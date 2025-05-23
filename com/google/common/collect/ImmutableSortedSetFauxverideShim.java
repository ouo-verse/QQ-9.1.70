package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableSortedSet;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class ImmutableSortedSetFauxverideShim<E> extends ImmutableSet<E> {
    @Deprecated
    public static <E> ImmutableSortedSet.a<E> builder() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet.a<E> builderWithExpectedSize(int i3) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> copyOf(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E e16) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E e16, E e17) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E e16, E e17, E e18) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E e16, E e17, E e18, E e19) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E e16, E e17, E e18, E e19, E e26) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static <E> ImmutableSortedSet<E> of(E e16, E e17, E e18, E e19, E e26, E e27, E... eArr) {
        throw new UnsupportedOperationException();
    }
}
