package com.tencent.luggage.wxa.xc;

import android.graphics.Canvas;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class o extends com.tencent.luggage.wxa.xc.a {
    public static final Parcelable.Creator<o> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public j f144716b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public o createFromParcel(Parcel parcel) {
            return new o(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public o[] newArray(int i3) {
            return new o[i3];
        }
    }

    public o(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas) {
        j jVar = this.f144716b;
        if (jVar == null) {
            return false;
        }
        return jVar.a(dVar, canvas);
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
        if (!(obj instanceof o) || !super.equals(obj)) {
            return false;
        }
        return Objects.equals(this.f144716b, ((o) obj).f144716b);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.f144716b);
    }

    @Override // com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeParcelable(this.f144716b, i3);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f144716b = (j) parcel.readParcelable(o.class.getClassLoader());
    }
}
