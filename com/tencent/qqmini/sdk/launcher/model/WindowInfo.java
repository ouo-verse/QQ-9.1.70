package com.tencent.qqmini.sdk.launcher.model;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppConst;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WindowInfo implements Cloneable {
    public static String ORIENTATION_AUTO = "auto";
    public static String ORIENTATION_LANDSCAPE = "landscape";
    public static String ORIENTATION_PORTRAIT = "portrait";
    public int backgroundColor;
    public String backgroundTextStyle;
    public Boolean disableScroll;
    public Boolean enablePullDownRefresh;
    public Boolean homeButtonIsShow;
    public NavigationBarInfo navigationBarInfo;
    public int onReachBottomDistance;
    public String pageOrientation;

    public static WindowInfo getDefault() {
        WindowInfo windowInfo = new WindowInfo();
        windowInfo.navigationBarInfo = NavigationBarInfo.getDefault();
        windowInfo.homeButtonIsShow = null;
        windowInfo.backgroundColor = ColorUtils.parseColor(TipsElementData.DEFAULT_COLOR);
        windowInfo.backgroundTextStyle = MiniAppConst.MENU_STYLE_DARK;
        windowInfo.enablePullDownRefresh = null;
        windowInfo.onReachBottomDistance = 50;
        windowInfo.disableScroll = null;
        windowInfo.pageOrientation = null;
        return windowInfo;
    }

    public void updateInfo(JSONObject jSONObject) {
        Boolean bool;
        int parseColor;
        Boolean bool2;
        Boolean bool3;
        if (jSONObject != null) {
            this.navigationBarInfo.updateInfo(jSONObject);
            String str = null;
            if (jSONObject.has("homeButton")) {
                bool = Boolean.valueOf(jSONObject.optBoolean("homeButton"));
            } else {
                bool = null;
            }
            this.homeButtonIsShow = bool;
            String optString = jSONObject.optString("backgroundColor");
            if (TextUtils.isEmpty(optString)) {
                parseColor = this.backgroundColor;
            } else {
                parseColor = ColorUtils.parseColor(optString);
            }
            this.backgroundColor = parseColor;
            this.backgroundTextStyle = jSONObject.optString("backgroundTextStyle", this.backgroundTextStyle);
            if (jSONObject.has("enablePullDownRefresh")) {
                bool2 = Boolean.valueOf(jSONObject.optBoolean("enablePullDownRefresh"));
            } else {
                bool2 = null;
            }
            this.enablePullDownRefresh = bool2;
            this.onReachBottomDistance = jSONObject.optInt("onReachBottomDistance", this.onReachBottomDistance);
            if (jSONObject.has("disableScroll")) {
                bool3 = Boolean.valueOf(jSONObject.optBoolean("disableScroll"));
            } else {
                bool3 = null;
            }
            this.disableScroll = bool3;
            if (jSONObject.has("pageOrientation")) {
                str = jSONObject.optString("pageOrientation", ORIENTATION_PORTRAIT);
            }
            this.pageOrientation = str;
        }
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public WindowInfo m246clone() {
        WindowInfo windowInfo;
        Throwable th5;
        try {
            windowInfo = (WindowInfo) super.clone();
        } catch (Throwable th6) {
            windowInfo = null;
            th5 = th6;
        }
        try {
            windowInfo.navigationBarInfo = this.navigationBarInfo.m242clone();
        } catch (Throwable th7) {
            th5 = th7;
            th5.printStackTrace();
            return windowInfo;
        }
        return windowInfo;
    }
}
