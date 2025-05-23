package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProQQMsgListGuild {
    public long avatarSeq;
    public long guildId;
    public String guildName;
    public long topTimestamp;

    public GProQQMsgListGuild() {
        this.guildName = "";
    }

    public long getAvatarSeq() {
        return this.avatarSeq;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public long getTopTimestamp() {
        return this.topTimestamp;
    }

    public String toString() {
        return "GProQQMsgListGuild{guildId=" + this.guildId + ",topTimestamp=" + this.topTimestamp + ",guildName=" + this.guildName + ",avatarSeq=" + this.avatarSeq + ",}";
    }

    public GProQQMsgListGuild(long j3, long j16, String str, long j17) {
        this.guildId = j3;
        this.topTimestamp = j16;
        this.guildName = str;
        this.avatarSeq = j17;
    }
}
