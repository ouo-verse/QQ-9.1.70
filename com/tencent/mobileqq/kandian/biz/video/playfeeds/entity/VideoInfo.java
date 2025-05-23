package com.tencent.mobileqq.kandian.biz.video.playfeeds.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.kandian.base.annotation.IgnoreDenyDependencyToSelf;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.VideoColumnInfo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/* compiled from: P */
@IgnoreDenyDependencyToSelf(reason = "\u6682\u4e0d\u5904\u7406\u5916\u90e8\u4f9d\u8d56\u4e8e\u6b64\u7c7b\u7684\u4f9d\u8d56\uff0c\u5e7f\u544a\u8026\u5408\u8f83\u4e25\u91cd\uff0c\u4e14native\u4e00\u62d6\u4e09\u8fd1\u671f\u4e0b\u67b6")
/* loaded from: classes15.dex */
public class VideoInfo implements Parcelable {
    public static final Parcelable.Creator<VideoInfo> CREATOR = new a();
    public int A0;
    public boolean B0;
    public String C;
    public boolean C0;
    public String D;
    public long D0;
    public String E;
    public int E0;
    public long F;
    public int F0;
    public String G;
    public int G0;
    public String H;
    public boolean H0;
    public String I;
    public boolean I0;
    public long J;
    public int J0;
    public String K;
    public long K0;
    public int L;
    public String L0;
    public String M;
    public String M0;
    public String N;
    public boolean N0;
    public int O0;
    public boolean P;
    public int P0;
    public boolean Q;
    public int Q0;
    public long R;
    public VideoColumnInfo R0;
    public String S;
    public TopBarInfo S0;
    public int T;
    public InterruptedWeishiAd T0;
    public int U;
    public DownloadBarInfo U0;
    public String V;
    public ECommerceEntranceInfo V0;
    public String W;
    public ArrayList<VideoInfo> W0;
    public String X;
    public LikeActionDownloadBar X0;
    public String Y;
    public SoftAdDownloadBarInfo Y0;
    public String Z;
    public SubscriptInfo Z0;

    /* renamed from: a0, reason: collision with root package name */
    public String f239657a0;

    /* renamed from: a1, reason: collision with root package name */
    public LocationInfo f239658a1;

    /* renamed from: b0, reason: collision with root package name */
    public long f239659b0;

    /* renamed from: b1, reason: collision with root package name */
    public StressState f239660b1;

    /* renamed from: c0, reason: collision with root package name */
    public int f239661c0;

    /* renamed from: c1, reason: collision with root package name */
    public MessageForShortVideo f239662c1;

    /* renamed from: d, reason: collision with root package name */
    public int f239663d;

    /* renamed from: d0, reason: collision with root package name */
    public ArrayList<String> f239664d0;

    /* renamed from: d1, reason: collision with root package name */
    protected boolean f239665d1;

    /* renamed from: e, reason: collision with root package name */
    public String f239666e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f239667e0;

    /* renamed from: e1, reason: collision with root package name */
    public String f239668e1;

    /* renamed from: f, reason: collision with root package name */
    public int f239669f;

    /* renamed from: f0, reason: collision with root package name */
    public HashSet<String> f239670f0;

    /* renamed from: g0, reason: collision with root package name */
    public boolean f239671g0;

    /* renamed from: h, reason: collision with root package name */
    public int f239672h;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f239673h0;

    /* renamed from: i, reason: collision with root package name */
    public int f239674i;

    /* renamed from: i0, reason: collision with root package name */
    public int f239675i0;

    /* renamed from: j0, reason: collision with root package name */
    public int f239676j0;

    /* renamed from: k0, reason: collision with root package name */
    public long f239677k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f239678l0;

    /* renamed from: m, reason: collision with root package name */
    public String f239679m;

    /* renamed from: m0, reason: collision with root package name */
    public boolean f239680m0;

    /* renamed from: n0, reason: collision with root package name */
    public String f239681n0;

    /* renamed from: o0, reason: collision with root package name */
    public boolean f239682o0;

    /* renamed from: p0, reason: collision with root package name */
    public int f239683p0;

    /* renamed from: q0, reason: collision with root package name */
    public boolean f239684q0;

    /* renamed from: r0, reason: collision with root package name */
    public int f239685r0;

    /* renamed from: s0, reason: collision with root package name */
    public boolean f239686s0;

