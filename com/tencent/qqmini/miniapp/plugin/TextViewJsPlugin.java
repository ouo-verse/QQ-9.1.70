package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.miniapp.action.GetJsRuntimeListener;
import com.tencent.qqmini.miniapp.widget.CoverTextView;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
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
public class TextViewJsPlugin extends BaseJsPlugin {
    private static final String EVENT_INSERT_TEXTVIEW = "insertTextView";
    private static final String EVENT_REMOVE_TEXTVIEW = "removeTextView";
    private static final String EVENT_UPDATE_TEXTVIEW = "updateTextView";
    private static final String TAG = "TextViewJsPlugin";
    protected float density;
    private boolean needSetPadding = WnsConfig.getConfig("qqminiapp", WnsConfig.SECONDARY_MINI_APP_COVER_TEXTVIEW_PADDING, true);

    /* JADX INFO: Access modifiers changed from: private */
    public boolean insertTextView(int i3, JSONObject jSONObject) {
        boolean z16;
        int optInt = jSONObject.optInt("viewId");
        int optInt2 = jSONObject.optInt("parentId");
        String optString = jSONObject.optString("data");
        boolean optBoolean = jSONObject.optBoolean("gesture");
        boolean optBoolean2 = jSONObject.optBoolean(QCircleDaTongConstant.ElementParamValue.FIXED, false);
        CoverView coverView = CoverViewAction.obtain(this.mMiniAppContext, i3).get(optInt);
        if (coverView == null) {
            coverView = new CoverTextView(this.mContext);
            coverView.setData(optString, optBoolean, GetJsRuntimeListener.get(this.mMiniAppContext, i3));
            coverView.setContentDescription(optInt + "_" + optInt2);
            coverView.setParentId(optInt2);
            coverView.setFixed(optBoolean2);
            z16 = CoverViewAction.obtain(this.mMiniAppContext, i3).add(optInt2, optInt, coverView, optBoolean2);
        } else {
            z16 = true;
        }
        if (coverView instanceof CoverTextView) {
            updateTextView((CoverTextView) coverView, jSONObject);
        }
        return z16;
    }

    private void setEllipsize(CoverTextView coverTextView, JSONObject jSONObject) {
        if ("ellipsis".equals(jSONObject.optString("lineBreak", "clip"))) {
            coverTextView.setEllipsize(TextUtils.TruncateAt.END);
        } else {
            coverTextView.setEllipsize(null);
        }
    }

    private void setGravity(CoverTextView coverTextView, JSONObject jSONObject) {
        String optString = jSONObject.optString("textAlign");
        if ("left".equals(optString)) {
            coverTextView.setGravity(3);
        } else if ("center".equals(optString)) {
            coverTextView.setGravity(17);
        } else if ("right".equals(optString)) {
            coverTextView.setGravity(5);
        }
    }

    private void setPadding(CoverTextView coverTextView, JSONObject jSONObject) {
        int dip2px;
        int optInt = jSONObject.optInt(NodeProps.LINE_HEIGHT, 0);
        if (optInt > 0 && (dip2px = DisplayUtil.dip2px(this.mContext, optInt) - coverTextView.getTextView().getLineHeight()) != 0) {
            float f16 = dip2px;
            coverTextView.setLineSpacing(f16, 1.0f);
            if (this.needSetPadding && Build.MANUFACTURER.equals(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI) && dip2px < 0) {
                coverTextView.getTextView().setPadding(0, (int) (f16 / DisplayUtil.getDensity(this.mContext)), 0, 0);
            }
        }
    }

    private void setPosition(CoverTextView coverTextView, JSONObject jSONObject) {
        if (jSONObject.optJSONObject("position") != null) {
            int optInt = (int) ((this.density * r8.optInt("width")) + 0.5f);
            int optInt2 = (int) ((this.density * r8.optInt("height")) + 0.5f);
            int optInt3 = (int) ((this.density * r8.optInt("left")) + 0.5f);
            int optInt4 = (int) ((this.density * r8.optInt("top")) + 0.5f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optInt, optInt2);
            layoutParams.leftMargin = optInt3;
            layoutParams.topMargin = optInt4;
            coverTextView.setLayoutParams(layoutParams);
        }
    }

