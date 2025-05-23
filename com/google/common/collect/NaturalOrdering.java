package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtCompatible(serializable = true)
/* loaded from: classes2.dex */
public final class NaturalOrdering extends Ordering<Comparable> implements Serializable {
    static final NaturalOrdering INSTANCE = new NaturalOrdering();
    private static final long serialVersionUID = 0;

    /* renamed from: d, reason: collision with root package name */
    @MonotonicNonNullDecl
    private transient Ordering<Comparable> f34977d;

    /* renamed from: e, reason: collision with root package name */
    @MonotonicNonNullDecl
    private transient Ordering<Comparable> f34978e;

    NaturalOrdering() {
    }

    private Object readResolve() {
        return INSTANCE;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> nullsFirst() {
        Ordering<S> ordering = (Ordering<S>) this.f34977d;
        if (ordering == null) {
            Ordering<S> nullsFirst = super.nullsFirst();
            this.f34977d = nullsFirst;
            return nullsFirst;
        }
        return ordering;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> nullsLast() {
        Ordering<S> ordering = (Ordering<S>) this.f34978e;
        if (ordering == null) {
            Ordering<S> nullsLast = super.nullsLast();
            this.f34978e = nullsLast;
            return nullsLast;
        }
        return ordering;
    }

    @Override // com.google.common.collect.Ordering
    public <S extends Comparable> Ordering<S> reverse() {
        return ReverseNaturalOrdering.INSTANCE;
    }

    public String toString() {
        return "Ordering.natural()";
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Comparable comparable, Comparable comparable2) {
        com.google.common.base.j.m(comparable);
        com.google.common.base.j.m(comparable2);
        return comparable.compareTo(comparable2);
    }
}
