package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public abstract class IndexedImmutableSet<E> extends ImmutableSet<E> {
    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    @GwtIncompatible
    public int copyIntoArray(Object[] objArr, int i3) {
        return asList().copyIntoArray(objArr, i3);
    }

    @Override // com.google.common.collect.ImmutableSet
    ImmutableList<E> createAsList() {
        return new ImmutableList<E>() { // from class: com.google.common.collect.IndexedImmutableSet.1
            @Override // java.util.List
            public E get(int i3) {
                return (E) IndexedImmutableSet.this.get(i3);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.ImmutableCollection
            public boolean isPartialView() {
                return IndexedImmutableSet.this.isPartialView();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return IndexedImmutableSet.this.size();
            }
        };
    }

    abstract E get(int i3);

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public ai<E> iterator() {
        return asList().iterator();
    }
}
