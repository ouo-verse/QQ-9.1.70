package com.tencent.component.network.utils.thread;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface Future<T> {
    void cancel();

    T get();

    boolean isCancelled();

    boolean isDone();

    void waitDone();
}
