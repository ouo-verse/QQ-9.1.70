package com.xiaomi.push;

import com.tencent.thumbplayer.libloader.TPFromApkLibraryLoader;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ih {
    public static String a(String str, String str2) {
        try {
            return (String) ii.c(null, TPFromApkLibraryLoader.ANDROID_OS_SYSTEM_PROPERTIES_CLASS_NAME).getMethod("get", String.class, String.class).invoke(null, str, str2);
        } catch (Exception e16) {
            jz4.c.m("SystemProperties.get: " + e16);
            return str2;
        }
    }
}
