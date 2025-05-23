package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProRemoveGuildTaskCardReq {
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
        return "GProRemoveGuildTaskCardReq{taskId=" + this.taskId + ",guildId=" + this.guildId + ",curState=" + this.curState + ",}";
    }
}
