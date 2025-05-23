package com.tencent.mobileqq.qqguildsdk.data;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes17.dex */
public class GuildSourceId implements Parcelable {
    public static final Parcelable.Creator<GuildSourceId> CREATOR = new a();
    private String C;
    private String D;
    private String E;
    private String F;
    private String G;
    private String H;
    private String I;
    private String J;
    private String K;

    /* renamed from: d, reason: collision with root package name */
    private String f265638d;

    /* renamed from: e, reason: collision with root package name */
    private String f265639e;

    /* renamed from: f, reason: collision with root package name */
    private int f265640f;

    /* renamed from: h, reason: collision with root package name */
    private int f265641h;

    /* renamed from: i, reason: collision with root package name */
    private long f265642i;

    /* renamed from: m, reason: collision with root package name */
    private String f265643m;

    /* compiled from: P */
    /* loaded from: classes17.dex */
    class a implements Parcelable.Creator<GuildSourceId> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildSourceId createFromParcel(Parcel parcel) {
            return new GuildSourceId(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildSourceId[] newArray(int i3) {
            return new GuildSourceId[i3];
        }
    }

    public GuildSourceId(String str, String str2, int i3, int i16, String str3) {
        this.f265643m = "";
        this.C = "";
        this.D = "";
        this.E = "";
        this.F = "";
        this.G = "";
        this.f265638d = str;
        this.f265639e = str2;
        this.f265640f = i3;
        this.f265641h = i16;
        this.H = str3;
        this.I = "";
        this.J = "";
        this.K = "";
    }

    public String a() {
        return this.J;
    }

    public int b() {
        return this.f265640f;
    }

    public String c() {
        return this.D;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.I;
    }

    public String f() {
        return this.K;
    }

    public String g() {
        return this.C;
    }

    public String j() {
        return this.E;
    }

    public String k() {
        return this.f265643m;
    }

    public String l() {
        return this.H;
    }

    public String m() {
        return this.G;
    }

    public long n() {
        return this.f265642i;
    }

    public String o() {
        return this.f265638d;
    }

    public int p() {
        return this.f265641h;
    }

    public String q() {
        return this.f265639e;
    }

    public String r() {
        return this.F;
    }

    public void s(String str) {
        this.J = str;
    }

    public void t(String str) {
        this.I = str;
    }

    public String toString() {
        return "GuildSourceId{mSourceId='" + this.f265638d + "', mSubSourceId='" + this.f265639e + "', mEntranceId=" + this.f265640f + ", mSourceType=" + this.f265641h + ", sourceApp=" + this.f265642i + ", sceneId='" + this.f265643m + "', openId='" + this.C + "', flagId='" + this.D + "', pginSourceName='" + this.E + "', visitForm='" + this.F + "', sessionId='" + this.G + "', searchExtensionInfo='" + com.tencent.qqnt.kernel.nativeinterface.cq.w(this.H, 2) + "', inviteCode='" + this.I + "', contentId='" + this.J + "', inviteUuid=" + this.K + '}';
    }

    public void u(String str) {
        this.K = str;
    }

    public void v(String str) {
        this.E = str;
    }

    public void w(String str) {
        this.G = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f265638d);
        parcel.writeString(this.f265639e);
        parcel.writeInt(this.f265640f);
        parcel.writeInt(this.f265641h);
        parcel.writeLong(this.f265642i);
        parcel.writeString(this.f265643m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
    }

    public void x(long j3) {
        this.f265642i = j3;
    }

    public void y(String str) {
        this.F = str;
    }

    protected GuildSourceId(Parcel parcel) {
        this.f265643m = "";
        this.C = "";
        this.D = "";
        this.E = "";
        this.F = "";
        this.G = "";
        this.H = "";
        this.I = "";
        this.J = "";
        this.K = "";
        this.f265638d = parcel.readString();
        this.f265639e = parcel.readString();
        this.f265640f = parcel.readInt();
        this.f265641h = parcel.readInt();
        this.f265642i = parcel.readLong();
        this.f265643m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readString();
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readString();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
    }
}
