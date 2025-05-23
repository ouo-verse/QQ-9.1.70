package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes23.dex */
public class SubPkgInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<SubPkgInfo> CREATOR = new Parcelable.Creator<SubPkgInfo>() { // from class: com.tencent.qqmini.sdk.launcher.model.SubPkgInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SubPkgInfo createFromParcel(Parcel parcel) {
            SubPkgInfo subPkgInfo = new SubPkgInfo();
            subPkgInfo.subPkgName = parcel.readString();
            subPkgInfo.downloadUrl = parcel.readString();
            subPkgInfo.independent = parcel.readInt();
            subPkgInfo.fileSize = parcel.readInt();
            subPkgInfo.version = parcel.readString();
            subPkgInfo.versionId = parcel.readString();
            subPkgInfo.mainPackVersion = parcel.readString();
            subPkgInfo.subVersionType = parcel.readString();
            return subPkgInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SubPkgInfo[] newArray(int i3) {
            return new SubPkgInfo[i3];
        }
    };
    public String downloadUrl;
    public int independent;
    public String subPkgName;
    public int fileSize = -1;
    public String version = "";
    public String versionId = "";
    public String mainPackVersion = "";
    public String subVersionType = "0";
    public String preFetchConfig = "";

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDownloadUrl() {
        return this.downloadUrl;
    }

    public int getIndependent() {
        return this.independent;
    }

    public String getPreFetchConfig() {
        return this.preFetchConfig;
    }

    public String getPureSubPkgName() {
        String str = this.subPkgName;
        if (str == null) {
            return "";
        }
        return str.replaceAll("/", "");
    }

    public String getSubPkgName() {
        return this.subPkgName;
    }

    public String getVersion() {
        return this.version;
    }

    public String getVersionId() {
        return this.versionId;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setIndependent(int i3) {
        this.independent = i3;
    }

    public void setPreFetchConfig(String str) {
        this.preFetchConfig = str;
    }

    public void setSubPkgName(String str) {
        this.subPkgName = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setVersionId(String str) {
        this.versionId = str;
    }

    public String toString() {
        return "SubPkgInfo{subPkgName='" + this.subPkgName + "', downloadUrl='" + this.downloadUrl + "', independent=" + this.independent + ", fileSize=" + this.fileSize + ", version=" + this.version + ", versionId=" + this.versionId + ", mainPackVersion=" + this.mainPackVersion + ", subVersionType=" + this.subVersionType + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.subPkgName);
        parcel.writeString(this.downloadUrl);
        parcel.writeInt(this.independent);
        parcel.writeInt(this.fileSize);
        parcel.writeString(this.version);
        parcel.writeString(this.versionId);
        parcel.writeString(this.mainPackVersion);
        parcel.writeString(this.subVersionType);
    }
}
