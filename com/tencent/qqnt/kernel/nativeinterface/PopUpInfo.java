package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class PopUpInfo {
    public long busId;
    public String content = "";
    public int ctrlFlag;
    public byte[] pbReserv;
    public Long seqId;

    public long getBusId() {
        return this.busId;
    }

    public String getContent() {
        return this.content;
    }

    public int getCtrlFlag() {
        return this.ctrlFlag;
    }

    public byte[] getPbReserv() {
        return this.pbReserv;
    }

    public Long getSeqId() {
        return this.seqId;
    }

    public String toString() {
        return "PopUpInfo{busId=" + this.busId + ",ctrlFlag=" + this.ctrlFlag + ",content=" + this.content + ",seqId=" + this.seqId + ",pbReserv=" + this.pbReserv + ",}";
    }
}
