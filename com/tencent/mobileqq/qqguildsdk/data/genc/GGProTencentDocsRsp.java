package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProTencentDocsRsp;

/* loaded from: classes17.dex */
public class GGProTencentDocsRsp implements IGProTencentDocsRsp {
    public final GProTencentDocsRsp mInfo;

    public GGProTencentDocsRsp(GProTencentDocsRsp gProTencentDocsRsp) {
        this.mInfo = gProTencentDocsRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTencentDocsRsp
    public String getIcon() {
        return this.mInfo.getIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTencentDocsRsp
    public String getPermission() {
        return this.mInfo.getPermission();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTencentDocsRsp
    public String getPlatformName() {
        return this.mInfo.getPlatformName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTencentDocsRsp
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTencentDocsRsp
    public String getUrl() {
        return this.mInfo.getUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTencentDocsRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
