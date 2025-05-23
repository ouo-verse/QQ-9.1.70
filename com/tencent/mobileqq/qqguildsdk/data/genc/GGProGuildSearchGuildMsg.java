package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchGuildMsg;

/* loaded from: classes17.dex */
public class GGProGuildSearchGuildMsg implements IGProGuildSearchGuildMsg {
    public final GProGuildSearchGuildMsg mInfo;

    public GGProGuildSearchGuildMsg(GProGuildSearchGuildMsg gProGuildSearchGuildMsg) {
        this.mInfo = gProGuildSearchGuildMsg;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildMsg
    public String getAvatar() {
        return this.mInfo.getAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildMsg
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildMsg
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildMsg
    public long getMsgSeq() {
        return this.mInfo.getMsgSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildMsg
    public String getMsgTxt() {
        return this.mInfo.getMsgTxt();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildMsg
    public String getNickName() {
        return this.mInfo.getNickName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildMsg
    public String getPic() {
        return this.mInfo.getPic();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildMsg
    public long getTimeStamp() {
        return this.mInfo.getTimeStamp();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildMsg
    public long getTinyId() {
        return this.mInfo.getTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildMsg
    public int getUserType() {
        return this.mInfo.getUserType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildMsg
    public String getVideo() {
        return this.mInfo.getVideo();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchGuildMsg
    public String toString() {
        return this.mInfo.toString();
    }
}
