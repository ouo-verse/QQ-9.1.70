package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchSession;

/* loaded from: classes17.dex */
public class GGProAISearchSession implements IGProAISearchSession {
    public final GProAISearchSession mInfo;

    public GGProAISearchSession(GProAISearchSession gProAISearchSession) {
        this.mInfo = gProAISearchSession;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSession
    public String getFirstMsgId() {
        return this.mInfo.getFirstMsgId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSession
    public int getIsDeleted() {
        return this.mInfo.getIsDeleted();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSession
    public String getSessionId() {
        return this.mInfo.getSessionId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSession
    public int getSessionStatus() {
        return this.mInfo.getSessionStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSession
    public String getSummary() {
        return this.mInfo.getSummary();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSession
    public long getTimestamp() {
        return this.mInfo.getTimestamp();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSession
    public long getUpdateTimestamp() {
        return this.mInfo.getUpdateTimestamp();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchSession
    public String toString() {
        return this.mInfo.toString();
    }
}
