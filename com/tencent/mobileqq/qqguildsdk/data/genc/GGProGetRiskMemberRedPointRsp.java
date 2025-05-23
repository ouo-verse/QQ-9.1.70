package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetRiskMemberRedPointRsp;

/* loaded from: classes17.dex */
public class GGProGetRiskMemberRedPointRsp implements IGProGetRiskMemberRedPointRsp {
    public final GProGetRiskMemberRedPointRsp mInfo;

    public GGProGetRiskMemberRedPointRsp(GProGetRiskMemberRedPointRsp gProGetRiskMemberRedPointRsp) {
        this.mInfo = gProGetRiskMemberRedPointRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRiskMemberRedPointRsp
    public long getDuration() {
        return this.mInfo.getDuration();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRiskMemberRedPointRsp
    public long getSeqNo() {
        return this.mInfo.getSeqNo();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRiskMemberRedPointRsp
    public String getTips() {
        return this.mInfo.getTips();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetRiskMemberRedPointRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
