package com.tencent.qqlive.tvkplayer.tools.log;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface ITVKLogger {
    void debug(String str, String str2, Object... objArr);

    void debug(String str, Object... objArr);

    void error(String str, String str2, Object... objArr);

    void error(String str, Object... objArr);

    String getTag();

    void info(String str, String str2, Object... objArr);

    void info(String str, Object... objArr);

    void printException(Throwable th5);

    void verbose(String str, String str2, Object... objArr);

    void verbose(String str, Object... objArr);

    void warn(String str, String str2, Object... objArr);

    void warn(String str, Object... objArr);
}
