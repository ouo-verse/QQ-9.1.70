package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.ark.api.IArkQualityReport;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkQualityReportImpl implements IArkQualityReport {
    @Override // com.tencent.mobileqq.ark.api.IArkQualityReport
    public void reportAppSSOResult(AppRuntime appRuntime, String str, String str2, boolean z16, int i3) {
        m91.a.a(appRuntime, str, str2, z16, i3);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkQualityReport
    public void reportScriptError(AppRuntime appRuntime, String str, String str2) {
        m91.a.b(appRuntime, str, str2);
    }
}
