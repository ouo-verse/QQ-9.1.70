package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProUserGuideMsg;

/* loaded from: classes17.dex */
public class GGProUserGuideMsg implements IGProUserGuideMsg {
    public final GProUserGuideMsg mInfo;

    public GGProUserGuideMsg(GProUserGuideMsg gProUserGuideMsg) {
        this.mInfo = gProUserGuideMsg;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserGuideMsg
    public IGProUserGuideBubble getBubble() {
        return new GGProUserGuideBubble(this.mInfo.getBubble());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProUserGuideMsg
    public int getScene() {
        return this.mInfo.getScene();
    }

    public String toString() {
        return this.mInfo.toString();
    }
}
