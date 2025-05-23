package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ab;
import com.google.common.collect.u;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public final class Multisets {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class ImmutableEntry<E> extends a<E> implements Serializable {
        private static final long serialVersionUID = 0;
        private final int count;

        @NullableDecl
        private final E element;

        ImmutableEntry(@NullableDecl E e16, int i3) {
            this.element = e16;
            this.count = i3;
            h.b(i3, "count");
        }

        @Override // com.google.common.collect.u.a
        public final int getCount() {
            return this.count;
        }

        @Override // com.google.common.collect.u.a
        @NullableDecl
        public final E getElement() {
            return this.element;
        }

        public ImmutableEntry<E> nextInBucket() {
            return null;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static abstract class a<E> implements u.a<E> {
        public boolean equals(@NullableDecl Object obj) {
            if (!(obj instanceof u.a)) {
                return false;
            }
            u.a aVar = (u.a) obj;
            if (getCount() != aVar.getCount() || !com.google.common.base.g.a(getElement(), aVar.getElement())) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            int hashCode;
            E element = getElement();
            if (element == null) {
                hashCode = 0;
            } else {
                hashCode = element.hashCode();
            }
            return hashCode ^ getCount();
        }

        public String toString() {
            String valueOf = String.valueOf(getElement());
            int count = getCount();
            if (count != 1) {
                return valueOf + " x " + count;
            }
            return valueOf;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class b<E> extends ab.a<E> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            d().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return d().contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection<?> collection) {
            return d().containsAll(collection);
        }

        abstract u<E> d();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return d().isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (d().remove(obj, Integer.MAX_VALUE) > 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return d().entrySet().size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class c<E> extends ab.a<u.a<E>> {
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            d().clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(@NullableDecl Object obj) {
            if (!(obj instanceof u.a)) {
                return false;
            }
            u.a aVar = (u.a) obj;
            if (aVar.getCount() <= 0 || d().count(aVar.getElement()) != aVar.getCount()) {
                return false;
            }
            return true;
        }

        abstract u<E> d();

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            if (obj instanceof u.a) {
                u.a aVar = (u.a) obj;
                Object element = aVar.getElement();
                int count = aVar.getCount();
                if (count != 0) {
                    return d().setCount(element, count, 0);
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class d<E> implements Iterator<E> {

        /* renamed from: d, reason: collision with root package name */
        private final u<E> f34971d;

        /* renamed from: e, reason: collision with root package name */
        private final Iterator<u.a<E>> f34972e;

        /* renamed from: f, reason: collision with root package name */
        @MonotonicNonNullDecl
        private u.a<E> f34973f;

        /* renamed from: h, reason: collision with root package name */
        private int f34974h;

        /* renamed from: i, reason: collision with root package name */
        private int f34975i;

        /* renamed from: m, reason: collision with root package name */
        private boolean f34976m;

        d(u<E> uVar, Iterator<u.a<E>> it) {
            this.f34971d = uVar;
            this.f34972e = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f34974h <= 0 && !this.f34972e.hasNext()) {
                return false;
            }
            return true;
        }

        @Override // java.util.Iterator
        public E next() {
            if (hasNext()) {
                if (this.f34974h == 0) {
                    u.a<E> next = this.f34972e.next();
                    this.f34973f = next;
                    int count = next.getCount();
                    this.f34974h = count;
                    this.f34975i = count;
                }
                this.f34974h--;
                this.f34976m = true;
                return this.f34973f.getElement();
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            h.d(this.f34976m);
            if (this.f34975i == 1) {
                this.f34972e.remove();
            } else {
                this.f34971d.remove(this.f34973f.getElement());
            }
            this.f34975i--;
            this.f34976m = false;
        }
    }

    private static <E> boolean a(u<E> uVar, AbstractMapBasedMultiset<? extends E> abstractMapBasedMultiset) {
        if (abstractMapBasedMultiset.isEmpty()) {
            return false;
        }
        abstractMapBasedMultiset.addTo(uVar);
        return true;
    }

    private static <E> boolean b(u<E> uVar, u<? extends E> uVar2) {
        if (uVar2 instanceof AbstractMapBasedMultiset) {
            return a(uVar, (AbstractMapBasedMultiset) uVar2);
        }
        if (uVar2.isEmpty()) {
            return false;
        }
        for (u.a<? extends E> aVar : uVar2.entrySet()) {
            uVar.add(aVar.getElement(), aVar.getCount());
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> boolean c(u<E> uVar, Collection<? extends E> collection) {
        com.google.common.base.j.m(uVar);
        com.google.common.base.j.m(collection);
        if (collection instanceof u) {
            return b(uVar, d(collection));
        }
        if (collection.isEmpty()) {
            return false;
        }
        return r.a(uVar, collection.iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> u<T> d(Iterable<T> iterable) {
        return (u) iterable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean e(u<?> uVar, @NullableDecl Object obj) {
        if (obj == uVar) {
            return true;
        }
        if (obj instanceof u) {
            u uVar2 = (u) obj;
            if (uVar.size() == uVar2.size() && uVar.entrySet().size() == uVar2.entrySet().size()) {
                for (u.a aVar : uVar2.entrySet()) {
                    if (uVar.count(aVar.getElement()) != aVar.getCount()) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static <E> u.a<E> f(@NullableDecl E e16, int i3) {
        return new ImmutableEntry(e16, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int g(Iterable<?> iterable) {
        if (iterable instanceof u) {
            return ((u) iterable).elementSet().size();
        }
        return 11;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> Iterator<E> h(u<E> uVar) {
        return new d(uVar, uVar.entrySet().iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(u<?> uVar, Collection<?> collection) {
        if (collection instanceof u) {
            collection = ((u) collection).elementSet();
        }
        return uVar.elementSet().removeAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j(u<?> uVar, Collection<?> collection) {
        com.google.common.base.j.m(collection);
        if (collection instanceof u) {
            collection = ((u) collection).elementSet();
        }
        return uVar.elementSet().retainAll(collection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> int k(u<E> uVar, E e16, int i3) {
        h.b(i3, "count");
        int count = uVar.count(e16);
        int i16 = i3 - count;
        if (i16 > 0) {
            uVar.add(e16, i16);
        } else if (i16 < 0) {
            uVar.remove(e16, -i16);
        }
        return count;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> boolean l(u<E> uVar, E e16, int i3, int i16) {
        h.b(i3, "oldCount");
        h.b(i16, "newCount");
        if (uVar.count(e16) == i3) {
            uVar.setCount(e16, i16);
            return true;
        }
        return false;
    }
}
