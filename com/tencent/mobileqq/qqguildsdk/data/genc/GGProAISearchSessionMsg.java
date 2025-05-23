package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchSessionMsg;

/* loaded from: classes17.dex */
public class GGProAISearchSessionMsg implements IGProAISearchSessionMsg {
    public final GProAISearchSessionMsg mInfo;

    public GGProAISearchSessionMsg(GProAISearchSessionMsg gProAISearchSessionMsg) {
        this.mInfo = gProAISearchSessionMsg;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSessionMsg
    public IGProAISearchMsgContent getContent() {
        return new GGProAISearchMsgContent(this.mInfo.getContent());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSessionMsg
    public String getCoupleId() {
        return this.mInfo.getCoupleId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSessionMsg
    public long getCreateTime() {
        return this.mInfo.getCreateTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSessionMsg
    public boolean getIsFold() {
        return this.mInfo.getIsFold();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSessionMsg
    public int getModelType() {
        return this.mInfo.getModelType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSessionMsg
    public String getMsgId() {
        return this.mInfo.getMsgId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSessionMsg
    public String getMsgShareSummary() {
        return this.mInfo.getMsgShareSummary();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSessionMsg
    public int getMsgStatus() {
        return this.mInfo.getMsgStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSessionMsg
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSessionMsg
    public long getUin() {
        return this.mInfo.getUin();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSessionMsg
    public String toString() {
        return this.mInfo.toString();
    }
}
