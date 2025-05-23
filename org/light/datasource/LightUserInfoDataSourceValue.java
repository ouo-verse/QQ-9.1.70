package org.light.datasource;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonObject;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightUserInfoDataSourceValue extends LightBaseDataSourceValue {
    public static final Parcelable.Creator<LightUserInfoDataSourceValue> CREATOR = new Parcelable.Creator<LightUserInfoDataSourceValue>() { // from class: org.light.datasource.LightUserInfoDataSourceValue.1
        @Override // android.os.Parcelable.Creator
        public LightUserInfoDataSourceValue createFromParcel(Parcel parcel) {
            return new LightUserInfoDataSourceValue(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LightUserInfoDataSourceValue[] newArray(int i3) {
            return new LightUserInfoDataSourceValue[i3];
        }
    };
    private String ageLabel;
    private String avatarPath;
    private String constellationLabel;
    private String dayLabel;
    private String describeLabel;
    private String gender;
    private String locationLabel;
    private String monthLabel;
    private String nickName;
    private String settlementTimeLabel;

    public LightUserInfoDataSourceValue() {
        this.nickName = "";
        this.avatarPath = "";
        this.settlementTimeLabel = "";
        this.gender = "";
        this.locationLabel = "";
        this.describeLabel = "";
        this.constellationLabel = "";
        this.monthLabel = "";
        this.dayLabel = "";
        this.ageLabel = "";
        this.type = "UserInfoDataSourceValue";
    }

    @Override // org.light.datasource.LightBaseDataSourceValue, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAgeLabel() {
        return this.ageLabel;
    }

    public String getAvatarPath() {
        return this.avatarPath;
    }

    public String getConstellationLabel() {
        return this.constellationLabel;
    }

    public String getDayLabel() {
        return this.dayLabel;
    }

    public String getDescribeLabel() {
        return this.describeLabel;
    }

    public String getGender() {
        return this.gender;
    }

    public String getLocationLabel() {
        return this.locationLabel;
    }

    public String getMonthLabel() {
        return this.monthLabel;
    }

    public String getNickName() {
        return this.nickName;
    }

    public String getSettlementTimeLabel() {
        return this.settlementTimeLabel;
    }

    public void setAgeLabel(String str) {
        this.ageLabel = str;
    }

    public void setAvatarPath(String str) {
        this.avatarPath = str;
    }

    public void setConstellationLabel(String str) {
        this.constellationLabel = str;
    }

    public void setDayLabel(String str) {
        this.dayLabel = str;
    }

    public void setDescribeLabel(String str) {
        this.describeLabel = str;
    }

    public void setGender(String str) {
        this.gender = str;
    }

    public void setLocationLabel(String str) {
        this.locationLabel = str;
    }

    public void setMonthLabel(String str) {
        this.monthLabel = str;
    }

    public void setNickName(String str) {
        this.nickName = str;
    }

    public void setSettlementTimeLabel(String str) {
        this.settlementTimeLabel = str;
    }

    @Override // org.light.datasource.LightBaseDataSourceValue
    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", this.type);
        jsonObject.addProperty("nickName", this.nickName);
        jsonObject.addProperty("avatarPath", this.avatarPath);
        jsonObject.addProperty("settlementTimeLabel", this.settlementTimeLabel);
        jsonObject.addProperty("gender", this.gender);
        jsonObject.addProperty("locationLabel", this.locationLabel);
        jsonObject.addProperty("describeLabel", this.describeLabel);
        jsonObject.addProperty("constellationLabel", this.constellationLabel);
        jsonObject.addProperty("monthLabel", this.monthLabel);
        jsonObject.addProperty("dayLabel", this.dayLabel);
        jsonObject.addProperty("ageLabel", this.ageLabel);
        return jsonObject;
    }

    @Override // org.light.datasource.LightBaseDataSourceValue, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.nickName);
        parcel.writeString(this.avatarPath);
        parcel.writeString(this.settlementTimeLabel);
        parcel.writeString(this.gender);
        parcel.writeString(this.locationLabel);
        parcel.writeString(this.describeLabel);
        parcel.writeString(this.constellationLabel);
        parcel.writeString(this.monthLabel);
        parcel.writeString(this.dayLabel);
        parcel.writeString(this.ageLabel);
    }

    protected LightUserInfoDataSourceValue(Parcel parcel) {
        super(parcel);
        this.nickName = "";
        this.avatarPath = "";
        this.settlementTimeLabel = "";
        this.gender = "";
        this.locationLabel = "";
        this.describeLabel = "";
        this.constellationLabel = "";
        this.monthLabel = "";
        this.dayLabel = "";
        this.ageLabel = "";
        this.nickName = parcel.readString();
        this.avatarPath = parcel.readString();
        this.settlementTimeLabel = parcel.readString();
        this.gender = parcel.readString();
        this.locationLabel = parcel.readString();
        this.describeLabel = parcel.readString();
        this.constellationLabel = parcel.readString();
        this.monthLabel = parcel.readString();
        this.dayLabel = parcel.readString();
        this.ageLabel = parcel.readString();
    }
}
