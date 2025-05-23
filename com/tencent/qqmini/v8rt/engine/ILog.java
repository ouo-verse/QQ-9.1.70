package com.tencent.qqmini.v8rt.engine;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ILog {
    public static final int VCONSOLE_LOG_DEBUG = 100;

    int d(String str, String str2);

    int d(String str, String str2, Throwable th5);

    int e(String str, String str2);

    int e(String str, String str2, Throwable th5);

    int i(String str, String str2);

    int i(String str, String str2, Throwable th5);

    void printNativeLog(int i3, String str, String str2);

    int w(String str, String str2);

    int w(String str, String str2, Throwable th5);
}
