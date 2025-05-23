package com.tencent.luggage.wxa.yc;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h extends com.tencent.luggage.wxa.yc.a {
    public static final Parcelable.Creator<h> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public float f145530b;

    /* renamed from: c, reason: collision with root package name */
    public float f145531c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public h createFromParcel(Parcel parcel) {
            return new h(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public h[] newArray(int i3) {
            return new h[i3];
        }
    }

    public h(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f145530b = parcel.readFloat();
        this.f145531c = parcel.readFloat();
    }

    @Override // com.tencent.luggage.wxa.yc.a, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (hVar.f145530b != this.f145530b || hVar.f145531c != this.f145531c) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.yc.a, com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f145530b);
        parcel.writeFloat(this.f145531c);
    }
}
