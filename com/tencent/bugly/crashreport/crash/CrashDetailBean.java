package com.tencent.bugly.crashreport.crash;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.bugly.crashreport.common.info.PlugInBean;
import com.tencent.bugly.proguard.ai;
import com.tencent.bugly.proguard.ba;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes5.dex */
public class CrashDetailBean implements Parcelable, Comparable<CrashDetailBean> {
    public static final Parcelable.Creator<CrashDetailBean> CREATOR = new Parcelable.Creator<CrashDetailBean>() { // from class: com.tencent.bugly.crashreport.crash.CrashDetailBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ CrashDetailBean createFromParcel(Parcel parcel) {
            return new CrashDetailBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ CrashDetailBean[] newArray(int i3) {
            return new CrashDetailBean[i3];
        }
    };
    public String A;
    public int B;
    public String C;
    public String D;
    public String E;
    public String F;
    public byte[] G;
    public Map<String, String> H;
    public String I;
    public String J;
    public long K;
    public long L;
    public long M;
    public long N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public long S;
    public long T;
    public long U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public String Z;

    /* renamed from: a, reason: collision with root package name */
    public long f97859a;

    /* renamed from: aa, reason: collision with root package name */
    public long f97860aa;

    /* renamed from: ab, reason: collision with root package name */
    public boolean f97861ab;

    /* renamed from: ac, reason: collision with root package name */
    public Map<String, String> f97862ac;

    /* renamed from: ad, reason: collision with root package name */
    public Map<String, String> f97863ad;

    /* renamed from: ae, reason: collision with root package name */
    public int f97864ae;

    /* renamed from: af, reason: collision with root package name */
    public int f97865af;

    /* renamed from: ag, reason: collision with root package name */
    public Map<String, String> f97866ag;

    /* renamed from: ah, reason: collision with root package name */
    public Map<String, String> f97867ah;

    /* renamed from: ai, reason: collision with root package name */
    public byte[] f97868ai;

    /* renamed from: aj, reason: collision with root package name */
    public String f97869aj;

    /* renamed from: ak, reason: collision with root package name */
    @Deprecated
    public String f97870ak;

    /* renamed from: al, reason: collision with root package name */
    public String f97871al;

    /* renamed from: am, reason: collision with root package name */
    public String f97872am;

    /* renamed from: an, reason: collision with root package name */
    public boolean f97873an;

    /* renamed from: ao, reason: collision with root package name */
    public Map<String, String> f97874ao;

    /* renamed from: ap, reason: collision with root package name */
    public String f97875ap;

    /* renamed from: b, reason: collision with root package name */
    public int f97876b;

    /* renamed from: c, reason: collision with root package name */
    public String f97877c;

    /* renamed from: d, reason: collision with root package name */
    public String f97878d;

    /* renamed from: e, reason: collision with root package name */
    public Boolean f97879e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f97880f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f97881g;

    /* renamed from: h, reason: collision with root package name */
    public String f97882h;

    /* renamed from: i, reason: collision with root package name */
    public String f97883i;

    /* renamed from: j, reason: collision with root package name */
    public String f97884j;

    /* renamed from: k, reason: collision with root package name */
    public String f97885k;

    /* renamed from: l, reason: collision with root package name */
    public String f97886l;

    /* renamed from: m, reason: collision with root package name */
    public String f97887m;

    /* renamed from: n, reason: collision with root package name */
    public String f97888n;

    /* renamed from: o, reason: collision with root package name */
    public List<String> f97889o;

    /* renamed from: p, reason: collision with root package name */
    public Map<String, PlugInBean> f97890p;

    /* renamed from: q, reason: collision with root package name */
    public Map<String, PlugInBean> f97891q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f97892r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f97893s;

    /* renamed from: t, reason: collision with root package name */
    public int f97894t;

    /* renamed from: u, reason: collision with root package name */
    public String f97895u;

    /* renamed from: v, reason: collision with root package name */
    public String f97896v;

    /* renamed from: w, reason: collision with root package name */
    public String f97897w;

    /* renamed from: x, reason: collision with root package name */
    public String f97898x;

    /* renamed from: y, reason: collision with root package name */
    public String f97899y;

    /* renamed from: z, reason: collision with root package name */
    public long f97900z;

