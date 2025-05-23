package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProPlayNodeExtInfo implements Serializable {
    public long compereTinyid;
    public boolean enableVolume;
    public int pauseDuration;
    public int playState;
    public GProPlayPushScene pushScene;
    long serialVersionUID;
    public long sourceNum;
    public long startPlayTime;
    public int volume;

    public GProPlayNodeExtInfo() {
        this.serialVersionUID = 1L;
        this.pushScene = new GProPlayPushScene();
    }

    public long getCompereTinyid() {
        return this.compereTinyid;
    }

    public boolean getEnableVolume() {
        return this.enableVolume;
    }

    public int getPauseDuration() {
        return this.pauseDuration;
    }

    public int getPlayState() {
        return this.playState;
    }

    public GProPlayPushScene getPushScene() {
        return this.pushScene;
    }

    public long getSourceNum() {
        return this.sourceNum;
    }

    public long getStartPlayTime() {
        return this.startPlayTime;
    }

    public int getVolume() {
        return this.volume;
    }

    public String toString() {
        return "GProPlayNodeExtInfo{playState=" + this.playState + ",startPlayTime=" + this.startPlayTime + ",pauseDuration=" + this.pauseDuration + ",sourceNum=" + this.sourceNum + ",compereTinyid=" + this.compereTinyid + ",enableVolume=" + this.enableVolume + ",volume=" + this.volume + ",pushScene=" + this.pushScene + ",}";
    }

    public GProPlayNodeExtInfo(int i3, long j3, int i16, long j16, long j17, boolean z16, int i17, GProPlayPushScene gProPlayPushScene) {
        this.serialVersionUID = 1L;
        new GProPlayPushScene();
        this.playState = i3;
        this.startPlayTime = j3;
        this.pauseDuration = i16;
        this.sourceNum = j16;
        this.compereTinyid = j17;
        this.enableVolume = z16;
        this.volume = i17;
        this.pushScene = gProPlayPushScene;
    }
}
