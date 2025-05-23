package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProMsgGuildRole {
    public boolean bHoist;
    public long color;
    public long guildId;
    public String name = "";
    public long roleId;
    public long tinyId;

    public boolean getBHoist() {
        return this.bHoist;
    }

    public long getColor() {
        return this.color;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getName() {
        return this.name;
    }

    public long getRoleId() {
        return this.roleId;
    }

    public long getTinyId() {
        return this.tinyId;
    }

    public String toString() {
        return "GProMsgGuildRole{guildId=" + this.guildId + ",tinyId=" + this.tinyId + ",roleId=" + this.roleId + ",name=" + this.name + ",color=" + this.color + ",bHoist=" + this.bHoist + ",}";
    }
}
