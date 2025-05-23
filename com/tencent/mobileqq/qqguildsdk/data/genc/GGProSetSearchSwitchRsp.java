package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProSetSearchSwitchRsp;

/* loaded from: classes17.dex */
public class GGProSetSearchSwitchRsp implements IGProSetSearchSwitchRsp {
    public final GProSetSearchSwitchRsp mInfo;

    public GGProSetSearchSwitchRsp(GProSetSearchSwitchRsp gProSetSearchSwitchRsp) {
        this.mInfo = gProSetSearchSwitchRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProSetSearchSwitchRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
