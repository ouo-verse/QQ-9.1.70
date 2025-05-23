package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGetAudioBotStatusRsp {
    public ArrayList<GProAudioBotStatusInfo> botStatusInfos;
    public long pollInterval;

    public GProGetAudioBotStatusRsp() {
        this.botStatusInfos = new ArrayList<>();
    }

    public ArrayList<GProAudioBotStatusInfo> getBotStatusInfos() {
        return this.botStatusInfos;
    }

    public long getPollInterval() {
        return this.pollInterval;
    }

    public String toString() {
        return "GProGetAudioBotStatusRsp{botStatusInfos=" + this.botStatusInfos + ",pollInterval=" + this.pollInterval + ",}";
    }

    public GProGetAudioBotStatusRsp(ArrayList<GProAudioBotStatusInfo> arrayList, long j3) {
        new ArrayList();
        this.botStatusInfos = arrayList;
        this.pollInterval = j3;
    }
}
