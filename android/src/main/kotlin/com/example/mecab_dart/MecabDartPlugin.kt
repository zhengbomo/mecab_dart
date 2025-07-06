package com.example.mecab_dart

import androidx.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result

/** MecabDartPlugin */
public class MecabDartPlugin: FlutterPlugin, MethodCallHandler {
  private var methodChannel: MethodChannel? = null

  override fun onAttachedToEngine(binding: FlutterPluginBinding) {
      methodChannel = MethodChannel(binding.binaryMessenger, CHANNEL_NAME)
      methodChannel!!.setMethodCallHandler(this)
  }

  override fun onDetachedFromEngine(binding: FlutterPluginBinding) {
      methodChannel!!.setMethodCallHandler(null)
      methodChannel = null
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {
    if (call.method == "getPlatformVersion") {
      result.success("Android ${android.os.Build.VERSION.RELEASE}")
    } else {
      result.notImplemented()
    }
  }

  companion object {
    private const val CHANNEL_NAME = "mecab_dart"
  }
}
