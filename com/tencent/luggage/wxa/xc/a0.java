package com.tencent.luggage.wxa.xc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class a0 extends com.tencent.luggage.wxa.xc.a {
    public static final Parcelable.Creator<a0> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public float f144663b;

    /* renamed from: c, reason: collision with root package name */
    public float f144664c;

    /* renamed from: d, reason: collision with root package name */
    public float f144665d;

    /* renamed from: e, reason: collision with root package name */
    public int f144666e;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a0 createFromParcel(Parcel parcel) {
            return new a0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a0[] newArray(int i3) {
            return new a0[i3];
        }
    }

    public a0(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f144663b = parcel.readFloat();
        this.f144664c = parcel.readFloat();
        this.f144665d = parcel.readFloat();
        this.f144666e = parcel.readInt();
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
        if (!(obj instanceof a0) || !super.equals(obj)) {
            return false;
        }
        a0 a0Var = (a0) obj;
        if (Float.compare(a0Var.f144663b, this.f144663b) == 0 && Float.compare(a0Var.f144664c, this.f144664c) == 0 && Float.compare(a0Var.f144665d, this.f144665d) == 0 && this.f144666e == a0Var.f144666e) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.f144663b), Float.valueOf(this.f144664c), Float.valueOf(this.f144665d), Integer.valueOf(this.f144666e));
    }

    @Override // com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f144663b);
        parcel.writeFloat(this.f144664c);
        parcel.writeFloat(this.f144665d);
        parcel.writeInt(this.f144666e);
    }
}
