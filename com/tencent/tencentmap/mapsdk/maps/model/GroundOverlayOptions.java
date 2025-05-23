package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Bitmap;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class GroundOverlayOptions {
    public static Bitmap TRANSPARENT_PIXEL = Bitmap.createBitmap(new int[]{0}, 1, 1, Bitmap.Config.ARGB_8888);
    private LatLngBounds mLatLngBounds;
    private LatLng mPosition;
    private int mZIndex;
    private BitmapDescriptor mBitmapDescriptor = BitmapDescriptorFactory.fromBitmap(TRANSPARENT_PIXEL);
    private float mZoom = 18.0f;
    private float mAnchorU = 0.5f;
    private float mAnchorV = 0.5f;
    private float mAlpha = 1.0f;
    private boolean mVisibility = true;
    private int mLevel = 1;

    public final GroundOverlayOptions alpha(float f16) {
        this.mAlpha = f16;
        return this;
    }

    public final GroundOverlayOptions anchor(float f16, float f17) {
        this.mAnchorU = f16;
        this.mAnchorV = f17;
        return this;
    }

    public final GroundOverlayOptions bitmap(BitmapDescriptor bitmapDescriptor) {
        this.mBitmapDescriptor = bitmapDescriptor;
        return this;
    }

    public final float getAlpha() {
        return this.mAlpha;
    }

    public final float getAnchorU() {
        return this.mAnchorU;
    }

    public final float getAnchorV() {
        return this.mAnchorV;
    }

    public final BitmapDescriptor getBitmap() {
        return this.mBitmapDescriptor;
    }

    public final LatLngBounds getLatLngBounds() {
        return this.mLatLngBounds;
    }

    public final int getLevel() {
        return this.mLevel;
    }

    public final LatLng getPosition() {
        return this.mPosition;
    }

    public final int getZIndex() {
        return this.mZIndex;
    }

    public final float getZoom() {
        return this.mZoom;
    }

    public final boolean isVisible() {
        return this.mVisibility;
    }

    public final GroundOverlayOptions latLngBounds(LatLngBounds latLngBounds) {
        this.mLatLngBounds = latLngBounds;
        return this;
    }

    public final GroundOverlayOptions level(int i3) {
        if (i3 >= 0 && i3 <= 2) {
            this.mLevel = i3;
        }
        return this;
    }

    public final GroundOverlayOptions position(LatLng latLng) {
        this.mPosition = latLng;
        return this;
    }

    public final String toString() {
        return "GroundOverlayOptions{mBitmapDescriptor=" + this.mBitmapDescriptor + ", mLatLngBounds=" + this.mLatLngBounds + ", mPosition=" + this.mPosition + ", mZoom=" + this.mZoom + ", mAnchorU=" + this.mAnchorU + ", mAnchorV=" + this.mAnchorV + ", mAlpha=" + this.mAlpha + ", mVisibility=" + this.mVisibility + ", mZIndex=" + this.mZIndex + ", mLevel=" + this.mLevel + '}';
    }

    public final GroundOverlayOptions visible(boolean z16) {
        this.mVisibility = z16;
        return this;
    }

    public final GroundOverlayOptions zIndex(int i3) {
        this.mZIndex = i3;
        return this;
    }

    public final GroundOverlayOptions zoom(float f16) {
        this.mZoom = f16;
        return this;
    }
}
