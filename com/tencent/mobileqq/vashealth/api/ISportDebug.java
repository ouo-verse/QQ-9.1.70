package com.tencent.mobileqq.vashealth.api;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes20.dex */
public interface ISportDebug extends QRouteApi {
    void startCrossDayDebugFragment(Activity activity);

    void startHealthMainDebugFragment(Activity activity);
}
