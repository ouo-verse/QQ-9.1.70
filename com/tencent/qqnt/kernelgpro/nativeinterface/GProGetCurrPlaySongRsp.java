package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetCurrPlaySongRsp {
    public GProListenTogetherRspHead rspHead = new GProListenTogetherRspHead();
    public GProPlayInfo playInfo = new GProPlayInfo();

    public GProPlayInfo getPlayInfo() {
        return this.playInfo;
    }

    public GProListenTogetherRspHead getRspHead() {
        return this.rspHead;
    }

    public String toString() {
        return "GProGetCurrPlaySongRsp{rspHead=" + this.rspHead + ",playInfo=" + this.playInfo + ",}";
    }
}
