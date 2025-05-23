package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.io.Serializable;

/* loaded from: classes24.dex */
public final class GProAudioLiveUserListRsp implements Serializable {
    public GProChannelMemberInfos channelMemberInfo;
    public GProChannelUserNum channelUserNum;
    public GProChannelMemberInfos handUpMemberInfo;
    public boolean isEndPage;
    public long nextReadInterval;
    long serialVersionUID;
    public GProChannelMemberInfos speakOrderMemberInfo;

    public GProAudioLiveUserListRsp() {
        this.serialVersionUID = 1L;
        this.channelMemberInfo = new GProChannelMemberInfos();
        this.handUpMemberInfo = new GProChannelMemberInfos();
        this.speakOrderMemberInfo = new GProChannelMemberInfos();
        this.channelUserNum = new GProChannelUserNum();
    }

    public GProChannelMemberInfos getChannelMemberInfo() {
        return this.channelMemberInfo;
    }

    public GProChannelUserNum getChannelUserNum() {
        return this.channelUserNum;
    }

    public GProChannelMemberInfos getHandUpMemberInfo() {
        return this.handUpMemberInfo;
    }

    public boolean getIsEndPage() {
        return this.isEndPage;
    }

    public long getNextReadInterval() {
        return this.nextReadInterval;
    }

    public GProChannelMemberInfos getSpeakOrderMemberInfo() {
        return this.speakOrderMemberInfo;
    }

    public String toString() {
        return "GProAudioLiveUserListRsp{channelMemberInfo=" + this.channelMemberInfo + ",handUpMemberInfo=" + this.handUpMemberInfo + ",nextReadInterval=" + this.nextReadInterval + ",isEndPage=" + this.isEndPage + ",speakOrderMemberInfo=" + this.speakOrderMemberInfo + ",channelUserNum=" + this.channelUserNum + ",}";
    }

    public GProAudioLiveUserListRsp(GProChannelMemberInfos gProChannelMemberInfos, GProChannelMemberInfos gProChannelMemberInfos2, long j3, boolean z16, GProChannelMemberInfos gProChannelMemberInfos3, GProChannelUserNum gProChannelUserNum) {
        this.serialVersionUID = 1L;
        this.channelMemberInfo = new GProChannelMemberInfos();
        this.handUpMemberInfo = new GProChannelMemberInfos();
        this.speakOrderMemberInfo = new GProChannelMemberInfos();
        new GProChannelUserNum();
        this.channelMemberInfo = gProChannelMemberInfos;
        this.handUpMemberInfo = gProChannelMemberInfos2;
        this.nextReadInterval = j3;
        this.isEndPage = z16;
        this.speakOrderMemberInfo = gProChannelMemberInfos3;
        this.channelUserNum = gProChannelUserNum;
    }
}
