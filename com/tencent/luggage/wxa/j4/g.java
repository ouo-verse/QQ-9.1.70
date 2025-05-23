package com.tencent.luggage.wxa.j4;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.luggage.wxa.fd.q;
import com.tencent.luggage.wxa.tn.w0;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes8.dex */
public class g extends q implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new a();
    public String E;
    public boolean F;
    public boolean G;
    public boolean H;
    public boolean I;
    public i J;
    public HashMap K;
    public HashMap L;
    public String M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;
    public boolean T;
    public boolean U;
    public byte[] V;
    public int[] W;
    public ArrayList X;
    public ArrayList Y;
    public ArrayList Z;

    /* renamed from: a0, reason: collision with root package name */
    public ArrayList f130825a0;

    /* renamed from: b0, reason: collision with root package name */
    public ArrayList f130826b0;

    /* renamed from: c0, reason: collision with root package name */
    public ArrayList f130827c0;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f130828d0;

    /* renamed from: e0, reason: collision with root package name */
    public int f130829e0;

    /* renamed from: f0, reason: collision with root package name */
    public long f130830f0;

    /* renamed from: g0, reason: collision with root package name */
    public com.tencent.luggage.wxa.fd.h f130831g0;

    /* renamed from: h0, reason: collision with root package name */
    public String[] f130832h0;

    /* renamed from: i0, reason: collision with root package name */
    public long f130833i0;

    /* renamed from: j0, reason: collision with root package name */
    public String f130834j0;

    /* renamed from: k0, reason: collision with root package name */
    public byte[] f130835k0;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g[] newArray(int i3) {
            return new g[i3];
        }
    }

    public g() {
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.f130830f0 = 0L;
        this.f130832h0 = new String[0];
        this.f130834j0 = "";
    }

    public final int b() {
        return this.f125966l.pkgVersion;
    }

    public final String c() {
        return this.J.f130842c;
    }

    public final com.tencent.luggage.wxa.rj.b d() {
        return this.J.f130840a;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.f130833i0;
    }

    public String toString() {
        String valueOf;
        String valueOf2;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("AppBrandSysConfigLU{, brandName='");
        sb5.append(this.f125955a);
        sb5.append('\'');
        sb5.append(", appId='");
        sb5.append(this.f125956b);
        sb5.append('\'');
        sb5.append(", appIconUrl='");
        sb5.append(this.f125957c);
        sb5.append('\'');
        sb5.append(", debugEnabled=");
        sb5.append(this.F);
        sb5.append(", performancePanelEnabled=");
        sb5.append(this.G);
        sb5.append(", maxWebViewDepth=");
        sb5.append(this.f125958d);
        sb5.append(", maxBackgroundLifeSpan=");
        sb5.append(this.N);
        sb5.append(", maxRequestConcurrent=");
        sb5.append(this.O);
        sb5.append(", maxUploadConcurrent=");
        sb5.append(this.P);
        sb5.append(", maxDownloadConcurrent=");
        sb5.append(this.Q);
        sb5.append(", maxWebsocketConnect=");
        sb5.append(this.R);
        sb5.append(", websocketSkipPortCheck=");
        sb5.append(this.T);
        sb5.append(", requestDomains=");
        sb5.append(this.X);
        sb5.append(", socketDomains=");
        sb5.append(this.Y);
        sb5.append(", uploadDomains=");
        sb5.append(this.Z);
        sb5.append(", downloadDomains=");
        sb5.append(this.f130825a0);
        sb5.append(", udpDomains=");
        sb5.append(this.f130826b0);
        sb5.append(", tcpDomains=");
        sb5.append(this.f130827c0);
        sb5.append(", appPkgInfo=");
        sb5.append(this.f125966l);
        sb5.append(", systemSettings=");
        sb5.append(this.f130831g0);
        sb5.append(", runningFlag=");
        sb5.append(this.f130833i0);
        sb5.append(", operationInfo=");
        sb5.append(this.M);
        sb5.append(", kvStorageScheme=");
        sb5.append(this.f125967m);
        sb5.append(", TLSSkipHostnameCheck=");
        sb5.append(this.U);
        sb5.append(", kvStoragePerformanceReportOn=");
        sb5.append(this.C);
        sb5.append(", pluginPermissionBundleMap=");
        HashMap hashMap = this.K;
        if (hashMap == null) {
            valueOf = String.valueOf(0);
        } else {
            valueOf = String.valueOf(hashMap.size());
        }
        sb5.append(valueOf);
        sb5.append(", appidABTestPermissionBundleMap=");
        HashMap hashMap2 = this.L;
        if (hashMap2 == null) {
            valueOf2 = String.valueOf(0);
        } else {
            valueOf2 = String.valueOf(hashMap2.size());
        }
        sb5.append(valueOf2);
        sb5.append('}');
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f125955a);
        parcel.writeString(this.E);
        parcel.writeString(this.f125956b);
        parcel.writeString(this.f125957c);
        parcel.writeByte(this.F ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.G ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.J, i3);
        parcel.writeInt(this.f125958d);
        parcel.writeInt(this.N);
        parcel.writeInt(this.O);
        parcel.writeInt(this.P);
        parcel.writeInt(this.Q);
        parcel.writeInt(this.R);
        parcel.writeInt(this.S);
        parcel.writeByte(this.T ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.U ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.X);
        parcel.writeStringList(this.Y);
        parcel.writeStringList(this.Z);
        parcel.writeStringList(this.f130825a0);
        parcel.writeStringList(this.f130826b0);
        parcel.writeStringList(this.f130827c0);
        parcel.writeParcelable(this.f125966l, i3);
        parcel.writeParcelable(this.f130831g0, i3);
        parcel.writeByte(this.f125959e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f125960f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f125961g ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f125964j);
        parcel.writeInt(this.f125965k);
        parcel.writeInt(this.f130829e0);
        parcel.writeInt(this.f130828d0 ? 1 : 0);
        parcel.writeLong(this.f130830f0);
        parcel.writeString(this.M);
        parcel.writeInt(this.f130832h0.length);
        parcel.writeStringArray(this.f130832h0);
        parcel.writeInt(this.f125967m);
        parcel.writeInt(this.C ? 1 : 0);
        parcel.writeInt(this.f125962h ? 1 : 0);
        parcel.writeInt(this.f125963i ? 1 : 0);
        parcel.writeLong(this.f130833i0);
        parcel.writeMap(this.K);
        parcel.writeByteArray(this.f130835k0);
        parcel.writeMap(this.L);
        parcel.writeString(this.D);
        if (w0.b(this.V)) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(this.V.length);
            parcel.writeByteArray(this.V);
        }
        if (w0.a(this.W)) {
            parcel.writeInt(-1);
        } else {
            parcel.writeInt(this.W.length);
            parcel.writeIntArray(this.W);
        }
        parcel.writeString(this.f130834j0);
    }

    public g(Parcel parcel) {
        this.F = false;
        this.G = false;
        this.H = false;
        this.I = false;
        this.f130830f0 = 0L;
        this.f130832h0 = new String[0];
        this.f130834j0 = "";
        this.f125955a = parcel.readString();
        this.E = parcel.readString();
        this.f125956b = parcel.readString();
        this.f125957c = parcel.readString();
        this.F = parcel.readByte() != 0;
        this.G = parcel.readByte() != 0;
        this.J = (i) parcel.readParcelable(i.class.getClassLoader());
        this.f125958d = parcel.readInt();
        this.N = parcel.readInt();
        this.O = parcel.readInt();
        this.P = parcel.readInt();
        this.Q = parcel.readInt();
        this.R = parcel.readInt();
        this.S = parcel.readInt();
        this.T = parcel.readByte() != 0;
        this.U = parcel.readByte() != 0;
        this.X = parcel.createStringArrayList();
        this.Y = parcel.createStringArrayList();
        this.Z = parcel.createStringArrayList();
        this.f130825a0 = parcel.createStringArrayList();
        this.f130826b0 = parcel.createStringArrayList();
        this.f130827c0 = parcel.createStringArrayList();
        this.f125966l = (com.tencent.mm.plugin.appbrand.appcache.a) parcel.readParcelable(com.tencent.mm.plugin.appbrand.appcache.a.class.getClassLoader());
        this.f130831g0 = (com.tencent.luggage.wxa.fd.h) parcel.readParcelable(com.tencent.luggage.wxa.fd.h.class.getClassLoader());
        this.f125959e = parcel.readByte() > 0;
        this.f125960f = parcel.readByte() > 0;
        this.f125961g = parcel.readByte() > 0;
        this.f125964j = parcel.readInt();
        this.f125965k = parcel.readInt();
        this.f130829e0 = parcel.readInt();
        this.f130828d0 = parcel.readInt() == 1;
        this.f130830f0 = parcel.readLong();
        this.M = parcel.readString();
        String[] strArr = new String[parcel.readInt()];
        this.f130832h0 = strArr;
        parcel.readStringArray(strArr);
        this.f125967m = parcel.readInt();
        this.C = parcel.readInt() == 1;
        this.f125962h = parcel.readInt() == 1;
        this.f125963i = parcel.readInt() == 1;
        this.f130833i0 = parcel.readLong();
        this.K = parcel.readHashMap(com.tencent.luggage.wxa.rj.b.class.getClassLoader());
        this.f130835k0 = parcel.createByteArray();
        this.L = parcel.readHashMap(com.tencent.luggage.wxa.sj.a.class.getClassLoader());
        this.D = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            byte[] bArr = new byte[readInt];
            this.V = bArr;
            parcel.readByteArray(bArr);
        }
        int readInt2 = parcel.readInt();
        if (readInt2 > 0) {
            int[] iArr = new int[readInt2];
            this.W = iArr;
            parcel.readIntArray(iArr);
        }
        this.f130834j0 = parcel.readString();
    }
}
