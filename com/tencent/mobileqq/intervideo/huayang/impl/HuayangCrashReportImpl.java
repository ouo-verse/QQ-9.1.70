package com.tencent.mobileqq.intervideo.huayang.impl;

import com.tencent.mobileqq.intervideo.huayang.IHuayangCrashReport;
import com.tencent.mobileqq.intervideo.huayang.a;

/* compiled from: P */
/* loaded from: classes33.dex */
public class HuayangCrashReportImpl implements IHuayangCrashReport {
    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangCrashReport
    public void handleReport(Throwable th5) {
        a.b(th5);
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangCrashReport
    public void report(Throwable th5) {
        a.c(th5);
    }
}
