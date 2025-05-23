package com.tencent.qqmusic.mediaplayer;

import java.lang.Thread;

/* compiled from: P */
/* loaded from: classes23.dex */
public interface QMThreadExecutor {
    void execute(Runnable runnable, Thread.UncaughtExceptionHandler uncaughtExceptionHandler);
}
