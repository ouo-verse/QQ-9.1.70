package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProProgramInfo;

/* loaded from: classes17.dex */
public class LiveProgramInfo implements ILiveProgramInfo {
    private GProProgramInfo mGProProgramInfo;

    public LiveProgramInfo(GProProgramInfo gProProgramInfo) {
        this.mGProProgramInfo = gProProgramInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveProgramInfo
    public String getAnchorName() {
        return this.mGProProgramInfo.getAnchorName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveProgramInfo
    public String getLiveTitle() {
        return this.mGProProgramInfo.getLiveTitle();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveProgramInfo
    public String getProgramId() {
        return this.mGProProgramInfo.getProgramId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveProgramInfo
    public long getTabId() {
        return this.mGProProgramInfo.getTabId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.ILiveProgramInfo
    public String getThirdPartyLogo() {
        return this.mGProProgramInfo.getThirdPartyLogo();
    }
}
