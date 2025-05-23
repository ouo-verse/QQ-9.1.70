package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: P */
@GwtCompatible(emulated = true, serializable = true)
/* loaded from: classes2.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    static final int MAX_TABLE_SIZE = 1073741824;

    /* renamed from: e, reason: collision with root package name */
    @RetainedWith
    @NullableDecl
    @LazyInit
    private transient ImmutableList<E> f34917e;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a<E> extends ImmutableCollection.a<E> {

        /* renamed from: d, reason: collision with root package name */
        @VisibleForTesting
        @NullableDecl
        Object[] f34918d;

        /* renamed from: e, reason: collision with root package name */
        private int f34919e;

        public a() {
            super(4);
        }

        private void k(E e16) {
            int length = this.f34918d.length - 1;
            int hashCode = e16.hashCode();
            int b16 = p.b(hashCode);
            while (true) {
                int i3 = b16 & length;
                Object[] objArr = this.f34918d;
                Object obj = objArr[i3];
                if (obj == null) {
                    objArr[i3] = e16;
                    this.f34919e += hashCode;
                    super.f(e16);
                    return;
                } else if (obj.equals(e16)) {
                    return;
                } else {
                    b16 = i3 + 1;
                }
            }
        }

        @Override // com.google.common.collect.ImmutableCollection.b
        @CanIgnoreReturnValue
        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public a<E> a(E e16) {
            com.google.common.base.j.m(e16);
            if (this.f34918d != null && ImmutableSet.chooseTableSize(this.f34869b) <= this.f34918d.length) {
                k(e16);
                return this;
            }
            this.f34918d = null;
            super.f(e16);
            return this;
        }

        @CanIgnoreReturnValue
        public a<E> i(E... eArr) {
            if (this.f34918d != null) {
                for (E e16 : eArr) {
                    a(e16);
                }
            } else {
                super.b(eArr);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public a<E> j(Iterator<? extends E> it) {
            com.google.common.base.j.m(it);
            while (it.hasNext()) {
                a(it.next());
            }
            return this;
        }

        public ImmutableSet<E> l() {
            ImmutableSet<E> a16;
            Object[] objArr;
            int i3 = this.f34869b;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (this.f34918d == null || ImmutableSet.chooseTableSize(i3) != this.f34918d.length) {
                        a16 = ImmutableSet.a(this.f34869b, this.f34868a);
                        this.f34869b = a16.size();
                    } else {
                        if (ImmutableSet.d(this.f34869b, this.f34868a.length)) {
                            objArr = Arrays.copyOf(this.f34868a, this.f34869b);
                        } else {
                            objArr = this.f34868a;
                        }
                        a16 = new RegularImmutableSet<>(objArr, this.f34919e, this.f34918d, r5.length - 1, this.f34869b);
                    }
                    this.f34870c = true;
                    this.f34918d = null;
                    return a16;
                }
                return ImmutableSet.of(this.f34868a[0]);
            }
            return ImmutableSet.of();
        }

        a(int i3) {
            super(i3);
            this.f34918d = new Object[ImmutableSet.chooseTableSize(i3)];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> ImmutableSet<E> a(int i3, Object... objArr) {
        if (i3 != 0) {
            if (i3 != 1) {
                int chooseTableSize = chooseTableSize(i3);
                Object[] objArr2 = new Object[chooseTableSize];
                int i16 = chooseTableSize - 1;
                int i17 = 0;
                int i18 = 0;
                for (int i19 = 0; i19 < i3; i19++) {
                    Object a16 = v.a(objArr[i19], i19);
                    int hashCode = a16.hashCode();
                    int b16 = p.b(hashCode);
                    while (true) {
                        int i26 = b16 & i16;
                        Object obj = objArr2[i26];
                        if (obj == null) {
                            objArr[i18] = a16;
                            objArr2[i26] = a16;
                            i17 += hashCode;
                            i18++;
                            break;
                        }
                        if (obj.equals(a16)) {
                            break;
                        }
                        b16++;
                    }
                }
                Arrays.fill(objArr, i18, i3, (Object) null);
                if (i18 == 1) {
                    return new SingletonImmutableSet(objArr[0], i17);
                }
                if (chooseTableSize(i18) < chooseTableSize / 2) {
                    return a(i18, objArr);
                }
                if (d(i18, objArr.length)) {
                    objArr = Arrays.copyOf(objArr, i18);
                }
                return new RegularImmutableSet(objArr, i17, objArr2, i16, i18);
            }
            return of(objArr[0]);
        }
        return of();
    }

    public static <E> a<E> builder() {
        return new a<>();
    }

    @Beta
    public static <E> a<E> builderWithExpectedSize(int i3) {
        h.b(i3, "expectedSize");
        return new a<>(i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public static int chooseTableSize(int i3) {
        int max = Math.max(i3, 2);
        boolean z16 = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (highestOneBit * 0.7d < max) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z16 = false;
        }
        com.google.common.base.j.e(z16, "collection too large");
        return 1073741824;
    }

    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return a(array.length, array);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean d(int i3, int i16) {
        if (i3 < (i16 >> 1) + (i16 >> 2)) {
            return true;
        }
        return false;
    }

    public static <E> ImmutableSet<E> of() {
        return RegularImmutableSet.EMPTY;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.f34917e;
        if (immutableList == null) {
            ImmutableList<E> createAsList = createAsList();
            this.f34917e = createAsList;
            return createAsList;
        }
        return immutableList;
    }

    ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return ab.a(this, obj);
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return ab.b(this);
    }

    boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public abstract ai<E> iterator();

    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> ImmutableSet<E> of(E e16) {
        return new SingletonImmutableSet(e16);
    }

    public static <E> ImmutableSet<E> of(E e16, E e17) {
        return a(2, e16, e17);
    }

    public static <E> ImmutableSet<E> of(E e16, E e17, E e18) {
        return a(3, e16, e17, e18);
    }

    public static <E> ImmutableSet<E> of(E e16, E e17, E e18, E e19) {
        return a(4, e16, e17, e18, e19);
    }

    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    public static <E> ImmutableSet<E> of(E e16, E e17, E e18, E e19, E e26) {
        return a(5, e16, e17, e18, e19, e26);
    }

    @SafeVarargs
    public static <E> ImmutableSet<E> of(E e16, E e17, E e18, E e19, E e26, E e27, E... eArr) {
        com.google.common.base.j.e(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e16;
        objArr[1] = e17;
        objArr[2] = e18;
        objArr[3] = e19;
        objArr[4] = e26;
        objArr[5] = e27;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return a(length, objArr);
    }

    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return of((Object) next);
        }
        return new a().a(next).j(it).l();
    }

    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return of();
        }
        if (length != 1) {
            return a(eArr.length, (Object[]) eArr.clone());
        }
        return of((Object) eArr[0]);
    }
}
