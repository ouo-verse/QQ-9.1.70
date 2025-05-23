package com.tencent.qqlive.module.videoreport.reportdata;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.constants.ParamKey;
import com.tencent.qqlive.module.videoreport.data.ReportData;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.IFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DefaultFormatter implements IFormatter {
    @Override // com.tencent.qqlive.module.videoreport.utils.IFormatter
    public Map<String, Object> formatElementParams(@NonNull List<ReportData> list, ReportData reportData) {
        HashMap hashMap = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            ReportData reportData2 = list.get(size);
            if (reportData2 != null) {
                String id5 = reportData2.getId();
                if (!TextUtils.isEmpty(id5)) {
                    hashMap.put("eid", id5);
                }
                Map<String, Object> params = reportData2.getParams();
                if (!BaseUtils.isEmpty(params)) {
                    hashMap.putAll(params);
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("eid", id5);
                arrayList.add(0, hashMap2);
            }
        }
        hashMap.put(ParamKey.ELEMENT_PARAMS, arrayList);
        HashMap hashMap3 = new HashMap();
        if (reportData != null) {
            hashMap3.put("pgid", reportData.getId());
            if (!BaseUtils.isEmpty(reportData.getParams())) {
                hashMap3.putAll(reportData.getParams());
            }
        }
        hashMap.put("cur_pg", hashMap3);
        return hashMap;
    }

    @Override // com.tencent.qqlive.module.videoreport.utils.IFormatter
    public Map<String, Object> formatEvent(String str, Map<String, Object> map, Map<String, Object> map2) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put("udf_kv", map2);
        return hashMap;
    }
}
