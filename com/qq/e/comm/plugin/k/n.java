package com.qq.e.comm.plugin.k;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.qq.e.comm.plugin.router.PublicApi;
import com.qq.e.comm.plugin.router.PublicApiHelper;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;

/* compiled from: P */
/* loaded from: classes3.dex */
public class n {
    public static int a(Context context) {
        if (context == null || !com.qq.e.comm.plugin.j.c.a("splashFixNotch", 1, 1)) {
            return 0;
        }
        if (h(context)) {
            return ak.a(context, 27);
        }
        if (g(context)) {
            return 80;
        }
        if (i(context)) {
            return j(context)[1];
        }
        if (!l(context) && !b() && !m(context)) {
            if (a()) {
                return 121;
            }
            if (!(context instanceof Activity)) {
                return 0;
            }
            Activity activity = (Activity) context;
            if (activity.getWindow() == null || activity.getWindow().getDecorView() == null) {
                return 0;
            }
            return a(activity.getWindow().getDecorView());
        }
        return k(context);
    }

    private static boolean b() {
        return "SM-F9000".equals(((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getBuildModel());
    }

    public static int c(Context context) {
        if (context != null && context.getResources() != null && context.getResources().getDisplayMetrics() != null) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
        GDTLogger.e("getScreenWidth error");
        return Integer.MIN_VALUE;
    }

    public static int d(Context context) {
        if (context != null && context.getResources() != null && context.getResources().getDisplayMetrics() != null) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        GDTLogger.e("getScreenHeight error");
        return Integer.MIN_VALUE;
    }

    public static int e(Context context) {
        if (context != null && context.getResources() != null && context.getResources().getDisplayMetrics() != null) {
            int i3 = context.getResources().getDisplayMetrics().widthPixels;
            int i16 = context.getResources().getDisplayMetrics().heightPixels;
            if (i3 > i16) {
                return i16;
            }
            return i3;
        }
        return Integer.MIN_VALUE;
    }

    public static int f(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("status_bar_height", "dimen", "android"));
        } catch (Throwable th5) {
            th5.printStackTrace();
            return 0;
        }
    }

    private static boolean g(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    private static boolean h(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
        } catch (Throwable th5) {
            GDTLogger.e("hasNotchInVivo", th5);
            return false;
        }
    }

    private static boolean i(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException unused) {
            GDTLogger.e("hasNotchInScreen ClassNotFoundException");
            return false;
        } catch (NoSuchMethodException unused2) {
            GDTLogger.e("hasNotchInScreen NoSuchMethodException");
            return false;
        } catch (Exception unused3) {
            GDTLogger.e("hasNotchInScreen Exception");
            return false;
        }
    }

    private static int[] j(Context context) {
        int[] iArr = {0, 0};
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return (int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
        } catch (ClassNotFoundException unused) {
            GDTLogger.e("getNotchSize ClassNotFoundException");
            return iArr;
        } catch (NoSuchMethodException unused2) {
            GDTLogger.e("getNotchSize NoSuchMethodException");
            return iArr;
        } catch (Exception unused3) {
            GDTLogger.e("getNotchSize Exception");
            return iArr;
        }
    }

    private static int k(Context context) {
        int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return context.getResources().getDimensionPixelSize(identifier);
        }
        return 0;
    }

    private static boolean l(Context context) {
        String str = "0";
        try {
            Class<?> loadClass = context.getClassLoader().loadClass(TPFromApkLibraryLoader.ANDROID_OS_SYSTEM_PROPERTIES_CLASS_NAME);
            str = (String) loadClass.getMethod("get", String.class, String.class).invoke(loadClass, "ro.miui.notch", "0");
        } catch (IllegalArgumentException | Exception unused) {
        }
        if (str != null && str.equals("1")) {
            return true;
        }
        return false;
    }

    private static boolean m(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("smartisanos.api.DisplayUtilsSmt");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 1)).booleanValue();
        } catch (Exception e16) {
            GDTLogger.e("hasNotchInSmartisan", e16);
            return false;
        }
    }

    public static int b(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics.heightPixels;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return ak.c(context);
        }
    }

    private static int a(View view) {
        Object invoke;
        try {
            invoke = view.getClass().getMethod("getRootWindowInsets", new Class[0]).invoke(view, new Object[0]);
        } catch (Exception e16) {
            GDTLogger.e("hasNotchPixel", e16);
        }
        if (invoke == null) {
            return 0;
        }
        Class<?> cls = invoke.getClass();
        Object invoke2 = cls.getMethod("getDisplayCutout", new Class[0]).invoke(cls, new Object[0]);
        if (invoke2 == null) {
            return 0;
        }
        Class<?> cls2 = invoke2.getClass();
        Object invoke3 = cls2.getMethod("getSafeInsetTop", new Class[0]).invoke(cls2, new Object[0]);
        if (invoke3 != null) {
            return ((Integer) invoke3).intValue();
        }
        return 0;
    }

    private static boolean a() {
        return "FS8010".equals(((PublicApi.DeviceInfoApi) PublicApiHelper.getModuleApi(PublicApi.DeviceInfoApi.class)).getBuildModel());
    }

    public static int a(Context context, int i3, int i16) {
        if (i3 != 0) {
            return Double.valueOf(((i16 * 1.0d) * e(context)) / i3).intValue();
        }
        return 0;
    }
}
