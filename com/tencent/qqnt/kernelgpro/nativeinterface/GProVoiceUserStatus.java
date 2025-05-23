package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProVoiceUserStatus {
    public int networkQuality;
    public int screenShareMicStatus;
    public int sysMicStatus;
    public long tinyId;

    public GProVoiceUserStatus() {
    }

    public int getNetworkQuality() {
        return this.networkQuality;
    }

    public int getScreenShareMicStatus() {
        return this.screenShareMicStatus;
    }

    public int getSysMicStatus() {
        return this.sysMicStatus;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProVoiceUserStatus{tinyId=" + this.tinyId + ",networkQuality=" + this.networkQuality + ",sysMicStatus=" + this.sysMicStatus + ",screenShareMicStatus=" + this.screenShareMicStatus + ",}";
    }

    public GProVoiceUserStatus(long j3, int i3, int i16, int i17) {
        this.tinyId = j3;
        this.networkQuality = i3;
        this.sysMicStatus = i16;
        this.screenShareMicStatus = i17;
    }
}
