package com.tencent.qqnt.kernel.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGlobalRobotSubscription {
    public long guildId;
    public long subscribeTime;
    public String subscriptionId;

    public GProGlobalRobotSubscription() {
        this.subscriptionId = "";
    }

    public long getGuildId() {
        return this.guildId;
    }

    public long getSubscribeTime() {
        return this.subscribeTime;
    }

    public String getSubscriptionId() {
        return this.subscriptionId;
    }

    public String toString() {
        return "GProGlobalRobotSubscription{subscriptionId=" + this.subscriptionId + ",guildId=" + this.guildId + ",subscribeTime=" + this.subscribeTime + ",}";
    }

    public GProGlobalRobotSubscription(String str, long j3, long j16) {
        this.subscriptionId = str;
        this.guildId = j3;
        this.subscribeTime = j16;
    }
}
