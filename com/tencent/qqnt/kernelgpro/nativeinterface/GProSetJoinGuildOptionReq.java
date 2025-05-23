package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProSetJoinGuildOptionReq {
    public long guildId;
    public GProJoinGuildSetting settingInfo;

    public GProSetJoinGuildOptionReq() {
        this.settingInfo = new GProJoinGuildSetting();
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProJoinGuildSetting getSettingInfo() {
        return this.settingInfo;
    }

    public void setGuildId(long j3) {
        this.guildId = j3;
    }

    public void setSettingInfo(GProJoinGuildSetting gProJoinGuildSetting) {
        this.settingInfo = gProJoinGuildSetting;
    }

    public String toString() {
        return "GProSetJoinGuildOptionReq{guildId=" + this.guildId + ",settingInfo=" + this.settingInfo + ",}";
    }

    public GProSetJoinGuildOptionReq(long j3, GProJoinGuildSetting gProJoinGuildSetting) {
        new GProJoinGuildSetting();
        this.guildId = j3;
        this.settingInfo = gProJoinGuildSetting;
    }
}
