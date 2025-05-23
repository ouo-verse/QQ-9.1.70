package com.tencent.luggage.wxa.mc;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g0 implements Parcelable {
    public static final Parcelable.Creator<g0> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f134300a;

    /* renamed from: b, reason: collision with root package name */
    public long f134301b;

    /* renamed from: c, reason: collision with root package name */
    public long f134302c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g0 createFromParcel(Parcel parcel) {
            return new g0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g0[] newArray(int i3) {
            return new g0[i3];
        }
    }

    public g0(int i3, long j3, long j16) {
        this.f134300a = i3;
        this.f134301b = j3;
        this.f134302c = j16;
        if (i3 > 0 || j3 <= 0 || j16 <= 0) {
            return;
        }
        this.f134300a = Math.max(Math.round((((float) j3) / ((float) j16)) * 100.0f), 0);
    }

    public int a() {
        return this.f134300a;
    }

    public long b() {
        return this.f134302c;
    }

    public long c() {
        return this.f134301b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WxaPkgLoadProgress{progress=" + this.f134300a + ", writtenLength=" + this.f134301b + ", totalLength=" + this.f134302c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f134300a);
        parcel.writeLong(this.f134301b);
        parcel.writeLong(this.f134302c);
    }

    public g0() {
        this.f134300a = 0;
        this.f134301b = -1L;
        this.f134302c = -1L;
    }

    public g0(Parcel parcel) {
        this.f134300a = 0;
        this.f134301b = -1L;
        this.f134302c = -1L;
        this.f134300a = parcel.readInt();
        this.f134301b = parcel.readLong();
        this.f134302c = parcel.readLong();
    }
}
