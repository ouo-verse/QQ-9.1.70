package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildTaskCard {
    public long taskId;
    public GProGuildTaskCardInfo taskInfo = new GProGuildTaskCardInfo();
    public GProGuildTaskCardProgress taskProgress = new GProGuildTaskCardProgress();

    public long getTaskId() {
        return this.taskId;
    }

    public GProGuildTaskCardInfo getTaskInfo() {
        return this.taskInfo;
    }

    public GProGuildTaskCardProgress getTaskProgress() {
        return this.taskProgress;
    }

    public String toString() {
        return "GProGuildTaskCard{taskId=" + this.taskId + ",taskInfo=" + this.taskInfo + ",taskProgress=" + this.taskProgress + ",}";
    }
}
