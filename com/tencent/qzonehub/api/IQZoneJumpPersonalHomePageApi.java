package com.tencent.qzonehub.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes25.dex */
public interface IQZoneJumpPersonalHomePageApi extends QRouteApi {
    void qavJumpToPersonalHomePage(Activity activity, long j3);
}
