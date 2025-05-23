package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProQqMsgListSetting;

/* loaded from: classes17.dex */
public class GGProQqMsgListSetting implements IGProQqMsgListSetting {
    public final GProQqMsgListSetting mInfo;

    public GGProQqMsgListSetting(GProQqMsgListSetting gProQqMsgListSetting) {
        this.mInfo = gProQqMsgListSetting;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQqMsgListSetting
    public int getIsInList() {
        return this.mInfo.getIsInList();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQqMsgListSetting
    public long getSubscribeTimestamp() {
        return this.mInfo.getSubscribeTimestamp();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQqMsgListSetting
    public long getTopTimestamp() {
        return this.mInfo.getTopTimestamp();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQqMsgListSetting
    public String toString() {
        return this.mInfo.toString();
    }
}
