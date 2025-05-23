package com.airbnb.lottie.utils;

import com.airbnb.lottie.LottieLogger;

/* compiled from: P */
/* loaded from: classes.dex */
public class Logger {
    private static LottieLogger INSTANCE = new LogcatLogger();

    public static void debug(String str) {
        INSTANCE.debug(str);
    }

    public static void error(String str, Throwable th5) {
        INSTANCE.error(str, th5);
    }

    public static void setInstance(LottieLogger lottieLogger) {
        INSTANCE = lottieLogger;
    }

    public static void warning(String str) {
        INSTANCE.warning(str);
    }

    public static void debug(String str, Throwable th5) {
        INSTANCE.debug(str, th5);
    }

    public static void warning(String str, Throwable th5) {
        INSTANCE.warning(str, th5);
    }
}
