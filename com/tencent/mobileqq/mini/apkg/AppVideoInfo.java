package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AppVideoInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<AppVideoInfo> CREATOR = new Parcelable.Creator<AppVideoInfo>() { // from class: com.tencent.mobileqq.mini.apkg.AppVideoInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppVideoInfo createFromParcel(Parcel parcel) {
            return new AppVideoInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppVideoInfo[] newArray(int i3) {
            return new AppVideoInfo[i3];
        }
    };
    public ArrayList<AppMediaInfo> pics;
    public AppMediaInfo video;

    public AppVideoInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.video = (AppMediaInfo) parcel.readParcelable(AppMediaInfo.class.getClassLoader());
        this.pics = parcel.createTypedArrayList(AppMediaInfo.CREATOR);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeParcelable(this.video, i3);
        parcel.writeTypedList(this.pics);
    }

    protected AppVideoInfo(Parcel parcel) {
        this.video = (AppMediaInfo) parcel.readParcelable(AppMediaInfo.class.getClassLoader());
        this.pics = parcel.createTypedArrayList(AppMediaInfo.CREATOR);
    }

    public AppVideoInfo(AppMediaInfo appMediaInfo, ArrayList<AppMediaInfo> arrayList) {
        this.video = appMediaInfo;
        this.pics = arrayList;
    }
}
