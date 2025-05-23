package com.tencent.luggage.wxa.yc;

import android.os.Parcel;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class b extends a {

    /* renamed from: b, reason: collision with root package name */
    public float f145515b;

    /* renamed from: c, reason: collision with root package name */
    public float f145516c;

    /* renamed from: d, reason: collision with root package name */
    public float f145517d;

    /* renamed from: e, reason: collision with root package name */
    public float f145518e;

    /* renamed from: f, reason: collision with root package name */
    public float f145519f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f145520g;

    public b(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f145515b = parcel.readFloat();
        this.f145516c = parcel.readFloat();
        this.f145517d = parcel.readFloat();
        this.f145518e = parcel.readFloat();
        this.f145519f = parcel.readFloat();
        boolean z16 = true;
        if (parcel.readInt() != 1) {
            z16 = false;
        }
        this.f145520g = z16;
    }

    @Override // com.tencent.luggage.wxa.yc.a, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (bVar.f145515b != this.f145515b || bVar.f145516c != this.f145516c || bVar.f145517d != this.f145517d || bVar.f145518e != this.f145518e || bVar.f145520g != this.f145520g) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.yc.a, com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f145515b);
        parcel.writeFloat(this.f145516c);
        parcel.writeFloat(this.f145517d);
        parcel.writeFloat(this.f145518e);
        parcel.writeFloat(this.f145519f);
        parcel.writeInt(this.f145520g ? 1 : 0);
    }
}
