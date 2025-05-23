package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProCheckFeedAbstractInfoRsp;

/* loaded from: classes17.dex */
public class GGProCheckFeedAbstractInfoRsp implements IGProCheckFeedAbstractInfoRsp {
    public final GProCheckFeedAbstractInfoRsp mInfo;

    public GGProCheckFeedAbstractInfoRsp(GProCheckFeedAbstractInfoRsp gProCheckFeedAbstractInfoRsp) {
        this.mInfo = gProCheckFeedAbstractInfoRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCheckFeedAbstractInfoRsp
    public String getAbstractInfo() {
        return this.mInfo.getAbstractInfo();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCheckFeedAbstractInfoRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
