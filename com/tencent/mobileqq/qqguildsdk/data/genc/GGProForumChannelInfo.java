package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProForumChannelInfo;

/* loaded from: classes17.dex */
public class GGProForumChannelInfo implements IGProForumChannelInfo {
    public final GProForumChannelInfo mInfo;

    public GGProForumChannelInfo(GProForumChannelInfo gProForumChannelInfo) {
        this.mInfo = gProForumChannelInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumChannelInfo
    public String getHotIcon() {
        return this.mInfo.getHotIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumChannelInfo
    public int getHotIndex() {
        return this.mInfo.getHotIndex();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumChannelInfo
    public int getPostSortMode() {
        return this.mInfo.getPostSortMode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProForumChannelInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