    public CrashDetailBean() {
        this.f97859a = -1L;
        this.f97876b = 0;
        this.f97877c = UUID.randomUUID().toString();
        this.f97878d = ai.f97988af;
        this.f97879e = Boolean.FALSE;
        this.f97880f = false;
        this.f97881g = false;
        this.f97882h = "";
        this.f97883i = "";
        this.f97884j = "";
        this.f97885k = "";
        this.f97886l = "";
        this.f97887m = "";
        this.f97888n = "";
        this.f97889o = null;
        this.f97890p = null;
        this.f97891q = null;
        this.f97892r = false;
        this.f97893s = false;
        this.f97894t = 0;
        this.f97895u = "";
        this.f97896v = "";
        this.f97897w = "";
        this.f97898x = "";
        this.f97899y = "";
        this.f97900z = -1L;
        this.A = null;
        this.B = 0;
        this.C = "";
        this.D = "";
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = "";
        this.J = "";
        this.K = -1L;
        this.L = -1L;
        this.M = -1L;
        this.N = -1L;
        this.O = -1L;
        this.P = -1L;
        this.Q = -1L;
        this.R = -1L;
        this.S = -1L;
        this.T = -1L;
        this.U = -1L;
        this.V = "";
        this.W = "";
        this.X = "";
        this.Y = "";
        this.Z = "";
        this.f97860aa = -1L;
        this.f97861ab = false;
        this.f97862ac = null;
        this.f97863ad = null;
        this.f97864ae = -1;
        this.f97865af = -1;
        this.f97866ag = null;
        this.f97867ah = null;
        this.f97868ai = null;
        this.f97869aj = null;
        this.f97870ak = null;
        this.f97871al = null;
        this.f97872am = null;
        this.f97873an = false;
        this.f97874ao = null;
        this.f97875ap = "";
    }

