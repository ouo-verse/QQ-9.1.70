package com.tencent.gdtad;

import android.app.Activity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"all"})
/* loaded from: classes6.dex */
public interface IGdtDemoAPI extends QRouteApi {
    void startHippyDemoFragment(Activity activity);

    void startMotiveVideoDemoFragment(Activity activity);
}
