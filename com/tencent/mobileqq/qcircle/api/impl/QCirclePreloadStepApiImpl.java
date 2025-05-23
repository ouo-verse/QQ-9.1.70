package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.qcircle.api.IQCirclePreloadStepApi;
import com.tencent.qcircle.application.QCircleApplication;

/* loaded from: classes16.dex */
public class QCirclePreloadStepApiImpl implements IQCirclePreloadStepApi {
    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePreloadStepApi
    public void doPreload() {
        if (QCircleApplication.sHasInit) {
            com.tencent.qcircle.application.initprocess.f.d().process();
        }
    }
}
