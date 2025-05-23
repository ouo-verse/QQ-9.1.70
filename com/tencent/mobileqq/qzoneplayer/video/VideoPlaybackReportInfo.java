package com.tencent.mobileqq.qzoneplayer.video;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: classes35.dex */
public class VideoPlaybackReportInfo implements Parcelable {
    public static final Parcelable.Creator<VideoPlaybackReportInfo> CREATOR = new a();
    public String C;
    public String D;
    public String E;
    public String F;
    public String G;
    public String H;
    public String I;
    public String J;
    public String K;
    public boolean L;
    public boolean M;
    public boolean N;
    public String P;
    public long Q;
    public String R;
    public String S;
    public String T;
    public String U;
    public String V;
    public String W;
    public String X;
    public String Y;
    public String Z;

    /* renamed from: a0, reason: collision with root package name */
    public String f279927a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f279928b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f279929c0;

    /* renamed from: d, reason: collision with root package name */
    public String f279930d;

    /* renamed from: d0, reason: collision with root package name */
    public boolean f279931d0;

    /* renamed from: e, reason: collision with root package name */
    public boolean f279932e;

    /* renamed from: e0, reason: collision with root package name */
    public boolean f279933e0;

    /* renamed from: f, reason: collision with root package name */
    public boolean f279934f;

    /* renamed from: h, reason: collision with root package name */
    public String f279935h;

    /* renamed from: i, reason: collision with root package name */
    public String f279936i;

    /* renamed from: m, reason: collision with root package name */
    public String f279937m;

    /* loaded from: classes35.dex */
    class a implements Parcelable.Creator<VideoPlaybackReportInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public VideoPlaybackReportInfo createFromParcel(Parcel parcel) {
            return new VideoPlaybackReportInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public VideoPlaybackReportInfo[] newArray(int i3) {
            return new VideoPlaybackReportInfo[i3];
        }
    }

    public VideoPlaybackReportInfo() {
        this.f279930d = "";
        this.f279935h = "";
        this.f279936i = "9";
        this.f279937m = "";
        this.C = "";
        this.D = "";
        this.E = "";
        this.F = "";
        this.G = "";
        this.H = "";
        this.I = "";
        this.J = "";
        this.K = "";
        this.f279929c0 = "";
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        if (TextUtils.isEmpty(lastPathSegment)) {
            return "";
        }
        String[] split = lastPathSegment.split("\\.");
        if (split.length <= 0) {
            return "";
        }
        return split[0];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f279930d);
        parcel.writeByte(this.f279932e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f279934f ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f279935h);
        parcel.writeString(this.f279936i);
        parcel.writeString(this.f279937m);
        parcel.writeString(this.C);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeString(this.G);
        parcel.writeString(this.I);
        parcel.writeString(this.J);
        parcel.writeString(this.K);
    }

    protected VideoPlaybackReportInfo(Parcel parcel) {
        this.f279930d = "";
        this.f279935h = "";
        this.f279936i = "9";
        this.f279937m = "";
        this.C = "";
        this.D = "";
        this.E = "";
        this.F = "";
        this.G = "";
        this.H = "";
        this.I = "";
        this.J = "";
        this.K = "";
        this.f279929c0 = "";
        this.f279930d = parcel.readString();
        this.f279932e = parcel.readByte() != 0;
        this.f279934f = parcel.readByte() != 0;
        this.f279935h = parcel.readString();
        this.f279936i = parcel.readString();
        this.f279937m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readString();
        this.E = parcel.readString();
        this.F = parcel.readString();
        this.G = parcel.readString();
        this.I = parcel.readString();
        this.J = parcel.readString();
        this.K = parcel.readString();
    }
}
