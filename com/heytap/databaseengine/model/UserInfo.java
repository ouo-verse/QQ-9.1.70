package com.heytap.databaseengine.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.Objects;

/* compiled from: P */
@Keep
/* loaded from: classes2.dex */
public class UserInfo implements Parcelable {
    public static final String BIRTHDAY_DEFAULT = "1990-06-01";
    public static final long CREATE_TIME_DEFAULT = 1;
    public static final Parcelable.Creator<UserInfo> CREATOR = new Parcelable.Creator<UserInfo>() { // from class: com.heytap.databaseengine.model.UserInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserInfo createFromParcel(Parcel parcel) {
            return new UserInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserInfo[] newArray(int i3) {
            return new UserInfo[i3];
        }
    };
    public static final String HEIGHT_DEFAULT = "1700";
    public static final String SEX_DEFAULT = "M";
    public static final String SEX_FEMALE = "F";
    public static final String SEX_MALE = "M";
    public static final String WEIGHT_DEFAULT = "60000";
    private String accountName;
    private int age;
    private String avatar;
    private String birthday;
    private String country;
    private long createTime;
    private int guideStatus;
    private String height;
    private int insertDataType;
    private long modifiedTime;
    private String sex;
    private String ssoid;
    private String status;
    private boolean uploadAvatar;
    private String userId;
    private String userName;
    private boolean userNameNeedModify;
    private String weight;

