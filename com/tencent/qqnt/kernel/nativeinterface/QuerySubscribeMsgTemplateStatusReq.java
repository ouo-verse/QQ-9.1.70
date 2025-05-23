package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class QuerySubscribeMsgTemplateStatusReq {
    public long groupId;
    public long guildId;
    public int pageNum;
    public long robotUin;
    public int start;

    public QuerySubscribeMsgTemplateStatusReq() {
    }

    public long getGroupId() {
        return this.groupId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public long getRobotUin() {
        return this.robotUin;
    }

    public int getStart() {
        return this.start;
    }

    public String toString() {
        return "QuerySubscribeMsgTemplateStatusReq{groupId=" + this.groupId + ",guildId=" + this.guildId + ",robotUin=" + this.robotUin + ",start=" + this.start + ",pageNum=" + this.pageNum + ",}";
    }

    public QuerySubscribeMsgTemplateStatusReq(long j3, long j16, long j17, int i3, int i16) {
        this.groupId = j3;
        this.guildId = j16;
        this.robotUin = j17;
        this.start = i3;
        this.pageNum = i16;
    }
}
