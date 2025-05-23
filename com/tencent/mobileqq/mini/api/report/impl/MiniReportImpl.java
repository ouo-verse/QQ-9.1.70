package com.tencent.mobileqq.mini.api.report.impl;

import com.tencent.mobileqq.mini.api.report.IMiniReport;
import com.tencent.mobileqq.minigame.manager.MiniGameExceptionResetManager;
import com.tencent.mobileqq.minigame.report.MiniGameCrashReporter;
import com.tencent.qqmini.proxyimpl.ap;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniReportImpl implements IMiniReport {
    @Override // com.tencent.mobileqq.mini.api.report.IMiniReport
    public String getCrashReportAppInfo() {
        return ap.a();
    }

    @Override // com.tencent.mobileqq.mini.api.report.IMiniReport
    public void doCrashReport(String str, String str2, String str3, boolean z16, String str4, String str5, String str6, int i3, long j3) {
        if (str2.endsWith(":mini3") || str2.endsWith(":mini4") || str2.endsWith(":mini5")) {
            MiniGameCrashReporter.reportCrash(new MiniGameCrashReporter.CrashInfo(str, str2, j3, z16, str4, str5, str6, i3));
            if (str3 != null) {
                MiniGameExceptionResetManager.INSTANCE.recordPackageException(str3);
            }
        }
    }
}
