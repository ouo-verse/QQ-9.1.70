package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProAtSetInfo {
    public long guildId;
    public int remainingAtAllCount;
    public int remainingAtNotifyTimes;
    public int remainingAtOnlCount;
    public int remainingAtRoleCount;
    public int totalAtAllCount;
    public int totalAtNotifyTimes;
    public int totalAtOnlCount;
    public int totalAtRoleCount;

    public GProAtSetInfo() {
    }

    public long getGuildId() {
        return this.guildId;
    }

    public int getRemainingAtAllCount() {
        return this.remainingAtAllCount;
    }

    public int getRemainingAtNotifyTimes() {
        return this.remainingAtNotifyTimes;
    }

    public int getRemainingAtOnlCount() {
        return this.remainingAtOnlCount;
    }

    public int getRemainingAtRoleCount() {
        return this.remainingAtRoleCount;
    }

    public int getTotalAtAllCount() {
        return this.totalAtAllCount;
    }

    public int getTotalAtNotifyTimes() {
        return this.totalAtNotifyTimes;
    }

    public int getTotalAtOnlCount() {
        return this.totalAtOnlCount;
    }

    public int getTotalAtRoleCount() {
        return this.totalAtRoleCount;
    }

    public String toString() {
        return "GProAtSetInfo{guildId=" + this.guildId + ",totalAtAllCount=" + this.totalAtAllCount + ",remainingAtAllCount=" + this.remainingAtAllCount + ",totalAtOnlCount=" + this.totalAtOnlCount + ",remainingAtOnlCount=" + this.remainingAtOnlCount + ",totalAtRoleCount=" + this.totalAtRoleCount + ",remainingAtRoleCount=" + this.remainingAtRoleCount + ",totalAtNotifyTimes=" + this.totalAtNotifyTimes + ",remainingAtNotifyTimes=" + this.remainingAtNotifyTimes + ",}";
    }

    public GProAtSetInfo(long j3, int i3, int i16, int i17, int i18, int i19, int i26) {
        this.guildId = j3;
        this.totalAtAllCount = i3;
        this.remainingAtAllCount = i16;
        this.totalAtOnlCount = i17;
        this.remainingAtOnlCount = i18;
        this.totalAtRoleCount = i19;
        this.remainingAtRoleCount = i26;
    }
}
