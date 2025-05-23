package com.tencent.luggage.wxa.yc;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g extends com.tencent.luggage.wxa.yc.a {
    public static final Parcelable.Creator<g> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public float f145528b;

    /* renamed from: c, reason: collision with root package name */
    public float f145529c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g[] newArray(int i3) {
            return new g[i3];
        }
    }

    public g(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f145528b = parcel.readFloat();
        this.f145529c = parcel.readFloat();
    }

    @Override // com.tencent.luggage.wxa.yc.a, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        if (gVar.f145528b != this.f145528b || gVar.f145529c != this.f145529c) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.yc.a, com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f145528b);
        parcel.writeFloat(this.f145529c);
    }
}
