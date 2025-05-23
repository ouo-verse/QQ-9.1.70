package com.tencent.tmassistant.appinfo.data;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes26.dex */
public class AppDetail implements Parcelable {
    public static final Parcelable.Creator<AppDetail> CREATOR = new a();
    public String apkDownUrl;
    public long apkId;
    public String apkMd5;
    public long appId;
    public String appName;
    public String channelId;
    public long fileSize;
    public String iconUrl;
    public String packageName;
    public String signatureMd5;
    public int versionCode;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements Parcelable.Creator<AppDetail> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppDetail createFromParcel(Parcel parcel) {
            return new AppDetail(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AppDetail[] newArray(int i3) {
            return new AppDetail[i3];
        }
    }

    public AppDetail() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "appId=" + this.appId + "\napkId=" + this.apkId + "\nappName=" + this.appName + "\niconUrl=" + this.iconUrl + "\npackageName=" + this.packageName + "\nversionCode=" + this.versionCode + "\nsignatureMd5=" + this.signatureMd5 + "\napkMd5=" + this.apkMd5 + "\nfileSize=" + this.fileSize + "\napkDownUrl=" + this.apkDownUrl + "\nchannelId=" + this.channelId + "\n";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.appId);
        parcel.writeLong(this.apkId);
        parcel.writeString(this.appName);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.packageName);
        parcel.writeInt(this.versionCode);
        parcel.writeString(this.signatureMd5);
        parcel.writeString(this.apkMd5);
        parcel.writeLong(this.fileSize);
        parcel.writeString(this.apkDownUrl);
        parcel.writeString(this.channelId);
    }

    protected AppDetail(Parcel parcel) {
        this.appId = parcel.readLong();
        this.apkId = parcel.readLong();
        this.appName = parcel.readString();
        this.iconUrl = parcel.readString();
        this.packageName = parcel.readString();
        this.versionCode = parcel.readInt();
        this.signatureMd5 = parcel.readString();
        this.apkMd5 = parcel.readString();
        this.fileSize = parcel.readLong();
        this.apkDownUrl = parcel.readString();
        this.channelId = parcel.readString();
    }
}
