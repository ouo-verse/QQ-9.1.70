package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProFetchShareUrlRsp;

/* loaded from: classes17.dex */
public class GGProFetchShareUrlRsp implements IGProFetchShareUrlRsp {
    public final GProFetchShareUrlRsp mInfo;

    public GGProFetchShareUrlRsp(GProFetchShareUrlRsp gProFetchShareUrlRsp) {
        this.mInfo = gProFetchShareUrlRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchShareUrlRsp
    public String getAttaContentId() {
        return this.mInfo.getAttaContentId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchShareUrlRsp
    public boolean getCanShare() {
        return this.mInfo.getCanShare();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchShareUrlRsp
    public String getShareLink() {
        return this.mInfo.getShareLink();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchShareUrlRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
