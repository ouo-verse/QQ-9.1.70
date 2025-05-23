package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableSortedMap;

/* compiled from: P */
@GwtIncompatible
/* loaded from: classes2.dex */
abstract class ImmutableSortedMapFauxverideShim<K, V> extends ImmutableMap<K, V> {
    @Deprecated
    public static <K, V> ImmutableSortedMap.b<K, V> builder() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap.b<K, V> builderWithExpectedSize(int i3) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k3, V v3) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k3, V v3, K k16, V v16) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k3, V v3, K k16, V v16, K k17, V v17) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k3, V v3, K k16, V v16, K k17, V v17, K k18, V v18) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <K, V> ImmutableSortedMap<K, V> of(K k3, V v3, K k16, V v16, K k17, V v17, K k18, V v18, K k19, V v19) {
        throw new UnsupportedOperationException();
    }
}
