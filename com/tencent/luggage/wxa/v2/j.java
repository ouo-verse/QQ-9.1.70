package com.tencent.luggage.wxa.v2;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes8.dex */
public class j implements Parcelable, Cloneable {
    public static final Parcelable.Creator<j> CREATOR = new a();
    public int C;
    public int D;
    public int E;
    public int F;
    public int G;
    public int H;
    public int I;
    public int J;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;

    /* renamed from: a, reason: collision with root package name */
    public int f143036a;

    /* renamed from: b, reason: collision with root package name */
    public int f143037b;

    /* renamed from: c, reason: collision with root package name */
    public int f143038c;

    /* renamed from: d, reason: collision with root package name */
    public int f143039d;

    /* renamed from: e, reason: collision with root package name */
    public int f143040e;

    /* renamed from: f, reason: collision with root package name */
    public int f143041f;

    /* renamed from: g, reason: collision with root package name */
    public int f143042g;

    /* renamed from: h, reason: collision with root package name */
    public int f143043h;

    /* renamed from: i, reason: collision with root package name */
    public int f143044i;

    /* renamed from: j, reason: collision with root package name */
    public int f143045j;

    /* renamed from: k, reason: collision with root package name */
    public int f143046k;

    /* renamed from: l, reason: collision with root package name */
    public int f143047l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f143048m;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j createFromParcel(Parcel parcel) {
            return new j(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public j[] newArray(int i3) {
            return new j[i3];
        }
    }

    public j() {
        this.f143045j = 1;
        this.C = 0;
        this.Q = 0;
        this.R = 0;
    }

    public Object clone() {
        return super.clone();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "[isDefault " + this.f143048m + " width " + this.f143036a + " height " + this.f143037b + " fps " + this.f143038c + " video bitrate " + this.f143039d + " iFrame " + this.f143042g + " audio bitrate " + this.f143043h + " audioSampleRate " + this.f143044i + "audioChannelCount " + this.f143045j + " duration " + this.f143040e + " profile index " + this.f143046k + " preset index " + this.f143047l + " thumbSize " + this.C + " abaSwitch " + this.D + " qpSwitch " + this.E + " abaUpgear " + this.F + " abaDowngear " + this.G + " ceilingVideoBR " + this.H + " flooringVideoBR " + this.I + " isEnableHEVCEncode " + this.J + " isEnable720p " + this.K + " maxVideoSize " + this.L + " minQP " + this.M + " maxQP " + this.N + " takePhotosVideoBR " + this.O + " remuxScene " + this.P + " hwEnableHevc " + this.Q + " swEnableHevc " + this.R + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f143036a);
        parcel.writeInt(this.f143037b);
        parcel.writeInt(this.f143038c);
        parcel.writeInt(this.f143039d);
        parcel.writeInt(this.f143040e);
        parcel.writeInt(this.f143042g);
        parcel.writeInt(this.f143043h);
        parcel.writeInt(this.f143044i);
        parcel.writeInt(this.f143046k);
        parcel.writeInt(this.f143047l);
        parcel.writeInt(this.f143048m ? 1 : 0);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeInt(this.E);
        parcel.writeInt(this.F);
        parcel.writeInt(this.G);
        parcel.writeInt(this.H);
        parcel.writeInt(this.I);
        parcel.writeInt(this.J);
        parcel.writeInt(this.K);
        parcel.writeInt(this.L);
        parcel.writeInt(this.M);
        parcel.writeInt(this.N);
        parcel.writeInt(this.O);
        parcel.writeInt(this.P);
        parcel.writeInt(this.f143045j);
        parcel.writeInt(this.Q);
        parcel.writeInt(this.R);
        parcel.writeInt(this.f143041f);
    }

    public j(Parcel parcel) {
        this.f143045j = 1;
        this.C = 0;
        this.Q = 0;
        this.R = 0;
        this.f143036a = parcel.readInt();
        this.f143037b = parcel.readInt();
        this.f143038c = parcel.readInt();
        this.f143039d = parcel.readInt();
        this.f143040e = parcel.readInt();
        this.f143042g = parcel.readInt();
        this.f143043h = parcel.readInt();
        this.f143044i = parcel.readInt();
        this.f143046k = parcel.readInt();
        this.f143047l = parcel.readInt();
        this.f143048m = parcel.readInt() > 0;
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.E = parcel.readInt();
        this.F = parcel.readInt();
        this.G = parcel.readInt();
        this.H = parcel.readInt();
        this.I = parcel.readInt();
        this.J = parcel.readInt();
        this.K = parcel.readInt();
        this.L = parcel.readInt();
        this.M = parcel.readInt();
        this.N = parcel.readInt();
        this.O = parcel.readInt();
        this.P = parcel.readInt();
        this.f143045j = parcel.readInt();
        this.Q = parcel.readInt();
        this.R = parcel.readInt();
        this.f143041f = parcel.readInt();
    }
}