    public final void a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str2 == null) {
            str2 = "";
        }
        if (this.f97874ao == null) {
            this.f97874ao = new HashMap();
        }
        this.f97874ao.put(str, str2);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(CrashDetailBean crashDetailBean) {
        CrashDetailBean crashDetailBean2 = crashDetailBean;
        if (crashDetailBean2 != null) {
            long j3 = this.f97900z - crashDetailBean2.f97900z;
            if (j3 <= 0) {
                if (j3 < 0) {
                    return -1;
                }
                return 0;
            }
            return 1;
        }
        return 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f97876b);
        parcel.writeString(this.f97877c);
        parcel.writeString(this.f97878d);
        parcel.writeByte(this.f97879e.booleanValue() ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f97880f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f97881g ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f97882h);
        parcel.writeString(this.f97883i);
        parcel.writeString(this.f97884j);
        parcel.writeString(this.f97885k);
        parcel.writeString(this.f97886l);
        parcel.writeString(this.f97887m);
        parcel.writeString(this.f97888n);
        parcel.writeStringList(this.f97889o);
        parcel.writeByte(this.f97892r ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f97893s ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f97894t);
        parcel.writeString(this.f97895u);
        parcel.writeString(this.f97896v);
        parcel.writeString(this.f97897w);
        parcel.writeString(this.f97898x);
        parcel.writeString(this.f97899y);
        parcel.writeLong(this.f97900z);
        parcel.writeString(this.A);
        parcel.writeInt(this.B);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        ba.b(parcel, this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeLong(this.K);
        parcel.writeLong(this.L);
        parcel.writeLong(this.M);
        parcel.writeLong(this.N);
        parcel.writeLong(this.O);
        parcel.writeLong(this.P);
        parcel.writeString(this.V);
        parcel.writeString(this.W);
        parcel.writeString(this.X);
        parcel.writeString(this.Y);
        parcel.writeString(this.Z);
        parcel.writeLong(this.f97860aa);
        parcel.writeByte(this.f97861ab ? (byte) 1 : (byte) 0);
        ba.b(parcel, this.f97862ac);
        ba.a(parcel, this.f97890p);
        ba.a(parcel, this.f97891q);
        parcel.writeInt(this.f97864ae);
        parcel.writeInt(this.f97865af);
        ba.b(parcel, this.f97866ag);
        ba.b(parcel, this.f97867ah);
        parcel.writeByteArray(this.f97868ai);
        parcel.writeByteArray(this.G);
        parcel.writeString(this.f97869aj);
        parcel.writeString(this.f97870ak);
        parcel.writeString(this.F);
        parcel.writeLong(this.Q);
        parcel.writeLong(this.R);
        parcel.writeLong(this.S);
        parcel.writeLong(this.T);
        parcel.writeLong(this.U);
        parcel.writeString(this.f97871al);
        parcel.writeString(this.f97872am);
        parcel.writeByte(this.f97873an ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f97875ap);
        ba.b(parcel, this.f97874ao);
    }

    public final String a(String str) {
        Map<String, String> map;
        if (TextUtils.isEmpty(str) || (map = this.f97874ao) == null) {
            return null;
        }
        return map.get(str);
    }

    public CrashDetailBean(Parcel parcel) {
        this.f97859a = -1L;
        this.f97876b = 0;
        this.f97877c = UUID.randomUUID().toString();
        this.f97878d = ai.f97988af;
        this.f97879e = Boolean.FALSE;
        this.f97880f = false;
        this.f97881g = false;
        this.f97882h = "";
        this.f97883i = "";
        this.f97884j = "";
        this.f97885k = "";
        this.f97886l = "";
        this.f97887m = "";
        this.f97888n = "";
        this.f97889o = null;
        this.f97890p = null;
        this.f97891q = null;
        this.f97892r = false;
        this.f97893s = false;
        this.f97894t = 0;
        this.f97895u = "";
        this.f97896v = "";
        this.f97897w = "";
        this.f97898x = "";
        this.f97899y = "";
        this.f97900z = -1L;
        this.A = null;
        this.B = 0;
        this.C = "";
        this.D = "";
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = null;
        this.I = "";
        this.J = "";
        this.K = -1L;
        this.L = -1L;
        this.M = -1L;
        this.N = -1L;
        this.O = -1L;
        this.P = -1L;
        this.Q = -1L;
        this.R = -1L;
        this.S = -1L;
        this.T = -1L;
        this.U = -1L;
        this.V = "";
        this.W = "";
        this.X = "";
        this.Y = "";
        this.Z = "";
        this.f97860aa = -1L;
        this.f97861ab = false;
        this.f97862ac = null;
        this.f97863ad = null;
        this.f97864ae = -1;
        this.f97865af = -1;
        this.f97866ag = null;
        this.f97867ah = null;
        this.f97868ai = null;
        this.f97869aj = null;
        this.f97870ak = null;
        this.f97871al = null;
        this.f97872am = null;
        this.f97873an = false;
        this.f97874ao = null;
        this.f97875ap = "";
        this.f97876b = parcel.readInt();
        this.f97877c = parcel.readString();
        this.f97878d = parcel.readString();
        this.f97879e = Boolean.valueOf(parcel.readByte() == 1);
        this.f97880f = parcel.readByte() == 1;
        this.f97881g = parcel.readByte() == 1;
        this.f97882h = parcel.readString();
        this.f97883i = parcel.readString();
        this.f97884j = parcel.readString();
        this.f97885k = parcel.readString();
        this.f97886l = parcel.readString();
        this.f97887m = parcel.readString();
        this.f97888n = parcel.readString();
        this.f97889o = parcel.createStringArrayList();
        this.f97892r = parcel.readByte() == 1;
        this.f97893s = parcel.readByte() == 1;
        this.f97894t = parcel.readInt();
        this.f97895u = parcel.readString();
        this.f97896v = parcel.readString();
        this.f97897w = parcel.readString();
        this.f97898x = parcel.readString();
        this.f97899y = parcel.readString();
        this.f97900z = parcel.readLong();
        this.A = parcel.readString();
        this.B = parcel.readInt();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readString();
        this.H = ba.b(parcel);
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readLong();
        this.L = parcel.readLong();
        this.M = parcel.readLong();
        this.N = parcel.readLong();
        this.O = parcel.readLong();
        this.P = parcel.readLong();
        this.V = parcel.readString();
        this.W = parcel.readString();
        this.X = parcel.readString();
        this.Y = parcel.readString();
        this.Z = parcel.readString();
        this.f97860aa = parcel.readLong();
        this.f97861ab = parcel.readByte() == 1;
        this.f97862ac = ba.b(parcel);
        this.f97890p = ba.a(parcel);
        this.f97891q = ba.a(parcel);
        this.f97864ae = parcel.readInt();
        this.f97865af = parcel.readInt();
        this.f97866ag = ba.b(parcel);
        this.f97867ah = ba.b(parcel);
        this.f97868ai = parcel.createByteArray();
        this.G = parcel.createByteArray();
        this.f97869aj = parcel.readString();
        this.f97870ak = parcel.readString();
        this.F = parcel.readString();
        this.Q = parcel.readLong();
        this.R = parcel.readLong();
        this.S = parcel.readLong();
        this.T = parcel.readLong();
        this.U = parcel.readLong();
        this.f97871al = parcel.readString();
        this.f97872am = parcel.readString();
        this.f97873an = parcel.readByte() == 1;
        this.f97875ap = parcel.readString();
        this.f97874ao = ba.b(parcel);
    }
}
