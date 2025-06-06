package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class BulletinFeedsRecord {
    public int createTime;
    public int feedsFlag;
    public int feedsType;
    public long groupCode;
    public int modifyTime;
    public int setTop;
    public String fromUid = "";
    public String feedsId = "";
    public BulletinFeedsMsg feedsMsg = new BulletinFeedsMsg();

    public int getCreateTime() {
        return this.createTime;
    }

    public int getFeedsFlag() {
        return this.feedsFlag;
    }

    public String getFeedsId() {
        return this.feedsId;
    }

    public BulletinFeedsMsg getFeedsMsg() {
        return this.feedsMsg;
    }

    public int getFeedsType() {
        return this.feedsType;
    }

    public String getFromUid() {
        return this.fromUid;
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getModifyTime() {
        return this.modifyTime;
    }

    public int getSetTop() {
        return this.setTop;
    }

    public String toString() {
        return "BulletinFeedsRecord{groupCode=" + this.groupCode + ",fromUid=" + this.fromUid + ",feedsType=" + this.feedsType + ",feedsId=" + this.feedsId + ",feedsFlag=" + this.feedsFlag + ",createTime=" + this.createTime + ",modifyTime=" + this.modifyTime + ",feedsMsg=" + this.feedsMsg + ",setTop=" + this.setTop + ",}";
    }
}
