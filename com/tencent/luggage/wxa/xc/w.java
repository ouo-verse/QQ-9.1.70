package com.tencent.luggage.wxa.xc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class w extends com.tencent.luggage.wxa.xc.a {
    public static final Parcelable.Creator<w> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public float[] f144724b;

    /* renamed from: c, reason: collision with root package name */
    public float f144725c;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public w createFromParcel(Parcel parcel) {
            return new w(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public w[] newArray(int i3) {
            return new w[i3];
        }
    }

    public w(Parcel parcel) {
        super(parcel);
        this.f144724b = null;
        this.f144725c = Float.MIN_VALUE;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        int readInt = parcel.readInt();
        if (readInt > 0) {
            float[] fArr = new float[readInt];
            this.f144724b = fArr;
            parcel.readFloatArray(fArr);
        }
        this.f144725c = parcel.readFloat();
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
        if (!(obj instanceof w) || !super.equals(obj)) {
            return false;
        }
        w wVar = (w) obj;
        if (Float.compare(wVar.f144725c, this.f144725c) == 0 && Arrays.equals(this.f144724b, wVar.f144724b)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public int hashCode() {
        return (Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.f144725c)) * 31) + Arrays.hashCode(this.f144724b);
    }

    @Override // com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        float[] fArr = this.f144724b;
        if (fArr != null) {
            parcel.writeInt(fArr.length);
            parcel.writeFloatArray(this.f144724b);
        }
        parcel.writeFloat(this.f144725c);
    }
}
