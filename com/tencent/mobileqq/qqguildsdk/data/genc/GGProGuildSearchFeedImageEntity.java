package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildSearchFeedImageEntity;

/* loaded from: classes17.dex */
public class GGProGuildSearchFeedImageEntity implements IGProGuildSearchFeedImageEntity {
    public final GProGuildSearchFeedImageEntity mInfo;

    public GGProGuildSearchFeedImageEntity(GProGuildSearchFeedImageEntity gProGuildSearchFeedImageEntity) {
        this.mInfo = gProGuildSearchFeedImageEntity;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchFeedImageEntity
    public int getHeight() {
        return this.mInfo.getHeight();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchFeedImageEntity
    public String getUrl() {
        return this.mInfo.getUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchFeedImageEntity
    public int getWidth() {
        return this.mInfo.getWidth();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildSearchFeedImageEntity
    public String toString() {
        return this.mInfo.toString();
    }
}
