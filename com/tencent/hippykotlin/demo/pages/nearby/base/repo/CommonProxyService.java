package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.a;
import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import oicq.wlogin_sdk.tools.util;

/* loaded from: classes31.dex */
public final class CommonProxyService {
    public static final CommonProxyService INSTANCE = new CommonProxyService();

    public final <Req extends e, Rsp extends e> void request(IBizRequestByProxy<Req, Rsp> iBizRequestByProxy, Function4<? super Rsp, ? super byte[], ? super Integer, ? super String, Unit> function4) {
        a aVar = new a(i.d(iBizRequestByProxy.getRequest()));
        int appId = iBizRequestByProxy.getAppId();
        String service = iBizRequestByProxy.getService();
        String method = iBizRequestByProxy.getMethod();
        CommonProxyService$request$1 commonProxyService$request$1 = new CommonProxyService$request$1(function4, iBizRequestByProxy);
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = AdelieManagerCenterViewModel$fetchEditSwitchSetting$1$$ExternalSyntheticOutline0.m("req: appId=", appId, " service=", service, " method=");
        m3.append(method);
        kLog.i("CommonProxyService", m3.toString());
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, appId + util.base64_pad_url + service + '.' + method);
        CommonProxyRequest commonProxyRequest = new CommonProxyRequest(appId, service, method, aVar);
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(commonProxyRequest, null, new CommonProxyService$handle$1(aPICallTechReporter, commonProxyService$request$1), 6);
    }
}
