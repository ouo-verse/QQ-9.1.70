package com.tencent.component.network.utils.http.pool;

/* compiled from: P */
/* loaded from: classes5.dex */
public interface FutureCallback<T> {
    void cancelled();

    void completed(T t16);

    void failed(Exception exc);
}
