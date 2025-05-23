package com.tencent.qqmini.miniapp.plugin;

import android.R;
import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class VideoJsPlugin extends BaseJsPlugin implements VideoJsProxy.Bridge {
    public static final String API_CHOOSE_VIDEO = "chooseVideo";
    public static final String API_MAKE_MEDIA = "makeMedia";
    public static final String API_SAVE_VIDEO_TO_ALBUM = "saveVideoToPhotosAlbum";
    public static final String TAG = "VideoJsPlugin";
    private ConcurrentHashMap<Integer, RequestEvent> bridgeMap;
    private VideoJsProxy mImpl = (VideoJsProxy) ProxyManager.get(VideoJsProxy.class);
    private ToastView toastView;

    @JsEvent({"chooseVideo"})
    public void chooseVideo(RequestEvent requestEvent) {
        try {
            this.mImpl.chooseVideo(this.mMiniAppContext.getAttachedActivity(), requestEvent.event, requestEvent.jsonParams, requestEvent.callbackId);
        } catch (Throwable th5) {
            QMLog.e(TAG, requestEvent.event + " error,", th5);
            requestEvent.fail();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy.Bridge
    public void hideLoading() {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.VideoJsPlugin.3
            @Override // java.lang.Runnable
            public void run() {
                if (QMLog.isColorLevel()) {
                    QMLog.d(VideoJsPlugin.TAG, "hideToastView toastView=" + VideoJsPlugin.this.toastView);
                }
                if (VideoJsPlugin.this.toastView != null) {
                    VideoJsPlugin.this.toastView.hide();
                    VideoJsPlugin.this.toastView.onViewDestroy();
                    VideoJsPlugin.this.toastView = null;
                }
            }
        });
    }

    @JsEvent({"makeMedia"})
    public void makeMedia(RequestEvent requestEvent) {
        try {
            this.mImpl.makeMedia(this.mMiniAppContext.getAttachedActivity(), requestEvent.event, requestEvent.jsonParams, requestEvent.callbackId);
        } catch (Throwable th5) {
            QMLog.e(TAG, requestEvent.event + " error,", th5);
            requestEvent.fail();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
        this.mImpl.setResponseListener(this);
        this.bridgeMap = new ConcurrentHashMap<>();
        this.mImpl.create(iMiniAppContext);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onDestroy() {
        VideoJsProxy videoJsProxy = this.mImpl;
        if (videoJsProxy != null) {
            videoJsProxy.destroy();
        }
        ConcurrentHashMap<Integer, RequestEvent> concurrentHashMap = this.bridgeMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        super.onDestroy();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin
    public boolean onInterceptJsEvent(RequestEvent requestEvent) {
        QMLog.d(TAG, "onInterceptJsEvent event=" + requestEvent.event + ",jsonParams=" + requestEvent.jsonParams + ",callbackId=" + requestEvent.callbackId + ",webview=" + requestEvent.jsService);
        ConcurrentHashMap<Integer, RequestEvent> concurrentHashMap = this.bridgeMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(Integer.valueOf(requestEvent.callbackId), requestEvent);
        }
        return super.onInterceptJsEvent(requestEvent);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onPause() {
        super.onPause();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onResume() {
        super.onResume();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy.Bridge
    public void responseCancel(int i3, String str, JSONObject jSONObject) {
        RequestEvent requestEvent;
        ConcurrentHashMap<Integer, RequestEvent> concurrentHashMap = this.bridgeMap;
        if (concurrentHashMap != null && (requestEvent = concurrentHashMap.get(Integer.valueOf(i3))) != null) {
            requestEvent.cancel(jSONObject);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy.Bridge
    public void responseFail(int i3, String str, JSONObject jSONObject, String str2) {
        RequestEvent requestEvent;
        ConcurrentHashMap<Integer, RequestEvent> concurrentHashMap = this.bridgeMap;
        if (concurrentHashMap != null && (requestEvent = concurrentHashMap.get(Integer.valueOf(i3))) != null) {
            requestEvent.fail(str2);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy.Bridge
    public void responseOk(int i3, String str, JSONObject jSONObject) {
        RequestEvent requestEvent;
        ConcurrentHashMap<Integer, RequestEvent> concurrentHashMap = this.bridgeMap;
        if (concurrentHashMap != null && (requestEvent = concurrentHashMap.get(Integer.valueOf(i3))) != null) {
            requestEvent.ok(jSONObject);
        }
    }

    @JsEvent({"saveVideoToPhotosAlbum"})
    public void saveVideoToPhotosAlbum(RequestEvent requestEvent) {
        try {
            this.mImpl.saveVideoToPhotosAlbum(this.mMiniAppContext.getAttachedActivity(), requestEvent.event, requestEvent.jsonParams, requestEvent.callbackId);
        } catch (Throwable th5) {
            QMLog.e(TAG, requestEvent.event + " error,", th5);
            requestEvent.fail();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy.Bridge
    public void showLoading(final String str) {
        QMLog.i(TAG, "showLoading " + str);
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.VideoJsPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                Activity attachedActivity = ((BaseJsPlugin) VideoJsPlugin.this).mMiniAppContext.getAttachedActivity();
                if (attachedActivity != null && !attachedActivity.isFinishing()) {
                    if (VideoJsPlugin.this.toastView == null) {
                        VideoJsPlugin.this.toastView = new ToastView(attachedActivity, (ViewGroup) attachedActivity.findViewById(R.id.content));
                        VideoJsPlugin.this.toastView.show(1, ToastView.ICON_LOADING, null, str, -1, false);
                        return;
                    }
                    VideoJsPlugin.this.toastView.updateMsg(str);
                    return;
                }
                QMLog.w(VideoJsPlugin.TAG, "showLoading(). Do nothing, activity is null or finishing");
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.VideoJsProxy.Bridge
    public void updateLoading(final String str) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.VideoJsPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoJsPlugin.this.toastView == null) {
                    return;
                }
                if (QMLog.isColorLevel()) {
                    QMLog.d(VideoJsPlugin.TAG, "updateToastMsg toastView=" + VideoJsPlugin.this.toastView);
                }
                VideoJsPlugin.this.toastView.updateMsg(str);
            }
        });
    }
}
