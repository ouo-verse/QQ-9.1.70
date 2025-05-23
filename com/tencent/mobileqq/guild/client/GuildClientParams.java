package com.tencent.mobileqq.guild.client;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qqguildsdk.data.di;
import com.tencent.mobileqq.qqguildsdk.data.dn;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetUnbindClientInfo;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes12.dex */
public class GuildClientParams implements Parcelable {
    public static final Parcelable.Creator<GuildClientParams> CREATOR = new a();
    private String C;
    private int D;
    private String E;
    private String F;
    private String G;
    private boolean H;
    private String I;
    private String J;
    private String K;
    private boolean L;
    private List<GuildClientConfig> M;
    private int N;
    private int P;
    private String Q;
    private int R;
    private boolean S;
    private String T;
    private int U;
    private int V;
    private boolean W;
    private String X;

    /* renamed from: d, reason: collision with root package name */
    private String f215363d;

    /* renamed from: e, reason: collision with root package name */
    private String f215364e;

    /* renamed from: f, reason: collision with root package name */
    private String f215365f;

    /* renamed from: h, reason: collision with root package name */
    private Bundle f215366h;

    /* renamed from: i, reason: collision with root package name */
    private String f215367i;

    /* renamed from: m, reason: collision with root package name */
    private String f215368m;

    @Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes12.dex */
    public @interface ExamineStatus {
        public static final int STATUS_EXAMINING = 2;
        public static final int STATUS_FAILED = 1;
        public static final int STATUS_SUCCESS = 0;
    }

    /* loaded from: classes12.dex */
    class a implements Parcelable.Creator<GuildClientParams> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildClientParams createFromParcel(Parcel parcel) {
            return new GuildClientParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildClientParams[] newArray(int i3) {
            return new GuildClientParams[i3];
        }
    }

    public GuildClientParams() {
        this.f215363d = "";
        this.f215364e = "";
        this.f215365f = "";
        this.f215366h = new Bundle();
        this.f215367i = "";
        this.f215368m = "";
        this.C = "";
        this.D = 0;
        this.E = "";
        this.F = "";
        this.G = "";
        this.H = false;
        this.I = "";
        this.J = "";
        this.K = "";
        this.L = false;
        this.M = new ArrayList();
        this.N = 0;
        this.P = 0;
        this.Q = "";
        this.R = 0;
        this.S = true;
        this.T = "";
        this.X = "";
    }

