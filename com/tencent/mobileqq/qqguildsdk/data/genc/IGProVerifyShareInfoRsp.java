package com.tencent.mobileqq.qqguildsdk.data.genc;

import java.io.Serializable;

/* loaded from: classes17.dex */
public interface IGProVerifyShareInfoRsp extends Serializable {
    IGProBusinessData getBusinessData();

    int getErrCode();

    String getErrMsg();

    IGProCmd0x10b4RspExtendData getExtendData();

    IGProCmd0xf5aGuildInfo getGuildInfo();

    IGProLinkDetailInfo getLinkDetail();

    IGProCmd0xf5aSecurityResult getSecurityResult();

    IGProCmd0xf5aUserInfo getUserInfo();

    String toString();
}
