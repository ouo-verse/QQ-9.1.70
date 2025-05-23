package com.tencent.mobileqq.guild.robot.components.console;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes14.dex */
public class RobotInfo implements Parcelable {
    public static final Parcelable.Creator<RobotInfo> CREATOR = new a();
    private String C;
    private int D;
    private long E;

    /* renamed from: d, reason: collision with root package name */
    private long f232147d;

    /* renamed from: e, reason: collision with root package name */
    private long f232148e;

    /* renamed from: f, reason: collision with root package name */
    private long f232149f;

    /* renamed from: h, reason: collision with root package name */
    private long f232150h;

    /* renamed from: i, reason: collision with root package name */
    private String f232151i;

    /* renamed from: m, reason: collision with root package name */
    private String f232152m;

    /* compiled from: P */
    /* loaded from: classes14.dex */
    class a implements Parcelable.Creator<RobotInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public RobotInfo createFromParcel(Parcel parcel) {
            return new RobotInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public RobotInfo[] newArray(int i3) {
            return new RobotInfo[i3];
        }
    }

    public RobotInfo() {
    }

    public long a() {
        return this.E;
    }

    public long b() {
        return this.f232149f;
    }

    public int c() {
        return this.D;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long e() {
        return this.f232150h;
    }

    public String f() {
        return this.f232152m;
    }

    public String g() {
        return this.C;
    }

    public String j() {
        return this.f232151i;
    }

    public long k() {
        return this.f232148e;
    }

    public long l() {
        return this.f232147d;
    }

    public void m(long j3) {
        this.E = j3;
    }

    public void n(long j3) {
        this.f232149f = j3;
    }

    public void o(int i3) {
        this.D = i3;
    }

    public void p(long j3) {
        this.f232150h = j3;
    }

    public void q(String str) {
        this.f232152m = str;
    }

    public void r(String str) {
        this.C = str;
    }

    public void s(String str) {
        this.f232151i = str;
    }

    public void t(long j3) {
        this.f232148e = j3;
    }

    public String toString() {
        return "RobotInfo{robotUin=" + this.f232147d + ", robotTid=" + this.f232148e + ", channelId=" + this.f232149f + ", guildId=" + this.f232150h + ", robotName='" + this.f232151i + "', robotAvatar='" + this.f232152m + "', robotDesc='" + this.C + "', featureScene='" + this.D + "', appid='" + this.E + "'}";
    }

    public void u(long j3) {
        this.f232147d = j3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f232147d);
        parcel.writeLong(this.f232148e);
        parcel.writeLong(this.f232149f);
        parcel.writeLong(this.f232150h);
        parcel.writeString(this.f232151i);
        parcel.writeString(this.f232152m);
        parcel.writeString(this.C);
        parcel.writeInt(this.D);
        parcel.writeLong(this.E);
    }

    protected RobotInfo(Parcel parcel) {
        this.f232147d = parcel.readLong();
        this.f232148e = parcel.readLong();
        this.f232149f = parcel.readLong();
        this.f232150h = parcel.readLong();
        this.f232151i = parcel.readString();
        this.f232152m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readInt();
        this.E = parcel.readLong();
    }
}
