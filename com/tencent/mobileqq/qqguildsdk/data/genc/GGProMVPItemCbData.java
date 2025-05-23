package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPItemCbData;

/* loaded from: classes17.dex */
public class GGProMVPItemCbData implements IGProMVPItemCbData {
    public final GProMVPItemCbData mInfo;

    public GGProMVPItemCbData(GProMVPItemCbData gProMVPItemCbData) {
        this.mInfo = gProMVPItemCbData;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPItemCbData
    public byte[] getCbExtData() {
        return this.mInfo.getCbExtData();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPItemCbData
    public String getStatData() {
        return this.mInfo.getStatData();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPItemCbData
    public String toString() {
        return this.mInfo.toString();
    }
}
