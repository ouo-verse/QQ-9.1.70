package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopMsg;

/* loaded from: classes17.dex */
public class GProTopMsgInfo implements IGProTopMsg {
    public GProTopMsg mInfo;

    public GProTopMsgInfo(GProTopMsg gProTopMsg) {
        this.mInfo = gProTopMsg;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg
    public long getTopMsgOperatorTinyId() {
        return this.mInfo.getOperatorTinyid();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg
    public long getTopMsgSeq() {
        return this.mInfo.getSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg
    public long getTopMsgTime() {
        return this.mInfo.getTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProTopMsg
    public int getTopMsgType() {
        return this.mInfo.getTopMsgType();
    }
}
