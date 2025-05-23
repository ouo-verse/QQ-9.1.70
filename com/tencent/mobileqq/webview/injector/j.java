package com.tencent.mobileqq.webview.injector;

import com.tencent.mobileqq.statistics.DcReportUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes35.dex */
public class j implements com.tencent.mobileqq.webview.swift.injector.m {
    @Override // com.tencent.mobileqq.webview.swift.injector.m
    public void a(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, String str6, String str7, String str8, String str9) {
        ReportController.n(appRuntime, str, str2, str3, str4, str5, i3, i16, i17, str6, str7, str8, str9);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.m
    public void c() {
        StatisticCollector.getInstance(BaseApplication.getContext(), 10000L);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.m
    public void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3) {
        f("", str, str2, z16, j3, j16, hashMap, str3, false, false);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.m
    public void d(AppRuntime appRuntime, String str, String str2, boolean z16) {
        DcReportUtil.c(appRuntime, str, str2, z16);
    }

    public void f(String str, String str2, String str3, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str4, boolean z17, boolean z18) {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, str2, str3, z16, j3, j16, hashMap, str4, z17, z18);
    }

    public void g(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5, int i3, int i16, int i17, String str6, String str7, String str8, String str9) {
        ReportController.q(appRuntime, str, str2, str3, str4, str5, i3, i16, i17, str6, str7, str8, str9);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.m
    public void collectPerformance(String str, String str2, boolean z16, long j3, long j16, HashMap<String, String> hashMap, String str3, boolean z17) {
        f("", str, str2, z16, j3, j16, hashMap, str3, z17, false);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.m
    public void b(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
        a(appRuntime, str, str2, str3, str4, str5, i3, 1, i16, str6, str7, str8, str9);
    }

    @Override // com.tencent.mobileqq.webview.swift.injector.m
    public void e(AppRuntime appRuntime, String str, String str2, String str3, String str4, String str5, int i3, int i16, String str6, String str7, String str8, String str9) {
        g(appRuntime, str, str2, str3, str4, str5, i3, i16, 1, str6, str7, str8, str9);
    }
}
