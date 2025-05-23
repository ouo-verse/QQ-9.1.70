package com.tencent.mobileqq.ar;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ARScanAR implements Parcelable {
    public static final Parcelable.Creator<ARScanAR> CREATOR = new a();
    public int C;
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
    public String N;
    public String P;

    /* renamed from: d, reason: collision with root package name */
    public int f197345d;

    /* renamed from: e, reason: collision with root package name */
    public long f197346e;

    /* renamed from: f, reason: collision with root package name */
    public long f197347f;

    /* renamed from: h, reason: collision with root package name */
    public long f197348h;

    /* renamed from: i, reason: collision with root package name */
    public long f197349i;

    /* renamed from: m, reason: collision with root package name */
    public int f197350m;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    class a implements Parcelable.Creator<ARScanAR> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ARScanAR createFromParcel(Parcel parcel) {
            return new ARScanAR(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ARScanAR[] newArray(int i3) {
            return new ARScanAR[i3];
        }
    }

    public ARScanAR() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("ScanAR{");
        stringBuffer.append("EntryType='");
        stringBuffer.append(this.f197345d);
        stringBuffer.append('\'');
        stringBuffer.append(", aRBegin=");
        stringBuffer.append(this.f197346e);
        stringBuffer.append(", aREnd=");
        stringBuffer.append(this.f197347f);
        stringBuffer.append(", userGuideBeginTime=");
        stringBuffer.append(this.f197348h);
        stringBuffer.append(", userGuideEndTime=");
        stringBuffer.append(this.f197349i);
        stringBuffer.append(", actType=");
        stringBuffer.append(this.f197350m);
        stringBuffer.append(", userGuideShowCount=");
        stringBuffer.append(this.C);
        stringBuffer.append(", scanIconImg='");
        stringBuffer.append(this.D);
        stringBuffer.append('\'');
        stringBuffer.append(", scanIconPressed='");
        stringBuffer.append(this.F);
        stringBuffer.append('\'');
        stringBuffer.append(", scanIconText='");
        stringBuffer.append(this.H);
        stringBuffer.append('\'');
        stringBuffer.append(", scanLine1='");
        stringBuffer.append(this.I);
        stringBuffer.append('\'');
        stringBuffer.append(", scanLine2='");
        stringBuffer.append(this.J);
        stringBuffer.append('\'');
        stringBuffer.append(", scanLineLink='");
        stringBuffer.append(this.K);
        stringBuffer.append('\'');
        stringBuffer.append(", scanLinkUrl='");
        stringBuffer.append(this.L);
        stringBuffer.append('\'');
        stringBuffer.append(", what2scanUrl='");
        stringBuffer.append(this.M);
        stringBuffer.append('\'');
        stringBuffer.append(", userGuideWording='");
        stringBuffer.append(this.N);
        stringBuffer.append('\'');
        stringBuffer.append(", userGuideType='");
        stringBuffer.append(this.P);
        stringBuffer.append('\'');
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f197345d);
        parcel.writeLong(this.f197346e);
        parcel.writeLong(this.f197347f);
        parcel.writeLong(this.f197348h);
        parcel.writeLong(this.f197349i);
        parcel.writeInt(this.f197350m);
        parcel.writeInt(this.C);
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
        parcel.writeString(this.N);
        parcel.writeString(this.P);
    }

    public ARScanAR(Parcel parcel) {
        this.f197345d = parcel.readInt();
        this.f197346e = parcel.readLong();
        this.f197347f = parcel.readLong();
        this.f197348h = parcel.readLong();
        this.f197349i = parcel.readLong();
        this.f197350m = parcel.readInt();
        this.C = parcel.readInt();
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
        this.N = parcel.readString();
        this.P = parcel.readString();
    }
}
