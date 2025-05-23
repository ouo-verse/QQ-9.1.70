package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildTaskCardUpdateProgress {
    public long add;
    public long decrease;
    public long taskId;
    public int taskType;

    public long getAdd() {
        return this.add;
    }

    public long getDecrease() {
        return this.decrease;
    }

    public long getTaskId() {
        return this.taskId;
    }

    public int getTaskType() {
        return this.taskType;
    }

    public String toString() {
        return "GProGuildTaskCardUpdateProgress{taskId=" + this.taskId + ",taskType=" + this.taskType + ",add=" + this.add + ",decrease=" + this.decrease + ",}";
    }
}
