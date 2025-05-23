package com.tencent.ams.xsad.rewarded.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f71864a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14913);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f71864a = 0;
        }
    }

    private static String a() {
        return Build.MANUFACTURER;
    }

    private static int[] b(Context context) {
        int[] iArr = {0, 0};
        try {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                return (int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
            } catch (ClassNotFoundException unused) {
                Log.e("Notch", "getNotchSizeAtHuawei ClassNotFoundException");
                return iArr;
            } catch (NoSuchMethodException unused2) {
                Log.e("Notch", "getNotchSizeAtHuawei NoSuchMethodException");
                return iArr;
            } catch (Exception unused3) {
                Log.e("Notch", "getNotchSizeAtHuawei Exception");
                return iArr;
            }
        } catch (Throwable unused4) {
            return iArr;
        }
    }

    private static int c(Activity activity) {
        if (activity != null && activity.getWindow() != null && activity.getWindow().getDecorView() != null) {
            Rect rect = new Rect();
            activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
            return rect.top;
        }
        return 0;
    }

    @SuppressLint({"PrivateApi"})
    private static int d(Activity activity) {
        int i3;
        int i16 = f71864a;
        if (i16 > 0) {
            return i16;
        }
        try {
            int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                i3 = activity.getResources().getDimensionPixelSize(identifier);
            } else {
                i3 = 0;
            }
            f71864a = i3;
        } catch (Exception unused) {
        }
        if (f71864a <= 0) {
            f71864a = c(activity);
        }
        return f71864a;
    }

    private static boolean e() {
        try {
            if (((Integer) SystemProperties.class.getMethod("getInt", String.class, String.class).invoke(SystemProperties.class, "ro.miui.notch", "-1")).intValue() != 1) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    private static boolean f(Context context) {
        try {
            try {
                try {
                    Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                    return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
                } catch (ClassNotFoundException unused) {
                    Log.e("Notch", "hasNotchAtHuawei ClassNotFoundException");
                    return false;
                } catch (NoSuchMethodException unused2) {
                    Log.e("Notch", "hasNotchAtHuawei NoSuchMethodException");
                    return false;
                }
            } catch (Exception unused3) {
                Log.e("Notch", "hasNotchAtHuawei Exception");
                return false;
            }
        } catch (Throwable unused4) {
            return false;
        }
    }

    private static boolean g(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    private static boolean h(Context context) {
        try {
            try {
                try {
                    Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
                    return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
                } catch (ClassNotFoundException unused) {
                    Log.e("Notch", "hasNotchAtVivo ClassNotFoundException");
                    return false;
                } catch (NoSuchMethodException unused2) {
                    Log.e("Notch", "hasNotchAtVivo NoSuchMethodException");
                    return false;
                }
            } catch (Exception unused3) {
                Log.e("Notch", "hasNotchAtVivo Exception");
                return false;
            }
        } catch (Throwable unused4) {
            return false;
        }
    }

    private static boolean i() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI.equalsIgnoreCase(str) || ("Honor".equalsIgnoreCase(str) && (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI.equalsIgnoreCase(a()) || "Honor".equalsIgnoreCase(a()))))) {
            return true;
        }
        return false;
    }

    private static boolean j() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase("oppo")) {
            return true;
        }
        return false;
    }

    private static boolean k() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_VIVO)) {
            return true;
        }
        return false;
    }

    private static boolean l() {
        try {
            if (TextUtils.isEmpty((String) SystemProperties.class.getDeclaredMethod("get", String.class).invoke(SystemProperties.class, "ro.miui.ui.version.name"))) {
                return false;
            }
            if (!"xiaomi".equalsIgnoreCase(a())) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public static int m(Activity activity) {
        if (Build.VERSION.SDK_INT < 24) {
            return 0;
        }
        if (k() && h(activity)) {
            return d(activity);
        }
        if (i() && f(activity)) {
            return b(activity)[1];
        }
        if (j() && g(activity)) {
            return 80;
        }
        if (!l() || !e()) {
            return 0;
        }
        return d(activity);
    }
}
