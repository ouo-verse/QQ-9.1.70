package com.tencent.luggage.wxa.o0;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public final int f135964a;

    /* renamed from: b, reason: collision with root package name */
    public final int f135965b;

    /* renamed from: c, reason: collision with root package name */
    public final int f135966c;

    /* renamed from: d, reason: collision with root package name */
    public final byte[] f135967d;

    /* renamed from: e, reason: collision with root package name */
    public int f135968e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i3) {
            return new b[0];
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }
    }

    public b(int i3, int i16, int i17, byte[] bArr) {
        this.f135964a = i3;
        this.f135965b = i16;
        this.f135966c = i17;
        this.f135967d = bArr;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f135964a == bVar.f135964a && this.f135965b == bVar.f135965b && this.f135966c == bVar.f135966c && Arrays.equals(this.f135967d, bVar.f135967d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.f135968e == 0) {
            this.f135968e = ((((((this.f135964a + 527) * 31) + this.f135965b) * 31) + this.f135966c) * 31) + Arrays.hashCode(this.f135967d);
        }
        return this.f135968e;
    }

    public String toString() {
        boolean z16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ColorInfo(");
        sb5.append(this.f135964a);
        sb5.append(", ");
        sb5.append(this.f135965b);
        sb5.append(", ");
        sb5.append(this.f135966c);
        sb5.append(", ");
        if (this.f135967d != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append(")");
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        int i16;
        parcel.writeInt(this.f135964a);
        parcel.writeInt(this.f135965b);
        parcel.writeInt(this.f135966c);
        if (this.f135967d != null) {
            i16 = 1;
        } else {
            i16 = 0;
        }
        parcel.writeInt(i16);
        byte[] bArr = this.f135967d;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }

    public b(Parcel parcel) {
        this.f135964a = parcel.readInt();
        this.f135965b = parcel.readInt();
        this.f135966c = parcel.readInt();
        this.f135967d = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }
}
