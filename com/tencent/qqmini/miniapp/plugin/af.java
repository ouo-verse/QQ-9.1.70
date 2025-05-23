package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
@JsPlugin
/* loaded from: classes23.dex */
public class af extends ah {
    @JsEvent({"updateXWebCanvas", "operateXWebCanvas", "removeXWebCanvas"})
    public void handleXWebCanvasEvent(RequestEvent requestEvent) {
        EmbeddedWidgetClientFactory factory = getFactory(requestEvent);
        if (factory != null && factory.handleEmbeddedWidgetEvent(requestEvent.event, this.mMiniAppContext, requestEvent.jsonParams, requestEvent.callbackId, requestEvent.jsService)) {
            requestEvent.ok();
        } else {
            requestEvent.fail();
        }
    }

    @JsEvent({"insertXWebCanvas"})
    public void insertXWebCanvas(RequestEvent requestEvent) {
        EmbeddedWidgetClientFactory factory = getFactory(requestEvent);
        if (factory != null && factory.handleInsertEmbeddedWidgetEvent(requestEvent.event, this.mMiniAppContext, requestEvent.jsonParams, requestEvent.jsService)) {
            requestEvent.ok();
        } else {
            requestEvent.fail();
        }
    }

    @JsEvent({"xWebCanvasGetImageData", "xWebCanvasPutImageData", "xWebCanvasToTempFilePath"})
    public void invokeXWebCanvasMethod(RequestEvent requestEvent) {
        EmbeddedWidgetClientFactory factory = getFactory(requestEvent);
        if (factory == null || !factory.handleEmbeddedWidgetEvent(requestEvent.event, this.mMiniAppContext, requestEvent.jsonParams, requestEvent.callbackId, requestEvent.jsService)) {
            requestEvent.fail();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin
    public boolean onInterceptJsEvent(RequestEvent requestEvent) {
        QMLog.i("EmbeddedCanvasJsPlugin", requestEvent.event);
        return super.onInterceptJsEvent(requestEvent);
    }
}
