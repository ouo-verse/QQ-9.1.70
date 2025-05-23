package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.container.core.MiniWebView;
import com.tencent.qqmini.container.core.ax;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ExternalElementProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

@JsPlugin
/* loaded from: classes23.dex */
public class ExternalElementJsPlugin extends BaseJsPlugin {
    public static final String TAG = "ExternalElementJsPlugin";

    private EmbeddedWidgetClientFactory getFactory(RequestEvent requestEvent) {
        if (this.mIsContainer) {
            IJsService iJsService = requestEvent.jsService;
            if (iJsService instanceof MiniWebView) {
                return ((MiniWebView) iJsService).K();
            }
            MiniWebView s16 = ((ax) this.mMiniAppContext).s(requestEvent.webViewId);
            if (s16 != null) {
                return s16.K();
            }
            return null;
        }
        return (EmbeddedWidgetClientFactory) this.mMiniAppContext.performAction(new Action() { // from class: com.tencent.qqmini.miniapp.plugin.ai
            @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
            public final Object perform(BaseRuntime baseRuntime) {
                EmbeddedWidgetClientFactory lambda$getFactory$0;
                lambda$getFactory$0 = ExternalElementJsPlugin.lambda$getFactory$0(baseRuntime);
                return lambda$getFactory$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ EmbeddedWidgetClientFactory lambda$getFactory$0(BaseRuntime baseRuntime) {
        IPage page = baseRuntime.getPage();
        if (!(page instanceof AppBrandPageContainer)) {
            QMLog.d(Action.TAG, "Page is invalid");
            return null;
        }
        return ((AppBrandPageContainer) page).getCurrentX5EmbeddedWidgetClientFactory();
    }

    @JsEvent({ExternalElementProxy.EVENT_INSERT_XWEB_EXTERNAL_ELEMENT})
    public void insertExternalElement(RequestEvent requestEvent) {
        EmbeddedWidgetClientFactory factory = getFactory(requestEvent);
        if (factory != null && factory.handleInsertEmbeddedWidgetEvent(requestEvent.event, this.mMiniAppContext, requestEvent.jsonParams, requestEvent.jsService)) {
            requestEvent.ok();
        } else {
            requestEvent.fail();
        }
    }

    @JsEvent({ExternalElementProxy.EVENT_OPERATE_XWEB_EXTERNAL_ELEMENT})
    public void operateExternalElement(RequestEvent requestEvent) {
        EmbeddedWidgetClientFactory factory = getFactory(requestEvent);
        if (factory != null && factory.handleEmbeddedWidgetEvent(requestEvent.event, this.mMiniAppContext, requestEvent.jsonParams, requestEvent.callbackId, requestEvent.jsService)) {
            requestEvent.ok();
        } else {
            requestEvent.fail();
        }
    }

    @JsEvent({ExternalElementProxy.EVENT_REMOVE_XWEB_EXTERNAL_ELEMENT})
    public void removeExternalElement(RequestEvent requestEvent) {
        EmbeddedWidgetClientFactory factory = getFactory(requestEvent);
        if (factory != null && factory.handleEmbeddedWidgetEvent(requestEvent.event, this.mMiniAppContext, requestEvent.jsonParams, requestEvent.callbackId, requestEvent.jsService)) {
            requestEvent.ok();
        } else {
            requestEvent.fail();
        }
    }

    @JsEvent({ExternalElementProxy.EVENT_UPDATE_XWEB_EXTERNAL_ELEMENT})
    public void updateExternalElement(RequestEvent requestEvent) {
        EmbeddedWidgetClientFactory factory = getFactory(requestEvent);
        if (factory != null && factory.handleEmbeddedWidgetEvent(requestEvent.event, this.mMiniAppContext, requestEvent.jsonParams, requestEvent.callbackId, requestEvent.jsService)) {
            requestEvent.ok();
        } else {
            requestEvent.fail();
        }
    }
}
