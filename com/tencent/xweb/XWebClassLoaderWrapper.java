package com.tencent.xweb;

import android.util.Log;
import com.tencent.luggage.wxa.ar.u0;
import com.tencent.luggage.wxa.ar.x0;
import dalvik.system.DexClassLoader;
import java.io.File;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes27.dex */
public class XWebClassLoaderWrapper {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f385022a = false;

    /* renamed from: b, reason: collision with root package name */
    public static int f385023b = -1;

    public static ClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        x0.d("XWebClassLoaderWrapper", String.format("getClassLoader, dexPath:%s, optimizedDirectory:%s, librarySearchPath:%s", str, str2, str3));
        return new DexClassLoader(str, str2, str3, classLoader);
    }

    public static boolean generateOptDex(int i3) {
        try {
            if (getXWebClassLoader(i3) == null) {
                return false;
            }
            return true;
        } catch (Throwable th5) {
            x0.a("XWebClassLoaderWrapper", "generateOptDex error", th5);
            return false;
        }
    }

    public static ClassLoader getChildProcessDexClassLoader(int i3) {
        x0.d("XWebClassLoaderWrapper", "getChildProcessDexClassLoader, apkVersion:" + i3);
        String f16 = u0.f(i3);
        if (!new File(f16).exists()) {
            x0.f("XWebClassLoaderWrapper", "getChildProcessDexClassLoader, apk file not exist");
            return null;
        }
        return new DexClassLoader(f16, u0.b(i3), null, ClassLoader.getSystemClassLoader());
    }

    public static ClassLoader getClassLoader(String str, String str2, String str3) {
        return a(str, str2, str3, ClassLoader.getSystemClassLoader());
    }

    public static ClassLoader getXWebClassLoader() {
        return getXWebClassLoader(XWalkEnvironment.getAvailableVersion());
    }

    public static boolean isApkLoadMode(int i3) {
        x0.d("XWebClassLoaderWrapper", "isApkLoadMode, current version:" + i3);
        if (i3 >= 3000) {
            return true;
        }
        if (i3 <= 0) {
            return false;
        }
        if (!f385022a) {
            f385022a = true;
            f385023b = CommandCfg.getInstance().getCmdAsInt("APK_LOAD_MIN_VER", null, -1);
            x0.d("XWebClassLoaderWrapper", "isApkLoadMode, support apk load min version:" + f385023b);
        }
        if (i3 > f385023b) {
            return true;
        }
        return false;
    }

    public static ClassLoader getXWebClassLoader(int i3) {
        ClassLoader classLoader;
        x0.d("XWebClassLoaderWrapper", "getXWebClassLoader, apkVersion:" + i3);
        long currentTimeMillis = System.currentTimeMillis();
        if (i3 == -1) {
            x0.d("XWebClassLoaderWrapper", "getXWebClassLoader, version invalid");
            return null;
        }
        if (isApkLoadMode(i3)) {
            String e16 = u0.e(i3);
            if (!new File(e16).exists()) {
                x0.f("XWebClassLoaderWrapper", "getXWebClassLoader, apk file not exist");
                return null;
            }
            classLoader = getClassLoader(e16, u0.k(i3), u0.j(i3));
        } else {
            try {
                String c16 = u0.c(i3);
                if (!new File(c16).exists()) {
                    x0.f("XWebClassLoaderWrapper", "getXWebClassLoader, dex file not exist");
                    return null;
                }
                classLoader = getClassLoader(c16, u0.k(i3), u0.j(i3));
            } catch (Throwable th5) {
                x0.a("XWebClassLoaderWrapper", "getXWebClassLoader, error", th5);
                return null;
            }
        }
        x0.f("XWebClassLoaderWrapper", "###### getXWebClassLoader, costTime:" + (System.currentTimeMillis() - currentTimeMillis) + ", stack:" + Log.getStackTraceString(new Exception("please ignore this exception")));
        return classLoader;
    }
}
