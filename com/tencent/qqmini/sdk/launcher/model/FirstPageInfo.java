package com.tencent.qqmini.sdk.launcher.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* loaded from: classes23.dex */
public class FirstPageInfo implements Parcelable {
    public static final Parcelable.Creator<FirstPageInfo> CREATOR = new Parcelable.Creator<FirstPageInfo>() { // from class: com.tencent.qqmini.sdk.launcher.model.FirstPageInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FirstPageInfo createFromParcel(Parcel parcel) {
            FirstPageInfo firstPageInfo = new FirstPageInfo();
            firstPageInfo.pagePath = parcel.readString();
            firstPageInfo.subPkgName = parcel.readString();
            return firstPageInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FirstPageInfo[] newArray(int i3) {
            return new FirstPageInfo[i3];
        }
    };
    public String pagePath;
    public String subPkgName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FirstPageInfo)) {
            return false;
        }
        FirstPageInfo firstPageInfo = (FirstPageInfo) obj;
        return TextUtils.equals(firstPageInfo.pagePath, this.pagePath) && TextUtils.equals(firstPageInfo.subPkgName, this.subPkgName);
    }

    public String getPagePath() {
        return this.pagePath;
    }

    public String getSubPkgName() {
        return this.subPkgName;
    }

    public void setPagePath(String str) {
        this.pagePath = str;
    }

    public void setSubPkgName(String str) {
        this.subPkgName = str;
    }

    public String toString() {
        return "{pagePath='" + this.pagePath + "', subPkgName='" + this.subPkgName + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.pagePath);
        parcel.writeString(this.subPkgName);
    }

    public static boolean equals(FirstPageInfo firstPageInfo, FirstPageInfo firstPageInfo2) {
        if (firstPageInfo == firstPageInfo2) {
            return true;
        }
        if (firstPageInfo != null) {
            return firstPageInfo.equals(firstPageInfo2);
        }
        return false;
    }
}
