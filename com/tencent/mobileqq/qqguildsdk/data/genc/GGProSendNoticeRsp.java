package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProSendNoticeRsp;

/* loaded from: classes17.dex */
public class GGProSendNoticeRsp implements IGProSendNoticeRsp {
    public final GProSendNoticeRsp mInfo;

    public GGProSendNoticeRsp(GProSendNoticeRsp gProSendNoticeRsp) {
        this.mInfo = gProSendNoticeRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSendNoticeRsp
    public int getCode() {
        return this.mInfo.getCode();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSendNoticeRsp
    public String getNotAllowReason() {
        return this.mInfo.getNotAllowReason();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSendNoticeRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
