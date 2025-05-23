package com.tribe.async.log;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface IQLog {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    void a(String str, String str2);

    void a(String str, String str2, Throwable th5);

    void d(String str, String str2);

    void d(String str, String str2, Throwable th5);

    void d(String str, String str2, Object... objArr);

    void e(String str, String str2);

    void e(String str, String str2, Throwable th5);

    void i(String str, String str2);

    void i(String str, String str2, Throwable th5);

    void i(String str, String str2, Object... objArr);

    void v(String str, String str2);

    void v(String str, String str2, Throwable th5);

    void w(String str, String str2);

    void w(String str, String str2, Throwable th5);

    void w(String str, String str2, Object... objArr);

    void w(String str, Throwable th5);
}
