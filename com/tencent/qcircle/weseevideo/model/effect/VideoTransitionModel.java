package com.tencent.qcircle.weseevideo.model.effect;

import com.tencent.qcircle.weseevideo.composition.effectnode.VideoEffectType;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VideoTransitionModel extends VideoPagModel {
    private String linkVideoId;
    private String subCategoryId = "";
    private String transitionId = "";
    private int mTransitionPosition = -1;
    private float mSpeed = 1.0f;
    private float mFirstHalfTime = 0.0f;
    private float mOverlapTime = 0.0f;

    public VideoTransitionModel() {
        this.effectType = VideoEffectType.TYPE_TRANSITION_EFFECT.value;
    }

    public float getFirstHalfTime() {
        return this.mFirstHalfTime;
    }

    public String getLinkVideoId() {
        return this.linkVideoId;
    }

    public float getOverlapTime() {
        return this.mOverlapTime;
    }

    public float getSpeed() {
        return this.mSpeed;
    }

    public String getSubCategoryId() {
        return this.subCategoryId;
    }

    public String getTransitionId() {
        return this.transitionId;
    }

    public int getTransitionPosition() {
        return this.mTransitionPosition;
    }

    public void setFirstHalfTime(float f16) {
        this.mFirstHalfTime = f16;
    }

    public void setLinkVideoId(String str) {
        this.linkVideoId = str;
    }

    public void setOverlapTime(float f16) {
        this.mOverlapTime = f16;
    }

    public void setSpeed(float f16) {
        this.mSpeed = f16;
    }

    public void setSubCategoryId(String str) {
        this.subCategoryId = str;
    }

    public void setTransitionId(String str) {
        this.transitionId = str;
    }

    public void setTransitionPosition(int i3) {
        this.mTransitionPosition = i3;
    }
}
