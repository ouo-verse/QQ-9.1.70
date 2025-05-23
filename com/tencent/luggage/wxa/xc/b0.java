package com.tencent.luggage.wxa.xc;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b0 extends com.tencent.luggage.wxa.xc.a {
    public static final Parcelable.Creator<b0> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public k f144671b;

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

    public b0(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas) {
        k kVar = this.f144671b;
        if (kVar == null) {
            return false;
        }
        return kVar.a(dVar, canvas);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b0) || !super.equals(obj)) {
            return false;
        }
        return Objects.equals(this.f144671b, ((b0) obj).f144671b);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.f144671b);
    }

    @Override // com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeParcelable(this.f144671b, i3);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f144671b = (k) parcel.readParcelable(b0.class.getClassLoader());
    }
}
