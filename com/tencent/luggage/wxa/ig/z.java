package com.tencent.luggage.wxa.ig;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import com.tencent.luggage.wxa.rc.p;

/* compiled from: P */
/* loaded from: classes8.dex */
public class z extends com.tencent.luggage.wxa.wd.d {
    public static final Parcelable.Creator<z> CREATOR = new a();
    public String C;

    /* renamed from: c, reason: collision with root package name */
    public String f130349c;

    /* renamed from: d, reason: collision with root package name */
    public int f130350d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f130351e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f130352f;

    /* renamed from: g, reason: collision with root package name */
    public int f130353g;

    /* renamed from: h, reason: collision with root package name */
    public int f130354h;

    /* renamed from: i, reason: collision with root package name */
    public int f130355i;

    /* renamed from: j, reason: collision with root package name */
    public String f130356j;

    /* renamed from: k, reason: collision with root package name */
    public String f130357k;

    /* renamed from: l, reason: collision with root package name */
    public String f130358l;

    /* renamed from: m, reason: collision with root package name */
    public String f130359m = Process.myPid() + String.valueOf(super.hashCode());

    public void a(String str, String str2, String str3) {
        if (a0.a(str, str2, str3) > 102400) {
            this.f130353g = a0.a(str);
            this.f130354h = a0.a(str2);
            this.f130355i = a0.a(str3);
            try {
                a0.a(this.f130359m, str, str2, str3);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetStorageTask", e16.getMessage());
            }
            this.f130352f = true;
            return;
        }
        this.f130352f = false;
        this.f130356j = str;
        this.f130357k = str2;
        this.f130358l = str3;
    }

    @Override // com.tencent.luggage.wxa.wd.d
    public void g() {
        Runnable runnable = this.f130351e;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.tencent.luggage.wxa.wd.d
    public void h() {
        com.tencent.luggage.wxa.rc.b E;
        p.a a16;
        if (this.f130352f) {
            try {
                try {
                    a(a0.b(this.f130359m));
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiSetStorageTask", e16.getMessage());
                }
            } finally {
                a0.a(this.f130359m);
            }
        }
        if (com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class) == null) {
            E = null;
        } else {
            E = ((com.tencent.luggage.wxa.k4.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class)).E();
        }
        com.tencent.luggage.wxa.rc.b bVar = E;
        if (bVar == null) {
            this.C = "fail:internal error get DB fail";
            i();
            a();
        } else {
            synchronized (com.tencent.luggage.wxa.rc.b.class) {
                a16 = bVar.a(this.f130350d, this.f130349c, this.f130356j, this.f130357k, this.f130358l);
            }
            this.C = a0.b(a16);
            i();
            a();
        }
    }

    public final void i() {
        this.f130356j = null;
        this.f130357k = null;
        this.f130358l = null;
    }

    @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f130349c);
        parcel.writeInt(this.f130350d);
        parcel.writeByte(this.f130352f ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f130353g);
        parcel.writeInt(this.f130354h);
        parcel.writeInt(this.f130355i);
        parcel.writeString(this.f130356j);
        parcel.writeString(this.f130357k);
        parcel.writeString(this.f130358l);
        parcel.writeString(this.C);
        parcel.writeString(this.f130359m);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public z createFromParcel(Parcel parcel) {
            z zVar = new z();
            zVar.a(parcel);
            return zVar;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public z[] newArray(int i3) {
            return new z[i3];
        }
    }

    public final void a(String str) {
        int length = str.length();
        int i3 = this.f130353g;
        if (length != this.f130354h + i3 + this.f130355i) {
            return;
        }
        this.f130356j = str.substring(0, i3);
        int i16 = this.f130353g;
        this.f130357k = str.substring(i16, this.f130354h + i16);
        int i17 = this.f130353g + this.f130354h;
        this.f130358l = str.substring(i17, this.f130355i + i17);
    }

    @Override // com.tencent.luggage.wxa.wd.d
    public void a(Parcel parcel) {
        this.f130349c = parcel.readString();
        this.f130350d = parcel.readInt();
        this.f130352f = parcel.readByte() != 0;
        this.f130353g = parcel.readInt();
        this.f130354h = parcel.readInt();
        this.f130355i = parcel.readInt();
        this.f130356j = parcel.readString();
        this.f130357k = parcel.readString();
        this.f130358l = parcel.readString();
        this.C = parcel.readString();
        this.f130359m = parcel.readString();
    }
}
