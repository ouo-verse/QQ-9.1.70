package com.tencent.mobileqq.persistence.service.impl;

import com.tencent.mobileqq.persistence.CommonFunctionPublishConfigProcessor;
import com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes16.dex */
public class CommonFunctionPublishConfigServiceImpl implements ICommonFunctionPublishConfigService {
    private static final String TAG = "CommonFunctionPublishConfigServiceImpl";

    @Override // com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService
    public boolean isCopyDBCommandEnable() {
        return CommonFunctionPublishConfigProcessor.a().f258286f;
    }

    @Override // com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService
    public boolean isIgnoreInvalidUnreadMark() {
        boolean z16 = CommonFunctionPublishConfigProcessor.a().f258288h;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isIgnoreInvalidUnreadMark switch value: ", Boolean.valueOf(z16));
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService
    public boolean isLocalized() {
        boolean z16 = CommonFunctionPublishConfigProcessor.a().f258281a;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isLocalized switch value: ", Boolean.valueOf(z16));
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService
    public boolean isNewUnreadCountEnable() {
        return CommonFunctionPublishConfigProcessor.a().f258283c;
    }

    @Override // com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService
    public boolean isTuringRiskDetectEnable() {
        boolean z16 = CommonFunctionPublishConfigProcessor.a().f258289i;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isTuringRiskDetectEnable switch value: ", Boolean.valueOf(z16));
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService
    public boolean isUseNewInvalidUnreadMarkThreshold() {
        return CommonFunctionPublishConfigProcessor.a().f258284d;
    }

    @Override // com.tencent.mobileqq.persistence.service.ICommonFunctionPublishConfigService
    public boolean isWalEnable() {
        boolean z16 = CommonFunctionPublishConfigProcessor.a().f258282b;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isWalEnable switch value: ", Boolean.valueOf(z16));
        }
        return z16;
    }
}
