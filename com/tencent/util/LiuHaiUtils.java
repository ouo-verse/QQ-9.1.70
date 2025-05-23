package com.tencent.util;

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
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.richmediabrowser.config.LiuHaiWhiteListConfProcessor;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes27.dex */
public class LiuHaiUtils {
    static IPatchRedirector $redirector_ = null;
    private static final int ANDROID_O_API_LIMIT = 26;
    private static final int ANDROID_P_API_LIMIT = 27;
    public static int BOTTOM_HEIGHT = 0;
    public static final int BOTTOM_HEIGHT_LH;
    private static final int FLAG_NOTCH_SUPPORT = 65536;
    public static final int LAYOUT_IN_DISPLAY_CUTOUT_MODE_ALWAYS = 1;
    public static final int LAYOUT_IN_DISPLAY_CUTOUT_MODE_DEFAULT = 0;
    public static final int LAYOUT_IN_DISPLAY_CUTOUT_MODE_NEVER = 2;
    public static final int LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES = 1;
    private static String[] LIUHAI_LIST = null;
    private static String[] MANUFACTURER = null;
    public static final int NOTCH_IN_SCREEN_VOIO = 32;
    public static final int ROUNDED_IN_SCREEN_VOIO = 8;
    private static final String TAG = "LiuHaiUtils";
    public static boolean hasInitHasNotch = false;
    private static boolean isInitedLiuhai = false;
    public static boolean mHasInitHasNotch = false;
    public static boolean mHasNotch = false;
    public static int mNotchHeight = 0;
    public static int sCenterOffset = 0;
    public static boolean sEnableNotchOK = false;
    private static final boolean sForceCenter_16_9 = true;
    public static boolean sHasNotch;
    private static boolean sHasNotchWrapper;
    public static boolean sIsIrregularScreen;
    public static int sNotchHeight;
    public static final ArrayList<String> sNotchWhiteList;
    public static int sScreenHeight;
    public static int sScreenWidth;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42885);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        sNotchWhiteList = arrayList;
        arrayList.add("SHARP_FS8010".toLowerCase());
        isInitedLiuhai = false;
        sHasNotchWrapper = false;
        LIUHAI_LIST = new String[]{"PAAM00", "Lenovo L78011", "Pixel 3 XL", "SM-G9750", "N5207", "V1932A", "V1986A", "SM-G9910"};
        MANUFACTURER = new String[]{"HUAWEI", "OPPO", "VIVO", "XIAOMI"};
        sHasNotch = false;
        sEnableNotchOK = false;
        sNotchHeight = 0;
        hasInitHasNotch = false;
        sScreenHeight = 0;
        sScreenWidth = 0;
        sCenterOffset = 0;
        sIsIrregularScreen = false;
        BOTTOM_HEIGHT = 0;
        BOTTOM_HEIGHT_LH = ViewUtils.dip2px(66.0f);
        mHasInitHasNotch = false;
        mHasNotch = false;
        mNotchHeight = 0;
    }

    public LiuHaiUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static int LiuHaiTopBarHeight() {
        return mNotchHeight;
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
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "enableHuaWeiNotch true");
                }
                return true;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 1, "enableHuaWeiNotch Exception", e16);
                }
                return false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "enableHuaWeiNotch invalid param");
        }
        return false;
    }

    private static boolean enableMeizuNotch(Activity activity) {
        try {
            View decorView = activity.getWindow().getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 128);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "enableMeizuNotch true");
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "enableMeizuNotch Exception", e16);
                return false;
            }
            return false;
        }
    }

    public static boolean enableNotch(Activity activity) {
        int i3 = Build.VERSION.SDK_INT;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "enableNotch apiVersion: " + i3);
        }
        if (i3 > 27) {
            return enableNotchInScreen_AndroidP(activity);
        }
        return enableNotchInScreen_AndroidO(activity);
    }

    private static boolean enableNotchInScreen(Activity activity) {
        int i3 = Build.VERSION.SDK_INT;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "enableNotchInScreen apiVersion: " + i3);
        }
        return true;
    }

    private static boolean enableNotchInScreen_AndroidO(Activity activity) {
        String str = "" + Build.MANUFACTURER;
        if (str.equalsIgnoreCase("HUAWEI")) {
            return enableHuaWeiNotch(activity);
        }
        if (str.equalsIgnoreCase("OPPO")) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "enableNotchInScreen_AndroidO OPPO=true");
            }
            return true;
        }
        if (str.equalsIgnoreCase("VIVO")) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "enableNotchInScreen_AndroidO VIVO=true");
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
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "enableNotchInScreen_AndroidP true");
            }
            return true;
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "enableNotchInScreen_AndroidP Exception");
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
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "enableXiaoMiNotch true");
            }
            return true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "enableXiaoMiNotch Exception", e16);
            }
            return false;
        }
    }

    public static int getNotchInScreenHeight(Activity activity) {
        int i3 = Build.VERSION.SDK_INT;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "getNotchInScreenHeight apiVersion: " + i3);
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
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "getNotchInScreenHeight manufacturer:" + str + " height:" + i16 + " width:" + i3 + " status:" + statusBarHeight);
        }
        return Math.max(i16, statusBarHeight);
    }

    public static int getNotchInScreenHeight_AndroidP(Activity activity) {
        Object invoke;
        int statusBarHeight = getStatusBarHeight(activity);
        View decorView = activity.getWindow().getDecorView();
        if (decorView == null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "getNotchInScreenHeight_AndroidP decorView=null ");
            }
            return statusBarHeight;
        }
        try {
            invoke = decorView.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(decorView, new Object[0]);
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "getNotchInScreenHeight_AndroidP Exception");
            }
        }
        if (invoke == null) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "getNotchInScreenHeight_AndroidP getRootWindowInsets inserts=null ");
            }
            return statusBarHeight;
        }
        Object invoke2 = invoke.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(invoke, new Object[0]);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "getNotchInScreenHeight_AndroidP getDisplayCutout cutOut=" + invoke2);
        }
        if (invoke2 != null) {
            int intValue = ((Integer) invoke2.getClass().getMethod("getSafeInsetTop", new Class[0]).invoke(invoke2, new Object[0])).intValue();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "getNotchInScreenHeight_AndroidP top:" + intValue);
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
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "getRealDisplay manufacturer:" + Build.MANUFACTURER + " version:" + i3 + " width:" + displayMetrics.widthPixels + " height:" + displayMetrics.heightPixels);
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
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "getSystemPropertyForXiaomi() Exception=" + e16.getMessage());
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
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "hasNotchInScreen version: " + i3 + " " + sb6);
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
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "hasNotchInScreen manufacturer = " + str + " ,brand = " + Build.BRAND + " ,model = " + DeviceInfoMonitor.getModel());
        }
        if (!z16 && (LiuHaiWhiteListConfProcessor.b().c(str, Build.BRAND, DeviceInfoMonitor.getModel()) || isLiuHaiModel())) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "hasNotchInScreen haveNotch: " + z16);
        }
        return z16;
    }

    public static boolean hasNotchInScreenByVersion(Activity activity) {
        int i3 = Build.VERSION.SDK_INT;
        String str = "" + Build.MANUFACTURER;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "hasNotchInScreenByVersion version: " + i3 + " " + str);
        }
        if (i3 > 27) {
            return hasNotchInScreen_AndroidP(activity);
        }
        if (i3 >= 26) {
            return hasNotchInScreen_AndroidO(activity);
        }
        return false;
    }

    public static boolean hasNotchInScreenWrapper(Activity activity) {
        if (!isInitedLiuhai) {
            sHasNotchWrapper = hasNotchInScreenByVersion(activity);
            isInitedLiuhai = true;
        }
        return sHasNotchWrapper;
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
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "hasNotchInScreen_AndroidP decorView=null");
            }
            return false;
        }
        try {
            Object invoke = decorView.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(decorView, new Object[0]);
            if (invoke == null) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "hasNotchInScreen_AndroidP getRootWindowInsets inserts=null");
                }
                return false;
            }
            if (invoke.getClass().getMethod("getDisplayCutout", new Class[0]).invoke(invoke, new Object[0]) != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "hasNotchInScreen_AndroidP getDisplayCutout  exists:" + z16);
            }
            return z16;
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "hasNotchInScreen_AndroidP Exception");
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
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "hwGetNotchSize ret=" + iArr);
                return iArr;
            }
            return iArr;
        } catch (ClassNotFoundException unused4) {
            iArr2 = iArr;
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "hwGetNotchSize ClassNotFoundException");
            }
            return iArr2;
        } catch (NoSuchMethodException unused5) {
            iArr2 = iArr;
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "hwGetNotchSize NoSuchMethodException");
            }
            return iArr2;
        } catch (Exception unused6) {
            iArr2 = iArr;
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "hasNotchInScreen Exception");
            }
            return iArr2;
        }
    }

    private static boolean hwHasNotchInScreen(Context context) {
        boolean z16 = false;
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            z16 = ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "hwHasNotchInScreen ret=" + z16);
            }
        } catch (ClassNotFoundException unused) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "hwHasNotchInScreen ClassNotFoundException");
            }
        } catch (NoSuchMethodException unused2) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "hwHasNotchInScreen NoSuchMethodException");
            }
        } catch (Exception unused3) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "hwHasNotchInScreen Exception");
            }
        }
        return z16;
    }

    public static void initLiuHaiBarHeight(Activity activity) {
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "initLiuHaiBarHeight manufacturer:" + Build.MANUFACTURER + " mHasInitHasNotch:" + mHasInitHasNotch + " mHasNotch:" + mHasNotch + " mNotchHeight:" + mNotchHeight);
        }
        if (!mHasInitHasNotch) {
            mHasNotch = false;
            try {
                mHasNotch = hasNotchInScreen(activity);
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 1, "initLiuHaiProperty manufacturer:" + Build.MANUFACTURER, th5);
                }
            }
            if (mHasNotch) {
                mNotchHeight = getNotchInScreenHeight(activity);
            }
            mHasInitHasNotch = true;
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "initLiuHaiBarHeight[after] manufacturer:" + Build.MANUFACTURER + " mHasInitHasNotch:" + mHasInitHasNotch + " mHasNotch:" + mHasNotch + " mNotchHeight:" + mNotchHeight);
        }
    }

    public static void initLiuHaiProperty(Activity activity) {
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "initLiuHaiProperty manufacturer:" + Build.MANUFACTURER + " hasInitHasNotch:" + hasInitHasNotch + " sHasNotch:" + sHasNotch + " sEnableNotchOK:" + sEnableNotchOK + " sNotchHeight:" + sNotchHeight);
        }
        if (!hasInitHasNotch) {
            sScreenHeight = ViewUtils.getScreenHeight();
            sScreenWidth = ViewUtils.getScreenWidth();
            sHasNotch = false;
            try {
                sHasNotch = hasNotchInScreen(activity);
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 1, "initLiuHaiProperty manufacturer:" + Build.MANUFACTURER, th5);
                }
            }
            if (sHasNotch) {
                sNotchHeight = getNotchInScreenHeight(activity);
            }
            hasInitHasNotch = true;
        }
        sEnableNotchOK = false;
        if (sHasNotch) {
            sEnableNotchOK = enableNotchInScreen(activity);
            if (sNotchHeight <= 0) {
                sEnableNotchOK = false;
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 1, "initLiuHaiProperty[after] manufacturer:" + Build.MANUFACTURER + " hasInitHasNotch:" + hasInitHasNotch + " sHasNotch:" + sHasNotch + " sEnableNotchOK:" + sEnableNotchOK + " sNotchHeight:" + sNotchHeight);
        }
    }

    public static boolean initLiuHaiScreenUI_Common(View view, View view2, int i3) {
        if (view2 == null) {
            return false;
        }
        if (!isLiuHaiUseValid()) {
            if (view != null) {
                view.setVisibility(8);
            }
            view2.setVisibility(8);
            return false;
        }
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.height = sNotchHeight;
            view.setLayoutParams(layoutParams);
            if (view.getVisibility() != 0) {
                view.setVisibility(0);
            }
        }
        int screenWidth = ViewUtils.getScreenWidth();
        int screenHeight = ViewUtils.getScreenHeight();
        int i16 = (int) ((screenWidth / 9.0f) * 16.0f);
        int i17 = (screenHeight - i16) - sNotchHeight;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "initLiuHaiScreenUI_Common manufacturer:" + Build.MANUFACTURER + " version:" + Build.VERSION.SDK_INT + " remainedPixel:" + i17 + " srcHeight:" + screenHeight + " sNotchHeight:" + sNotchHeight + " BOTTOM_HEIGHT_LH: " + BOTTOM_HEIGHT_LH + " surfaceMaxHeight:" + i16);
        }
        int i18 = BOTTOM_HEIGHT_LH;
        if (i17 > i18) {
            int i19 = i17 - i3;
            int i26 = (int) (i18 * 1.2f);
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "initLiuHaiScreenUI_Common manufacturer:" + Build.MANUFACTURER + " limitMaxBottom:" + i26 + " remainedPixel:" + i19 + " sForceCenter_16_9:true");
            }
            if (i19 > i26) {
                int i27 = (i19 - i18) / 2;
                sCenterOffset = i27;
                if (view != null) {
                    ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
                    layoutParams2.height = sNotchHeight + i27;
                    view.setLayoutParams(layoutParams2);
                }
                i19 = i27 + i18;
            }
            ViewGroup.LayoutParams layoutParams3 = view2.getLayoutParams();
            layoutParams3.height = i19;
            view2.setLayoutParams(layoutParams3);
            BOTTOM_HEIGHT = i19;
            if (view2.getVisibility() != 0) {
                view2.setVisibility(0);
            }
        } else {
            int abs = Math.abs(i17 - i18);
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "initLiuHaiScreenUI_Common manufacturer:" + Build.MANUFACTURER + " sIsIrregularScreen:" + sIsIrregularScreen + " remainedPixel:" + i17 + " diffPixels: " + abs);
            }
            if (abs < 5) {
                ViewGroup.LayoutParams layoutParams4 = view2.getLayoutParams();
                layoutParams4.height = i17;
                view2.setLayoutParams(layoutParams4);
                BOTTOM_HEIGHT = i17;
                if (view2.getVisibility() != 0) {
                    view2.setVisibility(0);
                }
            } else {
                if (sIsIrregularScreen) {
                    view2.setVisibility(8);
                    return false;
                }
                ViewGroup.LayoutParams layoutParams5 = view2.getLayoutParams();
                layoutParams5.height = i18;
                view2.setLayoutParams(layoutParams5);
                BOTTOM_HEIGHT = i18;
                if (view2.getVisibility() != 0) {
                    view2.setVisibility(0);
                }
            }
        }
        return true;
    }

    public static boolean isHuaWeiFolderMobile() {
        String upperCase = DeviceInfoMonitor.getModel().toUpperCase();
        if (TextUtils.isEmpty(upperCase) || !Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI)) {
            return false;
        }
        if (!upperCase.contains("RLI-AN00") && !upperCase.contains("RLI-N29") && !upperCase.contains("TAH-AN00") && !upperCase.contains("TAH-N29") && !upperCase.contains("unknownRLl") && !upperCase.contains("HWTAH")) {
            return false;
        }
        return true;
    }

    public static boolean isInNotchWhiteList() {
        if (sNotchWhiteList.contains((Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel()).toLowerCase())) {
            return true;
        }
        return false;
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

    public static boolean isLiuHaiUseValid() {
        if (sHasNotch && sEnableNotchOK && sNotchHeight > 0) {
            return true;
        }
        return false;
    }

    private static boolean isNoneSupportedPhone() {
        String str = "" + Build.MANUFACTURER;
        if (Build.VERSION.SDK_INT > 27) {
            return true;
        }
        for (String str2 : MANUFACTURER) {
            if (str.equalsIgnoreCase(str2)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isSamsungFolderMobile() {
        String upperCase = DeviceInfoMonitor.getModel().toUpperCase();
        if (TextUtils.isEmpty(upperCase) || !Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_SANXING) || !upperCase.contains("SM-F9000")) {
            return false;
        }
        return true;
    }

    public static boolean needCloseFullScreen() {
        if (sHasNotch) {
            return true;
        }
        return false;
    }

    public static boolean needShowLiuHaiTopBar() {
        if (mHasNotch && mNotchHeight > 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int[] oppoGetNotchSize(Context context) {
        String str;
        Method method;
        try {
            method = SystemProperties.class.getMethod("get", String.class);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "oppoGetNotchSize mProperty exp ", th5);
            }
        }
        if (method != null) {
            method.setAccessible(true);
            Object invoke = method.invoke(null, "ro.oppo.screen.heteromorphism");
            if (invoke instanceof String) {
                str = (String) invoke;
                if (!TextUtils.isEmpty(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 1, "oppoGetNotchSize mProperty empty");
                    }
                    return null;
                }
                String[] split = str.split(":");
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 1, "oppoGetNotchSize mProperty values=" + split);
                }
                if (split.length >= 2) {
                    String[] split2 = split[0].split(",");
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 1, "oppoGetNotchSize mProperty values[0] size=" + split2);
                    }
                    if (split2.length < 2) {
                        return null;
                    }
                    try {
                        int intValue = Integer.valueOf(split2[0]).intValue();
                        int intValue2 = Integer.valueOf(split2[1]).intValue();
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 1, "oppoGetNotchSize mProperty values[0] left=" + intValue + " top=" + intValue2);
                        }
                        String[] split3 = split[1].split(",");
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 1, "oppoGetNotchSize mProperty values[1] size=" + split3);
                        }
                        if (split3.length < 2) {
                            return null;
                        }
                        try {
                            int intValue3 = Integer.valueOf(split3[0]).intValue();
                            int intValue4 = Integer.valueOf(split3[1]).intValue();
                            if (QLog.isColorLevel()) {
                                QLog.i(TAG, 1, "oppoGetNotchSize mProperty values[1] right=" + intValue3 + " bottom=" + intValue4);
                            }
                            return new int[]{intValue3 - intValue, intValue4 - intValue2};
                        } catch (NumberFormatException e16) {
                            if (QLog.isColorLevel()) {
                                QLog.i(TAG, 1, "oppoGetNotchSize values[1]=" + split[1], e16);
                            }
                            return null;
                        }
                    } catch (NumberFormatException e17) {
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 1, "oppoGetNotchSize values[0]=" + split[0], e17);
                        }
                    }
                }
                return null;
            }
        }
        str = null;
        if (!TextUtils.isEmpty(str)) {
        }
    }

    private static boolean oppoHasNotchInScreen(Context context) {
        if (DeviceInfoMonitor.getModel().equals("PAAM00")) {
            return true;
        }
        boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "oppoHasNotchInScreen exits:" + hasSystemFeature);
        }
        return hasSystemFeature;
    }

    public static void resetAllLiuHaiStatus() {
        sHasNotch = false;
        sEnableNotchOK = false;
        sNotchHeight = 0;
        hasInitHasNotch = false;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "resetAllLiuHaiStatus!");
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

    public static boolean setLpEnableNotch(WindowManager.LayoutParams layoutParams) {
        int i3 = Build.VERSION.SDK_INT;
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "enableNotch apiVersion: " + i3);
        }
        if (i3 > 27) {
            return setLpEnableNotchInScreen_AndroidP(layoutParams);
        }
        return setLpEnableNotchInScreen_AndroidO(layoutParams);
    }

    private static boolean setLpEnableNotchInScreen_AndroidO(WindowManager.LayoutParams layoutParams) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "color note androidO notch screen compat");
            return true;
        }
        return true;
    }

    private static boolean setLpEnableNotchInScreen_AndroidP(WindowManager.LayoutParams layoutParams) {
        try {
            Field field = layoutParams.getClass().getField("layoutInDisplayCutoutMode");
            field.setAccessible(true);
            field.setInt(layoutParams, 1);
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "enableNotchInScreen_AndroidP true");
            }
            return true;
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "enableNotchInScreen_AndroidP Exception");
                return false;
            }
            return false;
        }
    }

    public static boolean vivoHasNotchInScreen(Context context) {
        boolean z16 = false;
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            z16 = ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "vivoHasNotchInScreen ret=" + z16);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 1, "vivoHasNotchInScreen Exception", e16);
            }
        }
        return z16;
    }

    private static int[] xiaomiGetNotchSize(Context context) {
        int[] iArr = {0, 0};
        int identifier = context.getResources().getIdentifier("notch_width", "dimen", "android");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "xiaomiGetNotchSize [notch_width]resourceId: " + identifier);
        }
        if (identifier > 0) {
            iArr[0] = context.getResources().getDimensionPixelSize(identifier);
        }
        int identifier2 = context.getResources().getIdentifier("notch_height", "dimen", "android");
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "xiaomiGetNotchSize [notch_height]resourceId: " + identifier2);
        }
        if (identifier2 > 0) {
            iArr[1] = context.getResources().getDimensionPixelSize(identifier2);
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "xiaomiGetNotchSize width: " + iArr[0] + " height:" + iArr[1]);
        }
        return iArr;
    }

    @TargetApi(17)
    private static boolean xiaomiHasNotchInScreen(Context context) {
        int i3;
        try {
            i3 = Settings.Global.getInt(context.getContentResolver(), "force_black", 0);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "xiaomiHasNotchInScreen crash: ", th5);
            }
        }
        if (i3 == 1) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "xiaomiHasNotchInScreen closed: " + i3);
            }
            return false;
        }
        int systemPropertyForXiaomi = getSystemPropertyForXiaomi("ro.miui.notch", 0);
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 1, "xiaomiHasNotchInScreen isNotch: " + systemPropertyForXiaomi);
        }
        if (systemPropertyForXiaomi != 1) {
            return false;
        }
        return true;
    }
}
