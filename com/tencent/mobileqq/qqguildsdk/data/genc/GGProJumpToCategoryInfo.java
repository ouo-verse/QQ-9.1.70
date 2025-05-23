package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProJumpToCategoryInfo;

/* loaded from: classes17.dex */
public class GGProJumpToCategoryInfo implements IGProJumpToCategoryInfo {
    public final GProJumpToCategoryInfo mInfo;

    public GGProJumpToCategoryInfo(GProJumpToCategoryInfo gProJumpToCategoryInfo) {
        this.mInfo = gProJumpToCategoryInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJumpToCategoryInfo
    public long getCategoryId() {
        return this.mInfo.getCategoryId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJumpToCategoryInfo
    public int getFeedSortType() {
        return this.mInfo.getFeedSortType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJumpToCategoryInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProJumpToCategoryInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
