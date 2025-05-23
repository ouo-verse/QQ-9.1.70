package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleStatusInfo;

/* loaded from: classes17.dex */
public class GGProScheduleStatusInfo implements IGProScheduleStatusInfo {
    public final GProScheduleStatusInfo mInfo;

    public GGProScheduleStatusInfo(GProScheduleStatusInfo gProScheduleStatusInfo) {
        this.mInfo = gProScheduleStatusInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProScheduleStatusInfo
    public long getScheduleId() {
        return this.mInfo.getScheduleId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProScheduleStatusInfo
    public int getStatus() {
        return this.mInfo.getStatus();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProScheduleStatusInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
