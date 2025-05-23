package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProJoinGuilds implements Serializable {
    public long guildId;
    long serialVersionUID = 1;
    public String joinGuildSig = "";

    public long getGuildId() {
        return this.guildId;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setJoinGuildSig(String str) {
        this.joinGuildSig = str;
    }

    public String toString() {
        return "GProJoinGuilds{guildId=" + this.guildId + ",joinGuildSig=" + this.joinGuildSig + ",}";
    }
}
