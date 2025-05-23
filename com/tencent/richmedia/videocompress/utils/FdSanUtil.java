package com.tencent.richmedia.videocompress.utils;

import android.os.Build;

/* compiled from: P */
/* loaded from: classes25.dex */
public class FdSanUtil {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f365134a = false;

    private static synchronized boolean a() {
        synchronized (FdSanUtil.class) {
            if (f365134a) {
                return true;
            }
            try {
                System.loadLibrary("native-codec-jni");
                f365134a = true;
                ConvertLog.i("FdSanUtil", 2, "load library success");
            } catch (Exception | UnsatisfiedLinkError e16) {
                ConvertLog.w("FdSanUtil", 1, "load library fail, exc=" + e16);
            }
            return f365134a;
        }
    }

    public static void b(int i3) {
        int i16 = Build.VERSION.SDK_INT;
        if (i16 < 29) {
            ConvertLog.w("FdSanUtil", 1, "[setFdSanErrorLevel] ignore, api-level=" + i16);
            return;
        }
        try {
            if (a()) {
                nativeSetFdSanErrorLevel(i3);
                ConvertLog.i("FdSanUtil", 1, "[setFdSanErrorLevel] success, level=" + i3);
            } else {
                ConvertLog.w("FdSanUtil", 1, "[setFdSanErrorLevel] fail, failed to load library");
            }
        } catch (Throwable th5) {
            ConvertLog.w("FdSanUtil", 1, "[setFdSanErrorLevel] failed, exc=" + th5);
        }
    }

    private static native void nativeSetFdSanErrorLevel(int i3);

    private static native void nativeSimulateFdError();
}
