package com.tencent.gamecenter.wadl.biz.entity;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportKey;

/* loaded from: classes6.dex */
public class ApkParams implements Parcelable {
    public static final Parcelable.Creator<ApkParams> CREATOR = new a();
    public static String F = "sessionId";
    public static String G = "channel";
    public static String H = "appid";
    public static String I = "appName";
    public static String J = "pkgName";
    public static String K = "fileSize";
    public static String L = "localPath";
    public static String M = "sourceId";
    public static String N = "iconUrl";
    public String C;
    public int D;
    public String E;

    /* renamed from: d, reason: collision with root package name */
    public String f106716d;

    /* renamed from: e, reason: collision with root package name */
    public String f106717e;

    /* renamed from: f, reason: collision with root package name */
    public String f106718f;

    /* renamed from: h, reason: collision with root package name */
    public long f106719h;

    /* renamed from: i, reason: collision with root package name */
    public String f106720i;

    /* renamed from: m, reason: collision with root package name */
    public String f106721m;

    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<ApkParams> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApkParams createFromParcel(Parcel parcel) {
            return new ApkParams(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ApkParams[] newArray(int i3) {
            return new ApkParams[i3];
        }
    }

    public ApkParams() {
    }

    public static ApkParams a(Uri uri) {
        if (uri != null) {
            try {
                ApkParams apkParams = new ApkParams();
                apkParams.f106716d = uri.getQueryParameter(H);
                apkParams.f106717e = uri.getQueryParameter(I);
                apkParams.f106718f = uri.getQueryParameter(J);
                apkParams.f106719h = Long.parseLong(uri.getQueryParameter(K));
                apkParams.f106720i = uri.getQueryParameter(L);
                apkParams.f106721m = uri.getQueryParameter(M);
                apkParams.C = uri.getQueryParameter(N);
                apkParams.D = Integer.parseInt(uri.getQueryParameter(F));
                apkParams.E = uri.getQueryParameter(G);
                return apkParams;
            } catch (Exception e16) {
                com.tencent.xaction.log.b.c("ApkParams", 1, "parserFromUri exception|", e16);
                return null;
            }
        }
        return null;
    }

    public Uri b() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("gamecenter").appendPath(VRReportDefine$ReportKey.INSTALL).appendQueryParameter(H, this.f106716d).appendQueryParameter(I, this.f106717e).appendQueryParameter(J, this.f106718f).appendQueryParameter(K, String.valueOf(this.f106719h)).appendQueryParameter(L, this.f106720i).appendQueryParameter(M, this.f106721m).appendQueryParameter(N, this.C).appendQueryParameter(F, String.valueOf(this.D)).appendQueryParameter(G, this.E);
        return builder.build();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ApkParams{appId='" + this.f106716d + "', appName='" + this.f106717e + "', pkgName='" + this.f106718f + "', fileSize=" + this.f106719h + ", localPath='" + this.f106720i + "', sourceId='" + this.f106721m + "', iconUrl='" + this.C + "', sessionId=" + this.D + ", channel='" + this.E + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f106716d);
        parcel.writeString(this.f106717e);
        parcel.writeString(this.f106718f);
        parcel.writeLong(this.f106719h);
        parcel.writeString(this.f106720i);
        parcel.writeString(this.f106721m);
        parcel.writeString(this.C);
        parcel.writeInt(this.D);
        parcel.writeString(this.E);
    }

    protected ApkParams(Parcel parcel) {
        this.f106716d = parcel.readString();
        this.f106717e = parcel.readString();
        this.f106718f = parcel.readString();
        this.f106719h = parcel.readLong();
        this.f106720i = parcel.readString();
        this.f106721m = parcel.readString();
        this.C = parcel.readString();
        this.D = parcel.readInt();
        this.E = parcel.readString();
    }
}
