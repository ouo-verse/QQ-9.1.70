package com.tencent.rmonitor.common.logger;

/* compiled from: P */
/* loaded from: classes25.dex */
public class NativeLogger {
    private static int sLogLevel = LogState.WARN.getValue();

    public static int getLogLevel() {
        return sLogLevel;
    }

    public static int initLogLevel(int i3) {
        sLogLevel = i3;
        return i3;
    }
}
