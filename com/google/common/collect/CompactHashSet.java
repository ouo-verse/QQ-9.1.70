package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@GwtIncompatible
/* loaded from: classes2.dex */
public class CompactHashSet<E> extends AbstractSet<E> implements Serializable {
    static final int UNSET = -1;

    /* renamed from: d, reason: collision with root package name */
    @MonotonicNonNullDecl
    private transient int[] f34856d;

    /* renamed from: e, reason: collision with root package name */
    @MonotonicNonNullDecl
    private transient long[] f34857e;

    @MonotonicNonNullDecl
    transient Object[] elements;

    /* renamed from: f, reason: collision with root package name */
    private transient int f34858f;

    /* renamed from: h, reason: collision with root package name */
    private transient int f34859h;
    transient float loadFactor;
    transient int modCount;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements Iterator<E> {

        /* renamed from: d, reason: collision with root package name */
        int f34860d;

        /* renamed from: e, reason: collision with root package name */
        int f34861e;

        /* renamed from: f, reason: collision with root package name */
        int f34862f = -1;

        a() {
            this.f34860d = CompactHashSet.this.modCount;
            this.f34861e = CompactHashSet.this.firstEntryIndex();
        }

        private void a() {
            if (CompactHashSet.this.modCount == this.f34860d) {
            } else {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f34861e >= 0) {
                return true;
            }
            return false;
        }

        @Override // java.util.Iterator
        public E next() {
            a();
            if (hasNext()) {
                int i3 = this.f34861e;
                this.f34862f = i3;
                CompactHashSet compactHashSet = CompactHashSet.this;
                E e16 = (E) compactHashSet.elements[i3];
                this.f34861e = compactHashSet.getSuccessor(i3);
                return e16;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            boolean z16;
            a();
            if (this.f34862f >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            h.d(z16);
            this.f34860d++;
            CompactHashSet compactHashSet = CompactHashSet.this;
            compactHashSet.m(compactHashSet.elements[this.f34862f], CompactHashSet.a(compactHashSet.f34857e[this.f34862f]));
            this.f34861e = CompactHashSet.this.adjustAfterRemove(this.f34861e, this.f34862f);
            this.f34862f = -1;
        }
    }

    CompactHashSet() {
        init(3, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(long j3) {
        return (int) (j3 >>> 32);
    }

    public static <E> CompactHashSet<E> create() {
        return new CompactHashSet<>();
    }

    public static <E> CompactHashSet<E> createWithExpectedSize(int i3) {
        return new CompactHashSet<>(i3);
    }

    private static int d(long j3) {
        return (int) j3;
    }

    private int g() {
        return this.f34856d.length - 1;
    }

    private static long[] h(int i3) {
        long[] jArr = new long[i3];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] i(int i3) {
        int[] iArr = new int[i3];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @CanIgnoreReturnValue
    public boolean m(Object obj, int i3) {
        int g16 = g() & i3;
        int i16 = this.f34856d[g16];
        if (i16 == -1) {
            return false;
        }
        int i17 = -1;
        while (true) {
            if (a(this.f34857e[i16]) == i3 && com.google.common.base.g.a(obj, this.elements[i16])) {
                if (i17 == -1) {
                    this.f34856d[g16] = d(this.f34857e[i16]);
                } else {
                    long[] jArr = this.f34857e;
                    jArr[i17] = p(jArr[i17], d(jArr[i16]));
                }
                moveEntry(i16);
                this.f34859h--;
                this.modCount++;
                return true;
            }
            int d16 = d(this.f34857e[i16]);
            if (d16 == -1) {
                return false;
            }
            i17 = i16;
            i16 = d16;
        }
    }

    private void n(int i3) {
        int length = this.f34857e.length;
        if (i3 > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                resizeEntries(max);
            }
        }
    }

    private void o(int i3) {
        if (this.f34856d.length >= 1073741824) {
            this.f34858f = Integer.MAX_VALUE;
            return;
        }
        int i16 = ((int) (i3 * this.loadFactor)) + 1;
        int[] i17 = i(i3);
        long[] jArr = this.f34857e;
        int length = i17.length - 1;
        for (int i18 = 0; i18 < this.f34859h; i18++) {
            int a16 = a(jArr[i18]);
            int i19 = a16 & length;
            int i26 = i17[i19];
            i17[i19] = i18;
            jArr[i18] = (a16 << 32) | (i26 & 4294967295L);
        }
        this.f34858f = i16;
        this.f34856d = i17;
    }

    private static long p(long j3, int i3) {
        return (j3 & (-4294967296L)) | (4294967295L & i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        init(3, 1.0f);
        int readInt = objectInputStream.readInt();
        while (true) {
            readInt--;
            if (readInt >= 0) {
                add(objectInputStream.readObject());
            } else {
                return;
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.f34859h);
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean add(@NullableDecl E e16) {
        long[] jArr = this.f34857e;
        Object[] objArr = this.elements;
        int c16 = p.c(e16);
        int g16 = g() & c16;
        int i3 = this.f34859h;
        int[] iArr = this.f34856d;
        int i16 = iArr[g16];
        if (i16 == -1) {
            iArr[g16] = i3;
        } else {
            while (true) {
                long j3 = jArr[i16];
                if (a(j3) == c16 && com.google.common.base.g.a(e16, objArr[i16])) {
                    return false;
                }
                int d16 = d(j3);
                if (d16 == -1) {
                    jArr[i16] = p(j3, i3);
                    break;
                }
                i16 = d16;
            }
        }
        if (i3 != Integer.MAX_VALUE) {
            int i17 = i3 + 1;
            n(i17);
            insertEntry(i3, e16, c16);
            this.f34859h = i17;
            if (i3 >= this.f34858f) {
                o(this.f34856d.length * 2);
            }
            this.modCount++;
            return true;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    int adjustAfterRemove(int i3, int i16) {
        return i3 - 1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this.modCount++;
        Arrays.fill(this.elements, 0, this.f34859h, (Object) null);
        Arrays.fill(this.f34856d, -1);
        Arrays.fill(this.f34857e, -1L);
        this.f34859h = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean contains(@NullableDecl Object obj) {
        int c16 = p.c(obj);
        int i3 = this.f34856d[g() & c16];
        while (i3 != -1) {
            long j3 = this.f34857e[i3];
            if (a(j3) == c16 && com.google.common.base.g.a(obj, this.elements[i3])) {
                return true;
            }
            i3 = d(j3);
        }
        return false;
    }

    int firstEntryIndex() {
        if (isEmpty()) {
            return -1;
        }
        return 0;
    }

    int getSuccessor(int i3) {
        int i16 = i3 + 1;
        if (i16 >= this.f34859h) {
            return -1;
        }
        return i16;
    }

    void init(int i3, float f16) {
        boolean z16;
        boolean z17 = false;
        if (i3 >= 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        com.google.common.base.j.e(z16, "Initial capacity must be non-negative");
        if (f16 > 0.0f) {
            z17 = true;
        }
        com.google.common.base.j.e(z17, "Illegal load factor");
        int a16 = p.a(i3, f16);
        this.f34856d = i(a16);
        this.loadFactor = f16;
        this.elements = new Object[i3];
        this.f34857e = h(i3);
        this.f34858f = Math.max(1, (int) (a16 * f16));
    }

    void insertEntry(int i3, E e16, int i16) {
        this.f34857e[i3] = (i16 << 32) | 4294967295L;
        this.elements[i3] = e16;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        if (this.f34859h == 0) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<E> iterator() {
        return new a();
    }

    void moveEntry(int i3) {
        int size = size() - 1;
        if (i3 < size) {
            Object[] objArr = this.elements;
            objArr[i3] = objArr[size];
            objArr[size] = null;
            long[] jArr = this.f34857e;
            long j3 = jArr[size];
            jArr[i3] = j3;
            jArr[size] = -1;
            int a16 = a(j3) & g();
            int[] iArr = this.f34856d;
            int i16 = iArr[a16];
            if (i16 == size) {
                iArr[a16] = i3;
                return;
            }
            while (true) {
                long j16 = this.f34857e[i16];
                int d16 = d(j16);
                if (d16 == size) {
                    this.f34857e[i16] = p(j16, i3);
                    return;
                }
                i16 = d16;
            }
        } else {
            this.elements[i3] = null;
            this.f34857e[i3] = -1;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public boolean remove(@NullableDecl Object obj) {
        return m(obj, p.c(obj));
    }

    void resizeEntries(int i3) {
        this.elements = Arrays.copyOf(this.elements, i3);
        long[] jArr = this.f34857e;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i3);
        if (i3 > length) {
            Arrays.fill(copyOf, length, i3, -1L);
        }
        this.f34857e = copyOf;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this.f34859h;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return Arrays.copyOf(this.elements, this.f34859h);
    }

    public void trimToSize() {
        int i3 = this.f34859h;
        if (i3 < this.f34857e.length) {
            resizeEntries(i3);
        }
        int max = Math.max(1, Integer.highestOneBit((int) (i3 / this.loadFactor)));
        if (max < 1073741824 && i3 / max > this.loadFactor) {
            max <<= 1;
        }
        if (max < this.f34856d.length) {
            o(max);
        }
    }

    public static <E> CompactHashSet<E> create(Collection<? extends E> collection) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        return (T[]) v.e(this.elements, 0, this.f34859h, tArr);
    }

    CompactHashSet(int i3) {
        init(i3, 1.0f);
    }

    public static <E> CompactHashSet<E> create(E... eArr) {
        CompactHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }
}
