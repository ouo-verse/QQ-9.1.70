package com.tencent.tencentmap.mapsdk.maps.model;

import android.os.Parcel;
import java.util.List;

/* compiled from: P */
/* loaded from: classes26.dex */
public class CircleOptions {
    private boolean boVisible;
    private CircleBorderType borderType;
    private double dRadius;
    private float fStrokeWidth;
    private int iFillColor;
    private int iLevel;
    private int iStrokeColor;
    private int iZindex;
    private LatLng latlngCenter;
    private boolean mClickable;
    private List<Integer> pattern;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public enum CircleBorderType {
        REALLINE_DEFAULT,
        DOTTEDLINE_SQUARE,
        DOTTEDLINE_CIRCLE
    }

    public CircleOptions() {
        this.iLevel = 2;
        this.latlngCenter = new LatLng(39.984253d, 116.307439d);
        this.dRadius = 1.0d;
        this.fStrokeWidth = 1.0f;
        this.iStrokeColor = -16777216;
        this.iFillColor = 0;
        this.iZindex = 0;
        this.boVisible = true;
        this.borderType = CircleBorderType.REALLINE_DEFAULT;
    }

    public CircleOptions borderType(CircleBorderType circleBorderType) {
        this.borderType = circleBorderType;
        return this;
    }

    public CircleOptions center(LatLng latLng) {
        this.latlngCenter = latLng;
        return this;
    }

    public CircleOptions clickable(boolean z16) {
        this.mClickable = z16;
        return this;
    }

    public CircleOptions fillColor(int i3) {
        this.iFillColor = i3;
        return this;
    }

    public CircleBorderType getBorderType() {
        return this.borderType;
    }

    public LatLng getCenter() {
        return this.latlngCenter;
    }

    public int getFillColor() {
        return this.iFillColor;
    }

    public int getLevel() {
        return this.iLevel;
    }

    public List<Integer> getPattern() {
        return this.pattern;
    }

    public double getRadius() {
        return this.dRadius;
    }

    public int getStrokeColor() {
        return this.iStrokeColor;
    }

    public float getStrokeWidth() {
        return this.fStrokeWidth;
    }

    public int getZIndex() {
        return this.iZindex;
    }

    public boolean isClickable() {
        return this.mClickable;
    }

    public boolean isVisible() {
        return this.boVisible;
    }

    public CircleOptions level(int i3) {
        if (i3 >= 0 && i3 <= 2) {
            this.iLevel = i3;
        }
        return this;
    }

    public CircleOptions pattern(List<Integer> list) {
        if (list != null && list.size() == 2) {
            this.pattern = list;
        }
        return this;
    }

    public CircleOptions radius(double d16) {
        this.dRadius = d16;
        return this;
    }

    public CircleOptions strokeColor(int i3) {
        this.iStrokeColor = i3;
        return this;
    }

    public CircleOptions strokeWidth(float f16) {
        if (f16 < 0.0f) {
            this.fStrokeWidth = 1.0f;
        } else {
            this.fStrokeWidth = f16;
        }
        return this;
    }

    public String toString() {
        return "CircleOptions{latlngCenter=" + this.latlngCenter + ", dRadius=" + this.dRadius + ", fStrokeWidth=" + this.fStrokeWidth + ", iStrokeColor=" + this.iStrokeColor + ", iFillColor=" + this.iFillColor + ", iZindex=" + this.iZindex + ", boVisible=" + this.boVisible + ", mClickable=" + this.mClickable + ", pattern=" + this.pattern + ", borderType=" + this.borderType + ", iLevel=" + this.iLevel + '}';
    }

    public CircleOptions visible(boolean z16) {
        this.boVisible = z16;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i3) {
        if (parcel == null) {
            return;
        }
        parcel.writeDouble(this.dRadius);
    }

    public CircleOptions zIndex(int i3) {
        this.iZindex = i3;
        return this;
    }

    CircleOptions(int i3, LatLng latLng, double d16, float f16, int i16, int i17, int i18, boolean z16) {
        this.iLevel = 2;
        new LatLng(39.984253d, 116.307439d);
        this.latlngCenter = latLng;
        this.dRadius = d16;
        this.fStrokeWidth = f16;
        this.iStrokeColor = i16;
        this.iFillColor = i17;
        this.iZindex = i18;
        this.boVisible = z16;
    }
}
