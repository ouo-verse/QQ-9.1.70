package com.tencent.oskplayer.util;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface QLog {
    public static final int DEBUG = 3;
    public static final int ERROR = 6;
    public static final int INFO = 4;
    public static final int VERBOSE = 2;
    public static final int WARN = 5;

    int d(String str, String str2);

    int d(String str, String str2, Throwable th5);

    int e(String str, String str2);

    int e(String str, String str2, Throwable th5);

    int i(String str, String str2);

    int i(String str, String str2, Throwable th5);

    int v(String str, String str2);

    int v(String str, String str2, Throwable th5);

    int w(String str, String str2);

    int w(String str, String str2, Throwable th5);

    int w(String str, Throwable th5);
}
