package com.dataline.mpfile;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class MpfileTaskInfo implements Parcelable {
    public static final Parcelable.Creator<MpfileTaskInfo> CREATOR = new a();
    public String C;
    public String D;
    public String E;
    public String F;
    public long G;
    public long H;
    public long I;
    public long J;
    public long M;

    /* renamed from: d, reason: collision with root package name */
    public int f32302d;

    /* renamed from: f, reason: collision with root package name */
    public String f32304f;

    /* renamed from: h, reason: collision with root package name */
    public String f32305h;

    /* renamed from: i, reason: collision with root package name */
    public String f32306i;

    /* renamed from: m, reason: collision with root package name */
    public String f32307m;

    /* renamed from: e, reason: collision with root package name */
    public int f32303e = 0;
    public long K = System.currentTimeMillis();
    public long L = 0;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    class a implements Parcelable.Creator<MpfileTaskInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MpfileTaskInfo createFromParcel(Parcel parcel) {
            MpfileTaskInfo mpfileTaskInfo = new MpfileTaskInfo();
            mpfileTaskInfo.f32302d = parcel.readInt();
            mpfileTaskInfo.f32303e = parcel.readInt();
            mpfileTaskInfo.f32304f = parcel.readString();
            mpfileTaskInfo.f32305h = parcel.readString();
            mpfileTaskInfo.f32306i = parcel.readString();
            mpfileTaskInfo.f32307m = parcel.readString();
            mpfileTaskInfo.C = parcel.readString();
            mpfileTaskInfo.D = parcel.readString();
            mpfileTaskInfo.E = parcel.readString();
            mpfileTaskInfo.F = parcel.readString();
            mpfileTaskInfo.G = parcel.readLong();
            mpfileTaskInfo.H = parcel.readLong();
            mpfileTaskInfo.I = parcel.readLong();
            mpfileTaskInfo.J = parcel.readLong();
            mpfileTaskInfo.K = parcel.readLong();
            mpfileTaskInfo.L = parcel.readLong();
            mpfileTaskInfo.M = parcel.readLong();
            return mpfileTaskInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public MpfileTaskInfo[] newArray(int i3) {
            return new MpfileTaskInfo[i3];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f32302d);
        parcel.writeInt(this.f32303e);
        parcel.writeString(this.f32304f);
        parcel.writeString(this.f32305h);
        parcel.writeString(this.f32306i);
        parcel.writeString(this.f32307m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeLong(this.G);
        parcel.writeLong(this.H);
        parcel.writeLong(this.I);
        parcel.writeLong(this.J);
        parcel.writeLong(this.K);
        parcel.writeLong(this.L);
        parcel.writeLong(this.M);
    }
}
