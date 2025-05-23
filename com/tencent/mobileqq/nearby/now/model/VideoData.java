package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class VideoData implements Parcelable {
    public int C;
    public long D;
    public long E;
    public long F;
    public int G;
    public String H;
    public boolean I;
    public boolean J;
    public int K;
    public int L;
    public int M;
    public String N;
    public String P;
    public long Q;
    public long R;
    public int S;
    public String T;
    public long U;
    public long V;
    public String W;
    public String X;
    public long Y;
    public long Z;

    /* renamed from: a0, reason: collision with root package name */
    public int f252690a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f252691b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f252692c0;

    /* renamed from: d, reason: collision with root package name */
    public int f252693d;

    /* renamed from: d0, reason: collision with root package name */
    public int f252694d0;

    /* renamed from: e, reason: collision with root package name */
    public String f252695e;

    /* renamed from: e0, reason: collision with root package name */
    public int f252696e0;

    /* renamed from: f, reason: collision with root package name */
    public String f252697f;

    /* renamed from: f0, reason: collision with root package name */
    public LocationInfo f252698f0;

    /* renamed from: h, reason: collision with root package name */
    public String f252700h;

    /* renamed from: i, reason: collision with root package name */
    public String f252702i;

    /* renamed from: j0, reason: collision with root package name */
    public e f252704j0;

    /* renamed from: k0, reason: collision with root package name */
    public int f252705k0;

    /* renamed from: m, reason: collision with root package name */
    public String f252706m;

    /* renamed from: l0, reason: collision with root package name */
    public static final int f252689l0 = ((IModelUtil) QRoute.api(IModelUtil.class)).getFeedsProtocolMediaInfoTextFeeds();
    public static final Parcelable.Creator<VideoData> CREATOR = new a();

    /* renamed from: g0, reason: collision with root package name */
    public boolean f252699g0 = false;

    /* renamed from: h0, reason: collision with root package name */
    public boolean f252701h0 = false;

    /* renamed from: i0, reason: collision with root package name */
    public ArrayList<b> f252703i0 = new ArrayList<>();

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<VideoData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoData createFromParcel(Parcel parcel) {
            return new VideoData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public VideoData[] newArray(int i3) {
            return new VideoData[i3];
        }
    }

    public VideoData() {
    }

    public boolean a() {
        String str = this.f252695e;
        if (str != null && !str.equals("")) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return hashCode();
    }

    public String toString() {
        return "VideoData{id='" + this.f252695e + "', videoUrl='" + this.f252697f + "', coverUrl='" + this.f252700h + "', doodleUrl='" + this.f252702i + "', headerUrl='" + this.H + "', anchorNickName='" + this.N + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f252693d);
        parcel.writeString(this.f252695e);
        parcel.writeString(this.f252697f);
        parcel.writeString(this.f252700h);
        parcel.writeString(this.f252702i);
        parcel.writeString(this.f252706m);
        parcel.writeInt(this.C);
        parcel.writeLong(this.D);
        parcel.writeString(this.H);
        parcel.writeByte(this.I ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.J ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.K);
        parcel.writeString(this.N);
        parcel.writeString(this.P);
        parcel.writeLong(this.Q);
        parcel.writeLong(this.U);
        parcel.writeString(this.W);
        parcel.writeString(this.X);
        parcel.writeLong(this.Y);
        parcel.writeInt(this.f252691b0);
        parcel.writeInt(this.f252692c0);
        parcel.writeInt(this.L);
        parcel.writeInt(this.M);
    }

    public VideoData(Parcel parcel) {
        this.f252693d = parcel.readInt();
        this.f252695e = parcel.readString();
        this.f252697f = parcel.readString();
        this.f252700h = parcel.readString();
        this.f252702i = parcel.readString();
        this.f252706m = parcel.readString();
        this.C = parcel.readInt();
        this.D = parcel.readLong();
        this.H = parcel.readString();
        this.I = parcel.readByte() != 0;
        this.J = parcel.readByte() != 0;
        this.K = parcel.readInt();
        this.N = parcel.readString();
        this.P = parcel.readString();
        this.Q = parcel.readLong();
        this.U = parcel.readLong();
        this.W = parcel.readString();
        this.X = parcel.readString();
        this.Y = parcel.readLong();
        this.f252691b0 = parcel.readInt();
        this.f252692c0 = parcel.readInt();
        this.L = parcel.readInt();
        this.M = parcel.readInt();
    }
}
