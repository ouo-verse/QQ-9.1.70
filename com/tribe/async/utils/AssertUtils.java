package com.tribe.async.utils;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AssertUtils {
    private static final boolean DEBUG = true;

    public static void assertTrue(boolean z16) {
        if (!z16) {
            throw new AssertionError();
        }
    }

    public static <T> T checkNotNull(T t16) {
        t16.getClass();
        return t16;
    }

    public static void fail(String str, Object... objArr) {
        if (objArr.length != 0) {
            str = String.format(str, objArr);
        }
        throw new AssertionError(str);
    }

    public static void assertTrue(boolean z16, String str) {
        if (!z16) {
            throw new AssertionError(str);
        }
    }
}
