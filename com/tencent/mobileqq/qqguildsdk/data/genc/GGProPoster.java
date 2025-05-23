package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProPoster;

/* loaded from: classes17.dex */
public class GGProPoster implements IGProPoster {
    public final GProPoster mInfo;

    public GGProPoster(GProPoster gProPoster) {
        this.mInfo = gProPoster;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPoster
    public String getAvatar() {
        return this.mInfo.getAvatar();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPoster
    public String getNick() {
        return this.mInfo.getNick();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPoster
    public long getTinyId() {
        return this.mInfo.getTinyId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPoster
    public String toString() {
        return this.mInfo.toString();
    }
}
