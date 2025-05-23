package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPWeixinOfficialAccountsContent;

/* loaded from: classes17.dex */
public class GGProMVPWeixinOfficialAccountsContent implements IGProMVPWeixinOfficialAccountsContent {
    public final GProMVPWeixinOfficialAccountsContent mInfo;

    public GGProMVPWeixinOfficialAccountsContent(GProMVPWeixinOfficialAccountsContent gProMVPWeixinOfficialAccountsContent) {
        this.mInfo = gProMVPWeixinOfficialAccountsContent;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPWeixinOfficialAccountsContent
    public String getAuthor() {
        return this.mInfo.getAuthor();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPWeixinOfficialAccountsContent
    public String getIcon() {
        return this.mInfo.getIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPWeixinOfficialAccountsContent
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPWeixinOfficialAccountsContent
    public String getUrl() {
        return this.mInfo.getUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPWeixinOfficialAccountsContent
    public String toString() {
        return this.mInfo.toString();
    }
}
