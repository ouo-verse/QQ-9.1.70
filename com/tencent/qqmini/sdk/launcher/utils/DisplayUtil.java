package com.tencent.qqmini.sdk.launcher.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.SystemProperties;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class DisplayUtil {
    private static final String NAVIGATION = "navigationBarBackground";
    private static final String NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME = "navigation_bar_height_landscape";
    private static final String NAV_BAR_HEIGHT_RES_NAME = "navigation_bar_height";
    private static final String SHOW_NAV_BAR_RES_NAME = "config_showNavigationBar";
    public static final String STATUS_BAR_HEIGHT = "status_bar_height";
    public static final String TAG = "DisplayUtil";
    private static float density = 0.0f;
    private static int immersiveSupportState = -1;
    private static boolean mInPortrait = true;
    private static int mhasNavBar = -1;
    private static String sNavBarOverride = null;
    public static int statusHeight = -1;

    static {
        if (VersionUtil.isKITKAT()) {
            try {
                Method declaredMethod = SystemProperties.class.getDeclaredMethod("get", String.class);
                declaredMethod.setAccessible(true);
                sNavBarOverride = (String) declaredMethod.invoke(null, "qemu.hw.mainkeys");
            } catch (Throwable unused) {
                sNavBarOverride = null;
            }
        }
    }

    DisplayUtil() {
    }

    private static void checkImmersiveStatusBar(Window window) {
        try {
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(0);
        } catch (Exception e16) {
            QMLog.e("DisplayUtil", "", e16);
        }
    }

    public static boolean checkNavigationBarShow(Context context) {
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
            int i3 = Settings.Global.getInt(context.getContentResolver(), "navigationbar_is_min", 0);
            if (!"1".equals(str) && 1 != i3) {
                z17 = "0".equals(str) ? true : z16;
            }
            return z17;
        } catch (Exception unused) {
            return z16;
        }
    }

    public static void clearCoverForStatus(Window window, boolean z16) {
        String phoneModel = OSUtils.getPhoneModel();
        if (z16) {
            StringBuilder sb5 = new StringBuilder();
            String str = Build.MANUFACTURER;
            sb5.append(str);
            sb5.append(phoneModel);
            String sb6 = sb5.toString();
            QMLog.i("DisplayUtil", "MANUFACTURER = " + str + ", MODEL = " + phoneModel);
            if (sb6 != null && (sb6.equals("MeizuPRO 7-S") || sb6.equalsIgnoreCase("MeizuM711C"))) {
                setTranslucentStatus(window);
            } else {
                checkImmersiveStatusBar(window);
            }
        }
    }

    @TargetApi(23)
    private static void compatHighMIUI(Window window, boolean z16) {
        View decorView = window.getDecorView();
        if (z16) {
            decorView.setSystemUiVisibility(9216);
        } else {
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-8193));
        }
    }

    private static boolean compatLowMIUI(Window window, boolean z16) {
        int i3;
        Class<?> cls = window.getClass();
        try {
            Class<?> cls2 = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i16 = cls2.getField("EXTRA_FLAG_STATUS_BAR_DARK_MODE").getInt(cls2);
            Class<?> cls3 = Integer.TYPE;
            Method method = cls.getMethod("setExtraFlags", cls3, cls3);
            Object[] objArr = new Object[2];
            if (z16) {
                i3 = i16;
            } else {
                i3 = 0;
            }
            objArr[0] = Integer.valueOf(i3);
            objArr[1] = Integer.valueOf(i16);
            method.invoke(window, objArr);
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static int dip2px(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static boolean enableXiaoMiNotch(Activity activity) {
        try {
            Window.class.getMethod("addExtraFlags", Integer.TYPE).invoke(activity.getWindow(), 1792);
            if (QMLog.isColorLevel()) {
                QMLog.i("Window", "enableXiaoMiNotch true");
            }
            return true;
        } catch (Exception e16) {
            if (QMLog.isColorLevel()) {
                QMLog.e("Window", "enableXiaoMiNotch Exception", e16);
            }
            return false;
        }
    }

    public static float getDensity(Context context) {
        float f16 = density;
        if (f16 != 0.0f) {
            return f16;
        }
        if (context != null) {
            float f17 = context.getResources().getDisplayMetrics().density;
            density = f17;
            return f17;
        }
        throw new IllegalArgumentException("");
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics;
    }

    private static int getInternalDimensionSize(Resources resources, String str) {
        int identifier = resources.getIdentifier(str, "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static int getNavigationBarHeight(Context context) {
        String str;
        Resources resources = context.getResources();
        if (mInPortrait) {
            str = NAV_BAR_HEIGHT_RES_NAME;
        } else {
            str = NAV_BAR_HEIGHT_LANDSCAPE_RES_NAME;
        }
        return getInternalDimensionSize(resources, str);
    }

    public static int getRealHeight(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (NoSuchMethodException e16) {
            QMLog.e("DisplayUtil", e16.getMessage());
            return -1;
        }
    }

    public static int getRealScreenWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static int getScreenHeight(Context context) {
        if (context.getResources().getConfiguration().orientation == 2) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int getScreenRefreshRate(Context context) {
        Display[] displays = ((DisplayManager) context.getSystemService("display")).getDisplays();
        if (displays != null && displays.length > 0) {
            return (int) displays[0].getRefreshRate();
        }
        return 60;
    }

    public static int getScreenWidth(Context context) {
        if (context.getResources().getConfiguration().orientation == 2) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getStatusBarHeight(Context context) {
        int i3;
        int ceil;
        if (statusHeight == -1) {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                i3 = resources.getDimensionPixelSize(identifier);
            } else {
                i3 = 0;
            }
            float f16 = resources.getDisplayMetrics().density;
            float f17 = f16 / resources.getDisplayMetrics().density;
            if (f17 <= 0.0f) {
                f17 = 1.0f;
            }
            if (i3 <= 0) {
                ceil = Math.round(f17 * 25.0f * f16);
            } else {
                ceil = (int) Math.ceil((i3 * f17) + 0.5f);
            }
            statusHeight = ceil;
        }
        return statusHeight;
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            return (String) SystemProperties.class.getMethod("get", String.class, String.class).invoke(SystemProperties.class, str, str2);
        } catch (Throwable th5) {
            th5.printStackTrace();
            return str2;
        }
    }

    public static boolean hasNavBar(Context context) {
        boolean z16;
        int i3 = mhasNavBar;
        if (i3 != -1) {
            if (i3 != 1) {
                return false;
            }
            return true;
        }
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(SHOW_NAV_BAR_RES_NAME, "bool", "android");
        if (identifier != 0) {
            z16 = resources.getBoolean(identifier);
            if ("1".equals(sNavBarOverride)) {
                z16 = false;
            } else if ("0".equals(sNavBarOverride)) {
                z16 = true;
            }
        } else {
            z16 = !ViewConfiguration.get(context).hasPermanentMenuKey();
        }
        QMLog.d("XPanelContainer", "hasNavbar=" + z16);
        if (z16) {
            mhasNavBar = 1;
        } else {
            mhasNavBar = 0;
        }
        return z16;
    }

    public static boolean isFlymeOS7NavBarShow() {
        String systemProperty = getSystemProperty("ro.build.display.id", "");
        if ("Flyme 7.1.1.4A".equals(systemProperty) || "Flyme 7.3.0.0A".equals(systemProperty)) {
            if ("1".equals(getSystemProperty("persist.sys.mz_mback_nav", "0")) && "0".equals(getSystemProperty("persist.sys.mz_mainkeys", "0"))) {
                return true;
            }
            if ("0".equals(getSystemProperty("persist.sys.mz_mback_nav", "0")) && "0".equals(getSystemProperty("persist.sys.mz_mback_nav", "0"))) {
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isImmersiveSupported() {
        int i3 = immersiveSupportState;
        if (i3 != -1) {
            if (i3 != 1) {
                return false;
            }
            return true;
        }
        String upperCase = Build.MANUFACTURER.toUpperCase();
        String str = upperCase + "-" + OSUtils.getPhoneModel();
        if (!upperCase.endsWith("BBK")) {
            upperCase.endsWith("VIVO");
            if (!str.equals("OPPO-3007")) {
                immersiveSupportState = 1;
                if (immersiveSupportState == 1) {
                    return false;
                }
                return true;
            }
        }
        immersiveSupportState = 0;
        if (immersiveSupportState == 1) {
        }
    }

    public static boolean isNavigationBarExist(Activity activity) {
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView();
        if (viewGroup != null) {
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                viewGroup.getChildAt(i3).getContext().getPackageName();
                if (viewGroup.getChildAt(i3).getId() != -1 && NAVIGATION.equals(activity.getResources().getResourceEntryName(viewGroup.getChildAt(i3).getId()))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isNavigationBarShow(Activity activity) {
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        Point point = new Point();
        Point point2 = new Point();
        defaultDisplay.getSize(point);
        defaultDisplay.getRealSize(point2);
        if (point2.y != point.y) {
            return true;
        }
        return false;
    }

    public static boolean isVivoAndLOLLIPOP() {
        if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO.equalsIgnoreCase(Build.MANUFACTURER)) {
            return true;
        }
        return false;
    }

    public static float mpx2px(double d16) {
        return (float) (d16 * density);
    }

    public static int mpx2pxInt(double d16) {
        return (int) ((d16 * density) + 0.5d);
    }

    public static int parseColor(String str) {
        try {
            if (str.length() == 4 && str.substring(0, 1).equals("#")) {
                String substring = str.substring(1, 2);
                String substring2 = str.substring(2, 3);
                String substring3 = str.substring(3, 4);
                str = "#" + substring + substring + substring2 + substring2 + substring3 + substring3;
            }
            return Color.parseColor(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    private static boolean processMIUI(Window window, boolean z16) {
        compatHighMIUI(window, z16);
        return true;
    }

    public static int px2dip(Context context, float f16) {
        return (int) ((f16 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static float px2mpx(double d16) {
        return (float) (d16 / density);
    }

    public static void setActivityFullScreen(Activity activity) {
        Window window;
        if (activity != null && !activity.isFinishing() && (window = activity.getWindow()) != null) {
            window.getDecorView().setSystemUiVisibility(23075586);
        }
    }

    public static void setActivityTransparent(Activity activity) {
        int i3;
        activity.requestWindowFeature(1);
        activity.getWindow().setFormat(-2);
        LiuHaiUtils.initLiuHaiProperty(activity);
        if (LiuHaiUtils.isLiuHaiUseValid()) {
            if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi") && ((i3 = Build.VERSION.SDK_INT) == 26 || i3 == 27)) {
                enableXiaoMiNotch(activity);
            } else {
                LiuHaiUtils.enableNotch(activity);
            }
        }
    }

    public static boolean setStatusBarDarkModeForFlyme(Window window, boolean z16) {
        int i3;
        int i16;
        if (window != null) {
            try {
                WindowManager.LayoutParams attributes = window.getAttributes();
                Field declaredField = WindowManager.LayoutParams.class.getDeclaredField("MEIZU_FLAG_DARK_STATUS_BAR_ICON");
                Field declaredField2 = WindowManager.LayoutParams.class.getDeclaredField("meizuFlags");
                declaredField.setAccessible(true);
                declaredField2.setAccessible(true);
                int i17 = declaredField.getInt(null);
                int i18 = declaredField2.getInt(attributes);
                if (z16) {
                    i16 = i17 | i18;
                } else {
                    i16 = (~i17) & i18;
                }
                declaredField2.setInt(attributes, i16);
                window.setAttributes(attributes);
            } catch (Exception unused) {
                QMLog.e("DisplayUtil", "setStatusBarDarkModeForFlyme: failed");
            }
            View decorView = window.getDecorView();
            if (decorView != null) {
                int systemUiVisibility = decorView.getSystemUiVisibility();
                if (z16) {
                    i3 = systemUiVisibility | 8192;
                } else {
                    i3 = systemUiVisibility & (-8193);
                }
                if (i3 != systemUiVisibility) {
                    decorView.setSystemUiVisibility(i3);
                }
            }
        }
        return true;
    }

    public static boolean setStatusTextColor(boolean z16, Window window) {
        if (OSUtils.isFlymeOS()) {
            return setStatusBarDarkModeForFlyme(window, z16);
        }
        if (OSUtils.isMIUI()) {
            return processMIUI(window, z16);
        }
        if (z16) {
            window.getDecorView().setSystemUiVisibility(9216);
        } else {
            window.getDecorView().setSystemUiVisibility(1280);
        }
        return true;
    }

    public static void setSystemUIVisible(Activity activity, boolean z16) {
        int i3;
        if (z16) {
            try {
                WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
                attributes.flags &= -1025;
                activity.getWindow().setAttributes(attributes);
                activity.getWindow().clearFlags(512);
                return;
            } catch (Exception e16) {
                QMLog.e("DisplayUtil", "void setSystemUIVisible", e16);
                return;
            }
        }
        LiuHaiUtils.initLiuHaiProperty(activity);
        if (LiuHaiUtils.isLiuHaiUseValid()) {
            if (Build.MANUFACTURER.equalsIgnoreCase("xiaomi") && ((i3 = Build.VERSION.SDK_INT) == 26 || i3 == 27)) {
                enableXiaoMiNotch(activity);
            } else {
                LiuHaiUtils.enableNotch(activity);
            }
        }
        activity.getWindow().setFlags(1024, 1024);
    }

    public static void setTranslucentStatus(Window window) {
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                Field declaredField = Class.forName("com.android.internal.policy.DecorView").getDeclaredField("mSemiTransparentStatusBarColor");
                declaredField.setAccessible(true);
                declaredField.setInt(window.getDecorView(), 0);
            } catch (Exception unused) {
                QMLog.i("DisplayUtil", "\u53cd\u5c04\u4fee\u6539\u72b6\u6001\u680f\u989c\u8272\u5931\u8d25");
            }
        }
    }

    public static int sp2px(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static void updatePortrait(Activity activity) {
        if (activity != null) {
            boolean z16 = true;
            if (activity.getWindow().getContext().getResources().getConfiguration().orientation != 1) {
                z16 = false;
            }
            mInPortrait = z16;
        }
    }

    public static int getScreenHeight(Activity activity) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
        boolean z16 = (hasNavBar(activity) && isNavigationBarExist(activity)) || isFlymeOS7NavBarShow();
        int i3 = displayMetrics.heightPixels;
        return z16 ? i3 - getNavigationBarHeight(activity) : i3;
    }
}
