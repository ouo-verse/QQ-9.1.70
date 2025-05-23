package com.tencent.mobileqq.teamwork.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TeamWorkFileImportInfo implements Parcelable {
    public static final Parcelable.Creator<TeamWorkFileImportInfo> CREATOR = new a();
    public String C;
    public int D;
    public int E;
    public String F;
    public String G;
    public long H;
    public boolean I;
    public int J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean P;
    public boolean Q;
    public int R;
    public String S;
    public int T;
    public String U;
    public String V;
    public String W;
    public String X;
    public int Y;
    public int Z;

    /* renamed from: a0, reason: collision with root package name */
    public String f292067a0;

    /* renamed from: b0, reason: collision with root package name */
    public int f292068b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f292069c0;

    /* renamed from: d, reason: collision with root package name */
    public int f292070d;

    /* renamed from: d0, reason: collision with root package name */
    public String f292071d0;

    /* renamed from: e, reason: collision with root package name */
    public String f292072e;

    /* renamed from: e0, reason: collision with root package name */
    public String f292073e0;

    /* renamed from: f, reason: collision with root package name */
    public String f292074f;

    /* renamed from: f0, reason: collision with root package name */
    public boolean f292075f0;

    /* renamed from: g0, reason: collision with root package name */
    public int f292076g0;

    /* renamed from: h, reason: collision with root package name */
    public String f292077h;

    /* renamed from: h0, reason: collision with root package name */
    public long f292078h0;

    /* renamed from: i, reason: collision with root package name */
    public long f292079i;

    /* renamed from: i0, reason: collision with root package name */
    public long f292080i0;

    /* renamed from: j0, reason: collision with root package name */
    public String f292081j0;

    /* renamed from: k0, reason: collision with root package name */
    public int f292082k0;

    /* renamed from: l0, reason: collision with root package name */
    public int f292083l0;

    /* renamed from: m, reason: collision with root package name */
    public long f292084m;

    /* renamed from: m0, reason: collision with root package name */
    public String f292085m0;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements Parcelable.Creator<TeamWorkFileImportInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public TeamWorkFileImportInfo createFromParcel(Parcel parcel) {
            return new TeamWorkFileImportInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public TeamWorkFileImportInfo[] newArray(int i3) {
            return new TeamWorkFileImportInfo[i3];
        }
    }

    public TeamWorkFileImportInfo() {
        this.f292070d = -1;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = false;
        this.S = "";
    }

    public boolean a() {
        if (this.J == 8) {
            return true;
        }
        return false;
    }

    public boolean b() {
        if (this.J == 11) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.J == 7) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean e() {
        if (this.J == 13) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "TeamWorkFileImportInfo{peerType=" + this.f292070d + ", peerUin='" + this.f292072e + "', fileName='" + this.f292074f + "', filePath='" + this.f292077h + "', msgUniseq=" + this.f292079i + ", nSessionId=" + this.f292084m + ", troopFilePath='" + this.C + "', troopFileBusId=" + this.D + ", device=" + this.E + ", troopUin='" + this.F + "', isNeedDownLoadUrl=" + this.I + ", entranceFrom=" + this.J + ", isFromAIO=" + this.K + ", isFromDataLine=" + this.L + ", isOpenTeamWork=" + this.M + ", isUserClick=" + this.N + ", isMessageConvert=" + this.P + ", nFileType=" + this.R + ", folderId='" + this.S + "', retCode=" + this.T + ", errorString='" + this.U + "', redirectUrl='" + this.V + "', strSendUin='" + this.W + "', traceId='" + this.X + "', importOption=" + this.Y + ", urlType=" + this.Z + ", fileid='" + this.f292067a0 + "', filetype=" + this.f292068b0 + ", fileImportType=" + this.f292076g0 + ", fileSize=" + this.f292078h0 + ", structUniseq=" + this.f292080i0 + ", editedUrl='" + this.f292081j0 + "', srcUrl='" + this.G + "', createTime='" + this.H + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.f292070d);
        parcel.writeString(this.f292072e);
        parcel.writeString(this.f292074f);
        parcel.writeString(this.f292077h);
        parcel.writeLong(this.f292079i);
        parcel.writeLong(this.f292084m);
        parcel.writeString(this.C);
        parcel.writeInt(this.D);
        parcel.writeInt(this.E);
        parcel.writeString(this.F);
        parcel.writeByte(this.I ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.J);
        parcel.writeByte(this.K ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.L ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.M ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.N ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.P ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.Q ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.R);
        parcel.writeString(this.S);
        parcel.writeInt(this.T);
        parcel.writeString(this.U);
        parcel.writeString(this.V);
        parcel.writeString(this.W);
        parcel.writeString(this.X);
        parcel.writeInt(this.Y);
        parcel.writeInt(this.Z);
        parcel.writeString(this.f292067a0);
        parcel.writeInt(this.f292068b0);
        parcel.writeInt(this.f292076g0);
        parcel.writeLong(this.f292078h0);
        parcel.writeLong(this.f292080i0);
        parcel.writeString(this.f292081j0);
        parcel.writeString(this.G);
        parcel.writeLong(this.H);
        parcel.writeInt(this.f292083l0);
        parcel.writeString(this.f292085m0);
        parcel.writeString(this.f292071d0);
        parcel.writeString(this.f292073e0);
    }

    protected TeamWorkFileImportInfo(Parcel parcel) {
        this.f292070d = -1;
        this.L = false;
        this.M = false;
        this.N = false;
        this.P = false;
        this.S = "";
        this.f292070d = parcel.readInt();
        this.f292072e = parcel.readString();
        this.f292074f = parcel.readString();
        this.f292077h = parcel.readString();
        this.f292079i = parcel.readLong();
        this.f292084m = parcel.readLong();
        this.C = parcel.readString();
        this.D = parcel.readInt();
        this.E = parcel.readInt();
        this.F = parcel.readString();
        this.I = parcel.readByte() != 0;
        this.J = parcel.readInt();
        this.K = parcel.readByte() != 0;
        this.L = parcel.readByte() != 0;
        this.M = parcel.readByte() != 0;
        this.N = parcel.readByte() != 0;
        this.P = parcel.readByte() != 0;
        this.Q = parcel.readByte() != 0;
        this.R = parcel.readInt();
        this.S = parcel.readString();
        this.T = parcel.readInt();
        this.U = parcel.readString();
        this.V = parcel.readString();
        this.W = parcel.readString();
        this.X = parcel.readString();
        this.Y = parcel.readInt();
        this.Z = parcel.readInt();
        this.f292067a0 = parcel.readString();
        this.f292068b0 = parcel.readInt();
        this.f292076g0 = parcel.readInt();
        this.f292078h0 = parcel.readLong();
        this.f292080i0 = parcel.readLong();
        this.f292081j0 = parcel.readString();
        this.G = parcel.readString();
        this.H = parcel.readLong();
        this.f292083l0 = parcel.readInt();
        this.f292085m0 = parcel.readString();
        this.f292071d0 = parcel.readString();
        this.f292073e0 = parcel.readString();
    }
}
