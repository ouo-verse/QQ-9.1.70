package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multisets;
import com.google.common.collect.u;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
abstract class d<E> extends AbstractCollection<E> implements u<E> {

    /* renamed from: d, reason: collision with root package name */
    @MonotonicNonNullDecl
    private transient Set<E> f35020d;

    /* renamed from: e, reason: collision with root package name */
    @MonotonicNonNullDecl
    private transient Set<u.a<E>> f35021e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a extends Multisets.b<E> {
        a() {
        }

        @Override // com.google.common.collect.Multisets.b
        u<E> d() {
            return d.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return d.this.elementIterator();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b extends Multisets.c<E> {
        b() {
        }

        @Override // com.google.common.collect.Multisets.c
        u<E> d() {
            return d.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<u.a<E>> iterator() {
            return d.this.entryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return d.this.distinctElements();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean add(@NullableDecl E e16) {
        add(e16, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean addAll(Collection<? extends E> collection) {
        return Multisets.c(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract void clear();

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.u
    public boolean contains(@NullableDecl Object obj) {
        if (count(obj) > 0) {
            return true;
        }
        return false;
    }

    Set<E> createElementSet() {
        return new a();
    }

    Set<u.a<E>> createEntrySet() {
        return new b();
    }

    abstract int distinctElements();

    abstract Iterator<E> elementIterator();

    @Override // com.google.common.collect.u
    public Set<E> elementSet() {
        Set<E> set = this.f35020d;
        if (set == null) {
            Set<E> createElementSet = createElementSet();
            this.f35020d = createElementSet;
            return createElementSet;
        }
        return set;
    }

    abstract Iterator<u.a<E>> entryIterator();

    @Override // com.google.common.collect.u
    public Set<u.a<E>> entrySet() {
        Set<u.a<E>> set = this.f35021e;
        if (set == null) {
            Set<u.a<E>> createEntrySet = createEntrySet();
            this.f35021e = createEntrySet;
            return createEntrySet;
        }
        return set;
    }

    @Override // java.util.Collection
    public final boolean equals(@NullableDecl Object obj) {
        return Multisets.e(this, obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.u
    @CanIgnoreReturnValue
    public final boolean remove(@NullableDecl Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean removeAll(Collection<?> collection) {
        return Multisets.i(this, collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean retainAll(Collection<?> collection) {
        return Multisets.j(this, collection);
    }

    @CanIgnoreReturnValue
    public int setCount(@NullableDecl E e16, int i3) {
        return Multisets.k(this, e16, i3);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return entrySet().toString();
    }

    @CanIgnoreReturnValue
    public int add(@NullableDecl E e16, int i3) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object obj, int i3) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    public boolean setCount(@NullableDecl E e16, int i3, int i16) {
        return Multisets.l(this, e16, i3, i16);
    }
}
