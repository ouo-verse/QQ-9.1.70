package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProQueryRecommendGuildInfoRsp {
    public byte[] cookie;
    public GProGuildData guildData;
    public long newDefaultChannelId;
    public long reqInterval;
    public GProRecommendGuildPersonalSetting setting;

    public GProQueryRecommendGuildInfoRsp() {
        this.guildData = new GProGuildData();
        this.setting = new GProRecommendGuildPersonalSetting();
        this.cookie = new byte[0];
    }

    public byte[] getCookie() {
        return this.cookie;
    }

    public GProGuildData getGuildData() {
        return this.guildData;
    }

    public long getNewDefaultChannelId() {
        return this.newDefaultChannelId;
    }

    public long getReqInterval() {
        return this.reqInterval;
    }

    public GProRecommendGuildPersonalSetting getSetting() {
        return this.setting;
    }

    public String toString() {
        return "GProQueryRecommendGuildInfoRsp{guildData=" + this.guildData + ",setting=" + this.setting + ",reqInterval=" + this.reqInterval + ",cookie=" + this.cookie + ",newDefaultChannelId=" + this.newDefaultChannelId + ",}";
    }

    public GProQueryRecommendGuildInfoRsp(GProGuildData gProGuildData, GProRecommendGuildPersonalSetting gProRecommendGuildPersonalSetting, long j3, byte[] bArr, long j16) {
        this.guildData = new GProGuildData();
        new GProRecommendGuildPersonalSetting();
        this.guildData = gProGuildData;
        this.setting = gProRecommendGuildPersonalSetting;
        this.reqInterval = j3;
        this.cookie = bArr;
        this.newDefaultChannelId = j16;
    }
}
