package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGuildEssenceSvrReq implements Serializable {
    public long guildId;
    long serialVersionUID = 1;
    public GProUnifiedEssenceInfo unifiedEssenceInfo;

    public GProGuildEssenceSvrReq() {
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProUnifiedEssenceInfo getUnifiedEssenceInfo() {
        return this.unifiedEssenceInfo;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setUnifiedEssenceInfo(GProUnifiedEssenceInfo gProUnifiedEssenceInfo) {
        this.unifiedEssenceInfo = gProUnifiedEssenceInfo;
    }

    public String toString() {
        return "GProGuildEssenceSvrReq{guildId=" + this.guildId + ",unifiedEssenceInfo=" + this.unifiedEssenceInfo + ",}";
    }

    public GProGuildEssenceSvrReq(long j3, GProUnifiedEssenceInfo gProUnifiedEssenceInfo) {
        this.guildId = j3;
        this.unifiedEssenceInfo = gProUnifiedEssenceInfo;
    }
}
