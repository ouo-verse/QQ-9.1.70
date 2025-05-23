package com.tencent.luggage.wxa.xc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class e extends com.tencent.luggage.wxa.xc.a {
    public static final Parcelable.Creator<e> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public float f144677b;

    /* renamed from: c, reason: collision with root package name */
    public float f144678c;

    /* renamed from: d, reason: collision with root package name */
    public float f144679d;

    /* renamed from: e, reason: collision with root package name */
    public float f144680e;

    /* renamed from: f, reason: collision with root package name */
    public float f144681f;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e createFromParcel(Parcel parcel) {
            return new e(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public e[] newArray(int i3) {
            return new e[i3];
        }
    }

    public e(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f144677b = parcel.readFloat();
        this.f144678c = parcel.readFloat();
        this.f144679d = parcel.readFloat();
        this.f144680e = parcel.readFloat();
        this.f144681f = parcel.readFloat();
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
        if (!(obj instanceof e) || !super.equals(obj)) {
            return false;
        }
        e eVar = (e) obj;
        if (Float.compare(eVar.f144677b, this.f144677b) == 0 && Float.compare(eVar.f144678c, this.f144678c) == 0 && Float.compare(eVar.f144679d, this.f144679d) == 0 && Float.compare(eVar.f144680e, this.f144680e) == 0 && Float.compare(eVar.f144681f, this.f144681f) == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.f144677b), Float.valueOf(this.f144678c), Float.valueOf(this.f144679d), Float.valueOf(this.f144680e), Float.valueOf(this.f144681f));
    }

    @Override // com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f144677b);
        parcel.writeFloat(this.f144678c);
        parcel.writeFloat(this.f144679d);
        parcel.writeFloat(this.f144680e);
        parcel.writeFloat(this.f144681f);
    }
}
