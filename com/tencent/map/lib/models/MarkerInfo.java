package com.tencent.map.lib.models;

import android.support.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class MarkerInfo {
    public static final int TYPE_2D_GEO_ANGLE = 0;
    public static final int TYPE_2D_SCREEN_ANGLE = 1;
    public static final int TYPE_2D_UI = 2;
    public static final int TYPE_3D = 3;
    private int iconHeight;
    private String iconName;
    private int iconWidth;
    private double latitude;
    private double longitude;
    private SubMarkerInfo mSubMarkerInfo;
    private int priority;
    private int type = 1;
    private float anchorX = 0.5f;
    private float anchorY = 0.5f;
    private float angle = 0.0f;
    private float alpha = 1.0f;
    private float scaleX = 1.0f;
    private float scaleY = 1.0f;
    private boolean avoidAnnotation = false;
    private boolean interactive = true;
    private int displayLevel = 0;
    private boolean forceLoad = true;
    private int minScaleLevel = 0;
    private int maxScaleLevel = 30;
    private boolean visibility = true;
    private boolean avoidOtherMarker = false;

    MarkerInfo() {
    }

    public MarkerInfo alpha(float f16) {
        this.alpha = f16;
        return this;
    }

    public MarkerInfo anchor(float f16, float f17) {
        this.anchorX = f16;
        this.anchorY = f17;
        return this;
    }

    public MarkerInfo avoidAnnotation(boolean z16) {
        this.avoidAnnotation = z16;
        return this;
    }

    public MarkerInfo avoidOtherMarker(boolean z16) {
        this.avoidOtherMarker = z16;
        return this;
    }

    public MarkerInfo displayLevel(int i3) {
        this.displayLevel = i3;
        return this;
    }

    public MarkerInfo forceLoad(boolean z16) {
        this.forceLoad = z16;
        return this;
    }

    public MarkerInfo iconHeight(int i3) {
        this.iconHeight = i3;
        return this;
    }

    public MarkerInfo iconName(String str) {
        this.iconName = str;
        return this;
    }

    public MarkerInfo iconWidth(int i3) {
        this.iconWidth = i3;
        return this;
    }

    public MarkerInfo interactive(boolean z16) {
        this.interactive = z16;
        return this;
    }

    public MarkerInfo maxScaleLevel(int i3) {
        this.maxScaleLevel = i3;
        return this;
    }

    public MarkerInfo minScaleLevel(int i3) {
        this.minScaleLevel = i3;
        return this;
    }

    public MarkerInfo position(double d16, double d17) {
        this.latitude = d16;
        this.longitude = d17;
        return this;
    }

    public MarkerInfo priority(int i3) {
        this.priority = i3;
        return this;
    }

    public MarkerInfo rotation(float f16) {
        this.angle = f16;
        return this;
    }

    public MarkerInfo scale(float f16, float f17) {
        this.scaleX = f16;
        this.scaleY = f17;
        return this;
    }

    public MarkerInfo subMarkerInfo(SubMarkerInfo subMarkerInfo) {
        this.mSubMarkerInfo = subMarkerInfo;
        return this;
    }

    public String toString() {
        return "MarkerInfo{type=" + this.type + ", iconName='" + this.iconName + "', latitude=" + this.latitude + ", longitude=" + this.longitude + ", anchorX=" + this.anchorX + ", anchorY=" + this.anchorY + ", angle=" + this.angle + ", alpha=" + this.alpha + ", scaleX=" + this.scaleX + ", scaleY=" + this.scaleY + ", avoidAnnotation=" + this.avoidAnnotation + ", interactive=" + this.interactive + ", displayLevel=" + this.displayLevel + ", priority=" + this.priority + ", forceLoad=" + this.forceLoad + ", minScaleLevel=" + this.minScaleLevel + ", maxScaleLevel=" + this.maxScaleLevel + ", visibility=" + this.visibility + ", avoidOtherMarker=" + this.avoidOtherMarker + ", iconWidth=" + this.iconWidth + ", iconHeight=" + this.iconHeight + ", mSubMarkerInfo=" + this.mSubMarkerInfo + '}';
    }

    public MarkerInfo type(int i3) {
        this.type = i3;
        return this;
    }

    public MarkerInfo visible(boolean z16) {
        this.visibility = z16;
        return this;
    }

    public MarkerInfo(double d16, double d17, String str) {
        this.latitude = d16;
        this.longitude = d17;
        this.iconName = str;
    }
}
