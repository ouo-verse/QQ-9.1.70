package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.biz.richframework.video.rfw.player.exp.RFWLowDeviceAv1Exp;
import com.tencent.biz.richframework.video.rfw.player.strategy.RFWPlayerAV1Strategy;
import com.tencent.mobileqq.qcircle.api.IQFSPlayerStrategyApi;

/* loaded from: classes16.dex */
public class QFSPlayerStrategyApiImpl implements IQFSPlayerStrategyApi {
    @Override // com.tencent.mobileqq.qcircle.api.IQFSPlayerStrategyApi
    public int getAV1Flag() {
        return RFWPlayerAV1Strategy.getAV1Flag();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQFSPlayerStrategyApi
    public String getCurrentAv1ExpName() {
        return RFWLowDeviceAv1Exp.getExpName();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQFSPlayerStrategyApi
    public boolean isEnableAV1() {
        return RFWPlayerAV1Strategy.enableAV1();
    }
}
