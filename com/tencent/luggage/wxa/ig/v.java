package com.tencent.luggage.wxa.ig;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class v extends com.tencent.luggage.wxa.wd.d {
    public static final Parcelable.Creator<v> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    public String f130325c;

    /* renamed from: d, reason: collision with root package name */
    public int f130326d;

    /* renamed from: e, reason: collision with root package name */
    public String f130327e;

    @Override // com.tencent.luggage.wxa.wd.d
    public void a(Parcel parcel) {
        this.f130325c = parcel.readString();
        this.f130326d = parcel.readInt();
        this.f130327e = parcel.readString();
    }

    @Override // com.tencent.luggage.wxa.wd.d
    public void h() {
        com.tencent.luggage.wxa.rc.b E;
        if (com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class) == null) {
            E = null;
        } else {
            E = ((com.tencent.luggage.wxa.k4.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class)).E();
        }
        if (E == null) {
            return;
        }
        E.b(this.f130326d, this.f130325c, this.f130327e);
    }

    @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f130325c);
        parcel.writeInt(this.f130326d);
        parcel.writeString(this.f130327e);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public v createFromParcel(Parcel parcel) {
            v vVar = new v();
            vVar.a(parcel);
            return vVar;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public v[] newArray(int i3) {
            return new v[i3];
        }
    }
}
