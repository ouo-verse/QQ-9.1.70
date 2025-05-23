package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProTransferGuildOwnerReq {
    public long guildId;
    public long tinyId;

    public long getGuildId() {
        return this.guildId;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProTransferGuildOwnerReq{guildId=" + this.guildId + ",tinyId=" + this.tinyId + ",}";
    }
}
