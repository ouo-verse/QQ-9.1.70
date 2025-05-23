package com.tencent.oskplayer.support.log;

/* compiled from: P */
/* loaded from: classes22.dex */
public class Logger {
    private static ILogger sLogger;

    public static ILogger g() {
        if (sLogger == null) {
            synchronized (Logger.class) {
                if (sLogger == null) {
                    sLogger = new DefaultLogger();
                }
            }
        }
        return sLogger;
    }

    public static void setLogger(ILogger iLogger) {
        synchronized (Logger.class) {
            sLogger = iLogger;
        }
    }
}
