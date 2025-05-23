package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProDeleteFeedRsp;

/* loaded from: classes17.dex */
public class GGProDeleteFeedRsp implements IGProDeleteFeedRsp {
    public final GProDeleteFeedRsp mInfo;

    public GGProDeleteFeedRsp(GProDeleteFeedRsp gProDeleteFeedRsp) {
        this.mInfo = gProDeleteFeedRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProDeleteFeedRsp
    public IGProFDLStCommonExt getExtInfo() {
        return new GGProFDLStCommonExt(this.mInfo.getExtInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProDeleteFeedRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
