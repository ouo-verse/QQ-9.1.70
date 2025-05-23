package com.tencent.qqmini.sdk.launcher.log;

import com.tencent.qqmini.sdk.annotation.MiniKeep;

/* compiled from: P */
@MiniKeep
/* loaded from: classes23.dex */
public interface Log {
    public static final int ASSERT = 6;
    public static final int DEBUG = 2;
    public static final int ERROR = 5;
    public static final int INFO = 3;
    public static final int VERBOSE = 1;
    public static final int WARN = 4;

    void d(String str, String str2, Throwable th5);

    void e(String str, String str2, Throwable th5);

    int getLogLevel();

    void i(String str, String str2, Throwable th5);

    boolean isColorLevel();

    void w(String str, String str2, Throwable th5);
}
