package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes33.dex */
public class SubPkgInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<SubPkgInfo> CREATOR = new Parcelable.Creator<SubPkgInfo>() { // from class: com.tencent.mobileqq.mini.apkg.SubPkgInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SubPkgInfo createFromParcel(Parcel parcel) {
            SubPkgInfo subPkgInfo = new SubPkgInfo();
            subPkgInfo.subPkgName = parcel.readString();
            subPkgInfo.downloadUrl = parcel.readString();
            subPkgInfo.independent = parcel.readInt();
            subPkgInfo.fileSize = parcel.readInt();
            return subPkgInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SubPkgInfo[] newArray(int i3) {
            return new SubPkgInfo[i3];
        }
    };
    public String downloadUrl;
    public int fileSize = -1;
    public int independent;
    public String subPkgName;

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

    public String getSubPkgName() {
        return this.subPkgName;
    }

    public void setDownloadUrl(String str) {
        this.downloadUrl = str;
    }

    public void setIndependent(int i3) {
        this.independent = i3;
    }

    public void setSubPkgName(String str) {
        this.subPkgName = str;
    }

    public String toString() {
        return "SubPkgInfo{subPkgName='" + this.subPkgName + "', downloadUrl='" + this.downloadUrl + "', independent=" + this.independent + ", fileSize=" + this.fileSize + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.subPkgName);
        parcel.writeString(this.downloadUrl);
        parcel.writeInt(this.independent);
        parcel.writeInt(this.fileSize);
    }
}
