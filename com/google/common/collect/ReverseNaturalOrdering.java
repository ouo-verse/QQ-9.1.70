package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;

/* compiled from: P */
@GwtCompatible(serializable = true)
/* loaded from: classes2.dex */
final class ReverseNaturalOrdering extends Ordering<Comparable> implements Serializable {
    static final ReverseNaturalOrdering INSTANCE = new ReverseNaturalOrdering();
    private static final long serialVersionUID = 0;

    ReverseNaturalOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> reverse() {
        return Ordering.natural();
    }

    public String toString() {
        return "Ordering.natural().reverse()";
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Comparable comparable, Comparable comparable2) {
        com.google.common.base.j.m(comparable);
        if (comparable == comparable2) {
            return 0;
        }
        return comparable2.compareTo(comparable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(E e16, E e17) {
        return (E) NaturalOrdering.INSTANCE.min(e16, e17);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(E e16, E e17) {
        return (E) NaturalOrdering.INSTANCE.max(e16, e17);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(E e16, E e17, E e18, E... eArr) {
        return (E) NaturalOrdering.INSTANCE.min(e16, e17, e18, eArr);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(E e16, E e17, E e18, E... eArr) {
        return (E) NaturalOrdering.INSTANCE.max(e16, e17, e18, eArr);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(Iterator<E> it) {
        return (E) NaturalOrdering.INSTANCE.min(it);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(Iterator<E> it) {
        return (E) NaturalOrdering.INSTANCE.max(it);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E max(Iterable<E> iterable) {
        return (E) NaturalOrdering.INSTANCE.min(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends Comparable> E min(Iterable<E> iterable) {
        return (E) NaturalOrdering.INSTANCE.max(iterable);
    }
}
