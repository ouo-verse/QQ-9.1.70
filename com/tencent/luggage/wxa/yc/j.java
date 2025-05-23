package com.tencent.luggage.wxa.yc;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class j extends com.tencent.luggage.wxa.yc.a {
    public static final Parcelable.Creator<j> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public float f145536b;

    /* renamed from: c, reason: collision with root package name */
    public float f145537c;

    /* renamed from: d, reason: collision with root package name */
    public float f145538d;

    /* renamed from: e, reason: collision with root package name */
    public float f145539e;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j[] newArray(int i3) {
            return new j[i3];
        }
    }

    public j(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f145536b = parcel.readFloat();
        this.f145537c = parcel.readFloat();
        this.f145538d = parcel.readFloat();
        this.f145539e = parcel.readFloat();
    }

    @Override // com.tencent.luggage.wxa.yc.a, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public boolean equals(Object obj) {
        if (!super.equals(obj) || !(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (jVar.f145536b != this.f145536b || jVar.f145537c != this.f145537c || jVar.f145538d != this.f145538d || jVar.f145539e != this.f145539e) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.luggage.wxa.yc.a, com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f145536b);
        parcel.writeFloat(this.f145537c);
        parcel.writeFloat(this.f145538d);
        parcel.writeFloat(this.f145539e);
    }
}
