package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildTaskCardProgress {
    public int curState;
    public long curStatus;
    public long requireStatus;

    public int getCurState() {
        return this.curState;
    }

    public long getCurStatus() {
        return this.curStatus;
    }

    public long getRequireStatus() {
        return this.requireStatus;
    }

    public String toString() {
        return "GProGuildTaskCardProgress{curState=" + this.curState + ",curStatus=" + this.curStatus + ",requireStatus=" + this.requireStatus + ",}";
    }
}
