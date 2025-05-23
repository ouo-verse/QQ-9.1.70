package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GetGroupSchoolNoticeListReq {
    public long groupCode;
    public int pageSize;
    public long publishTime;
    public int type;

    public GetGroupSchoolNoticeListReq() {
    }

    public long getGroupCode() {
        return this.groupCode;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public long getPublishTime() {
        return this.publishTime;
    }

    public int getType() {
        return this.type;
    }

    public String toString() {
        return "GetGroupSchoolNoticeListReq{type=" + this.type + ",groupCode=" + this.groupCode + ",publishTime=" + this.publishTime + ",pageSize=" + this.pageSize + ",}";
    }

    public GetGroupSchoolNoticeListReq(int i3, long j3, long j16, int i16) {
        this.type = i3;
        this.groupCode = j3;
        this.publishTime = j16;
        this.pageSize = i16;
    }
}
