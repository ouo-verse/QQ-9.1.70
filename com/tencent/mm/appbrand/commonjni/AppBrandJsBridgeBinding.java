package com.tencent.mm.appbrand.commonjni;

import android.webkit.ValueCallback;
import androidx.annotation.Keep;
import kotlin.Pair;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class AppBrandJsBridgeBinding {
    private ValueCallback<Pair<String, String>> callback;
    private long mJsRuntimeInst = 0;

    private native long nativeCreateRuntime(long j3, long j16, String str, boolean z16);

    private native void nativeDestroyRuntime(long j3);

    private native void nativeInvokeCallbackHandler(long j3, int i3, String str, String str2);

    private native void nativeSubscribeHandler(long j3, String str, String str2, int i3, String str3);

    public void createRuntime(long j3, long j16) {
        this.mJsRuntimeInst = nativeCreateRuntime(j3, j16, "WeixinJSCoreAndroid", false);
    }

    public void destroyRuntime() {
        nativeDestroyRuntime(this.mJsRuntimeInst);
    }

    public void invokeCallbackHandler(int i3, String str) {
        invokeCallbackHandler(i3, str, "");
    }

    @Keep
    public void onJsException(String str, String str2) {
        ValueCallback<Pair<String, String>> valueCallback = this.callback;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(new Pair<>(str, str2));
        }
    }

    public void setJsExceptionCallback(ValueCallback<Pair<String, String>> valueCallback) {
        this.callback = valueCallback;
    }

    public void subscribeHandler(String str, String str2, int i3, String str3) {
        nativeSubscribeHandler(this.mJsRuntimeInst, str, str2, i3, str3);
    }

    public void createRuntime(long j3, long j16, String str, boolean z16) {
        this.mJsRuntimeInst = nativeCreateRuntime(j3, j16, str, z16);
    }

    public void invokeCallbackHandler(int i3, String str, String str2) {
        nativeInvokeCallbackHandler(this.mJsRuntimeInst, i3, str, str2);
    }
}
