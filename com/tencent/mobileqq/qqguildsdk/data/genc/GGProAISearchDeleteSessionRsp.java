package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProAISearchDeleteSessionRsp;

/* loaded from: classes17.dex */
public class GGProAISearchDeleteSessionRsp implements IGProAISearchDeleteSessionRsp {
    public final GProAISearchDeleteSessionRsp mInfo;

    public GGProAISearchDeleteSessionRsp(GProAISearchDeleteSessionRsp gProAISearchDeleteSessionRsp) {
        this.mInfo = gProAISearchDeleteSessionRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProAISearchDeleteSessionRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
