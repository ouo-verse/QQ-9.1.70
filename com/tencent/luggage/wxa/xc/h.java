package com.tencent.luggage.wxa.xc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class h extends com.tencent.luggage.wxa.xc.a {
    public static final Parcelable.Creator<h> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public String f144704b;

    /* renamed from: c, reason: collision with root package name */
    public float f144705c;

    /* renamed from: d, reason: collision with root package name */
    public float f144706d;

    /* renamed from: e, reason: collision with root package name */
    public float f144707e;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public h createFromParcel(Parcel parcel) {
            return new h(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public h[] newArray(int i3) {
            return new h[i3];
        }
    }

    public h(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f144704b = parcel.readString();
        this.f144705c = parcel.readFloat();
        this.f144706d = parcel.readFloat();
        this.f144707e = parcel.readFloat();
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
        if (!(obj instanceof h) || !super.equals(obj)) {
            return false;
        }
        h hVar = (h) obj;
        if (Float.compare(hVar.f144705c, this.f144705c) == 0 && Float.compare(hVar.f144706d, this.f144706d) == 0 && Float.compare(hVar.f144707e, this.f144707e) == 0 && Objects.equals(this.f144704b, hVar.f144704b)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.f144704b, Float.valueOf(this.f144705c), Float.valueOf(this.f144706d), Float.valueOf(this.f144707e));
    }

    @Override // com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.f144704b);
        parcel.writeFloat(this.f144705c);
        parcel.writeFloat(this.f144706d);
        parcel.writeFloat(this.f144707e);
    }
}
