package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProGetPreviewNavigationReq {
    public long guildId;

    public GProGetPreviewNavigationReq() {
    }

    public long getGuildId() {
        return this.guildId;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public String toString() {
        return "GProGetPreviewNavigationReq{guildId=" + this.guildId + ",}";
    }

    public GProGetPreviewNavigationReq(long j3) {
        this.guildId = j3;
    }
}
