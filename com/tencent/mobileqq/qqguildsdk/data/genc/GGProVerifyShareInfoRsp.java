package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProVerifyShareInfoRsp;

/* loaded from: classes17.dex */
public class GGProVerifyShareInfoRsp implements IGProVerifyShareInfoRsp {
    public final GProVerifyShareInfoRsp mInfo;

    public GGProVerifyShareInfoRsp(GProVerifyShareInfoRsp gProVerifyShareInfoRsp) {
        this.mInfo = gProVerifyShareInfoRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVerifyShareInfoRsp
    public IGProBusinessData getBusinessData() {
        return new GGProBusinessData(this.mInfo.getBusinessData());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVerifyShareInfoRsp
    public int getErrCode() {
        return this.mInfo.getErrCode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVerifyShareInfoRsp
    public String getErrMsg() {
        return this.mInfo.getErrMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVerifyShareInfoRsp
    public IGProCmd0x10b4RspExtendData getExtendData() {
        return new GGProCmd0x10b4RspExtendData(this.mInfo.getExtendData());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVerifyShareInfoRsp
    public IGProCmd0xf5aGuildInfo getGuildInfo() {
        return new GGProCmd0xf5aGuildInfo(this.mInfo.getGuildInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVerifyShareInfoRsp
    public IGProLinkDetailInfo getLinkDetail() {
        return new GGProLinkDetailInfo(this.mInfo.getLinkDetail());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVerifyShareInfoRsp
    public IGProCmd0xf5aSecurityResult getSecurityResult() {
        return new GGProCmd0xf5aSecurityResult(this.mInfo.getSecurityResult());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVerifyShareInfoRsp
    public IGProCmd0xf5aUserInfo getUserInfo() {
        return new GGProCmd0xf5aUserInfo(this.mInfo.getUserInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProVerifyShareInfoRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
