package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAnchorEnterRoomReq {
    public String extData;
    public String machine;
    public Long openLiveType;
    public String programId;
    public Long roomId;
    public String source;

    public String getExtData() {
        return this.extData;
    }

    public String getMachine() {
        return this.machine;
    }

    public Long getOpenLiveType() {
        return this.openLiveType;
    }

    public String getProgramId() {
        return this.programId;
    }

    public Long getRoomId() {
        return this.roomId;
    }

    public String getSource() {
        return this.source;
    }

    public String toString() {
        return "GProAnchorEnterRoomReq{roomId=" + this.roomId + ",source=" + this.source + ",programId=" + this.programId + ",machine=" + this.machine + ",openLiveType=" + this.openLiveType + ",extData=" + this.extData + ",}";
    }
}
