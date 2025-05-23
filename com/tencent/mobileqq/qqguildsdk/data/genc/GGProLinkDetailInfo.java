package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProLinkDetailInfo;

/* loaded from: classes17.dex */
public class GGProLinkDetailInfo implements IGProLinkDetailInfo {
    public final GProLinkDetailInfo mInfo;

    public GGProLinkDetailInfo(GProLinkDetailInfo gProLinkDetailInfo) {
        this.mInfo = gProLinkDetailInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLinkDetailInfo
    public String getLongUrl() {
        return this.mInfo.getLongUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLinkDetailInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
