package com.tencent.rfix.loader.thread;

/* loaded from: classes25.dex */
public interface IRFixThreadPool {

    /* loaded from: classes25.dex */
    public enum ThreadType {
        THREAD_DEFAULT,
        THREAD_NETWORK,
        THREAD_IO
    }

    void execute(Runnable runnable);

    void execute(Runnable runnable, ThreadType threadType);
}
