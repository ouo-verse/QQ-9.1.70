package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProEndPageLiveInfo {
    public GProLiveMetrics liveMetrics = new GProLiveMetrics();
    public GProEndPageLiveTime liveTime = new GProEndPageLiveTime();
    public int roomId;

    public GProLiveMetrics getLiveMetrics() {
        return this.liveMetrics;
    }

    public GProEndPageLiveTime getLiveTime() {
        return this.liveTime;
    }

    public int getRoomId() {
        return this.roomId;
    }

    public String toString() {
        return "GProEndPageLiveInfo{roomId=" + this.roomId + ",liveMetrics=" + this.liveMetrics + ",liveTime=" + this.liveTime + ",}";
    }
}
