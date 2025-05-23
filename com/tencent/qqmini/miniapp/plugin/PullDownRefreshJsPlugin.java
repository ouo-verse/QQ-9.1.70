package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;

@JsPlugin
/* loaded from: classes23.dex */
public class PullDownRefreshJsPlugin extends BaseJsPlugin {
    public static final String EVENT_DISABLE_SROLL_BOUNCE = "disableScrollBounce";
    public static final String EVENT_START_PULLDOWN_REFRESH = "startPullDownRefresh";
    public static final String EVENT_STOP_PULLDOWN_REFRESH = "stopPullDownRefresh";

    @JsEvent({"startPullDownRefresh", "stopPullDownRefresh", "disableScrollBounce"})
    public void doInterceptJsEvent(RequestEvent requestEvent) {
        this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(requestEvent, 1));
    }
}
