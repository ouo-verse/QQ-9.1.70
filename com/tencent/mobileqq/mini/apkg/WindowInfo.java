package com.tencent.mobileqq.mini.apkg;

import android.text.TextUtils;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class WindowInfo implements Cloneable {
    public static String ORIENTATION_AUTO = "auto";
    public static String ORIENTATION_LANDSCAPE = "landscape";
    public static String ORIENTATION_PORTRAIT = "portrait";
    public int backgroundColor;
    public String backgroundTextStyle;
    public Boolean disableScroll;
    public Boolean enablePullDownRefresh;
    public NavigationBarInfo navigationBarInfo;
    public int onReachBottomDistance;
    public String pageOrientation;

    public static WindowInfo getDefault() {
        WindowInfo windowInfo = new WindowInfo();
        windowInfo.navigationBarInfo = NavigationBarInfo.getDefault();
        windowInfo.backgroundColor = DisplayUtil.parseColor(TipsElementData.DEFAULT_COLOR);
        windowInfo.backgroundTextStyle = MiniAppConst.MENU_STYLE_DARK;
        windowInfo.enablePullDownRefresh = null;
        windowInfo.onReachBottomDistance = 50;
        windowInfo.disableScroll = null;
        windowInfo.pageOrientation = null;
        return windowInfo;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public WindowInfo m204clone() {
        WindowInfo windowInfo;
        Throwable th5;
        try {
            windowInfo = (WindowInfo) super.clone();
        } catch (Throwable th6) {
            windowInfo = null;
            th5 = th6;
        }
        try {
            windowInfo.navigationBarInfo = this.navigationBarInfo.m200clone();
        } catch (Throwable th7) {
            th5 = th7;
            th5.printStackTrace();
            return windowInfo;
        }
        return windowInfo;
    }

    public void updateInfo(JSONObject jSONObject) {
        int parseColor;
        if (jSONObject != null) {
            this.navigationBarInfo.updateInfo(jSONObject);
            String optString = jSONObject.optString("backgroundColor");
            if (TextUtils.isEmpty(optString)) {
                parseColor = this.backgroundColor;
            } else {
                parseColor = DisplayUtil.parseColor(optString);
            }
            this.backgroundColor = parseColor;
            this.backgroundTextStyle = jSONObject.optString("backgroundTextStyle", this.backgroundTextStyle);
            this.enablePullDownRefresh = jSONObject.has("enablePullDownRefresh") ? Boolean.valueOf(jSONObject.optBoolean("enablePullDownRefresh")) : null;
            this.onReachBottomDistance = jSONObject.optInt("onReachBottomDistance", this.onReachBottomDistance);
            this.disableScroll = jSONObject.has("disableScroll") ? Boolean.valueOf(jSONObject.optBoolean("disableScroll")) : null;
            this.pageOrientation = jSONObject.has("pageOrientation") ? jSONObject.optString("pageOrientation", ORIENTATION_PORTRAIT) : null;
        }
    }
}
