package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGuildActiveValue {
    public int guildTodayAddActive;
    public int myTodayActive;
    public long totalGuildActive;

    public GProGuildActiveValue() {
    }

    public int getGuildTodayAddActive() {
        return this.guildTodayAddActive;
    }

    public int getMyTodayActive() {
        return this.myTodayActive;
    }

    public long getTotalGuildActive() {
        return this.totalGuildActive;
    }

    public String toString() {
        return "GProGuildActiveValue{totalGuildActive=" + this.totalGuildActive + ",guildTodayAddActive=" + this.guildTodayAddActive + ",myTodayActive=" + this.myTodayActive + ",}";
    }

    public GProGuildActiveValue(long j3, int i3, int i16) {
        this.totalGuildActive = j3;
        this.guildTodayAddActive = i3;
        this.myTodayActive = i16;
    }
}
