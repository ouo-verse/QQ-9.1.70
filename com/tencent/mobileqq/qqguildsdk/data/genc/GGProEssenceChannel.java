package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProEssenceChannel;

/* loaded from: classes17.dex */
public class GGProEssenceChannel implements IGProEssenceChannel {
    public final GProEssenceChannel mInfo;

    public GGProEssenceChannel(GProEssenceChannel gProEssenceChannel) {
        this.mInfo = gProEssenceChannel;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEssenceChannel
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEssenceChannel
    public int getChannelType() {
        return this.mInfo.getChannelType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEssenceChannel
    public String getRecommend() {
        return this.mInfo.getRecommend();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProEssenceChannel
    public String toString() {
        return this.mInfo.toString();
    }
}
