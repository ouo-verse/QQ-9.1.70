package com.tencent.aelight.camera.api.impl;

import com.tencent.aelight.camera.aebase.d;
import com.tencent.aelight.camera.api.IPeakJceService;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime;

/* loaded from: classes32.dex */
public class PeakJceServiceImpl implements IPeakJceService {
    private static final String TAG = "PeakJceImpl";
    d mPeakJceService;

    @Override // com.tencent.aelight.camera.api.IPeakJceService
    public void handleRequest(ToServiceMsg toServiceMsg) {
        ms.a.a(TAG, "impl handleRequest" + this.mPeakJceService);
        d dVar = this.mPeakJceService;
        if (dVar == null) {
            return;
        }
        dVar.k(toServiceMsg);
    }

    @Override // com.tencent.aelight.camera.api.IPeakJceService
    public void handleResponse(boolean z16, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        ms.a.a(TAG, "impl handleResponse" + this.mPeakJceService);
        d dVar = this.mPeakJceService;
        if (dVar == null) {
            return;
        }
        dVar.l(z16, toServiceMsg, fromServiceMsg);
    }

    @Override // com.tencent.aelight.camera.api.IPeakJceService, mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        ms.a.a(TAG, "impl onCreate");
        try {
            if (appRuntime instanceof PeakAppInterface) {
                this.mPeakJceService = new d((PeakAppInterface) appRuntime);
                return;
            }
            ms.a.c(TAG, "[onCreate] init error, not in QQAppInterface! appRuntime = " + appRuntime);
        } catch (Throwable th5) {
            ms.a.d(TAG, "[onCreate] init error!", th5);
        }
    }

    @Override // com.tencent.aelight.camera.api.IPeakJceService, mqq.app.api.IRuntimeService
    public void onDestroy() {
    }
}
