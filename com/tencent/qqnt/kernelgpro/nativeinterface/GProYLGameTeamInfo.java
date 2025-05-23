package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProYLGameTeamInfo {
    public long channelId;
    public int curMemmberNum;
    public String gameAppid;
    public String gameEnvVersion;
    public String gameExtraData;
    public int gameId;
    public String gamePath;
    public long guildId;
    public String icon;
    public boolean isPk;
    public int modeId;
    public long readyExpireTime;
    public long teamId;
    public int teamStatus;
    public int totalMemberNum;

    public GProYLGameTeamInfo() {
        this.icon = "";
        this.gameAppid = "";
        this.gamePath = "";
        this.gameExtraData = "";
        this.gameEnvVersion = "";
    }

    public long getChannelId() {
        return this.channelId;
    }

    public int getCurMemmberNum() {
        return this.curMemmberNum;
    }

    public String getGameAppid() {
        return this.gameAppid;
    }

    public String getGameEnvVersion() {
        return this.gameEnvVersion;
    }

    public String getGameExtraData() {
        return this.gameExtraData;
    }

    public int getGameId() {
        return this.gameId;
    }

    public String getGamePath() {
        return this.gamePath;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getIcon() {
        return this.icon;
    }

    public boolean getIsPk() {
        return this.isPk;
    }

    public int getModeId() {
        return this.modeId;
    }

    public long getReadyExpireTime() {
        return this.readyExpireTime;
    }

    public long getTeamId() {
        return this.teamId;
    }

    public int getTeamStatus() {
        return this.teamStatus;
    }

    public int getTotalMemberNum() {
        return this.totalMemberNum;
    }

    public String toString() {
        return "GProYLGameTeamInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",teamId=" + this.teamId + ",teamStatus=" + this.teamStatus + ",readyExpireTime=" + this.readyExpireTime + ",icon=" + this.icon + ",totalMemberNum=" + this.totalMemberNum + ",curMemmberNum=" + this.curMemmberNum + ",gameId=" + this.gameId + ",gameAppid=" + this.gameAppid + ",gamePath=" + this.gamePath + ",gameExtraData=" + this.gameExtraData + ",gameEnvVersion=" + this.gameEnvVersion + ",modeId=" + this.modeId + ",isPk=" + this.isPk + ",}";
    }

    public GProYLGameTeamInfo(long j3, long j16, long j17, int i3, long j18, String str, int i16, int i17, int i18, String str2, String str3, String str4, String str5, int i19, boolean z16) {
        this.guildId = j3;
        this.channelId = j16;
        this.teamId = j17;
        this.teamStatus = i3;
        this.readyExpireTime = j18;
        this.icon = str;
        this.totalMemberNum = i16;
        this.curMemmberNum = i17;
        this.gameId = i18;
        this.gameAppid = str2;
        this.gamePath = str3;
        this.gameExtraData = str4;
        this.gameEnvVersion = str5;
        this.modeId = i19;
        this.isPk = z16;
    }
}
