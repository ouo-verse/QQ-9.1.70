package com.tencent.map.lib.models;

import android.support.annotation.Keep;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class GLModelInfo extends OverlayListenerInfo {
    private static final float DEFAULT_MAX_OPACITY = 1.0f;
    private static final int DEFAULT_MAX_ZOOM = 22;
    private static final float DEFAULT_MIN_OPACITY = 0.0f;
    private static final int DEFAULT_MIN_ZOOM = 3;
    protected double mAltitude;
    protected int mCoordType;
    protected LatLngBounds mLatLngBounds;
    protected String mModelFilePath;
    protected LatLng mPosition;
    protected float mRotationX;
    protected float mRotationY;
    protected float mRotationZ;
    protected double mScale = 1.0d;
    protected int mAnimate = 0;
    protected int mMinZoom = 3;
    protected int mMaxZoom = 22;
    protected float opacity = 1.0f;
    protected int level = 1;
    protected int zIndex = 0;
    protected boolean visible = true;
    protected float exposure = 1.0f;
    protected boolean buildingHidden = true;
    protected boolean clickEnabled = false;
    protected int mPixelWidth = 64;
    protected int mPixelHeight = 64;
    protected boolean unlit = false;

    public void enableClick(boolean z16) {
        this.clickEnabled = z16;
    }

    public float getExposure() {
        return this.exposure;
    }

    public LatLng getPosition() {
        return this.mPosition;
    }

    public float getRotationX() {
        return this.mRotationX;
    }

    public float getRotationY() {
        return this.mRotationY;
    }

    public float getRotationZ() {
        return this.mRotationZ;
    }

    public double getScale() {
        return this.mScale;
    }

    public boolean getUnlit() {
        return this.unlit;
    }

    public boolean isClickEnabled() {
        return this.clickEnabled;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public void setCoordType(int i3) {
        this.mCoordType = i3;
    }

    public void setExposure(float f16) {
        this.exposure = f16;
    }

    public void setLevel(int i3) {
        if (i3 == 1 || i3 == 2) {
            this.level = i3;
        }
    }

    public void setMaxZoom(int i3) {
        if (i3 <= 22) {
            this.mMaxZoom = i3;
        } else {
            this.mMaxZoom = 22;
        }
    }

    public void setMinZoom(int i3) {
        if (i3 >= 3) {
            this.mMinZoom = i3;
        } else {
            this.mMinZoom = 3;
        }
    }

    public void setModelPosition(LatLng latLng) {
        this.mPosition = latLng;
        this.mAltitude = latLng.getAltitude();
    }

    public void setOpacity(float f16) {
        if (f16 > 1.0f) {
            this.opacity = 1.0f;
        } else if (f16 < 0.0f) {
            this.opacity = 0.0f;
        } else {
            this.opacity = f16;
        }
    }

    public void setPixelBound(int i3, int i16) {
        this.mPixelWidth = i3;
        this.mPixelHeight = i16;
    }

    public void setRotationX(float f16) {
        this.mRotationX = f16;
    }

    public void setRotationY(float f16) {
        this.mRotationY = f16;
    }

    public void setRotationZ(float f16) {
        this.mRotationZ = f16;
    }

    public void setScale(float f16) {
        this.mScale = f16;
    }

    public void setUnlit(boolean z16) {
        this.unlit = z16;
    }

    public void setVisible(boolean z16) {
        this.visible = z16;
    }

    public void setZoomLevelRange(int i3, int i16) {
        if (i3 <= i16) {
            setMinZoom(i3);
            setMaxZoom(i16);
        }
    }

    public void setzIndex(int i3) {
        this.zIndex = i3;
    }
}
