package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProCmd0x1258ExtendRsp;

/* loaded from: classes17.dex */
public class GGProCmd0x1258ExtendRsp implements IGProCmd0x1258ExtendRsp {
    public final GProCmd0x1258ExtendRsp mInfo;

    public GGProCmd0x1258ExtendRsp(GProCmd0x1258ExtendRsp gProCmd0x1258ExtendRsp) {
        this.mInfo = gProCmd0x1258ExtendRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0x1258ExtendRsp
    public int getGuildFeedNum() {
        return this.mInfo.getGuildFeedNum();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0x1258ExtendRsp
    public String getInviterName() {
        return this.mInfo.getInviterName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProCmd0x1258ExtendRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
