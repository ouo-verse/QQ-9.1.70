package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProUpdateChannelThemeReq {
    public String authMeta;
    public int themeType;
    public long uint64ChannelId;
    public long uint64GuildId;

    public GProUpdateChannelThemeReq() {
        this.authMeta = "";
    }

    public String getAuthMeta() {
        return this.authMeta;
    }

    public int getThemeType() {
        return this.themeType;
    }

    public long getUint64ChannelId() {
        return this.uint64ChannelId;
    }

    public long getUint64GuildId() {
        return this.uint64GuildId;
    }

    public void setAuthMeta(String str) {
        this.authMeta = str;
    }

    public void setThemeType(int i3) {
        this.themeType = i3;
    }

    public void setUint64ChannelId(long j3) {
        this.uint64ChannelId = j3;
    }

    public void setUint64GuildId(long j3) {
        this.uint64GuildId = j3;
    }

    public String toString() {
        return "GProUpdateChannelThemeReq{uint64GuildId=" + this.uint64GuildId + ",uint64ChannelId=" + this.uint64ChannelId + ",authMeta=" + this.authMeta + ",themeType=" + this.themeType + ",}";
    }

    public GProUpdateChannelThemeReq(long j3, long j16, String str, int i3) {
        this.uint64GuildId = j3;
        this.uint64ChannelId = j16;
        this.authMeta = str;
        this.themeType = i3;
    }
}
