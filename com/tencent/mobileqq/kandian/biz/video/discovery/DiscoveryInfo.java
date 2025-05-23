package com.tencent.mobileqq.kandian.biz.video.discovery;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DiscoveryInfo implements Parcelable {
    public static final Parcelable.Creator<DiscoveryInfo> CREATOR = new a();
    public boolean C;
    public int D;
    public int E;
    public String F;
    public ArrayList<TopicVideoCard> G;
    public int[] H;

    /* renamed from: d, reason: collision with root package name */
    public long f239619d;

    /* renamed from: e, reason: collision with root package name */
    public String f239620e;

    /* renamed from: f, reason: collision with root package name */
    public String f239621f;

    /* renamed from: h, reason: collision with root package name */
    public String f239622h;

    /* renamed from: i, reason: collision with root package name */
    public String f239623i;

    /* renamed from: m, reason: collision with root package name */
    public String f239624m;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class TopicVideoCard implements Parcelable {
        public static final Parcelable.Creator<TopicVideoCard> CREATOR = new a();
        public String C;
        public String D;
        public String E;
        public String F;
        public String G;
        public String H;
        public String I;
        public String J;
        public String K;
        public String L;
        public String M;
        public int N;
        public int P;
        public int Q;
        public int R;
        public int S;
        public long T;
        public long U;
        public long V;
        public boolean W;

        /* renamed from: d, reason: collision with root package name */
        public String f239625d;

        /* renamed from: e, reason: collision with root package name */
        public String f239626e;

        /* renamed from: f, reason: collision with root package name */
        public long f239627f;

        /* renamed from: h, reason: collision with root package name */
        public long f239628h;

        /* renamed from: i, reason: collision with root package name */
        public String f239629i;

        /* renamed from: m, reason: collision with root package name */
        public String f239630m;

        /* compiled from: P */
        /* loaded from: classes33.dex */
        class a implements Parcelable.Creator<TopicVideoCard> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TopicVideoCard createFromParcel(Parcel parcel) {
                return new TopicVideoCard(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public TopicVideoCard[] newArray(int i3) {
                return new TopicVideoCard[i3];
            }
        }

        public TopicVideoCard() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "TopicVideoCard{cornerIconUrl='" + this.f239625d + "', coverUrl='" + this.f239626e + "', articleId=" + this.f239627f + ", topicId=" + this.f239628h + ", vid='" + this.f239629i + "', rowKey='" + this.f239630m + "', accountName='" + this.C + "', accountUin='" + this.D + "', thirdAction='" + this.E + "', thirdIconUrl='" + this.F + "', thirdUinName='" + this.G + "', articleTitle='" + this.H + "', articleSummary='" + this.I + "', firstPagePicUrl='" + this.J + "', articleContentUrl='" + this.K + "', videoUrl='" + this.L + "', width=" + this.N + ", height=" + this.P + ", duration=" + this.Q + ", busiType=" + this.R + ", feedsType=" + this.S + ", feedsId=" + this.T + ", xgFileSize=" + this.U + ", time=" + this.V + ", isUgc=" + this.W + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f239625d);
            parcel.writeString(this.f239626e);
            parcel.writeLong(this.f239627f);
            parcel.writeLong(this.f239628h);
            parcel.writeString(this.f239629i);
            parcel.writeString(this.f239630m);
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
            parcel.writeInt(this.N);
            parcel.writeInt(this.P);
            parcel.writeInt(this.Q);
            parcel.writeInt(this.R);
            parcel.writeInt(this.S);
            parcel.writeLong(this.T);
            parcel.writeLong(this.U);
            parcel.writeLong(this.V);
            parcel.writeByte(this.W ? (byte) 1 : (byte) 0);
        }

        protected TopicVideoCard(Parcel parcel) {
            this.f239625d = parcel.readString();
            this.f239626e = parcel.readString();
            this.f239627f = parcel.readLong();
            this.f239628h = parcel.readLong();
            this.f239629i = parcel.readString();
            this.f239630m = parcel.readString();
            this.C = parcel.readString();
            this.D = parcel.readString();
            this.E = parcel.readString();
            this.F = parcel.readString();
            this.G = parcel.readString();
            this.H = parcel.readString();
            this.I = parcel.readString();
            this.J = parcel.readString();
            this.K = parcel.readString();
            this.L = parcel.readString();
            this.M = parcel.readString();
            this.N = parcel.readInt();
            this.P = parcel.readInt();
            this.Q = parcel.readInt();
            this.R = parcel.readInt();
            this.S = parcel.readInt();
            this.T = parcel.readLong();
            this.U = parcel.readLong();
            this.V = parcel.readLong();
            this.W = parcel.readByte() != 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements Parcelable.Creator<DiscoveryInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DiscoveryInfo createFromParcel(Parcel parcel) {
            return new DiscoveryInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DiscoveryInfo[] newArray(int i3) {
            return new DiscoveryInfo[i3];
        }
    }

    public DiscoveryInfo() {
        this.H = new int[2];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "DiscoveryInfo{topicId=" + this.f239619d + ", title='" + this.f239620e + "', coverUrl='" + this.f239621f + "', subtitle='" + this.f239622h + "', playCounts=" + this.f239623i + ", jumpUrl='" + this.f239624m + "', hasRecomment=" + this.C + ", effectiveTime=" + this.D + ", expiationTime=" + this.E + ", commonData=" + this.F + ", topicVideoCards=" + this.G + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f239619d);
        parcel.writeString(this.f239620e);
        parcel.writeString(this.f239621f);
        parcel.writeString(this.f239622h);
        parcel.writeString(this.f239623i);
        parcel.writeString(this.f239624m);
        parcel.writeInt(this.C ? 1 : 2);
        parcel.writeInt(this.D);
        parcel.writeInt(this.E);
        parcel.writeTypedList(this.G);
        parcel.writeString(this.F);
    }

    protected DiscoveryInfo(Parcel parcel) {
        this.H = new int[2];
        this.f239619d = parcel.readLong();
        this.f239620e = parcel.readString();
        this.f239621f = parcel.readString();
        this.f239622h = parcel.readString();
        this.f239623i = parcel.readString();
        this.f239624m = parcel.readString();
        this.C = parcel.readInt() == 1;
        this.D = parcel.readInt();
        this.E = parcel.readInt();
        this.G = parcel.createTypedArrayList(TopicVideoCard.CREATOR);
        this.F = parcel.readString();
    }
}
