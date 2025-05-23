package com.tencent.mobileqq.nativememorymonitor.library.trafficmonitor;

import java.util.Set;

/* compiled from: P */
/* loaded from: classes15.dex */
public interface ITrafficReporter {
    boolean onGlobalFdsTrafficReport(Set<TrafficReportBean> set, long j3, long j16, long j17, long j18, boolean z16);

    void onSingleFdTrafficReport(TrafficReportBean trafficReportBean);
}
