package com.tencent.luggage.wxa.c0;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.n0.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class k extends h {
    public static final Parcelable.Creator<k> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f123195b;

    /* renamed from: c, reason: collision with root package name */
    public final String f123196c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public k createFromParcel(Parcel parcel) {
            return new k(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public k[] newArray(int i3) {
            return new k[i3];
        }
    }

    public k(String str, String str2, String str3) {
        super(str);
        this.f123195b = str2;
        this.f123196c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || k.class != obj.getClass()) {
            return false;
        }
        k kVar = (k) obj;
        if (this.f123190a.equals(kVar.f123190a) && v.a(this.f123195b, kVar.f123195b) && v.a(this.f123196c, kVar.f123196c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int hashCode = (this.f123190a.hashCode() + 527) * 31;
        String str = this.f123195b;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = (hashCode + i3) * 31;
        String str2 = this.f123196c;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f123190a);
        parcel.writeString(this.f123195b);
        parcel.writeString(this.f123196c);
    }

    public k(Parcel parcel) {
        super(parcel.readString());
        this.f123195b = parcel.readString();
        this.f123196c = parcel.readString();
    }
}
