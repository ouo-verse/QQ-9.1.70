package com.tencent.image;

import android.graphics.Rect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RegionDrawableData {
    static IPatchRedirector $redirector_ = null;
    public static final int REGION_STATE_NONE = 0;
    public static final int REGION_STATE_SAMPLE = 1;
    public static final int SCROLL_DIRECTION_NO = 0;
    public static final int SCROLL_DIRECTION_TOLEFT = 1;
    public static final int SCROLL_DIRECTION_TORIGHT = 2;
    public float mDefaultScale;
    public Rect mImageArea;
    int mSample;
    public float mScale;
    public int mScrollDirection;
    public Rect mShowArea;
    public boolean mShowRegion;
    int mSourceDensity;
    public int mState;
    int mTargetDensity;
    public long mTaskTime;

    public RegionDrawableData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private int scaleToSampleRoundDown(float f16) {
        int floor = (int) Math.floor(1.0f / f16);
        if (floor > 64) {
            floor = 64;
        }
        for (int i3 = 64; i3 != 0; i3 >>= 1) {
            int i16 = floor & i3;
            if (i16 != 0) {
                return i16;
            }
        }
        return 1;
    }

    private int scaleToSampleRoundup(float f16) {
        int round = (int) Math.round(1.0d / f16);
        if (round < 1) {
            round = 1;
        }
        if (round > 64) {
            round = 64;
        }
        for (int i3 = 64; i3 != 0; i3 >>= 1) {
            int i16 = round & i3;
            if (i16 != 0) {
                if (((i3 >> 1) & round) != 0 && (round & (i3 - 1)) != 0) {
                    return i16 << 1;
                }
                return i16;
            }
        }
        return 1;
    }

    public int calcSample() {
        int scaleToSampleRoundup;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        float f16 = this.mScale;
        if (f16 == 0.0f) {
            scaleToSampleRoundup = 1;
        } else {
            scaleToSampleRoundup = scaleToSampleRoundup(f16 * (this.mTargetDensity / this.mSourceDensity));
        }
        this.mSample = scaleToSampleRoundup;
        return scaleToSampleRoundup;
    }
}
