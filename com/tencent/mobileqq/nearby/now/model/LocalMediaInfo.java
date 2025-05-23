package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes33.dex */
public class LocalMediaInfo implements Comparable<LocalMediaInfo>, Parcelable {
    public static final Parcelable.Creator<LocalMediaInfo> CREATOR = new a();
    public long C;
    public int D;
    public long E;
    public int F;
    public int G;
    public int K;
    public int L;
    public int M;
    public String P;

    /* renamed from: f, reason: collision with root package name */
    public long f252675f;

    /* renamed from: h, reason: collision with root package name */
    public String f252676h;

    /* renamed from: i, reason: collision with root package name */
    public long f252677i;

    /* renamed from: m, reason: collision with root package name */
    public long f252678m;

    /* renamed from: d, reason: collision with root package name */
    public String f252673d = "";

    /* renamed from: e, reason: collision with root package name */
    public int f252674e = 2;
    public int H = 0;
    public int I = 0;
    public int J = 0;
    public Integer N = -1;
    public String Q = "";
    public String R = "";
    public String S = "";

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements Parcelable.Creator<LocalMediaInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocalMediaInfo createFromParcel(Parcel parcel) {
            LocalMediaInfo localMediaInfo = new LocalMediaInfo();
            localMediaInfo.f252675f = parcel.readLong();
            localMediaInfo.f252676h = parcel.readString();
            localMediaInfo.f252677i = parcel.readLong();
            localMediaInfo.f252678m = parcel.readLong();
            localMediaInfo.C = parcel.readLong();
            localMediaInfo.D = parcel.readInt();
            localMediaInfo.H = parcel.readInt();
            localMediaInfo.E = parcel.readLong();
            localMediaInfo.f252674e = parcel.readInt();
            localMediaInfo.K = parcel.readInt();
            localMediaInfo.L = parcel.readInt();
            localMediaInfo.M = parcel.readInt();
            localMediaInfo.N = Integer.valueOf(parcel.readInt());
            localMediaInfo.P = parcel.readString();
            localMediaInfo.Q = parcel.readString();
            localMediaInfo.F = parcel.readInt();
            localMediaInfo.G = parcel.readInt();
            localMediaInfo.J = parcel.readInt();
            localMediaInfo.I = parcel.readInt();
            return localMediaInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LocalMediaInfo[] newArray(int i3) {
            return new LocalMediaInfo[0];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "LocalMediaInfo{_id=" + this.f252675f + ", path='" + this.f252676h + "', fileSize=" + this.f252677i + ", addedDate=" + this.f252678m + ", modifiedDate=" + this.C + ", orientation=" + this.D + ", mDuration=" + this.E + ", selectStatus=" + this.f252674e + ", rotation=" + this.H + ", thumbWidth=" + this.K + ", thumbHeight=" + this.L + ", index=" + this.M + ", position=" + this.N + ", mMimeType='" + this.P + "', mediaWidth=" + this.F + ", mediaHeight=" + this.G + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.f252675f);
        parcel.writeString(this.f252676h);
        parcel.writeLong(this.f252677i);
        parcel.writeLong(this.f252678m);
        parcel.writeLong(this.C);
        parcel.writeInt(this.D);
        parcel.writeInt(this.H);
        parcel.writeLong(this.E);
        parcel.writeInt(this.f252674e);
        parcel.writeInt(this.K);
        parcel.writeInt(this.L);
        parcel.writeInt(this.M);
        parcel.writeInt(this.N.intValue());
        parcel.writeString(this.P);
        parcel.writeString(this.Q);
        parcel.writeInt(this.F);
        parcel.writeInt(this.G);
        parcel.writeInt(this.J);
        parcel.writeInt(this.I);
    }

    @Override // java.lang.Comparable
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public int compareTo(LocalMediaInfo localMediaInfo) {
        if (localMediaInfo == null) {
            return -1;
        }
        long j3 = localMediaInfo.C;
        long j16 = this.C;
        if (j3 > j16) {
            return 1;
        }
        return j3 == j16 ? 0 : -1;
    }
}
