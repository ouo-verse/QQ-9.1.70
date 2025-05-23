package com.google.protobuf;

import com.google.protobuf.ad;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes2.dex */
public final class ac extends d<Integer> implements ad.g, RandomAccess, bh {

    /* renamed from: h, reason: collision with root package name */
    private static final ac f35637h;

    /* renamed from: e, reason: collision with root package name */
    private int[] f35638e;

    /* renamed from: f, reason: collision with root package name */
    private int f35639f;

    static {
        ac acVar = new ac(new int[0], 0);
        f35637h = acVar;
        acVar.y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac() {
        this(new int[10], 0);
    }

    private void i(int i3, int i16) {
        int i17;
        d();
        if (i3 >= 0 && i3 <= (i17 = this.f35639f)) {
            int[] iArr = this.f35638e;
            if (i17 < iArr.length) {
                System.arraycopy(iArr, i3, iArr, i3 + 1, i17 - i3);
            } else {
                int[] iArr2 = new int[((i17 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i3);
                System.arraycopy(this.f35638e, i3, iArr2, i3 + 1, this.f35639f - i3);
                this.f35638e = iArr2;
            }
            this.f35638e[i3] = i16;
            this.f35639f++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(p(i3));
    }

    public static ac m() {
        return f35637h;
    }

    private void n(int i3) {
        if (i3 >= 0 && i3 < this.f35639f) {
        } else {
            throw new IndexOutOfBoundsException(p(i3));
        }
    }

    private String p(int i3) {
        return "Index:" + i3 + ", Size:" + this.f35639f;
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        d();
        ad.a(collection);
        if (!(collection instanceof ac)) {
            return super.addAll(collection);
        }
        ac acVar = (ac) collection;
        int i3 = acVar.f35639f;
        if (i3 == 0) {
            return false;
        }
        int i16 = this.f35639f;
        if (Integer.MAX_VALUE - i16 >= i3) {
            int i17 = i16 + i3;
            int[] iArr = this.f35638e;
            if (i17 > iArr.length) {
                this.f35638e = Arrays.copyOf(iArr, i17);
            }
            System.arraycopy(acVar.f35638e, 0, this.f35638e, this.f35639f, acVar.f35639f);
            this.f35639f = i17;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.protobuf.ad.g
    public void e(int i3) {
        d();
        int i16 = this.f35639f;
        int[] iArr = this.f35638e;
        if (i16 == iArr.length) {
            int[] iArr2 = new int[((i16 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i16);
            this.f35638e = iArr2;
        }
        int[] iArr3 = this.f35638e;
        int i17 = this.f35639f;
        this.f35639f = i17 + 1;
        iArr3[i17] = i3;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ac)) {
            return super.equals(obj);
        }
        ac acVar = (ac) obj;
        if (this.f35639f != acVar.f35639f) {
            return false;
        }
        int[] iArr = acVar.f35638e;
        for (int i3 = 0; i3 < this.f35639f; i3++) {
            if (this.f35638e[i3] != iArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void add(int i3, Integer num) {
        i(i3, num.intValue());
    }

    @Override // com.google.protobuf.ad.g
    public int getInt(int i3) {
        n(i3);
        return this.f35638e[i3];
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public boolean add(Integer num) {
        e(num.intValue());
        return true;
    }

    @Override // com.google.protobuf.d, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i3 = 1;
        for (int i16 = 0; i16 < this.f35639f; i16++) {
            i3 = (i3 * 31) + this.f35638e[i16];
        }
        return i3;
    }

    @Override // com.google.protobuf.ad.g
    public int k(int i3, int i16) {
        d();
        n(i3);
        int[] iArr = this.f35638e;
        int i17 = iArr[i3];
        iArr[i3] = i16;
        return i17;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public Integer get(int i3) {
        return Integer.valueOf(getInt(i3));
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Integer remove(int i3) {
        d();
        n(i3);
        int[] iArr = this.f35638e;
        int i16 = iArr[i3];
        if (i3 < this.f35639f - 1) {
            System.arraycopy(iArr, i3 + 1, iArr, i3, (r2 - i3) - 1);
        }
        this.f35639f--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i16);
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public Integer set(int i3, Integer num) {
        return Integer.valueOf(k(i3, num.intValue()));
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i3, int i16) {
        d();
        if (i16 >= i3) {
            int[] iArr = this.f35638e;
            System.arraycopy(iArr, i16, iArr, i3, this.f35639f - i16);
            this.f35639f -= i16 - i3;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f35639f;
    }

    ac(int[] iArr, int i3) {
        this.f35638e = iArr;
        this.f35639f = i3;
    }

    @Override // com.google.protobuf.ad.j, com.google.protobuf.ad.f
    /* renamed from: b */
    public ad.j<Integer> b2(int i3) {
        if (i3 >= this.f35639f) {
            return new ac(Arrays.copyOf(this.f35638e, i3), this.f35639f);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        d();
        for (int i3 = 0; i3 < this.f35639f; i3++) {
            if (obj.equals(Integer.valueOf(this.f35638e[i3]))) {
                int[] iArr = this.f35638e;
                System.arraycopy(iArr, i3 + 1, iArr, i3, (this.f35639f - i3) - 1);
                this.f35639f--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }
}
