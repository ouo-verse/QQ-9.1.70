package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.a;
import c45.e;
import c45.i;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.kuikly.core.manager.c;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import w35.b;

/* loaded from: classes31.dex */
public final class NBPVasSsoRepo {
    public static final NBPVasSsoRepo INSTANCE = new NBPVasSsoRepo();

    public static void sendVasProxyRequest$default(String str, String str2, e eVar, final Function1 function1) {
        Map emptyMap;
        emptyMap = MapsKt__MapsKt.emptyMap();
        int i3 = 0;
        String valueOf = String.valueOf(Utils.INSTANCE.currentBridgeModule().currentTimeStamp());
        String appVersion = c.f117352a.g().getPageData().getAppVersion();
        int i16 = 109;
        a aVar = new a(i.d(eVar));
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : emptyMap.entrySet()) {
            arrayList.add(new w35.c((String) entry.getKey(), (String) entry.getValue()));
        }
        NBPVasSsoRequest nBPVasSsoRequest = new NBPVasSsoRequest(new w35.a(valueOf, appVersion, i16, str, str2, aVar, arrayList, i3, 256));
        Function1<PbResponse<b>, Unit> function12 = new Function1<PbResponse<b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPVasSsoRepo$sendVasProxyRequest$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<b> pbResponse) {
                function1.invoke(pbResponse);
                return Unit.INSTANCE;
            }
        };
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.qmeta.mob_proxy_svr.MobProxy.SsoHandle");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(nBPVasSsoRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function12), 6);
    }
}
