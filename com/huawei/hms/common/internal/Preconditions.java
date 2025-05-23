package com.huawei.hms.common.internal;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes2.dex */
public final class Preconditions {
    Preconditions() {
        throw new AssertionError("Cannot use constructor to make a new instance");
    }

    private static boolean a() {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            return true;
        }
        return false;
    }

    public static void checkArgument(boolean z16, Object obj) {
        if (z16) {
        } else {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void checkHandlerThread(Handler handler) {
        checkHandlerThread(handler, "Must be called on the handler thread");
    }

    public static void checkMainThread(String str) {
        if (a()) {
        } else {
            throw new IllegalStateException(str);
        }
    }

    public static void checkNotMainThread() {
        if (!a()) {
        } else {
            throw new IllegalStateException("Must not be called on the main application thread");
        }
    }

    public static <O> O checkNotNull(O o16) {
        if (o16 != null) {
            return o16;
        }
        throw new NullPointerException("must not refer to a null object");
    }

    public static void checkState(boolean z16, Object obj) {
        if (z16) {
        } else {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkHandlerThread(Handler handler, String str) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException(str);
        }
    }

    public static <O> O checkNotNull(O o16, Object obj) {
        if (o16 != null) {
            return o16;
        }
        throw new NullPointerException(String.valueOf(obj));
    }
}
