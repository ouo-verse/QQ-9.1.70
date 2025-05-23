package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProExposureGuildTaskCardReq {
    public int curState;
    public long guildId;
    public long taskId;

    public int getCurState() {
        return this.curState;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public String toString() {
        return "GProExposureGuildTaskCardReq{taskId=" + this.taskId + ",guildId=" + this.guildId + ",curState=" + this.curState + ",}";
    }
}
