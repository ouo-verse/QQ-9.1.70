package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;

@JsPlugin
/* loaded from: classes23.dex */
public class NavigationBarPlugin extends BaseJsPlugin {
    public static final String HIDE_NAVBAR_HOME_BUTTON = "hideNavigationBarHomeButton";
    public static final String HIDE_NAVBAR_LOADING = "hideNavigationBarLoading";
    public static final String SET_NAV_BAR_BG_COLOR = "setNavigationBarColor";
    public static final String SET_NAV_BAR_TITLE = "setNavigationBarTitle";
    public static final String SHOW_NAVBAR_LOADING = "showNavigationBarLoading";

    @JsEvent({"setNavigationBarTitle", "showNavigationBarLoading", "hideNavigationBarLoading", "setNavigationBarColor", HIDE_NAVBAR_HOME_BUTTON})
    public void doInterceptJsEvent(RequestEvent requestEvent) {
        this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(requestEvent, 0));
    }
}
