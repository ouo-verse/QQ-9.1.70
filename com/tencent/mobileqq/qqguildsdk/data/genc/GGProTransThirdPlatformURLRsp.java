package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProTransThirdPlatformURLRsp;

/* loaded from: classes17.dex */
public class GGProTransThirdPlatformURLRsp implements IGProTransThirdPlatformURLRsp {
    public final GProTransThirdPlatformURLRsp mInfo;

    public GGProTransThirdPlatformURLRsp(GProTransThirdPlatformURLRsp gProTransThirdPlatformURLRsp) {
        this.mInfo = gProTransThirdPlatformURLRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTransThirdPlatformURLRsp
    public IGProTencentDocsRsp getTencentDocsRsp() {
        return new GGProTencentDocsRsp(this.mInfo.getTencentDocsRsp());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTransThirdPlatformURLRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
