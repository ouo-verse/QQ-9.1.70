package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProChannelUserNum implements Serializable {
    public long dataVersion;
    public int playersNum;
    public int robotNum;
    long serialVersionUID = 1;
    public int showThreshold;
    public int speakOrderNum;
    public int userNum;
    public int viewersNum;

    public GProChannelUserNum() {
    }

    public long getDataVersion() {
        return this.dataVersion;
    }

    public int getPlayersNum() {
        return this.playersNum;
    }

    public int getRobotNum() {
        return this.robotNum;
    }

    public int getShowThreshold() {
        return this.showThreshold;
    }

    public int getSpeakOrderNum() {
        return this.speakOrderNum;
    }

    public int getUserNum() {
        return this.userNum;
    }

    public int getViewersNum() {
        return this.viewersNum;
    }

    public String toString() {
        return "GProChannelUserNum{dataVersion=" + this.dataVersion + ",userNum=" + this.userNum + ",playersNum=" + this.playersNum + ",viewersNum=" + this.viewersNum + ",speakOrderNum=" + this.speakOrderNum + ",showThreshold=" + this.showThreshold + ",robotNum=" + this.robotNum + ",}";
    }

    public GProChannelUserNum(long j3, int i3, int i16, int i17, int i18, int i19, int i26) {
        this.dataVersion = j3;
        this.userNum = i3;
        this.playersNum = i16;
        this.viewersNum = i17;
        this.speakOrderNum = i18;
        this.showThreshold = i19;
        this.robotNum = i26;
    }
}
