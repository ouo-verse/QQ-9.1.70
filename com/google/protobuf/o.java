package com.google.protobuf;

import com.google.protobuf.ad;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class o extends d<Double> implements ad.b, RandomAccess, bh {

    /* renamed from: h, reason: collision with root package name */
    private static final o f35924h;

    /* renamed from: e, reason: collision with root package name */
    private double[] f35925e;

    /* renamed from: f, reason: collision with root package name */
    private int f35926f;

    static {
        o oVar = new o(new double[0], 0);
        f35924h = oVar;
        oVar.y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o() {
        this(new double[10], 0);
    }

    private void m(int i3, double d16) {
        int i16;
        d();
        if (i3 >= 0 && i3 <= (i16 = this.f35926f)) {
            double[] dArr = this.f35925e;
            if (i16 < dArr.length) {
                System.arraycopy(dArr, i3, dArr, i3 + 1, i16 - i3);
            } else {
                double[] dArr2 = new double[((i16 * 3) / 2) + 1];
                System.arraycopy(dArr, 0, dArr2, 0, i3);
                System.arraycopy(this.f35925e, i3, dArr2, i3 + 1, this.f35926f - i3);
                this.f35925e = dArr2;
            }
            this.f35925e[i3] = d16;
            this.f35926f++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(r(i3));
    }

    public static o n() {
        return f35924h;
    }

    private void o(int i3) {
        if (i3 >= 0 && i3 < this.f35926f) {
        } else {
            throw new IndexOutOfBoundsException(r(i3));
        }
    }

    private String r(int i3) {
        return "Index:" + i3 + ", Size:" + this.f35926f;
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Double> collection) {
        d();
        ad.a(collection);
        if (!(collection instanceof o)) {
            return super.addAll(collection);
        }
        o oVar = (o) collection;
        int i3 = oVar.f35926f;
        if (i3 == 0) {
            return false;
        }
        int i16 = this.f35926f;
        if (Integer.MAX_VALUE - i16 >= i3) {
            int i17 = i16 + i3;
            double[] dArr = this.f35925e;
            if (i17 > dArr.length) {
                this.f35925e = Arrays.copyOf(dArr, i17);
            }
            System.arraycopy(oVar.f35925e, 0, this.f35925e, this.f35926f, oVar.f35926f);
            this.f35926f = i17;
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
        if (!(obj instanceof o)) {
            return super.equals(obj);
        }
        o oVar = (o) obj;
        if (this.f35926f != oVar.f35926f) {
            return false;
        }
        double[] dArr = oVar.f35925e;
        for (int i3 = 0; i3 < this.f35926f; i3++) {
            if (Double.doubleToLongBits(this.f35925e[i3]) != Double.doubleToLongBits(dArr[i3])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void add(int i3, Double d16) {
        m(i3, d16.doubleValue());
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean add(Double d16) {
        i(d16.doubleValue());
        return true;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i3 = 1;
        for (int i16 = 0; i16 < this.f35926f; i16++) {
            i3 = (i3 * 31) + ad.h(Double.doubleToLongBits(this.f35925e[i16]));
        }
        return i3;
    }

    public void i(double d16) {
        d();
        int i3 = this.f35926f;
        double[] dArr = this.f35925e;
        if (i3 == dArr.length) {
            double[] dArr2 = new double[((i3 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i3);
            this.f35925e = dArr2;
        }
        double[] dArr3 = this.f35925e;
        int i16 = this.f35926f;
        this.f35926f = i16 + 1;
        dArr3[i16] = d16;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public Double get(int i3) {
        return Double.valueOf(q(i3));
    }

    public double q(int i3) {
        o(i3);
        return this.f35925e[i3];
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i3, int i16) {
        d();
        if (i16 >= i3) {
            double[] dArr = this.f35925e;
            System.arraycopy(dArr, i16, dArr, i3, this.f35926f - i16);
            this.f35926f -= i16 - i3;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public Double remove(int i3) {
        d();
        o(i3);
        double[] dArr = this.f35925e;
        double d16 = dArr[i3];
        if (i3 < this.f35926f - 1) {
            System.arraycopy(dArr, i3 + 1, dArr, i3, (r3 - i3) - 1);
        }
        this.f35926f--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d16);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f35926f;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public Double set(int i3, Double d16) {
        return Double.valueOf(u(i3, d16.doubleValue()));
    }

    public double u(int i3, double d16) {
        d();
        o(i3);
        double[] dArr = this.f35925e;
        double d17 = dArr[i3];
        dArr[i3] = d16;
        return d17;
    }

    o(double[] dArr, int i3) {
        this.f35925e = dArr;
        this.f35926f = i3;
    }

    @Override // com.google.protobuf.ad.j, com.google.protobuf.ad.f
    /* renamed from: b */
    public ad.j<Double> b2(int i3) {
        if (i3 >= this.f35926f) {
            return new o(Arrays.copyOf(this.f35925e, i3), this.f35926f);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        d();
        for (int i3 = 0; i3 < this.f35926f; i3++) {
            if (obj.equals(Double.valueOf(this.f35925e[i3]))) {
                double[] dArr = this.f35925e;
                System.arraycopy(dArr, i3 + 1, dArr, i3, (this.f35926f - i3) - 1);
                this.f35926f--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
