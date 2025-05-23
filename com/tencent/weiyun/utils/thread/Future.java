package com.tencent.weiyun.utils.thread;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface Future<T> {
    void cancel();

    T get();

    boolean isCancelled();

    boolean isDone();

    void waitDone();
}
