package com.tencent.opentelemetry.api.logging;

/* loaded from: classes22.dex */
public interface IPrinterLogger {
    public static final String DEBUG = "DEBUG";
    public static final String EVENT = "EVENT";
    public static final String INFO = "INFO";
    public static final String WARN = "WARN";

    void d(String str, String str2);

    void e(String str, String str2);

    void e(String str, String str2, Throwable th5);

    void i(String str, String str2);

    boolean isColorLevel();

    boolean isDebug();

    void w(String str, String str2);

    void w(String str, String str2, Throwable th5);
}
