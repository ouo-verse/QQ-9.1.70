package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProRemoveRiskMembersRsp;

/* loaded from: classes17.dex */
public class GGProRemoveRiskMembersRsp implements IGProRemoveRiskMembersRsp {
    public final GProRemoveRiskMembersRsp mInfo;

    public GGProRemoveRiskMembersRsp(GProRemoveRiskMembersRsp gProRemoveRiskMembersRsp) {
        this.mInfo = gProRemoveRiskMembersRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProRemoveRiskMembersRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
