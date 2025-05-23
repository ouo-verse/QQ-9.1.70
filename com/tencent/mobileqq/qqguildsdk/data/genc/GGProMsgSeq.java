package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMsgSeq;

/* loaded from: classes17.dex */
public class GGProMsgSeq implements IGProMsgSeq {
    public final GProMsgSeq mInfo;

    public GGProMsgSeq(GProMsgSeq gProMsgSeq) {
        this.mInfo = gProMsgSeq;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMsgSeq
    public long getSeq() {
        return this.mInfo.getSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMsgSeq
    public long getTime() {
        return this.mInfo.getTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMsgSeq
    public String toString() {
        return this.mInfo.toString();
    }
}
