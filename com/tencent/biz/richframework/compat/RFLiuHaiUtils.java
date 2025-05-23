package com.tencent.biz.richframework.compat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RFLiuHaiUtils {
    private static String[] LIUHAI_LIST;
    private static String[] MANUFACTURER;
    public static final ArrayList<String> NOTCH_WHITE_LIST;
    public static boolean mHasInitHasNotch;
    public static boolean mHasNotch;
    public static int mNotchHeight;
    public static boolean sIsIrregularScreen;

    static {
        ArrayList<String> arrayList = new ArrayList<>();
        NOTCH_WHITE_LIST = arrayList;
        arrayList.add("SHARP_FS8010".toLowerCase());
        LIUHAI_LIST = new String[]{"PAAM00", "Lenovo L78011", "Pixel 3 XL", "SM-G9750", "N5207", "V1932A"};
        MANUFACTURER = new String[]{"HUAWEI", "OPPO", "VIVO", "XIAOMI"};
        sIsIrregularScreen = false;
        mHasInitHasNotch = false;
        mHasNotch = false;
        mNotchHeight = 0;
    }

    private static boolean enableHuaWeiNotch(Activity activity) {
        if (activity != null && activity.getWindow() != null) {
            WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
            try {
                Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
                cls.getMethod("addHwFlags", Integer.TYPE).invoke(cls.getConstructor(WindowManager.LayoutParams.class).newInstance(attributes), 65536);
                if (RFWLog.isColorLevel()) {
                    RFWLog.i("LiuHaiUtils", RFWLog.USR, "enableHuaWeiNotch true");
                }
                return true;
            } catch (Exception e16) {
                if (RFWLog.isColorLevel()) {
                    RFWLog.e("LiuHaiUtils", RFWLog.USR, "enableHuaWeiNotch Exception", e16);
                }
                return false;
            }
        }
        if (RFWLog.isColorLevel()) {
            RFWLog.i("LiuHaiUtils", RFWLog.USR, "enableHuaWeiNotch invalid param");
        }
        return false;
    }

    private static boolean enableMeizuNotch(Activity activity) {
        try {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 128);
            if (RFWLog.isColorLevel()) {
                RFWLog.i("LiuHaiUtils", RFWLog.USR, "enableMeizuNotch true");
            }
            return true;
        } catch (Exception e16) {
            if (RFWLog.isColorLevel()) {
                RFWLog.e("LiuHaiUtils", RFWLog.USR, "enableMeizuNotch Exception", e16);
            }
            return false;
        }
    }

    public static boolean enableNotch(Activity activity) {
        int i3 = Build.VERSION.SDK_INT;
        if (RFWLog.isColorLevel()) {
            RFWLog.i("LiuHaiUtils", RFWLog.USR, "enableNotch apiVersion: " + i3);
        }
        if (i3 > 27) {
            return enableNotchInScreen_AndroidP(activity);
        }
        return enableNotchInScreen_AndroidO(activity);
    }

    private static boolean enableNotchInScreen_AndroidO(Activity activity) {
        String str = "" + Build.MANUFACTURER;
        if (str.equalsIgnoreCase("HUAWEI")) {
            return enableHuaWeiNotch(activity);
        }
        if (str.equalsIgnoreCase("OPPO")) {
            if (RFWLog.isColorLevel()) {
                RFWLog.i("LiuHaiUtils", RFWLog.USR, "enableNotchInScreen_AndroidO OPPO=true");
            }
            return true;
        }
        if (str.equalsIgnoreCase("VIVO")) {
            if (RFWLog.isColorLevel()) {
                RFWLog.i("LiuHaiUtils", RFWLog.USR, "enableNotchInScreen_AndroidO VIVO=true");
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
            if (RFWLog.isColorLevel()) {
                RFWLog.i("LiuHaiUtils", RFWLog.USR, "enableNotchInScreen_AndroidP true");
            }
            return true;
        } catch (Exception unused) {
            if (RFWLog.isColorLevel()) {
                RFWLog.e("LiuHaiUtils", RFWLog.USR, "enableNotchInScreen_AndroidP Exception");
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
            if (RFWLog.isColorLevel()) {
                RFWLog.i("LiuHaiUtils", RFWLog.USR, "enableXiaoMiNotch true");
            }
            return true;
        } catch (Exception e16) {
            if (RFWLog.isColorLevel()) {
                RFWLog.e("LiuHaiUtils", RFWLog.USR, "enableXiaoMiNotch Exception", e16);
            }
            return false;
        }
    }

    public static int getNotchInScreenHeight(Activity activity) {
        int i3 = Build.VERSION.SDK_INT;
        if (RFWLog.isColorLevel()) {
            RFWLog.i("LiuHaiUtils", RFWLog.USR, "getNotchInScreenHeight apiVersion: " + i3);
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
        int i16;
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
        if (iArr != null) {
            i3 = iArr[0];
        } else {
            i3 = 0;
        }
        if (iArr != null) {
            i16 = iArr[1];
        } else {
            i16 = 0;
        }
        int statusBarHeight = getStatusBarHeight(context);
        if (RFWLog.isColorLevel()) {
            RFWLog.e("LiuHaiUtils", RFWLog.USR, "getNotchInScreenHeight manufacturer:" + str + " height:" + i16 + " width:" + i3 + " status:" + statusBarHeight);
        }
        return Math.max(i16, statusBarHeight);
    }

    public static int getNotchInScreenHeight_AndroidP(Activity activity) {
        Object invoke;
        int statusBarHeight = getStatusBarHeight(activity);
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null) {
            if (RFWLog.isColorLevel()) {
                RFWLog.i("LiuHaiUtils", RFWLog.USR, "getNotchInScreenHeight_AndroidP decorView=null ");
            }
            return statusBarHeight;
        }
        try {
            invoke = decorView.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(decorView, new Object[0]);
        } catch (Exception unused) {
            if (RFWLog.isColorLevel()) {
                RFWLog.e("LiuHaiUtils", RFWLog.USR, "getNotchInScreenHeight_AndroidP Exception");
            }
        }
        if (invoke == null) {
            if (RFWLog.isColorLevel()) {
                RFWLog.i("LiuHaiUtils", RFWLog.USR, "getNotchInScreenHeight_AndroidP getRootWindowInsets inserts=null ");
            }
            return statusBarHeight;
        }
        Object invoke2 = invoke.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(invoke, new Object[0]);
        if (RFWLog.isColorLevel()) {
            RFWLog.i("LiuHaiUtils", RFWLog.USR, "getNotchInScreenHeight_AndroidP getDisplayCutout cutOut=" + invoke2);
        }
        if (invoke2 != null) {
            int intValue = ((Integer) invoke2.getClass().getMethod("getSafeInsetTop", new Class[0]).invoke(invoke2, new Object[0])).intValue();
            if (RFWLog.isColorLevel()) {
                RFWLog.i("LiuHaiUtils", RFWLog.USR, "getNotchInScreenHeight_AndroidP top:" + intValue);
            }
            return intValue;
        }
        return statusBarHeight;
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
            if (RFWLog.isColorLevel()) {
                RFWLog.d("LiuHaiUtils", RFWLog.CLR, "getSystemPropertyForXiaomi() Exception=" + e16.getMessage());
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
        if (RFWLog.isColorLevel()) {
            RFWLog.i("LiuHaiUtils", RFWLog.USR, "hasNotchInScreen version: " + i3 + " " + sb6);
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
        if (RFWLog.isColorLevel()) {
            RFWLog.i("LiuHaiUtils", RFWLog.USR, "hasNotchInScreen manufacturer = " + str + " ,brand = " + Build.BRAND + " ,model = " + DeviceInfoMonitor.getModel());
        }
        if (!z16 && isLiuHaiModel()) {
            z16 = true;
        }
        if (RFWLog.isColorLevel()) {
            RFWLog.i("LiuHaiUtils", RFWLog.USR, "hasNotchInScreen haveNotch: " + z16);
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
            if (RFWLog.isColorLevel()) {
                RFWLog.i("LiuHaiUtils", RFWLog.USR, "hasNotchInScreen_AndroidP decorView=null");
            }
            return false;
        }
        try {
            Object invoke = decorView.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(decorView, new Object[0]);
            if (invoke == null) {
                if (RFWLog.isColorLevel()) {
                    RFWLog.i("LiuHaiUtils", RFWLog.USR, "hasNotchInScreen_AndroidP getRootWindowInsets inserts=null");
                }
                return false;
            }
            if (invoke.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(invoke, new Object[0]) != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (RFWLog.isColorLevel()) {
                RFWLog.i("LiuHaiUtils", RFWLog.USR, "hasNotchInScreen_AndroidP getDisplayCutout  exists:" + z16);
            }
            return z16;
        } catch (Exception unused) {
            if (RFWLog.isColorLevel()) {
                RFWLog.e("LiuHaiUtils", RFWLog.USR, "hasNotchInScreen_AndroidP Exception");
            }
            return false;
        }
    }

    private static int[] hwGetNotchSize(Context context) {
        int[] iArr = {0, 0};
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            int[] iArr2 = (int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
            try {
                if (RFWLog.isColorLevel()) {
                    RFWLog.i("LiuHaiUtils", RFWLog.USR, "hwGetNotchSize ret=" + iArr2);
                    return iArr2;
                }
                return iArr2;
            } catch (ClassNotFoundException unused) {
                iArr = iArr2;
                if (RFWLog.isColorLevel()) {
                    RFWLog.e("LiuHaiUtils", RFWLog.USR, "hwGetNotchSize ClassNotFoundException");
                }
                return iArr;
            } catch (NoSuchMethodException unused2) {
                iArr = iArr2;
                if (RFWLog.isColorLevel()) {
                    RFWLog.e("LiuHaiUtils", RFWLog.USR, "hwGetNotchSize NoSuchMethodException");
                }
                return iArr;
            } catch (Exception unused3) {
                iArr = iArr2;
                if (RFWLog.isColorLevel()) {
                    RFWLog.e("LiuHaiUtils", RFWLog.USR, "hasNotchInScreen Exception");
                }
                return iArr;
            }
        } catch (ClassNotFoundException unused4) {
        } catch (NoSuchMethodException unused5) {
        } catch (Exception unused6) {
        }
    }

    private static boolean hwHasNotchInScreen(Context context) {
        boolean z16;
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            z16 = ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException unused) {
            z16 = false;
        } catch (NoSuchMethodException unused2) {
            z16 = false;
        } catch (Exception unused3) {
            z16 = false;
        }
        try {
            if (RFWLog.isColorLevel()) {
                RFWLog.i("LiuHaiUtils", RFWLog.USR, "hwHasNotchInScreen ret=" + z16);
            }
        } catch (ClassNotFoundException unused4) {
            if (RFWLog.isColorLevel()) {
                RFWLog.e("LiuHaiUtils", RFWLog.USR, "hwHasNotchInScreen ClassNotFoundException");
            }
            return z16;
        } catch (NoSuchMethodException unused5) {
            if (RFWLog.isColorLevel()) {
                RFWLog.e("LiuHaiUtils", RFWLog.USR, "hwHasNotchInScreen NoSuchMethodException");
            }
            return z16;
        } catch (Exception unused6) {
            if (RFWLog.isColorLevel()) {
                RFWLog.e("LiuHaiUtils", RFWLog.USR, "hwHasNotchInScreen Exception");
            }
            return z16;
        }
        return z16;
    }

    public static void initLiuHaiBarHeight(Activity activity) {
        if (RFWLog.isColorLevel()) {
            RFWLog.e("LiuHaiUtils", RFWLog.USR, "initLiuHaiBarHeight manufacturer:" + Build.MANUFACTURER + " mHasInitHasNotch:" + mHasInitHasNotch + " mHasNotch:" + mHasNotch + " mNotchHeight:" + mNotchHeight);
        }
        if (!mHasInitHasNotch) {
            mHasNotch = false;
            try {
                mHasNotch = hasNotchInScreen(activity);
            } catch (Throwable th5) {
                if (RFWLog.isColorLevel()) {
                    RFWLog.e("LiuHaiUtils", RFWLog.USR, "initLiuHaiProperty manufacturer:" + Build.MANUFACTURER, th5);
                }
            }
            if (mHasNotch) {
                mNotchHeight = getNotchInScreenHeight(activity);
            }
            mHasInitHasNotch = true;
        }
        if (RFWLog.isColorLevel()) {
            RFWLog.e("LiuHaiUtils", RFWLog.USR, "initLiuHaiBarHeight[after] manufacturer:" + Build.MANUFACTURER + " mHasInitHasNotch:" + mHasInitHasNotch + " mHasNotch:" + mHasNotch + " mNotchHeight:" + mNotchHeight);
        }
    }

    private static boolean isLiuHaiModel() {
        String model = DeviceInfoMonitor.getModel();
        if (!TextUtils.isEmpty(model)) {
            for (String str : LIUHAI_LIST) {
                if (model.equalsIgnoreCase(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int liuHaiTopBarHeight() {
        return mNotchHeight;
    }

    private static int[] oppoGetNotchSize(Context context) {
        if (TextUtils.isEmpty(null)) {
            if (RFWLog.isColorLevel()) {
                RFWLog.i("LiuHaiUtils", RFWLog.USR, "oppoGetNotchSize mProperty empty");
            }
            return null;
        }
        throw null;
    }

    private static boolean oppoHasNotchInScreen(Context context) {
        if (DeviceInfoMonitor.getModel().equals("PAAM00")) {
            return true;
        }
        if (context == null) {
            return false;
        }
        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        if (RFWLog.isColorLevel()) {
            RFWLog.i("LiuHaiUtils", RFWLog.USR, "oppoHasNotchInScreen exits:" + hasSystemFeature);
        }
        return hasSystemFeature;
    }

    public static boolean vivoHasNotchInScreen(Context context) {
        boolean z16;
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            z16 = ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (Exception e16) {
            e = e16;
            z16 = false;
        }
        try {
            if (RFWLog.isColorLevel()) {
                RFWLog.i("LiuHaiUtils", RFWLog.USR, "vivoHasNotchInScreen ret=" + z16);
            }
        } catch (Exception e17) {
            e = e17;
            if (RFWLog.isColorLevel()) {
                RFWLog.e("LiuHaiUtils", RFWLog.USR, "vivoHasNotchInScreen Exception", e);
            }
            return z16;
        }
        return z16;
    }

    private static int[] xiaomiGetNotchSize(Context context) {
        int[] iArr = {0, 0};
        int identifier = context.getResources().getIdentifier("notch_width", "dimen", "android");
        if (RFWLog.isColorLevel()) {
            RFWLog.i("LiuHaiUtils", RFWLog.USR, "xiaomiGetNotchSize [notch_width]resourceId: " + identifier);
        }
        if (identifier > 0) {
            iArr[0] = context.getResources().getDimensionPixelSize(identifier);
        }
        int identifier2 = context.getResources().getIdentifier("notch_height", "dimen", "android");
        if (RFWLog.isColorLevel()) {
            RFWLog.i("LiuHaiUtils", RFWLog.USR, "xiaomiGetNotchSize [notch_height]resourceId: " + identifier2);
        }
        if (identifier2 > 0) {
            iArr[1] = context.getResources().getDimensionPixelSize(identifier2);
        }
        if (RFWLog.isColorLevel()) {
            RFWLog.i("LiuHaiUtils", RFWLog.USR, "xiaomiGetNotchSize width: " + iArr[0] + " height:" + iArr[1]);
        }
        return iArr;
    }

    @TargetApi(17)
    private static boolean xiaomiHasNotchInScreen(Context context) {
        int i3;
        try {
            i3 = Settings.Global.getInt(context.getContentResolver(), "force_black", 0);
        } catch (Throwable th5) {
            if (RFWLog.isColorLevel()) {
                RFWLog.i("LiuHaiUtils", RFWLog.USR, "xiaomiHasNotchInScreen crash: " + th5.getMessage());
            }
        }
        if (i3 == 1) {
            if (RFWLog.isColorLevel()) {
                RFWLog.i("LiuHaiUtils", RFWLog.USR, "xiaomiHasNotchInScreen closed: " + i3);
            }
            return false;
        }
        int systemPropertyForXiaomi = getSystemPropertyForXiaomi("ro.miui.notch", 0);
        if (RFWLog.isColorLevel()) {
            RFWLog.i("LiuHaiUtils", RFWLog.USR, "xiaomiHasNotchInScreen isNotch: " + systemPropertyForXiaomi);
        }
        if (systemPropertyForXiaomi != 1) {
            return false;
        }
        return true;
    }
}
