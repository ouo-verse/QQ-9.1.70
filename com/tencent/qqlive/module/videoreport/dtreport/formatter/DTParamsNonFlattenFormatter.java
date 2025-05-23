package com.tencent.qqlive.module.videoreport.dtreport.formatter;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.constants.ParamKey;
import com.tencent.qqlive.module.videoreport.data.ReportData;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTHandleEventFormatFactory;
import com.tencent.qqlive.module.videoreport.reportdata.DefaultFormatter;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes22.dex */
public class DTParamsNonFlattenFormatter extends DefaultFormatter {
    private void formatPage(ReportData reportData, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (reportData != null) {
            hashMap.put("pgid", reportData.getId());
            BaseUtils.copyTo(reportData.getParams(), hashMap);
        }
        map.put("cur_pg", hashMap);
    }

    @Override // com.tencent.qqlive.module.videoreport.reportdata.DefaultFormatter, com.tencent.qqlive.module.videoreport.utils.IFormatter
    public Map<String, Object> formatElementParams(@NonNull List<ReportData> list, ReportData reportData) {
        HashMap hashMap = new HashMap();
        formatElements(list, hashMap);
        formatPage(reportData, hashMap);
        return hashMap;
    }

    protected void formatElements(@NonNull List<ReportData> list, Map<String, Object> map) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (ReportData reportData : list) {
            if (reportData != null) {
                arrayList.add(reportData.getId());
                Map copyNonNull = BaseUtils.copyNonNull(reportData.getParams());
                copyNonNull.put("eid", reportData.getId());
                arrayList2.add(copyNonNull);
            }
        }
        map.put(ParamKey.ELEMENT_PATH, arrayList);
        map.put(ParamKey.ELEMENT_PARAMS, arrayList2);
    }

    @Override // com.tencent.qqlive.module.videoreport.reportdata.DefaultFormatter, com.tencent.qqlive.module.videoreport.utils.IFormatter
    public Map<String, Object> formatEvent(String str, Map<String, Object> map, Map<String, Object> map2) {
        DTHandleEventFormatFactory.fetchEventHandler(str).formatEvent(str, map, map2);
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        if (map2 != null) {
            hashMap.put("udf_kv", map2);
        }
        return hashMap;
    }
}
