package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public final class Lists {

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;

        @NullableDecl
        final E first;
        final E[] rest;

        OnePlusArrayList(@NullableDecl E e16, E[] eArr) {
            this.first = e16;
            this.rest = (E[]) ((Object[]) com.google.common.base.j.m(eArr));
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i3) {
            com.google.common.base.j.k(i3, size());
            if (i3 == 0) {
                return this.first;
            }
            return this.rest[i3 - 1];
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return r1.a.d(this.rest.length, 1);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements RandomAccess, Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final com.google.common.base.d<? super F, ? extends T> function;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a extends ag<F, T> {
            a(ListIterator listIterator) {
                super(listIterator);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.af
            public T a(F f16) {
                return TransformingRandomAccessList.this.function.apply(f16);
            }
        }

        TransformingRandomAccessList(List<F> list, com.google.common.base.d<? super F, ? extends T> dVar) {
            this.fromList = (List) com.google.common.base.j.m(list);
            this.function = (com.google.common.base.d) com.google.common.base.j.m(dVar);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i3) {
            return this.function.apply(this.fromList.get(i3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i3) {
            return new a(this.fromList.listIterator(i3));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i3) {
            return this.function.apply(this.fromList.remove(i3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final com.google.common.base.d<? super F, ? extends T> function;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a extends ag<F, T> {
            a(ListIterator listIterator) {
                super(listIterator);
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            @Override // com.google.common.collect.af
            public T a(F f16) {
                return TransformingSequentialList.this.function.apply(f16);
            }
        }

        TransformingSequentialList(List<F> list, com.google.common.base.d<? super F, ? extends T> dVar) {
            this.fromList = (List) com.google.common.base.j.m(list);
            this.function = (com.google.common.base.d) com.google.common.base.j.m(dVar);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i3) {
            return new a(this.fromList.listIterator(i3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a<T> extends b<T> implements RandomAccess {
        a(List<T> list) {
            super(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b<T> extends AbstractList<T> {

        /* renamed from: d, reason: collision with root package name */
        private final List<T> f34932d;

        /* compiled from: P */
        /* loaded from: classes2.dex */
        class a implements ListIterator<T> {

            /* renamed from: d, reason: collision with root package name */
            boolean f34933d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ ListIterator f34934e;

            a(ListIterator listIterator) {
                this.f34934e = listIterator;
            }

            @Override // java.util.ListIterator
            public void add(T t16) {
                this.f34934e.add(t16);
                this.f34934e.previous();
                this.f34933d = false;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public boolean hasNext() {
                return this.f34934e.hasPrevious();
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return this.f34934e.hasNext();
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public T next() {
                if (hasNext()) {
                    this.f34933d = true;
                    return (T) this.f34934e.previous();
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return b.this.h(this.f34934e.nextIndex());
            }

            @Override // java.util.ListIterator
            public T previous() {
                if (hasPrevious()) {
                    this.f34933d = true;
                    return (T) this.f34934e.next();
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return nextIndex() - 1;
            }

            @Override // java.util.ListIterator, java.util.Iterator
            public void remove() {
                h.d(this.f34933d);
                this.f34934e.remove();
                this.f34933d = false;
            }

            @Override // java.util.ListIterator
            public void set(T t16) {
                com.google.common.base.j.s(this.f34933d);
                this.f34934e.set(t16);
            }
        }

        b(List<T> list) {
            this.f34932d = (List) com.google.common.base.j.m(list);
        }

        private int g(int i3) {
            int size = size();
            com.google.common.base.j.k(i3, size);
            return (size - 1) - i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int h(int i3) {
            int size = size();
            com.google.common.base.j.p(i3, size);
            return size - i3;
        }

        @Override // java.util.AbstractList, java.util.List
        public void add(int i3, @NullableDecl T t16) {
            this.f34932d.add(h(i3), t16);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.f34932d.clear();
        }

        List<T> d() {
            return this.f34932d;
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i3) {
            return this.f34932d.get(g(i3));
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
        public Iterator<T> iterator() {
            return listIterator();
        }

        @Override // java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i3) {
            return new a(this.f34932d.listIterator(h(i3)));
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i3) {
            return this.f34932d.remove(g(i3));
        }

        @Override // java.util.AbstractList
        protected void removeRange(int i3, int i16) {
            subList(i3, i16).clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T set(int i3, @NullableDecl T t16) {
            return this.f34932d.set(g(i3), t16);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f34932d.size();
        }

        @Override // java.util.AbstractList, java.util.List
        public List<T> subList(int i3, int i16) {
            com.google.common.base.j.r(i3, i16, size());
            return Lists.m(this.f34932d.subList(h(i16), h(i3)));
        }
    }

    public static <E> List<E> a(@NullableDecl E e16, E[] eArr) {
        return new OnePlusArrayList(e16, eArr);
    }

    @VisibleForTesting
    static int b(int i3) {
        h.b(i3, "arraySize");
        return s1.c.b(i3 + 5 + (i3 / 10));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(List<?> list, @NullableDecl Object obj) {
        if (obj == com.google.common.base.j.m(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        int size = list.size();
        if (size != list2.size()) {
            return false;
        }
        if ((list instanceof RandomAccess) && (list2 instanceof RandomAccess)) {
            for (int i3 = 0; i3 < size; i3++) {
                if (!com.google.common.base.g.a(list.get(i3), list2.get(i3))) {
                    return false;
                }
            }
            return true;
        }
        return r.i(list.iterator(), list2.iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(List<?> list, @NullableDecl Object obj) {
        if (list instanceof RandomAccess) {
            return e(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (com.google.common.base.g.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    private static int e(List<?> list, @NullableDecl Object obj) {
        int size = list.size();
        int i3 = 0;
        if (obj == null) {
            while (i3 < size) {
                if (list.get(i3) == null) {
                    return i3;
                }
                i3++;
            }
            return -1;
        }
        while (i3 < size) {
            if (obj.equals(list.get(i3))) {
                return i3;
            }
            i3++;
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int f(List<?> list, @NullableDecl Object obj) {
        if (list instanceof RandomAccess) {
            return g(list, obj);
        }
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (com.google.common.base.g.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    private static int g(List<?> list, @NullableDecl Object obj) {
        if (obj == null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                if (list.get(size) == null) {
                    return size;
                }
            }
            return -1;
        }
        for (int size2 = list.size() - 1; size2 >= 0; size2--) {
            if (obj.equals(list.get(size2))) {
                return size2;
            }
        }
        return -1;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> h() {
        return new ArrayList<>();
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> i(Iterable<? extends E> iterable) {
        com.google.common.base.j.m(iterable);
        if (iterable instanceof Collection) {
            return new ArrayList<>(i.a(iterable));
        }
        return j(iterable.iterator());
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> j(Iterator<? extends E> it) {
        ArrayList<E> h16 = h();
        r.a(h16, it);
        return h16;
    }

    @SafeVarargs
    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> k(E... eArr) {
        com.google.common.base.j.m(eArr);
        ArrayList<E> arrayList = new ArrayList<>(b(eArr.length));
        Collections.addAll(arrayList, eArr);
        return arrayList;
    }

    @GwtCompatible(serializable = true)
    public static <E> ArrayList<E> l(int i3) {
        h.b(i3, "initialArraySize");
        return new ArrayList<>(i3);
    }

    public static <T> List<T> m(List<T> list) {
        if (list instanceof ImmutableList) {
            return ((ImmutableList) list).reverse();
        }
        if (list instanceof b) {
            return ((b) list).d();
        }
        if (list instanceof RandomAccess) {
            return new a(list);
        }
        return new b(list);
    }

    public static <F, T> List<T> n(List<F> list, com.google.common.base.d<? super F, ? extends T> dVar) {
        if (list instanceof RandomAccess) {
            return new TransformingRandomAccessList(list, dVar);
        }
        return new TransformingSequentialList(list, dVar);
    }
}
