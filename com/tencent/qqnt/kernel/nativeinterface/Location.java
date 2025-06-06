package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class Location {
    public String city;
    public String country;
    public String province;
    public String zone;

    public Location() {
        this.country = "";
        this.province = "";
        this.city = "";
        this.zone = "";
    }

    public String getCity() {
        return this.city;
    }

    public String getCountry() {
        return this.country;
    }

    public String getProvince() {
        return this.province;
    }

    public String getZone() {
        return this.zone;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setCountry(String str) {
        this.country = str;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setZone(String str) {
        this.zone = str;
    }

    public Location(String str, String str2, String str3, String str4) {
        this.country = str;
        this.province = str2;
        this.city = str3;
        this.zone = str4;
    }
}
