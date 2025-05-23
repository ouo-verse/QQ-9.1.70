package com.tencent.luggage.wxa.xd;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b0 implements Parcelable {
    public static final Parcelable.Creator<b0> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    public boolean f144737a;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b0 createFromParcel(Parcel parcel) {
            return new b0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b0[] newArray(int i3) {
            return new b0[i3];
        }
    }

    public b0(boolean z16) {
        this.f144737a = z16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeByte(this.f144737a ? (byte) 1 : (byte) 0);
    }

    public b0(Parcel parcel) {
        this.f144737a = parcel.readByte() != 0;
    }
}
