package com.tencent.luggage.wxa.ig;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.wd.d {
    public static final Parcelable.Creator<b> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    public String f130262c;

    /* renamed from: d, reason: collision with root package name */
    public int f130263d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f130264e;

    /* compiled from: P */
    /* loaded from: classes8.dex */
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

    public b() {
    }

    @Override // com.tencent.luggage.wxa.wd.d
    public void a(Parcel parcel) {
        this.f130262c = parcel.readString();
        this.f130263d = parcel.readInt();
    }

    @Override // com.tencent.luggage.wxa.wd.d
    public void g() {
        Runnable runnable = this.f130264e;
        if (runnable != null) {
            runnable.run();
        }
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
            a();
        } else {
            this.f130263d = E.b(this.f130262c);
            a();
        }
    }

    @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.f130262c);
        parcel.writeInt(this.f130263d);
    }

    public b(Parcel parcel) {
        a(parcel);
    }
}
