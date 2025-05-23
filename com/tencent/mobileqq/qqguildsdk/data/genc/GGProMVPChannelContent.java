package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPChannelContent;

/* loaded from: classes17.dex */
public class GGProMVPChannelContent implements IGProMVPChannelContent {
    public final GProMVPChannelContent mInfo;

    public GGProMVPChannelContent(GProMVPChannelContent gProMVPChannelContent) {
        this.mInfo = gProMVPChannelContent;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPChannelContent
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPChannelContent
    public String getChannelName() {
        return this.mInfo.getChannelName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPChannelContent
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPChannelContent
    public String toString() {
        return this.mInfo.toString();
    }
}
