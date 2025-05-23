package com.tencent.component.network.module.base.inter;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface Log {
    public static final int ASSERT = 6;
    public static final int DEBUG = 2;
    public static final int ERROR = 5;
    public static final int INFO = 3;
    public static final int VERBOSE = 1;
    public static final int WARN = 4;

    void d(String str, String str2);

    void d(String str, String str2, Throwable th5);

    void e(String str, String str2);

    void e(String str, String str2, Throwable th5);

    int getLogLevel();

    void i(String str, String str2);

    void i(String str, String str2, Throwable th5);

    void w(String str, String str2);

    void w(String str, String str2, Throwable th5);
}
