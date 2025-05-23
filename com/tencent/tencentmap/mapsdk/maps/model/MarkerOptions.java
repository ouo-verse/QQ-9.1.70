package com.tencent.tencentmap.mapsdk.maps.model;

import android.os.Parcel;
import android.support.annotation.NonNull;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes26.dex */
public class MarkerOptions {
    private boolean bFlat;
    private BitmapDescriptor bitmapDesctor;
    private boolean boDragable;
    private boolean boInfoWindowEnable;
    private boolean boVisible;
    private String contentDescription;
    private float fAlpha;
    private float fAngle;
    private float fanchorU;
    private float fanchorV;
    private int iLevel;
    private boolean mClockwise;
    private MarkerCollisionItem[] mCollisions;
    private int mIconLooperDuration;
    private boolean mIconLooperEnable;
    private IndoorInfo mIndoorInfo;
    private float mInfowindowAnchorU;
    private float mInfowindowAnchorV;
    private int mInfowindowOffsetX;
    private int mInfowindowOffsetY;
    private boolean mIsFastLoad;
    private boolean mIsViewInfowindow;
    private Object mTag;
    private LatLng mlatlng;
    private String strSnippet;
    private String strtitle;
    private MarkerCollisionRelation thisCollisionRelation;
    private MarkerCollisionItem[] thisInfoWindowCollisions;
    private float zIndex;

    public MarkerOptions(@NonNull LatLng latLng) {
        this.strtitle = "";
        this.fAngle = 0.0f;
        this.fAlpha = 1.0f;
        this.zIndex = 0.0f;
        this.boInfoWindowEnable = true;
        this.bFlat = false;
        this.mClockwise = true;
        this.mInfowindowAnchorU = 0.5f;
        this.mInfowindowAnchorV = 1.0f;
        this.mInfowindowOffsetX = 0;
        this.mInfowindowOffsetY = 0;
        this.mIsFastLoad = true;
        this.mIsViewInfowindow = false;
        this.iLevel = 2;
        this.mIconLooperDuration = 500;
        this.mCollisions = new MarkerCollisionItem[0];
        this.thisCollisionRelation = MarkerCollisionRelation.ALONE;
        this.fanchorU = 0.5f;
        this.fanchorV = 0.5f;
        this.boVisible = true;
        this.mlatlng = latLng;
    }

    public MarkerOptions alpha(float f16) {
        this.fAlpha = f16;
        return this;
    }

    public MarkerOptions anchor(float f16, float f17) {
        this.fanchorU = f16;
        this.fanchorV = f17;
        return this;
    }

    public MarkerOptions clockwise(boolean z16) {
        this.mClockwise = z16;
        return this;
    }

    public MarkerOptions collisionBy(MarkerCollisionItem... markerCollisionItemArr) {
        this.mCollisions = markerCollisionItemArr;
        return this;
    }

    public MarkerOptions contentDescription(String str) {
        this.contentDescription = str;
        return this;
    }

    public MarkerOptions draggable(boolean z16) {
        this.boDragable = z16;
        return this;
    }

    public MarkerOptions fastLoad(boolean z16) {
        this.mIsFastLoad = z16;
        return this;
    }

    public MarkerOptions flat(boolean z16) {
        this.bFlat = z16;
        return this;
    }

    public float getAlpha() {
        return this.fAlpha;
    }

    public float getAnchorU() {
        return this.fanchorU;
    }

    public float getAnchorV() {
        return this.fanchorV;
    }

    public MarkerCollisionRelation getCollisionRelation() {
        return this.thisCollisionRelation;
    }

    public MarkerCollisionItem[] getCollisions() {
        return this.mCollisions;
    }

    public String getContentDescription() {
        return this.contentDescription;
    }

    public BitmapDescriptor getIcon() {
        return this.bitmapDesctor;
    }

    public int getIconLooperDuration() {
        return this.mIconLooperDuration;
    }

    public IndoorInfo getIndoorInfo() {
        return this.mIndoorInfo;
    }

    public float getInfoWindowAnchorU() {
        return this.mInfowindowAnchorU;
    }

    public float getInfoWindowAnchorV() {
        return this.mInfowindowAnchorV;
    }

    public MarkerCollisionItem[] getInfoWindowCollisions() {
        return this.thisInfoWindowCollisions;
    }

    public int getInfoWindowOffsetX() {
        return this.mInfowindowOffsetX;
    }

    public int getInfowindowOffsetY() {
        return this.mInfowindowOffsetY;
    }

    public int getLevel() {
        return this.iLevel;
    }

    public LatLng getPosition() {
        return this.mlatlng;
    }

    public float getRotation() {
        return this.fAngle;
    }

    public String getSnippet() {
        return this.strSnippet;
    }

    public Object getTag() {
        return this.mTag;
    }

    public String getTitle() {
        return this.strtitle;
    }

    public float getZIndex() {
        return this.zIndex;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.bitmapDesctor = bitmapDescriptor;
        return this;
    }

    public MarkerOptions iconLooper(boolean z16) {
        this.mIconLooperEnable = z16;
        return this;
    }

    public MarkerOptions indoorInfo(IndoorInfo indoorInfo) {
        this.mIndoorInfo = indoorInfo;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float f16, float f17) {
        this.mInfowindowAnchorU = f16;
        this.mInfowindowAnchorV = f17;
        return this;
    }

