package com.tencent.qqnt.kernel.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchGuildJump {
    public long guildId;
    public int joinStatus;
    public String joinGuildSig = "";
    public String guildNumber = "";

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildNumber() {
        return this.guildNumber;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public int getJoinStatus() {
        return this.joinStatus;
    }

    public String toString() {
        return "SearchGuildJump{guildId=" + this.guildId + ",joinGuildSig=" + this.joinGuildSig + ",joinStatus=" + this.joinStatus + ",guildNumber=" + this.guildNumber + ",}";
    }
}
