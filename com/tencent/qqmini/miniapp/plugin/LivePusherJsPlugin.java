package com.tencent.qqmini.miniapp.plugin;

import android.util.Log;
import android.widget.FrameLayout;
import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.miniapp.util.EmbeddedHelper;
import com.tencent.qqmini.miniapp.widget.media.CoverPusherView;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
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
public class LivePusherJsPlugin extends BaseJsPlugin {
    private static final String EVENT_INSERT_LIVE_PUSHER = "insertLivePusher";
    private static final String EVENT_OPERATE_LIVE_PUSHER = "operateLivePusher";
    private static final String EVENT_REMOVE_LIVE_PUSHER = "removeLivePusher";
    private static final String EVENT_UPDATE_LIVE_PUSHER = "updateLivePusher";
    public static final String TAG = "LivePusherJsPlugin";

    @JsEvent({"insertLivePusher"})
    public void insertLivePusher(final RequestEvent requestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final int optInt = jSONObject.optInt("livePusherId");
            final JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("containerId", optInt);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.LivePusherJsPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    int pageId;
                    Log.i(LivePusherJsPlugin.TAG, "insertLivePusher: " + jSONObject);
                    CoverView coverView = CoverViewAction.obtain(((BaseJsPlugin) LivePusherJsPlugin.this).mMiniAppContext, requestEvent.webViewId).get(optInt);
                    CoverView coverView2 = coverView;
                    if (coverView == null) {
                        CoverPusherView coverPusherView = new CoverPusherView(((BaseJsPlugin) LivePusherJsPlugin.this).mMiniAppContext);
                        coverPusherView.setAtyRef(new WeakReference<>(((BaseJsPlugin) LivePusherJsPlugin.this).mMiniAppContext.getAttachActivity()));
                        coverPusherView.setData(jSONObject.optString("data"));
                        if (((BaseJsPlugin) LivePusherJsPlugin.this).mIsContainer) {
                            pageId = requestEvent.webViewId;
                        } else {
                            pageId = PageAction.obtain(((BaseJsPlugin) LivePusherJsPlugin.this).mMiniAppContext).getPageId();
                        }
                        coverPusherView.setPageWebviewId(pageId);
                        coverPusherView.setLivePusherId(optInt);
                        CoverViewAction.obtain(((BaseJsPlugin) LivePusherJsPlugin.this).mMiniAppContext, requestEvent.webViewId).add(0, optInt, coverPusherView, false);
                        coverView2 = coverPusherView;
                    }
                    if (coverView2 instanceof CoverPusherView) {
                        CoverPusherView coverPusherView2 = (CoverPusherView) coverView2;
                        coverPusherView2.setMiniAppContext(((BaseJsPlugin) LivePusherJsPlugin.this).mMiniAppContext);
                        coverPusherView2.initLivePusherSettings(requestEvent, jSONObject);
                        JSONObject optJSONObject = jSONObject.optJSONObject("position");
                        float density = DisplayUtil.getDensity(((BaseJsPlugin) LivePusherJsPlugin.this).mContext);
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
                            coverPusherView2.setLayoutParams(layoutParams);
                        }
                        if (jSONObject.optBoolean("hide")) {
                            coverPusherView2.setVisibility(8);
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
        if ("insertLivePusher".equals(requestEvent.event)) {
            EmbeddedHelper.checkEmbeddedWidgetSupport(requestEvent, this.mMiniAppContext.getMiniAppInfo().appId, this.mMiniAppContext.getAttachActivity());
        }
        return super.onInterceptJsEvent(requestEvent);
    }

    @JsEvent({"operateLivePusher"})
    public void operateLivePusher(final RequestEvent requestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final String optString = jSONObject.optString("type");
            final int optInt = jSONObject.optInt("livePusherId");
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.LivePusherJsPlugin.4
                @Override // java.lang.Runnable
                public void run() {
                    CoverPusherView coverPusherView;
                    CoverView coverView = CoverViewAction.obtain(((BaseJsPlugin) LivePusherJsPlugin.this).mMiniAppContext, requestEvent.webViewId).get(optInt);
                    if ((coverView instanceof CoverPusherView) && (coverPusherView = (CoverPusherView) coverView) != null) {
                        coverPusherView.operateLivePusher(optString, requestEvent, jSONObject);
                    }
                }
            });
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
    }

    @JsEvent({"removeLivePusher"})
    public void removeLivePusher(final RequestEvent requestEvent) {
        try {
            final int optInt = new JSONObject(requestEvent.jsonParams).optInt("livePusherId");
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.LivePusherJsPlugin.3
                @Override // java.lang.Runnable
                public void run() {
                    CoverViewAction.obtain(((BaseJsPlugin) LivePusherJsPlugin.this).mMiniAppContext, requestEvent.webViewId).del(optInt);
                    requestEvent.ok();
                }
            });
        } catch (JSONException e16) {
            QMLog.e(TAG, requestEvent.event + " error.", e16);
        }
    }

    @JsEvent({"updateLivePusher"})
    public void updateLivePusher(final RequestEvent requestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final int optInt = jSONObject.optInt("livePusherId");
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.LivePusherJsPlugin.2
                @Override // java.lang.Runnable
                public void run() {
                    CoverView coverView = CoverViewAction.obtain(((BaseJsPlugin) LivePusherJsPlugin.this).mMiniAppContext, requestEvent.webViewId).get(optInt);
                    if (!(coverView instanceof CoverPusherView)) {
                        return;
                    }
                    CoverPusherView coverPusherView = (CoverPusherView) coverView;
                    if (coverPusherView != null) {
                        coverPusherView.updateLivePusherSettings(jSONObject);
                    }
                    JSONObject optJSONObject = jSONObject.optJSONObject("position");
                    if (optJSONObject == null) {
                        return;
                    }
                    float density = DisplayUtil.getDensity(((BaseJsPlugin) LivePusherJsPlugin.this).mContext);
                    int optInt2 = optJSONObject.optInt("left");
                    int optInt3 = optJSONObject.optInt("top");
                    int optInt4 = (int) ((optJSONObject.optInt("width") * density) + 0.5f);
                    int optInt5 = (int) ((optJSONObject.optInt("height") * density) + 0.5f);
                    int i3 = (int) ((optInt2 * density) + 0.5f);
                    int i16 = (int) ((density * optInt3) + 0.5f);
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) coverPusherView.getLayoutParams();
                    layoutParams.width = optInt4;
                    layoutParams.height = optInt5;
                    layoutParams.leftMargin = i3;
                    layoutParams.topMargin = i16;
                    coverPusherView.setLayoutParams(layoutParams);
                    requestEvent.ok();
                }
            });
        } catch (JSONException e16) {
            QMLog.e(TAG, requestEvent.event + " error.", e16);
        }
    }
}
