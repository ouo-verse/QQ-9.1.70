package com.yolo.esports.download.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.open.base.g;
import com.tencent.timi.game.utils.l;
import com.tencent.timi.game.utils.p;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class DownloadInfo implements Comparable<DownloadInfo>, Parcelable {
    public static final Parcelable.Creator<DownloadInfo> CREATOR = new a();
    public String C;
    public long D;
    public long E;
    public long F;
    public long G;
    public int H;
    public String I;
    public int J;
    public String K;
    public boolean L;
    public int M;
    public String N;
    public String P;
    public long Q;
    public long R;
    public int S;
    public int T;
    public String U;

    /* renamed from: d, reason: collision with root package name */
    String f390013d;

    /* renamed from: e, reason: collision with root package name */
    public String f390014e;

    /* renamed from: f, reason: collision with root package name */
    public String f390015f;

    /* renamed from: h, reason: collision with root package name */
    public String f390016h;

    /* renamed from: i, reason: collision with root package name */
    public String f390017i;

    /* renamed from: m, reason: collision with root package name */
    public long f390018m;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements Parcelable.Creator<DownloadInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public DownloadInfo createFromParcel(Parcel parcel) {
            return new DownloadInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public DownloadInfo[] newArray(int i3) {
            return new DownloadInfo[i3];
        }
    }

    public DownloadInfo() {
        this.f390013d = "";
        this.f390014e = "";
        this.f390015f = "";
        this.f390016h = "";
        this.f390017i = "";
        this.f390018m = 0L;
        this.C = "";
        this.D = 0L;
        this.E = 0L;
        this.H = 0;
        this.I = "";
        this.J = 1;
        this.K = "";
        this.L = false;
        this.M = 0;
        this.N = "";
        this.P = "";
        this.Q = 0L;
        this.R = 0L;
        this.U = "unknown";
        u();
    }

    private boolean l(DownloadInfo downloadInfo) {
        if (this.f390018m == downloadInfo.f390018m && this.D == downloadInfo.D && this.E == downloadInfo.E && this.F == downloadInfo.F && this.G == downloadInfo.G) {
            return true;
        }
        return false;
    }

    private boolean m(DownloadInfo downloadInfo) {
        if (this.H == downloadInfo.H && this.J == downloadInfo.J && this.L == downloadInfo.L && this.M == downloadInfo.M && this.Q == downloadInfo.Q) {
            return true;
        }
        return false;
    }

    private boolean n(DownloadInfo downloadInfo) {
        if (this.R == downloadInfo.R && this.S == downloadInfo.S && this.T == downloadInfo.T && p.a(this.f390013d, downloadInfo.f390013d)) {
            return true;
        }
        return false;
    }

    private boolean o(DownloadInfo downloadInfo) {
        if (p.a(this.f390014e, downloadInfo.f390014e) && p.a(this.f390015f, downloadInfo.f390015f) && p.a(this.f390016h, downloadInfo.f390016h) && p.a(this.f390017i, downloadInfo.f390017i) && p.a(this.C, downloadInfo.C)) {
            return true;
        }
        return false;
    }

    private boolean p(DownloadInfo downloadInfo) {
        if (p.a(this.I, downloadInfo.I) && p.a(this.K, downloadInfo.K) && p.a(this.N, downloadInfo.N) && p.a(this.P, downloadInfo.P) && p.a(this.U, downloadInfo.U)) {
            return true;
        }
        return false;
    }

    public static String q(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return g.d(str);
    }

    private static String r(String str) {
        String str2;
        AppRuntime peekAppRuntime;
        try {
            MobileQQ mobileQQ = MobileQQ.sMobileQQ;
            if (mobileQQ == null || (peekAppRuntime = mobileQQ.peekAppRuntime()) == null) {
                str2 = "";
            } else {
                str2 = peekAppRuntime.getAccount();
            }
            String str3 = "" + str2 + System.currentTimeMillis() + str;
            l.i("DownloadInfo_", ">genUniqueId ori=" + str3);
            return g.d(str3);
        } catch (Throwable unused) {
            return "" + System.currentTimeMillis();
        }
    }

    private void u() {
        if (this.D == 0) {
            this.D = System.currentTimeMillis();
        }
        if (TextUtils.isEmpty(this.f390016h)) {
            this.f390016h = i05.a.c();
        }
        if (!TextUtils.isEmpty(this.f390016h)) {
            File file = new File(this.f390016h);
            if (!file.exists()) {
                file.mkdirs();
            }
            l.i("DownloadInfo_", "is " + this.f390016h + " exits:" + file.exists());
        }
    }

    private void z() {
        if (!TextUtils.isEmpty(this.f390013d) && TextUtils.isEmpty(this.P)) {
            this.P = r(this.f390013d);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DownloadInfo downloadInfo = (DownloadInfo) obj;
        if (l(downloadInfo) && m(downloadInfo) && n(downloadInfo) && o(downloadInfo) && p(downloadInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return p.b(this.f390013d, this.f390014e, this.f390015f, this.f390016h, this.f390017i, Long.valueOf(this.f390018m), this.C, Long.valueOf(this.D), Long.valueOf(this.E), Long.valueOf(this.F), Long.valueOf(this.G), Integer.valueOf(this.H), this.I, Integer.valueOf(this.J), this.K, Boolean.valueOf(this.L), Integer.valueOf(this.M), this.N, this.P, Long.valueOf(this.Q), Long.valueOf(this.R), Integer.valueOf(this.S), Integer.valueOf(this.T), this.U);
    }

    public boolean j() {
        if (this.M == 4 && !w()) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Comparable
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public int compareTo(DownloadInfo downloadInfo) {
        long j3 = this.D;
        long j16 = downloadInfo.D;
        if (j3 > j16) {
            return 1;
        }
        if (j3 == j16) {
            return 0;
        }
        return -1;
    }

    public String s() {
        if (TextUtils.isEmpty(this.f390013d)) {
            this.f390013d = q(this.f390014e);
        }
        z();
        return this.f390013d;
    }

    public int t() {
        long j3 = this.G;
        if (j3 <= 0) {
            return 0;
        }
        return (int) ((this.F * 100) / j3);
    }

    public String toString() {
        return "DownloadInfo{downloadTicket='" + this.f390013d + "', downloadURL='" + this.f390014e + "', fileSize=" + this.f390018m + ", fileMd5='" + this.C + "', fileName='" + this.f390015f + "', fileAbsPath='" + this.f390017i + "', fileRootDir='" + this.f390016h + "', createTime=" + this.D + ", costTime=" + this.E + ", receivedLength=" + this.F + ", totalLength=" + this.G + ", errorCode=" + this.H + ", errorMsg='" + this.I + "', priority=" + this.J + ", scene='" + this.K + "', pauseOnMobile=" + this.L + ", downloadState=" + this.M + ", extraInfo='" + this.N + "', uniqueId='" + this.P + "', lastSaveTimeStamp=" + this.Q + ", lastUpdateTimeStamp=" + this.R + ", averageSpeed=" + this.S + ", realTimeSpeed=" + this.T + '}';
    }

    public boolean v() {
        if (this.M == 4 && w()) {
            return true;
        }
        return false;
    }

    public boolean w() {
        if (TextUtils.isEmpty(this.f390017i) || !new File(this.f390017i).exists()) {
            return false;
        }
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f390013d);
        parcel.writeString(this.f390014e);
        parcel.writeString(this.f390015f);
        parcel.writeString(this.f390016h);
        parcel.writeString(this.f390017i);
        parcel.writeLong(this.f390018m);
        parcel.writeString(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
        parcel.writeLong(this.F);
        parcel.writeLong(this.G);
        parcel.writeInt(this.H);
        parcel.writeString(this.I);
        parcel.writeInt(this.J);
        parcel.writeString(this.K);
        parcel.writeByte(this.L ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.M);
        parcel.writeString(this.N);
        parcel.writeString(this.P);
        parcel.writeLong(this.Q);
        parcel.writeLong(this.R);
        parcel.writeInt(this.S);
        parcel.writeInt(this.T);
        parcel.writeString(this.U);
    }

    public void x() {
        this.P = "";
        s();
    }

    public void y(String str) {
        this.f390013d = str;
    }

    protected DownloadInfo(Parcel parcel) {
        this.f390013d = "";
        this.f390014e = "";
        this.f390015f = "";
        this.f390016h = "";
        this.f390017i = "";
        this.f390018m = 0L;
        this.C = "";
        this.D = 0L;
        this.E = 0L;
        this.H = 0;
        this.I = "";
        this.J = 1;
        this.K = "";
        this.L = false;
        this.M = 0;
        this.N = "";
        this.P = "";
        this.Q = 0L;
        this.R = 0L;
        this.U = "unknown";
        this.f390013d = parcel.readString();
        this.f390014e = parcel.readString();
        this.f390015f = parcel.readString();
        this.f390016h = parcel.readString();
        this.f390017i = parcel.readString();
        this.f390018m = parcel.readLong();
        this.C = parcel.readString();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
        this.F = parcel.readLong();
        this.G = parcel.readLong();
        this.H = parcel.readInt();
        this.I = parcel.readString();
        this.J = parcel.readInt();
        this.K = parcel.readString();
        this.L = parcel.readByte() != 0;
        this.M = parcel.readInt();
        this.N = parcel.readString();
        this.P = parcel.readString();
        this.Q = parcel.readLong();
        this.R = parcel.readLong();
        this.S = parcel.readInt();
        this.T = parcel.readInt();
        this.U = parcel.readString();
    }
}
