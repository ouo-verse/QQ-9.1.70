package com.tencent.matrix.xlog;

import androidx.annotation.Keep;

/* compiled from: P */
/* loaded from: classes9.dex */
public class XLogNative {
    public static void a(String str) {
        setXLoggerNative(str);
    }

    @Keep
    private static native void setXLoggerNative(String str);
}
