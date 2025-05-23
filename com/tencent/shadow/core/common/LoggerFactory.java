package com.tencent.shadow.core.common;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class LoggerFactory {
    private static final String TAG = "LoggerFactory";
    private static volatile ILoggerFactory sILoggerFactory;

    public static ILoggerFactory getILoggerFactory() {
        if (sILoggerFactory != null) {
            return sILoggerFactory;
        }
        throw new RuntimeException("\u6ca1\u6709\u627e\u5230 ILoggerFactory \u5b9e\u73b0\uff0c\u8bf7\u5148\u8c03\u7528setILoggerFactory");
    }

    public static final Logger getLogger(Class<?> cls) {
        return getILoggerFactory().getLogger(cls.getName());
    }

    public static void setILoggerFactory(ILoggerFactory iLoggerFactory) {
        if (sILoggerFactory != null) {
            Log.w(TAG, "setILoggerFactory: \u4e0d\u80fd\u91cd\u590d\u521d\u59cb\u5316!");
        } else {
            sILoggerFactory = iLoggerFactory;
        }
    }
}
