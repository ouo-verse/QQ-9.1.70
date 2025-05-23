package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPCommThirdShareInfo;

/* loaded from: classes17.dex */
public class GGProMVPCommThirdShareInfo implements IGProMVPCommThirdShareInfo {
    public final GProMVPCommThirdShareInfo mInfo;

    public GGProMVPCommThirdShareInfo(GProMVPCommThirdShareInfo gProMVPCommThirdShareInfo) {
        this.mInfo = gProMVPCommThirdShareInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPCommThirdShareInfo
    public String getImageUrl() {
        return this.mInfo.getImageUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPCommThirdShareInfo
    public String getRedirectUrl() {
        return this.mInfo.getRedirectUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPCommThirdShareInfo
    public String getStringAbstract() {
        return this.mInfo.getStringAbstract();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPCommThirdShareInfo
    public String getTitle() {
        return this.mInfo.getTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPCommThirdShareInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
