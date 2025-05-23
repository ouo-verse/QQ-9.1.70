package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProCreateGuildRsp {
    public long guildId;
    public GProSecurityResult secRet = new GProSecurityResult();

    public long getGuildId() {
        return this.guildId;
    }

    public GProSecurityResult getSecRet() {
        return this.secRet;
    }

    public String toString() {
        return "GProCreateGuildRsp{guildId=" + this.guildId + ",secRet=" + this.secRet + ",}";
    }
}
