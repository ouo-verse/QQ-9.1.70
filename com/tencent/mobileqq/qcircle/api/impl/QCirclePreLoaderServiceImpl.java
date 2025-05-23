package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.qcircle.api.IQCirclePreLoaderService;
import cooperation.qqcircle.whitelist.QCirclePreLoadManager;
import mqq.app.AppRuntime;

/* loaded from: classes16.dex */
public class QCirclePreLoaderServiceImpl implements IQCirclePreLoaderService {
    @Override // com.tencent.mobileqq.qcircle.api.IQCirclePreLoaderService
    public void requestWhiteList(String str) {
        QCirclePreLoadManager.getInstance().loadWhiteList(str);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
    }
}
