package com.tencent.qqmini.miniapp.plugin;

import android.app.Activity;
import android.media.AudioManager;
import android.util.Log;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
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
public class EmbeddedVideoJsPlugin extends ah {
    public static final String EVENT_GET_VOLUME = "getVolume";
    public static final String EVENT_HIDE_NAVIGATIONBAR = "hideVirtualBottomNavigationBar";
    public static final String EVENT_INSERT_XWEB_VIDEO = "insertXWebVideo";
    public static final String EVENT_OPERATE_XWEB_VIDEO = "operateXWebVideo";
    public static final String EVENT_REMOVE_XWEB_VIDEO = "removeXWebVideo";
    public static final String EVENT_SET_DISPLAY_ORIENTATION = "setDisplayOrientation";
    public static final String EVENT_SET_VOLUME = "setVolume";
    public static final String EVENT_SHOW_NAVIGATIONBAR = "showVirtualBottomNavigationBar";
    public static final String EVENT_UPDATE_XWEB_VIDEO = "updateXWebVideo";
    public static final String TAG = "EmbeddedVideoJsPlugin";
    public static final String VIDEO_EVENT_END = "onXWebVideoEnded";
    public static final String VIDEO_EVENT_EXIT_FULLSCREEN = "onXWebVideoExitFullscreen";
    public static final String VIDEO_EVENT_LOADED_METADATA = "onXWebVideoLoadedMetaData";
    public static final String VIDEO_EVENT_PAUSE = "onXWebVideoPause";
    public static final String VIDEO_EVENT_PLAY = "onXWebVideoPlay";
    public static final String VIDEO_EVENT_PROGRESS = "onXWebVideoProgress";
    public static final String VIDEO_EVENT_TIME_UPDATE = "onXWebVideoTimeUpdate";
    public static final String VIDEO_EVENT_WAITING = "onXWebVideoWaiting";
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
                    this.mMiniAppContext.performAction(new Action<Void>() { // from class: com.tencent.qqmini.miniapp.plugin.EmbeddedVideoJsPlugin.3
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

    @JsEvent({"getVolume"})
    public void getVolume(RequestEvent requestEvent) {
        try {
            AudioManager audioManager = (AudioManager) this.mMiniAppContext.getContext().getSystemService("audio");
            if (audioManager != null) {
                int streamVolume = SystemMethodProxy.getStreamVolume(audioManager, 3);
                int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("currentVolume", streamVolume);
                jSONObject.put("maxVolume", streamMaxVolume);
                requestEvent.ok(jSONObject);
            } else {
                requestEvent.fail("AudioManager error");
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, requestEvent.event + " error.", th5);
            requestEvent.fail();
        }
    }

    @JsEvent({"hideVirtualBottomNavigationBar"})
    public void hideNavigationBar(final RequestEvent requestEvent) {
        this.mMiniAppContext.performAction(new Action<Void>() { // from class: com.tencent.qqmini.miniapp.plugin.EmbeddedVideoJsPlugin.1
            @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
            public Void perform(BaseRuntime baseRuntime) {
                IPage page = baseRuntime.getPage();
                if (!(page instanceof AppBrandPageContainer)) {
                    QMLog.d(Action.TAG, "Page is invalid");
                    return null;
                }
                final AppBrandPage showingPage = ((AppBrandPageContainer) page).getShowingPage();
                if (showingPage != null) {
                    AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.EmbeddedVideoJsPlugin.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            EmbeddedVideoJsPlugin.this.lastNavBarVisibility = showingPage.getNavBar().getVisibility();
                            showingPage.getNavBar().setVisibility(8);
                            EmbeddedVideoJsPlugin.this.lastTabBarVisibility = showingPage.getTabBar().getVisibility();
                            showingPage.getTabBar().setVisibility(8);
                            EmbeddedVideoJsPlugin embeddedVideoJsPlugin = EmbeddedVideoJsPlugin.this;
                            embeddedVideoJsPlugin.enterFullScreenMode(((BaseJsPlugin) embeddedVideoJsPlugin).mMiniAppContext.getAttachActivity());
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

    @JsEvent({"insertXWebVideo"})
    public void insertXwebVideo(RequestEvent requestEvent) {
        EmbeddedWidgetClientFactory factory = getFactory(requestEvent);
        if (factory != null && factory.handleInsertEmbeddedWidgetEvent(requestEvent.event, this.mMiniAppContext, requestEvent.jsonParams, requestEvent.jsService)) {
            requestEvent.ok();
        } else {
            requestEvent.fail();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin
    public boolean onInterceptJsEvent(RequestEvent requestEvent) {
        QMLog.i(TAG, requestEvent.event);
        return super.onInterceptJsEvent(requestEvent);
    }

    @JsEvent({"operateXWebVideo"})
    public void operateXwebVideo(RequestEvent requestEvent) {
        EmbeddedWidgetClientFactory factory = getFactory(requestEvent);
        if (factory != null && factory.handleEmbeddedWidgetEvent(requestEvent.event, this.mMiniAppContext, requestEvent.jsonParams, requestEvent.callbackId, requestEvent.jsService)) {
            requestEvent.ok();
        } else {
            requestEvent.fail();
        }
    }

    @JsEvent({"removeXWebVideo"})
    public void removeXWebVideo(RequestEvent requestEvent) {
        requestEvent.ok();
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
                Log.i(TAG, "EVENT_SET_DISPLAY_ORIENTATION, setRequestedOrientation: " + optInt);
                this.mMiniAppContext.getAttachActivity().setRequestedOrientation(i3);
            }
            requestEvent.ok();
        } catch (Throwable unused) {
            requestEvent.fail();
        }
    }

    @JsEvent({"setVolume"})
    public void setVolume(RequestEvent requestEvent) {
        try {
            int optInt = new JSONObject(requestEvent.jsonParams).optInt("value");
            AudioManager audioManager = (AudioManager) this.mMiniAppContext.getContext().getSystemService("audio");
            if (audioManager != null) {
                if (optInt <= audioManager.getStreamMaxVolume(3) && optInt >= 0) {
                    audioManager.setStreamVolume(3, optInt, 4);
                    requestEvent.ok();
                } else {
                    requestEvent.fail("value error");
                }
            } else {
                requestEvent.fail("AudioManager error");
            }
        } catch (Throwable th5) {
            QMLog.e(TAG, requestEvent.event + " error.", th5);
            requestEvent.fail();
        }
    }

    @JsEvent({"showVirtualBottomNavigationBar"})
    public void showNavigationBar(final RequestEvent requestEvent) {
        this.mMiniAppContext.performAction(new Action<Void>() { // from class: com.tencent.qqmini.miniapp.plugin.EmbeddedVideoJsPlugin.2
            @Override // com.tencent.qqmini.sdk.launcher.core.action.Action
            public Void perform(BaseRuntime baseRuntime) {
                IPage page = baseRuntime.getPage();
                if (!(page instanceof AppBrandPageContainer)) {
                    QMLog.d(Action.TAG, "Page is invalid");
                    return null;
                }
                final AppBrandPage showingPage = ((AppBrandPageContainer) page).getShowingPage();
                if (showingPage != null) {
                    AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.EmbeddedVideoJsPlugin.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            showingPage.getNavBar().setVisibility(EmbeddedVideoJsPlugin.this.lastNavBarVisibility);
                            showingPage.getTabBar().setVisibility(EmbeddedVideoJsPlugin.this.lastTabBarVisibility);
                            EmbeddedVideoJsPlugin.this.enterSmallScreenMode();
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

    @JsEvent({"updateXWebVideo"})
    public void updateXwebVideo(RequestEvent requestEvent) {
        EmbeddedWidgetClientFactory factory = getFactory(requestEvent);
        if (factory != null && factory.handleEmbeddedWidgetEvent(requestEvent.event, this.mMiniAppContext, requestEvent.jsonParams, requestEvent.callbackId, requestEvent.jsService)) {
            requestEvent.ok();
        } else {
            requestEvent.fail();
        }
    }
}
