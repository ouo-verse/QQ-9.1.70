package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopMsg;

/* loaded from: classes17.dex */
public class GGProTopMsg implements IGProTopMsg {
    public final GProTopMsg mInfo;

    public GGProTopMsg(GProTopMsg gProTopMsg) {
        this.mInfo = gProTopMsg;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTopMsg
    public long getOperatorTinyid() {
        return this.mInfo.getOperatorTinyid();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTopMsg
    public long getSeq() {
        return this.mInfo.getSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTopMsg
    public long getTime() {
        return this.mInfo.getTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTopMsg
    public int getTopMsgType() {
        return this.mInfo.getTopMsgType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTopMsg
    public String toString() {
        return this.mInfo.toString();
    }
}
