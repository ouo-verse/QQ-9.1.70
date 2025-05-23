package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetSimpleProfileAsyncRsp;

/* loaded from: classes17.dex */
public class GGProGetSimpleProfileAsyncRsp implements IGProGetSimpleProfileAsyncRsp {
    public final GProGetSimpleProfileAsyncRsp mInfo;

    public GGProGetSimpleProfileAsyncRsp(GProGetSimpleProfileAsyncRsp gProGetSimpleProfileAsyncRsp) {
        this.mInfo = gProGetSimpleProfileAsyncRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetSimpleProfileAsyncRsp
    public IGProSimpleProfile getSimpleProfile() {
        return new GGProSimpleProfile(this.mInfo.getSimpleProfile());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetSimpleProfileAsyncRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
