package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class n<K, V> extends o implements Map<K, V> {
    @Override // java.util.Map
    public void clear() {
        delegate().clear();
    }

    @Override // java.util.Map
    public boolean containsKey(@NullableDecl Object obj) {
        return delegate().containsKey(obj);
    }

    @Override // java.util.Map
    public boolean containsValue(@NullableDecl Object obj) {
        return delegate().containsValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.o
    public abstract Map<K, V> delegate();

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    @Override // java.util.Map
    public boolean equals(@NullableDecl Object obj) {
        if (obj != this && !delegate().equals(obj)) {
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public V get(@NullableDecl Object obj) {
        return delegate().get(obj);
    }

    @Override // java.util.Map
    public int hashCode() {
        return delegate().hashCode();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return delegate().keySet();
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    public V put(K k3, V v3) {
        return delegate().put(k3, v3);
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    @Override // java.util.Map
    @CanIgnoreReturnValue
    public V remove(Object obj) {
        return delegate().remove(obj);
    }

    @Override // java.util.Map
    public int size() {
        return delegate().size();
    }

    protected void standardClear() {
        r.d(entrySet().iterator());
    }

    @Beta
    protected boolean standardContainsKey(@NullableDecl Object obj) {
        return Maps.a(this, obj);
    }

    protected boolean standardContainsValue(@NullableDecl Object obj) {
        return Maps.b(this, obj);
    }

    protected boolean standardEquals(@NullableDecl Object obj) {
        return Maps.c(this, obj);
    }

    protected int standardHashCode() {
        return ab.b(entrySet());
    }

    protected boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    protected void standardPutAll(Map<? extends K, ? extends V> map) {
        Maps.m(this, map);
    }

    @Beta
    protected V standardRemove(@NullableDecl Object obj) {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (com.google.common.base.g.a(next.getKey(), obj)) {
                V value = next.getValue();
                it.remove();
                return value;
            }
        }
        return null;
    }

    protected String standardToString() {
        return Maps.n(this);
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return delegate().values();
    }
}
