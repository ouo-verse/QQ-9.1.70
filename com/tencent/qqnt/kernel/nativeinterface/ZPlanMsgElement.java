package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class ZPlanMsgElement {
    public int actionFlag;
    public byte[] extInfo;
    public int guestActionID;
    public int masterActionID;

    public ZPlanMsgElement() {
        this.extInfo = new byte[0];
    }

    public int getActionFlag() {
        return this.actionFlag;
    }

    public byte[] getExtInfo() {
        return this.extInfo;
    }

    public int getGuestActionID() {
        return this.guestActionID;
    }

    public int getMasterActionID() {
        return this.masterActionID;
    }

    public String toString() {
        return "ZPlanMsgElement{masterActionID=" + this.masterActionID + ",guestActionID=" + this.guestActionID + ",actionFlag=" + this.actionFlag + ",extInfo=" + this.extInfo + ",}";
    }

    public ZPlanMsgElement(int i3, int i16, int i17, byte[] bArr) {
        this.masterActionID = i3;
        this.guestActionID = i16;
        this.actionFlag = i17;
        this.extInfo = bArr;
    }
}
