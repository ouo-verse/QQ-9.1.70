package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProVoiceQueueCfg;

/* loaded from: classes17.dex */
public class GGProVoiceQueueCfg implements IGProVoiceQueueCfg {
    public final GProVoiceQueueCfg mInfo;

    public GGProVoiceQueueCfg(GProVoiceQueueCfg gProVoiceQueueCfg) {
        this.mInfo = gProVoiceQueueCfg;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceQueueCfg
    public int getVoiceQueueState() {
        return this.mInfo.getVoiceQueueState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVoiceQueueCfg
    public String toString() {
        return this.mInfo.toString();
    }
}
