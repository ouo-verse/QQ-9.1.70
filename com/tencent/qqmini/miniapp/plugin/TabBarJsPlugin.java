package com.tencent.qqmini.miniapp.plugin;

import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.action.NativeViewRequestEvent;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;

@JsPlugin
/* loaded from: classes23.dex */
public class TabBarJsPlugin extends BaseJsPlugin {
    public static final String API_HIDE_TABBAR = "hideTabBar";
    public static final String API_HITD_RED_DOT = "hideTabBarRedDot";
    public static final String API_REMOVE_TABBAR_BADGE = "removeTabBarBadge";
    public static final String API_SET_TABBAR_BADGE = "setTabBarBadge";
    public static final String API_SET_TABBAR_ITEM = "setTabBarItem";
    public static final String API_SET_TABBAR_STYLE = "setTabBarStyle";
    public static final String API_SHOW_RED_DOT = "showTabBarRedDot";
    public static final String API_SHOW_TABBAR = "showTabBar";
    public static final String TAG = "TabBarJsPlugin";

    @JsEvent({"showTabBar", "hideTabBar", "setTabBarItem", "setTabBarStyle", "setTabBarBadge", API_REMOVE_TABBAR_BADGE, API_SHOW_RED_DOT, API_HITD_RED_DOT})
    public void doInterceptJsEvent(RequestEvent requestEvent) {
        this.mMiniAppContext.performAction(NativeViewRequestEvent.obtain(requestEvent, 0));
    }
}
