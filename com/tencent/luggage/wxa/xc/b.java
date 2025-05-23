package com.tencent.luggage.wxa.xc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class b extends com.tencent.luggage.wxa.xc.a {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public float f144667b;

    /* renamed from: c, reason: collision with root package name */
    public float f144668c;

    /* renamed from: d, reason: collision with root package name */
    public float f144669d;

    /* renamed from: e, reason: collision with root package name */
    public float f144670e;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public b[] newArray(int i3) {
            return new b[i3];
        }
    }

    public b(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f144667b = parcel.readFloat();
        this.f144668c = parcel.readFloat();
        this.f144669d = parcel.readFloat();
        this.f144670e = parcel.readFloat();
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
        if (!(obj instanceof b) || !super.equals(obj)) {
            return false;
        }
        b bVar = (b) obj;
        if (Float.compare(bVar.f144667b, this.f144667b) == 0 && Float.compare(bVar.f144668c, this.f144668c) == 0 && Float.compare(bVar.f144669d, this.f144669d) == 0 && Float.compare(bVar.f144670e, this.f144670e) == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.f144667b), Float.valueOf(this.f144668c), Float.valueOf(this.f144669d), Float.valueOf(this.f144670e));
    }

    @Override // com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f144667b);
        parcel.writeFloat(this.f144668c);
        parcel.writeFloat(this.f144669d);
        parcel.writeFloat(this.f144670e);
    }
}
