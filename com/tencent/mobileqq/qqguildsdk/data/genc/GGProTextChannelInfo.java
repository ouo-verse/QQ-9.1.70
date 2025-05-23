package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProTextChannelInfo;

/* loaded from: classes17.dex */
public class GGProTextChannelInfo implements IGProTextChannelInfo {
    public final GProTextChannelInfo mInfo;

    public GGProTextChannelInfo(GProTextChannelInfo gProTextChannelInfo) {
        this.mInfo = gProTextChannelInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTextChannelInfo
    public int getSubTypeId() {
        return this.mInfo.getSubTypeId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTextChannelInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
