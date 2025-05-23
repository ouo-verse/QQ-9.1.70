package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProFetchCategoryAdminDisplayInfoReq {
    public long guildId;

    public GProFetchCategoryAdminDisplayInfoReq() {
    }

    public long getGuildId() {
        return this.guildId;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public String toString() {
        return "GProFetchCategoryAdminDisplayInfoReq{guildId=" + this.guildId + ",}";
    }

    public GProFetchCategoryAdminDisplayInfoReq(long j3) {
        this.guildId = j3;
    }
}
