package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProScheduleStatusInfo {
    public long scheduleId;
    public int status;

    public long getScheduleId() {
        return this.scheduleId;
    }

    public int getStatus() {
        return this.status;
    }

    public String toString() {
        return "GProScheduleStatusInfo{scheduleId=" + this.scheduleId + ",status=" + this.status + ",}";
    }
}
