package com.tencent.tencentmap.mapsdk.maps.model;

/* compiled from: P */
/* loaded from: classes26.dex */
public class LocationNavigationGravityline {
    private int color;
    private LatLng destination;
    private float width;

    public LocationNavigationGravityline(float f16, int i3, LatLng latLng) {
        this.width = f16;
        this.color = i3;
        this.destination = latLng;
    }

    public int getColor() {
        return this.color;
    }

    public LatLng getDestination() {
        return this.destination;
    }

    public float getWidth() {
        return this.width;
    }

    public void setColor(int i3) {
        this.color = i3;
    }

    public void setDestination(LatLng latLng) {
        this.destination = latLng;
    }

    public void setWidth(float f16) {
        this.width = f16;
    }
}
