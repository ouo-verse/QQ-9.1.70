package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;

/* compiled from: P */
/* loaded from: classes28.dex */
public class WeishiUserInfo implements Parcelable {
    public static final Parcelable.Creator<WeishiUserInfo> CREATOR = new Parcelable.Creator<WeishiUserInfo>() { // from class: cooperation.qzone.model.WeishiUserInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeishiUserInfo createFromParcel(Parcel parcel) {
            WeishiUserInfo weishiUserInfo = new WeishiUserInfo();
            weishiUserInfo.uin = parcel.readLong();
            weishiUserInfo.nickName = parcel.readString();
            weishiUserInfo.logo = parcel.readString();
            return weishiUserInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WeishiUserInfo[] newArray(int i3) {
            return new WeishiUserInfo[i3];
        }
    };
    public String logo;
    public String nickName;
    public long uin;

    public WeishiUserInfo() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.uin);
        parcel.writeString(this.nickName);
        parcel.writeString(this.logo);
    }

    public WeishiUserInfo(long j3, String str) {
        this.uin = j3;
        this.nickName = str;
    }
}
