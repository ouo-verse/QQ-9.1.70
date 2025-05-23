package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.biz.richframework.network.quic.manager.VSNetLightQUICIPStrategyManager;
import com.tencent.mobileqq.qcircle.api.IQCircleQuicReqApi;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleQuicReqApiImpl implements IQCircleQuicReqApi {
    @Override // com.tencent.mobileqq.qcircle.api.IQCircleQuicReqApi
    public void retryPingRequest() {
        VSNetLightQUICIPStrategyManager.instance().asyncRetryPingReq();
    }
}
