package com.tencent.luggage.wxa.b0;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.a0.a;
import com.tencent.luggage.wxa.n0.v;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements a.b {
    public static final Parcelable.Creator<a> CREATOR = new C6026a();

    /* renamed from: a, reason: collision with root package name */
    public final String f121814a;

    /* renamed from: b, reason: collision with root package name */
    public final String f121815b;

    /* renamed from: c, reason: collision with root package name */
    public final long f121816c;

    /* renamed from: d, reason: collision with root package name */
    public final long f121817d;

    /* renamed from: e, reason: collision with root package name */
    public final byte[] f121818e;

    /* renamed from: f, reason: collision with root package name */
    public int f121819f;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.b0.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C6026a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i3) {
            return new a[i3];
        }
    }

    public a(Parcel parcel) {
        this.f121814a = parcel.readString();
        this.f121815b = parcel.readString();
        this.f121816c = parcel.readLong();
        this.f121817d = parcel.readLong();
        this.f121818e = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f121816c == aVar.f121816c && this.f121817d == aVar.f121817d && v.a(this.f121814a, aVar.f121814a) && v.a(this.f121815b, aVar.f121815b) && Arrays.equals(this.f121818e, aVar.f121818e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        if (this.f121819f == 0) {
            String str = this.f121814a;
            int i16 = 0;
            if (str != null) {
                i3 = str.hashCode();
            } else {
                i3 = 0;
            }
            int i17 = (i3 + 527) * 31;
            String str2 = this.f121815b;
            if (str2 != null) {
                i16 = str2.hashCode();
            }
            int i18 = (i17 + i16) * 31;
            long j3 = this.f121816c;
            int i19 = (i18 + ((int) (j3 ^ (j3 >>> 32)))) * 31;
            long j16 = this.f121817d;
            this.f121819f = ((i19 + ((int) (j16 ^ (j16 >>> 32)))) * 31) + Arrays.hashCode(this.f121818e);
        }
        return this.f121819f;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f121814a);
        parcel.writeString(this.f121815b);
        parcel.writeLong(this.f121816c);
        parcel.writeLong(this.f121817d);
        parcel.writeByteArray(this.f121818e);
    }
}
