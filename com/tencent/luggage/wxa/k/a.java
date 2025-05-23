package com.tencent.luggage.wxa.k;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.SparseArrayCompat;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements Comparable, Parcelable {

    /* renamed from: a, reason: collision with root package name */
    public final int f131238a;

    /* renamed from: b, reason: collision with root package name */
    public final int f131239b;

    /* renamed from: c, reason: collision with root package name */
    public static final SparseArrayCompat f131237c = new SparseArrayCompat(16);
    public static final Parcelable.Creator<a> CREATOR = new C6348a();

    public a(int i3, int i16) {
        this.f131238a = i3;
        this.f131239b = i16;
    }

    public static a b(int i3, int i16) {
        int a16 = a(i3, i16);
        int i17 = i3 / a16;
        int i18 = i16 / a16;
        SparseArrayCompat sparseArrayCompat = f131237c;
        SparseArrayCompat sparseArrayCompat2 = (SparseArrayCompat) sparseArrayCompat.get(i17);
        if (sparseArrayCompat2 == null) {
            a aVar = new a(i17, i18);
            SparseArrayCompat sparseArrayCompat3 = new SparseArrayCompat();
            sparseArrayCompat3.put(i18, aVar);
            sparseArrayCompat.put(i17, sparseArrayCompat3);
            return aVar;
        }
        a aVar2 = (a) sparseArrayCompat2.get(i18);
        if (aVar2 != null) {
            return aVar2;
        }
        a aVar3 = new a(i17, i18);
        sparseArrayCompat2.put(i18, aVar3);
        return aVar3;
    }

    public int a() {
        return this.f131238a;
    }

    public a c() {
        return b(this.f131239b, this.f131238a);
    }

    public float d() {
        return this.f131238a / this.f131239b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f131238a != aVar.f131238a || this.f131239b != aVar.f131239b) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3 = this.f131239b;
        int i16 = this.f131238a;
        return i3 ^ ((i16 >>> 16) | (i16 << 16));
    }

    public String toString() {
        return this.f131238a + ":" + this.f131239b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f131238a);
        parcel.writeInt(this.f131239b);
    }

    public boolean a(q qVar) {
        int a16 = a(qVar.b(), qVar.a());
        return this.f131238a == qVar.b() / a16 && this.f131239b == qVar.a() / a16;
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.k.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6348a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return a.b(parcel.readInt(), parcel.readInt());
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i3) {
            return new a[i3];
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(a aVar) {
        if (equals(aVar)) {
            return 0;
        }
        return d() - aVar.d() > 0.0f ? 1 : -1;
    }

    public static int a(int i3, int i16) {
        while (true) {
            int i17 = i16;
            int i18 = i3;
            i3 = i17;
            if (i3 == 0) {
                return i18;
            }
            i16 = i18 % i3;
        }
    }

    public int b() {
        return this.f131239b;
    }
}
