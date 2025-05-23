package com.tencent.luggage.wxa.ig;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class p extends com.tencent.luggage.wxa.wd.d {
    public static final Parcelable.Creator<p> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    public String f130304c;

    /* renamed from: d, reason: collision with root package name */
    public int f130305d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f130306e;

    /* renamed from: f, reason: collision with root package name */
    public int f130307f;

    /* renamed from: g, reason: collision with root package name */
    public int f130308g;

    /* renamed from: h, reason: collision with root package name */
    public Runnable f130309h;

    @Override // com.tencent.luggage.wxa.wd.d
    public void a(Parcel parcel) {
        this.f130304c = parcel.readString();
        this.f130305d = parcel.readInt();
        this.f130306e = parcel.createStringArrayList();
        this.f130307f = parcel.readInt();
        this.f130308g = parcel.readInt();
    }

    @Override // com.tencent.luggage.wxa.wd.d
    public void g() {
        Runnable runnable = this.f130309h;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.tencent.luggage.wxa.wd.d
    public void h() {
        com.tencent.luggage.wxa.rc.b E;
        Object[] a16;
        if (com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class) == null) {
            E = null;
        } else {
            E = ((com.tencent.luggage.wxa.k4.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class)).E();
        }
        if (E == null) {
            a();
            return;
        }
        synchronized (com.tencent.luggage.wxa.rc.b.class) {
            a16 = E.a(this.f130305d, this.f130304c);
        }
        this.f130306e = (ArrayList) a16[0];
        this.f130307f = (int) Math.ceil(((Integer) a16[1]).doubleValue() / 1000.0d);
        this.f130308g = (int) Math.ceil(((Integer) a16[2]).doubleValue() / 1000.0d);
        a();
    }

    @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f130304c);
        parcel.writeInt(this.f130305d);
        parcel.writeStringList(this.f130306e);
        parcel.writeInt(this.f130307f);
        parcel.writeInt(this.f130308g);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p createFromParcel(Parcel parcel) {
            p pVar = new p();
            pVar.a(parcel);
            return pVar;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public p[] newArray(int i3) {
            return new p[i3];
        }
    }
}
