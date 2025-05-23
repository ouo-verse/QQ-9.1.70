package com.tencent.luggage.wxa.j4;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.PersistableBundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.luggage.sdk.launching.OnWXAppResultXPCLeakFreeWrapper;
import com.tencent.luggage.wxa.fd.e0;
import com.tencent.luggage.wxa.fd.i0;
import com.tencent.luggage.wxa.fd.j0;
import com.tencent.luggage.wxa.fd.n0;
import com.tencent.luggage.wxa.fd.s;
import com.tencent.luggage.wxa.fd.x;
import com.tencent.luggage.wxa.j4.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.w0;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends com.tencent.luggage.wxa.fd.i {
    public static final Parcelable.Creator<d> CREATOR = new a();
    public int A0;
    public ArrayList B0;
    public int C0;
    public transient int D;
    public String D0;
    public String E;
    public boolean E0;
    public String F;
    public boolean F0;
    public String G;
    public com.tencent.luggage.wxa.v4.i G0;
    public String H;
    public com.tencent.luggage.wxa.cj.b H0;
    public int I;
    public int I0;
    public boolean J;
    public com.tencent.luggage.wxa.li.b J0;
    public Boolean K;
    public transient com.tencent.luggage.wxa.bk.e K0;
    public String L;
    public com.tencent.luggage.wxa.fd.m L0;
    public String M;
    public final com.tencent.luggage.wxa.fd.n N;
    public final s O;
    public String P;
    public boolean Q;
    public String R;
    public long S;
    public long T;
    public double U;
    public int V;
    public int W;
    public n0.g X;
    public String Y;
    public String Z;

    /* renamed from: a0, reason: collision with root package name */
    public n0.d.a f130789a0;

    /* renamed from: b0, reason: collision with root package name */
    public String f130790b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f130791c0;

    /* renamed from: d0, reason: collision with root package name */
    public PersistableBundle f130792d0;

    /* renamed from: e0, reason: collision with root package name */
    public String f130793e0;

    /* renamed from: f0, reason: collision with root package name */
    public int f130794f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f130795g0;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f130796h0;

    /* renamed from: i0, reason: collision with root package name */
    public boolean f130797i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f130798j0;

    /* renamed from: k0, reason: collision with root package name */
    public com.tencent.luggage.wxa.v4.e f130799k0;

    /* renamed from: l0, reason: collision with root package name */
    public com.tencent.luggage.wxa.v4.e f130800l0;

    /* renamed from: m0, reason: collision with root package name */
    public com.tencent.luggage.wxa.v4.e f130801m0;

    /* renamed from: n0, reason: collision with root package name */
    public boolean f130802n0;

    /* renamed from: o0, reason: collision with root package name */
    public e f130803o0;

    /* renamed from: p0, reason: collision with root package name */
    public com.tencent.luggage.wxa.fd.g f130804p0;

    /* renamed from: q0, reason: collision with root package name */
    public String f130805q0;

    /* renamed from: r0, reason: collision with root package name */
    public String f130806r0;

    /* renamed from: s0, reason: collision with root package name */
    public String f130807s0;

    /* renamed from: t0, reason: collision with root package name */
    public int f130808t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f130809u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f130810v0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f130811w0;

    /* renamed from: x0, reason: collision with root package name */
    public int f130812x0;

    /* renamed from: y0, reason: collision with root package name */
    public x f130813y0;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f130814z0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d createFromParcel(Parcel parcel) {
            return new d(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public d[] newArray(int i3) {
            return new d[i3];
        }
    }

    public d() {
        this.K = null;
        this.f130792d0 = new PersistableBundle();
        this.f130802n0 = false;
        this.f130803o0 = null;
        this.f130806r0 = "";
        this.f130813y0 = x.f125989g0;
        this.f130814z0 = false;
        this.E0 = false;
        this.G0 = com.tencent.luggage.wxa.v4.i.LEGACY;
        this.H0 = com.tencent.luggage.wxa.cj.b.f123564d;
        this.I0 = 4;
        this.L0 = null;
        this.N = new com.tencent.luggage.wxa.fd.n();
        this.O = new s();
    }

    public final void b(String str) {
        w.d("Luggage.AppBrandInitConfigLU", "resetSession(%s) %s", str, Log.getStackTraceString(new Throwable()));
        this.E = str;
    }

    @Override // com.tencent.luggage.wxa.fd.i
    public final JSONObject c() {
        return this.N.b();
    }

    public JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.f125808a);
            jSONObject.put("nickname", this.f125809b);
            jSONObject.put("icon", this.f125810c);
            if (jSONObject.length() == 0) {
                return null;
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public final long f() {
        return this.S;
    }

    public final String g() {
        return this.X.f125931l;
    }

    @Override // com.tencent.luggage.wxa.fd.i
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public d clone() {
        return (d) super.clone();
    }

    public com.tencent.luggage.wxa.bk.e i() {
        return this.K0;
    }

    public final String j() {
        return this.E;
    }

    public final String k() {
        return this.F;
    }

    public boolean l() {
        return e0.a(this.I);
    }

    public boolean m() {
        return this.E0;
    }

    public boolean n() {
        if (!this.J && this.I != 7) {
            return false;
        }
        return true;
    }

    public final boolean o() {
        boolean z16;
        Boolean bool = this.K;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (w0.c(g())) {
            this.K = Boolean.FALSE;
            return false;
        }
        try {
            JSONArray optJSONArray = new JSONObject(g()).optJSONArray("call_plugin_info");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            Boolean valueOf = Boolean.valueOf(z16);
            this.K = valueOf;
            return valueOf.booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    public final void p() {
        w.d("Luggage.AppBrandInitConfigLU", "resetSession() %s", Log.getStackTraceString(new Throwable()));
        l lVar = l.b.f130852a;
        if (lVar == null) {
            lVar = l.f130851b;
        }
        this.E = lVar.a(this);
    }

    public JSONObject q() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("shareKey", this.M);
            jSONObject.put("shareName", this.L);
            if (jSONObject.length() == 0) {
                return null;
            }
            return jSONObject;
        } catch (JSONException unused) {
            return null;
        }
    }

    public String r() {
        e eVar = this.f130803o0;
        if (eVar == null) {
            return null;
        }
        return eVar.b();
    }

    public final i0 s() {
        e eVar = this.f130803o0;
        if (eVar == null) {
            return i0.DEFAULT;
        }
        return eVar.a();
    }

    public final j0 t() {
        e eVar = this.f130803o0;
        if (eVar == null) {
            return j0.UNKNOWN;
        }
        return eVar.c();
    }

    public String toString() {
        return "AppBrandInitConfigLU {visitingSessionId='" + this.E + "', wxaLaunchInstanceId=" + this.F + ", clickTimestamp=" + f() + ", username='" + this.G + "', appId='" + this.f125808a + "', brandName='" + this.f125809b + "', debugType=" + this.f125811d + ", orientation='" + this.f125812e + "', enterPath='" + this.f125813f + "', shareName='" + this.L + "', shareKey='" + this.M + "', startTime=" + this.S + ", referrer=" + this.N + ", extInfo=" + this.P + ", appVersion=" + this.V + ", wsEndpoint=" + this.R + '}';
    }

    @Override // com.tencent.luggage.wxa.fd.i, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeString(this.L);
        parcel.writeString(this.M);
        parcel.writeParcelable(this.N, i3);
        parcel.writeParcelable(this.O, i3);
        parcel.writeInt(this.I);
        parcel.writeByte(this.Q ? (byte) 1 : (byte) 0);
        parcel.writeString(this.P);
        parcel.writeString(this.R);
        parcel.writeLong(this.S);
        parcel.writeLong(this.T);
        parcel.writeInt(this.V);
        parcel.writeInt(this.W);
        parcel.writeParcelable(this.X, i3);
        parcel.writeString(this.Y);
        parcel.writeString(this.Z);
        parcel.writeParcelable(this.f130789a0, i3);
        parcel.writeString(this.f130790b0);
        parcel.writeString(this.f130791c0);
        parcel.writePersistableBundle(this.f130792d0);
        parcel.writeString(this.f130793e0);
        parcel.writeInt(this.f130798j0);
        parcel.writeByte(this.E0 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.F0 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f130802n0 ? (byte) 1 : (byte) 0);
        OnWXAppResultXPCLeakFreeWrapper.a(this.f130799k0, parcel);
        OnWXAppResultXPCLeakFreeWrapper.a(this.f130800l0, parcel);
        OnWXAppResultXPCLeakFreeWrapper.a(this.f130801m0, parcel);
        com.tencent.luggage.wxa.v4.i.a(this.G0, parcel);
        parcel.writeInt(this.f130794f0);
        parcel.writeInt(this.f130795g0 ? 1 : 0);
        parcel.writeByte(this.f130796h0 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f130797i0 ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.f130803o0, i3);
        parcel.writeString(this.f130805q0);
        parcel.writeString(this.f130806r0);
        parcel.writeInt(this.f130809u0 ? 1 : 0);
        parcel.writeInt(this.f130810v0 ? 1 : 0);
        parcel.writeByte(this.f130811w0 ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f130812x0);
        parcel.writeParcelable(this.f130813y0, i3);
        parcel.writeByte(this.f130814z0 ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.A0);
        parcel.writeStringList(this.B0);
        parcel.writeInt(this.C0);
        if (this.H0 == null) {
            this.H0 = com.tencent.luggage.wxa.cj.b.f123564d;
        }
        parcel.writeParcelable(this.H0, i3);
        parcel.writeInt(this.I0);
        parcel.writeString(this.D0);
        parcel.writeParcelable(this.J0, i3);
        parcel.writeParcelable(this.f130804p0, i3);
    }

    public void a(boolean z16) {
        this.E0 = z16;
    }

    public final void a(String str) {
        com.tencent.luggage.wxa.er.a.a(TextUtils.isEmpty(str));
        w.d("Luggage.AppBrandInitConfigLU", "resetInstanceId(%s) %s", str, Log.getStackTraceString(new Throwable()));
        this.F = str;
    }

    public void a(com.tencent.luggage.wxa.bk.e eVar) {
        this.K0 = eVar;
    }

    public d(Parcel parcel) {
        super(parcel);
        this.K = null;
        this.f130792d0 = new PersistableBundle();
        this.f130802n0 = false;
        this.f130803o0 = null;
        this.f130806r0 = "";
        x xVar = x.f125989g0;
        this.f130813y0 = xVar;
        this.f130814z0 = false;
        this.E0 = false;
        this.G0 = com.tencent.luggage.wxa.v4.i.LEGACY;
        this.H0 = com.tencent.luggage.wxa.cj.b.f123564d;
        this.I0 = 4;
        this.L0 = null;
        this.E = parcel.readString();
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readString();
        this.L = parcel.readString();
        this.M = parcel.readString();
        this.N = (com.tencent.luggage.wxa.fd.n) parcel.readParcelable(com.tencent.luggage.wxa.fd.n.class.getClassLoader());
        this.O = (s) parcel.readParcelable(s.class.getClassLoader());
        this.I = parcel.readInt();
        this.Q = parcel.readByte() != 0;
        this.P = parcel.readString();
        this.R = parcel.readString();
        this.S = parcel.readLong();
        this.T = parcel.readLong();
        this.V = parcel.readInt();
        this.W = parcel.readInt();
        this.X = (n0.g) parcel.readParcelable(n0.g.class.getClassLoader());
        this.Y = parcel.readString();
        this.Z = parcel.readString();
        this.f130789a0 = (n0.d.a) parcel.readParcelable(n0.d.a.class.getClassLoader());
        this.f130790b0 = parcel.readString();
        this.f130791c0 = parcel.readString();
        this.f130792d0 = parcel.readPersistableBundle(d.class.getClassLoader());
        this.f130793e0 = parcel.readString();
        this.f130798j0 = parcel.readInt();
        this.E0 = parcel.readByte() != 0;
        this.F0 = parcel.readByte() > 0;
        this.f130802n0 = parcel.readByte() > 0;
        this.f130799k0 = OnWXAppResultXPCLeakFreeWrapper.a(parcel);
        this.f130800l0 = OnWXAppResultXPCLeakFreeWrapper.a(parcel);
        this.f130801m0 = OnWXAppResultXPCLeakFreeWrapper.a(parcel);
        this.G0 = com.tencent.luggage.wxa.v4.i.a(parcel);
        this.f130794f0 = parcel.readInt();
        this.f130795g0 = parcel.readInt() > 0;
        this.f130796h0 = parcel.readByte() > 0;
        this.f130797i0 = parcel.readByte() > 0;
        this.f130803o0 = (e) parcel.readParcelable(e.class.getClassLoader());
        this.f130805q0 = parcel.readString();
        this.f130806r0 = parcel.readString();
        this.f130809u0 = parcel.readInt() == 1;
        this.f130810v0 = parcel.readInt() == 1;
        this.f130811w0 = parcel.readByte() > 0;
        this.f130812x0 = parcel.readInt();
        x xVar2 = (x) parcel.readParcelable(x.class.getClassLoader());
        this.f130813y0 = xVar2 != null ? xVar2 : xVar;
        this.f130814z0 = parcel.readByte() > 0;
        this.A0 = parcel.readInt();
        this.B0 = parcel.createStringArrayList();
        this.C0 = parcel.readInt();
        this.H0 = (com.tencent.luggage.wxa.cj.b) parcel.readParcelable(com.tencent.luggage.wxa.cj.b.class.getClassLoader());
        this.I0 = parcel.readInt();
        this.D0 = parcel.readString();
        this.J0 = (com.tencent.luggage.wxa.li.b) parcel.readParcelable(com.tencent.luggage.wxa.li.b.class.getClassLoader());
        this.f130804p0 = (com.tencent.luggage.wxa.fd.g) parcel.readParcelable(com.tencent.luggage.wxa.fd.g.class.getClassLoader());
    }
}
