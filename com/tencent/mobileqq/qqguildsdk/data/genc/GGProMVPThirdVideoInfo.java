package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPThirdVideoInfo;

/* loaded from: classes17.dex */
public class GGProMVPThirdVideoInfo implements IGProMVPThirdVideoInfo {
    public final GProMVPThirdVideoInfo mInfo;

    public GGProMVPThirdVideoInfo(GProMVPThirdVideoInfo gProMVPThirdVideoInfo) {
        this.mInfo = gProMVPThirdVideoInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPThirdVideoInfo
    public String getCover() {
        return this.mInfo.getCover();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPThirdVideoInfo
    public long getDuration() {
        return this.mInfo.getDuration();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPThirdVideoInfo
    public String getJumpUrl() {
        return this.mInfo.getJumpUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPThirdVideoInfo
    public String getPcJumpUrl() {
        return this.mInfo.getPcJumpUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPThirdVideoInfo
    public String getPlayUrl() {
        return this.mInfo.getPlayUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPThirdVideoInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
