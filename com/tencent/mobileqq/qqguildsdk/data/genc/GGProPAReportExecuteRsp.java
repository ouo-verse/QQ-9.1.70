package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProPAReportExecuteRsp;

/* loaded from: classes17.dex */
public class GGProPAReportExecuteRsp implements IGProPAReportExecuteRsp {
    public final GProPAReportExecuteRsp mInfo;

    public GGProPAReportExecuteRsp(GProPAReportExecuteRsp gProPAReportExecuteRsp) {
        this.mInfo = gProPAReportExecuteRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPAReportExecuteRsp
    public String getMsg() {
        return this.mInfo.getMsg();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPAReportExecuteRsp
    public int getRet() {
        return this.mInfo.getRet();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProPAReportExecuteRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
