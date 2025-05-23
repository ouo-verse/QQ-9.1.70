package com.tencent.map.lib.models;

import android.graphics.Rect;
import android.support.annotation.Keep;

/* compiled from: P */
@Keep
/* loaded from: classes9.dex */
public class IntersectionOverlayInfo {
    protected Rect mBounds;
    protected byte[] mData;
    protected String mDayStyleFilePath;
    protected int mDistance;
    protected boolean mIsDarkMode;
    protected String mNightStyleFilePath;
    protected boolean mVisibility = true;
    protected boolean mRoundedCorner = false;

    public void enableDarkMode(boolean z16) {
        this.mIsDarkMode = z16;
    }

    public void enableRoundedCorner(boolean z16) {
        this.mRoundedCorner = z16;
    }

    public void setBounds(Rect rect) {
        this.mBounds = rect;
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    public void setDistance(int i3) {
        this.mDistance = i3;
    }

    public void setVisibility(boolean z16) {
        this.mVisibility = z16;
    }
}
