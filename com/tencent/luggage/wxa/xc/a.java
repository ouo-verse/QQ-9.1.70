package com.tencent.luggage.wxa.xc;

import android.graphics.Canvas;
import android.os.Parcel;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a implements c {

    /* renamed from: a, reason: collision with root package name */
    public String f144662a;

    public a(Parcel parcel, Object obj) {
        this.f144662a = parcel.readString();
    }

    public boolean a(com.tencent.luggage.wxa.vc.d dVar, Canvas canvas) {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            String str = this.f144662a;
            String str2 = ((a) obj).f144662a;
            if (str == str2) {
                return true;
            }
            if (str != null && str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public String toString() {
        return String.format("method %s", this.f144662a);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f144662a);
    }

    public void a(Parcel parcel) {
        this.f144662a = parcel.readString();
    }

    public a(Parcel parcel) {
        a(parcel);
    }
}
