package com.tencent.qqnt.kernelgpro.nativeinterface;

/* loaded from: classes24.dex */
public final class GProVerifyShareInfoRsp {
    public int errCode;
    public String errMsg = "";
    public GProCmd0xf5aGuildInfo guildInfo = new GProCmd0xf5aGuildInfo();
    public GProCmd0xf5aUserInfo userInfo = new GProCmd0xf5aUserInfo();
    public GProCmd0xf5aSecurityResult securityResult = new GProCmd0xf5aSecurityResult();
    public GProBusinessData businessData = new GProBusinessData();
    public GProLinkDetailInfo linkDetail = new GProLinkDetailInfo();
    public GProCmd0x10b4RspExtendData extendData = new GProCmd0x10b4RspExtendData();

    public GProBusinessData getBusinessData() {
        return this.businessData;
    }

    public int getErrCode() {
        return this.errCode;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public GProCmd0x10b4RspExtendData getExtendData() {
        return this.extendData;
    }

    public GProCmd0xf5aGuildInfo getGuildInfo() {
        return this.guildInfo;
    }

    public GProLinkDetailInfo getLinkDetail() {
        return this.linkDetail;
    }

    public GProCmd0xf5aSecurityResult getSecurityResult() {
        return this.securityResult;
    }

    public GProCmd0xf5aUserInfo getUserInfo() {
        return this.userInfo;
    }

    public String toString() {
        return "GProVerifyShareInfoRsp{errCode=" + this.errCode + ",errMsg=" + this.errMsg + ",guildInfo=" + this.guildInfo + ",userInfo=" + this.userInfo + ",securityResult=" + this.securityResult + ",businessData=" + this.businessData + ",linkDetail=" + this.linkDetail + ",extendData=" + this.extendData + ",}";
    }
}
