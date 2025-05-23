package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetAISearchShareURLRsp;

/* loaded from: classes17.dex */
public class GGProGetAISearchShareURLRsp implements IGProGetAISearchShareURLRsp {
    public final GProGetAISearchShareURLRsp mInfo;

    public GGProGetAISearchShareURLRsp(GProGetAISearchShareURLRsp gProGetAISearchShareURLRsp) {
        this.mInfo = gProGetAISearchShareURLRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAISearchShareURLRsp
    public String getAnwserDescription() {
        return this.mInfo.getAnwserDescription();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAISearchShareURLRsp
    public String getBrandDescription() {
        return this.mInfo.getBrandDescription();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAISearchShareURLRsp
    public String getShareIcon() {
        return this.mInfo.getShareIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAISearchShareURLRsp
    public String getShareModelDescription() {
        return this.mInfo.getShareModelDescription();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAISearchShareURLRsp
    public String getShareTitle() {
        return this.mInfo.getShareTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAISearchShareURLRsp
    public String getShareUrl() {
        return this.mInfo.getShareUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAISearchShareURLRsp
    public String getTailDescription() {
        return this.mInfo.getTailDescription();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAISearchShareURLRsp
    public String getTailIcon() {
        return this.mInfo.getTailIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetAISearchShareURLRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
