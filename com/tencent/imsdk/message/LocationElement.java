package com.tencent.imsdk.message;

/* compiled from: P */
/* loaded from: classes7.dex */
public class LocationElement extends MessageBaseElement {
    private String description;
    private double latitude;
    private double longitude;

    public LocationElement() {
        setElementType(7);
    }

    public String getDescription() {
        return this.description;
    }

    public double getLatitude() {
        return this.latitude;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public void setDescription(String str) {
        this.description = str;
    }

    public void setLatitude(double d16) {
        this.latitude = d16;
    }

    public void setLongitude(double d16) {
        this.longitude = d16;
    }
}
