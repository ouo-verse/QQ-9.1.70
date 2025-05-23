package com.tencent.tencentmap.mapsdk.maps.model;

/* loaded from: classes26.dex */
public class MapPoi {
    private double latitude;
    private double longitude;
    public String name;
    public String poiId;
    public LatLng position;

    public MapPoi() {
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public String getName() {
        return this.name;
    }

    public String getPoiId() {
        return this.poiId;
    }

    public LatLng getPosition() {
        return this.position;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPosition(LatLng latLng) {
        this.position = latLng;
        this.latitude = latLng.getLatitude();
        this.longitude = latLng.getLongitude();
    }

    public MapPoi(double d16, double d17) {
        this.latitude = d16;
        this.longitude = d17;
        this.position = new LatLng(d16, d17);
    }

    public MapPoi(double d16, double d17, String str) {
        this(d16, d17);
        this.name = str;
    }
}
