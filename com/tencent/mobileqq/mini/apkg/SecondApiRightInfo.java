package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes33.dex */
public class SecondApiRightInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<SecondApiRightInfo> CREATOR = new Parcelable.Creator<SecondApiRightInfo>() { // from class: com.tencent.mobileqq.mini.apkg.SecondApiRightInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SecondApiRightInfo createFromParcel(Parcel parcel) {
            SecondApiRightInfo secondApiRightInfo = new SecondApiRightInfo();
            secondApiRightInfo.apiName = parcel.readString();
            secondApiRightInfo.secondName = parcel.readString();
            secondApiRightInfo.right = parcel.readInt();
            return secondApiRightInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SecondApiRightInfo[] newArray(int i3) {
            return new SecondApiRightInfo[i3];
        }
    };
    public String apiName;
    public int right;
    public String secondName;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "SecondApiRightInfo{apiName='" + this.apiName + "', secondName='" + this.secondName + "', right=" + this.right + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.apiName);
        parcel.writeString(this.secondName);
        parcel.writeInt(this.right);
    }
}
