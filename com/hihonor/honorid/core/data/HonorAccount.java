package com.hihonor.honorid.core.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.login.QAdLoginDefine$LoginCookieKey;
import com.tencent.mobileqq.vas.ipc.VasLiveIPCModule;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HonorAccount implements Parcelable {
    public static final Parcelable.Creator<HonorAccount> CREATOR = new a();
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String I;
    private String J;
    private String K;
    private String L;
    private String M;
    private String N;
    private String P;
    private String Q;
    private String R;
    private String S;
    private String T;
    private boolean V;
    private String W;
    private String X;

    /* renamed from: e, reason: collision with root package name */
    private String f36269e;

    /* renamed from: f, reason: collision with root package name */
    private String f36270f;

    /* renamed from: h, reason: collision with root package name */
    private String f36271h;

    /* renamed from: i, reason: collision with root package name */
    private String f36272i;

    /* renamed from: d, reason: collision with root package name */
    private String f36268d = "-1";

    /* renamed from: m, reason: collision with root package name */
    private int f36273m = 0;
    private String H = "";
    private int U = 0;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<HonorAccount> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public HonorAccount createFromParcel(Parcel parcel) {
            HonorAccount honorAccount = new HonorAccount();
            honorAccount.f36268d = parcel.readString();
            honorAccount.f36269e = parcel.readString();
            honorAccount.f36270f = parcel.readString();
            honorAccount.f36271h = parcel.readString();
            honorAccount.f36272i = parcel.readString();
            honorAccount.f36273m = parcel.readInt();
            honorAccount.C = parcel.readString();
            honorAccount.D = parcel.readString();
            honorAccount.E = parcel.readString();
            honorAccount.F = parcel.readString();
            honorAccount.G = parcel.readString();
            honorAccount.H = parcel.readString();
            honorAccount.I = parcel.readString();
            honorAccount.J = parcel.readString();
            honorAccount.K = parcel.readString();
            honorAccount.L = parcel.readString();
            honorAccount.M = parcel.readString();
            honorAccount.N = parcel.readString();
            honorAccount.P = parcel.readString();
            honorAccount.Q = parcel.readString();
            honorAccount.R = parcel.readString();
            honorAccount.S = parcel.readString();
            boolean z16 = true;
            if (parcel.readByte() != 1) {
                z16 = false;
            }
            honorAccount.V = z16;
            honorAccount.W = parcel.readString();
            honorAccount.X = parcel.readString();
            return honorAccount;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public HonorAccount[] newArray(int i3) {
            return new HonorAccount[i3];
        }
    }

    public static String Q0(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (str.contains("+86")) {
            str = str.replace(Marker.ANY_NON_NULL_MARKER, "00");
        }
        if (str.startsWith("0086")) {
            return str.substring(4);
        }
        return str;
    }

    public void A(String str) {
        this.C = str;
    }

    public String A0() {
        return this.f36270f;
    }

    public String B() {
        return this.F;
    }

    public void C0(String str) {
        this.E = str;
    }

    public void D(String str) {
        this.D = str;
    }

    public String D0() {
        return this.f36269e;
    }

    public int E() {
        return this.U;
    }

    public void F0(String str) {
        this.f36270f = str;
    }

    public void G(String str) {
        this.F = str;
    }

    public String G0() {
        return this.L;
    }

    public void I0(String str) {
        this.f36269e = str;
    }

    public String J0() {
        return this.W;
    }

    public void L0(String str) {
        this.L = str;
    }

    public String M() {
        return this.X;
    }

    public String M0() {
        return this.f36272i;
    }

    public void O0(String str) {
        this.W = str;
    }

    public void P0(String str) {
        this.f36272i = str;
    }

    public void V(String str) {
        this.X = str;
    }

    public String Z() {
        return this.I;
    }

    public HonorAccount b(Bundle bundle) {
        q0(bundle.getString("sL"));
        I0(bundle.getString("requestTokenType"));
        F0(bundle.getString("serviceToken"));
        r(Q0(bundle.getString(VasLiveIPCModule.KEY_GET_ACCOUNT_NICK_NAME)));
        P0(bundle.getString("userId"));
        n(bundle.getInt("siteId"));
        A(bundle.getString("Cookie"));
        D(bundle.getString(Constants.SP_DEVICE_ID));
        C0(bundle.getString("subDeviceId"));
        G(bundle.getString("deviceType"));
        u(bundle.getString("accountType"));
        h0(bundle.getString(UserInfo.LOGIN_USER_NAME));
        b0(bundle.getString("countryIsoCode"));
        n0(bundle.getString("STValidStatus"));
        w0(bundle.getString(CommonConstant.KEY_SERVICE_COUNTRY_CODE));
        L0(bundle.getString("uuid"));
        g(bundle.getString("as_server_domain"));
        x(bundle.getString("cas_server_domain"));
        z0(bundle.getString("siteDomain"));
        f(bundle.getInt(CommonConstant.KEY_HOME_ZONE, 0));
        e0(bundle.getString("lastupdatetime"));
        o(bundle.getString(QAdLoginDefine$LoginCookieKey.WX_ACCESS_TOKEN));
        t0(bundle.getString("code"));
        k0(bundle.getString("open_id"));
        j(bundle.getBoolean("isRealName"));
        O0(bundle.getString("union_id"));
        V(bundle.getString("id_token"));
        return this;
    }

    public void b0(String str) {
        this.I = str;
    }

    public String c() {
        return this.M;
    }

    public String c0() {
        String str = this.P;
        if (str == null) {
            return "0";
        }
        return str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void e0(String str) {
        this.P = str;
    }

    public void f(int i3) {
        this.U = i3;
    }

    public String f0() {
        return this.H;
    }

    public void g(String str) {
        this.M = str;
    }

    public void h0(String str) {
        this.H = str;
    }

    public String i0() {
        return this.S;
    }

    public void j(boolean z16) {
        this.V = z16;
    }

    public void k0(String str) {
        this.S = str;
    }

    public String l() {
        return this.Q;
    }

    public String l0() {
        return this.R;
    }

    public void n(int i3) {
        this.f36273m = i3;
    }

    public void n0(String str) {
        this.J = str;
    }

    public void o(String str) {
        this.Q = str;
    }

    public String o0() {
        if (TextUtils.isEmpty(this.K)) {
            return "";
        }
        return this.K;
    }

    public String p() {
        return this.f36271h;
    }

    public void q0(String str) {
        this.f36268d = str;
    }

    public void r(String str) {
        this.f36271h = str;
    }

    public String r0() {
        return this.T;
    }

    public String s() {
        return this.G;
    }

    public void t0(String str) {
        this.R = str;
    }

    public String toString() {
        return "HonorAccount";
    }

    public void u(String str) {
        this.G = str;
    }

    public int u0() {
        return this.f36273m;
    }

    public String v() {
        return this.N;
    }

    public void w0(String str) {
        this.K = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f36268d);
        parcel.writeString(this.f36269e);
        parcel.writeString(this.f36270f);
        parcel.writeString(this.f36271h);
        parcel.writeString(this.f36272i);
        parcel.writeInt(this.f36273m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
        parcel.writeString(this.M);
        parcel.writeString(this.N);
        parcel.writeString(this.P);
        parcel.writeString(this.Q);
        parcel.writeString(this.R);
        parcel.writeString(this.S);
        parcel.writeByte(this.V ? (byte) 1 : (byte) 0);
        parcel.writeString(this.W);
        parcel.writeString(this.X);
    }

    public void x(String str) {
        this.N = str;
    }

    public String x0() {
        return this.E;
    }

    public String y() {
        return this.D;
    }

    public void z0(String str) {
        this.T = str;
    }
}
