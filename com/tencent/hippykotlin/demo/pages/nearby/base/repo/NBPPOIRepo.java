package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendOIDBRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.kuikly.core.log.KLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import o25.e;
import p35.af;
import p35.ah;
import x25.h;
import x25.m;

/* loaded from: classes31.dex */
public final class NBPPOIRepo {
    public final void getPOIDetail(ah ahVar, e eVar, final Function3<? super h, ? super Integer, ? super String, Unit> function3) {
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getPOIDetail: poiId=");
        m3.append(ahVar.f425143d);
        m3.append(", poiGps=(");
        af afVar = ahVar.C;
        m3.append(afVar != null ? Long.valueOf(afVar.f425135d) : null);
        m3.append(',');
        af afVar2 = ahVar.C;
        m3.append(afVar2 != null ? Long.valueOf(afVar2.f425136e) : null);
        m3.append("), poiName=");
        m3.append(ahVar.Q);
        m3.append(" poiKey=");
        m3.append(ahVar.R);
        m3.append(" coord=(");
        m3.append(eVar.f421846d);
        m3.append(',');
        m3.append(eVar.f421847e);
        m3.append(')');
        kLog.i("NBPPOIRepo", m3.toString());
        GetPoiDetailRequest getPoiDetailRequest = new GetPoiDetailRequest(ahVar, eVar);
        QQKuiklyPlatformApi.Companion.sendOIDBRequest(getPoiDetailRequest, false, new NearbyApi$sendOIDBRequest$1(new APICallTechReporter(1, getPoiDetailRequest.getCmd()), new Function1<OIDBResponse<h>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPOIRepo$getPOIDetail$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(OIDBResponse<h> oIDBResponse) {
                m mVar;
                ah ahVar2;
                m mVar2;
                ah ahVar3;
                OIDBResponse<h> oIDBResponse2 = oIDBResponse;
                if (oIDBResponse2.success) {
                    KLog kLog2 = KLog.INSTANCE;
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getPOIDetail success poiKey=");
                    h hVar = oIDBResponse2.rsp;
                    String str = null;
                    m16.append((hVar == null || (mVar2 = hVar.f447095e) == null || (ahVar3 = mVar2.f447113d) == null) ? null : ahVar3.R);
                    m16.append(", district=");
                    h hVar2 = oIDBResponse2.rsp;
                    if (hVar2 != null && (mVar = hVar2.f447095e) != null && (ahVar2 = mVar.f447113d) != null) {
                        str = ahVar2.M;
                    }
                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m16, str, kLog2, "NBPPOIRepo");
                } else {
                    KLog kLog3 = KLog.INSTANCE;
                    StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getPOIDetail failure code:");
                    m17.append(oIDBResponse2.code);
                    m17.append(", message:");
                    m17.append(oIDBResponse2.f114186msg);
                    m17.append('}');
                    kLog3.e("NBPPOIRepo", m17.toString());
                }
                function3.invoke(oIDBResponse2.rsp, Integer.valueOf(oIDBResponse2.code), oIDBResponse2.f114186msg);
                return Unit.INSTANCE;
            }
        }));
    }
}
