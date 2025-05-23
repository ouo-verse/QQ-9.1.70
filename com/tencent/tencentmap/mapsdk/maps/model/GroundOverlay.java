package com.tencent.tencentmap.mapsdk.maps.model;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface GroundOverlay {
    void remove();

    void setAlpha(float f16);

    void setAnchor(float f16, float f17);

    void setBitmap(BitmapDescriptor bitmapDescriptor);

    void setLatLongBounds(LatLngBounds latLngBounds);

    void setLevel(int i3);

    void setPosition(LatLng latLng);

    void setVisibility(boolean z16);

    void setZindex(int i3);

    void setZoom(float f16);
}
