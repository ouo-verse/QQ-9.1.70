package com.tencent.component.media.image.region;

import android.graphics.Rect;

/* compiled from: P */
/* loaded from: classes5.dex */
public class RegionDrawableData {
    private static final String TAG = "RegionDrawableData";
    public float mDefaultScale;
    public Rect mImageArea;
    public int mSample;
    public float mScale;
    public int mScrollDirection;
    public Rect mShowArea;
    public boolean mShowRegion;
    public int mSourceDensity;
    public int mState;
    public int mTargetDensity;
    public long mTaskTime;

    private int scaleToSampleRoundup(float f16) {
        int ceil = (int) Math.ceil(1.0f / f16);
        if (ceil > 64) {
            ceil = 64;
        }
        for (int i3 = 64; i3 != 0; i3 >>= 1) {
            int i16 = ceil & i3;
            if (i16 != 0) {
                if ((ceil & (ceil - 1)) != 0) {
                    return i16 << 1;
                }
                return i16;
            }
        }
        return 1;
    }

    public int calcSample() {
        int scaleToSampleRoundup;
        float f16 = this.mScale;
        if (f16 == 0.0f) {
            scaleToSampleRoundup = 1;
        } else {
            scaleToSampleRoundup = scaleToSampleRoundup(f16);
        }
        this.mSample = scaleToSampleRoundup;
        return scaleToSampleRoundup;
    }

    public String toString() {
        if (this.mShowArea != null && this.mImageArea != null) {
            return "onShowAreaChanged mShowArea = " + this.mShowArea + " mImageArea = " + this.mImageArea + " scale = " + this.mScale + " mDefaultScale = " + this.mDefaultScale + " sample = " + this.mSample + " mTargetDensity = " + this.mTargetDensity + " mSourceDensity = " + this.mSourceDensity + " mIsShowRegion = " + this.mShowRegion;
        }
        return super.toString();
    }
}
