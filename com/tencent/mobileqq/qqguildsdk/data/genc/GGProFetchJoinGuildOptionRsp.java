package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProFetchJoinGuildOptionRsp;

/* loaded from: classes17.dex */
public class GGProFetchJoinGuildOptionRsp implements IGProFetchJoinGuildOptionRsp {
    public final GProFetchJoinGuildOptionRsp mInfo;

    public GGProFetchJoinGuildOptionRsp(GProFetchJoinGuildOptionRsp gProFetchJoinGuildOptionRsp) {
        this.mInfo = gProFetchJoinGuildOptionRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchJoinGuildOptionRsp
    public boolean getEnableAIGCAnswer() {
        return this.mInfo.getEnableAIGCAnswer();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchJoinGuildOptionRsp
    public IGProJoinGuildSetting getSettingInfo() {
        return new GGProJoinGuildSetting(this.mInfo.getSettingInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchJoinGuildOptionRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
