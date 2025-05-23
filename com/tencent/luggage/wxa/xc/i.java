package com.tencent.luggage.wxa.xc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class i extends com.tencent.luggage.wxa.xc.a {
    public static final Parcelable.Creator<i> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public float f144708b;

    /* renamed from: c, reason: collision with root package name */
    public float f144709c;

    /* renamed from: d, reason: collision with root package name */
    public float f144710d;

    /* renamed from: e, reason: collision with root package name */
    public float f144711e;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i createFromParcel(Parcel parcel) {
            return new i(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i[] newArray(int i3) {
            return new i[i3];
        }
    }

    public i(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f144708b = parcel.readFloat();
        this.f144709c = parcel.readFloat();
        this.f144710d = parcel.readFloat();
        this.f144711e = parcel.readFloat();
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
        if (!(obj instanceof i) || !super.equals(obj)) {
            return false;
        }
        i iVar = (i) obj;
        if (Float.compare(iVar.f144708b, this.f144708b) == 0 && Float.compare(iVar.f144709c, this.f144709c) == 0 && Float.compare(iVar.f144710d, this.f144710d) == 0 && Float.compare(iVar.f144711e, this.f144711e) == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.f144708b), Float.valueOf(this.f144709c), Float.valueOf(this.f144710d), Float.valueOf(this.f144711e));
    }

    @Override // com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f144708b);
        parcel.writeFloat(this.f144709c);
        parcel.writeFloat(this.f144710d);
        parcel.writeFloat(this.f144711e);
    }
}
