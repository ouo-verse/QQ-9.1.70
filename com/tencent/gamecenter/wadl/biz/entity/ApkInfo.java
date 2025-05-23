package com.tencent.gamecenter.wadl.biz.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes6.dex */
public class ApkInfo implements Parcelable {
    public static final Parcelable.Creator<ApkInfo> CREATOR = new a();
    public static final int FROM_DEF = 0;
    public static final int FROM_REGEX = 1;
    public static final int JUMP_TYPE_DOWNLOAD = 0;
    public static final int JUMP_TYPE_INTERRUPT = 1;
    public String appId;
    public String appName;
    public String channel;
    public String defUrl;
    public int from;
    public String iconUrl;
    public int jumpType;
    public String path;
    public String pkgName;
    public long pkgSize;
    public int versionCode;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class ApkPathInfo {
        public String appId;
        public int jumpType;
        public String path;
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Parcelable.Creator<ApkInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ApkInfo createFromParcel(Parcel parcel) {
            return new ApkInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ApkInfo[] newArray(int i3) {
            return new ApkInfo[i3];
        }
    }

    public ApkInfo(String str, int i3, String str2, String str3) {
        this.pkgName = str;
        this.versionCode = i3;
        this.defUrl = str2;
        this.path = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return " appId=" + this.appId + ",appName=" + this.appName + ",pkgName=" + this.pkgName + ",channel=" + this.channel + ",versionCode=" + this.versionCode + ",defUrl=" + this.defUrl + ",path=" + this.path + ",iconUrl=" + this.iconUrl + ",pkgSize=" + this.pkgSize;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        if (parcel != null) {
            parcel.writeInt(this.from);
            parcel.writeString(this.appId);
            parcel.writeString(this.appName);
            parcel.writeString(this.pkgName);
            parcel.writeString(this.channel);
            parcel.writeString(this.defUrl);
            parcel.writeString(this.path);
            parcel.writeInt(this.versionCode);
            parcel.writeString(this.iconUrl);
            parcel.writeLong(this.pkgSize);
            parcel.writeInt(this.jumpType);
        }
    }

    public ApkInfo(String str, String str2, String str3, String str4, String str5) {
        this.appId = str;
        this.appName = str2;
        this.channel = str3;
        this.pkgName = str4;
        this.defUrl = str5;
    }

    public ApkInfo(String str, String str2, String str3, String str4, String str5, String str6) {
        this(str, str2, str3, str4, str5);
        this.path = str6;
    }

    protected ApkInfo(Parcel parcel) {
        this.from = parcel.readInt();
        this.appId = parcel.readString();
        this.appName = parcel.readString();
        this.pkgName = parcel.readString();
        this.channel = parcel.readString();
        this.defUrl = parcel.readString();
        this.path = parcel.readString();
        this.versionCode = parcel.readInt();
        this.iconUrl = parcel.readString();
        this.pkgSize = parcel.readLong();
        this.jumpType = parcel.readInt();
    }
}
