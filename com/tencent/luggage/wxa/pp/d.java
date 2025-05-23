package com.tencent.luggage.wxa.pp;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements Parcelable {
    public static final Parcelable.Creator<d> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public int f137733a;

    /* renamed from: b, reason: collision with root package name */
    public byte[] f137734b;

    /* renamed from: c, reason: collision with root package name */
    public int f137735c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i3) {
            return new d[i3];
        }
    }

    public d(Parcel parcel) {
        this.f137733a = parcel.readInt();
        this.f137734b = parcel.createByteArray();
        this.f137735c = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f137733a);
        parcel.writeByteArray(this.f137734b);
        parcel.writeInt(this.f137735c);
    }
}
