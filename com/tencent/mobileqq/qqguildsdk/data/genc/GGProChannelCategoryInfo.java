package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelCategoryInfo;

/* loaded from: classes17.dex */
public class GGProChannelCategoryInfo implements IGProChannelCategoryInfo {
    public final GProChannelCategoryInfo mInfo;

    public GGProChannelCategoryInfo(GProChannelCategoryInfo gProChannelCategoryInfo) {
        this.mInfo = gProChannelCategoryInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelCategoryInfo
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelCategoryInfo
    public int getChannelIndex() {
        return this.mInfo.getChannelIndex();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelCategoryInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
