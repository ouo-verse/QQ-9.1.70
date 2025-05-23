package com.tencent.mobileqq.vashealth.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import h43.a;
import h43.e;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface IQQHealthStatusApi extends QRouteApi {
    void getStepInfo(String str, Boolean bool, a aVar);

    boolean getStepPermission();

    void jumpToMainPage();

    void jumpToMainPage(String str);

    void requestStepPermission(e eVar, Activity activity);
}
