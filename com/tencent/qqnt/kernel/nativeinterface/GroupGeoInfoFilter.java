package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GroupGeoInfoFilter {
    public int cityId;
    public int geoContent;
    public int latitude;
    public int longitude;
    public int ownerUid;
    public int poiId;
    public int setTime;

    public int getCityId() {
        return this.cityId;
    }

    public int getGeoContent() {
        return this.geoContent;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getOwnerUid() {
        return this.ownerUid;
    }

    public int getPoiId() {
        return this.poiId;
    }

    public int getSetTime() {
        return this.setTime;
    }

    public String toString() {
        return "GroupGeoInfoFilter{ownerUid=" + this.ownerUid + ",setTime=" + this.setTime + ",cityId=" + this.cityId + ",longitude=" + this.longitude + ",latitude=" + this.latitude + ",geoContent=" + this.geoContent + ",poiId=" + this.poiId + ",}";
    }
}
