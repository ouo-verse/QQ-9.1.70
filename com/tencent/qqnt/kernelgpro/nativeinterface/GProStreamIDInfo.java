package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProStreamIDInfo {
    public String auxStreamId;
    public Boolean isSelfInfo;
    public String mainStreamId;
    public Long originRoomid;
    public Long originUid;
    public Long roomId;
    public Long uid;

    public String getAuxStreamId() {
        return this.auxStreamId;
    }

    public Boolean getIsSelfInfo() {
        return this.isSelfInfo;
    }

    public String getMainStreamId() {
        return this.mainStreamId;
    }

    public Long getOriginRoomid() {
        return this.originRoomid;
    }

    public Long getOriginUid() {
        return this.originUid;
    }

    public Long getRoomId() {
        return this.roomId;
    }

    public Long getUid() {
        return this.uid;
    }

    public String toString() {
        return "GProStreamIDInfo{uid=" + this.uid + ",roomId=" + this.roomId + ",mainStreamId=" + this.mainStreamId + ",auxStreamId=" + this.auxStreamId + ",isSelfInfo=" + this.isSelfInfo + ",originUid=" + this.originUid + ",originRoomid=" + this.originRoomid + ",}";
    }
}
