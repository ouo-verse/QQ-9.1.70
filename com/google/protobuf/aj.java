package com.google.protobuf;

import com.google.protobuf.ad;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class aj extends d<Long> implements ad.i, RandomAccess, bh {

    /* renamed from: h, reason: collision with root package name */
    private static final aj f35661h;

    /* renamed from: e, reason: collision with root package name */
    private long[] f35662e;

    /* renamed from: f, reason: collision with root package name */
    private int f35663f;

    static {
        aj ajVar = new aj(new long[0], 0);
        f35661h = ajVar;
        ajVar.y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj() {
        this(new long[10], 0);
    }

    private void i(int i3, long j3) {
        int i16;
        d();
        if (i3 >= 0 && i3 <= (i16 = this.f35663f)) {
            long[] jArr = this.f35662e;
            if (i16 < jArr.length) {
                System.arraycopy(jArr, i3, jArr, i3 + 1, i16 - i3);
            } else {
                long[] jArr2 = new long[((i16 * 3) / 2) + 1];
                System.arraycopy(jArr, 0, jArr2, 0, i3);
                System.arraycopy(this.f35662e, i3, jArr2, i3 + 1, this.f35663f - i3);
                this.f35662e = jArr2;
            }
            this.f35662e[i3] = j3;
            this.f35663f++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(r(i3));
    }

    public static aj n() {
        return f35661h;
    }

    private void o(int i3) {
        if (i3 >= 0 && i3 < this.f35663f) {
        } else {
            throw new IndexOutOfBoundsException(r(i3));
        }
    }

    private String r(int i3) {
        return "Index:" + i3 + ", Size:" + this.f35663f;
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Long> collection) {
        d();
        ad.a(collection);
        if (!(collection instanceof aj)) {
            return super.addAll(collection);
        }
        aj ajVar = (aj) collection;
        int i3 = ajVar.f35663f;
        if (i3 == 0) {
            return false;
        }
        int i16 = this.f35663f;
        if (Integer.MAX_VALUE - i16 >= i3) {
            int i17 = i16 + i3;
            long[] jArr = this.f35662e;
            if (i17 > jArr.length) {
                this.f35662e = Arrays.copyOf(jArr, i17);
            }
            System.arraycopy(ajVar.f35662e, 0, this.f35662e, this.f35663f, ajVar.f35663f);
            this.f35663f = i17;
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
        if (!(obj instanceof aj)) {
            return super.equals(obj);
        }
        aj ajVar = (aj) obj;
        if (this.f35663f != ajVar.f35663f) {
            return false;
        }
        long[] jArr = ajVar.f35662e;
        for (int i3 = 0; i3 < this.f35663f; i3++) {
            if (this.f35662e[i3] != jArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void add(int i3, Long l3) {
        i(i3, l3.longValue());
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean add(Long l3) {
        m(l3.longValue());
        return true;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i3 = 1;
        for (int i16 = 0; i16 < this.f35663f; i16++) {
            i3 = (i3 * 31) + ad.h(this.f35662e[i16]);
        }
        return i3;
    }

    public void m(long j3) {
        d();
        int i3 = this.f35663f;
        long[] jArr = this.f35662e;
        if (i3 == jArr.length) {
            long[] jArr2 = new long[((i3 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i3);
            this.f35662e = jArr2;
        }
        long[] jArr3 = this.f35662e;
        int i16 = this.f35663f;
        this.f35663f = i16 + 1;
        jArr3[i16] = j3;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Long get(int i3) {
        return Long.valueOf(q(i3));
    }

    public long q(int i3) {
        o(i3);
        return this.f35662e[i3];
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i3, int i16) {
        d();
        if (i16 >= i3) {
            long[] jArr = this.f35662e;
            System.arraycopy(jArr, i16, jArr, i3, this.f35663f - i16);
            this.f35663f -= i16 - i3;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Long remove(int i3) {
        d();
        o(i3);
        long[] jArr = this.f35662e;
        long j3 = jArr[i3];
        if (i3 < this.f35663f - 1) {
            System.arraycopy(jArr, i3 + 1, jArr, i3, (r3 - i3) - 1);
        }
        this.f35663f--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f35663f;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public Long set(int i3, Long l3) {
        return Long.valueOf(u(i3, l3.longValue()));
    }

    public long u(int i3, long j3) {
        d();
        o(i3);
        long[] jArr = this.f35662e;
        long j16 = jArr[i3];
        jArr[i3] = j3;
        return j16;
    }

    aj(long[] jArr, int i3) {
        this.f35662e = jArr;
        this.f35663f = i3;
    }

    @Override // com.google.protobuf.ad.j, com.google.protobuf.ad.f
    /* renamed from: b */
    public ad.j<Long> b2(int i3) {
        if (i3 >= this.f35663f) {
            return new aj(Arrays.copyOf(this.f35662e, i3), this.f35663f);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        d();
        for (int i3 = 0; i3 < this.f35663f; i3++) {
            if (obj.equals(Long.valueOf(this.f35662e[i3]))) {
                long[] jArr = this.f35662e;
                System.arraycopy(jArr, i3 + 1, jArr, i3, (this.f35663f - i3) - 1);
                this.f35663f--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
