package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.v2;

import android.webkit.JavascriptInterface;

/* compiled from: P */
/* loaded from: classes22.dex */
public class JsBridgeInterfaceV2 {
    public static final String JS_OBJECT_NAME = "dtBridge";
    private final JsBridgeControllerV2 mJsBridgeControllerV2;

    public JsBridgeInterfaceV2(Object obj) {
        this.mJsBridgeControllerV2 = new JsBridgeControllerV2(obj);
    }

    @JavascriptInterface
    public String postMessage(String str) {
        return this.mJsBridgeControllerV2.postMessage(str);
    }
}
