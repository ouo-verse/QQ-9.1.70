package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFetchGuildRobotDirectMsgSettingRsp {
    public long dailyPushMaxNum;

    public GProFetchGuildRobotDirectMsgSettingRsp() {
    }

    public long getDailyPushMaxNum() {
        return this.dailyPushMaxNum;
    }

    public String toString() {
        return "GProFetchGuildRobotDirectMsgSettingRsp{dailyPushMaxNum=" + this.dailyPushMaxNum + ",}";
    }

    public GProFetchGuildRobotDirectMsgSettingRsp(long j3) {
        this.dailyPushMaxNum = j3;
    }
}
