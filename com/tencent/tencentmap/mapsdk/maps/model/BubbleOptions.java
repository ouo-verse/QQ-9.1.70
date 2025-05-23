package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;

/* compiled from: P */
/* loaded from: classes26.dex */
public class BubbleOptions {
    private String mContent;
    private View mContentView;
    private Marker mMarker;
    private LatLng mPosition;
    private int mMarkerWidth = 0;
    private int mMarkerHeight = 0;
    private float mMarkerAnchorU = 0.5f;
    private float mMarkerAnchorV = 0.5f;
    private int mDisplayLevel = 0;
    private Drawable[] mBackground = null;
    private boolean mOnTapHidden = false;

    public BubbleOptions background(Drawable[] drawableArr) {
        this.mBackground = drawableArr;
        return this;
    }

    public BubbleOptions content(String str) {
        this.mContent = str;
        return this;
    }

    public BubbleOptions contentView(View view) {
        this.mContentView = view;
        return this;
    }

    public BubbleOptions displayLevel(int i3) {
        if (i3 < 0) {
            i3 = 0;
        }
        this.mDisplayLevel = i3;
        return this;
    }

    public Drawable[] getBackground() {
        return this.mBackground;
    }

    public String getContent() {
        return this.mContent;
    }

    public View getContentView() {
        return this.mContentView;
    }

    public int getDisplayLevel() {
        return this.mDisplayLevel;
    }

    public Marker getMarker() {
        return this.mMarker;
    }

    public float getMarkerAnchorU() {
        return this.mMarkerAnchorU;
    }

    public float getMarkerAnchorV() {
        return this.mMarkerAnchorV;
    }

    public int getMarkerHeight() {
        return this.mMarkerHeight;
    }

    public int getMarkerWidth() {
        return this.mMarkerWidth;
    }

    public boolean getOnTapHidden() {
        return this.mOnTapHidden;
    }

    public LatLng getPosition() {
        return this.mPosition;
    }

    public BubbleOptions marker(Marker marker) {
        this.mMarker = marker;
        position(marker.getPosition());
        markerAnchor(marker.getAnchorU(), marker.getAnchorV());
        return this;
    }

    public BubbleOptions markerAnchor(float f16, float f17) {
        this.mMarkerAnchorU = f16;
        this.mMarkerAnchorV = f17;
        return this;
    }

    public BubbleOptions markerSize(int i3, int i16) {
        this.mMarkerWidth = i3;
        this.mMarkerHeight = i16;
        return this;
    }

    public BubbleOptions position(LatLng latLng) {
        this.mPosition = latLng;
        return this;
    }

    public BubbleOptions setOnTapHidden(boolean z16) {
        this.mOnTapHidden = z16;
        return this;
    }

    public BubbleOptions background(Bitmap[] bitmapArr) {
        if (bitmapArr != null) {
            this.mBackground = new Drawable[4];
            int length = bitmapArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                this.mBackground[i3] = new BitmapDrawable(bitmapArr[i3]);
            }
        }
        return this;
    }
}
