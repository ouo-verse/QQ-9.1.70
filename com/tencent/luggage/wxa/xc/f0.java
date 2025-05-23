package com.tencent.luggage.wxa.xc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class f0 extends com.tencent.luggage.wxa.xc.a {
    public static final Parcelable.Creator<f0> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public float f144698b;

    /* renamed from: c, reason: collision with root package name */
    public float f144699c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f0 createFromParcel(Parcel parcel) {
            return new f0(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public f0[] newArray(int i3) {
            return new f0[i3];
        }
    }

    public f0(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f144698b = parcel.readFloat();
        this.f144699c = parcel.readFloat();
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
        if (!(obj instanceof f0) || !super.equals(obj)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        if (Float.compare(f0Var.f144698b, this.f144698b) == 0 && Float.compare(f0Var.f144699c, this.f144699c) == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.f144698b), Float.valueOf(this.f144699c));
    }

    @Override // com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f144698b);
        parcel.writeFloat(this.f144699c);
    }
}
