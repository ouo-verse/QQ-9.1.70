package com.tencent.qqnt.kernelgpro.nativeinterface;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GproXWorldInfo {
    public boolean allowDisplay;
    public long bindTime;
    public long guildId;
    public String guildName;
    public String guildUrl;

    public GproXWorldInfo() {
        this.guildUrl = "";
        this.guildName = "";
    }

    public boolean getAllowDisplay() {
        return this.allowDisplay;
    }

    public long getBindTime() {
        return this.bindTime;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getGuildUrl() {
        return this.guildUrl;
    }

    public String toString() {
        return "GproXWorldInfo{allowDisplay=" + this.allowDisplay + ",guildId=" + this.guildId + ",guildUrl=" + this.guildUrl + ",bindTime=" + this.bindTime + ",guildName=" + this.guildName + ",}";
    }

    public GproXWorldInfo(boolean z16, long j3, String str, long j16, String str2) {
        this.allowDisplay = z16;
        this.guildId = j3;
        this.guildUrl = str;
        this.bindTime = j16;
        this.guildName = str2;
    }
}
