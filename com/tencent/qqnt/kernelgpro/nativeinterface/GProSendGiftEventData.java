package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProSendGiftEventData implements Serializable {
    public long channelId;
    public String eventId;
    public GProGiftInfo giftInfo;
    public long guildId;
    public GProUser receiverMember;
    public GProUser senderMember;
    long serialVersionUID;

    public GProSendGiftEventData() {
        this.serialVersionUID = 1L;
        this.eventId = "";
        this.senderMember = new GProUser();
        this.receiverMember = new GProUser();
        this.giftInfo = new GProGiftInfo();
    }

    public long getChannelId() {
        return this.channelId;
    }

    public String getEventId() {
        return this.eventId;
    }

    public GProGiftInfo getGiftInfo() {
        return this.giftInfo;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProUser getReceiverMember() {
        return this.receiverMember;
    }

    public GProUser getSenderMember() {
        return this.senderMember;
    }

    public String toString() {
        return "GProSendGiftEventData{guildId=" + this.guildId + ",channelId=" + this.channelId + ",eventId=" + this.eventId + ",senderMember=" + this.senderMember + ",receiverMember=" + this.receiverMember + ",giftInfo=" + this.giftInfo + ",}";
    }

    public GProSendGiftEventData(long j3, long j16, String str, GProUser gProUser, GProUser gProUser2, GProGiftInfo gProGiftInfo) {
        this.serialVersionUID = 1L;
        this.eventId = "";
        this.senderMember = new GProUser();
        this.receiverMember = new GProUser();
        new GProGiftInfo();
        this.guildId = j3;
        this.channelId = j16;
        this.eventId = str;
        this.senderMember = gProUser;
        this.receiverMember = gProUser2;
        this.giftInfo = gProGiftInfo;
    }
}
