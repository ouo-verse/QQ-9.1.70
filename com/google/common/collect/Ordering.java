package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class Ordering<T> implements Comparator<T> {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    static class IncomparableValueException extends ClassCastException {
        private static final long serialVersionUID = 0;
        final Object value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public IncomparableValueException(Object obj) {
            super("Cannot compare value: " + obj);
            this.value = obj;
        }
    }

    /* compiled from: P */
    @VisibleForTesting
    /* loaded from: classes2.dex */
    static class a extends Ordering<Object> {

        /* renamed from: d, reason: collision with root package name */
        private final AtomicInteger f34979d = new AtomicInteger(0);

        /* renamed from: e, reason: collision with root package name */
        private final ConcurrentMap<Object, Integer> f34980e = y.e(new MapMaker()).i();

        a() {
        }

        private Integer a(Object obj) {
            Integer num = this.f34980e.get(obj);
            if (num == null) {
                Integer valueOf = Integer.valueOf(this.f34979d.getAndIncrement());
                Integer putIfAbsent = this.f34980e.putIfAbsent(obj, valueOf);
                if (putIfAbsent != null) {
                    return putIfAbsent;
                }
                return valueOf;
            }
            return num;
        }

        int b(Object obj) {
            return System.identityHashCode(obj);
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == obj2) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            int b16 = b(obj);
            int b17 = b(obj2);
            if (b16 != b17) {
                if (b16 < b17) {
                    return -1;
                }
                return 1;
            }
            int compareTo = a(obj).compareTo(a(obj2));
            if (compareTo != 0) {
                return compareTo;
            }
            throw new AssertionError();
        }

        public String toString() {
            return "Ordering.arbitrary()";
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        static final Ordering<Object> f34981a = new a();
    }

    @GwtCompatible(serializable = true)
    public static Ordering<Object> allEqual() {
        return AllEqualOrdering.INSTANCE;
    }

    public static Ordering<Object> arbitrary() {
        return b.f34981a;
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> explicit(List<T> list) {
        return new ExplicitOrdering(list);
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> from(Comparator<T> comparator) {
        return comparator instanceof Ordering ? (Ordering) comparator : new ComparatorOrdering(comparator);
    }

    @GwtCompatible(serializable = true)
    public static <C extends Comparable> Ordering<C> natural() {
        return NaturalOrdering.INSTANCE;
    }

    @GwtCompatible(serializable = true)
    public static Ordering<Object> usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }

    @Deprecated
    public int binarySearch(List<? extends T> list, @NullableDecl T t16) {
        return Collections.binarySearch(list, t16, this);
    }

    @Override // java.util.Comparator
    @CanIgnoreReturnValue
    public abstract int compare(@NullableDecl T t16, @NullableDecl T t17);

    @GwtCompatible(serializable = true)
    public <U extends T> Ordering<U> compound(Comparator<? super U> comparator) {
        return new CompoundOrdering(this, (Comparator) com.google.common.base.j.m(comparator));
    }

    public <E extends T> List<E> greatestOf(Iterable<E> iterable, int i3) {
        return reverse().leastOf(iterable, i3);
    }

    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        return ImmutableList.sortedCopyOf(this, iterable);
    }

    public boolean isOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (compare(next, next2) > 0) {
                    return false;
                }
                next = next2;
            }
            return true;
        }
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (compare(next, next2) >= 0) {
                    return false;
                }
                next = next2;
            }
            return true;
        }
        return true;
    }

    public <E extends T> List<E> leastOf(Iterable<E> iterable, int i3) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection.size() <= i3 * 2) {
                Object[] array = collection.toArray();
                Arrays.sort(array, this);
                if (array.length > i3) {
                    array = Arrays.copyOf(array, i3);
                }
                return Collections.unmodifiableList(Arrays.asList(array));
            }
        }
        return leastOf(iterable.iterator(), i3);
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<Iterable<S>> lexicographical() {
        return new LexicographicalOrdering(this);
    }

    public <E extends T> E max(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) max(next, it.next());
        }
        return next;
    }

    public <E extends T> E min(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) min(next, it.next());
        }
        return next;
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<S> nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<S> nullsLast() {
        return new NullsLastOrdering(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <T2 extends T> Ordering<Map.Entry<T2, ?>> onKeys() {
        return (Ordering<Map.Entry<T2, ?>>) onResultOf(Maps.f());
    }

    @GwtCompatible(serializable = true)
    public <F> Ordering<F> onResultOf(com.google.common.base.d<F, ? extends T> dVar) {
        return new ByFunctionOrdering(dVar, this);
    }

    @GwtCompatible(serializable = true)
    public <S extends T> Ordering<S> reverse() {
        return new ReverseOrdering(this);
    }

    public <E extends T> List<E> sortedCopy(Iterable<E> iterable) {
        Object[] k3 = q.k(iterable);
        Arrays.sort(k3, this);
        return Lists.i(Arrays.asList(k3));
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> iterable) {
        return new CompoundOrdering(iterable);
    }

    @GwtCompatible(serializable = true)
    public static <T> Ordering<T> explicit(T t16, T... tArr) {
        return explicit(Lists.a(t16, tArr));
    }

    @GwtCompatible(serializable = true)
    @Deprecated
    public static <T> Ordering<T> from(Ordering<T> ordering) {
        return (Ordering) com.google.common.base.j.m(ordering);
    }

    public <E extends T> List<E> greatestOf(Iterator<E> it, int i3) {
        return reverse().leastOf(it, i3);
    }

    public <E extends T> E max(Iterable<E> iterable) {
        return (E) max(iterable.iterator());
    }

    public <E extends T> E min(Iterable<E> iterable) {
        return (E) min(iterable.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E max(@NullableDecl E e16, @NullableDecl E e17) {
        return compare(e16, e17) >= 0 ? e16 : e17;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E min(@NullableDecl E e16, @NullableDecl E e17) {
        return compare(e16, e17) <= 0 ? e16 : e17;
    }

    public <E extends T> E max(@NullableDecl E e16, @NullableDecl E e17, @NullableDecl E e18, E... eArr) {
        E e19 = (E) max(max(e16, e17), e18);
        for (E e26 : eArr) {
            e19 = (E) max(e19, e26);
        }
        return e19;
    }

    public <E extends T> E min(@NullableDecl E e16, @NullableDecl E e17, @NullableDecl E e18, E... eArr) {
        E e19 = (E) min(min(e16, e17), e18);
        for (E e26 : eArr) {
            e19 = (E) min(e19, e26);
        }
        return e19;
    }

    public <E extends T> List<E> leastOf(Iterator<E> it, int i3) {
        com.google.common.base.j.m(it);
        h.b(i3, "k");
        if (i3 == 0 || !it.hasNext()) {
            return Collections.emptyList();
        }
        if (i3 >= 1073741823) {
            ArrayList j3 = Lists.j(it);
            Collections.sort(j3, this);
            if (j3.size() > i3) {
                j3.subList(i3, j3.size()).clear();
            }
            j3.trimToSize();
            return Collections.unmodifiableList(j3);
        }
        ae a16 = ae.a(i3, this);
        a16.c(it);
        return a16.f();
    }
}
