package org.jf.util;

import com.google.common.collect.r;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.Nonnull;

/* compiled from: P */
/* loaded from: classes29.dex */
public class ArraySortedSet<T> implements SortedSet<T> {

    @Nonnull
    private final Object[] arr;

    @Nonnull
    private final Comparator<? super T> comparator;

    ArraySortedSet(@Nonnull Comparator<? super T> comparator, @Nonnull T[] tArr) {
        this.comparator = comparator;
        this.arr = tArr;
    }

    public static <T> ArraySortedSet<T> of(@Nonnull Comparator<? super T> comparator, @Nonnull T[] tArr) {
        return new ArraySortedSet<>(comparator, tArr);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean add(T t16) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.SortedSet
    public Comparator<? super T> comparator() {
        return this.comparator;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        if (Arrays.binarySearch(this.arr, obj, this.comparator) >= 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) obj;
            if (this.arr.length != sortedSet.size()) {
                return false;
            }
            return r.i(iterator(), sortedSet.iterator());
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (this.arr.length != set.size()) {
            return false;
        }
        return containsAll(set);
    }

    @Override // java.util.SortedSet
    public T first() {
        Object[] objArr = this.arr;
        if (objArr.length != 0) {
            return (T) objArr[0];
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Set, java.util.Collection
    public int hashCode() {
        int i3 = 0;
        for (Object obj : this.arr) {
            i3 += obj.hashCode();
        }
        return i3;
    }

    @Override // java.util.SortedSet
    public SortedSet<T> headSet(T t16) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        if (this.arr.length > 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<T> iterator() {
        return r.m(this.arr);
    }

    @Override // java.util.SortedSet
    public T last() {
        Object[] objArr = this.arr;
        if (objArr.length != 0) {
            return (T) objArr[objArr.length - 1];
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        return this.arr.length;
    }

    @Override // java.util.SortedSet
    public SortedSet<T> subSet(T t16, T t17) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.SortedSet
    public SortedSet<T> tailSet(T t16) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        return (Object[]) this.arr.clone();
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        int length = tArr.length;
        Object[] objArr = this.arr;
        if (length <= objArr.length) {
            System.arraycopy(objArr, 0, tArr, 0, objArr.length);
            return tArr;
        }
        return (T[]) Arrays.copyOf(objArr, objArr.length);
    }
}
