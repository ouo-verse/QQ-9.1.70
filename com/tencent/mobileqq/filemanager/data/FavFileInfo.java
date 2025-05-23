package com.tencent.mobileqq.filemanager.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes12.dex */
public class FavFileInfo implements Parcelable {
    public static final Parcelable.Creator<FavFileInfo> CREATOR = new a();
    public long C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public long K;
    public long L;
    public String M;
    public long N;
    public String P;
    public String Q;
    public String R;
    public boolean S;
    long[] T;

    /* renamed from: d, reason: collision with root package name */
    public long f207672d;

    /* renamed from: e, reason: collision with root package name */
    public String f207673e;

    /* renamed from: f, reason: collision with root package name */
    public String f207674f;

    /* renamed from: h, reason: collision with root package name */
    public String f207675h;

    /* renamed from: i, reason: collision with root package name */
    public String f207676i;

    /* renamed from: m, reason: collision with root package name */
    public long f207677m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements Parcelable.Creator<FavFileInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public FavFileInfo createFromParcel(Parcel parcel) {
            return new FavFileInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public FavFileInfo[] newArray(int i3) {
            return new FavFileInfo[i3];
        }
    }

    public FavFileInfo() {
        this.K = -1L;
        this.L = -1L;
        this.M = "";
        this.N = -1L;
        this.P = "";
        this.T = new long[5];
    }

    public long a(int i3) {
        if (i3 >= 0 && i3 < 5) {
            return this.T[i3];
        }
        return 0L;
    }

    public String b() {
        if (!TextUtils.isEmpty(this.E)) {
            return this.E;
        }
        if (!TextUtils.isEmpty(this.J)) {
            this.E = this.J;
        } else if (!TextUtils.isEmpty(this.I)) {
            this.E = this.I;
        } else if (!TextUtils.isEmpty(this.H)) {
            this.E = this.H;
        } else if (!TextUtils.isEmpty(this.G)) {
            this.E = this.G;
        } else if (!TextUtils.isEmpty(this.F)) {
            this.E = this.F;
        }
        return this.E;
    }

    public void c(int i3, long j3) {
        if (i3 >= 0 && i3 < 5) {
            this.T[i3] = j3;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f207672d);
        parcel.writeString(this.f207673e);
        parcel.writeString(this.f207674f);
        parcel.writeString(this.f207675h);
        parcel.writeString(this.f207676i);
        parcel.writeLong(this.f207677m);
        parcel.writeLong(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.Q);
        parcel.writeString(this.R);
        parcel.writeByte(this.S ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.K);
        parcel.writeLong(this.L);
        parcel.writeString(this.M);
        parcel.writeLong(this.N);
        parcel.writeString(this.P);
    }

    public FavFileInfo(Parcel parcel) {
        this.K = -1L;
        this.L = -1L;
        this.M = "";
        this.N = -1L;
        this.P = "";
        this.T = new long[5];
        this.f207672d = parcel.readLong();
        this.f207673e = parcel.readString();
        this.f207674f = parcel.readString();
        this.f207675h = parcel.readString();
        this.f207676i = parcel.readString();
        this.f207677m = parcel.readLong();
        this.C = parcel.readLong();
        this.D = parcel.readString();
        this.E = parcel.readString();
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readString();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.Q = parcel.readString();
        this.R = parcel.readString();
        this.S = parcel.readByte() != 0;
        this.K = parcel.readLong();
        this.L = parcel.readLong();
        this.M = parcel.readString();
        this.N = parcel.readLong();
        this.P = parcel.readString();
    }
}
