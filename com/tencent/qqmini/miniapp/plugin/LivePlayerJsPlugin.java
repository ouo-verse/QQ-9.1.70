package com.tencent.qqmini.miniapp.plugin;

import android.widget.FrameLayout;
import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.miniapp.util.EmbeddedHelper;
import com.tencent.qqmini.miniapp.widget.media.CoverLiveView;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.CoverView;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class LivePlayerJsPlugin extends BaseJsPlugin {
    private static final String EVENT_INSERT_LIVE_VIDEO_PLAYER = "insertLivePlayer";
    private static final String EVENT_OPERATE_LIVE_VIDEO_PLAYER = "operateLivePlayer";
    private static final String EVENT_REMOVE_LIVE_VIDEO_PLAYER = "removeLivePlayer";
    private static final String EVENT_UPDATE_LIVE_VIDEO_PLAYER = "updateLivePlayer";
    public static final String TAG = "LivePlayerJsPlugin";

    /* JADX INFO: Access modifiers changed from: private */
    public int getPageWebViewId() {
        return PageAction.obtain(this.mMiniAppContext).getPageId();
    }

    @JsEvent({"insertLivePlayer"})
    public void insertLivePlayer(final RequestEvent requestEvent) {
        QMLog.d(TAG, "JsEvent insertLivePlayer");
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final int optInt = jSONObject.optInt("livePlayerId");
            final JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("containerId", optInt);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.LivePlayerJsPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    int pageWebViewId;
                    CoverView coverView = CoverViewAction.obtain(((BaseJsPlugin) LivePlayerJsPlugin.this).mMiniAppContext, requestEvent.webViewId).get(optInt);
                    CoverView coverView2 = coverView;
                    if (coverView == null) {
                        CoverLiveView coverLiveView = new CoverLiveView(((BaseJsPlugin) LivePlayerJsPlugin.this).mContext);
                        coverLiveView.setAtyRef(new WeakReference<>(((BaseJsPlugin) LivePlayerJsPlugin.this).mMiniAppContext.getAttachActivity()));
                        coverLiveView.setData(jSONObject.optString("data"));
                        coverLiveView.setBaseRuntime((BaseRuntime) ((BaseJsPlugin) LivePlayerJsPlugin.this).mMiniAppContext);
                        if (!((BaseJsPlugin) LivePlayerJsPlugin.this).mIsContainer) {
                            pageWebViewId = LivePlayerJsPlugin.this.getPageWebViewId();
                        } else {
                            pageWebViewId = requestEvent.webViewId;
                        }
                        coverLiveView.setPageWebviewId(pageWebViewId);
                        coverLiveView.setLivePlayerId(optInt);
                        CoverViewAction.obtain(((BaseJsPlugin) LivePlayerJsPlugin.this).mMiniAppContext, requestEvent.webViewId).add(0, optInt, coverLiveView, false);
                        coverView2 = coverLiveView;
                    }
                    if (coverView2 instanceof CoverLiveView) {
                        CoverLiveView coverLiveView2 = (CoverLiveView) coverView2;
                        coverLiveView2.setMiniAppContext(((BaseJsPlugin) LivePlayerJsPlugin.this).mMiniAppContext);
                        coverLiveView2.initLivePlayerSettings(requestEvent, jSONObject);
                        JSONObject optJSONObject = jSONObject.optJSONObject("position");
                        float density = DisplayUtil.getDensity(((BaseJsPlugin) LivePlayerJsPlugin.this).mContext);
                        if (optJSONObject != null) {
                            int optInt2 = optJSONObject.optInt("left");
                            int optInt3 = optJSONObject.optInt("top");
                            int optInt4 = (int) ((optJSONObject.optInt("width") * density) + 0.5f);
                            int optInt5 = (int) ((optJSONObject.optInt("height") * density) + 0.5f);
                            int i3 = (int) ((optInt2 * density) + 0.5f);
                            int i16 = (int) ((density * optInt3) + 0.5f);
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optInt4, optInt5);
                            layoutParams.leftMargin = i3;
                            layoutParams.topMargin = i16;
                            coverLiveView2.setLayoutParams(layoutParams);
                        }
                        if (jSONObject.optBoolean("hide")) {
                            coverLiveView2.setVisibility(8);
                        }
                    }
                    requestEvent.ok(jSONObject2);
                }
            });
        } catch (JSONException e16) {
            QMLog.e(TAG, requestEvent.event + " error.", e16);
        }
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.IJsPlugin
    public boolean onInterceptJsEvent(RequestEvent requestEvent) {
        QMLog.d(TAG, requestEvent.event);
        if ("insertLivePlayer".equals(requestEvent.event)) {
            EmbeddedHelper.checkEmbeddedWidgetSupport(requestEvent, this.mMiniAppContext.getMiniAppInfo().appId, this.mMiniAppContext.getAttachActivity());
        }
        return super.onInterceptJsEvent(requestEvent);
    }

    @JsEvent({"operateLivePlayer"})
    public void operateLivePlayer(final RequestEvent requestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final String optString = jSONObject.optString("type");
            final int optInt = jSONObject.optInt("livePlayerId");
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.LivePlayerJsPlugin.4
                @Override // java.lang.Runnable
                public void run() {
                    CoverView coverView = CoverViewAction.obtain(((BaseJsPlugin) LivePlayerJsPlugin.this).mMiniAppContext, requestEvent.webViewId).get(optInt);
                    if (!(coverView instanceof CoverLiveView)) {
                        return;
                    }
                    ((CoverLiveView) coverView).operateLivePlayer(optString, requestEvent, jSONObject);
                }
            });
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @JsEvent({"removeLivePlayer"})
    public void removeLivePlayer(final RequestEvent requestEvent) {
        try {
            final int optInt = new JSONObject(requestEvent.jsonParams).optInt("livePlayerId");
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.LivePlayerJsPlugin.3
                @Override // java.lang.Runnable
                public void run() {
                    CoverViewAction.obtain(((BaseJsPlugin) LivePlayerJsPlugin.this).mMiniAppContext, requestEvent.webViewId).del(optInt);
                    requestEvent.ok();
                }
            });
        } catch (JSONException e16) {
            QMLog.e(TAG, requestEvent.event + " error.", e16);
        }
    }

    @JsEvent({"updateLivePlayer"})
    public void updateLivePlayer(final RequestEvent requestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final int optInt = jSONObject.optInt("livePlayerId");
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.LivePlayerJsPlugin.2
                @Override // java.lang.Runnable
                public void run() {
                    CoverView coverView = CoverViewAction.obtain(((BaseJsPlugin) LivePlayerJsPlugin.this).mMiniAppContext, requestEvent.webViewId).get(optInt);
                    if (!(coverView instanceof CoverLiveView)) {
                        return;
                    }
                    CoverLiveView coverLiveView = (CoverLiveView) coverView;
                    coverLiveView.updateLivePlayerSettings(jSONObject);
                    if (!coverLiveView.isFullScreen()) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("position");
                        if (optJSONObject == null) {
                            return;
                        }
                        float density = DisplayUtil.getDensity(((BaseJsPlugin) LivePlayerJsPlugin.this).mContext);
                        int optInt2 = optJSONObject.optInt("left");
                        int optInt3 = optJSONObject.optInt("top");
                        int optInt4 = (int) ((optJSONObject.optInt("width") * density) + 0.5f);
                        int optInt5 = (int) ((optJSONObject.optInt("height") * density) + 0.5f);
                        int i3 = (int) ((optInt2 * density) + 0.5f);
                        int i16 = (int) ((density * optInt3) + 0.5f);
                        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) coverLiveView.getLayoutParams();
                        layoutParams.width = optInt4;
                        layoutParams.height = optInt5;
                        layoutParams.leftMargin = i3;
                        layoutParams.topMargin = i16;
                        coverLiveView.setLayoutParams(layoutParams);
                    }
                    requestEvent.ok();
                }
            });
        } catch (JSONException e16) {
            QMLog.e(TAG, requestEvent.event + " error.", e16);
        }
    }
}
