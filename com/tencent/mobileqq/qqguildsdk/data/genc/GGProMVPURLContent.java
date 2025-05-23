package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPURLContent;

/* loaded from: classes17.dex */
public class GGProMVPURLContent implements IGProMVPURLContent {
    public final GProMVPURLContent mInfo;

    public GGProMVPURLContent(GProMVPURLContent gProMVPURLContent) {
        this.mInfo = gProMVPURLContent;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPURLContent
    public String getDisplayText() {
        return this.mInfo.getDisplayText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPURLContent
    public int getIconType() {
        return this.mInfo.getIconType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPURLContent
    public IGProMVPTencentDocsContent getTencentDocsContent() {
        return new GGProMVPTencentDocsContent(this.mInfo.getTencentDocsContent());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPURLContent
    public IGProMVPThirdPlatform getThirdPlatform() {
        return new GGProMVPThirdPlatform(this.mInfo.getThirdPlatform());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPURLContent
    public IGProMVPCommThirdShareInfo getThirdShareInfo() {
        return new GGProMVPCommThirdShareInfo(this.mInfo.getThirdShareInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPURLContent
    public IGProMVPThirdVideoInfo getThirdVideoInfo() {
        return new GGProMVPThirdVideoInfo(this.mInfo.getThirdVideoInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPURLContent
    public int getType() {
        return this.mInfo.getType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPURLContent
    public String getUrl() {
        return this.mInfo.getUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPURLContent
    public IGProMVPWeixinOfficialAccountsContent getWeixinOffcialAccountsContent() {
        return new GGProMVPWeixinOfficialAccountsContent(this.mInfo.getWeixinOffcialAccountsContent());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPURLContent
    public String toString() {
        return this.mInfo.toString();
    }
}
