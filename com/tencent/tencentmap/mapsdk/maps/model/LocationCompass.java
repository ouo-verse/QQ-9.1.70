package com.tencent.tencentmap.mapsdk.maps.model;

/* compiled from: P */
/* loaded from: classes26.dex */
public class LocationCompass {
    private BitmapDescriptor compassImage;
    private BitmapDescriptor[] mGroupIcons;

    public LocationCompass(BitmapDescriptor bitmapDescriptor, BitmapDescriptor[] bitmapDescriptorArr) {
        this.compassImage = bitmapDescriptor;
        this.mGroupIcons = bitmapDescriptorArr;
    }

    public BitmapDescriptor[] getCompassGroupImages() {
        return this.mGroupIcons;
    }

    public BitmapDescriptor getCompassImage() {
        return this.compassImage;
    }

    public void setCompassGroupImage(BitmapDescriptor[] bitmapDescriptorArr) {
        if (bitmapDescriptorArr != null && bitmapDescriptorArr.length == 4) {
            this.mGroupIcons = bitmapDescriptorArr;
        }
    }

    public void setCompassImage(BitmapDescriptor bitmapDescriptor) {
        this.compassImage = bitmapDescriptor;
    }
}
