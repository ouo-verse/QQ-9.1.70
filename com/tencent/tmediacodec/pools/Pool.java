package com.tencent.tmediacodec.pools;

import android.support.annotation.Nullable;

/* loaded from: classes26.dex */
public interface Pool<T, Y> {
    void clear();

    boolean isEmpty();

    boolean isFull();

    @Nullable
    T obtain(Y y16);

    void put(T t16);

    void remove(T t16);
}
