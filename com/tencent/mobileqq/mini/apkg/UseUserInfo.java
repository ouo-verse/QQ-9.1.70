package com.tencent.mobileqq.mini.apkg;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes33.dex */
public class UseUserInfo implements Parcelable, Serializable {
    public static final Parcelable.Creator<UseUserInfo> CREATOR = new Parcelable.Creator<UseUserInfo>() { // from class: com.tencent.mobileqq.mini.apkg.UseUserInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UseUserInfo createFromParcel(Parcel parcel) {
            UseUserInfo useUserInfo = new UseUserInfo();
            useUserInfo.uin = parcel.readString();
            useUserInfo.avatar = parcel.readString();
            useUserInfo.nick = parcel.readString();
            return useUserInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UseUserInfo[] newArray(int i3) {
            return new UseUserInfo[i3];
        }
    };
    public String avatar;
    public String nick;
    public String uin;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UseUserInfo{uin='" + this.uin + "', avatar='" + this.avatar + "', nick=" + this.nick + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.uin);
        parcel.writeString(this.avatar);
        parcel.writeString(this.nick);
    }
}