    /* renamed from: t0, reason: collision with root package name */
    public String f239687t0;

    /* renamed from: u0, reason: collision with root package name */
    public int f239688u0;

    /* renamed from: v0, reason: collision with root package name */
    public boolean f239689v0;

    /* renamed from: w0, reason: collision with root package name */
    public boolean f239690w0;

    /* renamed from: x0, reason: collision with root package name */
    public String f239691x0;

    /* renamed from: y0, reason: collision with root package name */
    public boolean f239692y0;

    /* renamed from: z0, reason: collision with root package name */
    public boolean f239693z0;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class DownloadBarInfo implements Parcelable {
        public static final Parcelable.Creator<DownloadBarInfo> CREATOR = new a();
        public String C;

        /* renamed from: d, reason: collision with root package name */
        public int f239706d;

        /* renamed from: e, reason: collision with root package name */
        public String f239707e;

        /* renamed from: f, reason: collision with root package name */
        public String f239708f;

        /* renamed from: h, reason: collision with root package name */
        public String f239709h;

        /* renamed from: i, reason: collision with root package name */
        public int f239710i;

        /* renamed from: m, reason: collision with root package name */
        public UrlJumpInfo f239711m;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements Parcelable.Creator<DownloadBarInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public DownloadBarInfo createFromParcel(Parcel parcel) {
                return new DownloadBarInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public DownloadBarInfo[] newArray(int i3) {
                return new DownloadBarInfo[i3];
            }
        }

        public DownloadBarInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "DownloadBarInfo{appearTime=" + this.f239706d + ", logoUrl='" + this.f239707e + "', downloadBtnText='" + this.f239708f + "', openBtnText='" + this.f239709h + "', buttonBgColor=" + this.f239710i + ", jumpInfo=" + this.f239711m + ", commonData='" + this.C + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f239706d);
            parcel.writeString(this.f239707e);
            parcel.writeString(this.f239708f);
            parcel.writeString(this.f239709h);
            parcel.writeInt(this.f239710i);
            parcel.writeParcelable(this.f239711m, i3);
            parcel.writeString(this.C);
        }

        protected DownloadBarInfo(Parcel parcel) {
            this.f239706d = parcel.readInt();
            this.f239707e = parcel.readString();
            this.f239708f = parcel.readString();
            this.f239709h = parcel.readString();
            this.f239710i = parcel.readInt();
            this.f239711m = (UrlJumpInfo) parcel.readParcelable(UrlJumpInfo.class.getClassLoader());
            this.C = parcel.readString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class LikeActionDownloadBar implements Parcelable {
        public static final Parcelable.Creator<LikeActionDownloadBar> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public String f239726d;

        /* renamed from: e, reason: collision with root package name */
        public String f239727e;

        /* renamed from: f, reason: collision with root package name */
        public UrlJumpInfo f239728f;

        /* renamed from: h, reason: collision with root package name */
        public String f239729h;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements Parcelable.Creator<LikeActionDownloadBar> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LikeActionDownloadBar createFromParcel(Parcel parcel) {
                return new LikeActionDownloadBar(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public LikeActionDownloadBar[] newArray(int i3) {
                return new LikeActionDownloadBar[i3];
            }
        }

        public LikeActionDownloadBar() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "LikeActionDownloadBar{logoUrl=" + this.f239726d + ", downloadBarText='" + this.f239727e + "', jumpInfo=" + this.f239728f + ", commonData='" + this.f239729h + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f239726d);
            parcel.writeString(this.f239727e);
            parcel.writeParcelable(this.f239728f, i3);
            parcel.writeString(this.f239729h);
        }

        protected LikeActionDownloadBar(Parcel parcel) {
            this.f239726d = parcel.readString();
            this.f239727e = parcel.readString();
            this.f239728f = (UrlJumpInfo) parcel.readParcelable(UrlJumpInfo.class.getClassLoader());
            this.f239729h = parcel.readString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class LocationInfo implements Parcelable {
        public static final Parcelable.Creator<LocationInfo> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public boolean f239730d;

        /* renamed from: e, reason: collision with root package name */
        public String f239731e;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements Parcelable.Creator<LocationInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public LocationInfo createFromParcel(Parcel parcel) {
                return new LocationInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public LocationInfo[] newArray(int i3) {
                return new LocationInfo[i3];
            }
        }

        public LocationInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "LocationInfo{location=" + this.f239731e + ", isCreatedByUser=" + this.f239730d + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeByte(this.f239730d ? (byte) 1 : (byte) 0);
            parcel.writeString(this.f239731e);
        }

        protected LocationInfo(Parcel parcel) {
            this.f239730d = parcel.readByte() != 0;
            this.f239731e = parcel.readString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class SoftAdDownloadBarInfo implements Parcelable {
        public static final Parcelable.Creator<DownloadBarInfo> CREATOR = new a();
        public String C;
        public int D;

        /* renamed from: d, reason: collision with root package name */
        public String f239732d;

        /* renamed from: e, reason: collision with root package name */
        public String f239733e;

        /* renamed from: f, reason: collision with root package name */
        public String f239734f;

        /* renamed from: h, reason: collision with root package name */
        public String f239735h;

        /* renamed from: i, reason: collision with root package name */
        public int f239736i;

        /* renamed from: m, reason: collision with root package name */
        public UrlJumpInfo f239737m;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements Parcelable.Creator<DownloadBarInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public DownloadBarInfo createFromParcel(Parcel parcel) {
                return new DownloadBarInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public DownloadBarInfo[] newArray(int i3) {
                return new DownloadBarInfo[i3];
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "SoftAdDownloadBarInfo{title=" + this.f239732d + ", subTitle='" + this.f239733e + "', smallIconUrl='" + this.f239734f + "', bigIconUrl='" + this.f239735h + "', changeBiggerPositionPercent='" + this.f239736i + "', urlJumpInfo=" + this.f239737m + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f239732d);
            parcel.writeString(this.f239733e);
            parcel.writeString(this.f239734f);
            parcel.writeString(this.f239735h);
            parcel.writeInt(this.f239736i);
            parcel.writeParcelable(this.f239737m, i3);
            parcel.writeString(this.C);
            parcel.writeInt(this.D);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class SubscriptInfo implements Parcelable {
        public static final Parcelable.Creator<SubscriptInfo> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public String f239738d;

        /* renamed from: e, reason: collision with root package name */
        public int f239739e;

        /* renamed from: f, reason: collision with root package name */
        public int f239740f;

        /* renamed from: h, reason: collision with root package name */
        public int f239741h;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements Parcelable.Creator<SubscriptInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public SubscriptInfo createFromParcel(Parcel parcel) {
                return new SubscriptInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public SubscriptInfo[] newArray(int i3) {
                return new SubscriptInfo[i3];
            }
        }

        public SubscriptInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "SubscriptInfo{subscriptText='" + this.f239738d + "', subscriptColor=" + this.f239739e + ", backgroundColor=" + this.f239740f + ", subscriptType=" + this.f239741h + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f239738d);
            parcel.writeInt(this.f239739e);
            parcel.writeInt(this.f239740f);
            parcel.writeInt(this.f239741h);
        }

        protected SubscriptInfo(Parcel parcel) {
            this.f239738d = parcel.readString();
            this.f239739e = parcel.readInt();
            this.f239740f = parcel.readInt();
            this.f239741h = parcel.readInt();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class TopBarInfo implements Parcelable {
        public static final Parcelable.Creator<TopBarInfo> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public int f239742d;

        /* renamed from: e, reason: collision with root package name */
        public String f239743e;

        /* renamed from: f, reason: collision with root package name */
        public String f239744f;

        /* renamed from: h, reason: collision with root package name */
        public String f239745h;

        /* renamed from: i, reason: collision with root package name */
        public UrlJumpInfo f239746i;

        /* renamed from: m, reason: collision with root package name */
        public String f239747m;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements Parcelable.Creator<TopBarInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public TopBarInfo createFromParcel(Parcel parcel) {
                return new TopBarInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public TopBarInfo[] newArray(int i3) {
                return new TopBarInfo[i3];
            }
        }

        public TopBarInfo() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "TopBarInfo{logoId=" + this.f239742d + ", iconUrl='" + this.f239743e + "', title='" + this.f239744f + "', backgroundUrl='" + this.f239745h + "', jumpInfo=" + this.f239746i + ", commonData='" + this.f239747m + "'}";
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeInt(this.f239742d);
            parcel.writeString(this.f239743e);
            parcel.writeString(this.f239744f);
            parcel.writeString(this.f239745h);
            parcel.writeParcelable(this.f239746i, i3);
            parcel.writeString(this.f239747m);
        }

        protected TopBarInfo(Parcel parcel) {
            this.f239742d = parcel.readInt();
            this.f239743e = parcel.readString();
            this.f239744f = parcel.readString();
            this.f239745h = parcel.readString();
            this.f239746i = (UrlJumpInfo) parcel.readParcelable(UrlJumpInfo.class.getClassLoader());
            this.f239747m = parcel.readString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<VideoInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoInfo createFromParcel(Parcel parcel) {
            return new VideoInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public VideoInfo[] newArray(int i3) {
            return new VideoInfo[i3];
        }
    }

    public VideoInfo() {
        this.f239664d0 = new ArrayList<>();
        this.f239667e0 = false;
        this.f239670f0 = new HashSet<>();
        this.f239671g0 = false;
        this.f239673h0 = false;
        this.f239675i0 = 0;
        this.f239676j0 = 0;
        this.f239678l0 = 0;
        this.f239682o0 = true;
        this.f239684q0 = true;
        this.f239686s0 = false;
        this.f239690w0 = false;
        this.f239692y0 = false;
        this.A0 = 0;
        this.B0 = false;
        this.C0 = false;
        this.F0 = 0;
        this.G0 = 0;
        this.H0 = false;
        this.I0 = false;
        this.K0 = 0L;
        this.N0 = false;
        this.O0 = 1;
        this.f239660b1 = StressState.Shrink;
        this.f239665d1 = true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "VideoInfo{vid='" + this.f239666e + "', coverUrl='" + this.f239679m + "', title='" + this.C + "', articleID='" + this.H + "', videoUrl='" + this.f239657a0 + "', recommendSeq=" + this.f239677k0 + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f239663d);
        parcel.writeParcelable(this.f239662c1, i3);
        parcel.writeString(this.f239666e);
        parcel.writeInt(this.f239669f);
        parcel.writeInt(this.f239672h);
        parcel.writeInt(this.f239674i);
        parcel.writeString(this.f239679m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        parcel.writeLong(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeString(this.I);
        parcel.writeLong(this.J);
        parcel.writeString(this.K);
        parcel.writeInt(this.L);
        parcel.writeString(this.M);
        parcel.writeString(this.N);
        parcel.writeByte(this.P ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.Q ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.R);
        parcel.writeString(this.S);
        parcel.writeInt(this.T);
        parcel.writeString(this.X);
        parcel.writeString(this.Y);
        parcel.writeString(this.Z);
        parcel.writeString(this.f239657a0);
        parcel.writeLong(this.f239659b0);
        parcel.writeInt(this.f239661c0);
        parcel.writeByte(this.N0 ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.O0);
        parcel.writeStringList(this.f239664d0);
        parcel.writeByte(this.f239667e0 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f239671g0 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f239673h0 ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f239675i0);
        parcel.writeInt(this.f239676j0);
        parcel.writeParcelable(this.S0, i3);
        parcel.writeParcelable(this.T0, i3);
        parcel.writeParcelable(this.U0, i3);
        parcel.writeParcelable(this.V0, i3);
        parcel.writeByte(this.f239665d1 ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f239678l0);
        parcel.writeLong(this.D0);
        parcel.writeInt(this.E0);
        parcel.writeInt(this.F0);
        parcel.writeInt(this.G0);
        parcel.writeByte(this.H0 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.I0 ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.J0);
        parcel.writeString(this.L0);
        parcel.writeString(this.f239660b1.name());
        parcel.writeString(this.M0);
        parcel.writeLong(this.f239677k0);
        parcel.writeByte(this.f239680m0 ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f239681n0);
        parcel.writeByte((byte) (!this.f239682o0 ? 1 : 0));
        parcel.writeTypedList(this.W0);
        parcel.writeInt(this.f239683p0);
        parcel.writeInt(this.f239685r0);
        parcel.writeString(this.f239687t0);
        parcel.writeInt(this.f239688u0);
        parcel.writeInt(this.f239689v0 ? 1 : 0);
        parcel.writeParcelable(this.X0, i3);
        parcel.writeParcelable(this.R0, i3);
        parcel.writeParcelable(this.Y0, i3);
        parcel.writeString(this.V);
        parcel.writeString(this.W);
        parcel.writeInt(this.f239690w0 ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f239691x0);
        parcel.writeInt(this.U);
        parcel.writeByte(this.f239692y0 ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f239693z0 ? (byte) 1 : (byte) 0);
        parcel.writeParcelable(this.Z0, i3);
        parcel.writeParcelable(this.f239658a1, i3);
        parcel.writeInt(this.P0);
        parcel.writeInt(this.Q0);
        parcel.writeString(this.f239668e1);
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class ECommerceEntranceInfo implements Parcelable {
        public static final Parcelable.Creator<ECommerceEntranceInfo> CREATOR = new a();
        public int[] C;
        public int D;
        public int E;
        public String F;
        public int G;
        public int H;
        public int I;
        public int J;
        public int K;
        public UrlJumpInfo L;
        public String M;
        public String N;

        /* renamed from: d, reason: collision with root package name */
        public String f239712d;

        /* renamed from: e, reason: collision with root package name */
        public String f239713e;

        /* renamed from: f, reason: collision with root package name */
        public String f239714f;

        /* renamed from: h, reason: collision with root package name */
        public String f239715h;

        /* renamed from: i, reason: collision with root package name */
        public int f239716i;

        /* renamed from: m, reason: collision with root package name */
        public String f239717m;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements Parcelable.Creator<ECommerceEntranceInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ECommerceEntranceInfo createFromParcel(Parcel parcel) {
                return new ECommerceEntranceInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ECommerceEntranceInfo[] newArray(int i3) {
                return new ECommerceEntranceInfo[i3];
            }
        }

        public ECommerceEntranceInfo() {
            this.D = -1;
            this.E = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            String urlJumpInfo;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("commerceEntranceInfo{title='");
            sb5.append(this.f239712d);
            sb5.append('\'');
            sb5.append(", subTitle='");
            sb5.append(this.f239713e);
            sb5.append('\'');
            sb5.append(", thumbnailUrl='");
            sb5.append(this.f239714f);
            sb5.append('\'');
            sb5.append(", linkIconUrl='");
            sb5.append(this.f239715h);
            sb5.append('\'');
            sb5.append(", jumpType=");
            sb5.append(this.f239716i);
            sb5.append(", jumpUrl='");
            sb5.append(this.f239717m);
            sb5.append('\'');
            sb5.append(", showPosition=");
            sb5.append(Arrays.toString(this.C));
            sb5.append(", showPercent=");
            sb5.append(this.E);
            sb5.append(", playTime=");
            sb5.append(this.D);
            sb5.append(", commonData=");
            sb5.append(this.F);
            sb5.append(", displayCountsVersion=");
            sb5.append(this.G);
            sb5.append(", sessionDisplayCounts=");
            sb5.append(this.H);
            sb5.append(", oneDayMaxDisplayCounts=");
            sb5.append(this.I);
            sb5.append(", videoSource=");
            sb5.append(this.J);
            sb5.append(", style=");
            sb5.append(this.K);
            sb5.append(", appInfo=");
            UrlJumpInfo urlJumpInfo2 = this.L;
            if (urlJumpInfo2 == null) {
                urlJumpInfo = "null";
            } else {
                urlJumpInfo = urlJumpInfo2.toString();
            }
            sb5.append(urlJumpInfo);
            sb5.append(", downloadBtnText=");
            sb5.append(this.M);
            sb5.append(", openBtnText=");
            sb5.append(this.N);
            sb5.append('}');
            return sb5.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f239712d);
            parcel.writeString(this.f239713e);
            parcel.writeString(this.f239714f);
            parcel.writeString(this.f239715h);
            parcel.writeInt(this.f239716i);
            parcel.writeString(this.f239717m);
            parcel.writeIntArray(this.C);
            parcel.writeInt(this.E);
            parcel.writeInt(this.D);
            parcel.writeString(this.F);
            parcel.writeInt(this.G);
            parcel.writeInt(this.H);
            parcel.writeInt(this.I);
            parcel.writeInt(this.J);
            parcel.writeInt(this.K);
            parcel.writeParcelable(this.L, i3);
            parcel.writeString(this.M);
            parcel.writeString(this.N);
        }

        protected ECommerceEntranceInfo(Parcel parcel) {
            this.D = -1;
            this.E = -1;
            this.f239712d = parcel.readString();
            this.f239713e = parcel.readString();
            this.f239714f = parcel.readString();
            this.f239715h = parcel.readString();
            this.f239716i = parcel.readInt();
            this.f239717m = parcel.readString();
            this.C = parcel.createIntArray();
            this.E = parcel.readInt();
            this.D = parcel.readInt();
            this.F = parcel.readString();
            this.G = parcel.readInt();
            this.H = parcel.readInt();
            this.I = parcel.readInt();
            this.J = parcel.readInt();
            this.K = parcel.readInt();
            this.L = (UrlJumpInfo) parcel.readParcelable(UrlJumpInfo.class.getClassLoader());
            this.M = parcel.readString();
            this.N = parcel.readString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class KdTagItem implements Parcelable {
        public static final Parcelable.Creator<KdTagItem> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public String f239724d;

        /* renamed from: e, reason: collision with root package name */
        public long f239725e;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements Parcelable.Creator<KdTagItem> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public KdTagItem createFromParcel(Parcel parcel) {
                return new KdTagItem(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public KdTagItem[] newArray(int i3) {
                return new KdTagItem[i3];
            }
        }

        public KdTagItem() {
            this.f239724d = "";
            this.f239725e = 0L;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f239724d);
            parcel.writeLong(this.f239725e);
        }

        protected KdTagItem(Parcel parcel) {
            this.f239724d = "";
            this.f239725e = 0L;
            this.f239724d = parcel.readString();
            this.f239725e = parcel.readLong();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class AdTagInfo implements Parcelable {
        public static final Parcelable.Creator<AdTagInfo> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public String f239694d;

        /* renamed from: e, reason: collision with root package name */
        public ArrayList<KdTagItem> f239695e;

        /* renamed from: f, reason: collision with root package name */
        public int f239696f;

        /* renamed from: h, reason: collision with root package name */
        public int f239697h;

        /* renamed from: i, reason: collision with root package name */
        public ClassInfo f239698i;

        /* renamed from: m, reason: collision with root package name */
        public String f239699m;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements Parcelable.Creator<AdTagInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public AdTagInfo createFromParcel(Parcel parcel) {
                return new AdTagInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public AdTagInfo[] newArray(int i3) {
                return new AdTagInfo[i3];
            }
        }

        public AdTagInfo() {
            this.f239694d = "";
            this.f239696f = 0;
            this.f239699m = "";
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeString(this.f239694d);
            parcel.writeTypedList(this.f239695e);
            parcel.writeInt(this.f239696f);
            parcel.writeInt(this.f239697h);
            parcel.writeParcelable(this.f239698i, i3);
            parcel.writeString(this.f239699m);
        }

        protected AdTagInfo(Parcel parcel) {
            this.f239694d = "";
            this.f239696f = 0;
            this.f239699m = "";
            this.f239694d = parcel.readString();
            this.f239695e = parcel.createTypedArrayList(KdTagItem.CREATOR);
            this.f239696f = parcel.readInt();
            this.f239697h = parcel.readInt();
            this.f239698i = (ClassInfo) parcel.readParcelable(ClassInfo.class.getClassLoader());
            this.f239699m = parcel.readString();
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class InterruptedWeishiAd implements Parcelable {
        public static final Parcelable.Creator<InterruptedWeishiAd> CREATOR = new a();
        public String C;
        public String D;
        public UrlJumpInfo E;

        /* renamed from: d, reason: collision with root package name */
        public int[] f239718d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f239719e;

        /* renamed from: f, reason: collision with root package name */
        public boolean f239720f;

        /* renamed from: h, reason: collision with root package name */
        public int f239721h;

        /* renamed from: i, reason: collision with root package name */
        public String f239722i;

        /* renamed from: m, reason: collision with root package name */
        public int f239723m;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements Parcelable.Creator<InterruptedWeishiAd> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public InterruptedWeishiAd createFromParcel(Parcel parcel) {
                return new InterruptedWeishiAd(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public InterruptedWeishiAd[] newArray(int i3) {
                return new InterruptedWeishiAd[i3];
            }
        }

        public InterruptedWeishiAd() {
            this.f239719e = false;
            this.f239720f = false;
            this.f239721h = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            String str;
            String urlJumpInfo;
            if (this.f239723m == 0) {
                str = "\u5f39\u51fa\u5f0fweb\u9875\u9762";
            } else {
                str = null;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("InterruptedWeishiAd{showPositon=");
            sb5.append(Arrays.toString(this.f239718d));
            sb5.append(", isShowInSwitch=");
            sb5.append(this.f239719e);
            sb5.append(", isShowInPlayEnd=");
            sb5.append(this.f239720f);
            sb5.append(", showAfterPlayTime=");
            sb5.append(this.f239721h);
            sb5.append(", adUrl='");
            sb5.append(this.f239722i);
            sb5.append('\'');
            sb5.append(", type=");
            sb5.append(str);
            sb5.append(", downloadBtnText=");
            sb5.append(this.C);
            sb5.append(", openBtnText=");
            sb5.append(this.D);
            sb5.append(", appInfo=");
            UrlJumpInfo urlJumpInfo2 = this.E;
            if (urlJumpInfo2 == null) {
                urlJumpInfo = "null";
            } else {
                urlJumpInfo = urlJumpInfo2.toString();
            }
            sb5.append(urlJumpInfo);
            sb5.append('}');
            return sb5.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeIntArray(this.f239718d);
            parcel.writeByte(this.f239719e ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f239720f ? (byte) 1 : (byte) 0);
            parcel.writeInt(this.f239721h);
            parcel.writeString(this.f239722i);
            parcel.writeInt(this.f239723m);
            parcel.writeString(this.C);
            parcel.writeString(this.D);
            parcel.writeParcelable(this.E, i3);
        }

        protected InterruptedWeishiAd(Parcel parcel) {
            this.f239719e = false;
            this.f239720f = false;
            this.f239721h = -1;
            this.f239718d = parcel.createIntArray();
            this.f239719e = parcel.readByte() != 0;
            this.f239720f = parcel.readByte() != 0;
            this.f239721h = parcel.readInt();
            this.f239722i = parcel.readString();
            this.f239723m = parcel.readInt();
            this.C = parcel.readString();
            this.D = parcel.readString();
            this.E = (UrlJumpInfo) parcel.readParcelable(UrlJumpInfo.class.getClassLoader());
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public static class ClassInfo implements Parcelable {
        public static final Parcelable.Creator<ClassInfo> CREATOR = new a();

        /* renamed from: d, reason: collision with root package name */
        public long f239700d;

        /* renamed from: e, reason: collision with root package name */
        public String f239701e;

        /* renamed from: f, reason: collision with root package name */
        public long f239702f;

        /* renamed from: h, reason: collision with root package name */
        public String f239703h;

        /* renamed from: i, reason: collision with root package name */
        public long f239704i;

        /* renamed from: m, reason: collision with root package name */
        public String f239705m;

        /* compiled from: P */
        /* loaded from: classes15.dex */
        class a implements Parcelable.Creator<ClassInfo> {
            a() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public ClassInfo createFromParcel(Parcel parcel) {
                return new ClassInfo(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public ClassInfo[] newArray(int i3) {
                return new ClassInfo[i3];
            }
        }

        public ClassInfo() {
            this.f239700d = 0L;
            this.f239701e = "";
            this.f239702f = 0L;
            this.f239703h = "";
            this.f239704i = 0L;
            this.f239705m = "";
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            parcel.writeLong(this.f239700d);
            parcel.writeString(this.f239701e);
            parcel.writeLong(this.f239702f);
            parcel.writeString(this.f239703h);
            parcel.writeLong(this.f239704i);
            parcel.writeString(this.f239705m);
        }

        protected ClassInfo(Parcel parcel) {
            this.f239700d = 0L;
            this.f239701e = "";
            this.f239702f = 0L;
            this.f239703h = "";
            this.f239704i = 0L;
            this.f239705m = "";
            this.f239700d = parcel.readLong();
            this.f239701e = parcel.readString();
            this.f239702f = parcel.readLong();
            this.f239703h = parcel.readString();
            this.f239704i = parcel.readLong();
            this.f239705m = parcel.readString();
        }
    }

    public VideoInfo(Parcel parcel) {
        this.f239664d0 = new ArrayList<>();
        this.f239667e0 = false;
        this.f239670f0 = new HashSet<>();
        this.f239671g0 = false;
        this.f239673h0 = false;
        this.f239675i0 = 0;
        this.f239676j0 = 0;
        this.f239678l0 = 0;
        this.f239682o0 = true;
        this.f239684q0 = true;
        this.f239686s0 = false;
        this.f239690w0 = false;
        this.f239692y0 = false;
        this.A0 = 0;
        this.B0 = false;
        this.C0 = false;
        this.F0 = 0;
        this.G0 = 0;
        this.H0 = false;
        this.I0 = false;
        this.K0 = 0L;
        this.N0 = false;
        this.O0 = 1;
        this.f239660b1 = StressState.Shrink;
        this.f239665d1 = true;
        this.f239663d = parcel.readInt();
        this.f239662c1 = (MessageForShortVideo) parcel.readParcelable(MessageForShortVideo.class.getClassLoader());
        this.f239666e = parcel.readString();
        this.f239669f = parcel.readInt();
        this.f239672h = parcel.readInt();
        this.f239674i = parcel.readInt();
        this.f239679m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readString();
        this.F = parcel.readLong();
        this.G = parcel.readString();
        this.H = parcel.readString();
        this.I = parcel.readString();
        this.J = parcel.readLong();
        this.K = parcel.readString();
        this.L = parcel.readInt();
        this.M = parcel.readString();
        this.N = parcel.readString();
        this.P = parcel.readByte() != 0;
        this.Q = parcel.readByte() != 0;
        this.R = parcel.readLong();
        this.S = parcel.readString();
        this.T = parcel.readInt();
        this.X = parcel.readString();
        this.Y = parcel.readString();
        this.Z = parcel.readString();
        this.f239657a0 = parcel.readString();
        this.f239659b0 = parcel.readLong();
        this.f239661c0 = parcel.readInt();
        this.N0 = parcel.readByte() != 0;
        this.O0 = parcel.readInt();
        this.f239664d0 = parcel.createStringArrayList();
        this.f239667e0 = parcel.readByte() != 0;
        this.f239671g0 = parcel.readByte() != 0;
        this.f239673h0 = parcel.readByte() != 0;
        this.f239675i0 = parcel.readInt();
        this.f239676j0 = parcel.readInt();
        this.S0 = (TopBarInfo) parcel.readParcelable(TopBarInfo.class.getClassLoader());
        this.T0 = (InterruptedWeishiAd) parcel.readParcelable(InterruptedWeishiAd.class.getClassLoader());
        this.U0 = (DownloadBarInfo) parcel.readParcelable(DownloadBarInfo.class.getClassLoader());
        this.V0 = (ECommerceEntranceInfo) parcel.readParcelable(ECommerceEntranceInfo.class.getClassLoader());
        this.f239665d1 = parcel.readByte() != 0;
        this.f239678l0 = parcel.readInt();
        this.D0 = parcel.readLong();
        this.E0 = parcel.readInt();
        this.F0 = parcel.readInt();
        this.G0 = parcel.readInt();
        this.H0 = parcel.readByte() != 0;
        this.I0 = parcel.readByte() != 0;
        this.J0 = parcel.readInt();
        this.L0 = parcel.readString();
        this.f239660b1 = StressState.valueOf(parcel.readString());
        this.M0 = parcel.readString();
        this.f239677k0 = parcel.readLong();
        this.f239680m0 = parcel.readByte() != 0;
        this.f239681n0 = parcel.readString();
        this.f239682o0 = parcel.readByte() == 0;
        this.W0 = parcel.createTypedArrayList(CREATOR);
        this.f239683p0 = parcel.readInt();
        this.f239685r0 = parcel.readInt();
        this.f239687t0 = parcel.readString();
        this.f239688u0 = parcel.readInt();
        this.f239689v0 = parcel.readInt() == 1;
        this.X0 = (LikeActionDownloadBar) parcel.readParcelable(LikeActionDownloadBar.class.getClassLoader());
        this.R0 = (VideoColumnInfo) parcel.readParcelable(VideoColumnInfo.class.getClassLoader());
        this.Y0 = (SoftAdDownloadBarInfo) parcel.readParcelable(SoftAdDownloadBarInfo.class.getClassLoader());
        this.V = parcel.readString();
        this.W = parcel.readString();
        this.f239690w0 = parcel.readInt() != 0;
        this.f239691x0 = parcel.readString();
        this.U = parcel.readInt();
        this.f239692y0 = parcel.readByte() != 0;
        this.f239693z0 = parcel.readByte() != 0;
        this.Z0 = (SubscriptInfo) parcel.readParcelable(SubscriptInfo.class.getClassLoader());
        this.f239658a1 = (LocationInfo) parcel.readParcelable(LocationInfo.class.getClassLoader());
        this.P0 = parcel.readInt();
        this.Q0 = parcel.readInt();
        this.f239668e1 = parcel.readString();
    }
}
