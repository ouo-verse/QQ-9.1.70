package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    /* renamed from: e, reason: collision with root package name */
    private static final aj<Object> f34871e = new b(RegularImmutableList.EMPTY, 0);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class ReverseImmutableList<E> extends ImmutableList<E> {

        /* renamed from: f, reason: collision with root package name */
        private final transient ImmutableList<E> f34872f;

        ReverseImmutableList(ImmutableList<E> immutableList) {
            this.f34872f = immutableList;
        }

        private int d(int i3) {
            return (size() - 1) - i3;
        }

        private int g(int i3) {
            return size() - i3;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
        public boolean contains(@NullableDecl Object obj) {
            return this.f34872f.contains(obj);
        }

        @Override // java.util.List
        public E get(int i3) {
            com.google.common.base.j.k(i3, size());
            return this.f34872f.get(d(i3));
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int indexOf(@NullableDecl Object obj) {
            int lastIndexOf = this.f34872f.lastIndexOf(obj);
            if (lastIndexOf >= 0) {
                return d(lastIndexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return this.f34872f.isPartialView();
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public int lastIndexOf(@NullableDecl Object obj) {
            int indexOf = this.f34872f.indexOf(obj);
            if (indexOf >= 0) {
                return d(indexOf);
            }
            return -1;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // com.google.common.collect.ImmutableList
        public ImmutableList<E> reverse() {
            return this.f34872f;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f34872f.size();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i3) {
            return super.listIterator(i3);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i3, int i16) {
            com.google.common.base.j.r(i3, i16, size());
            return this.f34872f.subList(g(i16), g(i3)).reverse();
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        /* JADX INFO: Access modifiers changed from: package-private */
        public SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        Object readResolve() {
            return ImmutableList.copyOf(this.elements);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class SubList extends ImmutableList<E> {
        final transient int length;
        final transient int offset;

        SubList(int i3, int i16) {
            this.offset = i3;
            this.length = i16;
        }

        @Override // java.util.List
        public E get(int i3) {
            com.google.common.base.j.k(i3, this.length);
            return ImmutableList.this.get(i3 + this.offset);
        }

        @Override // com.google.common.collect.ImmutableCollection
        Object[] internalArray() {
            return ImmutableList.this.internalArray();
        }

        @Override // com.google.common.collect.ImmutableCollection
        int internalArrayEnd() {
            return ImmutableList.this.internalArrayStart() + this.offset + this.length;
        }

        @Override // com.google.common.collect.ImmutableCollection
        int internalArrayStart() {
            return ImmutableList.this.internalArrayStart() + this.offset;
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.iterator();
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator() {
            return super.listIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.length;
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public /* bridge */ /* synthetic */ ListIterator listIterator(int i3) {
            return super.listIterator(i3);
        }

        @Override // com.google.common.collect.ImmutableList, java.util.List
        public ImmutableList<E> subList(int i3, int i16) {
            com.google.common.base.j.r(i3, i16, this.length);
            ImmutableList immutableList = ImmutableList.this;
            int i17 = this.offset;
            return immutableList.subList(i3 + i17, i16 + i17);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static final class a<E> extends ImmutableCollection.a<E> {
        public a() {
            this(4);
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        @CanIgnoreReturnValue
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public a<E> a(E e16) {
            super.f(e16);
            return this;
        }

        @CanIgnoreReturnValue
        public a<E> i(Iterator<? extends E> it) {
            super.d(it);
            return this;
        }

        public ImmutableList<E> j() {
            this.f34870c = true;
            return ImmutableList.asImmutableList(this.f34868a, this.f34869b);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i3) {
            super(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b<E> extends com.google.common.collect.a<E> {

        /* renamed from: f, reason: collision with root package name */
        private final ImmutableList<E> f34873f;

        b(ImmutableList<E> immutableList, int i3) {
            super(immutableList.size(), i3);
            this.f34873f = immutableList;
        }

        @Override // com.google.common.collect.a
        protected E a(int i3) {
            return this.f34873f.get(i3);
        }
    }

    private static <E> ImmutableList<E> a(Object... objArr) {
        return asImmutableList(v.b(objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableList<E> asImmutableList(Object[] objArr) {
        return asImmutableList(objArr, objArr.length);
    }

    public static <E> a<E> builder() {
        return new a<>();
    }

    @Beta
    public static <E> a<E> builderWithExpectedSize(int i3) {
        h.b(i3, "expectedSize");
        return new a<>(i3);
    }

    public static <E> ImmutableList<E> copyOf(Iterable<? extends E> iterable) {
        com.google.common.base.j.m(iterable);
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableList<E> of() {
        return (ImmutableList<E>) RegularImmutableList.EMPTY;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static <E extends Comparable<? super E>> ImmutableList<E> sortedCopyOf(Iterable<? extends E> iterable) {
        Comparable[] comparableArr = (Comparable[]) q.l(iterable, new Comparable[0]);
        v.b(comparableArr);
        Arrays.sort(comparableArr);
        return asImmutableList(comparableArr);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i3, E e16) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(int i3, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(@NullableDecl Object obj) {
        if (indexOf(obj) >= 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i3) {
        int size = size();
        for (int i16 = 0; i16 < size; i16++) {
            objArr[i3 + i16] = get(i16);
        }
        return i3 + size;
    }

    @Override // java.util.Collection, java.util.List
    public boolean equals(@NullableDecl Object obj) {
        return Lists.c(this, obj);
    }

    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i3 = 1;
        for (int i16 = 0; i16 < size; i16++) {
            i3 = ~(~((i3 * 31) + get(i16).hashCode()));
        }
        return i3;
    }

    @Override // java.util.List
    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.d(this, obj);
    }

    @Override // java.util.List
    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        return Lists.f(this, obj);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final E remove(int i3) {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> reverse() {
        if (size() <= 1) {
            return this;
        }
        return new ReverseImmutableList(this);
    }

    @Override // java.util.List
    @CanIgnoreReturnValue
    @Deprecated
    public final E set(int i3, E e16) {
        throw new UnsupportedOperationException();
    }

    ImmutableList<E> subListUnchecked(int i3, int i16) {
        return new SubList(i3, i16 - i3);
    }

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableList<E> asImmutableList(Object[] objArr, int i3) {
        if (i3 == 0) {
            return of();
        }
        return new RegularImmutableList(objArr, i3);
    }

    public static <E> ImmutableList<E> of(E e16) {
        return a(e16);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public ai<E> iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public ImmutableList<E> subList(int i3, int i16) {
        com.google.common.base.j.r(i3, i16, size());
        int i17 = i16 - i3;
        if (i17 == size()) {
            return this;
        }
        if (i17 == 0) {
            return of();
        }
        return subListUnchecked(i3, i16);
    }

    public static <E> ImmutableList<E> of(E e16, E e17) {
        return a(e16, e17);
    }

    @Override // java.util.List
    public aj<E> listIterator() {
        return listIterator(0);
    }

    public static <E> ImmutableList<E> of(E e16, E e17, E e18) {
        return a(e16, e17, e18);
    }

    @Override // java.util.List
    public aj<E> listIterator(int i3) {
        com.google.common.base.j.p(i3, size());
        if (isEmpty()) {
            return (aj<E>) f34871e;
        }
        return new b(this, i3);
    }

    public static <E> ImmutableList<E> copyOf(Collection<? extends E> collection) {
        if (collection instanceof ImmutableCollection) {
            ImmutableList<E> asList = ((ImmutableCollection) collection).asList();
            return asList.isPartialView() ? asImmutableList(asList.toArray()) : asList;
        }
        return a(collection.toArray());
    }

    public static <E> ImmutableList<E> of(E e16, E e17, E e18, E e19) {
        return a(e16, e17, e18, e19);
    }

    public static <E> ImmutableList<E> sortedCopyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        com.google.common.base.j.m(comparator);
        Object[] k3 = q.k(iterable);
        v.b(k3);
        Arrays.sort(k3, comparator);
        return asImmutableList(k3);
    }

    public static <E> ImmutableList<E> of(E e16, E e17, E e18, E e19, E e26) {
        return a(e16, e17, e18, e19, e26);
    }

    public static <E> ImmutableList<E> of(E e16, E e17, E e18, E e19, E e26, E e27) {
        return a(e16, e17, e18, e19, e26, e27);
    }

    public static <E> ImmutableList<E> of(E e16, E e17, E e18, E e19, E e26, E e27, E e28) {
        return a(e16, e17, e18, e19, e26, e27, e28);
    }

    public static <E> ImmutableList<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new a().a(next).i(it).j();
    }

    public static <E> ImmutableList<E> of(E e16, E e17, E e18, E e19, E e26, E e27, E e28, E e29) {
        return a(e16, e17, e18, e19, e26, e27, e28, e29);
    }

    public static <E> ImmutableList<E> of(E e16, E e17, E e18, E e19, E e26, E e27, E e28, E e29, E e36) {
        return a(e16, e17, e18, e19, e26, e27, e28, e29, e36);
    }

    public static <E> ImmutableList<E> of(E e16, E e17, E e18, E e19, E e26, E e27, E e28, E e29, E e36, E e37) {
        return a(e16, e17, e18, e19, e26, e27, e28, e29, e36, e37);
    }

    public static <E> ImmutableList<E> of(E e16, E e17, E e18, E e19, E e26, E e27, E e28, E e29, E e36, E e37, E e38) {
        return a(e16, e17, e18, e19, e26, e27, e28, e29, e36, e37, e38);
    }

    @SafeVarargs
    public static <E> ImmutableList<E> of(E e16, E e17, E e18, E e19, E e26, E e27, E e28, E e29, E e36, E e37, E e38, E e39, E... eArr) {
        com.google.common.base.j.e(eArr.length <= 2147483635, "the total number of elements must fit in an int");
        Object[] objArr = new Object[eArr.length + 12];
        objArr[0] = e16;
        objArr[1] = e17;
        objArr[2] = e18;
        objArr[3] = e19;
        objArr[4] = e26;
        objArr[5] = e27;
        objArr[6] = e28;
        objArr[7] = e29;
        objArr[8] = e36;
        objArr[9] = e37;
        objArr[10] = e38;
        objArr[11] = e39;
        System.arraycopy(eArr, 0, objArr, 12, eArr.length);
        return a(objArr);
    }

    public static <E> ImmutableList<E> copyOf(E[] eArr) {
        if (eArr.length == 0) {
            return of();
        }
        return a((Object[]) eArr.clone());
    }

    @Override // com.google.common.collect.ImmutableCollection
    public final ImmutableList<E> asList() {
        return this;
    }
}
