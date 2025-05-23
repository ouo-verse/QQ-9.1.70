package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProGuildSpeakableThreshold implements Serializable {
    public boolean guildNeedJoinRole;
    public long guildNeedJoinTime;
    public boolean guildNeedRealName;
    public boolean privateNeedJoinRole;
    public long privateNeedJoinTime;
    public boolean privateNeedRealName;
    long serialVersionUID = 1;

    public GProGuildSpeakableThreshold() {
    }

    public boolean getGuildNeedJoinRole() {
        return this.guildNeedJoinRole;
    }

    public long getGuildNeedJoinTime() {
        return this.guildNeedJoinTime;
    }

    public boolean getGuildNeedRealName() {
        return this.guildNeedRealName;
    }

    public boolean getPrivateNeedJoinRole() {
        return this.privateNeedJoinRole;
    }

    public long getPrivateNeedJoinTime() {
        return this.privateNeedJoinTime;
    }

    public boolean getPrivateNeedRealName() {
        return this.privateNeedRealName;
    }

    public String toString() {
        return "GProGuildSpeakableThreshold{guildNeedRealName=" + this.guildNeedRealName + ",guildNeedJoinRole=" + this.guildNeedJoinRole + ",guildNeedJoinTime=" + this.guildNeedJoinTime + ",privateNeedRealName=" + this.privateNeedRealName + ",privateNeedJoinRole=" + this.privateNeedJoinRole + ",privateNeedJoinTime=" + this.privateNeedJoinTime + ",}";
    }

    public GProGuildSpeakableThreshold(boolean z16, boolean z17, long j3, boolean z18, boolean z19, long j16) {
        this.guildNeedRealName = z16;
        this.guildNeedJoinRole = z17;
        this.guildNeedJoinTime = j3;
        this.privateNeedRealName = z18;
        this.privateNeedJoinRole = z19;
        this.privateNeedJoinTime = j16;
    }
}
