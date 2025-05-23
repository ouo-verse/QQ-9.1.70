package com.tencent.mobileqq.peak.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IPeakHelperApi extends QRouteApi {
    void cancelPeakAlive(Context context);

    boolean isPeakAlive(Context context);

    void preloadPeakProcess(Context context);
}
