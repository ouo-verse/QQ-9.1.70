package com.tencent.mtt.hippy.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Insets;
import android.os.Build;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.view.WindowMetrics;
import androidx.annotation.NonNull;
import com.tencent.mtt.hippy.common.HippyMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class DimensionsUtil {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
    private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
    private static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";
    private static int STATUS_BAR_HEIGHT = -1;

    private static boolean checkNavigationBarShow(@NonNull Context context) {
        boolean z16;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(SHOW_NAV_BAR_RES_NAME, "bool", "android");
        boolean z17 = false;
        if (identifier > 0) {
            z16 = resources.getBoolean(identifier);
        } else {
            z16 = false;
        }
        try {
            String str = (String) SystemProperties.class.getMethod("get", String.class).invoke(SystemProperties.class, "qemu.hw.mainkeys");
            int i3 = Settings.Global.getInt(context.getContentResolver(), getNavigationBarIsMinKeyName(), 0);
            if (!"1".equals(str) && 1 != i3) {
                z17 = "0".equals(str) ? true : z16;
            }
            return z17;
        } catch (Exception e16) {
            e16.printStackTrace();
            return z16;
        }
    }

    public static HippyMap getDimensions(int i3, int i16, Context context, boolean z16) {
        int i17;
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        displayMetrics2.setTo(displayMetrics);
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics2);
        HippyMap hippyMap = new HippyMap();
        getStatusBarHeight();
        int navigationBarHeight = getNavigationBarHeight(context);
        HippyMap hippyMap2 = new HippyMap();
        if (z16) {
            if (i3 < 0) {
                i3 = displayMetrics2.widthPixels;
            }
            hippyMap2.pushInt("width", i3);
            if (i16 < 0) {
                i16 = displayMetrics2.heightPixels;
            }
            hippyMap2.pushInt("height", i16);
            hippyMap2.pushDouble("scale", displayMetrics2.density);
            hippyMap2.pushDouble("fontScale", displayMetrics2.scaledDensity);
            i17 = displayMetrics2.densityDpi;
        } else {
            if (i3 < 0) {
                i3 = displayMetrics.widthPixels;
            }
            hippyMap2.pushInt("width", i3);
            if (i16 < 0) {
                i16 = displayMetrics.heightPixels;
            }
            hippyMap2.pushInt("height", i16);
            hippyMap2.pushDouble("scale", displayMetrics.density);
            hippyMap2.pushDouble("fontScale", displayMetrics.scaledDensity);
            i17 = displayMetrics.densityDpi;
        }
        hippyMap2.pushDouble("densityDpi", i17);
        hippyMap2.pushDouble("statusBarHeight", STATUS_BAR_HEIGHT);
        double d16 = navigationBarHeight;
        hippyMap2.pushDouble("navigationBarHeight", d16);
        hippyMap.pushMap("windowPhysicalPixels", hippyMap2);
        HippyMap hippyMap3 = new HippyMap();
        hippyMap3.pushInt("width", displayMetrics2.widthPixels);
        hippyMap3.pushInt("height", displayMetrics2.heightPixels);
        hippyMap3.pushDouble("scale", displayMetrics2.density);
        hippyMap3.pushDouble("fontScale", displayMetrics2.scaledDensity);
        hippyMap3.pushDouble("densityDpi", displayMetrics2.densityDpi);
        hippyMap3.pushDouble("statusBarHeight", STATUS_BAR_HEIGHT);
        hippyMap3.pushDouble("navigationBarHeight", d16);
        hippyMap.pushMap("screenPhysicalPixels", hippyMap3);
        return hippyMap;
    }

    public static int getNavigationBarHeight(Context context) {
        String str;
        if (context == null || !checkNavigationBarShow(context)) {
            return 0;
        }
        if (context.getResources().getConfiguration().orientation != 2) {
            str = NAV_BAR_HEIGHT_RES_NAME;
        } else {
            str = NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME;
        }
        try {
            return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier(str, "dimen", "android"));
        } catch (Resources.NotFoundException e16) {
            LogUtils.d("DimensionsUtil", "getNavigationBarHeight: " + e16.getMessage());
            return 0;
        }
    }

    private static String getNavigationBarIsMinKeyName() {
        String str = Build.BRAND;
        if (TextUtils.isEmpty(str) || str.equalsIgnoreCase("HUAWEI")) {
            return "navigationbar_is_min";
        }
        if (str.equalsIgnoreCase("XIAOMI")) {
            return "force_fsg_nav_bar";
        }
        if (!str.equalsIgnoreCase("VIVO") && !str.equalsIgnoreCase("OPPO")) {
            return "navigationbar_is_min";
        }
        return "navigation_gesture_on";
    }

    public static int getStatusBarHeight() {
        WindowMetrics currentWindowMetrics;
        WindowInsets windowInsets;
        int statusBars;
        Insets insetsIgnoringVisibility;
        int i3;
        Context appContext = ContextHolder.getAppContext();
        int i16 = STATUS_BAR_HEIGHT;
        if (i16 > 0) {
            return i16;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            currentWindowMetrics = ((WindowManager) ContextHolder.getAppContext().getSystemService("window")).getCurrentWindowMetrics();
            windowInsets = currentWindowMetrics.getWindowInsets();
            statusBars = WindowInsets.Type.statusBars();
            insetsIgnoringVisibility = windowInsets.getInsetsIgnoringVisibility(statusBars);
            i3 = insetsIgnoringVisibility.top;
            STATUS_BAR_HEIGHT = i3;
        } else {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                STATUS_BAR_HEIGHT = appContext.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
            } catch (Exception e16) {
                STATUS_BAR_HEIGHT = -1;
                e16.printStackTrace();
            }
            if (STATUS_BAR_HEIGHT < 1) {
                try {
                    STATUS_BAR_HEIGHT = Math.round(appContext.getResources().getDimension(appContext.getResources().getIdentifier("statebar_height", "dimen", appContext.getPackageName())));
                } catch (Resources.NotFoundException e17) {
                    LogUtils.d("DimensionsUtil", "getDimensions: " + e17.getMessage());
                }
            }
        }
        return STATUS_BAR_HEIGHT;
    }
}
