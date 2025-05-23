package com.xiaomi.push;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ii {

    /* renamed from: a, reason: collision with root package name */
    private static Context f389413a;

    /* renamed from: b, reason: collision with root package name */
    private static String f389414b;

    public static int a() {
        try {
            Class<?> c16 = c(null, "miui.os.Build");
            if (c16.getField("IS_STABLE_VERSION").getBoolean(null)) {
                return 3;
            }
            if (c16.getField("IS_DEVELOPMENT_VERSION").getBoolean(null)) {
                return 2;
            }
            return 1;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static Context b() {
        return f389413a;
    }

    public static Class<?> c(Context context, String str) {
        boolean z16;
        if (str != null && str.trim().length() != 0) {
            if (context != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && Build.VERSION.SDK_INT >= 29) {
                try {
                    return context.getClassLoader().loadClass(str);
                } catch (Throwable unused) {
                }
            }
            try {
                return Class.forName(str);
            } catch (Throwable th5) {
                jz4.c.m(String.format("loadClass fail hasContext= %s, errMsg = %s", Boolean.valueOf(z16), th5.getLocalizedMessage()));
                throw new ClassNotFoundException("loadClass fail ", th5);
            }
        }
        throw new ClassNotFoundException("class is empty");
    }

    public static synchronized String d() {
        synchronized (ii.class) {
            String str = f389414b;
            if (str != null) {
                return str;
            }
            String str2 = Build.VERSION.INCREMENTAL;
            if (a() <= 0) {
                String h16 = h();
                if (TextUtils.isEmpty(h16)) {
                    h16 = j();
                    if (TextUtils.isEmpty(h16)) {
                        h16 = k();
                        if (TextUtils.isEmpty(h16)) {
                            str2 = String.valueOf(ih.a("ro.product.brand", "Android") + "_" + str2);
                        }
                    }
                }
                str2 = h16;
            }
            f389414b = str2;
            return str2;
        }
    }

    public static void e(Context context) {
        f389413a = context.getApplicationContext();
    }

    public static boolean f() {
        return TextUtils.equals((String) y.g(TPFromApkLibraryLoader.ANDROID_OS_SYSTEM_PROPERTIES_CLASS_NAME, "get", "sys.boot_completed"), "1");
    }

    public static boolean g(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) == 0) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            jz4.c.q(e16);
            return false;
        }
    }

    private static String h() {
        String a16 = ih.a("ro.build.version.emui", "");
        f389414b = a16;
        return a16;
    }

    public static boolean i() {
        try {
            return c(null, "miui.os.Build").getField("IS_GLOBAL_BUILD").getBoolean(Boolean.FALSE);
        } catch (ClassNotFoundException unused) {
            jz4.c.B("miui.os.Build ClassNotFound");
            return false;
        } catch (Exception e16) {
            jz4.c.q(e16);
            return false;
        }
    }

    private static String j() {
        String a16 = ih.a("ro.build.version.opporom", "");
        if (!TextUtils.isEmpty(a16) && !a16.startsWith("ColorOS_")) {
            f389414b = "ColorOS_" + a16;
        }
        return f389414b;
    }

    private static String k() {
        String a16 = ih.a("ro.vivo.os.version", "");
        if (!TextUtils.isEmpty(a16) && !a16.startsWith("FuntouchOS_")) {
            f389414b = "FuntouchOS_" + a16;
        }
        return f389414b;
    }
}
