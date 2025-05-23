package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import d35.b;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyAIOAccessService {
    public static final Companion Companion = new Companion();
    public static final e defaultJson;
    public static NearbyAIOAccessService instance;
    public boolean isRequesting;

    /* compiled from: P */
    /* loaded from: classes31.dex */
    public static final class Companion {
        public final synchronized NearbyAIOAccessService getInstance() {
            if (NearbyAIOAccessService.instance == null) {
                NearbyAIOAccessService.instance = new NearbyAIOAccessService();
            }
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("instance=");
            m3.append(NearbyAIOAccessService.instance);
            kLog.i("NearbyAioSafeCheckService", m3.toString());
            return NearbyAIOAccessService.instance;
        }
    }

    static {
        e eVar = new e();
        eVar.w("isAuthorized", true);
        defaultJson = eVar;
    }

    public final void fetch() {
        if (this.isRequesting) {
            KLog.INSTANCE.i("NearbyAioSafeCheckService", "fetch: isRequesting=true");
            return;
        }
        this.isRequesting = true;
        CheckAIOAccessReqRequest checkAIOAccessReqRequest = new CheckAIOAccessReqRequest();
        Function1<PbResponse<b>, Unit> function1 = new Function1<PbResponse<b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.NearbyAIOAccessService$fetch$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<b> pbResponse) {
                e eVar;
                Long l3;
                PbResponse<b> pbResponse2 = pbResponse;
                NearbyAIOAccessService.this.isRequesting = false;
                if (pbResponse2.success) {
                    eVar = new e();
                    b bVar = pbResponse2.rsp;
                    eVar.w("isAuthorized", bVar != null && bVar.f392769e);
                    b bVar2 = pbResponse2.rsp;
                    eVar.v("tips", bVar2 != null ? bVar2.f392770f : null);
                    b bVar3 = pbResponse2.rsp;
                    if (bVar3 != null) {
                        Long valueOf = Long.valueOf(bVar3.f392771h);
                        if (!(valueOf.longValue() > 0)) {
                            valueOf = null;
                        }
                        if (valueOf != null) {
                            l3 = Long.valueOf(APICallTechReporterKt.NBPCurrentTime() + (valueOf.longValue() * 1000));
                            eVar.v("nextPullTime", l3);
                        }
                    }
                    l3 = null;
                    eVar.v("nextPullTime", l3);
                } else {
                    eVar = NearbyAIOAccessService.defaultJson;
                }
                Utils.INSTANCE.cacheModule("").setObject("nbp_aio_access_data_for_safe", eVar);
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetch, success: ");
                m3.append(pbResponse2.success);
                m3.append(", code: ");
                m3.append(pbResponse2.code);
                m3.append(", isAuthorized: ");
                b bVar4 = pbResponse2.rsp;
                m3.append(bVar4 != null ? Boolean.valueOf(bVar4.f392769e) : null);
                m3.append(", nextPullTime: ");
                b bVar5 = pbResponse2.rsp;
                m3.append(bVar5 != null ? Long.valueOf(bVar5.f392771h) : null);
                kLog.i("NearbyAioSafeCheckService", m3.toString());
                return Unit.INSTANCE;
            }
        };
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.safety_svr.Safety.SsoCheckAIOAccess");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(checkAIOAccessReqRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function1), 6);
    }
}
