package com.tencent.luggage.wxa.tc;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public String f141214a;

    /* renamed from: b, reason: collision with root package name */
    public int f141215b;

    /* renamed from: c, reason: collision with root package name */
    public String f141216c;

    /* renamed from: d, reason: collision with root package name */
    public String f141217d;

    /* renamed from: e, reason: collision with root package name */
    public String f141218e;

    /* renamed from: f, reason: collision with root package name */
    public int f141219f;

    /* renamed from: g, reason: collision with root package name */
    public long f141220g;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public c[] newArray(int i3) {
            return new c[i3];
        }
    }

    public c() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f141214a);
        parcel.writeInt(this.f141215b);
        parcel.writeString(this.f141216c);
        parcel.writeString(this.f141217d);
        parcel.writeString(this.f141218e);
        parcel.writeInt(this.f141219f);
        parcel.writeLong(this.f141220g);
    }

    public c(Parcel parcel) {
        this.f141214a = parcel.readString();
        this.f141215b = parcel.readInt();
        this.f141216c = parcel.readString();
        this.f141217d = parcel.readString();
        this.f141218e = parcel.readString();
        this.f141219f = parcel.readInt();
        this.f141220g = parcel.readLong();
    }
}
