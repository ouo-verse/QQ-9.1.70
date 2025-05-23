package com.google.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class bj<E> extends d<E> implements RandomAccess {

    /* renamed from: h, reason: collision with root package name */
    private static final bj<Object> f35720h;

    /* renamed from: e, reason: collision with root package name */
    private E[] f35721e;

    /* renamed from: f, reason: collision with root package name */
    private int f35722f;

    static {
        bj<Object> bjVar = new bj<>(new Object[0], 0);
        f35720h = bjVar;
        bjVar.y();
    }

    bj(E[] eArr, int i3) {
        this.f35721e = eArr;
        this.f35722f = i3;
    }

    private static <E> E[] g(int i3) {
        return (E[]) new Object[i3];
    }

    public static <E> bj<E> h() {
        return (bj<E>) f35720h;
    }

    private void i(int i3) {
        if (i3 >= 0 && i3 < this.f35722f) {
        } else {
            throw new IndexOutOfBoundsException(m(i3));
        }
    }

    private String m(int i3) {
        return "Index:" + i3 + ", Size:" + this.f35722f;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e16) {
        d();
        int i3 = this.f35722f;
        E[] eArr = this.f35721e;
        if (i3 == eArr.length) {
            this.f35721e = (E[]) Arrays.copyOf(eArr, ((i3 * 3) / 2) + 1);
        }
        E[] eArr2 = this.f35721e;
        int i16 = this.f35722f;
        this.f35722f = i16 + 1;
        eArr2[i16] = e16;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i3) {
        i(i3);
        return this.f35721e[i3];
    }

    @Override // com.google.protobuf.ad.j, com.google.protobuf.ad.f
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public bj<E> b(int i3) {
        if (i3 >= this.f35722f) {
            return new bj<>(Arrays.copyOf(this.f35721e, i3), this.f35722f);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public E remove(int i3) {
        d();
        i(i3);
        E[] eArr = this.f35721e;
        E e16 = eArr[i3];
        if (i3 < this.f35722f - 1) {
            System.arraycopy(eArr, i3 + 1, eArr, i3, (r2 - i3) - 1);
        }
        this.f35722f--;
        ((AbstractList) this).modCount++;
        return e16;
    }

    @Override // java.util.AbstractList, java.util.List
    public E set(int i3, E e16) {
        d();
        i(i3);
        E[] eArr = this.f35721e;
        E e17 = eArr[i3];
        eArr[i3] = e16;
        ((AbstractList) this).modCount++;
        return e17;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f35722f;
    }

    @Override // java.util.AbstractList, java.util.List
    public void add(int i3, E e16) {
        int i16;
        d();
        if (i3 >= 0 && i3 <= (i16 = this.f35722f)) {
            E[] eArr = this.f35721e;
            if (i16 < eArr.length) {
                System.arraycopy(eArr, i3, eArr, i3 + 1, i16 - i3);
            } else {
                E[] eArr2 = (E[]) g(((i16 * 3) / 2) + 1);
                System.arraycopy(this.f35721e, 0, eArr2, 0, i3);
                System.arraycopy(this.f35721e, i3, eArr2, i3 + 1, this.f35722f - i3);
                this.f35721e = eArr2;
            }
            this.f35721e[i3] = e16;
            this.f35722f++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(m(i3));
    }
}
