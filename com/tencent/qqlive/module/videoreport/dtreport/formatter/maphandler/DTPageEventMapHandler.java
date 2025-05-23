package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import com.tencent.qqlive.module.videoreport.constants.ParamKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.Map;

/* loaded from: classes22.dex */
public class DTPageEventMapHandler extends DTBaseEventMapHandler {

    /* loaded from: classes22.dex */
    private static class Holder {
        private static final DTPageEventMapHandler instance = new DTPageEventMapHandler();

        Holder() {
        }
    }

    public static DTPageEventMapHandler getInstance() {
        return Holder.instance;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseEventMapHandler
    public void formatCustomParams(String str, Map<String, Object> map, Map<String, Object> map2) {
        super.formatCustomParams(str, map, map2);
        formatPage(map, map2);
        if ("pgout".equals(str)) {
            formatLvTime(map, map2);
            formatSingleParamNonNull(map2, ParamKey.REPORT_KEY_PG_AREA, map, DTParamKey.REPORT_KEY_PG_AREA);
            formatSingleParamNonNull(map2, ParamKey.REPORT_KEY_PG_IMP_AREA, map, DTParamKey.REPORT_KEY_PG_IMP_AREA);
            formatSingleParamNonNull(map2, ParamKey.REPORT_KEY_PG_IMP_RATE, map, DTParamKey.REPORT_KEY_PG_IMP_RATE);
        }
    }
}
