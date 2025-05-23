package com.tencent.mobileqq.guild.feed.usecases;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.feed.util.bh;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedArkShareInfo implements Parcelable {
    public static final Parcelable.Creator<GuildFeedArkShareInfo> CREATOR = new a();
    private Bundle C;
    private String D;
    private String E;
    private String F;
    private String G;
    private long H;
    private long I;
    private String J;
    private String K;
    private String L;
    private String M;
    private int N;
    private String P;
    private String Q;
    private String R;
    private int S;
    private String T;
    private String U;
    private String V;
    private boolean W;
    private String X;
    private int Y;
    private String Z;

    /* renamed from: a0, reason: collision with root package name */
    private String f223735a0;

    /* renamed from: d, reason: collision with root package name */
    private String f223736d;

    /* renamed from: e, reason: collision with root package name */
    private String f223737e;

    /* renamed from: f, reason: collision with root package name */
    private String f223738f;

    /* renamed from: h, reason: collision with root package name */
    private String f223739h;

    /* renamed from: i, reason: collision with root package name */
    private String f223740i;

    /* renamed from: m, reason: collision with root package name */
    private String f223741m;

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class a implements Parcelable.Creator<GuildFeedArkShareInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildFeedArkShareInfo createFromParcel(Parcel parcel) {
            return new GuildFeedArkShareInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildFeedArkShareInfo[] newArray(int i3) {
            return new GuildFeedArkShareInfo[i3];
        }
    }

    public GuildFeedArkShareInfo() {
        this.f223736d = "";
        this.f223737e = "";
        this.f223738f = "";
        this.f223739h = "";
        this.f223740i = "";
        this.f223741m = "";
        this.D = "";
        this.E = "";
        this.F = "";
        this.G = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = "";
        this.P = "";
        this.Q = "";
        this.R = "";
        this.T = "";
        this.U = "";
        this.V = "";
        this.X = "";
        this.Y = 1;
        this.Z = "";
        this.f223735a0 = "";
    }

    public boolean A() {
        return this.W;
    }

    public boolean B() {
        if (this.Y == 2) {
            return true;
        }
        return false;
    }

    public void C(String str) {
        this.Z = str;
    }

    public void D(String str) {
        this.f223736d = str;
    }

    public void E(String str) {
        this.f223738f = str;
    }

    public void F(String str) {
        this.f223737e = str;
    }

    public void G(String str) {
        this.K = str;
    }

    public void M(String str) {
        this.F = str;
    }

    public void N(int i3) {
        this.N = i3;
    }

    public void V(String str) {
        this.f223741m = str;
    }

    public void Z(long j3) {
        this.H = j3;
    }

    @NonNull
    public String a() {
        return bh.a(this.Z);
    }

    public void a0(Bundle bundle) {
        this.C = bundle;
    }

    @NonNull
    public String b() {
        return bh.a(this.f223735a0);
    }

    public void b0(String str) {
        this.G = str;
    }

    @NonNull
    public String c() {
        return bh.a(this.f223736d);
    }

    public void c0(String str) {
        this.U = str;
    }

    public void d0(String str) {
        this.E = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NonNull
    public String e() {
        return bh.a(this.f223738f);
    }

    public void e0(boolean z16) {
        this.W = z16;
    }

    @NonNull
    public String f() {
        return bh.a(this.f223737e);
    }

    public void f0(String str) {
        this.f223740i = str;
    }

    @NonNull
    public String g() {
        return bh.a(this.K);
    }

    public void g0(String str) {
        this.T = str;
    }

    public void h0(String str) {
        this.M = str;
    }

    public void i0(String str) {
        this.P = str;
    }

    @NonNull
    public String j() {
        return bh.a(this.D);
    }

    public void j0(long j3) {
        this.I = j3;
    }

    @NonNull
    public String k() {
        return bh.a(this.F);
    }

    public void k0(String str) {
        this.f223739h = str;
    }

    @NonNull
    public String l() {
        return bh.a(this.f223741m);
    }

    public void l0(String str) {
        this.X = str;
    }

    public long m() {
        return this.H;
    }

    public void m0(String str) {
        this.V = str;
    }

    @NonNull
    public String n() {
        return bh.a(this.G);
    }

    public void n0(int i3) {
        this.Y = i3;
    }

    @NonNull
    public String o() {
        return bh.a(this.U);
    }

    public void o0(String str) {
        this.Q = str;
    }

    @NonNull
    public String p() {
        return bh.a(this.E);
    }

    public void p0(String str) {
        this.L = str;
    }

    @NonNull
    public String q() {
        return bh.a(this.f223740i);
    }

    public void q0(String str) {
        this.J = str;
    }

    @NonNull
    public String r() {
        return bh.a(this.T);
    }

    @NonNull
    public String s() {
        if (!TextUtils.isEmpty(this.M)) {
            return this.M;
        }
        if (this.N == 0) {
            return String.format(HardCodeUtil.qqStr(R.string.f156661kt), this.P);
        }
        return String.format(HardCodeUtil.qqStr(R.string.f156671ku), Integer.valueOf(this.N), this.P);
    }

    public long t() {
        return this.I;
    }

    @NonNull
    public String u() {
        return bh.a(this.f223739h);
    }

    @NonNull
    public String v() {
        return bh.a(this.X);
    }

    @NonNull
    public String w() {
        return bh.a(this.V);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f223736d);
        parcel.writeString(this.f223737e);
        parcel.writeString(this.f223738f);
        parcel.writeString(this.f223739h);
        parcel.writeString(this.f223740i);
        parcel.writeString(this.f223741m);
        parcel.writeBundle(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeLong(this.H);
        parcel.writeLong(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
        parcel.writeString(this.M);
        parcel.writeInt(this.N);
        parcel.writeString(this.P);
        parcel.writeString(this.Q);
        parcel.writeInt(this.S);
        parcel.writeString(this.T);
        parcel.writeString(this.U);
        parcel.writeString(this.V);
        parcel.writeString(this.X);
        parcel.writeInt(this.Y);
        parcel.writeString(this.Z);
        parcel.writeString(this.f223735a0);
    }

    @NonNull
    public String x() {
        return bh.a(this.Q);
    }

    @NonNull
    public String y() {
        return bh.a(this.L);
    }

    @NonNull
    public String z() {
        return bh.a(this.J);
    }

    protected GuildFeedArkShareInfo(Parcel parcel) {
        this.f223736d = "";
        this.f223737e = "";
        this.f223738f = "";
        this.f223739h = "";
        this.f223740i = "";
        this.f223741m = "";
        this.D = "";
        this.E = "";
        this.F = "";
        this.G = "";
        this.J = "";
        this.K = "";
        this.L = "";
        this.M = "";
        this.P = "";
        this.Q = "";
        this.R = "";
        this.T = "";
        this.U = "";
        this.V = "";
        this.X = "";
        this.Y = 1;
        this.Z = "";
        this.f223735a0 = "";
        this.f223736d = parcel.readString();
        this.f223737e = parcel.readString();
        this.f223738f = parcel.readString();
        this.f223739h = parcel.readString();
        this.f223740i = parcel.readString();
        this.f223741m = parcel.readString();
        this.C = parcel.readBundle();
        this.D = parcel.readString();
        this.E = parcel.readString();
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readLong();
        this.I = parcel.readLong();
        this.J = parcel.readString();
        this.K = parcel.readString();
        this.L = parcel.readString();
        this.M = parcel.readString();
        this.N = parcel.readInt();
        this.P = parcel.readString();
        this.Q = parcel.readString();
        this.S = parcel.readInt();
        this.T = parcel.readString();
        this.U = parcel.readString();
        this.V = parcel.readString();
        this.X = parcel.readString();
        this.Y = parcel.readInt();
        this.Z = parcel.readString();
        this.f223735a0 = parcel.readString();
    }
}
