package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProRecommendQuickJoinItem {
    public long channelId;
    public long guildId;
    public String joinSig;
    public String mainSource;
    public String subSource;

    public GProRecommendQuickJoinItem() {
        this.mainSource = "";
        this.subSource = "";
        this.joinSig = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getJoinSig() {
        return this.joinSig;
    }

    public String getMainSource() {
        return this.mainSource;
    }

    public String getSubSource() {
        return this.subSource;
    }

    public String toString() {
        return "GProRecommendQuickJoinItem{guildId=" + this.guildId + ",channelId=" + this.channelId + ",mainSource=" + this.mainSource + ",subSource=" + this.subSource + ",joinSig=" + this.joinSig + ",}";
    }

    public GProRecommendQuickJoinItem(long j3, long j16, String str, String str2, String str3) {
        this.guildId = j3;
        this.channelId = j16;
        this.mainSource = str;
        this.subSource = str2;
        this.joinSig = str3;
    }
}
