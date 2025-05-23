package com.tencent.av.smallscreen.api;

import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface ISmallScreenActivityPluginHelperApi extends QRouteApi {
    void onPauseRender(long j3, BaseVideoAppInterface baseVideoAppInterface, boolean z16, boolean z17);
}
