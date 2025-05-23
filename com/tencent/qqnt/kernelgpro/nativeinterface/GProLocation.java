package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProLocation {
    public String city;
    public int cityId;
    public String cityZone;
    public int cityZoneId;
    public String country;
    public int countryId;
    public String province;
    public int provinceId;

    public GProLocation() {
        this.country = "";
        this.province = "";
        this.city = "";
        this.cityZone = "";
    }

    public String getCity() {
        return this.city;
    }

    public int getCityId() {
        return this.cityId;
    }

    public String getCityZone() {
        return this.cityZone;
    }

    public int getCityZoneId() {
        return this.cityZoneId;
    }

    public String getCountry() {
        return this.country;
    }

    public int getCountryId() {
        return this.countryId;
    }

    public String getProvince() {
        return this.province;
    }

    public int getProvinceId() {
        return this.provinceId;
    }

    public String toString() {
        return "GProLocation{countryId=" + this.countryId + ",provinceId=" + this.provinceId + ",cityId=" + this.cityId + ",cityZoneId=" + this.cityZoneId + ",country=" + this.country + ",province=" + this.province + ",city=" + this.city + ",cityZone=" + this.cityZone + ",}";
    }

    public GProLocation(int i3, int i16, int i17, int i18, String str, String str2, String str3, String str4) {
        this.countryId = i3;
        this.provinceId = i16;
        this.cityId = i17;
        this.cityZoneId = i18;
        this.country = str;
        this.province = str2;
        this.city = str3;
        this.cityZone = str4;
    }
}
