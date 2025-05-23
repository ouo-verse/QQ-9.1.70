package com.tencent.mobileqq.guild.data.profilecard;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;

/* loaded from: classes13.dex */
public class GuildBaseProfileData implements Parcelable {
    public static final Parcelable.Creator<GuildBaseProfileData> CREATOR = new a();
    private int C;
    private int D;
    private String E;
    private boolean F;
    private boolean G;
    boolean H;
    private boolean I;
    private int J;
    private String K;
    private String L;

    /* renamed from: d, reason: collision with root package name */
    private String f216471d;

    /* renamed from: e, reason: collision with root package name */
    private String f216472e;

    /* renamed from: f, reason: collision with root package name */
    private String f216473f;

    /* renamed from: h, reason: collision with root package name */
    private String f216474h;

    /* renamed from: i, reason: collision with root package name */
    private int f216475i;

    /* renamed from: m, reason: collision with root package name */
    private int f216476m;

    /* loaded from: classes13.dex */
    class a implements Parcelable.Creator<GuildBaseProfileData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public GuildBaseProfileData createFromParcel(Parcel parcel) {
            return new GuildBaseProfileData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public GuildBaseProfileData[] newArray(int i3) {
            return new GuildBaseProfileData[i3];
        }
    }

    public GuildBaseProfileData() {
        this.G = true;
        this.I = false;
        this.J = 0;
        this.K = "";
        this.L = "";
    }

    public GuildBaseProfileData A(int i3) {
        this.f216475i = i3;
        return this;
    }

    public void B(int i3) {
        this.f216476m = i3;
    }

    public void C(String str) {
        this.f216473f = str;
    }

    public void D(int i3) {
        this.C = i3;
    }

    public void E(String str) {
        this.L = str;
    }

    public GuildBaseProfileData F(String str) {
        this.f216472e = str;
        return this;
    }

    @NonNull
    public String a() {
        String str = this.E;
        if (str == null) {
            return "";
        }
        return str;
    }

    public String b() {
        return this.f216474h;
    }

    public int c() {
        return this.D;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f216471d;
    }

    public int f() {
        return this.f216475i;
    }

    public int g() {
        return this.f216476m;
    }

    public String j() {
        return this.f216473f;
    }

    public int k() {
        return this.C;
    }

    public String l() {
        return this.f216472e;
    }

    public boolean m() {
        return this.I;
    }

    public boolean n() {
        return this.H;
    }

    public boolean o() {
        if (!TextUtils.isEmpty(this.K) && (this.K.equals("discover") || this.K.equals("channel_the_public"))) {
            return true;
        }
        return false;
    }

    public boolean p() {
        return this.G;
    }

    public boolean q() {
        return this.F;
    }

    public void r(String str) {
        this.E = str;
    }

    public GuildBaseProfileData s(int i3) {
        this.J = i3;
        return this;
    }

    public void t(int i3) {
        this.D = i3;
    }

    public String toString() {
        return "GuildBaseProfileData{mGuildId='" + this.f216471d + "', mTroopUin='" + this.f216472e + "', mSelfTinyId='" + this.f216473f + "', mDstTinyId='" + this.f216474h + "', mProfileType=" + this.f216475i + ", mSceneType=" + this.f216476m + ", mSelfUserType=" + this.C + ", mDstUserType=" + this.D + ", mChannelId='" + this.E + "', mIsRobot=" + this.F + ", mIsMember=" + this.G + ", mIsDirectMsgBlack=" + this.H + ", mIsDetailMemberList=" + this.I + ", channelManager=" + this.J + '}';
    }

    public GuildBaseProfileData u(String str) {
        this.f216471d = str;
        return this;
    }

    public void v(boolean z16) {
        this.I = z16;
    }

    public void w(boolean z16) {
        this.H = z16;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f216471d);
        parcel.writeString(this.f216472e);
        parcel.writeString(this.f216473f);
        parcel.writeString(this.f216474h);
        parcel.writeInt(this.f216475i);
        parcel.writeInt(this.f216476m);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeString(this.E);
        parcel.writeInt(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
        parcel.writeByte(this.F ? (byte) 1 : (byte) 0);
    }

    public void x(boolean z16) {
        this.G = z16;
    }

    public void y(boolean z16) {
        this.F = z16;
    }

    public void z(String str) {
        this.K = str;
    }

    public GuildBaseProfileData(String str, String str2, String str3, int i3, int i16) {
        this.G = true;
        this.I = false;
        this.J = 0;
        this.K = "";
        this.L = "";
        this.f216471d = str;
        this.f216472e = str2;
        this.f216474h = str3;
        this.f216475i = i3;
        this.f216476m = i16;
    }

    protected GuildBaseProfileData(Parcel parcel) {
        this.G = true;
        this.I = false;
        this.J = 0;
        this.K = "";
        this.L = "";
        this.f216471d = parcel.readString();
        this.f216472e = parcel.readString();
        this.f216473f = parcel.readString();
        this.f216474h = parcel.readString();
        this.f216475i = parcel.readInt();
        this.f216476m = parcel.readInt();
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.E = parcel.readString();
        this.J = parcel.readInt();
        this.K = parcel.readString();
        this.L = parcel.readString();
        this.F = parcel.readByte() != 0;
    }
}
