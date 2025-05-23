package com.tencent.avcore.util;

/* compiled from: P */
/* loaded from: classes3.dex */
public interface IAVLog {
    void d(String str, String str2);

    void e(String str, String str2);

    void e(String str, String str2, Throwable th5);

    long genDebugSeq();

    String getVersion();

    void i(String str, String str2);

    boolean isColorLevel();

    boolean isDebugVersion();

    boolean isDevelopLevel();

    boolean isGrayVersion();

    void printAllUserLog(String str, String str2);

    void printColorLog(String str, String str2);

    void printDebugLog(String str, String str2);

    void printErrorLog(String str, String str2);

    void printInfoLog(String str, String str2);
}
