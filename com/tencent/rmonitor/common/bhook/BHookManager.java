package com.tencent.rmonitor.common.bhook;

/* compiled from: P */
/* loaded from: classes25.dex */
public class BHookManager {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f365464a;

    static {
        try {
            System.loadLibrary("rmonitor_base");
            f365464a = true;
        } catch (Throwable unused) {
            f365464a = false;
        }
    }

    public static int a() {
        if (f365464a) {
            return getSigLongJmpNumberNative();
        }
        return 0;
    }

    private static native int getSigLongJmpNumberNative();
}
