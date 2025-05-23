package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProSlowModeInfo;

/* compiled from: P */
/* loaded from: classes17.dex */
public class SlowModeInfo implements ISlowModeInfo {
    private final GProSlowModeInfo slowModeInfo;

    public SlowModeInfo(GProSlowModeInfo gProSlowModeInfo) {
        this.slowModeInfo = gProSlowModeInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ISlowModeInfo
    public int getSlowModeCircle() {
        return this.slowModeInfo.getSlowModeCircle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ISlowModeInfo
    public int getSlowModeKey() {
        return this.slowModeInfo.getSlowModeKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ISlowModeInfo
    public String getSlowModeText() {
        return this.slowModeInfo.getSlowModeText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ISlowModeInfo
    public int getSpeakFrequency() {
        return this.slowModeInfo.getSpeakFrequency();
    }
}
