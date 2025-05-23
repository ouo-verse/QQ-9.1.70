package com.tencent.theme;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface k {
    void execute(Runnable runnable);

    void reportError(Throwable th5, String str);

    void reportLoadOverTime(String str, long j3, int i3);

    void reportResInfo(String str, int i3, String str2, String str3, String str4);

    void runOnUIThread(Runnable runnable);

    boolean switchOn(String str, boolean z16);
}
