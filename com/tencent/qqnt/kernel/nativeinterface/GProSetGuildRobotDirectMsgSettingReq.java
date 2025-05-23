package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSetGuildRobotDirectMsgSettingReq {
    public long botTid;
    public long maxPushNum;
    public long userTid;

    public GProSetGuildRobotDirectMsgSettingReq() {
    }

    public long getBotTid() {
        return this.botTid;
    }

    public long getMaxPushNum() {
        return this.maxPushNum;
    }

    public long getUserTid() {
        return this.userTid;
    }

    public String toString() {
        return "GProSetGuildRobotDirectMsgSettingReq{botTid=" + this.botTid + ",userTid=" + this.userTid + ",maxPushNum=" + this.maxPushNum + ",}";
    }

    public GProSetGuildRobotDirectMsgSettingReq(long j3, long j16, long j17) {
        this.botTid = j3;
        this.userTid = j16;
        this.maxPushNum = j17;
    }
}
