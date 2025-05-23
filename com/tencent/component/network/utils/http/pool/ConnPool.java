package com.tencent.component.network.utils.http.pool;

import java.util.concurrent.Future;

/* loaded from: classes5.dex */
public interface ConnPool<T, E> {
    Future<E> lease(T t16, Object obj, FutureCallback<E> futureCallback);

    void release(E e16, boolean z16);
}
