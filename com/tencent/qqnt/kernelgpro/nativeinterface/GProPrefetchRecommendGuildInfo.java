package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProPrefetchRecommendGuildInfo implements Serializable {
    public String category;
    public String guildIcon;
    public long guildId;
    long serialVersionUID;

    public GProPrefetchRecommendGuildInfo() {
        this.serialVersionUID = 1L;
        this.guildIcon = "";
        this.category = "";
    }

    public String getCategory() {
        return this.category;
    }

    public String getGuildIcon() {
        return this.guildIcon;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProPrefetchRecommendGuildInfo{guildId=" + this.guildId + ",guildIcon=" + this.guildIcon + ",category=" + this.category + ",}";
    }

    public GProPrefetchRecommendGuildInfo(long j3, String str, String str2) {
        this.serialVersionUID = 1L;
        this.guildId = j3;
        this.guildIcon = str;
        this.category = str2;
    }
}
