package com.tencent.qcircle.weseevideo.model.effect;

import com.tencent.qcircle.weseevideo.composition.effectnode.VideoEffectType;

/* loaded from: classes22.dex */
public class VideoPagModel extends BaseEffectModel {
    protected String assetFilePath;
    protected float duration;
    protected String filePath;
    protected float startTime;
    protected int effectType = VideoEffectType.TYPE_DEFAULT.value;
    protected String uniqueId = "";

    public String getAssetFilePath() {
        return this.assetFilePath;
    }

    public float getDuration() {
        return this.duration;
    }

    public int getEffectType() {
        return this.effectType;
    }

    public String getFilePath() {
        return this.filePath;
    }

    public float getStartTime() {
        return this.startTime;
    }

    public String getUniqueId() {
        return this.uniqueId;
    }

    public void setAssetFilePath(String str) {
        this.assetFilePath = str;
    }

    public void setDuration(float f16) {
        this.duration = f16;
    }

    public void setEffectType(int i3) {
        this.effectType = i3;
    }

    public void setFilePath(String str) {
        this.filePath = str;
    }

    public void setStartTime(float f16) {
        this.startTime = f16;
    }

    public void setUniqueId(String str) {
        this.uniqueId = str;
    }
}
