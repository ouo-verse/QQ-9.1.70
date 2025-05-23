package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProTransThirdVideoURLRsp;

/* loaded from: classes17.dex */
public class GGProTransThirdVideoURLRsp implements IGProTransThirdVideoURLRsp {
    public final GProTransThirdVideoURLRsp mInfo;

    public GGProTransThirdVideoURLRsp(GProTransThirdVideoURLRsp gProTransThirdVideoURLRsp) {
        this.mInfo = gProTransThirdVideoURLRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTransThirdVideoURLRsp
    public String getCover() {
        return this.mInfo.getCover();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTransThirdVideoURLRsp
    public long getDuration() {
        return this.mInfo.getDuration();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTransThirdVideoURLRsp
    public String getPlayUrl() {
        return this.mInfo.getPlayUrl();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProTransThirdVideoURLRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
