package com.tencent.mobileqq.guild.profile.profilecard.main;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qqguildsdk.data.IGProIdentityInfo;
import com.tencent.mobileqq.qqguildsdk.data.ea;
import com.tencent.mobileqq.qqguildsdk.data.em;
import com.tencent.mobileqq.qqguildsdk.data.er;
import com.tencent.mobileqq.qqguildsdk.data.eu;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes14.dex */
public class GuildHeaderData implements Parcelable {
    public static final Parcelable.Creator<GuildHeaderData> CREATOR = new a();
    private String C;
    private long D;
    private int E;
    private long F;
    private String G;
    private String H;
    private boolean I;
    private String J;
    private ea K;
    private em L;
    private String M;
    private IGProIdentityInfo N;
    private IGProIdentityInfo P;
    private ArrayList<eu> Q = new ArrayList<>();
    private er R;

    /* renamed from: d, reason: collision with root package name */
    private String f231514d;

    /* renamed from: e, reason: collision with root package name */
    private String f231515e;

    /* renamed from: f, reason: collision with root package name */
    private String f231516f;

    /* renamed from: h, reason: collision with root package name */
    private String f231517h;

    /* renamed from: i, reason: collision with root package name */
    private int f231518i;

    /* renamed from: m, reason: collision with root package name */
    private byte f231519m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Parcelable.Creator<GuildHeaderData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildHeaderData createFromParcel(Parcel parcel) {
            return new GuildHeaderData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildHeaderData[] newArray(int i3) {
            return new GuildHeaderData[i3];
        }
    }

    public GuildHeaderData() {
    }

    public void A(long j3) {
        this.D = j3;
    }

    public void B(ArrayList<eu> arrayList) {
        this.Q = arrayList;
    }

    public void C(boolean z16) {
        this.I = z16;
    }

    public void D(ea eaVar) {
        this.K = eaVar;
    }

    public void E(em emVar) {
        this.L = emVar;
    }

    public void F(String str) {
        this.H = str;
    }

    public void G(String str) {
        this.f231515e = str;
    }

    public void M(String str) {
        this.J = str;
    }

    public void N(String str) {
        this.f231514d = str;
    }

    public String a() {
        return this.C;
    }

    public er b() {
        return this.R;
    }

    public IGProIdentityInfo c() {
        return this.P;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f231517h;
    }

    public int f() {
        return this.f231518i;
    }

    public long g() {
        return this.F;
    }

    public long j() {
        return this.D;
    }

    public ArrayList<eu> k() {
        return this.Q;
    }

    public em l() {
        return this.L;
    }

    public String m() {
        return this.f231515e;
    }

    public String n() {
        return this.J;
    }

    public String o() {
        return this.f231514d;
    }

    public void p(String str) {
        this.C = str;
    }

    public void q(byte b16) {
        this.f231519m = b16;
    }

    public void r(er erVar) {
        this.R = erVar;
    }

    public void s(IGProIdentityInfo iGProIdentityInfo) {
        this.N = iGProIdentityInfo;
    }

    public void t(String str) {
        this.G = str;
    }

    public void u(String str) {
        this.M = str;
    }

    public void v(IGProIdentityInfo iGProIdentityInfo) {
        this.P = iGProIdentityInfo;
    }

    public void w(String str) {
        this.f231517h = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f231515e);
        parcel.writeString(this.f231516f);
        parcel.writeString(this.f231517h);
        parcel.writeInt(this.f231518i);
        parcel.writeByte(this.f231519m);
        parcel.writeString(this.C);
        parcel.writeLong(this.D);
        parcel.writeInt(this.E);
        parcel.writeLong(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeByte(this.I ? (byte) 1 : (byte) 0);
        parcel.writeString(this.J);
    }

    public void x(int i3) {
        this.f231518i = i3;
    }

    public void y(long j3) {
        this.F = j3;
    }

    public void z(String str) {
        this.f231516f = str;
    }

    protected GuildHeaderData(Parcel parcel) {
        this.f231515e = parcel.readString();
        this.f231516f = parcel.readString();
        this.f231517h = parcel.readString();
        this.f231518i = parcel.readInt();
        this.f231519m = parcel.readByte();
        this.C = parcel.readString();
        this.D = parcel.readLong();
        this.E = parcel.readInt();
        this.F = parcel.readLong();
        this.G = parcel.readString();
        this.H = parcel.readString();
        this.I = parcel.readByte() == 1;
        this.J = parcel.readString();
    }
}
