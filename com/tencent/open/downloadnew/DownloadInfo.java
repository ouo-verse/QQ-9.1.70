package com.tencent.open.downloadnew;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.mobileqq.utils.ah;
import com.tencent.tmassistantbase.util.GlobalUtil;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DownloadInfo implements Parcelable {
    public static final Parcelable.Creator<DownloadInfo> CREATOR = new a();

    /* renamed from: w0, reason: collision with root package name */
    protected static final String f341178w0 = "com.tencent.open.downloadnew.DownloadInfo";
    public String C;
    public long D;
    public int E;
    public String F;
    public String G;
    public String H;
    public int I;
    public int J;
    public int K;
    public String L;
    public String M;
    public int N;
    protected volatile int P;
    public volatile int Q;
    public Intent R;
    public int S;
    public boolean T;
    public boolean U;
    public long V;
    public int W;
    public boolean X;
    public String Y;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f341179a0;

    /* renamed from: b0, reason: collision with root package name */
    public long f341180b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f341181c0;

    /* renamed from: d, reason: collision with root package name */
    public String f341182d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f341183d0;

    /* renamed from: e, reason: collision with root package name */
    public String f341184e;

    /* renamed from: e0, reason: collision with root package name */
    public String f341185e0;

    /* renamed from: f, reason: collision with root package name */
    public String f341186f;

    /* renamed from: f0, reason: collision with root package name */
    public long f341187f0;

    /* renamed from: g0, reason: collision with root package name */
    public String f341188g0;

    /* renamed from: h, reason: collision with root package name */
    public String f341189h;

    /* renamed from: h0, reason: collision with root package name */
    public String f341190h0;

    /* renamed from: i, reason: collision with root package name */
    public String f341191i;

    /* renamed from: i0, reason: collision with root package name */
    public String f341192i0;

    /* renamed from: j0, reason: collision with root package name */
    public String f341193j0;

    /* renamed from: k0, reason: collision with root package name */
    public String f341194k0;

    /* renamed from: l0, reason: collision with root package name */
    public String f341195l0;

    /* renamed from: m, reason: collision with root package name */
    public String f341196m;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f341197m0;

    /* renamed from: n0, reason: collision with root package name */
    public int f341198n0;

    /* renamed from: o0, reason: collision with root package name */
    public String f341199o0;

    /* renamed from: p0, reason: collision with root package name */
    public String f341200p0;

    /* renamed from: q0, reason: collision with root package name */
    public String f341201q0;

    /* renamed from: r0, reason: collision with root package name */
    public boolean f341202r0;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f341203s0;

    /* renamed from: t0, reason: collision with root package name */
    public long f341204t0;

    /* renamed from: u0, reason: collision with root package name */
    public boolean f341205u0;

    /* renamed from: v0, reason: collision with root package name */
    public int f341206v0;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements Parcelable.Creator<DownloadInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadInfo createFromParcel(Parcel parcel) {
            return new DownloadInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DownloadInfo[] newArray(int i3) {
            return new DownloadInfo[i3];
        }
    }

    public DownloadInfo() {
        this.f341196m = "";
        this.E = 0;
        this.I = 0;
        this.J = 0;
        this.K = 1;
        this.L = "";
        this.M = "";
        this.N = 0;
        this.P = 1;
        this.Q = 0;
        this.T = true;
        this.U = false;
        this.V = 0L;
        this.W = 0;
        this.X = true;
        this.Y = "";
        this.Z = 0;
        this.f341179a0 = -1;
        this.f341180b0 = 0L;
        this.f341181c0 = null;
        this.f341183d0 = false;
        this.f341185e0 = "";
        this.f341187f0 = 0L;
        this.f341188g0 = "";
        this.f341190h0 = "";
        this.f341192i0 = "";
        this.f341193j0 = "6000";
        this.f341194k0 = "0";
        this.f341195l0 = "0";
        this.f341197m0 = false;
        this.f341202r0 = false;
        this.f341205u0 = false;
        this.f341206v0 = 0;
    }

    public static String a(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str + "_" + i3;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return com.tencent.open.base.g.d(str);
    }

    private static String c(String str) {
        try {
            String str2 = "" + com.tencent.open.adapter.a.f().l() + ah.z() + System.currentTimeMillis() + str;
            com.tencent.open.base.f.e(f341178w0, ">genUniqueId ori=" + str2);
            return com.tencent.open.base.g.d(str2);
        } catch (Throwable unused) {
            return "" + System.currentTimeMillis();
        }
    }

    private void n() {
        if (!TextUtils.isEmpty(this.f341182d) && TextUtils.isEmpty(this.f341200p0)) {
            this.f341200p0 = c(this.f341182d);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e(String str) {
        JSONObject jSONObject;
        String str2 = "";
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f341201q0)) {
            try {
                jSONObject = new JSONObject(this.f341201q0);
            } catch (JSONException unused) {
                jSONObject = null;
            }
            if (jSONObject != null) {
                str2 = jSONObject.optString(str);
            }
            com.tencent.open.base.f.e(f341178w0, ">getExtParam " + str + ContainerUtils.KEY_VALUE_DELIMITER + str2);
            return str2;
        }
        com.tencent.open.base.f.e(f341178w0, ">getExtParam empty params:" + str + "|" + this.f341201q0);
        return "";
    }

    public synchronized int f() {
        return this.P;
    }

    public void g() {
        this.f341200p0 = "";
        m();
    }

    public boolean j(String str, String str2) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(this.f341201q0)) {
                jSONObject = new JSONObject();
            } else {
                try {
                    jSONObject = new JSONObject(this.f341201q0);
                } catch (JSONException unused) {
                    this.f341201q0 = "";
                    jSONObject = new JSONObject();
                }
            }
            try {
                jSONObject.put(str, str2);
                com.tencent.open.base.f.e(f341178w0, ">setExtParam " + str + ContainerUtils.KEY_VALUE_DELIMITER + str2);
                this.f341201q0 = jSONObject.toString();
                return true;
            } catch (Exception e16) {
                com.tencent.open.base.f.d(f341178w0, ">setExtParam failed:", e16);
            }
        }
        return false;
    }

    public synchronized void k(int i3) {
        this.P = i3;
    }

    public JSONObject l() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appid", this.f341184e);
            jSONObject.put("state", this.P);
            jSONObject.put(WadlResult.WEB_KEY_PROGRESS, this.Q);
            jSONObject.put("packagename", this.f341189h);
            jSONObject.put("ismyapp", this.J);
            jSONObject.put("download_from", this.W);
            jSONObject.put("realDownloadType", this.K);
            jSONObject.put("via", this.C);
            jSONObject.put(WadlResult.WEB_KEY_WRITE_CODE_STATE, this.f341179a0);
            jSONObject.put("extraInfo", this.f341181c0);
            jSONObject.put(WadlResult.WEB_KEY_IS_AUTO_INSTALL_BY_SDK, this.f341183d0);
            jSONObject.put("fileMd5", this.f341185e0);
            jSONObject.put("fileSize", this.f341187f0);
        } catch (JSONException e16) {
            com.tencent.open.base.f.d(f341178w0, "onNetworkConnect " + e16.getMessage(), e16);
        }
        return jSONObject;
    }

    public void m() {
        if (TextUtils.isEmpty(this.f341182d)) {
            if (!TextUtils.isEmpty(this.f341186f)) {
                this.f341182d = b(this.f341186f);
                com.tencent.open.base.f.e(f341178w0, "gen ticket by urlStr");
            } else if (!TextUtils.isEmpty(this.F)) {
                this.f341182d = b(this.F);
                com.tencent.open.base.f.e(f341178w0, "gen ticket by urlPatch");
            } else if (!TextUtils.isEmpty(this.f341189h)) {
                this.f341182d = a(this.f341189h, this.I);
                com.tencent.open.base.f.e(f341178w0, "gen ticket by packageName & versionCode");
            } else {
                com.tencent.open.base.f.c(f341178w0, "bad download INFO!!!");
            }
        }
        n();
    }

    public String toString() {
        return "DownloadInfo [ticket=" + this.f341182d + ", source =" + this.M + ", uniqueId=" + this.f341200p0 + ", state=" + this.P + ", urlStr=" + this.f341186f + ", urlPatch=" + this.F + ", packageName=" + this.f341189h + ", versionCode=" + this.I + ", fileSize =" + this.f341187f0 + ", totalDataLength =" + this.f341180b0 + ", progress=" + this.Q + ", isAutoInstallBySDK =" + this.f341183d0 + ", isAutoInstall=" + this.T + ", filePath=" + this.L + ", appId=" + this.f341184e + ", push_title=" + this.f341191i + ", sendTime=" + this.f341196m + ", time=" + this.D + ", updateType=" + this.E + ", myAppId=" + this.G + ", apkId=" + this.H + ", lastDownloadSize=" + this.V + ", isApk=" + this.X + ", iconUrl=" + this.Y + ", isShowNotification=" + this.Z + ", writeCodeState=" + this.f341179a0 + ", extraInfo =" + this.f341181c0 + ", fileMd5 =" + this.f341185e0 + ", recommendId =" + this.f341188g0 + ", notificationStyle =" + this.N + ", injectTraceIdOffset =" + this.f341204t0 + ", isInjectedTraceId" + this.f341205u0 + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f341182d);
        parcel.writeString(this.f341184e);
        parcel.writeString(this.f341186f);
        parcel.writeString(this.f341189h);
        parcel.writeString(this.f341191i);
        parcel.writeString(this.f341196m);
        parcel.writeString(this.C);
        parcel.writeLong(this.D);
        parcel.writeInt(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeInt(this.I);
        parcel.writeInt(this.J);
        parcel.writeInt(this.K);
        parcel.writeString(this.L);
        parcel.writeString(this.M);
        parcel.writeInt(this.P);
        parcel.writeInt(this.Q);
        parcel.writeParcelable(this.R, i3);
        parcel.writeInt(this.S);
        parcel.writeByte(this.T ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.U ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.V);
        parcel.writeInt(this.W);
        parcel.writeByte(this.X ? (byte) 1 : (byte) 0);
        parcel.writeString(this.Y);
        parcel.writeInt(this.Z);
        parcel.writeInt(this.f341179a0);
        parcel.writeLong(this.f341180b0);
        parcel.writeString(this.f341181c0);
        parcel.writeByte(this.f341183d0 ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f341185e0);
        parcel.writeLong(this.f341187f0);
        parcel.writeString(this.f341188g0);
        parcel.writeString(this.f341190h0);
        parcel.writeString(this.f341192i0);
        parcel.writeString(this.f341193j0);
        parcel.writeString(this.f341194k0);
        parcel.writeString(this.f341195l0);
        parcel.writeByte(this.f341197m0 ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f341198n0);
        parcel.writeString(this.f341199o0);
        parcel.writeString(this.f341200p0);
        parcel.writeString(this.f341201q0);
        parcel.writeInt(this.N);
        parcel.writeLong(this.f341204t0);
        parcel.writeByte(this.f341205u0 ? (byte) 1 : (byte) 0);
    }

    public DownloadInfo(String str, String str2) {
        this.f341196m = "";
        this.E = 0;
        this.I = 0;
        this.J = 0;
        this.K = 1;
        this.L = "";
        this.M = "";
        this.N = 0;
        this.P = 1;
        this.Q = 0;
        this.T = true;
        this.U = false;
        this.V = 0L;
        this.W = 0;
        this.X = true;
        this.Y = "";
        this.Z = 0;
        this.f341179a0 = -1;
        this.f341180b0 = 0L;
        this.f341181c0 = null;
        this.f341183d0 = false;
        this.f341185e0 = "";
        this.f341187f0 = 0L;
        this.f341188g0 = "";
        this.f341190h0 = "";
        this.f341192i0 = "";
        this.f341193j0 = "6000";
        this.f341194k0 = "0";
        this.f341195l0 = "0";
        this.f341197m0 = false;
        this.f341202r0 = false;
        this.f341205u0 = false;
        this.f341206v0 = 0;
        this.f341184e = str;
        this.f341189h = str2;
    }

    public DownloadInfo(String str, String str2, String str3, String str4, String str5, long j3, String str6, String str7, int i3, String str8, String str9, int i16, int i17, String str10, String str11, long j16, boolean z16, int i18, String str12, int i19, int i26, String str13, boolean z17, String str14, long j17) {
        this.f341196m = "";
        this.E = 0;
        this.I = 0;
        this.J = 0;
        this.K = 1;
        this.L = "";
        this.M = "";
        this.N = 0;
        this.P = 1;
        this.Q = 0;
        this.T = true;
        this.U = false;
        this.f341180b0 = 0L;
        this.f341188g0 = "";
        this.f341190h0 = "";
        this.f341192i0 = "";
        this.f341193j0 = "6000";
        this.f341194k0 = "0";
        this.f341195l0 = "0";
        this.f341197m0 = false;
        this.f341202r0 = false;
        this.f341205u0 = false;
        this.f341206v0 = 0;
        this.f341184e = str;
        this.f341186f = str2;
        this.f341189h = str3;
        this.f341191i = str4;
        this.f341196m = str5;
        this.D = j3;
        this.C = str6;
        this.F = str7;
        this.E = i3;
        this.G = str8;
        this.H = str9;
        this.I = i16;
        this.J = i17;
        this.L = str10;
        this.M = str11;
        this.V = j16;
        this.X = z16;
        this.W = i18;
        this.Y = str12;
        this.Z = i19;
        this.f341179a0 = i26;
        this.f341181c0 = str13;
        this.f341183d0 = z17;
        this.f341185e0 = str14;
        this.f341187f0 = j17;
    }

    public DownloadInfo(String str, String str2, String str3, String str4, String str5, Intent intent, String str6, boolean z16) {
        this.f341196m = "";
        this.E = 0;
        this.I = 0;
        this.J = 0;
        this.K = 1;
        this.L = "";
        this.M = "";
        this.N = 0;
        this.P = 1;
        this.Q = 0;
        this.T = true;
        this.U = false;
        this.V = 0L;
        this.W = 0;
        this.X = true;
        this.Y = "";
        this.Z = 0;
        this.f341179a0 = -1;
        this.f341180b0 = 0L;
        this.f341181c0 = null;
        this.f341183d0 = false;
        this.f341185e0 = "";
        this.f341187f0 = 0L;
        this.f341188g0 = "";
        this.f341190h0 = "";
        this.f341192i0 = "";
        this.f341193j0 = "6000";
        this.f341194k0 = "0";
        this.f341195l0 = "0";
        this.f341197m0 = false;
        this.f341202r0 = false;
        this.f341205u0 = false;
        this.f341206v0 = 0;
        this.f341184e = str;
        this.f341186f = str2;
        this.f341189h = str3;
        this.f341191i = str4;
        if (TextUtils.isEmpty(str2)) {
            this.f341196m = "_" + str;
        } else {
            this.f341196m = "_" + GlobalUtil.calcMD5AsString(str2);
        }
        this.D = System.currentTimeMillis();
        this.P = 1;
        this.C = str5;
        this.R = intent;
        this.V = 0L;
        this.M = str6;
        this.X = z16;
    }

    protected DownloadInfo(Parcel parcel) {
        this.f341196m = "";
        this.E = 0;
        this.I = 0;
        this.J = 0;
        this.K = 1;
        this.L = "";
        this.M = "";
        this.N = 0;
        this.P = 1;
        this.Q = 0;
        this.T = true;
        this.U = false;
        this.V = 0L;
        this.W = 0;
        this.X = true;
        this.Y = "";
        this.Z = 0;
        this.f341179a0 = -1;
        this.f341180b0 = 0L;
        this.f341181c0 = null;
        this.f341183d0 = false;
        this.f341185e0 = "";
        this.f341187f0 = 0L;
        this.f341188g0 = "";
        this.f341190h0 = "";
        this.f341192i0 = "";
        this.f341193j0 = "6000";
        this.f341194k0 = "0";
        this.f341195l0 = "0";
        this.f341197m0 = false;
        this.f341202r0 = false;
        this.f341205u0 = false;
        this.f341206v0 = 0;
        this.f341182d = parcel.readString();
        this.f341184e = parcel.readString();
        this.f341186f = parcel.readString();
        this.f341189h = parcel.readString();
        this.f341191i = parcel.readString();
        this.f341196m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readLong();
        this.E = parcel.readInt();
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readString();
        this.I = parcel.readInt();
        this.J = parcel.readInt();
        this.K = parcel.readInt();
        this.L = parcel.readString();
        this.M = parcel.readString();
        this.P = parcel.readInt();
        this.Q = parcel.readInt();
        this.R = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.S = parcel.readInt();
        this.T = parcel.readByte() != 0;
        this.U = parcel.readByte() != 0;
        this.V = parcel.readLong();
        this.W = parcel.readInt();
        this.X = parcel.readByte() != 0;
        this.Y = parcel.readString();
        this.Z = parcel.readInt();
        this.f341179a0 = parcel.readInt();
        this.f341180b0 = parcel.readLong();
        this.f341181c0 = parcel.readString();
        this.f341183d0 = parcel.readByte() != 0;
        this.f341185e0 = parcel.readString();
        this.f341187f0 = parcel.readLong();
        this.f341188g0 = parcel.readString();
        this.f341190h0 = parcel.readString();
        this.f341192i0 = parcel.readString();
        this.f341193j0 = parcel.readString();
        this.f341194k0 = parcel.readString();
        this.f341195l0 = parcel.readString();
        this.f341197m0 = parcel.readByte() != 0;
        this.f341198n0 = parcel.readInt();
        this.f341199o0 = parcel.readString();
        this.f341200p0 = parcel.readString();
        this.f341201q0 = parcel.readString();
        this.N = parcel.readInt();
        this.f341204t0 = parcel.readLong();
        this.f341205u0 = parcel.readByte() != 0;
    }
}
