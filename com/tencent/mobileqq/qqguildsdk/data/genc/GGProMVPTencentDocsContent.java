package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPTencentDocsContent;

/* loaded from: classes17.dex */
public class GGProMVPTencentDocsContent implements IGProMVPTencentDocsContent {
    public final GProMVPTencentDocsContent mInfo;

    public GGProMVPTencentDocsContent(GProMVPTencentDocsContent gProMVPTencentDocsContent) {
        this.mInfo = gProMVPTencentDocsContent;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPTencentDocsContent
    public int getDocType() {
        return this.mInfo.getDocType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPTencentDocsContent
    public String getIcon() {
        return this.mInfo.getIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPTencentDocsContent
    public String getPermission() {
        return this.mInfo.getPermission();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPTencentDocsContent
    public String getPlatformName() {
        return this.mInfo.getPlatformName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPTencentDocsContent
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPTencentDocsContent
    public String getUrl() {
        return this.mInfo.getUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPTencentDocsContent
    public String toString() {
        return this.mInfo.toString();
    }
}
