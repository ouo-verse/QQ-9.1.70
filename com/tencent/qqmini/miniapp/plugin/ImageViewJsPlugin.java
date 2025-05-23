package com.tencent.qqmini.miniapp.plugin;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.miniapp.action.CoverViewAction;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import com.tencent.qqmini.miniapp.widget.CoverImageView;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
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
public class ImageViewJsPlugin extends BaseJsPlugin {
    private static final String EVENT_INSERT_IMAGEVIEW = "insertImageView";
    private static final String EVENT_REMOVE_IMAGEVIEW = "removeImageView";
    private static final String EVENT_UPDATE_IMAGEVIEW = "updateImageView";
    private static final String TAG = "ImageViewJsPlugin";
    protected float density;

    /* JADX INFO: Access modifiers changed from: private */
    public int getPageWebViewId() {
        return PageAction.obtain(this.mMiniAppContext).getPageId();
    }

    private int getWindowHeight() {
        return PageAction.obtain(this.mMiniAppContext).getWindowHeight();
    }

    private void setIconPath(JSONObject jSONObject, String str, CoverImageView coverImageView) {
        int optInt;
        int i3;
        if (!str.startsWith("http") && !str.startsWith("https")) {
            String absolutePath = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str);
            if (!StringUtil.isEmpty(absolutePath)) {
                try {
                    Bitmap localBitmap = ImageUtil.getLocalBitmap(absolutePath);
                    if (localBitmap != null) {
                        coverImageView.setImageBitmap(localBitmap);
                        return;
                    }
                    return;
                } catch (Throwable th5) {
                    QMLog.e(TAG, "getLocalBitmap error.", th5);
                    return;
                }
            }
            return;
        }
        if (jSONObject != null) {
            try {
                int optInt2 = (int) ((this.density * jSONObject.optInt("width")) + 0.5f);
                optInt = (int) ((this.density * jSONObject.optInt("height")) + 0.5f);
                i3 = optInt2;
            } catch (Throwable th6) {
                QMLog.e(TAG, "URLDrawable error.", th6);
                return;
            }
        } else {
            i3 = 0;
            optInt = 0;
        }
        Drawable drawable = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getDrawable(this.mContext, str, i3, optInt, null);
        if (drawable != null) {
            coverImageView.setImageDrawable(drawable);
        }
    }

    private void setImageDrawable(String str, CoverImageView coverImageView, int i3, int i16) {
        if (!StringUtil.isEmpty(str)) {
            if (!str.startsWith("http") && !str.startsWith("https")) {
                String absolutePath = ((MiniAppFileManager) this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath(str);
                if (!StringUtil.isEmpty(absolutePath)) {
                    try {
                        Bitmap localBitmap = ImageUtil.getLocalBitmap(absolutePath);
                        if (localBitmap != null) {
                            coverImageView.setImageBitmap(localBitmap);
                            return;
                        }
                        return;
                    } catch (Throwable th5) {
                        QMLog.e(TAG, "getLocalBitmap error.", th5);
                        return;
                    }
                }
                return;
            }
            try {
                Drawable drawable = ((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).getDrawable(this.mContext, str, i3, i16, null);
                if (drawable != null) {
                    coverImageView.setImageDrawable(drawable);
                }
            } catch (Throwable th6) {
                QMLog.e(TAG, "URLDrawable error.", th6);
            }
        }
    }

    private void setOnClickListener(final RequestEvent requestEvent, final String str, Boolean bool, CoverView coverView) {
        if (bool != null) {
            coverView.setClickable(bool.booleanValue());
        }
        coverView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqmini.miniapp.plugin.ImageViewJsPlugin.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int pageWebViewId;
                EventCollector.getInstance().onViewClickedBefore(view);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("data", str);
                    IJsService iJsService = requestEvent.jsService;
                    String jSONObject2 = jSONObject.toString();
                    if (!((BaseJsPlugin) ImageViewJsPlugin.this).mIsContainer) {
                        pageWebViewId = ImageViewJsPlugin.this.getPageWebViewId();
                    } else {
                        pageWebViewId = requestEvent.webViewId;
                    }
                    iJsService.evaluateSubscribeJS("onImageViewClick", jSONObject2, pageWebViewId);
                } catch (Throwable th5) {
                    QMLog.e(ImageViewJsPlugin.TAG, "evaluateSubcribeJS error.", th5);
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        });
    }

    private void setPosition(JSONObject jSONObject, JSONObject jSONObject2, CoverView coverView, int i3, int i16) {
        int optInt;
        int optInt2 = (int) ((this.density * jSONObject.optInt("left")) + 0.5f);
        int optInt3 = (int) ((this.density * jSONObject.optInt("top")) + 0.5f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i3, i16);
        layoutParams.leftMargin = optInt2;
        layoutParams.topMargin = optInt3;
        coverView.setLayoutParams(layoutParams);
        if (jSONObject2 != null && (optInt = jSONObject2.optInt(CanvasView.ACTION_ROTATE)) != 0) {
            coverView.setPivotX(i3 / 2);
            coverView.setPivotY(i16 / 2);
            coverView.setRotation(optInt);
        }
    }

    private void setStyle(JSONObject jSONObject, CoverView coverView) {
        int i3;
        JSONArray optJSONArray;
        if (jSONObject != null) {
            if (jSONObject.has("bgColor")) {
                String actualColor = ColorUtils.getActualColor(jSONObject.optString("bgColor"));
                if (!TextUtils.isEmpty(actualColor)) {
                    try {
                        i3 = Color.parseColor(actualColor);
                    } catch (Exception e16) {
                        Log.w(TAG, "insertImageView: failed to parse color " + actualColor, e16);
                    }
                    coverView.setBackgroundColor(i3);
                    coverView.setAlpha((float) jSONObject.optDouble("opacity", 0.0d));
                    optJSONArray = jSONObject.optJSONArray("padding");
                    if (optJSONArray != null && optJSONArray.length() == 4) {
                        coverView.setPadding(optJSONArray.optInt(3, 0), optJSONArray.optInt(0, 0), optJSONArray.optInt(1, 0), optJSONArray.optInt(2, 0));
                    }
                    coverView.setBorderRadius(((float) jSONObject.optDouble(NodeProps.BORDER_RADIUS, 0.0d)) * this.density);
                }
            }
            i3 = 0;
            coverView.setBackgroundColor(i3);
            coverView.setAlpha((float) jSONObject.optDouble("opacity", 0.0d));
            optJSONArray = jSONObject.optJSONArray("padding");
            if (optJSONArray != null) {
                coverView.setPadding(optJSONArray.optInt(3, 0), optJSONArray.optInt(0, 0), optJSONArray.optInt(1, 0), optJSONArray.optInt(2, 0));
            }
            coverView.setBorderRadius(((float) jSONObject.optDouble(NodeProps.BORDER_RADIUS, 0.0d)) * this.density);
        }
    }

    @JsEvent({"insertImageView"})
    public void insertImageView(final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final int optInt = jSONObject.optInt("viewId");
            final int optInt2 = jSONObject.optInt("parentId");
            final String optString = jSONObject.optString("iconPath");
            final String optString2 = jSONObject.optString("data");
            final JSONObject optJSONObject = jSONObject.optJSONObject("position");
            final Boolean valueOf = jSONObject.has("clickable") ? Boolean.valueOf(jSONObject.optBoolean("clickable")) : null;
            final JSONObject optJSONObject2 = jSONObject.optJSONObject("style");
            final boolean optBoolean = jSONObject.optBoolean(QCircleDaTongConstant.ElementParamValue.FIXED, false);
            new JSONObject().put("viewId", optInt);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.ImageViewJsPlugin.1
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewJsPlugin.this.insertImageView(requestEvent, optJSONObject, optString2, optInt2, optInt, optString, valueOf, optJSONObject2, optBoolean)) {
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

    @Override // com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin, com.tencent.qqmini.sdk.launcher.core.plugins.ILifeCycle
    public void onCreate(IMiniAppContext iMiniAppContext) {
        super.onCreate(iMiniAppContext);
        this.density = DisplayUtil.getDensity(this.mContext);
    }

    @JsEvent({"removeImageView"})
    public void removeImageView(final RequestEvent requestEvent) {
        try {
            final JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.ImageViewJsPlugin.3
                @Override // java.lang.Runnable
                public void run() {
                    if (CoverViewAction.obtain(((BaseJsPlugin) ImageViewJsPlugin.this).mMiniAppContext, requestEvent.webViewId).del(jSONObject.optInt("viewId"))) {
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

    @JsEvent({"updateImageView"})
    public void updateImageView(final RequestEvent requestEvent) {
        try {
            JSONObject jSONObject = new JSONObject(requestEvent.jsonParams);
            final int optInt = jSONObject.optInt("viewId");
            final String optString = jSONObject.optString("iconPath");
            final JSONObject optJSONObject = jSONObject.optJSONObject("position");
            final Boolean valueOf = jSONObject.has("clickable") ? Boolean.valueOf(jSONObject.optBoolean("clickable")) : null;
            final JSONObject optJSONObject2 = jSONObject.optJSONObject("style");
            final String optString2 = jSONObject.optString("data");
            new JSONObject().put("viewId", optInt);
            AppBrandTask.runTaskOnUiThread(new Runnable() { // from class: com.tencent.qqmini.miniapp.plugin.ImageViewJsPlugin.2
                @Override // java.lang.Runnable
                public void run() {
                    if (ImageViewJsPlugin.this.updateImageView(requestEvent.webViewId, optJSONObject, optString2, optInt, optString, valueOf, optJSONObject2)) {
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

    public boolean updateImageView(int i3, JSONObject jSONObject, String str, int i16, String str2, Boolean bool, JSONObject jSONObject2) {
        CoverView coverView = CoverViewAction.obtain(this.mMiniAppContext, i3).get(i16);
        if (!(coverView instanceof CoverImageView)) {
            return false;
        }
        int windowHeight = getWindowHeight();
        if (jSONObject != null) {
            int optInt = (int) ((this.density * jSONObject.optInt("width")) + 0.5f);
            int optInt2 = (int) ((this.density * jSONObject.optInt("height")) + 0.5f);
            int optInt3 = (int) ((this.density * jSONObject.optInt("left")) + 0.5f);
            int optInt4 = (int) ((this.density * jSONObject.optInt("top")) + 0.5f);
            if (optInt2 + optInt4 > windowHeight) {
                optInt4 = windowHeight - optInt2;
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optInt, optInt2);
            layoutParams.leftMargin = optInt3;
            layoutParams.topMargin = optInt4;
            coverView.setLayoutParams(layoutParams);
        }
        if (jSONObject2 != null) {
            coverView.setAlpha((float) jSONObject2.optDouble("opacity", 0.0d));
            JSONArray optJSONArray = jSONObject2.optJSONArray("padding");
            if (optJSONArray != null && optJSONArray.length() == 4) {
                coverView.setPadding(optJSONArray.optInt(3, 0), optJSONArray.optInt(0, 0), optJSONArray.optInt(1, 0), optJSONArray.optInt(2, 0));
            }
            coverView.setBorderRadius(((float) jSONObject2.optDouble(NodeProps.BORDER_RADIUS, 0.0d)) * this.density);
        }
        if (!StringUtil.isEmpty(str2)) {
            setIconPath(jSONObject, str2, (CoverImageView) coverView);
        }
        if (bool != null) {
            coverView.setClickable(bool.booleanValue());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean insertImageView(RequestEvent requestEvent, JSONObject jSONObject, String str, int i3, int i16, String str2, Boolean bool, JSONObject jSONObject2, boolean z16) {
        boolean z17;
        int i17;
        JSONObject jSONObject3;
        int i18;
        CoverView coverView = CoverViewAction.obtain(this.mMiniAppContext, requestEvent.webViewId).get(i16);
        if (coverView == null) {
            coverView = new CoverImageView(this.mContext);
            coverView.setContentDescription(i16 + "_" + i3);
            coverView.setParentId(i3);
            coverView.setFixed(z16);
            z17 = CoverViewAction.obtain(this.mMiniAppContext, requestEvent.webViewId).add(i3, i16, coverView, z16);
        } else {
            z17 = true;
        }
        boolean z18 = z17;
        CoverView coverView2 = coverView;
        if (coverView2 instanceof CoverImageView) {
            if (jSONObject != null) {
                i17 = (int) ((this.density * jSONObject.optInt("width")) + 0.5f);
                i18 = (int) ((this.density * jSONObject.optInt("height")) + 0.5f);
                setPosition(jSONObject, jSONObject2, coverView2, i17, i18);
                jSONObject3 = jSONObject2;
            } else {
                i17 = 0;
                jSONObject3 = jSONObject2;
                i18 = 0;
            }
            setStyle(jSONObject3, coverView2);
            setImageDrawable(str2, (CoverImageView) coverView2, i17, i18);
            setOnClickListener(requestEvent, str, bool, coverView2);
        }
        return z18;
    }
}
