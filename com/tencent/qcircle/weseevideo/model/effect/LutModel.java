package com.tencent.qcircle.weseevideo.model.effect;

import com.tencent.qcircle.weseevideo.composition.effectnode.VideoEffectType;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LutModel extends BaseEffectModel {
    private int effectType = VideoEffectType.TYPE_LUT.value;
    private String lutBitmap = "";
    private float lutAlpha = 1.0f;
    private long lutStartTime = 0;
    private long lutDuration = TTL.MAX_VALUE;

    public int getEffectType() {
        return this.effectType;
    }

    public float getLutAlpha() {
        return this.lutAlpha;
    }

    public String getLutBitmap() {
        return this.lutBitmap;
    }

    public long getLutDuration() {
        return this.lutDuration;
    }

    public long getLutStartTime() {
        return this.lutStartTime;
    }

    public void setEffectType(int i3) {
        this.effectType = i3;
    }

    public void setLutAlpha(float f16) {
        this.lutAlpha = f16;
    }

    public void setLutBitmap(String str) {
        this.lutBitmap = str;
    }

    public void setLutDuration(long j3) {
        this.lutDuration = j3;
    }

    public void setLutStartTime(long j3) {
        this.lutStartTime = j3;
    }
}
