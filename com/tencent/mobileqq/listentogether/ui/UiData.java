package com.tencent.mobileqq.listentogether.ui;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;

/* compiled from: P */
/* loaded from: classes33.dex */
public class UiData implements Parcelable {
    public static final Parcelable.Creator<UiData> CREATOR = new a();
    long C;
    long D;
    int E;
    boolean F;
    boolean G;
    String H;
    String I;
    String J;
    int K;
    int L;
    ListenTogetherSession M;

    /* renamed from: d, reason: collision with root package name */
    public int f241157d;

    /* renamed from: e, reason: collision with root package name */
    public String f241158e;

    /* renamed from: f, reason: collision with root package name */
    public int f241159f;

    /* renamed from: h, reason: collision with root package name */
    public boolean f241160h;

    /* renamed from: i, reason: collision with root package name */
    int f241161i;

    /* renamed from: m, reason: collision with root package name */
    boolean f241162m;

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements Parcelable.Creator<UiData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public UiData createFromParcel(Parcel parcel) {
            return new UiData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public UiData[] newArray(int i3) {
            return new UiData[i3];
        }
    }

    public UiData() {
        this.f241157d = -1;
        this.f241158e = "";
        this.F = true;
        this.G = false;
        this.H = "";
        this.I = "";
        this.J = null;
        this.L = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UiData{mCurType=" + this.f241157d + ", mCurUin='" + this.f241158e + ", status=" + this.f241159f + ", userState=" + this.f241161i + ", changeMusic=" + this.G + ", isAdmin=" + this.f241160h + ", canOper=" + this.f241162m + ", playMode=" + this.K + ", mutualLevel=" + this.L + ", creatorUin=" + this.I + ", isShowPanel=" + this.F + ", progres=" + this.E + ", session=\n" + this.M + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f241157d);
        parcel.writeString(this.f241158e);
        parcel.writeInt(this.f241159f);
        parcel.writeByte(this.f241160h ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.f241161i);
        parcel.writeByte(this.f241162m ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeInt(this.E);
        parcel.writeByte(this.F ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.G ? (byte) 1 : (byte) 0);
        parcel.writeString(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeInt(this.K);
        parcel.writeInt(this.L);
        parcel.writeParcelable(this.M, i3);
    }

    public void a() {
        this.f241159f = 0;
        this.f241161i = -1;
        this.E = 0;
        this.F = true;
        this.M = null;
        this.C = 0L;
        this.D = 0L;
        this.G = false;
        this.I = "";
        this.J = null;
        this.H = "";
        this.K = 1;
        this.L = 0;
    }

    public UiData(Parcel parcel) {
        this.f241157d = -1;
        this.f241158e = "";
        this.F = true;
        this.G = false;
        this.H = "";
        this.I = "";
        this.J = null;
        this.L = 0;
        this.f241157d = parcel.readInt();
        this.f241158e = parcel.readString();
        this.f241159f = parcel.readInt();
        this.f241160h = parcel.readByte() == 1;
        this.f241161i = parcel.readInt();
        this.f241162m = parcel.readByte() == 1;
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readInt();
        this.F = parcel.readByte() == 1;
        this.G = parcel.readByte() == 1;
        this.H = parcel.readString();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readInt();
        this.L = parcel.readInt();
        this.M = (ListenTogetherSession) parcel.readParcelable(ListenTogetherSession.class.getClassLoader());
    }
}
