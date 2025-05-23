package com.tencent.mobileqq.ptt.temp.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IMediaPlayerManagerTempApi extends QRouteApi {
    void mediaPlayer_doStop(boolean z16, AppRuntime appRuntime);
}
