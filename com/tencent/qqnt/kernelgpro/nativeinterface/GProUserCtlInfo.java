package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProUserCtlInfo {
    public GProAVDevOptInfo devOpt;
    public int nextAVState;
    public GProSpeakTimeCtl speakTimeCtl;

    public GProUserCtlInfo() {
        this.devOpt = new GProAVDevOptInfo();
        this.speakTimeCtl = new GProSpeakTimeCtl();
    }

    public GProAVDevOptInfo getDevOpt() {
        return this.devOpt;
    }

    public int getNextAVState() {
        return this.nextAVState;
    }

    public GProSpeakTimeCtl getSpeakTimeCtl() {
        return this.speakTimeCtl;
    }

    public String toString() {
        return "GProUserCtlInfo{nextAVState=" + this.nextAVState + ",devOpt=" + this.devOpt + ",speakTimeCtl=" + this.speakTimeCtl + ",}";
    }

    public GProUserCtlInfo(int i3, GProAVDevOptInfo gProAVDevOptInfo, GProSpeakTimeCtl gProSpeakTimeCtl) {
        this.devOpt = new GProAVDevOptInfo();
        new GProSpeakTimeCtl();
        this.nextAVState = i3;
        this.devOpt = gProAVDevOptInfo;
        this.speakTimeCtl = gProSpeakTimeCtl;
    }
}
