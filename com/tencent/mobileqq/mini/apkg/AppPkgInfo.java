package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* loaded from: classes33.dex */
public class AppPkgInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<AppPkgInfo> CREATOR = new Parcelable.Creator<AppPkgInfo>() { // from class: com.tencent.mobileqq.mini.apkg.AppPkgInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppPkgInfo createFromParcel(Parcel parcel) {
            return new AppPkgInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppPkgInfo[] newArray(int i3) {
            return new AppPkgInfo[i3];
        }
    };
    public String name;

    public AppPkgInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.name = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.name);
    }

    public AppPkgInfo(String str) {
        this.name = str;
    }

    protected AppPkgInfo(Parcel parcel) {
        this.name = parcel.readString();
    }
}