    private List<GuildClientConfig> f0(List<dn> list) {
        ArrayList arrayList = new ArrayList();
        Iterator<dn> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new GuildClientConfig(it.next()));
        }
        return arrayList;
    }

    public String A() {
        return this.E;
    }

    public int B() {
        return this.V;
    }

    public int C() {
        return this.N;
    }

    public String E() {
        return this.G;
    }

    public Bundle F() {
        return this.f215366h;
    }

    public String G() {
        return this.f215363d;
    }

    public boolean M() {
        return this.H;
    }

    public int N() {
        return this.R;
    }

    public String V() {
        return this.Q;
    }

    public int Z() {
        return this.P;
    }

    public GuildClientParams a(int i3) {
        this.D = i3;
        return this;
    }

    public String a0() {
        return this.X;
    }

    public GuildClientParams b(String str) {
        this.f215367i = str;
        return this;
    }

    public String b0() {
        return this.T;
    }

    public GuildClientParams c(String str) {
        this.f215368m = str;
        return this;
    }

    public GuildClientParams c0(String str) {
        this.G = str;
        return this;
    }

    public GuildClientParams d0(Bundle bundle) {
        this.f215366h = bundle;
        return this;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public GuildClientParams e0(String str) {
        this.f215363d = str;
        return this;
    }

    public GuildClientParams f(String str) {
        this.f215364e = str;
        return this;
    }

    public GuildClientParams g(String str) {
        this.f215365f = str;
        return this;
    }

    public GuildClientParams g0(boolean z16) {
        this.H = z16;
        return this;
    }

    public int getType() {
        return this.U;
    }

    public boolean h0() {
        return this.S;
    }

    public GuildClientParams i0(int i3) {
        this.R = i3;
        return this;
    }

    public GuildClientParams j(List<GuildClientConfig> list) {
        this.M = list;
        return this;
    }

    public GuildClientParams j0(String str) {
        this.Q = str;
        return this;
    }

    public GuildClientParams k(String str) {
        this.F = str;
        return this;
    }

    public GuildClientParams k0(boolean z16) {
        this.S = z16;
        return this;
    }

    public GuildClientParams l(String str) {
        this.C = str;
        return this;
    }

    public GuildClientParams l0(int i3) {
        this.P = i3;
        return this;
    }

    public GuildClientParams m(String str) {
        this.E = str;
        return this;
    }

    public GuildClientParams n(int i3) {
        this.N = i3;
        return this;
    }

    public String o() {
        return this.I;
    }

    public String p() {
        return this.J;
    }

    public int q() {
        return this.D;
    }

    public String r() {
        return this.f215367i;
    }

    public String s() {
        return this.f215368m;
    }

    public boolean t() {
        return this.W;
    }

    public String toString() {
        return "GuildClientParams{guildId='" + this.f215363d + "', clientId='" + this.C + "', arkAppName='" + this.f215367i + "', arkId='" + this.f215368m + "', sceneType=" + this.P + ", jumpUrl='" + this.Q + "', channelId='" + this.f215364e + "', channelName='" + this.f215365f + "', appId=" + this.D + ", guildExtra=" + this.f215366h + ", reusable=" + this.S + ", clientName='" + this.E + "', clientIconUrl='" + this.F + "', guildAvatarUrl='" + this.G + "', isGuest='" + this.H + "', accountId='" + this.I + "', accountName='" + this.J + "', clientConfigList=" + this.M + ", accountDescribe='" + this.K + "', isConnect=" + this.L + ", jumpType=" + this.R + ", examiningStatus=" + this.N + ", clientSourceType=" + this.V + ", type=" + this.U + ", unbindUrl=" + this.T + ", canBind=" + this.W + ", toastMsg=" + this.X + '}';
    }

    public String u() {
        return this.f215364e;
    }

    public String v() {
        return this.f215365f;
    }

    public List<GuildClientConfig> w() {
        return this.M;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f215363d);
        parcel.writeString(this.C);
        parcel.writeString(this.f215367i);
        parcel.writeString(this.f215368m);
        parcel.writeInt(this.P);
        parcel.writeString(this.Q);
        parcel.writeString(this.f215364e);
        parcel.writeString(this.f215365f);
        parcel.writeInt(this.D);
        parcel.writeBundle(this.f215366h);
        parcel.writeByte(this.S ? (byte) 1 : (byte) 0);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeByte(this.H ? (byte) 1 : (byte) 0);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeList(this.M);
        parcel.writeString(this.K);
        parcel.writeByte(this.L ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.R);
        parcel.writeInt(this.N);
        parcel.writeInt(this.V);
        parcel.writeInt(this.U);
        parcel.writeString(this.T);
        parcel.writeByte(this.W ? (byte) 1 : (byte) 0);
        parcel.writeString(this.X);
    }

    public String x() {
        StringBuilder sb5 = new StringBuilder();
        for (GuildClientConfig guildClientConfig : this.M) {
            if (guildClientConfig.e()) {
                sb5.append(guildClientConfig.b());
                sb5.append("\u3001");
            }
        }
        if (sb5.length() > 0) {
            sb5.deleteCharAt(sb5.length() - 1);
        } else {
            sb5.append("\u65e0");
        }
        return sb5.toString();
    }

    public String y() {
        return this.F;
    }

    public String z() {
        return this.C;
    }

    public GuildClientParams e() {
        return this;
    }

    public GuildClientParams(GProGetUnbindClientInfo gProGetUnbindClientInfo) {
        this.f215363d = "";
        this.f215364e = "";
        this.f215365f = "";
        this.f215366h = new Bundle();
        this.f215367i = "";
        this.f215368m = "";
        this.C = "";
        this.D = 0;
        this.E = "";
        this.F = "";
        this.G = "";
        this.H = false;
        this.I = "";
        this.J = "";
        this.K = "";
        this.L = false;
        this.M = new ArrayList();
        this.N = 0;
        this.P = 0;
        this.Q = "";
        this.R = 0;
        this.S = true;
        this.T = "";
        this.X = "";
        l(String.valueOf(gProGetUnbindClientInfo.clientId));
        this.E = gProGetUnbindClientInfo.clientName;
        this.F = gProGetUnbindClientInfo.icon;
        this.V = gProGetUnbindClientInfo.clientSourceType;
        this.W = gProGetUnbindClientInfo.canBind;
        this.X = gProGetUnbindClientInfo.toastMsg;
    }

    public GuildClientParams(di diVar) {
        this.f215363d = "";
        this.f215364e = "";
        this.f215365f = "";
        this.f215366h = new Bundle();
        this.f215367i = "";
        this.f215368m = "";
        this.C = "";
        this.D = 0;
        this.E = "";
        this.F = "";
        this.G = "";
        this.H = false;
        this.I = "";
        this.J = "";
        this.K = "";
        this.L = false;
        this.M = new ArrayList();
        this.N = 0;
        this.P = 0;
        this.Q = "";
        this.R = 0;
        this.S = true;
        this.T = "";
        this.X = "";
        l(diVar.getClientId());
        this.E = diVar.getClientName();
        this.F = diVar.getIcon();
        this.I = diVar.a();
        this.J = diVar.b();
        this.T = diVar.e();
        this.U = diVar.getType();
        this.V = diVar.c();
        this.M = f0(diVar.d().a());
    }

    protected GuildClientParams(Parcel parcel) {
        this.f215363d = "";
        this.f215364e = "";
        this.f215365f = "";
        this.f215366h = new Bundle();
        this.f215367i = "";
        this.f215368m = "";
        this.C = "";
        this.D = 0;
        this.E = "";
        this.F = "";
        this.G = "";
        this.H = false;
        this.I = "";
        this.J = "";
        this.K = "";
        this.L = false;
        this.M = new ArrayList();
        this.N = 0;
        this.P = 0;
        this.Q = "";
        this.R = 0;
        this.S = true;
        this.T = "";
        this.X = "";
        this.f215363d = parcel.readString();
        this.C = parcel.readString();
        this.f215367i = parcel.readString();
        this.f215368m = parcel.readString();
        this.P = parcel.readInt();
        this.Q = parcel.readString();
        this.f215364e = parcel.readString();
        this.f215365f = parcel.readString();
        this.D = parcel.readInt();
        this.f215366h = parcel.readBundle(getClass().getClassLoader());
        this.S = parcel.readByte() != 0;
        this.E = parcel.readString();
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readByte() != 0;
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.M = parcel.readArrayList(GuildClientConfig.class.getClassLoader());
        this.K = parcel.readString();
        this.L = parcel.readByte() != 0;
        this.R = parcel.readInt();
        this.N = parcel.readInt();
        this.V = parcel.readInt();
        this.U = parcel.readInt();
        this.T = parcel.readString();
        this.W = parcel.readByte() != 0;
        this.X = parcel.readString();
    }
}
