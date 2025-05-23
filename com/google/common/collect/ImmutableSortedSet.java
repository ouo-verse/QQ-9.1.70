package com.google.common.collect;

import ADV_REPORT.mobile_adv_report_req;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements NavigableSet<E>, ac<E> {
    final transient Comparator<? super E> comparator;

    @GwtIncompatible
    @LazyInit
    transient ImmutableSortedSet<E> descendingSet;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> comparator;
        final Object[] elements;

        public SerializedForm(Comparator<? super E> comparator, Object[] objArr) {
            this.comparator = comparator;
            this.elements = objArr;
        }

        /* JADX WARN: Multi-variable type inference failed */
        Object readResolve() {
            return new a(this.comparator).n(this.elements).l();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class a<E> extends ImmutableSet.a<E> {

        /* renamed from: f, reason: collision with root package name */
        private final Comparator<? super E> f34929f;

        public a(Comparator<? super E> comparator) {
            this.f34929f = (Comparator) com.google.common.base.j.m(comparator);
        }

        @Override // com.google.common.collect.ImmutableSet.a
        @CanIgnoreReturnValue
        /* renamed from: m, reason: merged with bridge method [inline-methods] */
        public a<E> a(E e16) {
            super.a(e16);
            return this;
        }

        @CanIgnoreReturnValue
        public a<E> n(E... eArr) {
            super.i(eArr);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.a
        @CanIgnoreReturnValue
        /* renamed from: o, reason: merged with bridge method [inline-methods] */
        public a<E> j(Iterator<? extends E> it) {
            super.j(it);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.a
        /* renamed from: p, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedSet<E> l() {
            ImmutableSortedSet<E> construct = ImmutableSortedSet.construct(this.f34929f, this.f34869b, this.f34868a);
            this.f34869b = construct.size();
            this.f34870c = true;
            return construct;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSortedSet(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <E> ImmutableSortedSet<E> construct(Comparator<? super E> comparator, int i3, E... eArr) {
        if (i3 == 0) {
            return emptySet(comparator);
        }
        v.c(eArr, i3);
        Arrays.sort(eArr, 0, i3, comparator);
        int i16 = 1;
        for (int i17 = 1; i17 < i3; i17++) {
            mobile_adv_report_req mobile_adv_report_reqVar = (Object) eArr[i17];
            if (comparator.compare(mobile_adv_report_reqVar, (Object) eArr[i16 - 1]) != 0) {
                eArr[i16] = mobile_adv_report_reqVar;
                i16++;
            }
        }
        Arrays.fill(eArr, i16, i3, (Object) null);
        if (i16 < eArr.length / 2) {
            eArr = (E[]) Arrays.copyOf(eArr, i16);
        }
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(eArr, i16), comparator);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet copyOf(Comparable[] comparableArr) {
        return construct(Ordering.natural(), comparableArr.length, (Object[]) comparableArr.clone());
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> sortedSet) {
        Comparator a16 = ad.a(sortedSet);
        ImmutableList copyOf = ImmutableList.copyOf((Collection) sortedSet);
        if (copyOf.isEmpty()) {
            return emptySet(a16);
        }
        return new RegularImmutableSortedSet(copyOf, a16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> RegularImmutableSortedSet<E> emptySet(Comparator<? super E> comparator) {
        if (Ordering.natural().equals(comparator)) {
            return (RegularImmutableSortedSet<E>) RegularImmutableSortedSet.NATURAL_EMPTY_SET;
        }
        return new RegularImmutableSortedSet<>(ImmutableList.of(), comparator);
    }

    public static <E extends Comparable<?>> a<E> naturalOrder() {
        return new a<>(Ordering.natural());
    }

    public static <E> ImmutableSortedSet<E> of() {
        return RegularImmutableSortedSet.NATURAL_EMPTY_SET;
    }

    public static <E> a<E> orderedBy(Comparator<E> comparator) {
        return new a<>(comparator);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<?>> a<E> reverseOrder() {
        return new a<>(Collections.reverseOrder());
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public E ceiling(E e16) {
        return (E) q.g(tailSet((ImmutableSortedSet<E>) e16, true), null);
    }

    @Override // java.util.SortedSet, com.google.common.collect.ac
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    @GwtIncompatible
    abstract ImmutableSortedSet<E> createDescendingSet();

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public abstract ai<E> descendingIterator();

    @Override // java.util.SortedSet
    public E first() {
        return iterator().next();
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public E floor(E e16) {
        return (E) r.o(headSet((ImmutableSortedSet<E>) e16, true).descendingIterator(), null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    @GwtIncompatible
    public /* bridge */ /* synthetic */ NavigableSet headSet(Object obj, boolean z16) {
        return headSet((ImmutableSortedSet<E>) obj, z16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ImmutableSortedSet<E> headSetImpl(E e16, boolean z16);

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public E higher(E e16) {
        return (E) q.g(tailSet((ImmutableSortedSet<E>) e16, false), null);
    }

    abstract int indexOf(@NullableDecl Object obj);

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract ai<E> iterator();

    @Override // java.util.SortedSet
    public E last() {
        return descendingIterator().next();
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public E lower(E e16) {
        return (E) r.o(headSet((ImmutableSortedSet<E>) e16, false).descendingIterator(), null);
    }

    @Override // java.util.NavigableSet
    @CanIgnoreReturnValue
    @GwtIncompatible
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableSet
    @CanIgnoreReturnValue
    @GwtIncompatible
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    @GwtIncompatible
    public /* bridge */ /* synthetic */ NavigableSet subSet(Object obj, boolean z16, Object obj2, boolean z17) {
        return subSet((boolean) obj, z16, (boolean) obj2, z17);
    }

    abstract ImmutableSortedSet<E> subSetImpl(E e16, boolean z16, E e17, boolean z17);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    @GwtIncompatible
    public /* bridge */ /* synthetic */ NavigableSet tailSet(Object obj, boolean z16) {
        return tailSet((ImmutableSortedSet<E>) obj, z16);
    }

    abstract ImmutableSortedSet<E> tailSetImpl(E e16, boolean z16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public int unsafeCompare(Object obj, Object obj2) {
        return unsafeCompare(this.comparator, obj, obj2);
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this.comparator, toArray());
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable) {
        return new RegularImmutableSortedSet(ImmutableList.of(comparable), Ordering.natural());
    }

    static int unsafeCompare(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.descendingSet;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        ImmutableSortedSet<E> createDescendingSet = createDescendingSet();
        this.descendingSet = createDescendingSet;
        createDescendingSet.descendingSet = this;
        return createDescendingSet;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return headSet((ImmutableSortedSet<E>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet, java.util.SortedSet
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet((ImmutableSortedSet<E>) obj);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2) {
        return construct(Ordering.natural(), 2, comparable, comparable2);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> headSet(E e16) {
        return headSet((ImmutableSortedSet<E>) e16, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> subSet(E e16, E e17) {
        return subSet((boolean) e16, true, (boolean) e17, false);
    }

    @Override // java.util.NavigableSet, java.util.SortedSet
    public ImmutableSortedSet<E> tailSet(E e16) {
        return tailSet((ImmutableSortedSet<E>) e16, true);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> collection) {
        return copyOf((Comparator) Ordering.natural(), (Collection) collection);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return construct(Ordering.natural(), 3, comparable, comparable2, comparable3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    @GwtIncompatible
    public ImmutableSortedSet<E> headSet(E e16, boolean z16) {
        return headSetImpl(com.google.common.base.j.m(e16), z16);
    }

    @Override // java.util.NavigableSet
    @GwtIncompatible
    public ImmutableSortedSet<E> subSet(E e16, boolean z16, E e17, boolean z17) {
        com.google.common.base.j.m(e16);
        com.google.common.base.j.m(e17);
        com.google.common.base.j.d(this.comparator.compare(e16, e17) <= 0);
        return subSetImpl(e16, z16, e17, z17);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.NavigableSet
    @GwtIncompatible
    public ImmutableSortedSet<E> tailSet(E e16, boolean z16) {
        return tailSetImpl(com.google.common.base.j.m(e16), z16);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return construct(Ordering.natural(), 4, comparable, comparable2, comparable3, comparable4);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return construct(Ordering.natural(), 5, comparable, comparable2, comparable3, comparable4, comparable5);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        int length = comparableArr.length + 6;
        Comparable[] comparableArr2 = new Comparable[length];
        comparableArr2[0] = comparable;
        comparableArr2[1] = comparable2;
        comparableArr2[2] = comparable3;
        comparableArr2[3] = comparable4;
        comparableArr2[4] = comparable5;
        comparableArr2[5] = comparable6;
        System.arraycopy(comparableArr, 0, comparableArr2, 6, comparableArr.length);
        return construct(Ordering.natural(), length, comparableArr2);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        return new a(comparator).j(it).l();
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        com.google.common.base.j.m(comparator);
        if (ad.b(comparator, iterable) && (iterable instanceof ImmutableSortedSet)) {
            ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet) iterable;
            if (!immutableSortedSet.isPartialView()) {
                return immutableSortedSet;
            }
        }
        Object[] k3 = q.k(iterable);
        return construct(comparator, k3.length, k3);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return copyOf((Comparator) comparator, (Iterable) collection);
    }
}
