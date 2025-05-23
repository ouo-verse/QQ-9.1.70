package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProChannelPresenceItemInfo;

/* loaded from: classes17.dex */
public class GGProChannelPresenceItemInfo implements IGProChannelPresenceItemInfo {
    public final GProChannelPresenceItemInfo mInfo;

    public GGProChannelPresenceItemInfo(GProChannelPresenceItemInfo gProChannelPresenceItemInfo) {
        this.mInfo = gProChannelPresenceItemInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelPresenceItemInfo
    public int getJumpType() {
        return this.mInfo.getJumpType();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelPresenceItemInfo
    public String getJumpUrl() {
        return this.mInfo.getJumpUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelPresenceItemInfo
    public String getText() {
        return this.mInfo.getText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannelPresenceItemInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
