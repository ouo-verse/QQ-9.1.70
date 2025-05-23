package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ListRobotReq {
    public long groupId;
    public int pageNum;
    public boolean queryAddedRobot;
    public boolean queryTab;
    public byte[] reqPagingCookie = new byte[0];
    public String dataVersion = "";
    public String listId = "";

    public String getDataVersion() {
        return this.dataVersion;
    }

    public long getGroupId() {
        return this.groupId;
    }

    public String getListId() {
        return this.listId;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public boolean getQueryAddedRobot() {
        return this.queryAddedRobot;
    }

    public boolean getQueryTab() {
        return this.queryTab;
    }

    public byte[] getReqPagingCookie() {
        return this.reqPagingCookie;
    }

    public String toString() {
        return "ListRobotReq{reqPagingCookie=" + this.reqPagingCookie + ",dataVersion=" + this.dataVersion + ",listId=" + this.listId + ",pageNum=" + this.pageNum + ",groupId=" + this.groupId + ",queryTab=" + this.queryTab + ",queryAddedRobot=" + this.queryAddedRobot + ",}";
    }
}
