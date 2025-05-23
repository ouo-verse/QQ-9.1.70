package com.tencent.hippykotlin.demo.pages.nearby.mood_group.vm;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.Iterator;

/* loaded from: classes31.dex */
public final class NBPMoodGroupReportViewModel {
    public final int mid;

    public NBPMoodGroupReportViewModel(int i3) {
        this.mid = i3;
    }

    public final void dtReportElementClick(String str, e eVar) {
        e dTReportPageParams = getDTReportPageParams();
        dTReportPageParams.v("dt_eid", str);
        if (eVar != null) {
            Iterator<String> c16 = eVar.c();
            while (c16.hasNext()) {
                String next = c16.next();
                dTReportPageParams.v(next, eVar.e(next));
            }
        }
        dTReportPageParams.v("cur_pg", getDTReportPageParams());
        dTReportPageParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_clck", dTReportPageParams);
    }

    public final void dtReportElementImp(String str, e eVar) {
        e dTReportPageParams = getDTReportPageParams();
        dTReportPageParams.v("dt_eid", str);
        if (eVar != null) {
            Iterator<String> c16 = eVar.c();
            while (c16.hasNext()) {
                String next = c16.next();
                dTReportPageParams.v(next, eVar.e(next));
            }
        }
        dTReportPageParams.v("cur_pg", getDTReportPageParams());
        dTReportPageParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent("dt_imp", dTReportPageParams);
    }

    public final e getDTReportPageParams() {
        e nearbyDTBaseParams = NearbyConstKt.getNearbyDTBaseParams();
        nearbyDTBaseParams.v("dt_pgid", "pg_nearby_emotion_circle");
        nearbyDTBaseParams.t("nearby_circle_type", this.mid);
        return nearbyDTBaseParams;
    }

    public final void dtReportPageExposure(boolean z16) {
        String str;
        if (z16) {
            str = "dt_pgin";
        } else {
            str = "dt_pgout";
        }
        e dTReportPageParams = getDTReportPageParams();
        dTReportPageParams.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
        Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(str, dTReportPageParams);
    }
}
