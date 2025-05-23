package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSetSearchSwitchReq {
    public int GProSearchSwitchTypeOpen;
    public String guildId = "";

    public int getGProSearchSwitchTypeOpen() {
        return this.GProSearchSwitchTypeOpen;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public String toString() {
        return "GProSetSearchSwitchReq{guildId=" + this.guildId + ",GProSearchSwitchTypeOpen=" + this.GProSearchSwitchTypeOpen + ",}";
    }
}
