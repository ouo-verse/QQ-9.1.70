package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GetLabelGuildsRsp;

/* compiled from: P */
/* loaded from: classes17.dex */
public class GGetLabelGuildsRsp implements IGetLabelGuildsRsp {
    public final GetLabelGuildsRsp mInfo;

    public GGetLabelGuildsRsp(GetLabelGuildsRsp getLabelGuildsRsp) {
        this.mInfo = getLabelGuildsRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGetLabelGuildsRsp
    public IGProLabelInfo getLabelInfo() {
        return new GGProLabelInfo(this.mInfo.getLabelInfo());
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGetLabelGuildsRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
