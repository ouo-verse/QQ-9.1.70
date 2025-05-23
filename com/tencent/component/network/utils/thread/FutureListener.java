package com.tencent.component.network.utils.thread;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface FutureListener<T> {
    void onFutureBegin(Future<T> future);

    void onFutureDone(Future<T> future);
}
