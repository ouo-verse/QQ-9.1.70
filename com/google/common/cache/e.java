package com.google.common.cache;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.o;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class e<K, V> extends o implements c<K, V> {
    @Override // com.google.common.cache.c
    public ConcurrentMap<K, V> asMap() {
        return delegate().asMap();
    }

    @Override // com.google.common.cache.c
    public void cleanUp() {
        delegate().cleanUp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.o
    public abstract c<K, V> delegate();

    @Override // com.google.common.cache.c
    public V get(K k3, Callable<? extends V> callable) throws ExecutionException {
        return delegate().get(k3, callable);
    }

    @Override // com.google.common.cache.c
    public ImmutableMap<K, V> getAllPresent(Iterable<?> iterable) {
        return delegate().getAllPresent(iterable);
    }

    @Override // com.google.common.cache.c
    @NullableDecl
    public V getIfPresent(Object obj) {
        return delegate().getIfPresent(obj);
    }

    @Override // com.google.common.cache.c
    public void invalidate(Object obj) {
        delegate().invalidate(obj);
    }

    @Override // com.google.common.cache.c
    public void invalidateAll(Iterable<?> iterable) {
        delegate().invalidateAll(iterable);
    }

    @Override // com.google.common.cache.c
    public void put(K k3, V v3) {
        delegate().put(k3, v3);
    }

    @Override // com.google.common.cache.c
    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    @Override // com.google.common.cache.c
    public long size() {
        return delegate().size();
    }

    @Override // com.google.common.cache.c
    public d stats() {
        return delegate().stats();
    }

    @Override // com.google.common.cache.c
    public void invalidateAll() {
        delegate().invalidateAll();
    }
}
