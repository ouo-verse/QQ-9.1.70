package com.tencent.smtt.sdk;

import java.io.File;
import java.io.InputStream;
import java.util.Map;

/* compiled from: P */
@Deprecated
/* loaded from: classes23.dex */
public final class CacheManager {
    @Deprecated
    public static boolean cacheDisabled() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return ((Boolean) a16.c().c()).booleanValue();
        }
        Object a17 = com.tencent.smtt.utils.k.a("android.webkit.CacheManager", "cacheDisabled");
        if (a17 == null) {
            return false;
        }
        return ((Boolean) a17).booleanValue();
    }

    public static Object getCacheFile(String str, Map<String, String> map) {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return a16.c().g();
        }
        try {
            return com.tencent.smtt.utils.k.a(Class.forName("android.webkit.CacheManager"), "getCacheFile", (Class<?>[]) new Class[]{String.class, Map.class}, str, map);
        } catch (Exception unused) {
            return null;
        }
    }

    @Deprecated
    public static File getCacheFileBaseDir() {
        p a16 = p.a();
        if (a16 != null && a16.b()) {
            return (File) a16.c().g();
        }
        return (File) com.tencent.smtt.utils.k.a("android.webkit.CacheManager", "getCacheFileBaseDir");
    }

    public static InputStream getCacheFile(String str, boolean z16) {
        p a16 = p.a();
        if (a16 == null || !a16.b()) {
            return null;
        }
        return a16.c().a(str, z16);
    }
}
