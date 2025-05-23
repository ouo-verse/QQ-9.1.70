package com.tencent.mobileqq.nearby.now.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LocationInfo implements Parcelable, Cloneable, Serializable {
    public static final Parcelable.Creator<LocationInfo> CREATOR = new a();
    public String address;
    public String city;
    boolean isForeign;
    public String lat;
    public String lng;
    public String name;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<LocationInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public LocationInfo createFromParcel(Parcel parcel) {
            return new LocationInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public LocationInfo[] newArray(int i3) {
            return new LocationInfo[i3];
        }
    }

    public LocationInfo(LocationInfo locationInfo) {
        this.lng = "";
        this.lat = "";
        this.city = "";
        this.address = "";
        this.name = "";
        this.isForeign = false;
        init(locationInfo.lng, locationInfo.lat, locationInfo.city, locationInfo.name);
        setAddress(locationInfo.address);
        setForeign(locationInfo.isForeign);
    }

    private String a(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(LocationInfo locationInfo) {
        if (locationInfo == null || !getName().equals(locationInfo.getName()) || !getCity().equals(locationInfo.getCity())) {
            return false;
        }
        return true;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getLat() {
        return this.lat;
    }

    public String getLng() {
        return this.lng;
    }

    public String getName() {
        return this.name;
    }

    public String getNameOrCity() {
        if (isNameEmpty()) {
            return this.city;
        }
        return this.name;
    }

    public void init(String str, String str2, String str3, String str4) {
        this.lng = a(str);
        this.lat = a(str2);
        this.city = a(str3);
        this.name = a(str4);
    }

    public boolean isCityEmpty() {
        return TextUtils.isEmpty(this.city);
    }

    public boolean isForeign() {
        return this.isForeign;
    }

    public boolean isNameEmpty() {
        return getName().equals("");
    }

    public boolean isOnlyCity() {
        if (!TextUtils.isEmpty(this.city) && TextUtils.isEmpty(this.name) && TextUtils.isEmpty(this.address)) {
            return true;
        }
        return false;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setForeign(boolean z16) {
        this.isForeign = z16;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "LocationInfo{lng='" + this.lng + "', lat='" + this.lat + "', city='" + this.city + "', address='" + this.address + "', name='" + this.name + "', isForeign=" + this.isForeign + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.lng);
        parcel.writeString(this.lat);
        parcel.writeString(this.city);
        parcel.writeString(this.address);
        parcel.writeString(this.name);
        parcel.writeByte(this.isForeign ? (byte) 1 : (byte) 0);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public LocationInfo m207clone() throws CloneNotSupportedException {
        return (LocationInfo) super.clone();
    }

    public LocationInfo() {
        this.lng = "";
        this.lat = "";
        this.city = "";
        this.address = "";
        this.name = "";
        this.isForeign = false;
    }

    protected LocationInfo(Parcel parcel) {
        this.lng = "";
        this.lat = "";
        this.city = "";
        this.address = "";
        this.name = "";
        this.isForeign = false;
        this.lng = parcel.readString();
        this.lat = parcel.readString();
        this.city = parcel.readString();
        this.address = parcel.readString();
        this.name = parcel.readString();
        this.isForeign = parcel.readByte() != 0;
    }
}
