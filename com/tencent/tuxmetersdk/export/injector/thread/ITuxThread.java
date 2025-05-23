package com.tencent.tuxmetersdk.export.injector.thread;

import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface ITuxThread extends ITuxHandlerThread {
    void execWorkTask(Runnable runnable);

    ExecutorService getWorkExecutor();
}
