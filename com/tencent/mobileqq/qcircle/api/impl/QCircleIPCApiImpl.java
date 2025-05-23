package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.qcircle.api.IQCircleIPCApi;
import com.tencent.mobileqq.qipc.QIPCModule;
import cooperation.qqcircle.ipc.QCircleIPCModule;

/* loaded from: classes16.dex */
public class QCircleIPCApiImpl implements IQCircleIPCApi {
    @Override // com.tencent.mobileqq.qcircle.api.IQCircleIPCApi
    public QIPCModule getIPCModule() {
        return QCircleIPCModule.getInstance();
    }
}
