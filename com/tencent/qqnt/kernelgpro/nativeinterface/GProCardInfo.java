package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProCardInfo {
    public long channelId;
    public long scheduleId;

    public long getChannelId() {
        return this.channelId;
    }

    public long getScheduleId() {
        return this.scheduleId;
    }

    public String toString() {
        return "GProCardInfo{channelId=" + this.channelId + ",scheduleId=" + this.scheduleId + ",}";
    }
}
