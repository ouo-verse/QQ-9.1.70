package com.tencent.qqlive.tvkplayer.api.vinfo;

import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKDarkLogoInfo implements Serializable {
    private float mDefaultAlpha = 100.0f;
    private int mDurationMs;
    private FlickerInfo mFlickerInfo;
    private String mLogo;
    private int mStartTimeMs;

    /* compiled from: P */
    /* loaded from: classes23.dex */
    public static class FlickerInfo implements Serializable {
        private float mAlpha = 100.0f;
        private int mDurationMs;
        private int mGapMs;

        public float getAlpha() {
            return this.mAlpha;
        }

        public int getDurationMs() {
            return this.mDurationMs;
        }

        public int getGapMs() {
            return this.mGapMs;
        }

        public void setAlpha(float f16) {
            this.mAlpha = f16;
        }

        public void setDurationMs(int i3) {
            this.mDurationMs = i3;
        }

        public void setGapMs(int i3) {
            this.mGapMs = i3;
        }
    }

    public float getDefaultAlpha() {
        return this.mDefaultAlpha;
    }

    public int getDurationMs() {
        return this.mDurationMs;
    }

    public FlickerInfo getFlickerInfo() {
        return this.mFlickerInfo;
    }

    public String getLogo() {
        return this.mLogo;
    }

    public int getStartTimeMs() {
        return this.mStartTimeMs;
    }

    public void setDefaultAlpha(float f16) {
        this.mDefaultAlpha = f16;
    }

    public void setDurationMs(int i3) {
        this.mDurationMs = i3;
    }

    public void setFlickerInfo(FlickerInfo flickerInfo) {
        this.mFlickerInfo = flickerInfo;
    }

    public void setLogo(String str) {
        this.mLogo = str;
    }

    public void setStartTimeMs(int i3) {
        this.mStartTimeMs = i3;
    }
}
