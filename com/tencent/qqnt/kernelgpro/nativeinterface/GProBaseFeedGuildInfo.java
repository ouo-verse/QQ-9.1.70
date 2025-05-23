package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProBaseFeedGuildInfo implements Serializable {
    public long guildId;
    public long joinTime;
    long serialVersionUID = 1;
    public String name = "";

    public long getGuildId() {
        return this.guildId;
    }

    public long getJoinTime() {
        return this.joinTime;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return "GProBaseFeedGuildInfo{guildId=" + this.guildId + ",name=" + this.name + ",joinTime=" + this.joinTime + ",}";
    }
}
