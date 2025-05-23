package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSubscribeGlobalRobotReq {
    public long guildId;
    public boolean isSwitchOn;
    public String subscriptionId;

    public GProSubscribeGlobalRobotReq() {
        this.subscriptionId = "";
    }

    public long getGuildId() {
        return this.guildId;
    }

    public boolean getIsSwitchOn() {
        return this.isSwitchOn;
    }

    public String getSubscriptionId() {
        return this.subscriptionId;
    }

    public String toString() {
        return "GProSubscribeGlobalRobotReq{subscriptionId=" + this.subscriptionId + ",guildId=" + this.guildId + ",isSwitchOn=" + this.isSwitchOn + ",}";
    }

    public GProSubscribeGlobalRobotReq(String str, long j3, boolean z16) {
        this.subscriptionId = str;
        this.guildId = j3;
        this.isSwitchOn = z16;
    }
}
