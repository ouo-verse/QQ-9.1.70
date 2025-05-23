package com.tencent.luggage.wxa.si;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f140371a;

    /* renamed from: b, reason: collision with root package name */
    public int f140372b;

    /* renamed from: c, reason: collision with root package name */
    public int f140373c;

    /* renamed from: d, reason: collision with root package name */
    public int f140374d;

    /* renamed from: e, reason: collision with root package name */
    public String f140375e;

    /* renamed from: f, reason: collision with root package name */
    public String f140376f;

    /* renamed from: g, reason: collision with root package name */
    public int f140377g;

    /* renamed from: h, reason: collision with root package name */
    public double f140378h;

    /* renamed from: i, reason: collision with root package name */
    public String f140379i;

    /* renamed from: j, reason: collision with root package name */
    public String f140380j;

    /* renamed from: k, reason: collision with root package name */
    public com.tencent.luggage.wxa.qi.a f140381k;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
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

    public b() {
        this.f140371a = 0;
        this.f140372b = 0;
        this.f140373c = 0;
        this.f140374d = 0;
        this.f140377g = 0;
        this.f140378h = 0.0d;
        this.f140379i = "";
        this.f140380j = "";
        this.f140381k = com.tencent.luggage.wxa.qi.a.MIC;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f140371a);
        parcel.writeInt(this.f140372b);
        parcel.writeInt(this.f140373c);
        parcel.writeInt(this.f140374d);
        parcel.writeString(this.f140375e);
        parcel.writeString(this.f140376f);
        parcel.writeInt(this.f140377g);
        parcel.writeDouble(this.f140378h);
        parcel.writeString(this.f140379i);
        parcel.writeString(this.f140380j);
        parcel.writeInt(this.f140381k.ordinal());
    }

    public b(Parcel parcel) {
        this.f140371a = 0;
        this.f140372b = 0;
        this.f140373c = 0;
        this.f140374d = 0;
        this.f140377g = 0;
        this.f140378h = 0.0d;
        this.f140379i = "";
        this.f140380j = "";
        this.f140381k = com.tencent.luggage.wxa.qi.a.MIC;
        this.f140371a = parcel.readInt();
        this.f140372b = parcel.readInt();
        this.f140373c = parcel.readInt();
        this.f140374d = parcel.readInt();
        this.f140375e = parcel.readString();
        this.f140376f = parcel.readString();
        this.f140377g = parcel.readInt();
        this.f140378h = parcel.readDouble();
        this.f140379i = parcel.readString();
        this.f140380j = parcel.readString();
        this.f140381k = com.tencent.luggage.wxa.qi.a.values()[parcel.readInt()];
    }
}
