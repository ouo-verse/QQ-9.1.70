package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProSlowModeInfo;

/* loaded from: classes17.dex */
public class GGProSlowModeInfo implements IGProSlowModeInfo {
    public final GProSlowModeInfo mInfo;

    public GGProSlowModeInfo(GProSlowModeInfo gProSlowModeInfo) {
        this.mInfo = gProSlowModeInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSlowModeInfo
    public int getSlowModeCircle() {
        return this.mInfo.getSlowModeCircle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSlowModeInfo
    public int getSlowModeKey() {
        return this.mInfo.getSlowModeKey();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSlowModeInfo
    public String getSlowModeText() {
        return this.mInfo.getSlowModeText();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSlowModeInfo
    public int getSpeakFrequency() {
        return this.mInfo.getSpeakFrequency();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSlowModeInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
