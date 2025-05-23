package com.tencent.mobileqq.qcircle.api.impl;

import android.content.SharedPreferences;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import com.tencent.mobileqq.qcircle.api.IQCircleConfigApi;
import cooperation.qqcircle.QCircleConfig;
import cooperation.qzone.QUA;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleConfigApiImpl implements IQCircleConfigApi {
    private static final String TAG = "QCircleConfigApiImpl";

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleConfigApi
    public String getPluginMark() {
        return com.tencent.mobileqq.auto.engine.loader.a.e(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).n();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleConfigApi
    public String getPluginQUA() {
        if (MobileQQ.sProcessId != 1) {
            return QUA.getQUA3();
        }
        return com.tencent.mobileqq.auto.engine.loader.a.e(ASEngineConstants.BusinessKey.BUSINESS_QCIRCLE).o();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleConfigApi
    public SharedPreferences getQCircleSp() {
        return QCircleConfig.getQCircleSp();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleConfigApi
    public boolean isNeedToShowGalleryNewUserGuideVideo() {
        return QCircleConfig.getInstance().checkIsNeedToShowGalleryNewUserGuideVideo();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleConfigApi
    public boolean isShowQCircleEnter(boolean z16) {
        return uq3.c.L6(z16);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleConfigApi
    public boolean isShowQQCircleMainTabEntrance() {
        return uq3.c.M6();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleConfigApi
    public boolean isWezoneJoy() {
        return uq3.c.i0();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleConfigApi
    public void tryGetNewUserGuideVideoAsync() {
        QCircleConfig.getInstance().tryGetNewUserGuideVideoAsync();
    }
}
