package com.tencent.mobileqq.kandian.repo.video.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;

/* compiled from: P */
/* loaded from: classes15.dex */
public class VideoColumnInfo implements Parcelable {
    public static final Parcelable.Creator<VideoColumnInfo> CREATOR = new a();
    public boolean C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public UrlJumpInfo I;
    public UrlJumpInfo J;
    public UrlJumpInfo K;
    public UrlJumpInfo L;
    public int M;
    public String N;
    public String P;
    public int Q;
    public int R;

    /* renamed from: d, reason: collision with root package name */
    public int f240075d;

    /* renamed from: e, reason: collision with root package name */
    public String f240076e;

    /* renamed from: f, reason: collision with root package name */
    public String f240077f;

    /* renamed from: h, reason: collision with root package name */
    public long f240078h;

    /* renamed from: i, reason: collision with root package name */
    public int f240079i;

    /* renamed from: m, reason: collision with root package name */
    public int f240080m;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<VideoColumnInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoColumnInfo createFromParcel(Parcel parcel) {
            return new VideoColumnInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public VideoColumnInfo[] newArray(int i3) {
            return new VideoColumnInfo[i3];
        }
    }

    public VideoColumnInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "VideoColumnInfo{columnId=" + this.f240075d + ", columnName='" + this.f240076e + "', columnIconUrl=" + this.f240077f + "', lastUpdateTime=" + this.f240078h + "', videoCount=" + this.f240079i + "', subscribeCount='" + this.f240080m + "', isSubscribed='" + this.C + "', cardBgUrl=" + this.D + "', cardBgColor=" + this.E + "', cardIconUrl=" + this.F + "', appName=" + this.G + ", appIconUrl='" + this.H + "', defaultJumpInfo=" + this.I + ", videoJumpInfo=" + this.J + ", subscribeJumpInfo=" + this.K + ", appJumpInfo='" + this.L + "', cardBgStyle='" + this.M + "', fromText='" + this.N + "', columnNameColor='" + this.P + "', columnStyle='" + this.Q + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f240075d);
        parcel.writeString(this.f240076e);
        parcel.writeString(this.f240077f);
        parcel.writeLong(this.f240078h);
        parcel.writeInt(this.f240079i);
        parcel.writeInt(this.f240080m);
        parcel.writeByte(this.C ? (byte) 1 : (byte) 0);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeParcelable(this.I, i3);
        parcel.writeParcelable(this.J, i3);
        parcel.writeParcelable(this.K, i3);
        parcel.writeParcelable(this.L, i3);
        parcel.writeInt(this.M);
        parcel.writeString(this.N);
        parcel.writeString(this.P);
        parcel.writeInt(this.Q);
        parcel.writeInt(this.R);
    }

    protected VideoColumnInfo(Parcel parcel) {
        this.f240075d = parcel.readInt();
        this.f240076e = parcel.readString();
        this.f240077f = parcel.readString();
        this.f240078h = parcel.readLong();
        this.f240079i = parcel.readInt();
        this.f240080m = parcel.readInt();
        this.C = parcel.readByte() != 0;
        this.D = parcel.readString();
        this.E = parcel.readString();
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readString();
        this.I = (UrlJumpInfo) parcel.readParcelable(UrlJumpInfo.class.getClassLoader());
        this.J = (UrlJumpInfo) parcel.readParcelable(UrlJumpInfo.class.getClassLoader());
        this.K = (UrlJumpInfo) parcel.readParcelable(UrlJumpInfo.class.getClassLoader());
        this.L = (UrlJumpInfo) parcel.readParcelable(UrlJumpInfo.class.getClassLoader());
        this.M = parcel.readInt();
        this.N = parcel.readString();
        this.P = parcel.readString();
        this.Q = parcel.readInt();
        this.R = parcel.readInt();
    }
}
