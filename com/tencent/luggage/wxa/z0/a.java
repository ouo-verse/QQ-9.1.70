package com.tencent.luggage.wxa.z0;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a extends com.tencent.luggage.wxa.a1.a {
    public static final Parcelable.Creator<a> CREATOR = new C6965a();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.z0.a$a, reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C6965a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i3) {
            return new a[i3];
        }
    }

    public /* synthetic */ a(Parcel parcel, C6965a c6965a) {
        this(parcel);
    }

    @Override // com.tencent.luggage.wxa.a1.a, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.a1.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
    }

    public a() {
    }

    public a(Parcel parcel) {
        super(parcel);
    }
}
