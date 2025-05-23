package com.tencent.mobileqq.vas.pendant.drawable.report;

import com.tencent.mobileqq.vas.report.VasCommonReporter;

/* loaded from: classes20.dex */
public class ReportLocalPathUse {
    public static void reportLocalPathUse(int i3) {
        VasCommonReporter.getPendant().setValue1("pendant_local_path_use").setNum1(i3).report();
    }
}
