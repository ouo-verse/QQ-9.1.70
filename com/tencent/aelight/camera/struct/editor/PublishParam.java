package com.tencent.aelight.camera.struct.editor;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class PublishParam implements Parcelable {
    public static final Parcelable.Creator<PublishParam> CREATOR = new a();
    public static final String Z = "com.tencent.aelight.camera.struct.editor.PublishParam";
    public final int C;
    public final int D;
    public final long E;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final String K;
    public final String L;
    public final int M;
    public final int N;
    public final String P;
    public final String Q;
    public final String R;
    public final String S;
    public final int T;
    public final int U;
    public final String V;
    public final int W;
    public final int X;
    public int Y;

    /* renamed from: d, reason: collision with root package name */
    public final String f69066d;

    /* renamed from: e, reason: collision with root package name */
    public final String f69067e;

    /* renamed from: f, reason: collision with root package name */
    public final String f69068f;

    /* renamed from: h, reason: collision with root package name */
    public final String f69069h;

    /* renamed from: i, reason: collision with root package name */
    public final String f69070i;

    /* renamed from: m, reason: collision with root package name */
    public final String f69071m;

    /* loaded from: classes3.dex */
    class a implements Parcelable.Creator<PublishParam> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PublishParam createFromParcel(Parcel parcel) {
            return new PublishParam(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PublishParam[] newArray(int i3) {
            return new PublishParam[i3];
        }
    }

    public PublishParam(String str, String str2, String str3, String str4, String str5, String str6, int i3, int i16, long j3, int i17, int i18, int i19, int i26, int i27, String str7, String str8, int i28, int i29, String str9, String str10, String str11, String str12, int i36, boolean z16, String str13, int i37, int i38) {
        this.f69066d = str;
        this.f69067e = str2;
        this.f69068f = str3;
        this.f69069h = str4;
        this.f69070i = str5;
        this.f69071m = str6;
        this.C = i3;
        this.D = i16;
        this.E = j3;
        this.F = i17;
        this.G = i18;
        this.H = i19;
        this.I = i26;
        this.J = i27;
        this.K = str7;
        this.L = str8;
        this.M = i28;
        this.N = i29;
        this.P = str9;
        this.Q = str10;
        this.R = str11;
        this.S = str12;
        this.T = i36;
        this.U = z16 ? 1 : 0;
        this.V = str13;
        this.W = i37;
        this.X = i38;
        String a16 = a();
        if (a16 != null) {
            throw new RuntimeException(a16);
        }
    }

    protected String a() {
        if (!TextUtils.isEmpty(this.f69066d) && !TextUtils.isEmpty(this.f69067e)) {
            return null;
        }
        return "both fakeVid and thumbPath should not be empty";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PublishParam{fakeVid='" + this.f69066d + "', thumbPath='" + this.f69067e + "', doodlePath='" + this.f69068f + "', videoLabel='" + this.f69069h + "', videoDoodleDescription='" + this.f69070i + "', videoAddress='" + this.f69071m + "', videoWidth=" + this.C + ", videoHeight=" + this.D + ", videoDuration=" + this.E + ", videoMaxrate=" + this.F + ", videoMinrate=" + this.G + ", isEdited=" + this.H + ", saveMode=" + this.I + ", recordFrames=" + this.J + ", atDoodlePath='" + this.K + "', atJsonData='" + this.L + "', hwEncodeRecordVideo='" + this.N + "', videoFilePath='" + this.P + "', audioFilePath='" + this.Q + "', mosaicFilePath='" + this.S + "', videoCount=" + this.T + "', videoLocateDescription='" + this.V + "', localVideoLongitude='" + this.W + "', localVideoLatitude=" + this.X + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f69066d);
        parcel.writeString(this.f69067e);
        parcel.writeString(this.f69068f);
        parcel.writeString(this.f69069h);
        parcel.writeString(this.f69070i);
        parcel.writeString(this.f69071m);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeLong(this.E);
        parcel.writeInt(this.F);
        parcel.writeInt(this.G);
        parcel.writeInt(this.H);
        parcel.writeInt(this.I);
        parcel.writeInt(this.J);
        parcel.writeString(this.K);
        parcel.writeString(this.L);
        parcel.writeInt(this.M);
        parcel.writeInt(this.N);
        parcel.writeString(this.P);
        parcel.writeString(this.Q);
        parcel.writeString(this.R);
        parcel.writeString(this.S);
        parcel.writeInt(this.T);
        parcel.writeInt(this.U);
        parcel.writeString(this.V);
        parcel.writeInt(this.W);
        parcel.writeInt(this.X);
    }

    protected PublishParam(Parcel parcel) {
        this.f69066d = parcel.readString();
        this.f69067e = parcel.readString();
        this.f69068f = parcel.readString();
        this.f69069h = parcel.readString();
        this.f69070i = parcel.readString();
        this.f69071m = parcel.readString();
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.E = parcel.readLong();
        this.F = parcel.readInt();
        this.G = parcel.readInt();
        this.H = parcel.readInt();
        this.I = parcel.readInt();
        this.J = parcel.readInt();
        this.K = parcel.readString();
        this.L = parcel.readString();
        this.M = parcel.readInt();
        this.N = parcel.readInt();
        this.P = parcel.readString();
        this.Q = parcel.readString();
        this.R = parcel.readString();
        this.S = parcel.readString();
        this.T = parcel.readInt();
        this.U = parcel.readInt();
        this.V = parcel.readString();
        this.W = parcel.readInt();
        this.X = parcel.readInt();
        String a16 = a();
        if (a16 != null) {
            throw new RuntimeException(a16);
        }
    }
}
