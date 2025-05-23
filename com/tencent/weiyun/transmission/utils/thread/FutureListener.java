package com.tencent.weiyun.transmission.utils.thread;

/* compiled from: P */
/* loaded from: classes27.dex */
public interface FutureListener<T> {
    void onFutureBegin(Future<T> future);

    void onFutureDone(Future<T> future);
}
