package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProStPoiInfoV2 implements Serializable {
    public int distance;
    public int districtCode;
    public int hotValue;
    public int poiNum;
    public int poiOrderType;
    public int poiType;
    long serialVersionUID = 1;
    public String poiId = "";
    public String name = "";
    public String typeName = "";
    public String address = "";
    public GProStGPSV2 gps = new GProStGPSV2();
    public String phone = "";
    public String country = "";
    public String province = "";
    public String city = "";
    public String defaultName = "";
    public String district = "";
    public String dianPingId = "";
    public String distanceText = "";
    public String displayName = "";

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getDefaultName() {
        return this.defaultName;
    }

    public String getDianPingId() {
        return this.dianPingId;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public int getDistance() {
        return this.distance;
    }

    public String getDistanceText() {
        return this.distanceText;
    }

    public String getDistrict() {
        return this.district;
    }

    public int getDistrictCode() {
        return this.districtCode;
    }

    public GProStGPSV2 getGps() {
        return this.gps;
    }

    public int getHotValue() {
        return this.hotValue;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPoiId() {
        return this.poiId;
    }

    public int getPoiNum() {
        return this.poiNum;
    }

    public int getPoiOrderType() {
        return this.poiOrderType;
    }

    public int getPoiType() {
        return this.poiType;
    }

    public String getProvince() {
        return this.province;
    }

    public String getTypeName() {
        return this.typeName;
    }

    public String toString() {
        return "GProStPoiInfoV2{poiId=" + this.poiId + ",name=" + this.name + ",poiType=" + this.poiType + ",typeName=" + this.typeName + ",address=" + this.address + ",districtCode=" + this.districtCode + ",gps=" + this.gps + ",distance=" + this.distance + ",hotValue=" + this.hotValue + ",phone=" + this.phone + ",country=" + this.country + ",province=" + this.province + ",city=" + this.city + ",poiNum=" + this.poiNum + ",poiOrderType=" + this.poiOrderType + ",defaultName=" + this.defaultName + ",district=" + this.district + ",dianPingId=" + this.dianPingId + ",distanceText=" + this.distanceText + ",displayName=" + this.displayName + ",}";
    }
}
