package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes33.dex */
public class AppMediaInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<AppMediaInfo> CREATOR = new Parcelable.Creator<AppMediaInfo>() { // from class: com.tencent.mobileqq.mini.apkg.AppMediaInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppMediaInfo createFromParcel(Parcel parcel) {
            return new AppMediaInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppMediaInfo[] newArray(int i3) {
            return new AppMediaInfo[i3];
        }
    };
    public int appMediaType;
    public int height;
    public String url;
    public int width;

    public AppMediaInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        this.appMediaType = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.url = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.appMediaType);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeString(this.url);
    }

    protected AppMediaInfo(Parcel parcel) {
        this.appMediaType = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.url = parcel.readString();
    }

    public AppMediaInfo(int i3, int i16, int i17, String str) {
        this.appMediaType = i3;
        this.width = i16;
        this.height = i17;
        this.url = str;
    }
}