    private void setSingleLine(CoverTextView coverTextView, JSONObject jSONObject) {
        if ("nowrap".equals(jSONObject.optString("whiteSpace", "nowrap"))) {
            coverTextView.setSingleLine(true);
        } else {
            coverTextView.setSingleLine(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void setStyle(CoverTextView coverTextView, JSONObject jSONObject) {
        int i3;
        int i16;
        JSONArray optJSONArray;
        JSONObject optJSONObject = jSONObject.optJSONObject("style");
        if (optJSONObject != null) {
            if (optJSONObject.has("bgColor")) {
                String actualColor = ColorUtils.getActualColor(optJSONObject.optString("bgColor"));
                if (!TextUtils.isEmpty(actualColor)) {
                    i3 = Color.parseColor(actualColor);
                    if (optJSONObject.has(NodeProps.BORDER_COLOR)) {
                        String actualColor2 = ColorUtils.getActualColor(optJSONObject.optString(NodeProps.BORDER_COLOR));
                        if (!TextUtils.isEmpty(actualColor2)) {
                            i16 = Color.parseColor(actualColor2);
                            coverTextView.setAlpha((float) optJSONObject.optDouble("opacity", 0.0d));
                            coverTextView.setBackgroundColor(i3);
                            coverTextView.setScaleX((float) optJSONObject.optDouble(BasicAnimation.KeyPath.SCALE_X, 1.0d));
                            coverTextView.setScaleY((float) optJSONObject.optDouble(BasicAnimation.KeyPath.SCALE_Y, 1.0d));
                            optJSONArray = optJSONObject.optJSONArray("padding");
                            if (optJSONArray != null) {
                                coverTextView.setPadding(optJSONArray.optInt(3), optJSONArray.optInt(0), optJSONArray.optInt(1), optJSONArray.optInt(2));
                            }
                            coverTextView.setBorder(optJSONObject.optInt(NodeProps.BORDER_WIDTH, 0), i16, (float) optJSONObject.optDouble(NodeProps.BORDER_RADIUS, 0.0d), i3);
                            coverTextView.setAlpha((float) optJSONObject.optDouble("opacity", 0.0d));
                            coverTextView.setBorderRadius(((float) optJSONObject.optDouble(NodeProps.BORDER_RADIUS, 0.0d)) * this.density);
                        }
                    }
                    i16 = 0;
                    coverTextView.setAlpha((float) optJSONObject.optDouble("opacity", 0.0d));
                    coverTextView.setBackgroundColor(i3);
                    coverTextView.setScaleX((float) optJSONObject.optDouble(BasicAnimation.KeyPath.SCALE_X, 1.0d));
                    coverTextView.setScaleY((float) optJSONObject.optDouble(BasicAnimation.KeyPath.SCALE_Y, 1.0d));
                    optJSONArray = optJSONObject.optJSONArray("padding");
                    if (optJSONArray != null) {
                    }
                    coverTextView.setBorder(optJSONObject.optInt(NodeProps.BORDER_WIDTH, 0), i16, (float) optJSONObject.optDouble(NodeProps.BORDER_RADIUS, 0.0d), i3);
                    coverTextView.setAlpha((float) optJSONObject.optDouble("opacity", 0.0d));
                    coverTextView.setBorderRadius(((float) optJSONObject.optDouble(NodeProps.BORDER_RADIUS, 0.0d)) * this.density);
                }
            }
            i3 = 0;
            if (optJSONObject.has(NodeProps.BORDER_COLOR)) {
            }
            i16 = 0;
            coverTextView.setAlpha((float) optJSONObject.optDouble("opacity", 0.0d));
            coverTextView.setBackgroundColor(i3);
            coverTextView.setScaleX((float) optJSONObject.optDouble(BasicAnimation.KeyPath.SCALE_X, 1.0d));
            coverTextView.setScaleY((float) optJSONObject.optDouble(BasicAnimation.KeyPath.SCALE_Y, 1.0d));
            optJSONArray = optJSONObject.optJSONArray("padding");
            if (optJSONArray != null) {
            }
            coverTextView.setBorder(optJSONObject.optInt(NodeProps.BORDER_WIDTH, 0), i16, (float) optJSONObject.optDouble(NodeProps.BORDER_RADIUS, 0.0d), i3);
            coverTextView.setAlpha((float) optJSONObject.optDouble("opacity", 0.0d));
            coverTextView.setBorderRadius(((float) optJSONObject.optDouble(NodeProps.BORDER_RADIUS, 0.0d)) * this.density);
        }
    }

    private void setText(CoverTextView coverTextView, JSONObject jSONObject) {
        String optString = jSONObject.optString("content");
        if (!StringUtil.isEmpty(optString)) {
            coverTextView.setText(optString);
        }
    }

    private void setTextColor(CoverTextView coverTextView, JSONObject jSONObject) {
        if (!StringUtil.isEmpty(jSONObject.optString("color"))) {
            String actualColor = ColorUtils.getActualColor(jSONObject.optString("color"));
            if (!TextUtils.isEmpty(actualColor)) {
                coverTextView.setTextColor(Color.parseColor(actualColor));
            }
        }
    }

    private void setTextSize(CoverTextView coverTextView, JSONObject jSONObject) {
        if (jSONObject.optInt("fontSize", 0) > 0) {
            coverTextView.setTextSize(0, DisplayUtil.dip2px(this.mContext, r4));
        }
    }

    private void setTypeface(CoverTextView coverTextView, JSONObject jSONObject) {
        if ("bold".equals(jSONObject.optString("fontWeight"))) {
            coverTextView.setTypeface(Typeface.defaultFromStyle(1));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean updateTextView(int i3, JSONObject jSONObject) {
        CoverView coverView = CoverViewAction.obtain(this.mMiniAppContext, i3).get(jSONObject.optInt("viewId"));
        if (!(coverView instanceof CoverTextView)) {
            return false;
        }
        updateTextView((CoverTextView) coverView, jSONObject);
        return true;
    }

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
        this.density = DisplayUtil.getDensity(this.mContext);
    }

    @JsEvent({"insertTextView"})
    public void setEventInsertTextview(final RequestEvent requestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.TextViewJsPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    if (TextViewJsPlugin.this.insertTextView(requestEvent.webViewId, jSONObject)) {
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

    @JsEvent({"removeTextView"})
    public void setEventRemoveTextview(final RequestEvent requestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.TextViewJsPlugin.3
                @Override // java.lang.Runnable
                public void run() {
                    if (CoverViewAction.obtain(((BaseJsPlugin) TextViewJsPlugin.this).mMiniAppContext, requestEvent.webViewId).del(jSONObject.optInt("viewId"))) {
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

    @JsEvent({"updateTextView"})
    public void setEventUpdateTextview(final RequestEvent requestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.TextViewJsPlugin.2
                @Override // java.lang.Runnable
                public void run() {
                    if (TextViewJsPlugin.this.updateTextView(requestEvent.webViewId, jSONObject)) {
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

    private void updateTextView(CoverTextView coverTextView, JSONObject jSONObject) {
        setStyle(coverTextView, jSONObject);
        coverTextView.setClickable(jSONObject.optBoolean("clickable"));
        coverTextView.setIncludeFontPadding(false);
        setPosition(coverTextView, jSONObject);
        JSONObject optJSONObject = jSONObject.optJSONObject("label");
        if (optJSONObject != null) {
            setTextColor(coverTextView, optJSONObject);
            setTextSize(coverTextView, optJSONObject);
            setGravity(coverTextView, optJSONObject);
            setText(coverTextView, optJSONObject);
            setTypeface(coverTextView, optJSONObject);
            setSingleLine(coverTextView, optJSONObject);
            setEllipsize(coverTextView, optJSONObject);
            setPadding(coverTextView, optJSONObject);
        }
    }
}
