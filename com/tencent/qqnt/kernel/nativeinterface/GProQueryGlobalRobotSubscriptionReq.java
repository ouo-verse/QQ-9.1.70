package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GProQueryGlobalRobotSubscriptionReq {
    public long guildId;
    public String subscriptionId;

    public GProQueryGlobalRobotSubscriptionReq() {
        this.subscriptionId = "";
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getSubscriptionId() {
        return this.subscriptionId;
    }

    public String toString() {
        return "GProQueryGlobalRobotSubscriptionReq{subscriptionId=" + this.subscriptionId + ",guildId=" + this.guildId + ",}";
    }

    public GProQueryGlobalRobotSubscriptionReq(String str, long j3) {
        this.subscriptionId = str;
        this.guildId = j3;
    }
}
