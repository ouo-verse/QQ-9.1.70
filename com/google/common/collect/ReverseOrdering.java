package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtCompatible(serializable = true)
/* loaded from: classes2.dex */
public final class ReverseOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final Ordering<? super T> forwardOrder;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ReverseOrdering(Ordering<? super T> ordering) {
        this.forwardOrder = (Ordering) com.google.common.base.j.m(ordering);
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t16, T t17) {
        return this.forwardOrder.compare(t17, t16);
    }

    @Override // java.util.Comparator
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ReverseOrdering) {
            return this.forwardOrder.equals(((ReverseOrdering) obj).forwardOrder);
        }
        return false;
    }

    public int hashCode() {
        return -this.forwardOrder.hashCode();
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(E e16, E e17) {
        return (E) this.forwardOrder.min(e16, e17);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(E e16, E e17) {
        return (E) this.forwardOrder.max(e16, e17);
    }

    @Override // com.google.common.collect.Ordering
    public <S extends T> Ordering<S> reverse() {
        return this.forwardOrder;
    }

    public String toString() {
        return this.forwardOrder + ".reverse()";
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(E e16, E e17, E e18, E... eArr) {
        return (E) this.forwardOrder.min(e16, e17, e18, eArr);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(E e16, E e17, E e18, E... eArr) {
        return (E) this.forwardOrder.max(e16, e17, e18, eArr);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterator<E> it) {
        return (E) this.forwardOrder.min(it);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterator<E> it) {
        return (E) this.forwardOrder.max(it);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E max(Iterable<E> iterable) {
        return (E) this.forwardOrder.min(iterable);
    }

    @Override // com.google.common.collect.Ordering
    public <E extends T> E min(Iterable<E> iterable) {
        return (E) this.forwardOrder.max(iterable);
    }
}
