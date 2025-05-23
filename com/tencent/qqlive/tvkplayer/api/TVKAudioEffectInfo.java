package com.tencent.qqlive.tvkplayer.api;

import com.tencent.qqlive.tvkplayer.api.postprocess.effect.audio.TVKAudioEffectType;

/* compiled from: P */
/* loaded from: classes23.dex */
public class TVKAudioEffectInfo {
    private String mEffectName;
    private String mEffectShowName;
    private TVKAudioEffectType mEffectType;
    private boolean mIsSelected;
    private int mVipLimit;

    public String getEffectName() {
        return this.mEffectName;
    }

    public String getEffectShowName() {
        return this.mEffectShowName;
    }

    public TVKAudioEffectType getEffectType() {
        return this.mEffectType;
    }

    public int getVipLimit() {
        return this.mVipLimit;
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }

    public void setEffectName(String str) {
        this.mEffectName = str;
    }

    public void setEffectShowName(String str) {
        this.mEffectShowName = str;
    }

    public void setEffectType(TVKAudioEffectType tVKAudioEffectType) {
        this.mEffectType = tVKAudioEffectType;
    }

    public void setSelected(boolean z16) {
        this.mIsSelected = z16;
    }

    public void setVipLimit(int i3) {
        this.mVipLimit = i3;
    }
}
