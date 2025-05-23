package com.tencent.luggage.wxa.pp;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f137728a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f137729b;

    /* renamed from: c, reason: collision with root package name */
    public int f137730c;

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

    public b(Parcel parcel) {
        this.f137728a = parcel.readInt();
        this.f137729b = parcel.createByteArray();
        this.f137730c = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f137728a);
        parcel.writeByteArray(this.f137729b);
        parcel.writeInt(this.f137730c);
    }
}
