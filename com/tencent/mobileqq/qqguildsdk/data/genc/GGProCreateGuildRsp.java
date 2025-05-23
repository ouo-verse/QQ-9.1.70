package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.mobileqq.qqguildsdk.data.GProSecurityInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCreateGuildRsp;

/* loaded from: classes17.dex */
public class GGProCreateGuildRsp implements IGProCreateGuildRsp {
    public final GProCreateGuildRsp mInfo;

    public GGProCreateGuildRsp(GProCreateGuildRsp gProCreateGuildRsp) {
        this.mInfo = gProCreateGuildRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreateGuildRsp
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreateGuildRsp
    public IGProSecurityResult getSecRet() {
        return new GProSecurityInfo(this.mInfo.getSecRet());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCreateGuildRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
