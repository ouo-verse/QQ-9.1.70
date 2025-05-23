package com.tencent.upload.utils.pool;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface Future<T> {
    void cancel();

    T get();

    boolean isCancelled();

    boolean isDone();

    void waitDone();
}
