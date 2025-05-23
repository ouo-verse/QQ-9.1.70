package com.tencent.luggage.wxa.c0;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.n0.v;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class j extends h {
    public static final Parcelable.Creator<j> CREATOR = new a();

    /* renamed from: b, reason: collision with root package name */
    public final String f123193b;

    /* renamed from: c, reason: collision with root package name */
    public final String f123194c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j[] newArray(int i3) {
            return new j[i3];
        }
    }

    public j(String str, String str2, String str3) {
        super(str);
        this.f123193b = str2;
        this.f123194c = str3;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || j.class != obj.getClass()) {
            return false;
        }
        j jVar = (j) obj;
        if (this.f123190a.equals(jVar.f123190a) && v.a(this.f123193b, jVar.f123193b) && v.a(this.f123194c, jVar.f123194c)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i3;
        int hashCode = (this.f123190a.hashCode() + 527) * 31;
        String str = this.f123193b;
        int i16 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i17 = (hashCode + i3) * 31;
        String str2 = this.f123194c;
        if (str2 != null) {
            i16 = str2.hashCode();
        }
        return i17 + i16;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f123190a);
        parcel.writeString(this.f123193b);
        parcel.writeString(this.f123194c);
    }

    public j(Parcel parcel) {
        super(parcel.readString());
        this.f123193b = parcel.readString();
        this.f123194c = parcel.readString();
    }
}
