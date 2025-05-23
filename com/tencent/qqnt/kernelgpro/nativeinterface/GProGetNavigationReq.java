package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetNavigationReq {
    public long guildId;

    public GProGetNavigationReq() {
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProGetNavigationReq{guildId=" + this.guildId + ",}";
    }

    public GProGetNavigationReq(long j3) {
        this.guildId = j3;
    }
}
