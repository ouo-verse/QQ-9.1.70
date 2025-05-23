package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetMyTabContentRsp;

/* loaded from: classes17.dex */
public class GGProGetMyTabContentRsp implements IGProGetMyTabContentRsp {
    public final GProGetMyTabContentRsp mInfo;

    public GGProGetMyTabContentRsp(GProGetMyTabContentRsp gProGetMyTabContentRsp) {
        this.mInfo = gProGetMyTabContentRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetMyTabContentRsp
    public IGProTabContentCommonRsp getCommonRsp() {
        return new GGProTabContentCommonRsp(this.mInfo.getCommonRsp());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGetMyTabContentRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
