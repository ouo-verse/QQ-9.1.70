package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
abstract class c<K, V> implements s<K, V> {

    /* renamed from: d, reason: collision with root package name */
    @MonotonicNonNullDecl
    private transient Collection<Map.Entry<K, V>> f35015d;

    /* renamed from: e, reason: collision with root package name */
    @MonotonicNonNullDecl
    private transient Set<K> f35016e;

    /* renamed from: f, reason: collision with root package name */
    @MonotonicNonNullDecl
    private transient u<K> f35017f;

    /* renamed from: h, reason: collision with root package name */
    @MonotonicNonNullDecl
    private transient Collection<V> f35018h;

    /* renamed from: i, reason: collision with root package name */
    @MonotonicNonNullDecl
    private transient Map<K, Collection<V>> f35019i;

    @Override // com.google.common.collect.s
    public Map<K, Collection<V>> asMap() {
        Map<K, Collection<V>> map = this.f35019i;
        if (map == null) {
            Map<K, Collection<V>> createAsMap = createAsMap();
            this.f35019i = createAsMap;
            return createAsMap;
        }
        return map;
    }

    public boolean containsEntry(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Collection<V> collection = asMap().get(obj);
        if (collection != null && collection.contains(obj2)) {
            return true;
        }
        return false;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        Iterator<Collection<V>> it = asMap().values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    abstract Map<K, Collection<V>> createAsMap();

    abstract Collection<Map.Entry<K, V>> createEntries();

    abstract Set<K> createKeySet();

    abstract u<K> createKeys();

    abstract Collection<V> createValues();

    @Override // com.google.common.collect.s
    public Collection<Map.Entry<K, V>> entries() {
        Collection<Map.Entry<K, V>> collection = this.f35015d;
        if (collection == null) {
            Collection<Map.Entry<K, V>> createEntries = createEntries();
            this.f35015d = createEntries;
            return createEntries;
        }
        return collection;
    }

    abstract Iterator<Map.Entry<K, V>> entryIterator();

    public boolean equals(@NullableDecl Object obj) {
        return t.a(this, obj);
    }

    public int hashCode() {
        return asMap().hashCode();
    }

    @Override // com.google.common.collect.s
    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public Set<K> keySet() {
        Set<K> set = this.f35016e;
        if (set == null) {
            Set<K> createKeySet = createKeySet();
            this.f35016e = createKeySet;
            return createKeySet;
        }
        return set;
    }

    public u<K> keys() {
        u<K> uVar = this.f35017f;
        if (uVar == null) {
            u<K> createKeys = createKeys();
            this.f35017f = createKeys;
            return createKeys;
        }
        return uVar;
    }

    @CanIgnoreReturnValue
    public boolean put(@NullableDecl K k3, @NullableDecl V v3) {
        return get(k3).add(v3);
    }

    @CanIgnoreReturnValue
    public boolean putAll(@NullableDecl K k3, Iterable<? extends V> iterable) {
        com.google.common.base.j.m(iterable);
        if (iterable instanceof Collection) {
            Collection<? extends V> collection = (Collection) iterable;
            return !collection.isEmpty() && get(k3).addAll(collection);
        }
        Iterator<? extends V> it = iterable.iterator();
        return it.hasNext() && r.a(get(k3), it);
    }

    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj, @NullableDecl Object obj2) {
        Collection<V> collection = asMap().get(obj);
        if (collection != null && collection.remove(obj2)) {
            return true;
        }
        return false;
    }

    @CanIgnoreReturnValue
    public Collection<V> replaceValues(@NullableDecl K k3, Iterable<? extends V> iterable) {
        com.google.common.base.j.m(iterable);
        Collection<V> removeAll = removeAll(k3);
        putAll(k3, iterable);
        return removeAll;
    }

    public String toString() {
        return asMap().toString();
    }

    Iterator<V> valueIterator() {
        return Maps.p(entries().iterator());
    }

    public Collection<V> values() {
        Collection<V> collection = this.f35018h;
        if (collection == null) {
            Collection<V> createValues = createValues();
            this.f35018h = createValues;
            return createValues;
        }
        return collection;
    }

    @CanIgnoreReturnValue
    public boolean putAll(s<? extends K, ? extends V> sVar) {
        boolean z16 = false;
        for (Map.Entry<? extends K, ? extends V> entry : sVar.entries()) {
            z16 |= put(entry.getKey(), entry.getValue());
        }
        return z16;
    }
}
