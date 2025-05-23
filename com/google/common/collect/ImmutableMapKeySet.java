package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
final class ImmutableMapKeySet<K, V> extends IndexedImmutableSet<K> {
    private final ImmutableMap<K, V> map;

    /* compiled from: P */
    @GwtIncompatible
    /* loaded from: classes2.dex */
    private static class KeySetSerializedForm<K> implements Serializable {
        private static final long serialVersionUID = 0;
        final ImmutableMap<K, ?> map;

        KeySetSerializedForm(ImmutableMap<K, ?> immutableMap) {
            this.map = immutableMap;
        }

        Object readResolve() {
            return this.map.keySet();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableMapKeySet(ImmutableMap<K, V> immutableMap) {
        this.map = immutableMap;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(@NullableDecl Object obj) {
        return this.map.containsKey(obj);
    }

    @Override // com.google.common.collect.IndexedImmutableSet
    K get(int i3) {
        return this.map.entrySet().asList().get(i3).getKey();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.map.size();
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    Object writeReplace() {
        return new KeySetSerializedForm(this.map);
    }

    @Override // com.google.common.collect.IndexedImmutableSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public ai<K> iterator() {
        return this.map.keyIterator();
    }
}
