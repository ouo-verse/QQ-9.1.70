package com.tencent.luggage.wxa.yc;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a extends com.tencent.luggage.wxa.xc.a {
    public static final Parcelable.Creator<a> CREATOR = new C6949a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.yc.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C6949a implements Parcelable.Creator {
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
        super(parcel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
    }
}
