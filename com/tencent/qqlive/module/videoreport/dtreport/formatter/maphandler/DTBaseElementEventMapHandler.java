package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.constants.ParamKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
abstract class DTBaseElementEventMapHandler extends DTBaseEventMapHandler {
    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseEventMapHandler
    public void formatCustomParams(String str, Map<String, Object> map, Map<String, Object> map2) {
        super.formatCustomParams(str, map, map2);
        if (isValidMap(map2) && map2.containsKey("cur_pg") && isValidMap(map2.get("cur_pg"))) {
            formatPage(map, (Map) map2.get("cur_pg"));
        }
        String elementId = getElementId(map2);
        if (!TextUtils.isEmpty(elementId)) {
            map.put("dt_eid", elementId);
        }
        if ("imp_end".equals(str)) {
            formatSingleParam(map2, "element_lvtm", map, DTParamKey.REPORT_KEY_ELEMENT_LVTM);
            formatSingleParam(map2, ParamKey.REPORT_KEY_ELEMENT_AREA, map, DTParamKey.REPORT_KEY_ELEMENT_AREA);
            formatSingleParam(map2, ParamKey.REPORT_KEY_ELE_IMP_AREA, map, DTParamKey.REPORT_KEY_ELE_IMP_AREA);
            formatSingleParam(map2, ParamKey.REPORT_KEY_ELE_IMP_RATE, map, DTParamKey.REPORT_KEY_ELE_IMP_RATE);
        }
    }

    protected abstract String getElementId(Map<String, Object> map);
}
