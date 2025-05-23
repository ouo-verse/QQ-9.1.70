package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProSchedulePollingInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleStatusInfo;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes17.dex */
public class GGProSchedulePollingInfo implements IGProSchedulePollingInfo {
    public final GProSchedulePollingInfo mInfo;

    public GGProSchedulePollingInfo(GProSchedulePollingInfo gProSchedulePollingInfo) {
        this.mInfo = gProSchedulePollingInfo;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSchedulePollingInfo
    public long getChannelId() {
        return this.mInfo.getChannelId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSchedulePollingInfo
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSchedulePollingInfo
    public ArrayList<IGProScheduleStatusInfo> getSchedulerStatus() {
        ArrayList<GProScheduleStatusInfo> schedulerStatus = this.mInfo.getSchedulerStatus();
        ArrayList<IGProScheduleStatusInfo> arrayList = new ArrayList<>();
        Iterator<GProScheduleStatusInfo> it = schedulerStatus.iterator();
        while (it.hasNext()) {
            arrayList.add(new GGProScheduleStatusInfo(it.next()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSchedulePollingInfo
    public String toString() {
        return this.mInfo.toString();
    }
}
