package org.apache.httpcore.pool;

import java.util.concurrent.Future;
import org.apache.httpcore.concurrent.FutureCallback;

/* loaded from: classes29.dex */
public interface ConnPool<T, E> {
    Future<E> lease(T t16, Object obj, FutureCallback<E> futureCallback);

    void release(E e16, boolean z16);
}
