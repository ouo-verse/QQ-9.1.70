package com.tencent.luggage.wxa.ig;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class i extends com.tencent.luggage.wxa.wd.d {
    public static final Parcelable.Creator<i> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    public String f130272c;

    /* renamed from: d, reason: collision with root package name */
    public int f130273d;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i createFromParcel(Parcel parcel) {
            return new i(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public i[] newArray(int i3) {
            return new i[i3];
        }
    }

    public i() {
    }

    @Override // com.tencent.luggage.wxa.wd.d
    public void a(Parcel parcel) {
        this.f130272c = parcel.readString();
        this.f130273d = parcel.readInt();
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
        E.b(this.f130273d, this.f130272c);
    }

    @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f130272c);
        parcel.writeInt(this.f130273d);
    }

    public i(Parcel parcel) {
        a(parcel);
    }
}
