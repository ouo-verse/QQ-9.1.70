package com.google.android.exoplayer2.util;

import android.os.Looper;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class Assertions {
    Assertions() {
    }

    public static void checkArgument(boolean z16) {
        if (!z16) {
            throw new IllegalArgumentException();
        }
    }

    public static int checkIndex(int i3, int i16, int i17) {
        if (i3 >= i16 && i3 < i17) {
            return i3;
        }
        throw new IndexOutOfBoundsException();
    }

    public static void checkMainThread() {
        if (Looper.myLooper() == Looper.getMainLooper()) {
        } else {
            throw new IllegalStateException("Not in applications main thread");
        }
    }

    public static String checkNotEmpty(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
        return str;
    }

    public static <T> T checkNotNull(T t16) {
        t16.getClass();
        return t16;
    }

    public static void checkState(boolean z16) {
        if (!z16) {
            throw new IllegalStateException();
        }
    }

    public static void checkArgument(boolean z16, Object obj) {
        if (!z16) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static <T> T checkNotNull(T t16, Object obj) {
        if (t16 != null) {
            return t16;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    public static void checkState(boolean z16, Object obj) {
        if (!z16) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static String checkNotEmpty(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }
}
