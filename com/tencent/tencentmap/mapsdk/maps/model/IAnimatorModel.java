package com.tencent.tencentmap.mapsdk.maps.model;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface IAnimatorModel {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public interface IAnimatorEndListener {
        void onAnimatorEnd();
    }

    float getRotation();

    void setPosition(LatLng latLng);

    void setRotation(float f16);
}
