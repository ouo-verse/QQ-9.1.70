package com.tencent.luggage.wxa.f1;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public long f125191a;

    /* renamed from: b, reason: collision with root package name */
    public String f125192b;

    /* renamed from: c, reason: collision with root package name */
    public String f125193c;

    /* renamed from: d, reason: collision with root package name */
    public long f125194d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i3) {
            return new b[i3];
        }
    }

    public b(long j3, String str, String str2, long j16) {
        this.f125191a = j3;
        this.f125192b = str;
        this.f125193c = str2;
        this.f125194d = j16;
    }

    public long a() {
        return this.f125194d;
    }

    public String b() {
        return this.f125193c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return ((b) obj).b().equalsIgnoreCase(b());
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f125191a);
        parcel.writeString(this.f125192b);
        parcel.writeString(this.f125193c);
        parcel.writeLong(this.f125194d);
    }

    public b(Parcel parcel) {
        this.f125191a = parcel.readLong();
        this.f125192b = parcel.readString();
        this.f125193c = parcel.readString();
        this.f125194d = parcel.readLong();
    }
}
