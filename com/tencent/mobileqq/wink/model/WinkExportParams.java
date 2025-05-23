package com.tencent.mobileqq.wink.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

/* loaded from: classes21.dex */
public class WinkExportParams implements Parcelable {
    public static final Parcelable.Creator<WinkExportParams> CREATOR = new a();
    public boolean C;
    public String D;
    public String E;
    public String F;
    public int G;
    public int H;
    public LocalMediaInfo I;
    public String J;
    public long K;

    /* renamed from: d, reason: collision with root package name */
    public int f323989d;

    /* renamed from: e, reason: collision with root package name */
    public int f323990e;

    /* renamed from: f, reason: collision with root package name */
    public int f323991f;

    /* renamed from: h, reason: collision with root package name */
    public int f323992h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f323993i;

    /* renamed from: m, reason: collision with root package name */
    public boolean f323994m;

    /* loaded from: classes21.dex */
    class a implements Parcelable.Creator<WinkExportParams> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public WinkExportParams createFromParcel(Parcel parcel) {
            return new WinkExportParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public WinkExportParams[] newArray(int i3) {
            return new WinkExportParams[i3];
        }
    }

    public WinkExportParams(String str, String str2, String str3) {
        this.f323992h = 1;
        this.f323993i = true;
        this.f323994m = true;
        this.C = true;
        this.H = 1;
        this.D = str;
        this.E = str2;
        this.F = str3;
    }

    public int a() {
        return this.f323992h;
    }

    public LocalMediaInfo b() {
        return this.I;
    }

    public int c() {
        return this.f323990e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f323991f;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        WinkExportParams winkExportParams = (WinkExportParams) obj;
        if (!this.E.equals(winkExportParams.E) || this.G != winkExportParams.G || this.f323989d != winkExportParams.f323989d || this.f323990e != winkExportParams.f323990e || this.f323991f != winkExportParams.f323991f || this.f323993i != winkExportParams.f323993i || this.C != winkExportParams.C || this.f323992h != winkExportParams.f323992h) {
            return false;
        }
        return true;
    }

    public int f() {
        return this.f323989d;
    }

    public boolean g() {
        return this.C;
    }

    public boolean j() {
        return this.f323993i;
    }

    public void k(boolean z16) {
        this.C = z16;
    }

    public void l(boolean z16) {
        this.f323993i = z16;
    }

    public void m(int i3) {
        this.H = i3;
    }

    public void n(int i3) {
        this.f323992h = i3;
    }

    public void o() {
        this.K = System.currentTimeMillis();
    }

    public void p(LocalMediaInfo localMediaInfo) {
        this.I = localMediaInfo;
    }

    public void q(int i3) {
        this.f323989d = i3;
    }

    public String toString() {
        return "ExportParams{mVideoLevel=" + this.f323989d + ", mVideoBitRate=" + this.f323990e + ", mVideoFrameRate=" + this.f323991f + ", mEnableOriginVideo=" + this.f323993i + ", mEnableH265=" + this.C + ", mIFrameInterval=" + this.f323992h + ", mBusinessName='" + this.D + "', mMissionID='" + this.E + "', mTraceID='" + this.F + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f323989d);
        parcel.writeInt(this.f323990e);
        parcel.writeInt(this.f323991f);
        parcel.writeByte(this.f323993i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.C ? (byte) 1 : (byte) 0);
        parcel.writeString(this.D);
        parcel.writeString(this.E);
        parcel.writeString(this.F);
        parcel.writeInt(this.G);
        parcel.writeParcelable(this.I, i3);
        parcel.writeInt(this.f323992h);
        parcel.writeInt(this.H);
        parcel.writeString(this.J);
    }

    public WinkExportParams(String str, String str2, String str3, int i3, int i16, int i17) {
        this.f323992h = 1;
        this.f323993i = true;
        this.f323994m = true;
        this.C = true;
        this.H = 1;
        this.D = str;
        this.E = str2;
        this.F = str3;
        this.f323989d = i3;
        this.f323990e = i16;
        this.f323991f = i17;
    }

    protected WinkExportParams(Parcel parcel) {
        this.f323992h = 1;
        this.f323993i = true;
        this.f323994m = true;
        this.C = true;
        this.H = 1;
        this.f323989d = parcel.readInt();
        this.f323990e = parcel.readInt();
        this.f323991f = parcel.readInt();
        this.f323993i = parcel.readByte() != 0;
        this.C = parcel.readByte() != 0;
        this.D = parcel.readString();
        this.E = parcel.readString();
        this.F = parcel.readString();
        this.G = parcel.readInt();
        this.I = (LocalMediaInfo) parcel.readParcelable(LocalMediaInfo.class.getClassLoader());
        this.f323992h = parcel.readInt();
        this.H = parcel.readInt();
        this.J = parcel.readString();
    }
}
