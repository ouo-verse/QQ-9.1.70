package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildChannelState;

/* loaded from: classes17.dex */
public class GGProGuildChannelState implements IGProGuildChannelState {
    public final GProGuildChannelState mInfo;

    public GGProGuildChannelState(GProGuildChannelState gProGuildChannelState) {
        this.mInfo = gProGuildChannelState;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildChannelState
    public String getDesc() {
        return this.mInfo.getDesc();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildChannelState
    public int getState() {
        return this.mInfo.getState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildChannelState
    public String toString() {
        return this.mInfo.toString();
    }
}
