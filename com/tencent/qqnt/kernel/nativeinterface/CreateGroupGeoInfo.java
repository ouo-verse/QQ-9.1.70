package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class CreateGroupGeoInfo {
    public int cityId;
    public long latitude;
    public long longtitude;
    public long poiId;
    public byte[] stringGeoContent = new byte[0];

    public int getCityId() {
        return this.cityId;
    }

    public long getLatitude() {
        return this.latitude;
    }

    public long getLongtitude() {
        return this.longtitude;
    }

    public long getPoiId() {
        return this.poiId;
    }

    public byte[] getStringGeoContent() {
        return this.stringGeoContent;
    }

    public String toString() {
        return "CreateGroupGeoInfo{cityId=" + this.cityId + ",longtitude=" + this.longtitude + ",latitude=" + this.latitude + ",stringGeoContent=" + this.stringGeoContent + ",poiId=" + this.poiId + ",}";
    }
}
