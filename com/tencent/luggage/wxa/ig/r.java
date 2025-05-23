package com.tencent.luggage.wxa.ig;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.rc.p;

/* compiled from: P */
/* loaded from: classes8.dex */
public class r extends com.tencent.luggage.wxa.wd.d {
    public static final Parcelable.Creator<r> CREATOR = new a();

    /* renamed from: c, reason: collision with root package name */
    public String f130310c;

    /* renamed from: d, reason: collision with root package name */
    public int f130311d;

    /* renamed from: e, reason: collision with root package name */
    public Runnable f130312e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f130313f;

    /* renamed from: g, reason: collision with root package name */
    public int f130314g;

    /* renamed from: h, reason: collision with root package name */
    public int f130315h;

    /* renamed from: i, reason: collision with root package name */
    public int f130316i;

    /* renamed from: j, reason: collision with root package name */
    public String f130317j;

    /* renamed from: k, reason: collision with root package name */
    public String f130318k;

    /* renamed from: l, reason: collision with root package name */
    public String f130319l;

    /* renamed from: m, reason: collision with root package name */
    public String f130320m;

    public final void a(String str, String str2) {
        if (a0.a(str, str2) > 102400) {
            this.f130315h = a0.a(str);
            this.f130316i = a0.a(str2);
            try {
                a0.a(this.f130320m, str, str2);
            } catch (Exception e16) {
                com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetStorageTask", e16.getMessage());
            }
            this.f130313f = true;
            return;
        }
        this.f130313f = false;
        this.f130318k = str;
        this.f130319l = str2;
    }

    @Override // com.tencent.luggage.wxa.wd.d
    public void g() {
        if (this.f130313f) {
            try {
                try {
                    a(a0.b(this.f130320m));
                } catch (Exception e16) {
                    com.tencent.luggage.wxa.tn.w.b("MicroMsg.JsApiGetStorageTask", e16.getMessage());
                }
            } finally {
                a0.a(this.f130320m);
            }
        }
        Runnable runnable = this.f130312e;
        if (runnable != null) {
            runnable.run();
        }
    }

    @Override // com.tencent.luggage.wxa.wd.d
    public void h() {
        if (((com.tencent.luggage.wxa.k4.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class)) == null) {
            a();
            return;
        }
        com.tencent.luggage.wxa.rc.b E = ((com.tencent.luggage.wxa.k4.a) com.tencent.luggage.wxa.h1.e.a(com.tencent.luggage.wxa.k4.a.class)).E();
        if (E == null) {
            a();
            return;
        }
        Object[] a16 = E.a(this.f130311d, this.f130310c, this.f130317j);
        if (((p.a) a16[0]) == p.a.NONE) {
            a((String) a16[1], (String) a16[2]);
        }
        a();
    }

    @Override // com.tencent.luggage.wxa.wd.d, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f130310c);
        parcel.writeInt(this.f130311d);
        parcel.writeByte(this.f130313f ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f130314g);
        parcel.writeInt(this.f130315h);
        parcel.writeInt(this.f130316i);
        parcel.writeString(this.f130317j);
        parcel.writeString(this.f130318k);
        parcel.writeString(this.f130319l);
        parcel.writeString(this.f130320m);
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public r createFromParcel(Parcel parcel) {
            r rVar = new r();
            rVar.a(parcel);
            return rVar;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public r[] newArray(int i3) {
            return new r[i3];
        }
    }

    public final void a(String str) {
        int length = str.length();
        int i3 = this.f130315h;
        if (length != this.f130316i + i3) {
            return;
        }
        this.f130318k = str.substring(0, i3);
        int i16 = this.f130315h;
        this.f130319l = str.substring(i16, this.f130316i + i16);
    }

    @Override // com.tencent.luggage.wxa.wd.d
    public void a(Parcel parcel) {
        this.f130310c = parcel.readString();
        this.f130311d = parcel.readInt();
        this.f130313f = parcel.readByte() != 0;
        this.f130314g = parcel.readInt();
        this.f130315h = parcel.readInt();
        this.f130316i = parcel.readInt();
        this.f130317j = parcel.readString();
        this.f130318k = parcel.readString();
        this.f130319l = parcel.readString();
        this.f130320m = parcel.readString();
    }
}
