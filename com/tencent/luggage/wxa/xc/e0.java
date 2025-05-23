package com.tencent.luggage.wxa.xc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e0 extends com.tencent.luggage.wxa.xc.a {
    public static final Parcelable.Creator<e0> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public float f144682b;

    /* renamed from: c, reason: collision with root package name */
    public float f144683c;

    /* renamed from: d, reason: collision with root package name */
    public float f144684d;

    /* renamed from: e, reason: collision with root package name */
    public float f144685e;

    /* renamed from: f, reason: collision with root package name */
    public float f144686f;

    /* renamed from: g, reason: collision with root package name */
    public float f144687g;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e0 createFromParcel(Parcel parcel) {
            return new e0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e0[] newArray(int i3) {
            return new e0[i3];
        }
    }

    public e0(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f144682b = parcel.readFloat();
        this.f144683c = parcel.readFloat();
        this.f144684d = parcel.readFloat();
        this.f144685e = parcel.readFloat();
        this.f144686f = parcel.readFloat();
        this.f144687g = parcel.readFloat();
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
        if (!(obj instanceof e0) || !super.equals(obj)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        if (Float.compare(e0Var.f144682b, this.f144682b) == 0 && Float.compare(e0Var.f144683c, this.f144683c) == 0 && Float.compare(e0Var.f144684d, this.f144684d) == 0 && Float.compare(e0Var.f144685e, this.f144685e) == 0 && Float.compare(e0Var.f144686f, this.f144686f) == 0 && Float.compare(e0Var.f144687g, this.f144687g) == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.f144682b), Float.valueOf(this.f144683c), Float.valueOf(this.f144684d), Float.valueOf(this.f144685e), Float.valueOf(this.f144686f), Float.valueOf(this.f144687g));
    }

    @Override // com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f144685e);
        parcel.writeFloat(this.f144683c);
        parcel.writeFloat(this.f144684d);
        parcel.writeFloat(this.f144685e);
        parcel.writeFloat(this.f144686f);
        parcel.writeFloat(this.f144687g);
    }
}
