package org.light.datasource;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.JsonObject;
import com.huawei.hms.support.feature.result.CommonConstant;

/* compiled from: P */
/* loaded from: classes29.dex */
public class LightLocationDataSourceValue extends LightBaseDataSourceValue {
    public static final Parcelable.Creator<LightLocationDataSourceValue> CREATOR = new Parcelable.Creator<LightLocationDataSourceValue>() { // from class: org.light.datasource.LightLocationDataSourceValue.1
        @Override // android.os.Parcelable.Creator
        public LightLocationDataSourceValue createFromParcel(Parcel parcel) {
            return new LightLocationDataSourceValue(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public LightLocationDataSourceValue[] newArray(int i3) {
            return new LightLocationDataSourceValue[i3];
        }
    };
    private String address;
    private String city;
    private String country;
    private String displayName;
    private String district;
    private String latitude;
    private String longitude;
    private String poiName;
    private String province;
    private String road;
    private String town;
    private String village;

    public LightLocationDataSourceValue() {
        this.address = "";
        this.country = "";
        this.province = "";
        this.city = "";
        this.longitude = "";
        this.latitude = "";
        this.town = "";
        this.village = "";
        this.district = "";
        this.road = "";
        this.displayName = "";
        this.poiName = "";
        this.type = "LocationDataSourceValue";
    }

    @Override // org.light.datasource.LightBaseDataSourceValue, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public String getDistrict() {
        return this.district;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getPoiName() {
        return this.poiName;
    }

    public String getProvince() {
        return this.province;
    }

    public String getRoad() {
        return this.road;
    }

    public String getTown() {
        return this.town;
    }

    public String getVillage() {
        return this.village;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setDisplayName(String str) {
        this.displayName = str;
    }

    public void setDistrict(String str) {
        this.district = str;
    }

    public void setLatitude(String str) {
        this.latitude = str;
    }

    public void setLongitude(String str) {
        this.longitude = str;
    }

    public void setPoiName(String str) {
        this.poiName = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setRoad(String str) {
        this.road = str;
    }

    public void setTown(String str) {
        this.town = str;
    }

    public void setVillage(String str) {
        this.village = str;
    }

    @Override // org.light.datasource.LightBaseDataSourceValue
    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", this.type);
        jsonObject.addProperty("address", this.address);
        jsonObject.addProperty("country", this.country);
        jsonObject.addProperty("province", this.province);
        jsonObject.addProperty("city", this.city);
        jsonObject.addProperty("longitude", this.longitude);
        jsonObject.addProperty("latitude", this.latitude);
        jsonObject.addProperty("town", this.town);
        jsonObject.addProperty("village", this.village);
        jsonObject.addProperty("district", this.district);
        jsonObject.addProperty("road", this.road);
        jsonObject.addProperty(CommonConstant.KEY_DISPLAY_NAME, this.displayName);
        jsonObject.addProperty("poiName", this.poiName);
        return jsonObject;
    }

    @Override // org.light.datasource.LightBaseDataSourceValue, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeString(this.address);
        parcel.writeString(this.country);
        parcel.writeString(this.province);
        parcel.writeString(this.city);
        parcel.writeString(this.longitude);
        parcel.writeString(this.latitude);
        parcel.writeString(this.town);
        parcel.writeString(this.village);
        parcel.writeString(this.district);
        parcel.writeString(this.road);
        parcel.writeString(this.displayName);
        parcel.writeString(this.poiName);
    }

    protected LightLocationDataSourceValue(Parcel parcel) {
        super(parcel);
        this.address = "";
        this.country = "";
        this.province = "";
        this.city = "";
        this.longitude = "";
        this.latitude = "";
        this.town = "";
        this.village = "";
        this.district = "";
        this.road = "";
        this.displayName = "";
        this.poiName = "";
        this.address = parcel.readString();
        this.country = parcel.readString();
        this.province = parcel.readString();
        this.city = parcel.readString();
        this.longitude = parcel.readString();
        this.latitude = parcel.readString();
        this.town = parcel.readString();
        this.village = parcel.readString();
        this.district = parcel.readString();
        this.road = parcel.readString();
        this.displayName = parcel.readString();
        this.poiName = parcel.readString();
    }
}
