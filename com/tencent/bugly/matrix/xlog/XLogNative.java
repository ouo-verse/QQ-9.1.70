package com.tencent.bugly.matrix.xlog;

import android.support.annotation.Keep;

/* compiled from: P */
/* loaded from: classes5.dex */
public class XLogNative {
    public static void setXLogger(String str) {
        setXLoggerNative(str);
    }

    @Keep
    private static native void setXLoggerNative(String str);
}
