package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProUnionResult {
    public boolean feedIsEnd;
    public long feedTotal;
    public boolean msgIsEnd;
    public long msgTotal;
    public ArrayList<GProGuildMsgSearchRes> guildMsgs = new ArrayList<>();
    public byte[] msgCookie = new byte[0];
    public ArrayList<GProGuildFeedSearchRes> guildFeeds = new ArrayList<>();
    public byte[] feedCookie = new byte[0];

    public byte[] getFeedCookie() {
        return this.feedCookie;
    }

    public boolean getFeedIsEnd() {
        return this.feedIsEnd;
    }

    public long getFeedTotal() {
        return this.feedTotal;
    }

    public ArrayList<GProGuildFeedSearchRes> getGuildFeeds() {
        return this.guildFeeds;
    }

    public ArrayList<GProGuildMsgSearchRes> getGuildMsgs() {
        return this.guildMsgs;
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
        return "GProUnionResult{msgTotal=" + this.msgTotal + ",guildMsgs=" + this.guildMsgs + ",msgCookie=" + this.msgCookie + ",msgIsEnd=" + this.msgIsEnd + ",feedTotal=" + this.feedTotal + ",guildFeeds=" + this.guildFeeds + ",feedCookie=" + this.feedCookie + ",feedIsEnd=" + this.feedIsEnd + ",}";
    }
}
