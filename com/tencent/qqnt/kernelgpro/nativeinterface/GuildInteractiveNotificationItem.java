package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GuildInteractiveNotificationItem {
    public ArrayList<Integer> atTypes;
    public String avatarMeta;
    public String boxManagerAbstract;
    public long cid;
    public int count;
    public long eventLatestTimestampMs;
    public byte[] feedAbstract;
    public String feedId;
    public byte[] feedTabAbstract;
    public String guildId;
    public String guildName;
    public String highLightStr;
    public int highLightType;
    public int mainType;
    public String managerAbstract;
    public long readTimestampMs;
    public long replyTinyId;
    public int reportType;
    public int subType;
    public int type;
    public int unreadType;
    public int updateFrom;

    public GuildInteractiveNotificationItem() {
        this.feedId = "";
        this.avatarMeta = "";
        this.guildId = "";
        this.highLightStr = "";
        this.atTypes = new ArrayList<>();
        this.managerAbstract = "";
        this.boxManagerAbstract = "";
        this.guildName = "";
        this.feedAbstract = new byte[0];
        this.feedTabAbstract = new byte[0];
    }

    public ArrayList<Integer> getAtTypes() {
        return this.atTypes;
    }

    public String getAvatarMeta() {
        return this.avatarMeta;
    }

    public String getBoxManagerAbstract() {
        return this.boxManagerAbstract;
    }

    public long getCid() {
        return this.cid;
    }

    public int getCount() {
        return this.count;
    }

    public long getEventLatestTimestampMs() {
        return this.eventLatestTimestampMs;
    }

    public byte[] getFeedAbstract() {
        return this.feedAbstract;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public byte[] getFeedTabAbstract() {
        return this.feedTabAbstract;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getHighLightStr() {
        return this.highLightStr;
    }

    public int getHighLightType() {
        return this.highLightType;
    }

    public int getMainType() {
        return this.mainType;
    }

    public String getManagerAbstract() {
        return this.managerAbstract;
    }

    public long getReadTimestampMs() {
        return this.readTimestampMs;
    }

    public long getReplyTinyId() {
        return this.replyTinyId;
    }

    public int getReportType() {
        return this.reportType;
    }

    public int getSubType() {
        return this.subType;
    }

    public int getType() {
        return this.type;
    }

    public int getUnreadType() {
        return this.unreadType;
    }

    public int getUpdateFrom() {
        return this.updateFrom;
    }

    public String toString() {
        return "GuildInteractiveNotificationItem{type=" + this.type + ",count=" + this.count + ",readTimestampMs=" + this.readTimestampMs + ",eventLatestTimestampMs=" + this.eventLatestTimestampMs + ",feedId=" + this.feedId + ",replyTinyId=" + this.replyTinyId + ",avatarMeta=" + this.avatarMeta + ",guildId=" + this.guildId + ",highLightStr=" + this.highLightStr + ",unreadType=" + this.unreadType + ",highLightType=" + this.highLightType + ",atTypes=" + this.atTypes + ",managerAbstract=" + this.managerAbstract + ",boxManagerAbstract=" + this.boxManagerAbstract + ",mainType=" + this.mainType + ",subType=" + this.subType + ",reportType=" + this.reportType + ",cid=" + this.cid + ",guildName=" + this.guildName + ",feedAbstract=" + this.feedAbstract + ",updateFrom=" + this.updateFrom + ",feedTabAbstract=" + this.feedTabAbstract + ",}";
    }

    public GuildInteractiveNotificationItem(int i3, int i16, long j3, long j16, String str, long j17, String str2, String str3, String str4, int i17) {
        this.feedId = "";
        this.avatarMeta = "";
        this.guildId = "";
        this.highLightStr = "";
        this.atTypes = new ArrayList<>();
        this.managerAbstract = "";
        this.boxManagerAbstract = "";
        this.guildName = "";
        this.feedAbstract = new byte[0];
        this.feedTabAbstract = new byte[0];
        this.type = i3;
        this.count = i16;
        this.readTimestampMs = j3;
        this.eventLatestTimestampMs = j16;
        this.feedId = str;
        this.replyTinyId = j17;
        this.avatarMeta = str2;
        this.guildId = str3;
        this.highLightStr = str4;
        this.unreadType = i17;
    }
}
