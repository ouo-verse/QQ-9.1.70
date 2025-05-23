package com.tencent.mobileqq.vashealth.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Service(process = {"all"})
/* loaded from: classes20.dex */
public interface ISportManager extends IRuntimeService {
    void doOnLogin();

    void doOnTimer1();

    void doOnTimer2();

    void refreshCurrentStep(String str);

    void refreshStepConfig();
}
