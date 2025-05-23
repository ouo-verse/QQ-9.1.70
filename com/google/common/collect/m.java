package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.ConcurrentMap;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class m<K, V> extends n<K, V> implements ConcurrentMap<K, V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.n, com.google.common.collect.o
    public abstract ConcurrentMap<K, V> delegate();

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V putIfAbsent(K k3, V v3) {
        return delegate().putIfAbsent(k3, v3);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean remove(Object obj, Object obj2) {
        return delegate().remove(obj, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public V replace(K k3, V v3) {
        return delegate().replace(k3, v3);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    @CanIgnoreReturnValue
    public boolean replace(K k3, V v3, V v16) {
        return delegate().replace(k3, v3, v16);
    }
}
