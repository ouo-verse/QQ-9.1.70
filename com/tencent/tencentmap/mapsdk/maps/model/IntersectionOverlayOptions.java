package com.tencent.tencentmap.mapsdk.maps.model;

import android.graphics.Rect;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class IntersectionOverlayOptions {
    private Rect mBounds;
    private byte[] mData;
    private String mDayStyleFilePath;
    private int mDistance;
    private String mNightStyleFilePath;
    private boolean mVisibility = true;
    private boolean mDarkMode = false;
    private boolean mRoundedCorner = false;

    public final IntersectionOverlayOptions bounds(Rect rect) {
        this.mBounds = rect;
        return this;
    }

    public final IntersectionOverlayOptions darkMode(boolean z16) {
        this.mDarkMode = z16;
        return this;
    }

    public final IntersectionOverlayOptions data(byte[] bArr) {
        this.mData = bArr;
        return this;
    }

    public final IntersectionOverlayOptions distance(int i3) {
        this.mDistance = i3;
        return this;
    }

    public final Rect getBounds() {
        return this.mBounds;
    }

    public final byte[] getData() {
        return this.mData;
    }

    public final String getDayStyleFilePath() {
        return this.mDayStyleFilePath;
    }

    public final int getDistance() {
        return this.mDistance;
    }

    public final String getNightStyleFilePath() {
        return this.mNightStyleFilePath;
    }

    public final boolean isDarkMode() {
        return this.mDarkMode;
    }

    public final boolean isRoundedCorner() {
        return this.mRoundedCorner;
    }

    public final boolean isVisibility() {
        return this.mVisibility;
    }

    public final IntersectionOverlayOptions roundedCorner(boolean z16) {
        this.mRoundedCorner = z16;
        return this;
    }

    public final IntersectionOverlayOptions setDayStyleFilePath(String str) {
        this.mDayStyleFilePath = str;
        return this;
    }

    public final IntersectionOverlayOptions setNightStyleFilePath(String str) {
        this.mNightStyleFilePath = str;
        return this;
    }

    public final IntersectionOverlayOptions visibility(boolean z16) {
        this.mVisibility = z16;
        return this;
    }
}
