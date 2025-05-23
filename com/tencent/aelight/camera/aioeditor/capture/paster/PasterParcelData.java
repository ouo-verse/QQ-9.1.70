package com.tencent.aelight.camera.aioeditor.capture.paster;

import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;

/* loaded from: classes32.dex */
public class PasterParcelData implements Parcelable {
    public static final Parcelable.Creator<PasterParcelData> CREATOR = new a();
    public float C;
    public float D;
    public RectF E;
    public String F;
    public String G;
    public String H;
    public String I;
    public int J;
    public String K;
    public int L;
    public int M;
    public int N;
    public String P;
    public SegmentKeeper Q;

    /* renamed from: d, reason: collision with root package name */
    public int f66832d;

    /* renamed from: e, reason: collision with root package name */
    public PointF f66833e;

    /* renamed from: f, reason: collision with root package name */
    public float f66834f;

    /* renamed from: h, reason: collision with root package name */
    public float f66835h;

    /* renamed from: i, reason: collision with root package name */
    public float f66836i;

    /* renamed from: m, reason: collision with root package name */
    public float f66837m;

    /* loaded from: classes32.dex */
    class a implements Parcelable.Creator<PasterParcelData> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PasterParcelData createFromParcel(Parcel parcel) {
            return new PasterParcelData(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PasterParcelData[] newArray(int i3) {
            return new PasterParcelData[i3];
        }
    }

    protected PasterParcelData(Parcel parcel) {
        this.f66834f = 1.0f;
        this.f66835h = 0.0f;
        this.f66836i = 0.0f;
        this.f66837m = 0.0f;
        this.Q = new SegmentKeeper();
        this.f66832d = parcel.readInt();
        this.f66833e = (PointF) parcel.readParcelable(PointF.class.getClassLoader());
        this.f66834f = parcel.readFloat();
        this.f66835h = parcel.readFloat();
        this.f66836i = parcel.readFloat();
        this.f66837m = parcel.readFloat();
        this.C = parcel.readFloat();
        this.D = parcel.readFloat();
        this.E = (RectF) parcel.readParcelable(RectF.class.getClassLoader());
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readString();
        this.J = parcel.readInt();
        this.K = parcel.readString();
        this.L = parcel.readInt();
        this.M = parcel.readInt();
        this.N = parcel.readInt();
        this.P = parcel.readString();
        this.I = parcel.readString();
        this.Q = (SegmentKeeper) parcel.readParcelable(SegmentKeeper.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f66832d);
        parcel.writeParcelable(this.f66833e, 0);
        parcel.writeFloat(this.f66834f);
        parcel.writeFloat(this.f66835h);
        parcel.writeFloat(this.f66836i);
        parcel.writeFloat(this.f66837m);
        parcel.writeFloat(this.C);
        parcel.writeFloat(this.D);
        parcel.writeParcelable(this.E, 0);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.H);
        parcel.writeInt(this.J);
        parcel.writeString(this.K);
        parcel.writeInt(this.L);
        parcel.writeInt(this.M);
        parcel.writeInt(this.N);
        parcel.writeString(this.P);
        parcel.writeString(this.I);
        parcel.writeParcelable(this.Q, 0);
    }
}
