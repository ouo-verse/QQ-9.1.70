package com.tencent.mobileqq.filemanager.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes12.dex */
public class ForwardFileInfo implements Parcelable {
    public static final Parcelable.Creator<ForwardFileInfo> CREATOR = new a();
    private String C;
    private String D;
    private int E;
    private String F;
    private long G;
    private String H;
    private String I;
    private WeiYunFileInfo J;
    private ArrayList<Long> K;
    public int L;
    public int M;
    private String N;
    private int P;
    private int Q;

    /* renamed from: d, reason: collision with root package name */
    private int f207714d;

    /* renamed from: e, reason: collision with root package name */
    private int f207715e;

    /* renamed from: f, reason: collision with root package name */
    private String f207716f;

    /* renamed from: h, reason: collision with root package name */
    private long f207717h;

    /* renamed from: i, reason: collision with root package name */
    private long f207718i;

    /* renamed from: m, reason: collision with root package name */
    private long f207719m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements Parcelable.Creator<ForwardFileInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ForwardFileInfo createFromParcel(Parcel parcel) {
            return new ForwardFileInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ForwardFileInfo[] newArray(int i3) {
            return new ForwardFileInfo[i3];
        }
    }

    public ForwardFileInfo() {
        this.M = 0;
        C("");
        Z("");
        y("");
        E(-1L);
        x("");
        N(this.f207714d);
        M("");
    }

    private boolean a(ForwardFileInfo forwardFileInfo) {
        if (f().equals(forwardFileInfo.f()) && g() == forwardFileInfo.g() && getType() == forwardFileInfo.getType()) {
            return true;
        }
        return false;
    }

    public void A(int i3) {
        this.Q = i3;
    }

    public void B(long j3) {
        this.f207719m = j3;
    }

    public void C(String str) {
        this.f207716f = str;
    }

    public void D(String str) {
        this.N = str;
    }

    public void E(long j3) {
        this.f207717h = j3;
    }

    public void F(ArrayList<Long> arrayList) {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.K = arrayList;
    }

    public void G(String str) {
        this.I = str;
    }

    public void M(String str) {
        this.H = str;
    }

    public void N(int i3) {
        this.f207714d = i3;
    }

    public void V(long j3) {
        this.f207718i = j3;
    }

    public void Z(String str) {
        this.C = str;
    }

    public void a0(int i3) {
        this.E = i3;
    }

    public int b() {
        return this.P;
    }

    public void b0(WeiYunFileInfo weiYunFileInfo) {
        this.J = weiYunFileInfo;
    }

    public int c() {
        return this.f207715e;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.D;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof ForwardFileInfo)) {
            return a((ForwardFileInfo) obj);
        }
        return false;
    }

    public String f() {
        return this.F;
    }

    public long g() {
        return this.G;
    }

    public int getType() {
        return this.f207714d;
    }

    public int hashCode() {
        return (f() + g()).hashCode();
    }

    public int j() {
        return this.Q;
    }

    public long k() {
        return this.f207719m;
    }

    public String l() {
        return this.f207716f;
    }

    public String m() {
        return this.N;
    }

    public long n() {
        return this.f207717h;
    }

    public ArrayList<Long> o() {
        if (this.K == null) {
            this.K = new ArrayList<>();
        }
        return this.K;
    }

    public String p() {
        return this.I;
    }

    public String q() {
        return this.H;
    }

    public long r() {
        return this.f207718i;
    }

    public String s() {
        return this.C;
    }

    public int t() {
        return this.E;
    }

    public String toString() {
        return "type[" + this.f207714d + "], cloudTYpe[" + this.f207715e + "], sessionId[" + this.f207717h + "], uniseq[" + this.f207718i + "], uuid[" + this.C + "], fileId[" + this.D + "], weiYunSrcType[" + this.E + "], uuidTroopFile[" + this.H + "], localPath[" + this.f207716f + "], friendUin[" + this.f207719m + "], fileName[" + this.F + "], fileSize[" + this.G + "], thumbPath[" + this.I + "], wyFileInfo[" + this.J + "], forwardID[" + this.L + "], fromFile[" + this.M + "], selfUin[" + this.N + "], busId[" + this.P;
    }

    public WeiYunFileInfo u() {
        return this.J;
    }

    public void v(int i3) {
        this.P = i3;
    }

    public void w(int i3) {
        this.f207715e = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(getType());
        parcel.writeLong(n());
        parcel.writeLong(g());
        parcel.writeString(l());
        parcel.writeString(s());
        parcel.writeString(e());
        parcel.writeInt(t());
        parcel.writeString(f());
        parcel.writeLong(k());
        parcel.writeInt(c());
        parcel.writeLong(r());
        parcel.writeString(q());
        parcel.writeString(p());
        parcel.writeInt(j());
        parcel.writeParcelable(u(), i3);
        parcel.writeList(this.K);
        parcel.writeString(m());
        parcel.writeInt(b());
        parcel.writeInt(this.M);
    }

    public void x(String str) {
        this.D = str;
    }

    public void y(String str) {
        this.F = str;
    }

    public void z(long j3) {
        this.G = j3;
    }

    ForwardFileInfo(Parcel parcel) {
        this.M = 0;
        N(parcel.readInt());
        E(parcel.readLong());
        z(parcel.readLong());
        C(parcel.readString());
        Z(parcel.readString());
        x(parcel.readString());
        a0(parcel.readInt());
        y(parcel.readString());
        B(parcel.readLong());
        w(parcel.readInt());
        V(parcel.readLong());
        M(parcel.readString());
        G(parcel.readString());
        A(parcel.readInt());
        b0((WeiYunFileInfo) parcel.readParcelable(WeiYunFileInfo.class.getClassLoader()));
        F(parcel.readArrayList(Long.class.getClassLoader()));
        D(parcel.readString());
        v(parcel.readInt());
        this.M = parcel.readInt();
    }
}
