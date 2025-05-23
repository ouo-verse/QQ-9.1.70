package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProAnchorRoomInfo {
    public ArrayList<GProAnchorRoomNoticeItem> beginRoomNoticeTime = new ArrayList<>();
    public Integer continueLiveStatus;
    public String coverUrl169;
    public String coverUrl34;
    public Integer giftFlag;
    public Integer goodsNum;
    public String goodsUrl;

    /* renamed from: id, reason: collision with root package name */
    public Integer f359279id;
    public String logo;
    public String name;
    public String programId;
    public Integer roomGameType;
    public String roomPrepareNotify;
    public String systemNotice;
    public GProLiveRoomRichTitle tags;
    public Boolean todayHasRoomNotice;

    public ArrayList<GProAnchorRoomNoticeItem> getBeginRoomNoticeTime() {
        return this.beginRoomNoticeTime;
    }

    public Integer getContinueLiveStatus() {
        return this.continueLiveStatus;
    }

    public String getCoverUrl169() {
        return this.coverUrl169;
    }

    public String getCoverUrl34() {
        return this.coverUrl34;
    }

    public Integer getGiftFlag() {
        return this.giftFlag;
    }

    public Integer getGoodsNum() {
        return this.goodsNum;
    }

    public String getGoodsUrl() {
        return this.goodsUrl;
    }

    public Integer getId() {
        return this.f359279id;
    }

    public String getLogo() {
        return this.logo;
    }

    public String getName() {
        return this.name;
    }

    public String getProgramId() {
        return this.programId;
    }

    public Integer getRoomGameType() {
        return this.roomGameType;
    }

    public String getRoomPrepareNotify() {
        return this.roomPrepareNotify;
    }

    public String getSystemNotice() {
        return this.systemNotice;
    }

    public GProLiveRoomRichTitle getTags() {
        return this.tags;
    }

    public Boolean getTodayHasRoomNotice() {
        return this.todayHasRoomNotice;
    }

    public String toString() {
        return "GProAnchorRoomInfo{id=" + this.f359279id + ",name=" + this.name + ",logo=" + this.logo + ",programId=" + this.programId + ",giftFlag=" + this.giftFlag + ",goodsUrl=" + this.goodsUrl + ",goodsNum=" + this.goodsNum + ",tags=" + this.tags + ",coverUrl169=" + this.coverUrl169 + ",coverUrl34=" + this.coverUrl34 + ",roomPrepareNotify=" + this.roomPrepareNotify + ",roomGameType=" + this.roomGameType + ",systemNotice=" + this.systemNotice + ",continueLiveStatus=" + this.continueLiveStatus + ",beginRoomNoticeTime=" + this.beginRoomNoticeTime + ",todayHasRoomNotice=" + this.todayHasRoomNotice + ",}";
    }
}
