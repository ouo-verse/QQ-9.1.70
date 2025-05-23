package com.tencent.qqmini.miniapp.plugin;

import android.app.Activity;
import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.IPage;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class EmbeddedLivePusherJsPlugin extends ah {
    public static final String EVENT_HIDE_NAVIGATIONBAR = "hideVirtualBottomNavigationBar";
    public static final String EVENT_INSERT_XWEB_LIVE_PUSHER = "insertXWebLivePusher";
    public static final String EVENT_ON_XWEB_LIVE_PUSHER_BGM_COMPLETE = "onXWebLivePusherBGMComplete";
    public static final String EVENT_ON_XWEB_LIVE_PUSHER_BGM_PROGRESS = "onXWebLivePusherBGMProgress";
    public static final String EVENT_ON_XWEB_LIVE_PUSHER_BGM_START = "onXWebLivePusherBGMStart";
    public static final String EVENT_ON_XWEB_LIVE_PUSHER_ERR = "onXWebLivePusherError";
    public static final String EVENT_ON_XWEB_LIVE_PUSHER_EVENT = "onXWebLivePusherEvent";
    public static final String EVENT_ON_XWEB_LIVE_PUSHER_NET_STATUS = "onXWebLivePusherNetStatus";
    public static final String EVENT_OPERATE_XWEB_LIVE_PUSHER = "operateXWebLivePusher";
    public static final String EVENT_REMOVE_XWEB_LIVE_PUSHER = "removeXWebLivePusher";
    public static final String EVENT_SET_DISPLAY_ORIENTATION = "setDisplayOrientation";
    public static final String EVENT_SHOW_NAVIGATIONBAR = "showVirtualBottomNavigationBar";
    public static final String EVENT_UPDATE_XWEB_LIVE_PUSHER = "updateXWebLivePusher";
    public static final String TAG = "EmbeddedLivePusherJsPlugin";
    private int lastNavBarVisibility = 8;
    private int lastTabBarVisibility = 8;

    /* JADX INFO: Access modifiers changed from: private */
    public void enterFullScreenMode(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            activity.getWindow().getDecorView().getSystemUiVisibility();
            activity.getWindow().getDecorView().setSystemUiVisibility(5894 | 2048);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void enterSmallScreenMode() {
        Activity attachActivity = this.mMiniAppContext.getAttachActivity();
        final WeakReference weakReference = new WeakReference(attachActivity);
        if (attachActivity != null) {
            try {
                if (!attachActivity.isFinishing()) {
                    attachActivity.getWindow().getDecorView().setSystemUiVisibility(1024);
                    this.mMiniAppContext.performAction(new Action<Void>() { // from class: com.tencent.qqmini.miniapp.plugin.EmbeddedLivePusherJsPlugin.4
                        @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
                        public Void perform(BaseRuntime baseRuntime) {
                            IPage page = baseRuntime.getPage();
                            if (!(page instanceof AppBrandPageContainer)) {
                                QMLog.d(Action.TAG, "Page is invalid");
                                return null;
                            }
                            AppBrandPage showingPage = ((AppBrandPageContainer) page).getShowingPage();
                            if (showingPage != null) {
                                int statusNavigationBarTextStyle = showingPage.getNavBar().getStatusNavigationBarTextStyle();
                                if (statusNavigationBarTextStyle == -1) {
                                    if (weakReference.get() != null) {
                                        ImmersiveUtils.setStatusTextColor(false, ((Activity) weakReference.get()).getWindow());
                                    }
                                } else if (statusNavigationBarTextStyle == -16777216 && weakReference.get() != null) {
                                    ImmersiveUtils.setStatusTextColor(true, ((Activity) weakReference.get()).getWindow());
                                }
                            }
                            return null;
                        }
                    });
                }
            } catch (Exception e16) {
                QMLog.e(TAG, "smallScreen: ", e16);
            }
        }
    }

    @JsEvent({"hideVirtualBottomNavigationBar"})
    public void hideNavigationBar(final RequestEvent requestEvent) {
        this.mMiniAppContext.performAction(new Action<Void>() { // from class: com.tencent.qqmini.miniapp.plugin.EmbeddedLivePusherJsPlugin.3
            @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
            public Void perform(BaseRuntime baseRuntime) {
                IPage page = baseRuntime.getPage();
                if (!(page instanceof AppBrandPageContainer)) {
                    QMLog.d(Action.TAG, "Page is invalid");
                    return null;
                }
                final AppBrandPage showingPage = ((AppBrandPageContainer) page).getShowingPage();
                if (showingPage != null) {
                    AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.EmbeddedLivePusherJsPlugin.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            EmbeddedLivePusherJsPlugin.this.lastNavBarVisibility = showingPage.getNavBar().getVisibility();
                            showingPage.getNavBar().setVisibility(8);
                            EmbeddedLivePusherJsPlugin.this.lastTabBarVisibility = showingPage.getTabBar().getVisibility();
                            showingPage.getTabBar().setVisibility(8);
                            EmbeddedLivePusherJsPlugin embeddedLivePusherJsPlugin = EmbeddedLivePusherJsPlugin.this;
                            embeddedLivePusherJsPlugin.enterFullScreenMode(((BaseJsPlugin) embeddedLivePusherJsPlugin).mMiniAppContext.getAttachActivity());
                            requestEvent.ok();
                        }
                    });
                } else {
                    requestEvent.fail();
                }
                return null;
            }
        });
    }

    @JsEvent({"insertXWebLivePusher"})
    public void insertXWebLivePusher(RequestEvent requestEvent) {
        EmbeddedWidgetClientFactory factory = getFactory(requestEvent);
        if (factory != null && factory.handleInsertEmbeddedWidgetEvent(requestEvent.event, this.mMiniAppContext, requestEvent.jsonParams, requestEvent.jsService)) {
            requestEvent.ok();
        } else {
            requestEvent.fail();
        }
    }

    @JsEvent({"operateXWebLivePusher"})
    public void operateXWebLivePusher(RequestEvent requestEvent) {
        EmbeddedWidgetClientFactory factory = getFactory(requestEvent);
        if (factory != null && factory.handleEmbeddedWidgetEvent(requestEvent.event, this.mMiniAppContext, requestEvent.jsonParams, requestEvent.callbackId, requestEvent.jsService)) {
            requestEvent.ok();
        } else {
            requestEvent.fail();
        }
    }

    @JsEvent({"removeXWebLivePusher"})
    public void removeXWebLivePusher(RequestEvent requestEvent) {
        EmbeddedWidgetClientFactory factory = getFactory(requestEvent);
        if (factory != null && factory.handleEmbeddedWidgetEvent(requestEvent.event, this.mMiniAppContext, requestEvent.jsonParams, requestEvent.callbackId, requestEvent.jsService)) {
            requestEvent.ok();
        } else {
            requestEvent.fail();
        }
    }

    @JsEvent({"setDisplayOrientation"})
    public void setDisplayOrientation(RequestEvent requestEvent) {
        try {
            int i3 = 0;
            int optInt = new JSONObject(requestEvent.jsonParams).optInt("orientation", 0);
            if (optInt != 90) {
                if (optInt == -90) {
                    i3 = 8;
                } else {
                    i3 = 1;
                }
            }
            if (i3 != this.mMiniAppContext.getAttachActivity().getRequestedOrientation()) {
                QMLog.i(TAG, "EVENT_SET_DISPLAY_ORIENTATION, setRequestedOrientation: " + optInt);
                this.mMiniAppContext.getAttachActivity().setRequestedOrientation(i3);
            }
            requestEvent.ok();
        } catch (Throwable unused) {
            requestEvent.fail();
        }
    }

    @JsEvent({"showVirtualBottomNavigationBar"})
    public void showNavigationBar(final RequestEvent requestEvent) {
        this.mMiniAppContext.performAction(new Action<Void>() { // from class: com.tencent.qqmini.miniapp.plugin.EmbeddedLivePusherJsPlugin.2
            @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
            public Void perform(BaseRuntime baseRuntime) {
                IPage page = baseRuntime.getPage();
                if (!(page instanceof AppBrandPageContainer)) {
                    QMLog.d(Action.TAG, "Page is invalid");
                    return null;
                }
                final AppBrandPage showingPage = ((AppBrandPageContainer) page).getShowingPage();
                if (showingPage != null) {
                    AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.EmbeddedLivePusherJsPlugin.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            showingPage.getNavBar().setVisibility(EmbeddedLivePusherJsPlugin.this.lastNavBarVisibility);
                            showingPage.getTabBar().setVisibility(EmbeddedLivePusherJsPlugin.this.lastTabBarVisibility);
                            EmbeddedLivePusherJsPlugin.this.enterSmallScreenMode();
                            requestEvent.ok();
                        }
                    });
                } else {
                    requestEvent.fail();
                }
                return null;
            }
        });
    }

    @JsEvent({"updateXWebLivePusher"})
    public void updateXWebLivePusher(RequestEvent requestEvent) {
        EmbeddedWidgetClientFactory factory = getFactory(requestEvent);
        if (factory != null && factory.handleEmbeddedWidgetEvent(requestEvent.event, this.mMiniAppContext, requestEvent.jsonParams, requestEvent.callbackId, requestEvent.jsService)) {
            requestEvent.ok();
        } else {
            requestEvent.fail();
        }
    }
}
