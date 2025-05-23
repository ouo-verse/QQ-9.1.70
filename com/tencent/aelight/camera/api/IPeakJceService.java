package com.tencent.aelight.camera.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime;
import mqq.app.api.IRuntimeService;

@Service(needUin = false, process = {"all"})
/* loaded from: classes3.dex */
public interface IPeakJceService extends IRuntimeService {
    void handleRequest(ToServiceMsg toServiceMsg);

    void handleResponse(boolean z16, ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    @Override // mqq.app.api.IRuntimeService
    void onCreate(AppRuntime appRuntime);

    @Override // mqq.app.api.IRuntimeService
    void onDestroy();
}
