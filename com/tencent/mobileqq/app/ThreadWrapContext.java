package com.tencent.mobileqq.app;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface ThreadWrapContext {
    void d(String str, int i3, String str2, Throwable th5);

    int getFdCount();

    long getMainProccessThreadMonitorTime();

    long getMainProccessThreadPeakCounts();

    boolean isColorLevel();

    boolean isShotReportRejectedError();

    void registerApplicationStatus(cb cbVar);

    void reportBeacon(String str, Map<String, String> map);

    void reportDengTaException(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3, boolean z17);

    void reportRDMException(Throwable th5, String str, String str2);

    void setMainProccessThreadMonitorTime(long j3);

    void setMainProccessThreadPeakCounts(long j3);

    int threadMonitorReportSample();
}
