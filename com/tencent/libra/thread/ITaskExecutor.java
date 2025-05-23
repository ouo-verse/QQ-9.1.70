package com.tencent.libra.thread;

/* compiled from: P */
/* loaded from: classes7.dex */
public interface ITaskExecutor {
    void execDecodeTask(Runnable runnable);

    void execDownloadTask(Runnable runnable);

    void removeDecodeTask(Runnable runnable);

    void removeDownloadTask(Runnable runnable);
}
