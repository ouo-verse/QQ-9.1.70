package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProBannerInfo;

/* loaded from: classes17.dex */
public class GGProBannerInfo implements IGProBannerInfo {
    public final GProBannerInfo mInfo;

    public GGProBannerInfo(GProBannerInfo gProBannerInfo) {
        this.mInfo = gProBannerInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBannerInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBannerInfo
    public String getGuildName() {
        return this.mInfo.getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBannerInfo
    public String getJoinSig() {
        return this.mInfo.getJoinSig();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBannerInfo
    public String getUserAvatarMeta() {
        return this.mInfo.getUserAvatarMeta();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBannerInfo
    public String getUserName() {
        return this.mInfo.getUserName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProBannerInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
