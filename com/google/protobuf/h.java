package com.google.protobuf;

import com.google.protobuf.ad;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class h extends d<Boolean> implements ad.a, RandomAccess, bh {

    /* renamed from: h, reason: collision with root package name */
    private static final h f35859h;

    /* renamed from: e, reason: collision with root package name */
    private boolean[] f35860e;

    /* renamed from: f, reason: collision with root package name */
    private int f35861f;

    static {
        h hVar = new h(new boolean[0], 0);
        f35859h = hVar;
        hVar.y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h() {
        this(new boolean[10], 0);
    }

    private void i(int i3, boolean z16) {
        int i16;
        d();
        if (i3 >= 0 && i3 <= (i16 = this.f35861f)) {
            boolean[] zArr = this.f35860e;
            if (i16 < zArr.length) {
                System.arraycopy(zArr, i3, zArr, i3 + 1, i16 - i3);
            } else {
                boolean[] zArr2 = new boolean[((i16 * 3) / 2) + 1];
                System.arraycopy(zArr, 0, zArr2, 0, i3);
                System.arraycopy(this.f35860e, i3, zArr2, i3 + 1, this.f35861f - i3);
                this.f35860e = zArr2;
            }
            this.f35860e[i3] = z16;
            this.f35861f++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(r(i3));
    }

    public static h n() {
        return f35859h;
    }

    private void o(int i3) {
        if (i3 >= 0 && i3 < this.f35861f) {
        } else {
            throw new IndexOutOfBoundsException(r(i3));
        }
    }

    private String r(int i3) {
        return "Index:" + i3 + ", Size:" + this.f35861f;
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Boolean> collection) {
        d();
        ad.a(collection);
        if (!(collection instanceof h)) {
            return super.addAll(collection);
        }
        h hVar = (h) collection;
        int i3 = hVar.f35861f;
        if (i3 == 0) {
            return false;
        }
        int i16 = this.f35861f;
        if (Integer.MAX_VALUE - i16 >= i3) {
            int i17 = i16 + i3;
            boolean[] zArr = this.f35860e;
            if (i17 > zArr.length) {
                this.f35860e = Arrays.copyOf(zArr, i17);
            }
            System.arraycopy(hVar.f35860e, 0, this.f35860e, this.f35861f, hVar.f35861f);
            this.f35861f = i17;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return super.equals(obj);
        }
        h hVar = (h) obj;
        if (this.f35861f != hVar.f35861f) {
            return false;
        }
        boolean[] zArr = hVar.f35860e;
        for (int i3 = 0; i3 < this.f35861f; i3++) {
            if (this.f35860e[i3] != zArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void add(int i3, Boolean bool) {
        i(i3, bool.booleanValue());
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean add(Boolean bool) {
        m(bool.booleanValue());
        return true;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i3 = 1;
        for (int i16 = 0; i16 < this.f35861f; i16++) {
            i3 = (i3 * 31) + ad.c(this.f35860e[i16]);
        }
        return i3;
    }

    public void m(boolean z16) {
        d();
        int i3 = this.f35861f;
        boolean[] zArr = this.f35860e;
        if (i3 == zArr.length) {
            boolean[] zArr2 = new boolean[((i3 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i3);
            this.f35860e = zArr2;
        }
        boolean[] zArr3 = this.f35860e;
        int i16 = this.f35861f;
        this.f35861f = i16 + 1;
        zArr3[i16] = z16;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Boolean get(int i3) {
        return Boolean.valueOf(q(i3));
    }

    public boolean q(int i3) {
        o(i3);
        return this.f35860e[i3];
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i3, int i16) {
        d();
        if (i16 >= i3) {
            boolean[] zArr = this.f35860e;
            System.arraycopy(zArr, i16, zArr, i3, this.f35861f - i16);
            this.f35861f -= i16 - i3;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Boolean remove(int i3) {
        d();
        o(i3);
        boolean[] zArr = this.f35860e;
        boolean z16 = zArr[i3];
        if (i3 < this.f35861f - 1) {
            System.arraycopy(zArr, i3 + 1, zArr, i3, (r2 - i3) - 1);
        }
        this.f35861f--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z16);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f35861f;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public Boolean set(int i3, Boolean bool) {
        return Boolean.valueOf(u(i3, bool.booleanValue()));
    }

    public boolean u(int i3, boolean z16) {
        d();
        o(i3);
        boolean[] zArr = this.f35860e;
        boolean z17 = zArr[i3];
        zArr[i3] = z16;
        return z17;
    }

    h(boolean[] zArr, int i3) {
        this.f35860e = zArr;
        this.f35861f = i3;
    }

    @Override // com.google.protobuf.ad.j, com.google.protobuf.ad.f
    /* renamed from: b */
    public ad.j<Boolean> b2(int i3) {
        if (i3 >= this.f35861f) {
            return new h(Arrays.copyOf(this.f35860e, i3), this.f35861f);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        d();
        for (int i3 = 0; i3 < this.f35861f; i3++) {
            if (obj.equals(Boolean.valueOf(this.f35860e[i3]))) {
                boolean[] zArr = this.f35860e;
                System.arraycopy(zArr, i3 + 1, zArr, i3, (this.f35861f - i3) - 1);
                this.f35861f--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
