package com.tencent.qqmini.sdk.plugins;

import android.R;
import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.widget.ToastView;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class MediaChooseJsPlugin extends BaseJsPlugin implements MediaChooseJsProxy.Bridge {
    public static final String API_CHOOSE_MEDIA = "chooseMedia";
    public static final String TAG = "MediaJsPlugin";
    private ConcurrentHashMap<Integer, RequestEvent> bridgeMap;
    private MediaChooseJsProxy mImpl = (MediaChooseJsProxy) ProxyManager.get(MediaChooseJsProxy.class);
    private ToastView toastView;

    @JsEvent({"chooseMedia"})
    public void chooseMedia(RequestEvent requestEvent) {
        try {
            this.mImpl.chooseMedia(this.mMiniAppContext.getAttachedActivity(), requestEvent.event, requestEvent.jsonParams, requestEvent.callbackId);
        } catch (Throwable th5) {
            QMLog.e("MediaJsPlugin", requestEvent.event + " error,", th5);
            requestEvent.fail();
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy.Bridge
    public void hideLoading() {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.MediaChooseJsPlugin.3
            @Override // java.lang.Runnable
            public void run() {
                if (QMLog.isColorLevel()) {
                    QMLog.d("MediaJsPlugin", "hideToastView toastView=" + MediaChooseJsPlugin.this.toastView);
                }
                if (MediaChooseJsPlugin.this.toastView != null) {
                    MediaChooseJsPlugin.this.toastView.hide();
                    MediaChooseJsPlugin.this.toastView = null;
                }
            }
        });
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
        MediaChooseJsProxy mediaChooseJsProxy = this.mImpl;
        if (mediaChooseJsProxy != null) {
            mediaChooseJsProxy.destroy();
        }
        ConcurrentHashMap<Integer, RequestEvent> concurrentHashMap = this.bridgeMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.clear();
        }
        super.onDestroy();
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin
    public boolean onInterceptJsEvent(RequestEvent requestEvent) {
        QMLog.d("MediaJsPlugin", "onInterceptJsEvent event=" + requestEvent.event + ",jsonParams=" + requestEvent.jsonParams + ",callbackId=" + requestEvent.callbackId + ",webview=" + requestEvent.jsService);
        ConcurrentHashMap<Integer, RequestEvent> concurrentHashMap = this.bridgeMap;
        if (concurrentHashMap != null) {
            concurrentHashMap.put(Integer.valueOf(requestEvent.callbackId), requestEvent);
        }
        return super.onInterceptJsEvent(requestEvent);
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy.Bridge
    public void responseCancel(int i3, String str, JSONObject jSONObject) {
        RequestEvent requestEvent;
        ConcurrentHashMap<Integer, RequestEvent> concurrentHashMap = this.bridgeMap;
        if (concurrentHashMap != null && (requestEvent = concurrentHashMap.get(Integer.valueOf(i3))) != null) {
            requestEvent.cancel(jSONObject);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy.Bridge
    public void responseFail(int i3, String str, JSONObject jSONObject, String str2) {
        RequestEvent requestEvent;
        ConcurrentHashMap<Integer, RequestEvent> concurrentHashMap = this.bridgeMap;
        if (concurrentHashMap != null && (requestEvent = concurrentHashMap.get(Integer.valueOf(i3))) != null) {
            requestEvent.fail(str2);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy.Bridge
    public void responseOk(int i3, String str, JSONObject jSONObject) {
        RequestEvent requestEvent;
        ConcurrentHashMap<Integer, RequestEvent> concurrentHashMap = this.bridgeMap;
        if (concurrentHashMap != null && (requestEvent = concurrentHashMap.get(Integer.valueOf(i3))) != null) {
            requestEvent.ok(jSONObject);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy.Bridge
    public void showLoading(final String str) {
        QMLog.i("MediaJsPlugin", "showLoading " + str);
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.MediaChooseJsPlugin.1
            @Override // java.lang.Runnable
            public void run() {
                Activity attachedActivity = ((BaseJsPlugin) MediaChooseJsPlugin.this).mMiniAppContext.getAttachedActivity();
                if (attachedActivity != null && !attachedActivity.isFinishing()) {
                    if (MediaChooseJsPlugin.this.toastView == null) {
                        MediaChooseJsPlugin.this.toastView = new ToastView(attachedActivity, (ViewGroup) attachedActivity.findViewById(R.id.content));
                        MediaChooseJsPlugin.this.toastView.show(1, ToastView.ICON_LOADING, null, str, -1, false);
                        return;
                    }
                    return;
                }
                QMLog.w("MediaJsPlugin", "showLoading(). Do nothing, activity is null or finishing");
            }
        });
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.proxy.MediaChooseJsProxy.Bridge
    public void updateLoading(final String str) {
        AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.sdk.plugins.MediaChooseJsPlugin.2
            @Override // java.lang.Runnable
            public void run() {
                if (MediaChooseJsPlugin.this.toastView == null) {
                    return;
                }
                if (QMLog.isColorLevel()) {
                    QMLog.d("MediaJsPlugin", "updateToastMsg toastView=" + MediaChooseJsPlugin.this.toastView);
                }
                MediaChooseJsPlugin.this.toastView.updateMsg(str);
            }
        });
    }
}