    public MarkerOptions infoWindowCollisionBy(MarkerCollisionItem... markerCollisionItemArr) {
        this.thisInfoWindowCollisions = markerCollisionItemArr;
        return this;
    }

    public MarkerOptions infoWindowEnable(boolean z16) {
        this.boInfoWindowEnable = z16;
        return this;
    }

    public MarkerOptions infoWindowOffset(int i3, int i16) {
        this.mInfowindowOffsetX = i3;
        this.mInfowindowOffsetY = i16;
        return this;
    }

    public boolean isClockwise() {
        return this.mClockwise;
    }

    public boolean isDraggable() {
        return this.boDragable;
    }

    public boolean isFastLoad() {
        return this.mIsFastLoad;
    }

    public boolean isFlat() {
        return this.bFlat;
    }

    public boolean isIconLooperEnable() {
        return this.mIconLooperEnable;
    }

    public boolean isInfoWindowEnable() {
        return this.boInfoWindowEnable;
    }

    public boolean isViewInfowindow() {
        return this.mIsViewInfowindow;
    }

    public boolean isVisible() {
        return this.boVisible;
    }

    public MarkerOptions level(int i3) {
        if (i3 >= 0 && i3 <= 2) {
            this.iLevel = i3;
        }
        return this;
    }

    public MarkerOptions position(LatLng latLng) {
        this.mlatlng = latLng;
        return this;
    }

    public MarkerOptions rotation(float f16) {
        this.fAngle = f16;
        return this;
    }

    public MarkerOptions setCollisionRelation(MarkerCollisionRelation markerCollisionRelation) {
        this.thisCollisionRelation = markerCollisionRelation;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.strSnippet = str;
        return this;
    }

    public MarkerOptions tag(Object obj) {
        this.mTag = obj;
        return this;
    }

    public MarkerOptions title(String str) {
        this.strtitle = str;
        return this;
    }

    public String toString() {
        return "MarkerOptions{mlatlng=" + this.mlatlng + ", strtitle='" + this.strtitle + "', strSnippet='" + this.strSnippet + "', bitmapDesctor=" + this.bitmapDesctor + ", fanchorU=" + this.fanchorU + ", fanchorV=" + this.fanchorV + ", boDragable=" + this.boDragable + ", boVisible=" + this.boVisible + ", fAngle=" + this.fAngle + ", fAlpha=" + this.fAlpha + ", zIndex=" + this.zIndex + ", mTag=" + this.mTag + ", contentDescription='" + this.contentDescription + "', mIndoorInfo=" + this.mIndoorInfo + ", boInfoWindowEnable=" + this.boInfoWindowEnable + ", bFlat=" + this.bFlat + ", mClockwise=" + this.mClockwise + ", mInfowindowAnchorU=" + this.mInfowindowAnchorU + ", mInfowindowAnchorV=" + this.mInfowindowAnchorV + ", mInfowindowOffsetX=" + this.mInfowindowOffsetX + ", mInfowindowOffsetY=" + this.mInfowindowOffsetY + ", mIsFastLoad=" + this.mIsFastLoad + ", mIsViewInfowindow=" + this.mIsViewInfowindow + ", iLevel=" + this.iLevel + ", mIconLooperEnable=" + this.mIconLooperEnable + ", mIconLooperDuration=" + this.mIconLooperDuration + ", mCollisions=" + Arrays.toString(this.mCollisions) + ", thisInfoWindowCollisions=" + Arrays.toString(this.thisInfoWindowCollisions) + ", thisCollisionRelation=" + this.thisCollisionRelation + '}';
    }

    public MarkerOptions viewInfoWindow(boolean z16) {
        this.mIsViewInfowindow = z16;
        return this;
    }

    public MarkerOptions visible(boolean z16) {
        this.boVisible = z16;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i3) {
        LatLng latLng;
        if (parcel != null && (latLng = this.mlatlng) != null) {
            parcel.writeString(latLng.toString());
        }
    }

    public MarkerOptions zIndex(float f16) {
        this.zIndex = f16;
        return this;
    }

    public MarkerOptions iconLooper(boolean z16, int i3) {
        this.mIconLooperEnable = z16;
        this.mIconLooperDuration = i3;
        return this;
    }

    @Deprecated
    public MarkerOptions() {
        this.strtitle = "";
        this.fAngle = 0.0f;
        this.fAlpha = 1.0f;
        this.zIndex = 0.0f;
        this.boInfoWindowEnable = true;
        this.bFlat = false;
        this.mClockwise = true;
        this.mInfowindowAnchorU = 0.5f;
        this.mInfowindowAnchorV = 1.0f;
        this.mInfowindowOffsetX = 0;
        this.mInfowindowOffsetY = 0;
        this.mIsFastLoad = true;
        this.mIsViewInfowindow = false;
        this.iLevel = 2;
        this.mIconLooperDuration = 500;
        this.mCollisions = new MarkerCollisionItem[0];
        this.thisCollisionRelation = MarkerCollisionRelation.ALONE;
        this.fanchorU = 0.5f;
        this.fanchorV = 0.5f;
        this.boVisible = true;
    }
}
