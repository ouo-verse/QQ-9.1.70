package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchAllGuildAIInfoRsp;

/* loaded from: classes17.dex */
public class GGProGuildSearchAllGuildAIInfoRsp implements IGProGuildSearchAllGuildAIInfoRsp {
    public final GProGuildSearchAllGuildAIInfoRsp mInfo;

    public GGProGuildSearchAllGuildAIInfoRsp(GProGuildSearchAllGuildAIInfoRsp gProGuildSearchAllGuildAIInfoRsp) {
        this.mInfo = gProGuildSearchAllGuildAIInfoRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAllGuildAIInfoRsp
    public IGProGuildSearchAISearchInfo getAiSearchInfo() {
        return new GGProGuildSearchAISearchInfo(this.mInfo.getAiSearchInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAllGuildAIInfoRsp
    public String getAnswerMsgId() {
        return this.mInfo.getAnswerMsgId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAllGuildAIInfoRsp
    public String getSessionId() {
        return this.mInfo.getSessionId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAllGuildAIInfoRsp
    public String getUserMsgId() {
        return this.mInfo.getUserMsgId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAllGuildAIInfoRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
