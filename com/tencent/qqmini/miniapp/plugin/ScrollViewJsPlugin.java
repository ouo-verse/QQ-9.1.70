package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Color;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.miniapp.action.GetJsRuntimeListener;
import com.tencent.qqmini.miniapp.widget.CoverScrollView;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.CoverView;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
/* loaded from: classes23.dex */
public class ScrollViewJsPlugin extends BaseJsPlugin {
    private static final String EVENT_INSERT_SCROLLVIEW = "insertScrollView";
    private static final String EVENT_REMOVE_SCROLLVIEW = "removeScrollView";
    private static final String EVENT_UPDATE_SCROLLVIEW = "updateScrollView";
    private static final String TAG = "ScrollViewJsPlugin";
    protected float density;

    /* JADX INFO: Access modifiers changed from: private */
    public boolean insertScrollView(int i3, JSONObject jSONObject) {
        boolean z16;
        int optInt = jSONObject.optInt("viewId");
        int optInt2 = jSONObject.optInt("parentId");
        String optString = jSONObject.optString("data");
        boolean optBoolean = jSONObject.optBoolean("gesture");
        boolean optBoolean2 = jSONObject.optBoolean(QCircleDaTongConstant.ElementParamValue.FIXED, false);
        CoverView coverView = CoverViewAction.obtain(this.mMiniAppContext, i3).get(optInt);
        if (coverView == null) {
            coverView = new CoverScrollView(this.mContext);
            coverView.setData(optString, optBoolean, GetJsRuntimeListener.get(this.mMiniAppContext, i3));
            coverView.setContentDescription(optInt + "_" + optInt2);
            coverView.setParentId(optInt2);
            coverView.setFixed(optBoolean2);
            z16 = CoverViewAction.obtain(this.mMiniAppContext, i3).add(optInt2, optInt, coverView, optBoolean2);
        } else {
            z16 = true;
        }
        if (coverView instanceof CoverScrollView) {
            updateScrollView(jSONObject, (CoverScrollView) coverView);
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateScrollView(int i3, JSONObject jSONObject) {
        CoverView coverView = CoverViewAction.obtain(this.mMiniAppContext, i3).get(jSONObject.optInt("viewId"));
        if (!(coverView instanceof CoverScrollView)) {
            return false;
        }
        updateScrollView(jSONObject, (CoverScrollView) coverView);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
        this.density = DisplayUtil.getDensity(this.mContext);
    }

    @JsEvent({"insertScrollView"})
    public void setEventInsertScrollview(final RequestEvent requestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.ScrollViewJsPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ScrollViewJsPlugin.this.insertScrollView(requestEvent.webViewId, jSONObject)) {
                        requestEvent.ok();
                    } else {
                        requestEvent.fail();
                    }
                }
            });
        } catch (JSONException e16) {
            QMLog.e(TAG, requestEvent.event + " error.", e16);
        }
    }

    @JsEvent({"removeScrollView"})
    public void setEventRemoveScrollview(final RequestEvent requestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.ScrollViewJsPlugin.3
                @Override // java.lang.Runnable
                public void run() {
                    if (CoverViewAction.obtain(((BaseJsPlugin) ScrollViewJsPlugin.this).mMiniAppContext, requestEvent.webViewId).del(jSONObject.optInt("viewId"))) {
                        requestEvent.ok();
                    } else {
                        requestEvent.fail();
                    }
                }
            });
        } catch (JSONException e16) {
            QMLog.e(TAG, requestEvent.event + " error.", e16);
        }
    }

    @JsEvent({"updateScrollView"})
    public void setEventUpdateScrollview(final RequestEvent requestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.ScrollViewJsPlugin.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ScrollViewJsPlugin.this.updateScrollView(requestEvent.webViewId, jSONObject)) {
                        requestEvent.ok();
                    } else {
                        requestEvent.fail();
                    }
                }
            });
        } catch (JSONException e16) {
            QMLog.e(TAG, requestEvent.event + " error.", e16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void updateScrollView(JSONObject jSONObject, CoverScrollView coverScrollView) {
        JSONObject optJSONObject;
        int i3;
        int i16;
        JSONArray optJSONArray;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("style");
        if (optJSONObject2 != null) {
            if (optJSONObject2.has("bgColor")) {
                String actualColor = ColorUtils.getActualColor(optJSONObject2.optString("bgColor"));
                if (!TextUtils.isEmpty(actualColor)) {
                    try {
                        i3 = Color.parseColor(actualColor);
                    } catch (Exception e16) {
                        Log.w(TAG, "insertTextView: failed to parse color " + actualColor, e16);
                    }
                    if (optJSONObject2.has(NodeProps.BORDER_COLOR)) {
                        String actualColor2 = ColorUtils.getActualColor(optJSONObject2.optString(NodeProps.BORDER_COLOR));
                        if (!TextUtils.isEmpty(actualColor2)) {
                            i16 = Color.parseColor(actualColor2);
                            coverScrollView.setAlpha((float) optJSONObject2.optDouble("opacity", 0.0d));
                            coverScrollView.setBackgroundColor(i3);
                            coverScrollView.setScaleX((float) optJSONObject2.optDouble(BasicAnimation.KeyPath.SCALE_X, 1.0d));
                            coverScrollView.setScaleY((float) optJSONObject2.optDouble(BasicAnimation.KeyPath.SCALE_Y, 1.0d));
                            optJSONArray = optJSONObject2.optJSONArray("padding");
                            if (optJSONArray != null) {
                                coverScrollView.setPadding(optJSONArray.optInt(3), optJSONArray.optInt(2), optJSONArray.optInt(1), optJSONArray.optInt(0));
                            }
                            coverScrollView.setBorder(optJSONObject2.optInt(NodeProps.BORDER_WIDTH, 0), i16, (float) optJSONObject2.optDouble(NodeProps.BORDER_RADIUS, 0.0d), i3);
                            coverScrollView.setBorderRadius(((float) optJSONObject2.optDouble(NodeProps.BORDER_RADIUS, 0.0d)) * this.density);
                        }
                    }
                    i16 = 0;
                    coverScrollView.setAlpha((float) optJSONObject2.optDouble("opacity", 0.0d));
                    coverScrollView.setBackgroundColor(i3);
                    coverScrollView.setScaleX((float) optJSONObject2.optDouble(BasicAnimation.KeyPath.SCALE_X, 1.0d));
                    coverScrollView.setScaleY((float) optJSONObject2.optDouble(BasicAnimation.KeyPath.SCALE_Y, 1.0d));
                    optJSONArray = optJSONObject2.optJSONArray("padding");
                    if (optJSONArray != null) {
                    }
                    coverScrollView.setBorder(optJSONObject2.optInt(NodeProps.BORDER_WIDTH, 0), i16, (float) optJSONObject2.optDouble(NodeProps.BORDER_RADIUS, 0.0d), i3);
                    coverScrollView.setBorderRadius(((float) optJSONObject2.optDouble(NodeProps.BORDER_RADIUS, 0.0d)) * this.density);
                }
            }
            i3 = 0;
            if (optJSONObject2.has(NodeProps.BORDER_COLOR)) {
            }
            i16 = 0;
            coverScrollView.setAlpha((float) optJSONObject2.optDouble("opacity", 0.0d));
            coverScrollView.setBackgroundColor(i3);
            coverScrollView.setScaleX((float) optJSONObject2.optDouble(BasicAnimation.KeyPath.SCALE_X, 1.0d));
            coverScrollView.setScaleY((float) optJSONObject2.optDouble(BasicAnimation.KeyPath.SCALE_Y, 1.0d));
            optJSONArray = optJSONObject2.optJSONArray("padding");
            if (optJSONArray != null) {
            }
            coverScrollView.setBorder(optJSONObject2.optInt(NodeProps.BORDER_WIDTH, 0), i16, (float) optJSONObject2.optDouble(NodeProps.BORDER_RADIUS, 0.0d), i3);
            coverScrollView.setBorderRadius(((float) optJSONObject2.optDouble(NodeProps.BORDER_RADIUS, 0.0d)) * this.density);
        }
        coverScrollView.setClickable(jSONObject.optBoolean("clickable", false));
        coverScrollView.setHorizontalScrollBarEnabled(jSONObject.optBoolean("scrollX", false));
        coverScrollView.setVerticalScrollBarEnabled(jSONObject.optBoolean("scrollY", false));
        if (jSONObject.optJSONObject("position") != null) {
            int optInt = (int) ((this.density * r0.optInt("width")) + 0.5f);
            int optInt2 = (int) ((this.density * r0.optInt("height")) + 0.5f);
            int optInt3 = (int) ((this.density * r0.optInt("left")) + 0.5f);
            int optInt4 = (int) ((this.density * r0.optInt("top")) + 0.5f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optInt, optInt2);
            layoutParams.leftMargin = optInt3;
            layoutParams.topMargin = optInt4;
            coverScrollView.setLayoutParams(layoutParams);
        }
        if (jSONObject.has("contentSize") && (optJSONObject = jSONObject.optJSONObject("contentSize")) != null) {
            coverScrollView.setContainerSize((int) ((this.density * optJSONObject.optInt("width")) + 0.5f), (int) ((this.density * optJSONObject.optInt("height")) + 0.5f));
        }
        if (jSONObject.has("scrollTop")) {
            coverScrollView.setScrollTop((int) ((this.density * jSONObject.optInt("scrollTop", 0)) + 0.5f));
        }
    }
}
