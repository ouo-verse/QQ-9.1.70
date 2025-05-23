package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPExtInfo;

/* loaded from: classes17.dex */
public class GGProMVPExtInfo implements IGProMVPExtInfo {
    public final GProMVPExtInfo mInfo;

    public GGProMVPExtInfo(GProMVPExtInfo gProMVPExtInfo) {
        this.mInfo = gProMVPExtInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPExtInfo
    public boolean getIsAllRead() {
        return this.mInfo.getIsAllRead();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPExtInfo
    public String getTraceId() {
        return this.mInfo.getTraceId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProMVPExtInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
