package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProLiveChannelInfo;

/* loaded from: classes17.dex */
public class GGProLiveChannelInfo implements IGProLiveChannelInfo {
    public final GProLiveChannelInfo mInfo;

    public GGProLiveChannelInfo(GProLiveChannelInfo gProLiveChannelInfo) {
        this.mInfo = gProLiveChannelInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveChannelInfo
    public long getAnchorTinyId() {
        return this.mInfo.getAnchorTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveChannelInfo
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveChannelInfo
    public long getRoomId() {
        return this.mInfo.getRoomId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProLiveChannelInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
