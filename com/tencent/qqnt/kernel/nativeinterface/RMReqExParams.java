package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class RMReqExParams {
    public int downSourceType;
    public int triggerType;

    public RMReqExParams() {
    }

    public int getDownSourceType() {
        return this.downSourceType;
    }

    public int getTriggerType() {
        return this.triggerType;
    }

    public RMReqExParams(int i3, int i16) {
        this.downSourceType = i3;
        this.triggerType = i16;
    }
}
