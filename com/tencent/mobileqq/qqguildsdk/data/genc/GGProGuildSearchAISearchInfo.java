package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchAISearchInfo;

/* loaded from: classes17.dex */
public class GGProGuildSearchAISearchInfo implements IGProGuildSearchAISearchInfo {
    public final GProGuildSearchAISearchInfo mInfo;

    public GGProGuildSearchAISearchInfo(GProGuildSearchAISearchInfo gProGuildSearchAISearchInfo) {
        this.mInfo = gProGuildSearchAISearchInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAISearchInfo
    public String getBottomTitle() {
        return this.mInfo.getBottomTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAISearchInfo
    public String getDefaultText() {
        return this.mInfo.getDefaultText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAISearchInfo
    public String getIcon() {
        return this.mInfo.getIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAISearchInfo
    public String getLabel() {
        return this.mInfo.getLabel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAISearchInfo
    public String getModel() {
        return this.mInfo.getModel();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAISearchInfo
    public String getSearchKey() {
        return this.mInfo.getSearchKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAISearchInfo
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchAISearchInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
