package com.huya.huyasdk.api;

/* compiled from: P */
/* loaded from: classes2.dex */
public interface IHYLogger {
    void debug(Object obj, String str);

    void error(Object obj, String str);

    void flushToDisk();

    void info(Object obj, String str);

    boolean isLogLevelEnabled(int i3);

    void uncaughtException(Throwable th5);
}
