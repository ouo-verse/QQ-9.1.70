package com.tencent.luggage.wxa.ki;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.text.TextUtils;
import com.tencent.luggage.sdk.launching.OnWXAppResultXPCLeakFreeWrapper;
import com.tencent.luggage.wxa.fd.g;
import com.tencent.luggage.wxa.fd.l;
import com.tencent.luggage.wxa.fd.m;
import com.tencent.luggage.wxa.fd.n;
import com.tencent.luggage.wxa.fd.r;
import com.tencent.luggage.wxa.fd.s;
import com.tencent.luggage.wxa.fd.x;
import com.tencent.luggage.wxa.j4.d;
import com.tencent.luggage.wxa.lk.j;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.v4.b;
import com.tencent.luggage.wxa.v4.e;
import com.tencent.luggage.wxa.v4.i;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang.StringUtils;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new C6387a();
    public double C;
    public String D;
    public PersistableBundle E;
    public String F;
    public b G;
    public e H;
    public e I;
    public int J;
    public e K;
    public PersistableBundle L;
    public String M;
    public String N;
    public int O;
    public l P;
    public x Q;
    public boolean R;
    public boolean S;
    public com.tencent.luggage.wxa.j4.e T;
    public Parcelable U;
    public com.tencent.luggage.wxa.li.b V;
    public List W;
    public i X;
    public int Y;
    public String Z;

    /* renamed from: a, reason: collision with root package name */
    public String f132016a;

    /* renamed from: a0, reason: collision with root package name */
    public String f132017a0;

    /* renamed from: b, reason: collision with root package name */
    public String f132018b;

    /* renamed from: b0, reason: collision with root package name */
    public r f132019b0;

    /* renamed from: c, reason: collision with root package name */
    public int f132020c;

    /* renamed from: c0, reason: collision with root package name */
    public String f132021c0;

    /* renamed from: d, reason: collision with root package name */
    public int f132022d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f132023d0;

    /* renamed from: e, reason: collision with root package name */
    public int f132024e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f132025e0;

    /* renamed from: f, reason: collision with root package name */
    public String f132026f;

    /* renamed from: f0, reason: collision with root package name */
    public Parcelable f132027f0;

    /* renamed from: g, reason: collision with root package name */
    public String f132028g;

    /* renamed from: g0, reason: collision with root package name */
    public g f132029g0;

    /* renamed from: h, reason: collision with root package name */
    public String f132030h;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f132031h0;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.bk.e f132032i;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f132033i0;

    /* renamed from: j, reason: collision with root package name */
    public n f132034j;

    /* renamed from: j0, reason: collision with root package name */
    public String f132035j0;

    /* renamed from: k, reason: collision with root package name */
    public com.tencent.luggage.wxa.ob.b f132036k;

    /* renamed from: k0, reason: collision with root package name */
    public boolean f132037k0;

    /* renamed from: l, reason: collision with root package name */
    public long f132038l;

    /* renamed from: l0, reason: collision with root package name */
    public String f132039l0;

    /* renamed from: m, reason: collision with root package name */
    public long f132040m;

    /* renamed from: m0, reason: collision with root package name */
    public m f132041m0;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.ki.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6387a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public a[] newArray(int i3) {
            return new a[i3];
        }
    }

    public /* synthetic */ a(Parcel parcel, C6387a c6387a) {
        this(parcel);
    }

    public static String b(String str) {
        return com.tencent.luggage.wxa.rc.m.c(str);
    }

    public void a(d dVar) {
        s sVar;
        if (dVar == null) {
            return;
        }
        if (TextUtils.isEmpty(dVar.G)) {
            dVar.G = this.f132016a;
        }
        com.tencent.luggage.wxa.ob.b bVar = this.f132036k;
        if (bVar != null && (sVar = bVar.f136268d) != null) {
            dVar.O.a(sVar);
        }
        dVar.f125813f = b(this.f132026f);
        dVar.H = StringUtils.trim(this.f132028g);
        n nVar = this.f132034j;
        if (nVar == null) {
            dVar.N.a();
        } else {
            dVar.N.a(nVar);
        }
        com.tencent.luggage.wxa.ob.b bVar2 = this.f132036k;
        dVar.L = bVar2 == null ? null : bVar2.f136265a;
        dVar.M = bVar2 == null ? null : bVar2.f136266b;
        dVar.R = bVar2 != null ? bVar2.f136271g : null;
        dVar.S = this.f132038l;
        dVar.T = this.f132040m;
        dVar.U = this.C;
        dVar.f130799k0 = this.H;
        dVar.f130800l0 = this.I;
        dVar.G0 = this.X;
        dVar.f130796h0 = this.R;
        dVar.f130797i0 = this.S;
        dVar.f130802n0 = this.f132031h0;
        dVar.f130803o0 = this.T;
        dVar.F0 = this.f132033i0;
        dVar.b(this.f132030h);
        dVar.f130790b0 = this.D;
        dVar.f130793e0 = this.F;
        dVar.f130804p0 = this.f132029g0;
        dVar.f130813y0 = this.Q;
        dVar.f130812x0 = this.O;
        dVar.L0 = this.f132041m0;
        com.tencent.luggage.wxa.li.b bVar3 = this.V;
        if (bVar3 != null) {
            dVar.J0 = bVar3;
        }
    }

    public final void c(String str) {
        this.f132030h = str;
    }

    public final String d() {
        return this.f132030h;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e() {
        OnWXAppResultXPCLeakFreeWrapper.a(this.H);
        OnWXAppResultXPCLeakFreeWrapper.a(this.I);
        OnWXAppResultXPCLeakFreeWrapper.a(this.K);
    }

    public void f() {
        this.f132038l = w0.c();
        this.f132040m = c();
        this.C = j.a();
    }

    public void finalize() {
        try {
            e();
        } finally {
            super.finalize();
        }
    }

    public String toString() {
        String eVar;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("LaunchParcel{username='");
        sb5.append(this.f132016a);
        sb5.append('\'');
        sb5.append(", appId='");
        sb5.append(this.f132018b);
        sb5.append('\'');
        sb5.append(", version=");
        sb5.append(this.f132020c);
        sb5.append(", versionType=");
        sb5.append(this.f132022d);
        sb5.append(", enterPath='");
        sb5.append(this.f132026f);
        sb5.append('\'');
        sb5.append(", statObj=");
        sb5.append(this.f132032i);
        sb5.append(", referrer=");
        sb5.append(this.f132034j);
        sb5.append(", startClickTimestamp=");
        sb5.append(this.f132038l);
        sb5.append(", windowConfig=");
        com.tencent.luggage.wxa.j4.e eVar2 = this.T;
        if (eVar2 == null) {
            eVar = "null";
        } else {
            eVar = eVar2.toString();
        }
        sb5.append(eVar);
        sb5.append('}');
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f132016a);
        parcel.writeString(this.f132018b);
        parcel.writeInt(this.f132020c);
        parcel.writeInt(this.f132022d);
        parcel.writeInt(this.f132024e);
        parcel.writeString(this.f132026f);
        parcel.writeString(this.f132028g);
        parcel.writeString(this.f132030h);
        parcel.writeParcelable(this.f132032i, i3);
        parcel.writeParcelable(this.f132034j, i3);
        parcel.writeParcelable(this.f132036k, i3);
        parcel.writeLong(this.f132038l);
        parcel.writeLong(this.f132040m);
        parcel.writeString(this.D);
        parcel.writePersistableBundle(this.E);
        parcel.writeParcelable(this.G, i3);
        OnWXAppResultXPCLeakFreeWrapper.a(this.H, parcel);
        OnWXAppResultXPCLeakFreeWrapper.a(this.I, parcel);
        parcel.writeInt(this.J);
        OnWXAppResultXPCLeakFreeWrapper.a(this.K, parcel);
        parcel.writePersistableBundle(this.L);
        parcel.writeString(this.M);
        parcel.writeInt(this.O);
        parcel.writeParcelable(this.P, i3);
        parcel.writeParcelable(this.U, i3);
        parcel.writeParcelable(this.V, i3);
        parcel.writeStringList(this.W);
        parcel.writeParcelable(this.Q, i3);
        i.a(this.X, parcel);
        parcel.writeInt(this.Y);
        parcel.writeString(this.Z);
        parcel.writeByte(this.R ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.S ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.T, i3);
        parcel.writeString(this.f132017a0);
        parcel.writeString(this.f132021c0);
        parcel.writeString(this.f132019b0.name());
        parcel.writeInt(this.f132023d0 ? 1 : 0);
        parcel.writeInt(this.f132025e0 ? 1 : 0);
        parcel.writeInt(this.f132031h0 ? 1 : 0);
        parcel.writeByte(this.f132033i0 ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.f132029g0, i3);
        parcel.writeString(this.f132035j0);
        parcel.writeByte(this.f132037k0 ? (byte) 1 : (byte) 0);
        parcel.writeDouble(this.C);
        parcel.writeParcelable(this.f132027f0, i3);
        parcel.writeString(this.f132039l0);
        parcel.writeString(this.N);
        parcel.writeParcelable(this.f132041m0, i3);
    }

    public a() {
        this.J = -1;
        this.L = null;
        this.M = null;
        this.N = null;
        this.Q = x.f125989g0;
        this.R = false;
        this.S = false;
        this.T = null;
        this.W = new ArrayList();
        this.X = i.LEGACY;
        this.Y = 0;
        this.Z = "";
        this.f132017a0 = "";
        this.f132019b0 = r.NORMAL;
        this.f132021c0 = "";
        this.f132029g0 = null;
        this.f132031h0 = false;
        this.f132037k0 = false;
    }

    public static long c() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis()) + (System.nanoTime() % 1000000);
    }

    public final Parcel b() {
        Parcel obtain = Parcel.obtain();
        obtain.setDataPosition(0);
        writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        return obtain;
    }

    public a(Parcel parcel) {
        this.J = -1;
        this.L = null;
        this.M = null;
        this.N = null;
        this.Q = x.f125989g0;
        this.R = false;
        this.S = false;
        this.T = null;
        this.W = new ArrayList();
        this.X = i.LEGACY;
        this.Y = 0;
        this.Z = "";
        this.f132017a0 = "";
        r rVar = r.NORMAL;
        this.f132019b0 = rVar;
        this.f132021c0 = "";
        this.f132029g0 = null;
        this.f132031h0 = false;
        this.f132037k0 = false;
        this.f132016a = parcel.readString();
        this.f132018b = parcel.readString();
        this.f132020c = parcel.readInt();
        this.f132022d = parcel.readInt();
        this.f132024e = parcel.readInt();
        this.f132026f = parcel.readString();
        this.f132028g = parcel.readString();
        this.f132030h = parcel.readString();
        this.f132032i = (com.tencent.luggage.wxa.bk.e) parcel.readParcelable(com.tencent.luggage.wxa.bk.e.class.getClassLoader());
        this.f132034j = (n) parcel.readParcelable(n.class.getClassLoader());
        this.f132036k = (com.tencent.luggage.wxa.ob.b) parcel.readParcelable(com.tencent.luggage.wxa.ob.b.class.getClassLoader());
        this.f132038l = parcel.readLong();
        this.f132040m = parcel.readLong();
        this.D = parcel.readString();
        this.E = parcel.readPersistableBundle(a.class.getClassLoader());
        this.G = (b) parcel.readParcelable(b.class.getClassLoader());
        this.H = OnWXAppResultXPCLeakFreeWrapper.a(parcel);
        this.I = OnWXAppResultXPCLeakFreeWrapper.a(parcel);
        this.J = parcel.readInt();
        this.K = OnWXAppResultXPCLeakFreeWrapper.a(parcel);
        this.L = parcel.readPersistableBundle(a.class.getClassLoader());
        this.M = parcel.readString();
        this.O = parcel.readInt();
        this.P = (l) parcel.readParcelable(l.class.getClassLoader());
        this.U = parcel.readParcelable(a.class.getClassLoader());
        this.V = (com.tencent.luggage.wxa.li.b) parcel.readParcelable(a.class.getClassLoader());
        parcel.readStringList(this.W);
        this.Q = (x) parcel.readParcelable(x.class.getClassLoader());
        this.X = i.a(parcel);
        this.Y = parcel.readInt();
        this.Z = parcel.readString();
        this.R = parcel.readByte() > 0;
        this.S = parcel.readByte() > 0;
        this.T = (com.tencent.luggage.wxa.j4.e) parcel.readParcelable(com.tencent.luggage.wxa.j4.e.class.getClassLoader());
        this.f132017a0 = parcel.readString();
        this.f132021c0 = parcel.readString();
        String readString = parcel.readString();
        this.f132019b0 = TextUtils.isEmpty(readString) ? rVar : r.valueOf(readString);
        this.f132023d0 = parcel.readInt() == 1;
        this.f132025e0 = parcel.readInt() == 1;
        this.f132031h0 = parcel.readInt() == 1;
        this.f132033i0 = parcel.readByte() > 0;
        this.f132029g0 = (g) parcel.readParcelable(g.class.getClassLoader());
        this.f132035j0 = parcel.readString();
        this.f132037k0 = parcel.readByte() > 0;
        if (parcel.dataAvail() > 0) {
            this.C = parcel.readDouble();
        }
        if (parcel.dataAvail() > 0) {
            this.f132027f0 = parcel.readParcelable(a.class.getClassLoader());
        }
        this.f132039l0 = parcel.readString();
        this.N = parcel.readString();
        this.f132041m0 = (m) parcel.readParcelable(m.class.getClassLoader());
    }

    public static String a(String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        String b16 = b(str);
        int lastIndexOf = b16.lastIndexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (lastIndexOf != -1) {
            String substring = b16.substring(0, lastIndexOf);
            str2 = b16.substring(lastIndexOf);
            b16 = substring;
        }
        if (!TextUtils.isEmpty(b16) && !b16.endsWith(".html")) {
            sb5.append(b16);
            sb5.append(".html");
            sb5.append(str2);
        } else {
            sb5.append(b16);
            sb5.append(str2);
        }
        return sb5.toString();
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public a clone() {
        Parcel b16 = b();
        a aVar = new a(b16);
        OaidMonitor.parcelRecycle(b16);
        return aVar;
    }
}
