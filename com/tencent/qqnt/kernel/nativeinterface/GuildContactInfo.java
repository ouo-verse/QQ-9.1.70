package com.tencent.qqnt.kernel.nativeinterface;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class GuildContactInfo {
    public int abstractIconType;
    public int activityType;
    public long avatarSeq;
    public boolean channelHighLight;
    public String channelId;
    public String channelName;
    public int channelSubType;
    public int channelType;
    public String feedId;
    public GuildAbstractType grayAbstractType;
    public String guildId;
    public String guildName;
    public ArrayList<Integer> hasUnreadModuleIds;
    public int highAbstractColorType;
    public boolean isEntered;
    public boolean isShowChannelName;
    public boolean isSticky;
    public String locationId;
    public int moduleId;
    public long msgSeq;
    public long msgType;
    public int newPostUnreadCnt;
    public GuildAbstractType redAbstractType;
    public int unNotifyFlag;
    public UnreadCntInfo unreadCntInfo;

    public GuildContactInfo() {
        this.guildId = "";
        this.channelId = "";
        this.unreadCntInfo = new UnreadCntInfo();
        this.guildName = "";
        this.channelName = "";
        this.grayAbstractType = new GuildAbstractType();
        this.hasUnreadModuleIds = new ArrayList<>();
        this.redAbstractType = new GuildAbstractType();
    }

    public int getAbstractIconType() {
        return this.abstractIconType;
    }

    public int getActivityType() {
        return this.activityType;
    }

    public long getAvatarSeq() {
        return this.avatarSeq;
    }

    public boolean getChannelHighLight() {
        return this.channelHighLight;
    }

    public String getChannelId() {
        return this.channelId;
    }

    public String getChannelName() {
        return this.channelName;
    }

    public int getChannelSubType() {
        return this.channelSubType;
    }

    public int getChannelType() {
        return this.channelType;
    }

    public String getFeedId() {
        return this.feedId;
    }

    public GuildAbstractType getGrayAbstractType() {
        return this.grayAbstractType;
    }

    public String getGuildId() {
        return this.guildId;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public ArrayList<Integer> getHasUnreadModuleIds() {
        return this.hasUnreadModuleIds;
    }

    public int getHighAbstractColorType() {
        return this.highAbstractColorType;
    }

    public boolean getIsEntered() {
        return this.isEntered;
    }

    public boolean getIsShowChannelName() {
        return this.isShowChannelName;
    }

    public boolean getIsSticky() {
        return this.isSticky;
    }

    public String getLocationId() {
        return this.locationId;
    }

    public int getModuleId() {
        return this.moduleId;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getMsgType() {
        return this.msgType;
    }

    public int getNewPostUnreadCnt() {
        return this.newPostUnreadCnt;
    }

    public GuildAbstractType getRedAbstractType() {
        return this.redAbstractType;
    }

    public int getUnNotifyFlag() {
        return this.unNotifyFlag;
    }

    public UnreadCntInfo getUnreadCntInfo() {
        return this.unreadCntInfo;
    }

    public String toString() {
        return "GuildContactInfo{guildId=" + this.guildId + ",channelId=" + this.channelId + ",unreadCntInfo=" + this.unreadCntInfo + ",guildName=" + this.guildName + ",channelName=" + this.channelName + ",channelType=" + this.channelType + ",channelSubType=" + this.channelSubType + ",activityType=" + this.activityType + ",channelHighLight=" + this.channelHighLight + ",avatarSeq=" + this.avatarSeq + ",msgType=" + this.msgType + ",msgSeq=" + this.msgSeq + ",isSticky=" + this.isSticky + ",isEntered=" + this.isEntered + ",isShowChannelName=" + this.isShowChannelName + ",grayAbstractType=" + this.grayAbstractType + ",feedId=" + this.feedId + ",moduleId=" + this.moduleId + ",hasUnreadModuleIds=" + this.hasUnreadModuleIds + ",locationId=" + this.locationId + ",redAbstractType=" + this.redAbstractType + ",highAbstractColorType=" + this.highAbstractColorType + ",abstractIconType=" + this.abstractIconType + ",unNotifyFlag=" + this.unNotifyFlag + ",newPostUnreadCnt=" + this.newPostUnreadCnt + ",}";
    }

    public GuildContactInfo(String str, String str2, UnreadCntInfo unreadCntInfo, String str3, String str4, int i3, int i16, int i17, boolean z16, long j3, long j16, long j17, boolean z17, boolean z18, boolean z19, String str5, int i18, ArrayList<Integer> arrayList, String str6, int i19) {
        this.guildId = "";
        this.channelId = "";
        this.unreadCntInfo = new UnreadCntInfo();
        this.guildName = "";
        this.channelName = "";
        this.grayAbstractType = new GuildAbstractType();
        this.hasUnreadModuleIds = new ArrayList<>();
        this.redAbstractType = new GuildAbstractType();
        this.guildId = str;
        this.channelId = str2;
        this.unreadCntInfo = unreadCntInfo;
        this.guildName = str3;
        this.channelName = str4;
        this.channelType = i3;
        this.channelSubType = i16;
        this.activityType = i17;
        this.channelHighLight = z16;
        this.avatarSeq = j3;
        this.msgType = j16;
        this.msgSeq = j17;
        this.isSticky = z17;
        this.isEntered = z18;
        this.isShowChannelName = z19;
        this.feedId = str5;
        this.moduleId = i18;
        this.hasUnreadModuleIds = arrayList;
        this.locationId = str6;
        this.highAbstractColorType = i19;
    }
}
