package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class VASMsgIceBreak {
    public Integer isIceBreakMsg;
    public Integer templateID;

    public VASMsgIceBreak() {
    }

    public Integer getIsIceBreakMsg() {
        return this.isIceBreakMsg;
    }

    public Integer getTemplateID() {
        return this.templateID;
    }

    public String toString() {
        return "VASMsgIceBreak{templateID=" + this.templateID + ",isIceBreakMsg=" + this.isIceBreakMsg + ",}";
    }

    public VASMsgIceBreak(Integer num, Integer num2) {
        this.templateID = num;
        this.isIceBreakMsg = num2;
    }
}
