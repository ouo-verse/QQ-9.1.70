package com.tencent.mobileqq.soload.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoConfigService;
import com.tencent.qphone.base.remote.FromServiceMsg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static void a(int[] iArr, FromServiceMsg fromServiceMsg) {
        ISoConfigService iSoConfigService = (ISoConfigService) QRoute.api(ISoConfigService.class);
        if (iSoConfigService != null) {
            iSoConfigService.notifyNetFailed(iArr, fromServiceMsg);
        }
    }
}
