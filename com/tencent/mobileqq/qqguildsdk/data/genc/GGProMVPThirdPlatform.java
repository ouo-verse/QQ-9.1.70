package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPThirdPlatform;

/* loaded from: classes17.dex */
public class GGProMVPThirdPlatform implements IGProMVPThirdPlatform {
    public final GProMVPThirdPlatform mInfo;

    public GGProMVPThirdPlatform(GProMVPThirdPlatform gProMVPThirdPlatform) {
        this.mInfo = gProMVPThirdPlatform;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPThirdPlatform
    public String getIcon() {
        return this.mInfo.getIcon();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPThirdPlatform
    public String getName() {
        return this.mInfo.getName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPThirdPlatform
    public String toString() {
        return this.mInfo.toString();
    }
}