    public UserInfo(UserInfo userInfo) {
        this.ssoid = userInfo.getSsoid();
        this.userId = userInfo.getUserId();
        this.userName = userInfo.getUserName();
        this.accountName = userInfo.getAccountName();
        this.userNameNeedModify = userInfo.isUserNameNeedModify();
        this.country = userInfo.getCountry();
        this.status = userInfo.getStatus();
        this.birthday = userInfo.getBirthday();
        this.sex = userInfo.getSex();
        this.uploadAvatar = userInfo.isUploadAvatar();
        this.avatar = userInfo.getAvatar();
        this.height = userInfo.getHeight();
        this.weight = userInfo.getWeight();
        this.createTime = userInfo.getCreateTime();
        this.insertDataType = userInfo.getInsertDataType();
        this.modifiedTime = userInfo.getModifiedTime();
        this.guideStatus = userInfo.getGuideStatus();
        this.age = userInfo.getAge();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        UserInfo userInfo = (UserInfo) obj;
        if (this.userNameNeedModify == userInfo.userNameNeedModify && this.uploadAvatar == userInfo.uploadAvatar && this.createTime == userInfo.createTime && this.insertDataType == userInfo.insertDataType && this.modifiedTime == userInfo.modifiedTime && this.age == userInfo.age && Objects.equals(this.ssoid, userInfo.ssoid) && Objects.equals(this.userId, userInfo.userId) && Objects.equals(this.userName, userInfo.userName) && Objects.equals(this.accountName, userInfo.accountName) && Objects.equals(this.country, userInfo.country) && Objects.equals(this.status, userInfo.status) && Objects.equals(this.birthday, userInfo.birthday) && Objects.equals(this.sex, userInfo.sex) && Objects.equals(this.avatar, userInfo.avatar) && Objects.equals(this.height, userInfo.height) && Objects.equals(this.weight, userInfo.weight)) {
            return true;
        }
        return false;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public int getAge() {
        return this.age;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getBirthday() {
        return this.birthday;
    }

    public String getCountry() {
        return this.country;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public int getGuideStatus() {
        return this.guideStatus;
    }

    public String getHeight() {
        return this.height;
    }

    public int getInsertDataType() {
        return this.insertDataType;
    }

    public long getModifiedTime() {
        return this.modifiedTime;
    }

    public String getSex() {
        return this.sex;
    }

    public String getSsoid() {
        return this.ssoid;
    }

    public String getStatus() {
        return this.status;
    }

    public String getUserId() {
        return this.userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return Objects.hash(this.ssoid, this.userId, this.userName, this.accountName, Boolean.valueOf(this.userNameNeedModify), this.country, this.status, this.birthday, this.sex, Boolean.valueOf(this.uploadAvatar), this.avatar, this.height, this.weight, Long.valueOf(this.createTime), Integer.valueOf(this.insertDataType), Long.valueOf(this.modifiedTime), Integer.valueOf(this.age));
    }

    public boolean isUploadAvatar() {
        return this.uploadAvatar;
    }

    public boolean isUserNameNeedModify() {
        return this.userNameNeedModify;
    }

    public void setAccountName(String str) {
        this.accountName = str;
    }

    public void setAge(int i3) {
        this.age = i3;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setBirthday(String str) {
        this.birthday = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setCreateTime(long j3) {
        this.createTime = j3;
    }

    public void setGuideStatus(int i3) {
        this.guideStatus = i3;
    }

    public void setHeight(String str) {
        this.height = str;
    }

    public void setInsertDataType(int i3) {
        this.insertDataType = i3;
    }

    public void setModifiedTime(long j3) {
        this.modifiedTime = j3;
    }

    public void setSex(String str) {
        this.sex = str;
    }

    public void setSsoid(String str) {
        this.ssoid = str;
    }

    public void setStatus(String str) {
        this.status = str;
    }

    public void setUploadAvatar(boolean z16) {
        this.uploadAvatar = z16;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setUserNameNeedModify(boolean z16) {
        this.userNameNeedModify = z16;
    }

    public void setWeight(String str) {
        this.weight = str;
    }

    public String toString() {
        return "UserInfo{ssoid='" + this.ssoid + "', userId='" + this.userId + "', userName='" + this.userName + "', accountName='" + this.accountName + "', userNameNeedModify=" + this.userNameNeedModify + ", country='" + this.country + "', status='" + this.status + "', birthday='" + this.birthday + "', sex='" + this.sex + "', uploadAvatar=" + this.uploadAvatar + ", avatar='" + this.avatar + "', height=" + this.height + "', weight=" + this.weight + "', createTime=" + this.createTime + ", insertDataType=" + this.insertDataType + ", modifiedTime=" + this.modifiedTime + ", guideStatus=" + this.guideStatus + ", age=" + this.age + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.ssoid);
        parcel.writeString(this.userId);
        parcel.writeString(this.userName);
        parcel.writeString(this.accountName);
        parcel.writeByte(this.userNameNeedModify ? (byte) 1 : (byte) 0);
        parcel.writeString(this.country);
        parcel.writeString(this.status);
        parcel.writeString(this.birthday);
        parcel.writeString(this.sex);
        parcel.writeByte(this.uploadAvatar ? (byte) 1 : (byte) 0);
        parcel.writeString(this.avatar);
        parcel.writeString(this.height);
        parcel.writeString(this.weight);
        parcel.writeLong(this.createTime);
        parcel.writeInt(this.insertDataType);
        parcel.writeLong(this.modifiedTime);
        parcel.writeInt(this.guideStatus);
        parcel.writeInt(this.age);
    }

    public UserInfo() {
    }

    protected UserInfo(Parcel parcel) {
        this.ssoid = parcel.readString();
        this.userId = parcel.readString();
        this.userName = parcel.readString();
        this.accountName = parcel.readString();
        this.userNameNeedModify = parcel.readByte() != 0;
        this.country = parcel.readString();
        this.status = parcel.readString();
        this.birthday = parcel.readString();
        this.sex = parcel.readString();
        this.uploadAvatar = parcel.readByte() != 0;
        this.avatar = parcel.readString();
        this.height = parcel.readString();
        this.weight = parcel.readString();
        this.createTime = parcel.readLong();
        this.insertDataType = parcel.readInt();
        this.modifiedTime = parcel.readLong();
        this.guideStatus = parcel.readInt();
        this.age = parcel.readInt();
    }
}
