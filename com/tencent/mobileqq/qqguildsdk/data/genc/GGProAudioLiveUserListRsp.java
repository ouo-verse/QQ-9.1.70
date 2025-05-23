package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.ChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.GGProChannelUserNum;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelUserNum;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAudioLiveUserListRsp;

/* loaded from: classes17.dex */
public class GGProAudioLiveUserListRsp implements IGProAudioLiveUserListRsp {
    public final GProAudioLiveUserListRsp mInfo;

    public GGProAudioLiveUserListRsp(GProAudioLiveUserListRsp gProAudioLiveUserListRsp) {
        this.mInfo = gProAudioLiveUserListRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudioLiveUserListRsp
    public IAudioChannelMemberInfos getChannelMemberInfo() {
        return new ChannelMemberInfos(this.mInfo.getChannelMemberInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudioLiveUserListRsp
    public IGProChannelUserNum getChannelUserNum() {
        return new GGProChannelUserNum(this.mInfo.getChannelUserNum());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudioLiveUserListRsp
    public IAudioChannelMemberInfos getHandUpMemberInfo() {
        return new ChannelMemberInfos(this.mInfo.getHandUpMemberInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudioLiveUserListRsp
    public boolean getIsEndPage() {
        return this.mInfo.getIsEndPage();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudioLiveUserListRsp
    public long getNextReadInterval() {
        return this.mInfo.getNextReadInterval();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudioLiveUserListRsp
    public IAudioChannelMemberInfos getSpeakOrderMemberInfo() {
        return new ChannelMemberInfos(this.mInfo.getSpeakOrderMemberInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAudioLiveUserListRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
