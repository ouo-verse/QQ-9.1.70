package com.tencent.luggage.wxa.xc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class s extends com.tencent.luggage.wxa.xc.a {
    public static final Parcelable.Creator<s> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public String f144720b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public s createFromParcel(Parcel parcel) {
            return new s(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public s[] newArray(int i3) {
            return new s[i3];
        }
    }

    public s(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f144720b = parcel.readString();
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
        if (!(obj instanceof s) || !super.equals(obj)) {
            return false;
        }
        return Objects.equals(this.f144720b, ((s) obj).f144720b);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.f144720b);
    }

    @Override // com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.f144720b);
    }
}
