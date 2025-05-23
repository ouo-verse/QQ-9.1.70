package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;

/* loaded from: classes24.dex */
public final class GProCmd0xf67ReqBody {
    public long applicantUin;
    public long guildId;
    public int notSendBasicNotice;
    public boolean notSendSystemNotice;
    public int srcId;
    public String joinGuildSig = "";
    public GProSourceId srcInfo = new GProSourceId();
    public String joinGuildAnswerPlaintext = "";
    public String joinGuildComment = "";
    public String strUuid = "";
    public byte[] extData = new byte[0];
    public ArrayList<GProJoinGuilds> joinGuildsList = new ArrayList<>();
    public GProFieldFilter guildInfoFilter = new GProFieldFilter();
    public GProCmd0xf5dFieldFilter channelInfoFilter = new GProCmd0xf5dFieldFilter();
    public ArrayList<GProJoinGuildAnswer> joinGuildAnswers = new ArrayList<>();
    public ArrayList<Long> invitedUinList = new ArrayList<>();

    public long getApplicantUin() {
        return this.applicantUin;
    }

    public GProCmd0xf5dFieldFilter getChannelInfoFilter() {
        return this.channelInfoFilter;
    }

    public byte[] getExtData() {
        return this.extData;
    }

    public long getGuildId() {
        return this.guildId;
    }

    public GProFieldFilter getGuildInfoFilter() {
        return this.guildInfoFilter;
    }

    public ArrayList<Long> getInvitedUinList() {
        return this.invitedUinList;
    }

    public String getJoinGuildAnswerPlaintext() {
        return this.joinGuildAnswerPlaintext;
    }

    public ArrayList<GProJoinGuildAnswer> getJoinGuildAnswers() {
        return this.joinGuildAnswers;
    }

    public String getJoinGuildComment() {
        return this.joinGuildComment;
    }

    public String getJoinGuildSig() {
        return this.joinGuildSig;
    }

    public ArrayList<GProJoinGuilds> getJoinGuildsList() {
        return this.joinGuildsList;
    }

    public int getNotSendBasicNotice() {
        return this.notSendBasicNotice;
    }

    public boolean getNotSendSystemNotice() {
        return this.notSendSystemNotice;
    }

    public int getSrcId() {
        return this.srcId;
    }

    public GProSourceId getSrcInfo() {
        return this.srcInfo;
    }

    public String getStrUuid() {
        return this.strUuid;
    }

    public String toString() {
        return "GProCmd0xf67ReqBody{guildId=" + this.guildId + ",srcId=" + this.srcId + ",joinGuildSig=" + this.joinGuildSig + ",srcInfo=" + this.srcInfo + ",joinGuildAnswerPlaintext=" + this.joinGuildAnswerPlaintext + ",joinGuildComment=" + this.joinGuildComment + ",applicantUin=" + this.applicantUin + ",strUuid=" + this.strUuid + ",extData=" + this.extData + ",notSendSystemNotice=" + this.notSendSystemNotice + ",joinGuildsList=" + this.joinGuildsList + ",guildInfoFilter=" + this.guildInfoFilter + ",channelInfoFilter=" + this.channelInfoFilter + ",joinGuildAnswers=" + this.joinGuildAnswers + ",invitedUinList=" + this.invitedUinList + ",notSendBasicNotice=" + this.notSendBasicNotice + ",}";
    }
}
