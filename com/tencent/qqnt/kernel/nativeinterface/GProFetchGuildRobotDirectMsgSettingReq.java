package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFetchGuildRobotDirectMsgSettingReq {
    public long botTid;
    public long userTid;

    public GProFetchGuildRobotDirectMsgSettingReq() {
    }

    public long getBotTid() {
        return this.botTid;
    }

    public long getUserTid() {
        return this.userTid;
    }

    public String toString() {
        return "GProFetchGuildRobotDirectMsgSettingReq{botTid=" + this.botTid + ",userTid=" + this.userTid + ",}";
    }

    public GProFetchGuildRobotDirectMsgSettingReq(long j3, long j16) {
        this.botTid = j3;
        this.userTid = j16;
    }
}
