package com.tencent.mobileqq.shortvideo.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ScreenUtil {
    private static float DENSITY = 0.0f;
    public static int SCREEN_HIGHT = 0;
    public static int SCREEN_WIDTH = 0;
    private static final String TAG = "ScreenUtil";
    private static Context context;
    private static int sRefreshRate;

    static {
        Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
        context = applicationContext;
        sRefreshRate = 0;
        SCREEN_WIDTH = 320;
        SCREEN_HIGHT = 480;
        Display defaultDisplay = ((WindowManager) applicationContext.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            SCREEN_WIDTH = defaultDisplay.getWidth();
            SCREEN_HIGHT = defaultDisplay.getHeight();
        }
    }

    public static boolean checkDeviceHasNavigationBar(Context context2) {
        if (Build.MANUFACTURER.contains(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI) && (DeviceInfoMonitor.getModel().contains("MIX 2S") || DeviceInfoMonitor.getModel().contains("MI 8") || DeviceInfoMonitor.getModel().contains("MI 9") || DeviceInfoMonitor.getModel().contains("MIX 2") || DeviceInfoMonitor.getModel().contains("MIX 3") || DeviceInfoMonitor.getModel().contains("Redmi K20 Pro"))) {
            if (Settings.Global.getInt(BaseApplication.getContext().getContentResolver(), "force_fsg_nav_bar", 0) == 0) {
                return true;
            }
            return false;
        }
        if (getInstantScreenHeight(context2) != getRealHeight(context2)) {
            return true;
        }
        return false;
    }

    public static boolean checkNavigationBarShow(Context context2) {
        boolean z16;
        boolean z17 = false;
        try {
            Resources resources = context2.getResources();
            int identifier = resources.getIdentifier("config_showNavigationBar", "bool", "android");
            if (identifier > 0) {
                z16 = resources.getBoolean(identifier);
            } else {
                z16 = false;
            }
            try {
                if (Settings.Global.getInt(context2.getContentResolver(), "navigationbar_is_min", 0) == 1) {
                    return false;
                }
                if (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
                    String str = (String) SystemProperties.class.getMethod("get", String.class).invoke(SystemProperties.class, "qemu.hw.mainkeys");
                    if ("1".equals(str)) {
                        return false;
                    }
                    if ("0".equals(str)) {
                        return true;
                    }
                }
                return z16;
            } catch (Exception e16) {
                e = e16;
                z17 = z16;
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, "checkNavigationBarShow error: " + e.toString());
                    return z17;
                }
                return z17;
            }
        } catch (Exception e17) {
            e = e17;
        }
    }

    public static int dip2px(float f16) {
        if (DENSITY == 0.0f) {
            DENSITY = context.getResources().getDisplayMetrics().density;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[@] ScreenUtil.dip2px DENSITY = " + DENSITY);
            }
        }
        return (int) ((f16 * DENSITY) + 0.5f);
    }

    public static float getCurrentScreenRefreshRate(Activity activity) {
        return ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRefreshRate();
    }

    public static float getDensity() {
        if (DENSITY == 0.0f) {
            DENSITY = context.getResources().getDisplayMetrics().density;
        }
        return DENSITY;
    }

    @TargetApi(13)
    public static int getInstantScreenHeight(Context context2) {
        WindowManager windowManager = (WindowManager) context2.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        int i3 = point.y;
        SCREEN_HIGHT = i3;
        return i3;
    }

    public static int getInstantScreenWidth(Context context2) {
        WindowManager windowManager = (WindowManager) context2.getSystemService("window");
        Point point = new Point();
        windowManager.getDefaultDisplay().getSize(point);
        int i3 = point.x;
        SCREEN_WIDTH = i3;
        return i3;
    }

    public static int getMaxRefreshRate() {
        int i3 = sRefreshRate;
        if (i3 > 0) {
            return i3;
        }
        int i16 = 0;
        for (Display.Mode mode : ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getSupportedModes()) {
            i16 = Math.max(i16, (int) mode.getRefreshRate());
        }
        sRefreshRate = i16;
        QLog.d(TAG, 4, "Supported display max refresh rates: " + sRefreshRate);
        return sRefreshRate;
    }

    @TargetApi(23)
    private static Display.Mode getMaxScreenRefreshRateMode(Context context2) {
        Display defaultDisplay;
        WindowManager windowManager = (WindowManager) context2.getSystemService("window");
        Display.Mode mode = null;
        if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return null;
        }
        Display.Mode mode2 = defaultDisplay.getMode();
        for (Display.Mode mode3 : defaultDisplay.getSupportedModes()) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "supported mode: modeId=" + mode3.getModeId() + ", size=" + mode3.getPhysicalWidth() + "-" + mode3.getPhysicalHeight() + ", refreshRate=" + mode3.getRefreshRate() + ", currentModeId=" + mode2.getModeId());
            }
            if (mode3.getPhysicalWidth() == mode2.getPhysicalWidth() && mode3.getPhysicalHeight() == mode2.getPhysicalHeight() && (mode == null || mode3.getRefreshRate() > mode.getRefreshRate())) {
                mode = mode3;
            }
        }
        return mode;
    }

    public static int getNavigationBarHeight(Context context2) {
        Resources resources = context2.getResources();
        int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (identifier != 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getRealHeight(Context context2) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            ((WindowManager) context2.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (NoSuchMethodException e16) {
            QLog.e(TAG, 1, e16.getMessage());
            return -1;
        }
    }

    public static int getRealWidth(Context context2) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            ((WindowManager) context2.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics.widthPixels;
        } catch (NoSuchMethodException e16) {
            QLog.e(TAG, 1, e16.getMessage());
            return -1;
        }
    }

    public static boolean isNavigationBarExist(Activity activity) {
        if (activity == null) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
            int id5 = viewGroup.getChildAt(i3).getId();
            if (id5 != -1 && "navigationBarBackground".equals(activity.getResources().getResourceEntryName(id5))) {
                return true;
            }
        }
        return false;
    }

    public static void updateCache() {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        SCREEN_WIDTH = windowManager.getDefaultDisplay().getWidth();
        SCREEN_HIGHT = windowManager.getDefaultDisplay().getHeight();
        DENSITY = context.getResources().getDisplayMetrics().density;
        if (QLog.isColorLevel()) {
            QLog.d("systemDpiChanged", 2, "mofity width:" + SCREEN_WIDTH);
        }
    }

    public static void useHighScreenRefreshRate(Activity activity) {
        Display.Mode maxScreenRefreshRateMode = getMaxScreenRefreshRateMode(activity);
        if (maxScreenRefreshRateMode != null) {
            try {
                Window window = activity.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.preferredDisplayModeId = maxScreenRefreshRateMode.getModeId();
                window.setAttributes(attributes);
                QLog.i(TAG, 1, "high screen refresh rate is enabled, modeId=" + maxScreenRefreshRateMode.getModeId());
            } catch (Throwable unused) {
                QLog.i(TAG, 1, "[useHighScreenRefreshRate] exc=$e");
            }
        }
    }
}
