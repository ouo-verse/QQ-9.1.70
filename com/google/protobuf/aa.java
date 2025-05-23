package com.google.protobuf;

import com.google.protobuf.ad;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class aa extends d<Float> implements ad.f, RandomAccess, bh {

    /* renamed from: h, reason: collision with root package name */
    private static final aa f35633h;

    /* renamed from: e, reason: collision with root package name */
    private float[] f35634e;

    /* renamed from: f, reason: collision with root package name */
    private int f35635f;

    static {
        aa aaVar = new aa(new float[0], 0);
        f35633h = aaVar;
        aaVar.y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa() {
        this(new float[10], 0);
    }

    private void i(int i3, float f16) {
        int i16;
        d();
        if (i3 >= 0 && i3 <= (i16 = this.f35635f)) {
            float[] fArr = this.f35634e;
            if (i16 < fArr.length) {
                System.arraycopy(fArr, i3, fArr, i3 + 1, i16 - i3);
            } else {
                float[] fArr2 = new float[((i16 * 3) / 2) + 1];
                System.arraycopy(fArr, 0, fArr2, 0, i3);
                System.arraycopy(this.f35634e, i3, fArr2, i3 + 1, this.f35635f - i3);
                this.f35634e = fArr2;
            }
            this.f35634e[i3] = f16;
            this.f35635f++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(p(i3));
    }

    public static aa m() {
        return f35633h;
    }

    private void n(int i3) {
        if (i3 >= 0 && i3 < this.f35635f) {
        } else {
            throw new IndexOutOfBoundsException(p(i3));
        }
    }

    private String p(int i3) {
        return "Index:" + i3 + ", Size:" + this.f35635f;
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Float> collection) {
        d();
        ad.a(collection);
        if (!(collection instanceof aa)) {
            return super.addAll(collection);
        }
        aa aaVar = (aa) collection;
        int i3 = aaVar.f35635f;
        if (i3 == 0) {
            return false;
        }
        int i16 = this.f35635f;
        if (Integer.MAX_VALUE - i16 >= i3) {
            int i17 = i16 + i3;
            float[] fArr = this.f35634e;
            if (i17 > fArr.length) {
                this.f35634e = Arrays.copyOf(fArr, i17);
            }
            System.arraycopy(aaVar.f35634e, 0, this.f35634e, this.f35635f, aaVar.f35635f);
            this.f35635f = i17;
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
        if (!(obj instanceof aa)) {
            return super.equals(obj);
        }
        aa aaVar = (aa) obj;
        if (this.f35635f != aaVar.f35635f) {
            return false;
        }
        float[] fArr = aaVar.f35634e;
        for (int i3 = 0; i3 < this.f35635f; i3++) {
            if (Float.floatToIntBits(this.f35634e[i3]) != Float.floatToIntBits(fArr[i3])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void add(int i3, Float f16) {
        i(i3, f16.floatValue());
    }

    @Override // com.google.protobuf.ad.f
    public float getFloat(int i3) {
        n(i3);
        return this.f35634e[i3];
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean add(Float f16) {
        j(f16.floatValue());
        return true;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i3 = 1;
        for (int i16 = 0; i16 < this.f35635f; i16++) {
            i3 = (i3 * 31) + Float.floatToIntBits(this.f35634e[i16]);
        }
        return i3;
    }

    @Override // com.google.protobuf.ad.f
    public void j(float f16) {
        d();
        int i3 = this.f35635f;
        float[] fArr = this.f35634e;
        if (i3 == fArr.length) {
            float[] fArr2 = new float[((i3 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i3);
            this.f35634e = fArr2;
        }
        float[] fArr3 = this.f35634e;
        int i16 = this.f35635f;
        this.f35635f = i16 + 1;
        fArr3[i16] = f16;
    }

    @Override // com.google.protobuf.ad.f
    public float l(int i3, float f16) {
        d();
        n(i3);
        float[] fArr = this.f35634e;
        float f17 = fArr[i3];
        fArr[i3] = f16;
        return f17;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public Float get(int i3) {
        return Float.valueOf(getFloat(i3));
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Float remove(int i3) {
        d();
        n(i3);
        float[] fArr = this.f35634e;
        float f16 = fArr[i3];
        if (i3 < this.f35635f - 1) {
            System.arraycopy(fArr, i3 + 1, fArr, i3, (r2 - i3) - 1);
        }
        this.f35635f--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f16);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Float set(int i3, Float f16) {
        return Float.valueOf(l(i3, f16.floatValue()));
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i3, int i16) {
        d();
        if (i16 >= i3) {
            float[] fArr = this.f35634e;
            System.arraycopy(fArr, i16, fArr, i3, this.f35635f - i16);
            this.f35635f -= i16 - i3;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f35635f;
    }

    aa(float[] fArr, int i3) {
        this.f35634e = fArr;
        this.f35635f = i3;
    }

    @Override // com.google.protobuf.ad.j, com.google.protobuf.ad.f
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public ad.j<Float> b2(int i3) {
        if (i3 >= this.f35635f) {
            return new aa(Arrays.copyOf(this.f35634e, i3), this.f35635f);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        d();
        for (int i3 = 0; i3 < this.f35635f; i3++) {
            if (obj.equals(Float.valueOf(this.f35634e[i3]))) {
                float[] fArr = this.f35634e;
                System.arraycopy(fArr, i3 + 1, fArr, i3, (this.f35635f - i3) - 1);
                this.f35635f--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
