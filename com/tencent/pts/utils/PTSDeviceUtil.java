package com.tencent.pts.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes22.dex */
public class PTSDeviceUtil {
    static IPatchRedirector $redirector_ = null;
    private static final float SCREEN_RP = 750.0f;
    private static final String TAG = "PTSDeviceUtil";
    private static float density;
    private static int densityDpi;
    private static int screenHeightPx;
    private static int screenWidthPx;
    private static float textHeightOffsetPerLine;
    private static float textWidthOffsetPerLength;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41914);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        textHeightOffsetPerLine = 0.0f;
        textWidthOffsetPerLength = 0.0f;
        init();
    }

    PTSDeviceUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static float dp2px(float f16) {
        return f16 * density;
    }

    public static int dp2pxInt(float f16) {
        float f17;
        if (f16 > 0.0f) {
            f17 = (f16 * density) + 0.5f;
        } else if (f16 < 0.0f) {
            f17 = (f16 * density) - 0.5f;
        } else {
            return 0;
        }
        return (int) f17;
    }

    public static float getRPXScaling(float f16) {
        return f16 / SCREEN_RP;
    }

    public static float getScreenHeightDp() {
        return px2dp(screenHeightPx);
    }

    public static float getScreenHeightPx() {
        return screenHeightPx;
    }

    public static float getScreenScale() {
        return densityDpi / 160.0f;
    }

    public static float getScreenWidthDp() {
        return px2dp(screenWidthPx);
    }

    public static float getScreenWidthPx() {
        return screenWidthPx;
    }

    public static float getTextHeightOffsetPerLine() {
        return textHeightOffsetPerLine;
    }

    public static float getTextWidthOffsetPerLength() {
        return textWidthOffsetPerLength;
    }

    public static void init(Context context) {
        if (context != null && context.getResources() != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics != null) {
                density = displayMetrics.density;
                densityDpi = displayMetrics.densityDpi;
                screenWidthPx = displayMetrics.widthPixels;
                screenHeightPx = displayMetrics.heightPixels;
                PTSLog.i(TAG, "[init] density = " + density + ", densityDpi = " + densityDpi + ", screenWidthPx = " + screenWidthPx + ", screenHeightPx = " + screenHeightPx);
                return;
            }
            return;
        }
        init();
    }

    public static boolean isVisibleOnScreen(View view) {
        if (view == null || !view.isShown()) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        return rect.intersect(new Rect(0, 0, screenWidthPx, screenHeightPx));
    }

    public static float px2dp(float f16) {
        float f17 = density;
        if (f17 == 0.0f) {
            return 0.0f;
        }
        return f16 / f17;
    }

    public static int px2dpInt(float f16) {
        float f17;
        if (f16 > 0.0f) {
            f17 = (f16 / density) + 0.5f;
        } else if (f16 < 0.0f) {
            f17 = (f16 / density) - 0.5f;
        } else {
            return 0;
        }
        return (int) f17;
    }

    public static int rp2pxInt(float f16) {
        float f17;
        if (f16 > 0.0f) {
            f17 = ((screenWidthPx / SCREEN_RP) * f16) + 0.5f;
        } else if (f16 < 0.0f) {
            f17 = ((screenWidthPx / SCREEN_RP) * f16) - 0.5f;
        } else {
            return 0;
        }
        return (int) f17;
    }

    public static void setTextHeightOffsetPerLine(float f16) {
        textHeightOffsetPerLine = f16;
    }

    public static void setTextWidthOffsetPerLength(float f16) {
        textWidthOffsetPerLength = f16;
    }

    public static float getRPXScaling() {
        return getScreenWidthDp() / SCREEN_RP;
    }

    private static void init() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        if (displayMetrics != null) {
            density = displayMetrics.density;
            densityDpi = displayMetrics.densityDpi;
            screenWidthPx = displayMetrics.widthPixels;
            screenHeightPx = displayMetrics.heightPixels;
            PTSLog.i(TAG, "[init] density = " + density + ", densityDpi = " + densityDpi + ", screenWidthPx = " + screenWidthPx + ", screenHeightPx = " + screenHeightPx);
            return;
        }
        PTSLog.i(TAG, "[init] displayMetrics is null.");
    }
}
