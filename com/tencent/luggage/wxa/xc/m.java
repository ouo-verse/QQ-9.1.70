package com.tencent.luggage.wxa.xc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class m extends com.tencent.luggage.wxa.xc.a {
    public static final Parcelable.Creator<m> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public float f144713b;

    /* renamed from: c, reason: collision with root package name */
    public float f144714c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public m createFromParcel(Parcel parcel) {
            return new m(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public m[] newArray(int i3) {
            return new m[i3];
        }
    }

    public m(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f144713b = parcel.readFloat();
        this.f144714c = parcel.readFloat();
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
        if (!(obj instanceof m) || !super.equals(obj)) {
            return false;
        }
        m mVar = (m) obj;
        if (Float.compare(mVar.f144713b, this.f144713b) == 0 && Float.compare(mVar.f144714c, this.f144714c) == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.f144713b), Float.valueOf(this.f144714c));
    }

    @Override // com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f144713b);
        parcel.writeFloat(this.f144714c);
    }
}
