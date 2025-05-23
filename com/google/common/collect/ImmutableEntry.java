package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(serializable = true)
/* loaded from: classes2.dex */
class ImmutableEntry<K, V> extends b<K, V> implements Serializable {
    private static final long serialVersionUID = 0;

    @NullableDecl
    final K key;

    @NullableDecl
    final V value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableEntry(@NullableDecl K k3, @NullableDecl V v3) {
        this.key = k3;
        this.value = v3;
    }

    @Override // com.google.common.collect.b, java.util.Map.Entry
    @NullableDecl
    public final K getKey() {
        return this.key;
    }

    @Override // com.google.common.collect.b, java.util.Map.Entry
    @NullableDecl
    public final V getValue() {
        return this.value;
    }

    @Override // com.google.common.collect.b, java.util.Map.Entry
    public final V setValue(V v3) {
        throw new UnsupportedOperationException();
    }
}
