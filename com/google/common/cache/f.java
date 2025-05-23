package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ExecutionException;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public interface f<K, V> extends c<K, V>, com.google.common.base.d<K, V> {
    @Override // com.google.common.base.d
    @Deprecated
    V apply(K k3);

    V get(K k3) throws ExecutionException;

    ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException;

    V getUnchecked(K k3);

    void refresh(K k3);
}
