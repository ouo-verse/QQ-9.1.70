package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProInviteSpeakCfg;

/* loaded from: classes17.dex */
public class GGProInviteSpeakCfg implements IGProInviteSpeakCfg {
    public final GProInviteSpeakCfg mInfo;

    public GGProInviteSpeakCfg(GProInviteSpeakCfg gProInviteSpeakCfg) {
        this.mInfo = gProInviteSpeakCfg;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProInviteSpeakCfg
    public int getInviteSpeakState() {
        return this.mInfo.getInviteSpeakState();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProInviteSpeakCfg
    public String toString() {
        return this.mInfo.toString();
    }
}
