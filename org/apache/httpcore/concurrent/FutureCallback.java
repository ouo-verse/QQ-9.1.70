package org.apache.httpcore.concurrent;

/* compiled from: P */
/* loaded from: classes29.dex */
public interface FutureCallback<T> {
    void cancelled();

    void completed(T t16);

    void failed(Exception exc);
}
