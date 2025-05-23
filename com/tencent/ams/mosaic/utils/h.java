package com.tencent.ams.mosaic.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.WindowInsets;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class h {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f71572a;

    /* renamed from: b, reason: collision with root package name */
    private static int f71573b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59232);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f71572a = 0;
            f71573b = 0;
        }
    }

    public static int a(Context context) {
        int i3 = f71572a;
        if (i3 > 0) {
            return i3;
        }
        try {
            return m(context);
        } catch (Throwable th5) {
            f.c("NotchUtils", "getNotchHeight error.", th5);
            return 0;
        }
    }

    private static int[] b(Context context) {
        int[] iArr = {0, 0};
        try {
            try {
                Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                return (int[]) loadClass.getMethod("getNotchSize", new Class[0]).invoke(loadClass, new Object[0]);
            } catch (ClassNotFoundException unused) {
                f.b("NotchUtils", "getNotchSizeAtHuawei ClassNotFoundException");
                return iArr;
            } catch (NoSuchMethodException unused2) {
                f.b("NotchUtils", "getNotchSizeAtHuawei NoSuchMethodException");
                return iArr;
            } catch (Exception unused3) {
                f.b("NotchUtils", "getNotchSizeAtHuawei Exception");
                return iArr;
            }
        } catch (Throwable unused4) {
            return iArr;
        }
    }

    @SuppressLint({"PrivateApi"})
    public static int c(Context context) {
        int i3;
        int i16 = f71573b;
        if (i16 > 0) {
            return i16;
        }
        try {
            int identifier = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                i3 = context.getResources().getDimensionPixelSize(identifier);
            } else {
                i3 = 0;
            }
            f71573b = i3;
        } catch (Exception unused) {
        }
        return f71573b;
    }

    @SuppressLint({"PrivateApi"})
    private static boolean d() {
        try {
            if (((Integer) SystemProperties.class.getMethod("getInt", String.class, String.class).invoke(SystemProperties.class, "ro.miui.notch", "-1")).intValue() != 1) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static boolean e(Context context) {
        try {
            try {
                try {
                    Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
                    return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
                } catch (ClassNotFoundException unused) {
                    f.b("NotchUtils", "hasNotchAtHuawei ClassNotFoundException");
                    return false;
                } catch (NoSuchMethodException unused2) {
                    f.b("NotchUtils", "hasNotchAtHuawei NoSuchMethodException");
                    return false;
                }
            } catch (Exception unused3) {
                f.b("NotchUtils", "hasNotchAtHuawei Exception");
                return false;
            }
        } catch (Throwable unused4) {
            return false;
        }
    }

    private static boolean f(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    @SuppressLint({"PrivateApi"})
    private static boolean g(Context context) {
        try {
            try {
                try {
                    Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
                    return ((Boolean) loadClass.getMethod("isFeatureSupport", Integer.TYPE).invoke(loadClass, 32)).booleanValue();
                } catch (ClassNotFoundException unused) {
                    Log.e("NotchUtils", "hasNotchAtVivo ClassNotFoundException");
                    return false;
                } catch (NoSuchMethodException unused2) {
                    Log.e("NotchUtils", "hasNotchAtVivo NoSuchMethodException");
                    return false;
                }
            } catch (Exception unused3) {
                Log.e("NotchUtils", "hasNotchAtVivo Exception");
                return false;
            }
        } catch (Throwable unused4) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001b, code lost:
    
        r3 = r3.getDisplayCutout();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static boolean h(Context context) {
        DisplayCutout displayCutout;
        List boundingRects;
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        try {
            WindowInsets rootWindowInsets = MosaicUtils.m(context).getWindow().getDecorView().getRootWindowInsets();
            if (rootWindowInsets != null && displayCutout != null) {
                boundingRects = displayCutout.getBoundingRects();
                if (boundingRects.size() <= 0) {
                    return false;
                }
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean i() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str)) {
            if (!CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI.equalsIgnoreCase(str)) {
                if ("Honor".equalsIgnoreCase(str)) {
                    String str2 = Build.MANUFACTURER;
                    if (CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_HUAWEI.equalsIgnoreCase(str2) || "Honor".equalsIgnoreCase(str2)) {
                    }
                }
            }
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
            if (!"xiaomi".equalsIgnoreCase(Build.MANUFACTURER)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static int m(Context context) {
        if (Build.VERSION.SDK_INT < 24) {
            return c(context);
        }
        if (k() && g(context)) {
            f.e("NotchUtils", "obtainNotchHeight, isVivo & hasVivoNotchInScreen");
            return c(context);
        }
        if (i() && e(context)) {
            f.e("NotchUtils", "obtainNotchHeight, isHuaWeiDevice & hasNotchAtHuawei");
            return b(context)[1];
        }
        if (j() && f(context)) {
            f.e("NotchUtils", "obtainNotchHeight, isOPPO & hasOppoNotchInScreen");
            return 80;
        }
        if (l() && d()) {
            f.e("NotchUtils", "obtainNotchHeight, isOPPO & hasMIUINotchInScreen");
            return c(context);
        }
        if (h(context)) {
            f.e("NotchUtils", "obtainNotchHeight, isAndroidPNotchScreen");
            return c(context);
        }
        f.e("NotchUtils", "obtainNotchHeight, default");
        return c(context);
    }
}
