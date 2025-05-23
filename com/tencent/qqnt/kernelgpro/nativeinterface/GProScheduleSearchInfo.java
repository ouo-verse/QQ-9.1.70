package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProScheduleSearchInfo {
    public int acceptedNums;
    public long channelId;
    public long endTimeMs;
    public long guildId;
    public int inviteStatus;
    public long scheduleId;
    public long startTimeMs;
    public String title = "";
    public String content = "";
    public GProSearchUser creator = new GProSearchUser();
    public String guildName = "";
    public String guildHeadUrl = "";
    public String joinGuildSig = "";
    public String channelName = "";
    public ArrayList<String> tags = new ArrayList<>();
    public GProRecallInfo recallInfo = new GProRecallInfo();

    public int getAcceptedNums() {
        return this.acceptedNums;
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public String getContent() {
        return this.content;
    }

    public GProSearchUser getCreator() {
        return this.creator;
    }

    public long getEndTimeMs() {
        return this.endTimeMs;
    }

    public String getGuildHeadUrl() {
        return this.guildHeadUrl;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public int getInviteStatus() {
        return this.inviteStatus;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public GProRecallInfo getRecallInfo() {
        return this.recallInfo;
    }

    public long getScheduleId() {
        return this.scheduleId;
    }

    public long getStartTimeMs() {
        return this.startTimeMs;
    }

    public ArrayList<String> getTags() {
        return this.tags;
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return "GProScheduleSearchInfo{scheduleId=" + this.scheduleId + ",title=" + this.title + ",startTimeMs=" + this.startTimeMs + ",endTimeMs=" + this.endTimeMs + ",content=" + this.content + ",creator=" + this.creator + ",acceptedNums=" + this.acceptedNums + ",guildId=" + this.guildId + ",guildName=" + this.guildName + ",guildHeadUrl=" + this.guildHeadUrl + ",channelId=" + this.channelId + ",joinGuildSig=" + this.joinGuildSig + ",channelName=" + this.channelName + ",tags=" + this.tags + ",recallInfo=" + this.recallInfo + ",inviteStatus=" + this.inviteStatus + ",}";
    }
}
