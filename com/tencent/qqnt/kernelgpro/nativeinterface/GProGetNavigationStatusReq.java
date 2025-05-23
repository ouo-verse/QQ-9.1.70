package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetNavigationStatusReq {
    public long guildId;

    public GProGetNavigationStatusReq() {
    }

    public long getGuildId() {
        return this.guildId;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public String toString() {
        return "GProGetNavigationStatusReq{guildId=" + this.guildId + ",}";
    }

    public GProGetNavigationStatusReq(long j3) {
        this.guildId = j3;
    }
}
