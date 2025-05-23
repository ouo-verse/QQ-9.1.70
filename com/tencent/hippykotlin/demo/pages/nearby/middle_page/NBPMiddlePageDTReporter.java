package com.tencent.hippykotlin.demo.pages.nearby.middle_page;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.AsyncTaskTracker;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.g;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import x25.m;

/* loaded from: classes31.dex */
public final class NBPMiddlePageDTReporter {
    public m poiData;
    public final AsyncTaskTracker<Unit> setupTask = new AsyncTaskTracker<>();
    public final int source;

    public NBPMiddlePageDTReporter(g gVar) {
        this.source = gVar.n().k("nbp_source", 2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0007, code lost:
    
        if (r0.H == 1) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final e access$getDTReportPageParams(NBPMiddlePageDTReporter nBPMiddlePageDTReporter) {
        m mVar = nBPMiddlePageDTReporter.poiData;
        int i3 = mVar != null ? 1 : 0;
        e nearbyDTBaseParams = NearbyConstKt.getNearbyDTBaseParams();
        nearbyDTBaseParams.v("dt_pgid", "pg_nearby_place_middle_page");
        nearbyDTBaseParams.t("nearby_user_from", nBPMiddlePageDTReporter.source);
        nearbyDTBaseParams.t("nearby_is_official_poi", i3);
        return nearbyDTBaseParams;
    }

    public static void reportElementImp$default(final NBPMiddlePageDTReporter nBPMiddlePageDTReporter, final String str, final Function0 function0, int i3) {
        final e eVar = null;
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        nBPMiddlePageDTReporter.setupTask.executeOnDone(false, new Function1<Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageDTReporter$reportElementImp$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Unit unit) {
                e access$getDTReportPageParams = NBPMiddlePageDTReporter.access$getDTReportPageParams(NBPMiddlePageDTReporter.this);
                String str2 = str;
                e eVar2 = eVar;
                Function0<e> function02 = function0;
                NBPMiddlePageDTReporter nBPMiddlePageDTReporter2 = NBPMiddlePageDTReporter.this;
                access$getDTReportPageParams.v("dt_eid", str2);
                if (eVar2 != null) {
                    Iterator<String> c16 = eVar2.c();
                    while (c16.hasNext()) {
                        String next = c16.next();
                        access$getDTReportPageParams.v(next, eVar2.e(next));
                    }
                }
                if (function02 != null) {
                    Iterator<String> c17 = function02.invoke().c();
                    while (c17.hasNext()) {
                        String next2 = c17.next();
                        access$getDTReportPageParams.v(next2, function02.invoke().e(next2));
                    }
                }
                access$getDTReportPageParams.v("cur_pg", NBPMiddlePageDTReporter.access$getDTReportPageParams(nBPMiddlePageDTReporter2));
                access$getDTReportPageParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", access$getDTReportPageParams);
                return Unit.INSTANCE;
            }
        });
    }

    public static void reportElementClick$default(final NBPMiddlePageDTReporter nBPMiddlePageDTReporter, final String str, final e eVar, final Function0 function0, int i3) {
        if ((i3 & 2) != 0) {
            eVar = null;
        }
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        nBPMiddlePageDTReporter.setupTask.executeOnDone(false, new Function1<Unit, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.middle_page.NBPMiddlePageDTReporter$reportElementClick$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(Unit unit) {
                e access$getDTReportPageParams = NBPMiddlePageDTReporter.access$getDTReportPageParams(NBPMiddlePageDTReporter.this);
                String str2 = str;
                e eVar2 = eVar;
                Function0<e> function02 = function0;
                NBPMiddlePageDTReporter nBPMiddlePageDTReporter2 = NBPMiddlePageDTReporter.this;
                access$getDTReportPageParams.v("dt_eid", str2);
                if (eVar2 != null) {
                    Iterator<String> c16 = eVar2.c();
                    while (c16.hasNext()) {
                        String next = c16.next();
                        access$getDTReportPageParams.v(next, eVar2.e(next));
                    }
                }
                if (function02 != null) {
                    Iterator<String> c17 = function02.invoke().c();
                    while (c17.hasNext()) {
                        String next2 = c17.next();
                        access$getDTReportPageParams.v(next2, function02.invoke().e(next2));
                    }
                }
                access$getDTReportPageParams.v("cur_pg", NBPMiddlePageDTReporter.access$getDTReportPageParams(nBPMiddlePageDTReporter2));
                access$getDTReportPageParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", access$getDTReportPageParams);
                return Unit.INSTANCE;
            }
        });
    }
}
