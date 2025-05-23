package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.v1;

import android.text.TextUtils;
import android.webkit.JavascriptInterface;

/* compiled from: P */
/* loaded from: classes22.dex */
public class BridgeInterface {
    public static final String JS_OBJECT_NAME = "DTJsBridgeInterface";
    private JsBridgeController mJsBridgeController;
    private Object mWebView;

    public BridgeInterface(Object obj) {
        this.mWebView = obj;
    }

    @JavascriptInterface
    public String bridgeCall(String str) {
        String shouldIntercept = JsBridgeController.getInstance().shouldIntercept(this.mWebView, str, "");
        if (TextUtils.isEmpty(shouldIntercept)) {
            return JsBridgeCall.getResponse(500, "");
        }
        return shouldIntercept;
    }
}
