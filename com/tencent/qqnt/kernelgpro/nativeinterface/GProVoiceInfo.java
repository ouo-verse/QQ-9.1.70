package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProVoiceInfo implements Serializable {
    public String screenPic;
    public long screenShareTinyId;
    public int screenState;
    public long screenUpdateTime;
    long serialVersionUID;
    public int voiceState;

    public GProVoiceInfo() {
        this.serialVersionUID = 1L;
        this.screenPic = "";
    }

    public String getScreenPic() {
        return this.screenPic;
    }

    public long getScreenShareTinyId() {
        return this.screenShareTinyId;
    }

    public int getScreenState() {
        return this.screenState;
    }

    public long getScreenUpdateTime() {
        return this.screenUpdateTime;
    }

    public int getVoiceState() {
        return this.voiceState;
    }

    public String toString() {
        return "GProVoiceInfo{voiceState=" + this.voiceState + ",screenState=" + this.screenState + ",screenPic=" + this.screenPic + ",screenUpdateTime=" + this.screenUpdateTime + ",screenShareTinyId=" + this.screenShareTinyId + ",}";
    }

    public GProVoiceInfo(int i3, int i16, String str, long j3, long j16) {
        this.serialVersionUID = 1L;
        this.voiceState = i3;
        this.screenState = i16;
        this.screenPic = str;
        this.screenUpdateTime = j3;
        this.screenShareTinyId = j16;
    }
}
