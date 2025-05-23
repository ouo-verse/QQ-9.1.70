package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.ark.api.IArkVipReport;
import com.tencent.mobileqq.ark.vipreport.ArkVipReporter;
import com.tencent.mobileqq.ark.vipreport.d;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ArkVipReportImpl implements IArkVipReport {
    @Override // com.tencent.mobileqq.ark.api.IArkVipReport
    public void addEventToScene(String str, boolean z16, long j3, HashMap<String, String> hashMap) {
        ArkVipReporter.d().c(str, z16, j3, hashMap);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkVipReport
    public void initScene(String str, d dVar) {
        ArkVipReporter.d().f(str, dVar);
    }

    @Override // com.tencent.mobileqq.ark.api.IArkVipReport
    public void startSceneByEvent(String str, long j3) {
        ArkVipReporter.d().j(str, j3);
    }
}
