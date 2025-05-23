package com.tencent.raft.raftframework.log;

/* compiled from: P */
/* loaded from: classes25.dex */
public interface ILogDelegate {
    void debug(String str, String str2);

    void debug(String str, String str2, Throwable th5);

    void error(String str, String str2);

    void error(String str, String str2, Throwable th5);

    void info(String str, String str2);

    void info(String str, String str2, Throwable th5);

    void warn(String str, String str2);

    void warn(String str, String str2, Throwable th5);
}
