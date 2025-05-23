package com.tencent.luggage.wxa.xc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class g extends com.tencent.luggage.wxa.xc.a {
    public static final Parcelable.Creator<g> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public float f144700b;

    /* renamed from: c, reason: collision with root package name */
    public float f144701c;

    /* renamed from: d, reason: collision with root package name */
    public float f144702d;

    /* renamed from: e, reason: collision with root package name */
    public float f144703e;

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
        this.f144700b = parcel.readFloat();
        this.f144701c = parcel.readFloat();
        this.f144702d = parcel.readFloat();
        this.f144703e = parcel.readFloat();
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
        if (!(obj instanceof g) || !super.equals(obj)) {
            return false;
        }
        g gVar = (g) obj;
        if (Float.compare(gVar.f144700b, this.f144700b) == 0 && Float.compare(gVar.f144701c, this.f144701c) == 0 && Float.compare(gVar.f144702d, this.f144702d) == 0 && Float.compare(gVar.f144703e, this.f144703e) == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.f144700b), Float.valueOf(this.f144701c), Float.valueOf(this.f144702d), Float.valueOf(this.f144703e));
    }

    @Override // com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f144700b);
        parcel.writeFloat(this.f144701c);
        parcel.writeFloat(this.f144702d);
        parcel.writeFloat(this.f144703e);
    }
}
