package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
public final class RegularImmutableSortedSet<E> extends ImmutableSortedSet<E> {
    static final RegularImmutableSortedSet<Comparable> NATURAL_EMPTY_SET = new RegularImmutableSortedSet<>(ImmutableList.of(), Ordering.natural());

    @VisibleForTesting
    final transient ImmutableList<E> elements;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableSortedSet(ImmutableList<E> immutableList, Comparator<? super E> comparator) {
        super(comparator);
        this.elements = immutableList;
    }

    private int g(Object obj) throws ClassCastException {
        return Collections.binarySearch(this.elements, obj, unsafeComparator());
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        return this.elements;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E ceiling(E e16) {
        int tailIndex = tailIndex(e16, true);
        if (tailIndex == size()) {
            return null;
        }
        return this.elements.get(tailIndex);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(@NullableDecl Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            if (g(obj) < 0) {
                return false;
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection<?> collection) {
        if (collection instanceof u) {
            collection = ((u) collection).elementSet();
        }
        if (ad.b(comparator(), collection) && collection.size() > 1) {
            ai<E> it = iterator();
            Iterator<?> it5 = collection.iterator();
            if (!it.hasNext()) {
                return false;
            }
            Object next = it5.next();
            E next2 = it.next();
            while (true) {
                try {
                    int unsafeCompare = unsafeCompare(next2, next);
                    if (unsafeCompare < 0) {
                        if (!it.hasNext()) {
                            return false;
                        }
                        next2 = it.next();
                    } else if (unsafeCompare == 0) {
                        if (!it5.hasNext()) {
                            return true;
                        }
                        next = it5.next();
                    } else if (unsafeCompare > 0) {
                        break;
                    }
                } catch (ClassCastException | NullPointerException unused) {
                }
            }
        } else {
            return super.containsAll(collection);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i3) {
        return this.elements.copyIntoArray(objArr, i3);
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> createDescendingSet() {
        Comparator reverseOrder = Collections.reverseOrder(this.comparator);
        if (isEmpty()) {
            return ImmutableSortedSet.emptySet(reverseOrder);
        }
        return new RegularImmutableSortedSet(this.elements.reverse(), reverseOrder);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (ad.b(this.comparator, set)) {
            Iterator<E> it = set.iterator();
            try {
                ai<E> it5 = iterator();
                while (it5.hasNext()) {
                    E next = it5.next();
                    E next2 = it.next();
                    if (next2 == null || unsafeCompare(next, next2) != 0) {
                        return false;
                    }
                }
                return true;
            } catch (ClassCastException | NoSuchElementException unused) {
                return false;
            }
        }
        return containsAll(set);
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E first() {
        if (!isEmpty()) {
            return this.elements.get(0);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E floor(E e16) {
        int headIndex = headIndex(e16, true) - 1;
        if (headIndex == -1) {
            return null;
        }
        return this.elements.get(headIndex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableSortedSet<E> getSubSet(int i3, int i16) {
        if (i3 == 0 && i16 == size()) {
            return this;
        }
        if (i3 < i16) {
            return new RegularImmutableSortedSet<>(this.elements.subList(i3, i16), this.comparator);
        }
        return ImmutableSortedSet.emptySet(this.comparator);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int headIndex(E e16, boolean z16) {
        int binarySearch = Collections.binarySearch(this.elements, com.google.common.base.j.m(e16), comparator());
        if (binarySearch >= 0) {
            if (z16) {
                return binarySearch + 1;
            }
            return binarySearch;
        }
        return ~binarySearch;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    public ImmutableSortedSet<E> headSetImpl(E e16, boolean z16) {
        return getSubSet(0, headIndex(e16, z16));
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E higher(E e16) {
        int tailIndex = tailIndex(e16, false);
        if (tailIndex == size()) {
            return null;
        }
        return this.elements.get(tailIndex);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableSortedSet
    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        try {
            int binarySearch = Collections.binarySearch(this.elements, obj, unsafeComparator());
            if (binarySearch < 0) {
                return -1;
            }
            return binarySearch;
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public Object[] internalArray() {
        return this.elements.internalArray();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayEnd() {
        return this.elements.internalArrayEnd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int internalArrayStart() {
        return this.elements.internalArrayStart();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return this.elements.isPartialView();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.SortedSet
    public E last() {
        if (!isEmpty()) {
            return this.elements.get(size() - 1);
        }
        throw new NoSuchElementException();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    public E lower(E e16) {
        int headIndex = headIndex(e16, false) - 1;
        if (headIndex == -1) {
            return null;
        }
        return this.elements.get(headIndex);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.elements.size();
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> subSetImpl(E e16, boolean z16, E e17, boolean z17) {
        return tailSetImpl(e16, z16).headSetImpl(e17, z17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int tailIndex(E e16, boolean z16) {
        int binarySearch = Collections.binarySearch(this.elements, com.google.common.base.j.m(e16), comparator());
        if (binarySearch >= 0) {
            if (!z16) {
                return binarySearch + 1;
            }
            return binarySearch;
        }
        return ~binarySearch;
    }

    @Override // com.google.common.collect.ImmutableSortedSet
    ImmutableSortedSet<E> tailSetImpl(E e16, boolean z16) {
        return getSubSet(tailIndex(e16, z16), size());
    }

    Comparator<Object> unsafeComparator() {
        return this.comparator;
    }

    @Override // com.google.common.collect.ImmutableSortedSet, java.util.NavigableSet
    @GwtIncompatible
    public ai<E> descendingIterator() {
        return this.elements.reverse().iterator();
    }

    @Override // com.google.common.collect.ImmutableSortedSet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public ai<E> iterator() {
        return this.elements.iterator();
    }
}
