package com.tencent.mobileqq.qcircle.api.impl;

import com.tencent.mobileqq.qcircle.api.IQCircleEeveeManangerService;
import cooperation.qqcircle.eevee.QCircleEeveeMananger;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleEeveeManangerServiceImpl implements IQCircleEeveeManangerService {
    @Override // com.tencent.mobileqq.qcircle.api.IQCircleEeveeManangerService
    public void deleteAllRecomAutoTemplateData() {
        QCircleEeveeMananger.getInstance().deleteAllRecomAutoTemplateData();
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleEeveeManangerService
    public void deleteBizUndealMsgBuffer(int i3) {
        QCircleEeveeMananger.getInstance().deleteBizUndealMsgBuffer(i3);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleEeveeManangerService
    public void deleteOneRecomAutoTemplateData(String str) {
        QCircleEeveeMananger.getInstance().deleteOneRecomAutoTemplateData(str);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleEeveeManangerService
    public byte[] getBizUndealMsgBuffer(int i3) {
        return QCircleEeveeMananger.getInstance().getBizUndealMsgBuffer(i3);
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleEeveeManangerService
    public void onSend(int i3, String str, String str2) {
        QCircleEeveeMananger.getInstance().onSend(i3, str, str2);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
    }
}
