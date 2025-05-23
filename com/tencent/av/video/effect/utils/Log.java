package com.tencent.av.video.effect.utils;

import com.tencent.av.video.effect.QavVideoEffect;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class Log {
    public static void d(String str, Object obj) {
        if (QavVideoEffect.DEBUG_MODE) {
            android.util.Log.d(str, String.valueOf(obj));
        }
    }

    public static void e(String str, String str2) {
        if (QavVideoEffect.DEBUG_MODE) {
            android.util.Log.e(str, str2);
        }
    }

    public static void i(String str, String str2) {
        if (QavVideoEffect.DEBUG_MODE) {
            android.util.Log.i(str, str2);
        }
    }

    public static void v(String str, String str2) {
        if (QavVideoEffect.DEBUG_MODE) {
            android.util.Log.v(str, str2);
        }
    }

    public static void w(String str, String str2) {
        if (QavVideoEffect.DEBUG_MODE) {
            android.util.Log.w(str, str2);
        }
    }

    public static void d(String str, String str2, Throwable th5) {
        if (QavVideoEffect.DEBUG_MODE) {
            android.util.Log.d(str, str2, th5);
        }
    }

    public static void e(String str, String str2, Throwable th5) {
        if (QavVideoEffect.DEBUG_MODE) {
            android.util.Log.e(str, str2, th5);
        }
    }

    public static void i(String str, String str2, Throwable th5) {
        if (QavVideoEffect.DEBUG_MODE) {
            android.util.Log.i(str, str2, th5);
        }
    }

    public static void v(String str, String str2, Throwable th5) {
        if (QavVideoEffect.DEBUG_MODE) {
            android.util.Log.v(str, str2, th5);
        }
    }

    public static void w(String str, String str2, Throwable th5) {
        if (QavVideoEffect.DEBUG_MODE) {
            android.util.Log.w(str, str2, th5);
        }
    }

    public static void w(String str, Throwable th5) {
        if (QavVideoEffect.DEBUG_MODE) {
            android.util.Log.w(str, th5);
        }
    }
}
