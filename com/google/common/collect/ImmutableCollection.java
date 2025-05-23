package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableList;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true)
/* loaded from: classes2.dex */
public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {

    /* renamed from: d, reason: collision with root package name */
    private static final Object[] f34867d = new Object[0];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class a<E> extends b<E> {

        /* renamed from: a, reason: collision with root package name */
        Object[] f34868a;

        /* renamed from: b, reason: collision with root package name */
        int f34869b;

        /* renamed from: c, reason: collision with root package name */
        boolean f34870c;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i3) {
            h.b(i3, "initialCapacity");
            this.f34868a = new Object[i3];
            this.f34869b = 0;
        }

        private void g(int i3) {
            Object[] objArr = this.f34868a;
            if (objArr.length < i3) {
                this.f34868a = Arrays.copyOf(objArr, b.e(objArr.length, i3));
                this.f34870c = false;
            } else if (this.f34870c) {
                this.f34868a = (Object[]) objArr.clone();
                this.f34870c = false;
            }
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        @CanIgnoreReturnValue
        public b<E> b(E... eArr) {
            v.b(eArr);
            g(this.f34869b + eArr.length);
            System.arraycopy(eArr, 0, this.f34868a, this.f34869b, eArr.length);
            this.f34869b += eArr.length;
            return this;
        }

        @CanIgnoreReturnValue
        public a<E> f(E e16) {
            com.google.common.base.j.m(e16);
            g(this.f34869b + 1);
            Object[] objArr = this.f34868a;
            int i3 = this.f34869b;
            this.f34869b = i3 + 1;
            objArr[i3] = e16;
            return this;
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static abstract class b<E> {
        /* JADX INFO: Access modifiers changed from: package-private */
        public static int e(int i3, int i16) {
            if (i16 >= 0) {
                int i17 = i3 + (i3 >> 1) + 1;
                if (i17 < i16) {
                    i17 = Integer.highestOneBit(i16 - 1) << 1;
                }
                if (i17 < 0) {
                    return Integer.MAX_VALUE;
                }
                return i17;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        }

        @CanIgnoreReturnValue
        public abstract b<E> a(E e16);

        @CanIgnoreReturnValue
        public b<E> b(E... eArr) {
            for (E e16 : eArr) {
                a(e16);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public b<E> c(Iterable<? extends E> iterable) {
            Iterator<? extends E> it = iterable.iterator();
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        @CanIgnoreReturnValue
        public b<E> d(Iterator<? extends E> it) {
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean add(E e16) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        if (isEmpty()) {
            return ImmutableList.of();
        }
        return ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public abstract boolean contains(@NullableDecl Object obj);

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public int copyIntoArray(Object[] objArr, int i3) {
        ai<E> it = iterator();
        while (it.hasNext()) {
            objArr[i3] = it.next();
            i3++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object[] internalArray() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int internalArrayEnd() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int internalArrayStart() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isPartialView();

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract ai<E> iterator();

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        return toArray(f34867d);
    }

    Object writeReplace() {
        return new ImmutableList.SerializedForm(toArray());
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final <T> T[] toArray(T[] tArr) {
        com.google.common.base.j.m(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] internalArray = internalArray();
            if (internalArray != null) {
                return (T[]) y.a(internalArray, internalArrayStart(), internalArrayEnd(), tArr);
            }
            tArr = (T[]) v.d(tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        copyIntoArray(tArr, 0);
        return tArr;
    }
}
