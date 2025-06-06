package com.gyailib.library;

/* compiled from: P */
/* loaded from: classes2.dex */
public class SegmentSmoothConfig {
    public boolean enableBlurThreshold;
    public boolean enableFrames;
    public boolean enableGuideSmooth;
    public boolean enableLineSmooth;
    public boolean enableSigmod;
    public boolean enableSmooth;
    public boolean enableThreshold;
    public boolean enableThresholdTrans;
    public String faceFeatureKey;
    public float blurRadius = 9.0f;
    public int maskResizeWidth = 480;
    public int maskResizeHeight = 480;
    public float preProcessMaxThreshold = 0.6f;
    public float preProcessMinThreshold = 0.4f;
    public float postProcessMaxThreshold = 0.6f;
    public float postProcessMinThreshold = 0.4f;
    public float postProcessMaxThresholdTrans = 0.6f;
    public float postProcessMinThresholdTrans = 0.25f;

    public float getBlurRadius() {
        return this.blurRadius;
    }

    public boolean getEnableBlurThreshold() {
        return this.enableBlurThreshold;
    }

    public boolean getEnableFrames() {
        return this.enableFrames;
    }

    public boolean getEnableGuideSmooth() {
        return this.enableGuideSmooth;
    }

    public boolean getEnableLineSmooth() {
        return this.enableLineSmooth;
    }

    public boolean getEnableSigmod() {
        return this.enableSigmod;
    }

    public boolean getEnableSmooth() {
        return this.enableSmooth;
    }

    public boolean getEnableThreshold() {
        return this.enableThreshold;
    }

    public boolean getEnableThresholdTrans() {
        return this.enableThresholdTrans;
    }

    public String getFaceFeatureKey() {
        return this.faceFeatureKey;
    }

    public int getMaskResizeHeight() {
        return this.maskResizeHeight;
    }

    public int getMaskResizeWidth() {
        return this.maskResizeWidth;
    }

    public float getPostProcessMaxThreshold() {
        return this.postProcessMaxThreshold;
    }

    public float getPostProcessMaxThresholdTrans() {
        return this.postProcessMaxThresholdTrans;
    }

    public float getPostProcessMinThreshold() {
        return this.postProcessMinThreshold;
    }

    public float getPostProcessMinThresholdTrans() {
        return this.postProcessMinThresholdTrans;
    }

    public float getPreProcessMaxThreshold() {
        return this.preProcessMaxThreshold;
    }

    public float getPreProcessMinThreshold() {
        return this.preProcessMinThreshold;
    }
}
