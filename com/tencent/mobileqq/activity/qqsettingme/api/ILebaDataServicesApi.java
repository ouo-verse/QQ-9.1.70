package com.tencent.mobileqq.activity.qqsettingme.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import mqq.app.AppRuntime;

/* compiled from: P */
@QAPI(process = {""})
/* loaded from: classes10.dex */
public interface ILebaDataServicesApi extends QRouteApi {
    void accountChange();

    BusinessInfoCheckUpdate.RedTypeInfo getRedTypeInfo(AppRuntime appRuntime);

    void hiddeNewGuide();

    Boolean redTouchContainerNewGuide();
}
