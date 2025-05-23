package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProUserAllGiftInfo implements Serializable {
    long serialVersionUID = 1;
    public GProUserGiftInfo payGiftInfo = new GProUserGiftInfo();
    public GProUserGiftInfo freeGiftInfo = new GProUserGiftInfo();

    public GProUserGiftInfo getFreeGiftInfo() {
        return this.freeGiftInfo;
    }

    public GProUserGiftInfo getPayGiftInfo() {
        return this.payGiftInfo;
    }

    public String toString() {
        return "GProUserAllGiftInfo{payGiftInfo=" + this.payGiftInfo + ",freeGiftInfo=" + this.freeGiftInfo + ",}";
    }
}
