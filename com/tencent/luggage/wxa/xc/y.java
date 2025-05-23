package com.tencent.luggage.wxa.xc;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes9.dex */
public class y extends com.tencent.luggage.wxa.xc.a {
    public static final Parcelable.Creator<y> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public float f144727b;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public y createFromParcel(Parcel parcel) {
            return new y(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public y[] newArray(int i3) {
            return new y[i3];
        }
    }

    public y(Parcel parcel) {
        super(parcel);
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public void a(Parcel parcel) {
        super.a(parcel);
        this.f144727b = parcel.readFloat();
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
        if ((obj instanceof y) && super.equals(obj) && Float.compare(((y) obj).f144727b, this.f144727b) == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.xc.a
    public int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), Float.valueOf(this.f144727b));
    }

    @Override // com.tencent.luggage.wxa.xc.a, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeFloat(this.f144727b);
    }
}
