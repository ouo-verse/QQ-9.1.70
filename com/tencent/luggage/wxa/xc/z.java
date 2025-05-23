package com.tencent.luggage.wxa.xc;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class z extends com.tencent.luggage.wxa.xc.a {
    public static final Parcelable.Creator<z> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public int f144728b;

    /* renamed from: c, reason: collision with root package name */
    public int f144729c;

    /* renamed from: d, reason: collision with root package name */
    public int f144730d;

    /* renamed from: e, reason: collision with root package name */
    public int f144731e;

    /* renamed from: f, reason: collision with root package name */
    public Bitmap f144732f;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public z createFromParcel(Parcel parcel) {
            return new z(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public z[] newArray(int i3) {
            return new z[i3];
        }
    }

    public z(Parcel parcel) {
        super(parcel);
        this.f144732f = null;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f144728b = parcel.readInt();
        this.f144729c = parcel.readInt();
        this.f144730d = parcel.readInt();
        this.f144731e = parcel.readInt();
        this.f144732f = (Bitmap) parcel.readParcelable(z.class.getClassLoader());
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
        if (!(obj instanceof z) || !super.equals(obj)) {
            return false;
        }
        z zVar = (z) obj;
        if (this.f144728b == zVar.f144728b && this.f144729c == zVar.f144729c && this.f144730d == zVar.f144730d && this.f144731e == zVar.f144731e && Objects.equals(this.f144732f, zVar.f144732f)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), Integer.valueOf(this.f144728b), Integer.valueOf(this.f144729c), Integer.valueOf(this.f144730d), Integer.valueOf(this.f144731e), this.f144732f);
    }

    @Override // com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.f144728b);
        parcel.writeInt(this.f144729c);
        parcel.writeInt(this.f144730d);
        parcel.writeInt(this.f144731e);
        parcel.writeParcelable(this.f144732f, i3);
    }
}
