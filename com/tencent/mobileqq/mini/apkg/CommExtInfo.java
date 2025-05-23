package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public class CommExtInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<CommExtInfo> CREATOR = new Parcelable.Creator<CommExtInfo>() { // from class: com.tencent.mobileqq.mini.apkg.CommExtInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommExtInfo createFromParcel(Parcel parcel) {
            CommExtInfo commExtInfo = new CommExtInfo();
            commExtInfo.mapInfo = parcel.readHashMap(Map.class.getClassLoader());
            commExtInfo.attachInfo = parcel.readString();
            return commExtInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CommExtInfo[] newArray(int i3) {
            return new CommExtInfo[i3];
        }
    };
    public String attachInfo;
    public Map<String, String> mapInfo;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "CommExtInfo{mapInfo='" + this.mapInfo + ", attachInfo='" + this.attachInfo + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeMap(this.mapInfo);
        parcel.writeString(this.attachInfo);
    }
}
