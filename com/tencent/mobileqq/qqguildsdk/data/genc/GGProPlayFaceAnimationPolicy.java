package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProPlayFaceAnimationPolicy;

/* loaded from: classes17.dex */
public class GGProPlayFaceAnimationPolicy implements IGProPlayFaceAnimationPolicy {
    public final GProPlayFaceAnimationPolicy mInfo;

    public GGProPlayFaceAnimationPolicy(GProPlayFaceAnimationPolicy gProPlayFaceAnimationPolicy) {
        this.mInfo = gProPlayFaceAnimationPolicy;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayFaceAnimationPolicy
    public int getUserIdleTime() {
        return this.mInfo.getUserIdleTime();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayFaceAnimationPolicy
    public String toString() {
        return this.mInfo.toString();
    }
}
