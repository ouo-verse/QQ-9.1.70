package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProLiveEnterRoomInfo {
    public String businessPid;
    public Integer gameType;
    public Integer giftFlag;
    public Integer goodsFlag;
    public String logo;
    public String name;
    public Long ownerUid;
    public Integer payFlag;
    public String programId;
    public Long roomId;
    public GProLiveRoomRichTitle roomLabels;
    public String sid;
    public String systemNotice;

    public String getBusinessPid() {
        return this.businessPid;
    }

    public Integer getGameType() {
        return this.gameType;
    }

    public Integer getGiftFlag() {
        return this.giftFlag;
    }

    public Integer getGoodsFlag() {
        return this.goodsFlag;
    }

    public String getLogo() {
        return this.logo;
    }

    public String getName() {
        return this.name;
    }

    public Long getOwnerUid() {
        return this.ownerUid;
    }

    public Integer getPayFlag() {
        return this.payFlag;
    }

    public String getProgramId() {
        return this.programId;
    }

    public Long getRoomId() {
        return this.roomId;
    }

    public GProLiveRoomRichTitle getRoomLabels() {
        return this.roomLabels;
    }

    public String getSid() {
        return this.sid;
    }

    public String getSystemNotice() {
        return this.systemNotice;
    }

    public String toString() {
        return "GProLiveEnterRoomInfo{roomId=" + this.roomId + ",ownerUid=" + this.ownerUid + ",logo=" + this.logo + ",name=" + this.name + ",gameType=" + this.gameType + ",roomLabels=" + this.roomLabels + ",giftFlag=" + this.giftFlag + ",goodsFlag=" + this.goodsFlag + ",programId=" + this.programId + ",systemNotice=" + this.systemNotice + ",sid=" + this.sid + ",payFlag=" + this.payFlag + ",businessPid=" + this.businessPid + ",}";
    }
}
