package com.tencent.qqmini.sdk.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import androidx.annotation.NonNull;
import com.tencent.qqmini.sdk.annotation.MiniKeep;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.OSUtils;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;
import java.lang.reflect.Method;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public class ImmersiveUtils {
    private static final String ISMIUI = "1";
    public static final int OPPO_NOTCH_HEIGHT = 80;
    public static final int SHARP_NOTCH_HEIGHT = 121;
    public static final String TAG = "ImmersiveUtils";
    private static float density = -1.0f;
    public static int notchHeight = -1;
    private static int screenHeight = -1;
    private static int screenWidth = -1;
    public static int statusHeight = -1;

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

    public static void enterFullScreenMode(Activity activity) {
        if (ViewUtils.isActivityInvalid(activity)) {
            return;
        }
        activity.getWindow().getDecorView().getSystemUiVisibility();
        activity.getWindow().getDecorView().setSystemUiVisibility(5894 | 2048);
    }

    public static float getDensity() {
        init();
        return density;
    }

    public static JSONObject getDisplayCutoutSafeArea(Activity activity) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        JSONObject jSONObject = new JSONObject();
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            Rect displayCutoutSafeInsets = getDisplayCutoutSafeInsets(activity.getWindow().getDecorView());
            displayCutoutSafeInsets.top = getNotchHeight(activity, activity);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            activity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            i3 = displayCutoutSafeInsets.left;
            i18 = displayCutoutSafeInsets.top;
            i19 = displayCutoutSafeInsets.right;
            i16 = displayCutoutSafeInsets.bottom;
            i26 = (displayMetrics.widthPixels - i3) - i19;
            i17 = (displayMetrics.heightPixels - i18) - i16;
        } else {
            QMLog.w(TAG, "getDisplayCutoutSafeArea use all zero values");
            i3 = 0;
            i16 = 0;
            i17 = 0;
            i18 = 0;
            i19 = 0;
            i26 = 0;
        }
        try {
            jSONObject.put("left", i3);
            jSONObject.put("top", i18);
            jSONObject.put("right", i19);
            jSONObject.put("bottom", i16);
            jSONObject.put("width", i26);
            jSONObject.put("height", i17);
        } catch (JSONException e16) {
            QMLog.e(TAG, "getDisplayCutoutSafeArea", e16);
        }
        return jSONObject;
    }

    @NonNull
    public static Rect getDisplayCutoutSafeInsets(View view) {
        Object callSpecifiedMethod;
        Rect rect = new Rect();
        QMLog.d(TAG, "Build.VERSION.SDK_INT:" + Build.VERSION.SDK_INT);
        try {
            Object callSpecifiedMethod2 = JarReflectUtil.callSpecifiedMethod(view, "getRootWindowInsets", false, null, new Object[0]);
            QMLog.d(TAG, "insets:" + callSpecifiedMethod2);
            callSpecifiedMethod = JarReflectUtil.callSpecifiedMethod(callSpecifiedMethod2, "getDisplayCutout", false, null, new Object[0]);
        } catch (Exception e16) {
            QMLog.e(TAG, "" + e16);
        }
        if (callSpecifiedMethod == null) {
            QMLog.d(TAG, "displayCutout == null");
            return rect;
        }
        Object callSpecifiedMethod3 = JarReflectUtil.callSpecifiedMethod(callSpecifiedMethod, "getSafeInsetTop", false, null, new Object[0]);
        Object callSpecifiedMethod4 = JarReflectUtil.callSpecifiedMethod(callSpecifiedMethod, "getSafeInsetBottom", false, null, new Object[0]);
        Object callSpecifiedMethod5 = JarReflectUtil.callSpecifiedMethod(callSpecifiedMethod, "getSafeInsetLeft", false, null, new Object[0]);
        Object callSpecifiedMethod6 = JarReflectUtil.callSpecifiedMethod(callSpecifiedMethod, "getSafeInsetRight", false, null, new Object[0]);
        QMLog.d(TAG, "safeInsetTop:" + callSpecifiedMethod3 + " safeInsetBottom:" + callSpecifiedMethod4 + " safeInsetLeft:" + callSpecifiedMethod5 + " safeInsetRight:" + callSpecifiedMethod6);
        if (callSpecifiedMethod5 instanceof Integer) {
            rect.left = ((Integer) callSpecifiedMethod5).intValue();
        }
        if (callSpecifiedMethod4 instanceof Integer) {
            rect.bottom = ((Integer) callSpecifiedMethod4).intValue();
        }
        if (callSpecifiedMethod6 instanceof Integer) {
            rect.right = ((Integer) callSpecifiedMethod6).intValue();
        }
        if (callSpecifiedMethod3 instanceof Integer) {
            rect.top = ((Integer) callSpecifiedMethod3).intValue();
            return rect;
        }
        return rect;
    }

    private static void getGoogleApi(Activity activity) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            notchHeight = getDisplayCutoutSafeInsets(activity.getWindow().getDecorView()).top;
        }
    }

    public static int getNotchHeight(Context context, Activity activity) {
        if (notchHeight != -1) {
            QMLog.d(TAG, "has notchHeight:" + notchHeight);
            return notchHeight;
        }
        QMLog.d(TAG, "getNotchHeight: phone model=" + DeviceInfoUtil.getPhoneModel());
        if (hasNotchInVivo(context)) {
            notchHeight = DisplayUtil.dip2px(context, 27.0f);
        } else if (hasNotchInOppo(context)) {
            if (Build.VERSION.SDK_INT >= 28) {
                getGoogleApi(activity);
            }
            int i3 = notchHeight;
            if (i3 == 0 || i3 == -1) {
                notchHeight = 80;
            }
        } else if (hasNotchInHuaWei(context)) {
            notchHeight = getNotchSizeInHuaWei(context)[1];
        } else if (!hasNotchInXiaoMi(context) && !hasNotchInSmartisan(context) && !isSpecialDevices()) {
            if (isSharpS2()) {
                notchHeight = 121;
            } else {
                getGoogleApi(activity);
            }
        } else {
            notchHeight = getNotchSizeInStatusBar(context);
        }
        return notchHeight;
    }

    public static int[] getNotchSizeInHuaWei(Context context) {
        int[] iArr = {0, 0};
        try {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                return (int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
            } catch (ClassNotFoundException unused) {
                QMLog.e(TAG, "getNotchSize ClassNotFoundException");
                return iArr;
            } catch (NoSuchMethodException unused2) {
                QMLog.e(TAG, "getNotchSize NoSuchMethodException");
                return iArr;
            } catch (Exception unused3) {
                QMLog.e(TAG, "getNotchSize Exception");
                return iArr;
            }
        } catch (Throwable unused4) {
            return iArr;
        }
    }

    private static int getNotchSizeInStatusBar(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public static Class[] getParamsClass(Class... clsArr) {
        Class[] clsArr2 = new Class[clsArr.length];
        for (int i3 = 0; i3 < clsArr.length; i3++) {
            clsArr2[i3] = clsArr[i3];
        }
        return clsArr2;
    }

    public static String getReflectString(Context context, String str, String str2) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(TPFromApkLibraryLoader.ANDROID_OS_SYSTEM_PROPERTIES_CLASS_NAME);
            return (String) loadClass.getMethod("get", String.class, String.class).invoke(loadClass, new String(str), new String(str2));
        } catch (IllegalArgumentException | Exception unused) {
            return str2;
        }
    }

    public static int getScreenHeight() {
        init();
        return screenHeight;
    }

    public static int getScreenWidth() {
        init();
        return screenWidth;
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
            float density2 = ViewUtils.getDensity();
            if (QMLog.isColorLevel()) {
                QMLog.d("systembar", "getStatusBarHeight org=" + i3 + ", sys density=" + density2 + ", cur density=" + context.getResources().getDisplayMetrics().density);
            }
            float f16 = density2 / context.getResources().getDisplayMetrics().density;
            if (i3 <= 0) {
                if (f16 <= 0.0f) {
                    f16 = 1.0f;
                }
                ceil = ViewUtils.dpToPx(f16 * 25.0f);
            } else {
                float f17 = i3;
                if (f16 <= 0.0f) {
                    f16 = 1.0f;
                }
                ceil = (int) Math.ceil((f17 * f16) + 0.5f);
            }
            statusHeight = ceil;
        }
        return statusHeight;
    }

    public static boolean hasNotchInHuaWei(Context context) {
        try {
            try {
                try {
                    Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                    return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
                } catch (ClassNotFoundException unused) {
                    QMLog.e(TAG, "hasNotchInScreen ClassNotFoundException");
                    return false;
                } catch (NoSuchMethodException unused2) {
                    QMLog.e(TAG, "hasNotchInScreen NoSuchMethodException");
                    return false;
                }
            } catch (Exception unused3) {
                QMLog.e(TAG, "hasNotchInScreen Exception");
                return false;
            }
        } catch (Throwable unused4) {
            return false;
        }
    }

    public static boolean hasNotchInOppo(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static boolean hasNotchInSmartisan(Context context) {
        try {
            Object callSpecifiedStaticMethod = JarReflectUtil.callSpecifiedStaticMethod("smartisanos.api.DisplayUtilsSmt", "isFeatureSupport", false, getParamsClass(Integer.TYPE), 1);
            if (!(callSpecifiedStaticMethod instanceof Boolean)) {
                return false;
            }
            return ((Boolean) callSpecifiedStaticMethod).booleanValue();
        } catch (Exception e16) {
            QMLog.e(TAG, "" + e16);
            return false;
        }
    }

    public static boolean hasNotchInVivo(Context context) {
        try {
            Object callSpecifiedStaticMethod = JarReflectUtil.callSpecifiedStaticMethod("android.util.FtFeature", "isFeatureSupport", false, getParamsClass(Integer.TYPE), 32);
            if (!(callSpecifiedStaticMethod instanceof Boolean)) {
                return false;
            }
            return ((Boolean) callSpecifiedStaticMethod).booleanValue();
        } catch (Exception e16) {
            QMLog.e(TAG, "" + e16);
            return false;
        }
    }

    public static boolean hasNotchInXiaoMi(Context context) {
        String reflectString = getReflectString(context, "ro.miui.notch", "0");
        if (reflectString != null) {
            return reflectString.equals("1");
        }
        return false;
    }

    private static void init() {
        if (density == -1.0f) {
            DisplayMetrics displayMetrics = AppLoaderFactory.g().getContext().getResources().getDisplayMetrics();
            density = displayMetrics.density;
            int i3 = displayMetrics.widthPixels;
            int i16 = displayMetrics.heightPixels;
            if (i3 < i16) {
                screenWidth = i3;
                screenHeight = i16;
            } else {
                screenHeight = i3;
                screenWidth = i16;
            }
        }
    }

    private static boolean isLenovo() {
        return DeviceInfoUtil.getPhoneModel().endsWith("L78011");
    }

    private static boolean isOnePlus() {
        return "GM1910".equals(DeviceInfoUtil.getPhoneModel());
    }

    private static boolean isSMF9000() {
        return "SM-F9000".equals(DeviceInfoUtil.getPhoneModel());
    }

    private static boolean isSharpS2() {
        return "FS8010".equals(DeviceInfoUtil.getPhoneModel());
    }

    private static boolean isSpecialDevices() {
        if (!isLenovo() && !isOnePlus() && !isSMF9000() && !"Pixel 3 XL".equals(DeviceInfoUtil.getPhoneModel()) && !"NX606J".equals(DeviceInfoUtil.getPhoneModel())) {
            return false;
        }
        return true;
    }

    private static boolean processMIUI(Window window, boolean z16) {
        compatHighMIUI(window, z16);
        return true;
    }

    public static boolean setStatusTextColor(boolean z16, Window window) {
        if (OSUtils.isFlymeOS()) {
            return DisplayUtil.setStatusBarDarkModeForFlyme(window, z16);
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
}
