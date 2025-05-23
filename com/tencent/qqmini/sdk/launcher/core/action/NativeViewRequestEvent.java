package com.tencent.qqmini.sdk.launcher.core.action;

import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class NativeViewRequestEvent extends RequestEvent implements Action<String> {
    public static final int DISPATCH_TO_BRAND_PAGE = 0;
    public static final int DISPATCH_TO_NATIVE_VIEW = 2;
    public static final int DISPATCH_TO_PAGE = 3;
    public static final int DISPATCH_TO_PAGE_WEBVIEW_CONTAINER = 1;
    public int dispatchTarget = 2;
    private IJsService mService;

    public static NativeViewRequestEvent obtain(RequestEvent requestEvent, int i3) {
        NativeViewRequestEvent nativeViewRequestEvent = new NativeViewRequestEvent();
        nativeViewRequestEvent.event = requestEvent.event;
        nativeViewRequestEvent.jsonParams = requestEvent.jsonParams;
        nativeViewRequestEvent.jsService = requestEvent.jsService;
        nativeViewRequestEvent.callbackId = requestEvent.callbackId;
        nativeViewRequestEvent.dispatchTarget = i3;
        nativeViewRequestEvent.webViewId = requestEvent.webViewId;
        return nativeViewRequestEvent;
    }

    public void sendSubscribeJs(String str, String str2, int i3) {
        IJsService iJsService = this.mService;
        if (iJsService != null) {
            iJsService.evaluateSubscribeJS(str, str2, i3);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
    public String perform(BaseRuntime baseRuntime) {
        QMLog.d(Action.TAG, "sendNativeViewEvent eventName = " + this.event + " jsService = " + this.jsService + " callbackId = " + this.callbackId + " target = " + this.dispatchTarget);
        this.mService = baseRuntime.getJsService();
        if (baseRuntime.isContainer()) {
            return baseRuntime.dispatchEventToNativeView(this);
        }
        IPage page = baseRuntime.getPage(this.webViewId);
        if (page == null) {
            ok();
            return "";
        }
        return page.dispatchEventToNativeView(this);
    }
}
