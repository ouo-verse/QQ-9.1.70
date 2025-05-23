package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProGuildSearchUnionResult {
    public boolean feedIsEnd;
    public long feedTotal;
    public boolean msgIsEnd;
    public long msgTotal;
    public ArrayList<GProGuildSearchGuildMsg> guildMsgs = new ArrayList<>();
    public byte[] msgCookie = new byte[0];
    public ArrayList<GProGuildSearchGuildFeed> guildFeeds = new ArrayList<>();
    public byte[] feedCookie = new byte[0];
    public ArrayList<GProGuildSearchMsgGroupInfo> groupList = new ArrayList<>();
    public ArrayList<GProGuildSearchFeedGroupInfo> feedGroupList = new ArrayList<>();
    public String guildNumber = "";
    public String guildName = "";

    public byte[] getFeedCookie() {
        return this.feedCookie;
    }

    public ArrayList<GProGuildSearchFeedGroupInfo> getFeedGroupList() {
        return this.feedGroupList;
    }

    public boolean getFeedIsEnd() {
        return this.feedIsEnd;
    }

    public long getFeedTotal() {
        return this.feedTotal;
    }

    public ArrayList<GProGuildSearchMsgGroupInfo> getGroupList() {
        return this.groupList;
    }

    public ArrayList<GProGuildSearchGuildFeed> getGuildFeeds() {
        return this.guildFeeds;
    }

    public ArrayList<GProGuildSearchGuildMsg> getGuildMsgs() {
        return this.guildMsgs;
    }

    public String getGuildName() {
        return this.guildName;
    }

    public String getGuildNumber() {
        return this.guildNumber;
    }

    public byte[] getMsgCookie() {
        return this.msgCookie;
    }

    public boolean getMsgIsEnd() {
        return this.msgIsEnd;
    }

    public long getMsgTotal() {
        return this.msgTotal;
    }

    public String toString() {
        return "GProGuildSearchUnionResult{msgTotal=" + this.msgTotal + ",guildMsgs=" + this.guildMsgs + ",msgCookie=" + this.msgCookie + ",msgIsEnd=" + this.msgIsEnd + ",feedTotal=" + this.feedTotal + ",guildFeeds=" + this.guildFeeds + ",feedCookie=" + this.feedCookie + ",feedIsEnd=" + this.feedIsEnd + ",groupList=" + this.groupList + ",feedGroupList=" + this.feedGroupList + ",guildNumber=" + this.guildNumber + ",guildName=" + this.guildName + ",}";
    }
}
