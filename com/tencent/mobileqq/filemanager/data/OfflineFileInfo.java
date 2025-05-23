package com.tencent.mobileqq.filemanager.data;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes12.dex */
public class OfflineFileInfo implements Parcelable {
    public static final Parcelable.Creator<OfflineFileInfo> CREATOR = new a();
    public long C;
    public long D;
    public long E;
    public String F;
    public String G;
    private int H;

    /* renamed from: d, reason: collision with root package name */
    public boolean f207720d;

    /* renamed from: e, reason: collision with root package name */
    public String f207721e;

    /* renamed from: f, reason: collision with root package name */
    public String f207722f;

    /* renamed from: h, reason: collision with root package name */
    public long f207723h;

    /* renamed from: i, reason: collision with root package name */
    public int f207724i;

    /* renamed from: m, reason: collision with root package name */
    public String f207725m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements Parcelable.Creator<OfflineFileInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public OfflineFileInfo createFromParcel(Parcel parcel) {
            return new OfflineFileInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public OfflineFileInfo[] newArray(int i3) {
            return new OfflineFileInfo[i3];
        }
    }

    public OfflineFileInfo() {
        this.H = 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "bSend[" + this.f207720d + "]strUuid[" + this.f207721e + "]uFriendUin[" + this.f207723h + "]nDangerLv[" + this.f207724i + "]strFileName[" + this.f207725m + "]nFileSize[" + this.C + "]nLiftTime[" + this.D + "]nUploadTime[" + this.E + "]md5[" + this.F + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        if (this.f207720d) {
            this.H = 2;
        } else {
            this.H = 1;
        }
        parcel.writeInt(this.H);
        parcel.writeString(this.f207721e);
        parcel.writeLong(this.f207723h);
        parcel.writeInt(this.f207724i);
        parcel.writeString(this.f207725m);
        parcel.writeLong(this.C);
        parcel.writeLong(this.D);
        parcel.writeLong(this.E);
        parcel.writeString(this.G);
        parcel.writeString(this.F);
    }

    public OfflineFileInfo(Parcel parcel) {
        this.H = 1;
        this.H = parcel.readInt();
        this.f207721e = parcel.readString();
        this.f207723h = parcel.readLong();
        this.f207724i = parcel.readInt();
        this.f207725m = parcel.readString();
        this.C = parcel.readLong();
        this.D = parcel.readLong();
        this.E = parcel.readLong();
        this.G = parcel.readString();
        this.F = parcel.readString();
        if (this.H == 2) {
            this.f207720d = true;
        } else {
            this.f207720d = false;
        }
    }
}
