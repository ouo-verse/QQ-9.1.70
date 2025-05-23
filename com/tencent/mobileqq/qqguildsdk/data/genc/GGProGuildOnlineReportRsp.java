package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildOnlineReportRsp;

/* loaded from: classes17.dex */
public class GGProGuildOnlineReportRsp implements IGProGuildOnlineReportRsp {
    public final GProGuildOnlineReportRsp mInfo;

    public GGProGuildOnlineReportRsp(GProGuildOnlineReportRsp gProGuildOnlineReportRsp) {
        this.mInfo = gProGuildOnlineReportRsp;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildOnlineReportRsp
    public long getNextReportInterval() {
        return this.mInfo.getNextReportInterval();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildOnlineReportRsp
    public String toString() {
        return this.mInfo.toString();
    }
}
