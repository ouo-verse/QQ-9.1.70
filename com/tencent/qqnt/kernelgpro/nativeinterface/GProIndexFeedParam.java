package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProIndexFeedParam {
    public long guildId;
    public long tinyid;

    public long getGuildId() {
        return this.guildId;
    }

    public long getTinyid() {
        return this.tinyid;
    }

    public String toString() {
        return "GProIndexFeedParam{tinyid=" + this.tinyid + ",guildId=" + this.guildId + ",}";
    }
}
