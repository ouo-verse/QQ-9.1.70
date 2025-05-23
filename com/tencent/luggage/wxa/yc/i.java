package com.tencent.luggage.wxa.yc;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class i extends com.tencent.luggage.wxa.yc.a {
    public static final Parcelable.Creator<i> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public float f145532b;

    /* renamed from: c, reason: collision with root package name */
    public float f145533c;

    /* renamed from: d, reason: collision with root package name */
    public float f145534d;

    /* renamed from: e, reason: collision with root package name */
    public float f145535e;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i createFromParcel(Parcel parcel) {
            return new i(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i[] newArray(int i3) {
            return new i[i3];
        }
    }

    public i(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f145532b = parcel.readFloat();
        this.f145533c = parcel.readFloat();
        this.f145534d = parcel.readFloat();
        this.f145535e = parcel.readFloat();
    }

    @Override // com.tencent.luggage.wxa.yc.a, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        if (iVar.f145532b != this.f145532b || iVar.f145533c != this.f145533c || iVar.f145534d != this.f145534d || iVar.f145535e != this.f145535e) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.yc.a, com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f145532b);
        parcel.writeFloat(this.f145533c);
        parcel.writeFloat(this.f145534d);
        parcel.writeFloat(this.f145535e);
    }
}
