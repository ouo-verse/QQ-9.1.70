package com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.v2;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers.BaseJsReportHandler;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes22.dex */
public class JsReportHandlerV2 extends BaseJsReportHandler {
    public JsReportHandlerV2(WeakReference<Object> weakReference) {
        super(weakReference);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.webview.jsbridge.jsinterface.handlers.BaseJsHandler
    protected DTConstants.JsCallbackPolicy callbackType() {
        return DTConstants.JsCallbackPolicy.JS_WINDOWS_CALLBACK;
    }
}
