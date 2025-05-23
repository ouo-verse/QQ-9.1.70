package com.tencent.luggage.wxa.yc;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f extends com.tencent.luggage.wxa.yc.a {
    public static final Parcelable.Creator<f> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public float f145522b;

    /* renamed from: c, reason: collision with root package name */
    public float f145523c;

    /* renamed from: d, reason: collision with root package name */
    public float f145524d;

    /* renamed from: e, reason: collision with root package name */
    public float f145525e;

    /* renamed from: f, reason: collision with root package name */
    public float f145526f;

    /* renamed from: g, reason: collision with root package name */
    public float f145527g;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f[] newArray(int i3) {
            return new f[i3];
        }
    }

    public f(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f145522b = parcel.readFloat();
        this.f145523c = parcel.readFloat();
        this.f145524d = parcel.readFloat();
        this.f145525e = parcel.readFloat();
        this.f145526f = parcel.readFloat();
        this.f145527g = parcel.readFloat();
    }

    @Override // com.tencent.luggage.wxa.yc.a, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        if (fVar.f145522b != this.f145522b || fVar.f145523c != this.f145523c || fVar.f145524d != this.f145524d || fVar.f145525e != this.f145525e || fVar.f145526f != this.f145526f || fVar.f145527g != this.f145527g) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.yc.a, com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f145522b);
        parcel.writeFloat(this.f145523c);
        parcel.writeFloat(this.f145524d);
        parcel.writeFloat(this.f145525e);
        parcel.writeFloat(this.f145524d);
        parcel.writeFloat(this.f145525e);
    }
}
