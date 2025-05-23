package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.v1;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers.BaseJsSdkInfoHandler;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes22.dex */
public class JsSdkInfoHandler extends BaseJsSdkInfoHandler {
    public JsSdkInfoHandler(WeakReference<Object> weakReference) {
        super(weakReference);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers.BaseJsHandler
    protected DTConstants.JsCallbackPolicy callbackType() {
        return DTConstants.JsCallbackPolicy.JS_METHOND_CALLBACK;
    }
}
