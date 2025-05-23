package com.huawei.hms.utils;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Checker {
    Checker() {
    }

    public static void assertHandlerThread(Handler handler) {
        assertHandlerThread(handler, "Must be called on the handler thread");
    }

    public static void assertNonEmpty(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException("Given String is empty or null");
        }
    }

    public static <T> T assertNonNull(T t16) {
        if (t16 != null) {
            return t16;
        }
        throw new NullPointerException("Null reference");
    }

    public static void assertNotUiThread(String str) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
        } else {
            throw new IllegalStateException(str);
        }
    }

    public static void assertUiThread(String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
        } else {
            throw new IllegalStateException(str);
        }
    }

    public static String checkNonEmpty(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    public static <T> T checkNonNull(T t16) {
        if (t16 != null) {
            return t16;
        }
        throw new NullPointerException("Null reference");
    }

    public static int checkNonZero(int i3) {
        if (i3 != 0) {
            return i3;
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }

    public static long checkNotZero(long j3) {
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalArgumentException("Given Long is zero");
    }

    public static void assertHandlerThread(Handler handler, String str) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static <T> T assertNonNull(T t16, String str) {
        if (t16 != null) {
            return t16;
        }
        throw new NullPointerException(String.valueOf(str));
    }

    public static <T> T checkNonNull(T t16, String str) {
        if (t16 != null) {
            return t16;
        }
        throw new NullPointerException(String.valueOf(str));
    }

    public static int checkNonZero(int i3, String str) {
        if (i3 != 0) {
            return i3;
        }
        throw new IllegalArgumentException(String.valueOf(str));
    }

    public static long checkNotZero(long j3, String str) {
        if (j3 != 0) {
            return j3;
        }
        throw new IllegalArgumentException(String.valueOf(str));
    }

    public static void assertNonEmpty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalStateException(String.valueOf(str2));
        }
    }

    public static String checkNonEmpty(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(str2));
        }
        return str;
    }
}
