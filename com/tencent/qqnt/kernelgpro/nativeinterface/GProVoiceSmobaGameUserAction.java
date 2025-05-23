package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProVoiceSmobaGameUserAction {
    public long tinyId;
    public int userActionType;

    public GProVoiceSmobaGameUserAction() {
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public int getUserActionType() {
        return this.userActionType;
    }

    public String toString() {
        return "GProVoiceSmobaGameUserAction{tinyId=" + this.tinyId + ",userActionType=" + this.userActionType + ",}";
    }

    public GProVoiceSmobaGameUserAction(long j3, int i3) {
        this.tinyId = j3;
        this.userActionType = i3;
    }
}
