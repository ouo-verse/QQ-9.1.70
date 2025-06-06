package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProPlayPushScene;

/* loaded from: classes17.dex */
public class GGProPlayPushScene implements IGProPlayPushScene {
    public final GProPlayPushScene mInfo;

    public GGProPlayPushScene(GProPlayPushScene gProPlayPushScene) {
        this.mInfo = gProPlayPushScene;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayPushScene
    public boolean getVolume() {
        return this.mInfo.getVolume();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPlayPushScene
    public String toString() {
        return this.mInfo.toString();
    }
}
