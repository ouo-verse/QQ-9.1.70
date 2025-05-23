package com.tencent.hippykotlin.demo.pages.nearby.main.control.login;

import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import f35.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import zz0.a;

/* loaded from: classes31.dex */
public final class NBPMainLoginRepo {
    public final void login(Function3<? super Integer, ? super String, ? super g, Unit> function3) {
        long a16 = a.f453719a.a();
        NBPMainLoginRequest nBPMainLoginRequest = new NBPMainLoginRequest();
        NBPMainLoginRepo$login$1 nBPMainLoginRepo$login$1 = new NBPMainLoginRepo$login$1(a16, function3);
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.user_manager_svr.User.SsoLogin");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(nBPMainLoginRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, nBPMainLoginRepo$login$1), 6);
    }
}
