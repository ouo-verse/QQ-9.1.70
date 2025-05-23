package com.tencent.qqmini.sdk.launcher.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.proxy.WnsConfigProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class LiuHaiUtils {
    private static final int ANDROID_O_API_LIMIT = 26;
    private static final int ANDROID_P_API_LIMIT = 27;
    private static final int FLAG_NOTCH_SUPPORT = 65536;
    public static final int LAYOUT_IN_DISPLAY_CUTOUT_MODE_ALWAYS = 1;
    public static final int LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT = 0;
    public static final int LAYOUT_IN_DISPLAY_CUTOUT_MODE_NEVER = 2;
    public static final int LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES = 1;
    private static String[] LIUHAI_LIST = null;
    private static String[] MANUFACTURER = null;
    public static final int NOTCH_IN_SCREEN_VOIO = 32;
    public static final ArrayList<String> NOTCH_WHITE_LIST;
    public static final int ROUNDED_IN_SCREEN_VOIO = 8;
    private static final String TAG = "LiuHaiUtils";
    public static boolean hasInitHasNotch = false;
    public static int sCenterOffset = 0;
    public static boolean sEnableNotchOK = false;
    private static final boolean sForceCenter_16_9 = true;
    public static boolean sHasNotch;
    public static boolean sIsIrregularScreen;
    public static int sNotchHeight;
    public static int sScreenHeight;
    public static int sScreenWidth;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        NOTCH_WHITE_LIST = arrayList;
        sHasNotch = false;
        sEnableNotchOK = false;
        sNotchHeight = 0;
        hasInitHasNotch = false;
        sScreenHeight = 0;
        sScreenWidth = 0;
        sCenterOffset = 0;
        sIsIrregularScreen = false;
        LIUHAI_LIST = new String[]{"PAAM00", "Lenovo L78011", "Pixel 3 XL", "SM-G9750"};
        MANUFACTURER = new String[]{"HUAWEI", "OPPO", "VIVO", "XIAOMI"};
        arrayList.add("SHARP_FS8010".toLowerCase());
    }

    public static void closeFullScreen(Activity activity) {
        activity.getWindow().clearFlags(1024);
        activity.getWindow().addFlags(2048);
        activity.getWindow().addFlags(256);
        activity.getWindow().clearFlags(512);
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-5));
    }

    private static boolean enableHuaWeiNotch(Activity activity) {
        if (activity != null && activity.getWindow() != null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            try {
                Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
                cls.getMethod("addHwFlags", Integer.TYPE).invoke(cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 65536);
                if (QMLog.isColorLevel()) {
                    QMLog.i(TAG, "enableHuaWeiNotch true");
                }
                return true;
            } catch (Exception e16) {
                if (QMLog.isColorLevel()) {
                    QMLog.e(TAG, "enableHuaWeiNotch Exception", e16);
                }
                return false;
            }
        }
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "enableHuaWeiNotch invalid param");
        }
        return false;
    }

    private static boolean enableMeizuNotch(Activity activity) {
        try {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 128);
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "enableMeizuNotch true");
                return true;
            }
            return true;
        } catch (Exception e16) {
            if (QMLog.isColorLevel()) {
                QMLog.e(TAG, "enableMeizuNotch Exception", e16);
                return false;
            }
            return false;
        }
    }

    public static boolean enableNotch(Activity activity) {
        int i3 = Build.VERSION.SDK_INT;
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "enableNotch apiVersion: " + i3);
        }
        if (i3 > 27) {
            return enableNotchInScreen_AndroidP(activity);
        }
        return enableNotchInScreen_AndroidO(activity);
    }

    private static boolean enableNotchInScreen(Activity activity) {
        int i3 = Build.VERSION.SDK_INT;
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "enableNotchInScreen apiVersion: " + i3);
            return true;
        }
        return true;
    }

    private static boolean enableNotchInScreen_AndroidO(Activity activity) {
        String str = "" + Build.MANUFACTURER;
        if (str.equalsIgnoreCase("HUAWEI")) {
            return enableHuaWeiNotch(activity);
        }
        if (str.equalsIgnoreCase("OPPO")) {
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "enableNotchInScreen_AndroidO OPPO=true");
            }
            return true;
        }
        if (str.equalsIgnoreCase("VIVO")) {
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "enableNotchInScreen_AndroidO VIVO=true");
            }
            return true;
        }
        if (str.equalsIgnoreCase("XIAOMI")) {
            return enableXiaoMiNotch(activity);
        }
        if (str.equalsIgnoreCase("SAMSUNG")) {
            return enableSamsungNotch(activity);
        }
        if (str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_MEIZU)) {
            return enableMeizuNotch(activity);
        }
        return false;
    }

    private static boolean enableNotchInScreen_AndroidP(Activity activity) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        try {
            Field field = attributes.getClass().getField("layoutInDisplayCutoutMode");
            field.setAccessible(true);
            field.setInt(attributes, 1);
            activity.getWindow().setAttributes(attributes);
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "enableNotchInScreen_AndroidP true");
            }
            return true;
        } catch (Exception unused) {
            if (QMLog.isColorLevel()) {
                QMLog.e(TAG, "enableNotchInScreen_AndroidP Exception");
                return false;
            }
            return false;
        }
    }

    private static boolean enableSamsungNotch(Activity activity) {
        return enableNotchInScreen_AndroidP(activity);
    }

    private static boolean enableXiaoMiNotch(Activity activity) {
        try {
            Window.class.getMethod("addExtraFlags", Integer.TYPE).invoke(activity.getWindow(), 768);
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "enableXiaoMiNotch true");
            }
            return true;
        } catch (Exception e16) {
            if (QMLog.isColorLevel()) {
                QMLog.e(TAG, "enableXiaoMiNotch Exception", e16);
            }
            return false;
        }
    }

    public static int getNotchInScreenHeight(Activity activity) {
        int i3 = Build.VERSION.SDK_INT;
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "getNotchInScreenHeight apiVersion: " + i3);
        }
        int statusBarHeight = getStatusBarHeight(activity);
        if (statusBarHeight <= 0) {
            if (i3 > 27) {
                return getNotchInScreenHeight_AndroidP(activity);
            }
            return getNotchInScreenHeight_AndroidO(activity);
        }
        return statusBarHeight;
    }

    public static int getNotchInScreenHeight_AndroidO(Context context) {
        int[] iArr;
        int i3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("");
        String str = Build.MANUFACTURER;
        sb5.append(str);
        String sb6 = sb5.toString();
        if (sb6.equalsIgnoreCase("HUAWEI")) {
            iArr = hwGetNotchSize(context);
        } else if (sb6.equalsIgnoreCase("OPPO")) {
            iArr = oppoGetNotchSize(context);
        } else if (!sb6.equalsIgnoreCase("VIVO") && sb6.equalsIgnoreCase("XIAOMI")) {
            iArr = xiaomiGetNotchSize(context);
        } else {
            iArr = null;
        }
        int i16 = 0;
        if (iArr != null) {
            i3 = iArr[0];
        } else {
            i3 = 0;
        }
        if (iArr != null) {
            i16 = iArr[1];
        }
        int statusBarHeight = getStatusBarHeight(context);
        if (QMLog.isColorLevel()) {
            QMLog.e(TAG, "getNotchInScreenHeight manufacturer:" + str + " height:" + i16 + " width:" + i3 + " status:" + statusBarHeight);
        }
        return Math.max(i16, statusBarHeight);
    }

    public static int getNotchInScreenHeight_AndroidP(Activity activity) {
        Object invoke;
        int statusBarHeight = getStatusBarHeight(activity);
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null) {
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "getNotchInScreenHeight_AndroidP decorView=null ");
            }
            return statusBarHeight;
        }
        try {
            invoke = decorView.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(decorView, new Object[0]);
        } catch (Exception unused) {
            if (QMLog.isColorLevel()) {
                QMLog.e(TAG, "getNotchInScreenHeight_AndroidP Exception");
            }
        }
        if (invoke == null) {
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "getNotchInScreenHeight_AndroidP getRootWindowInsets inserts=null ");
            }
            return statusBarHeight;
        }
        Object invoke2 = invoke.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(invoke, new Object[0]);
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "getNotchInScreenHeight_AndroidP getDisplayCutout cutOut=" + invoke2);
        }
        if (invoke2 != null) {
            int intValue = ((Integer) invoke2.getClass().getMethod("getSafeInsetTop", new Class[0]).invoke(invoke2, new Object[0])).intValue();
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "getNotchInScreenHeight_AndroidP top:" + intValue);
            }
            return intValue;
        }
        return statusBarHeight;
    }

    public static int[] getRealDisplay(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        defaultDisplay.getMetrics(new DisplayMetrics());
        int i3 = Build.VERSION.SDK_INT;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "getRealDisplay manufacturer:" + Build.MANUFACTURER + " version:" + i3 + " width:" + displayMetrics.widthPixels + " height:" + displayMetrics.heightPixels);
        }
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    public static int getStatusBarHeight(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static int getSystemPropertyForXiaomi(String str, int i3) {
        try {
            Method method = SystemProperties.class.getMethod("getInt", String.class, Integer.TYPE);
            if (method != null) {
                Object invoke = method.invoke(null, str, Integer.valueOf(i3));
                if (invoke instanceof Integer) {
                    return ((Integer) invoke).intValue();
                }
            }
        } catch (Exception e16) {
            if (QMLog.isColorLevel()) {
                QMLog.d(TAG, "getSystemPropertyForXiaomi() Exception=" + e16.getMessage());
            }
        }
        return i3;
    }

    private static boolean hasNotchInScreen(Activity activity) {
        boolean z16 = false;
        sIsIrregularScreen = false;
        int i3 = Build.VERSION.SDK_INT;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("");
        String str = Build.MANUFACTURER;
        sb5.append(str);
        String sb6 = sb5.toString();
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "hasNotchInScreen version: " + i3 + " " + sb6);
        }
        if (i3 < 26) {
            return false;
        }
        if (i3 > 27) {
            z16 = hasNotchInScreen_AndroidP(activity);
        }
        if (!z16 && i3 >= 26) {
            z16 = hasNotchInScreen_AndroidO(activity);
        }
        if (isLiuHaiModel()) {
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "hasNotchInScreen manufacturer = " + str + " ,brand = " + Build.BRAND + " ,model = " + OSUtils.getPhoneModel());
                return true;
            }
            return true;
        }
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "hasNotchInScreen haveNotch: " + z16);
        }
        return z16;
    }

    public static boolean hasNotchInScreen_AndroidO(Context context) {
        String str = "" + Build.MANUFACTURER;
        if (str.equalsIgnoreCase("HUAWEI")) {
            return hwHasNotchInScreen(context);
        }
        if (str.equalsIgnoreCase("OPPO")) {
            return oppoHasNotchInScreen(context);
        }
        if (str.equalsIgnoreCase("VIVO")) {
            return vivoHasNotchInScreen(context);
        }
        if (str.equalsIgnoreCase("XIAOMI")) {
            return xiaomiHasNotchInScreen(context);
        }
        return false;
    }

    public static boolean hasNotchInScreen_AndroidP(Activity activity) {
        boolean z16;
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null) {
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "hasNotchInScreen_AndroidP decorView=null");
            }
            return false;
        }
        try {
            Object invoke = decorView.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(decorView, new Object[0]);
            if (invoke == null) {
                if (QMLog.isColorLevel()) {
                    QMLog.i(TAG, "hasNotchInScreen_AndroidP getRootWindowInsets inserts=null");
                }
                return false;
            }
            if (invoke.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(invoke, new Object[0]) != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "hasNotchInScreen_AndroidP getDisplayCutout  exists:" + z16);
            }
            return z16;
        } catch (Exception unused) {
            if (QMLog.isColorLevel()) {
                QMLog.e(TAG, "hasNotchInScreen_AndroidP Exception");
            }
            return false;
        }
    }

    private static int[] hwGetNotchSize(Context context) {
        int[] iArr;
        int[] iArr2 = {0, 0};
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            iArr = (int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
        } catch (ClassNotFoundException unused) {
        } catch (NoSuchMethodException unused2) {
        } catch (Exception unused3) {
        }
        try {
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "hwGetNotchSize ret=" + iArr);
                return iArr;
            }
            return iArr;
        } catch (ClassNotFoundException unused4) {
            iArr2 = iArr;
            if (QMLog.isColorLevel()) {
                QMLog.e(TAG, "hwGetNotchSize ClassNotFoundException");
            }
            return iArr2;
        } catch (NoSuchMethodException unused5) {
            iArr2 = iArr;
            if (QMLog.isColorLevel()) {
                QMLog.e(TAG, "hwGetNotchSize NoSuchMethodException");
            }
            return iArr2;
        } catch (Exception unused6) {
            iArr2 = iArr;
            if (QMLog.isColorLevel()) {
                QMLog.e(TAG, "hasNotchInScreen Exception");
            }
            return iArr2;
        }
    }

    private static boolean hwHasNotchInScreen(Context context) {
        boolean z16 = false;
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            z16 = ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "hwHasNotchInScreen ret=" + z16);
            }
        } catch (ClassNotFoundException unused) {
            if (QMLog.isColorLevel()) {
                QMLog.e(TAG, "hwHasNotchInScreen ClassNotFoundException");
            }
        } catch (NoSuchMethodException unused2) {
            if (QMLog.isColorLevel()) {
                QMLog.e(TAG, "hwHasNotchInScreen NoSuchMethodException");
            }
        } catch (Exception unused3) {
            if (QMLog.isColorLevel()) {
                QMLog.e(TAG, "hwHasNotchInScreen Exception");
            }
        }
        return z16;
    }

    public static void initLiuHaiProperty(Activity activity) {
        boolean z16;
        WnsConfigProxy wnsConfigProxy = (WnsConfigProxy) AppLoaderFactory.g().getProxyManager().get(WnsConfigProxy.class);
        if (wnsConfigProxy != null) {
            z16 = wnsConfigProxy.getNotchIgnoreEnable(false);
        } else {
            z16 = false;
        }
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "initLiuHaiProperty manufacturer:" + Build.MANUFACTURER + " hasInitHasNotch:" + hasInitHasNotch + " sHasNotch:" + sHasNotch + " sEnableNotchOK:" + sEnableNotchOK + " sNotchHeight:" + sNotchHeight);
        }
        if (!hasInitHasNotch) {
            sScreenHeight = DisplayUtil.getScreenHeight(activity);
            sScreenWidth = DisplayUtil.getScreenWidth(activity);
            sHasNotch = false;
            try {
                sHasNotch = hasNotchInScreen(activity);
            } catch (Throwable th5) {
                if (QMLog.isColorLevel()) {
                    QMLog.e(TAG, "initLiuHaiProperty manufacturer:" + Build.MANUFACTURER, th5);
                }
            }
            if (z16) {
                int notchInScreenHeight = getNotchInScreenHeight(activity);
                sNotchHeight = notchInScreenHeight;
                if (notchInScreenHeight > 0) {
                    sHasNotch = true;
                }
            } else if (sHasNotch) {
                sNotchHeight = getNotchInScreenHeight(activity);
            }
            hasInitHasNotch = true;
        }
        sEnableNotchOK = false;
        if (sHasNotch) {
            if (z16) {
                sEnableNotchOK = enableNotch(activity);
            } else {
                sEnableNotchOK = enableNotchInScreen(activity);
            }
            if (sNotchHeight <= 0) {
                sEnableNotchOK = false;
            }
        }
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "initLiuHaiProperty[after] manufacturer:" + Build.MANUFACTURER + " hasInitHasNotch:" + hasInitHasNotch + " sHasNotch:" + sHasNotch + " sEnableNotchOK:" + sEnableNotchOK + " sNotchHeight:" + sNotchHeight);
        }
    }

    private static boolean isLiuHaiModel() {
        String phoneModel = OSUtils.getPhoneModel();
        if (!TextUtils.isEmpty(phoneModel)) {
            for (String str : LIUHAI_LIST) {
                if (phoneModel.equalsIgnoreCase(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isLiuHaiUseValid() {
        if (sHasNotch && sEnableNotchOK && sNotchHeight > 0) {
            return true;
        }
        return false;
    }

    public static boolean needCloseFullScreen() {
        if (sHasNotch) {
            return true;
        }
        return false;
    }

    private static int[] oppoGetNotchSize(Context context) {
        String str;
        try {
            str = DisplayUtil.getSystemProperty("ro.oppo.screen.heteromorphism", null);
        } catch (Throwable th5) {
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "oppoGetNotchSize mProperty exp ", th5);
            }
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "oppoGetNotchSize mProperty empty");
            }
            return null;
        }
        String[] split = str.split(":");
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "oppoGetNotchSize mProperty values=" + split);
        }
        if (split.length >= 2) {
            String[] split2 = split[0].split(",");
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "oppoGetNotchSize mProperty values[0] size=" + split2);
            }
            if (split2.length < 2) {
                return null;
            }
            try {
                int intValue = Integer.valueOf(split2[0]).intValue();
                int intValue2 = Integer.valueOf(split2[1]).intValue();
                if (QMLog.isColorLevel()) {
                    QMLog.i(TAG, "oppoGetNotchSize mProperty values[0] left=" + intValue + " top=" + intValue2);
                }
                String[] split3 = split[1].split(",");
                if (QMLog.isColorLevel()) {
                    QMLog.i(TAG, "oppoGetNotchSize mProperty values[1] size=" + split3);
                }
                if (split3.length < 2) {
                    return null;
                }
                try {
                    int intValue3 = Integer.valueOf(split3[0]).intValue();
                    int intValue4 = Integer.valueOf(split3[1]).intValue();
                    if (QMLog.isColorLevel()) {
                        QMLog.i(TAG, "oppoGetNotchSize mProperty values[1] right=" + intValue3 + " bottom=" + intValue4);
                    }
                    return new int[]{intValue3 - intValue, intValue4 - intValue2};
                } catch (NumberFormatException e16) {
                    if (QMLog.isColorLevel()) {
                        QMLog.i(TAG, "oppoGetNotchSize values[1]=" + split[1], e16);
                    }
                    return null;
                }
            } catch (NumberFormatException e17) {
                if (QMLog.isColorLevel()) {
                    QMLog.i(TAG, "oppoGetNotchSize values[0]=" + split[0], e17);
                }
            }
        }
        return null;
    }

    private static boolean oppoHasNotchInScreen(Context context) {
        if (OSUtils.getPhoneModel().equals("PAAM00")) {
            return true;
        }
        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "oppoHasNotchInScreen exits:" + hasSystemFeature);
        }
        return hasSystemFeature;
    }

    public static void resetAllLiuHaiStatus() {
        sHasNotch = false;
        sEnableNotchOK = false;
        sNotchHeight = 0;
        hasInitHasNotch = false;
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "resetAllLiuHaiStatus!");
        }
    }

    public static void resetFullScreen(Activity activity) {
        activity.getWindow().clearFlags(2048);
        activity.getWindow().addFlags(1024);
        activity.getWindow().addFlags(256);
        activity.getWindow().addFlags(512);
        View decorView = activity.getWindow().getDecorView();
        decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 4);
    }

    public static boolean vivoHasNotchInScreen(Context context) {
        boolean z16 = false;
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            z16 = ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "vivoHasNotchInScreen ret=" + z16);
            }
        } catch (Exception e16) {
            if (QMLog.isColorLevel()) {
                QMLog.e(TAG, "vivoHasNotchInScreen Exception", e16);
            }
        }
        return z16;
    }

    private static int[] xiaomiGetNotchSize(Context context) {
        int[] iArr = {0, 0};
        int identifier = context.getResources().getIdentifier("notch_width", "dimen", "android");
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "xiaomiGetNotchSize [notch_width]resourceId: " + identifier);
        }
        if (identifier > 0) {
            iArr[0] = context.getResources().getDimensionPixelSize(identifier);
        }
        int identifier2 = context.getResources().getIdentifier("notch_height", "dimen", "android");
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "xiaomiGetNotchSize [notch_height]resourceId: " + identifier2);
        }
        if (identifier2 > 0) {
            iArr[1] = context.getResources().getDimensionPixelSize(identifier2);
        }
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "xiaomiGetNotchSize width: " + iArr[0] + " height:" + iArr[1]);
        }
        return iArr;
    }

    @TargetApi(17)
    private static boolean xiaomiHasNotchInScreen(Context context) {
        int i3;
        try {
            i3 = Settings.Global.getInt(context.getContentResolver(), "force_black", 0);
        } catch (Throwable th5) {
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "xiaomiHasNotchInScreen crash: ", th5);
            }
        }
        if (i3 == 1) {
            if (QMLog.isColorLevel()) {
                QMLog.i(TAG, "xiaomiHasNotchInScreen closed: " + i3);
            }
            return false;
        }
        int systemPropertyForXiaomi = getSystemPropertyForXiaomi("ro.miui.notch", 0);
        if (QMLog.isColorLevel()) {
            QMLog.i(TAG, "xiaomiHasNotchInScreen isNotch: " + systemPropertyForXiaomi);
        }
        if (systemPropertyForXiaomi != 1) {
            return false;
        }
        return true;
    }
}
