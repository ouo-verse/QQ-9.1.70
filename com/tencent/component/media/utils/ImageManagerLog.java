package com.tencent.component.media.utils;

import com.tencent.component.media.ImageManagerEnv;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ImageManagerLog {
    private static final String TAG = "QZoneImageManager";

    ImageManagerLog() {
    }

    public static void d(String str, String str2) {
        ImageManagerEnv.getLogger().d(TAG, "[" + str + "] " + str2);
    }

    public static void e(String str, String str2) {
        ImageManagerEnv.getLogger().e(TAG, "[" + str + "] " + str2);
    }

    public static void fatal(String str, Throwable th5) {
        ImageManagerEnv.getLogger().fatal(TAG, "[" + str + "] " + th5.toString(), th5);
    }

    public static void i(String str, String str2) {
        ImageManagerEnv.getLogger().i(TAG, "[" + str + "] " + str2);
    }

    public static void w(String str, String str2) {
        ImageManagerEnv.getLogger().w(TAG, "[" + str + "] " + str2);
    }
}
