package com.tencent.tencentmap.mapsdk.maps.model;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class ArcOptions {
    LatLng mEndLatLng;
    LatLng mPassLatLng;
    boolean mShowArrow;
    LatLng mStartLatLng;
    int mStrokeColor;
    float mAngle = 0.0f;
    float mWidth = 5.0f;
    float mStrokeWidth = 0.0f;
    int mColor = -16777216;

    public final ArcOptions angle(float f16) {
        this.mAngle = f16;
        return this;
    }

    public final ArcOptions color(int i3) {
        this.mColor = i3;
        return this;
    }

    public final float getAngle() {
        return this.mAngle;
    }

    public final int getColor() {
        return this.mColor;
    }

    public final LatLng getEndLatLng() {
        return this.mEndLatLng;
    }

    public final LatLng getPassLatLng() {
        return this.mPassLatLng;
    }

    public final LatLng getStartLatLng() {
        return this.mStartLatLng;
    }

    public final int getStrokeColor() {
        return this.mStrokeColor;
    }

    public final float getStrokeWidth() {
        return this.mStrokeWidth;
    }

    public final float getWidth() {
        return this.mWidth;
    }

    public final boolean isShowArrow() {
        return this.mShowArrow;
    }

    public final ArcOptions pass(LatLng latLng) {
        this.mPassLatLng = latLng;
        return this;
    }

    public final ArcOptions points(LatLng latLng, LatLng latLng2) {
        this.mStartLatLng = latLng;
        this.mEndLatLng = latLng2;
        return this;
    }

    public final ArcOptions showArrow(boolean z16) {
        this.mShowArrow = z16;
        return this;
    }

    public final ArcOptions strokeColor(int i3) {
        this.mStrokeColor = i3;
        return this;
    }

    public final ArcOptions strokeWidth(float f16) {
        this.mStrokeWidth = f16;
        return this;
    }

    public final String toString() {
        return "ArcOptions{mStartLatLng=" + this.mStartLatLng + ", mPassLatLng=" + this.mPassLatLng + ", mEndLatLng=" + this.mEndLatLng + ", mAngle=" + this.mAngle + ", mWidth=" + this.mWidth + ", mStrokeWidth=" + this.mStrokeWidth + ", mStrokeColor=" + this.mStrokeColor + ", mColor=" + this.mColor + ", mShowArrow=" + this.mShowArrow + '}';
    }

    public final ArcOptions width(float f16) {
        this.mWidth = f16;
        return this;
    }
}
