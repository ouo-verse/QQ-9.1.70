package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.biz.richframework.network.quic.VSNetLightQUICBaseRequest;
import com.tencent.mobileqq.qcircle.api.IQCircleQUICProtocolEnvApi;
import com.tencent.qphone.base.util.QLog;
import uq3.k;

/* loaded from: classes16.dex */
public class QCircleQUICProtocolEnvApiImpl implements IQCircleQUICProtocolEnvApi {
    private static final String TAG = "QCircleQUICProtocolEnvApiImpl";

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleQUICProtocolEnvApi
    public void updateEnv(String str, String str2, boolean z16) {
        QLog.d(TAG, 1, "[updateEnv] id: " + str + " | name: " + str2 + " | useTestEnv: " + z16);
        k.b().j(VSNetLightQUICBaseRequest.QQCIRCLE_DEBUG_SWITCH_CLOSE_QUIC, z16);
    }
}
