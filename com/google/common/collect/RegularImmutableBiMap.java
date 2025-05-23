package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.RegularImmutableMap;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
final class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    static final RegularImmutableBiMap<Object, Object> EMPTY = new RegularImmutableBiMap<>();
    private final transient int C;
    private final transient RegularImmutableBiMap<V, K> D;

    @VisibleForTesting
    final transient Object[] alternatingKeysAndValues;

    /* renamed from: i, reason: collision with root package name */
    private final transient int[] f34986i;

    /* renamed from: m, reason: collision with root package name */
    private final transient int f34987m;

    /* JADX WARN: Multi-variable type inference failed */
    RegularImmutableBiMap() {
        this.f34986i = null;
        this.alternatingKeysAndValues = new Object[0];
        this.f34987m = 0;
        this.C = 0;
        this.D = this;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new RegularImmutableMap.EntrySet(this, this.alternatingKeysAndValues, this.f34987m, this.C);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<K> createKeySet() {
        return new RegularImmutableMap.KeySet(this, new RegularImmutableMap.KeysOrValuesAsList(this.alternatingKeysAndValues, this.f34987m, this.C));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(@NullableDecl Object obj) {
        return (V) RegularImmutableMap.get(this.f34986i, this.alternatingKeysAndValues, this.C, this.f34987m, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.C;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.g
    public ImmutableBiMap<V, K> inverse() {
        return this.D;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableBiMap(Object[] objArr, int i3) {
        this.alternatingKeysAndValues = objArr;
        this.C = i3;
        this.f34987m = 0;
        int chooseTableSize = i3 >= 2 ? ImmutableSet.chooseTableSize(i3) : 0;
        this.f34986i = RegularImmutableMap.createHashTable(objArr, i3, chooseTableSize, 0);
        this.D = new RegularImmutableBiMap<>(RegularImmutableMap.createHashTable(objArr, i3, chooseTableSize, 1), objArr, i3, this);
    }

    RegularImmutableBiMap(int[] iArr, Object[] objArr, int i3, RegularImmutableBiMap<V, K> regularImmutableBiMap) {
        this.f34986i = iArr;
        this.alternatingKeysAndValues = objArr;
        this.f34987m = 1;
        this.C = i3;
        this.D = regularImmutableBiMap;
    }
}
