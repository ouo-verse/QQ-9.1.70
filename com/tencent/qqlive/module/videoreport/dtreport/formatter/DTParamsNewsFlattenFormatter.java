package com.tencent.qqlive.module.videoreport.dtreport.formatter;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ParamKey;
import com.tencent.qqlive.module.videoreport.data.ReportData;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTHandleEventFormatFactory;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.IEventMapHandler;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: classes22.dex */
public class DTParamsNewsFlattenFormatter extends DTParamsNonFlattenFormatter {
    static final String NEWS_PROTO_VERSION = "2";
    private static final String TAG = "common.DTParamsNewsFlatten";

    @NonNull
    private List<String> getPrefix(@NonNull List<ReportData> list) {
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        for (ReportData reportData : list) {
            if (reportData != null) {
                String id5 = reportData.getId();
                int intValue = ((Integer) BaseUtils.getOrDefault(hashMap, id5, 0)).intValue();
                if (intValue == 0) {
                    arrayList.add("");
                } else {
                    arrayList.add("p" + intValue + "_");
                }
                hashMap.put(id5, Integer.valueOf(intValue + 1));
            }
        }
        return arrayList;
    }

    private void printDebugLog(String str, Map<String, Object> map) {
        if (!VideoReport.isDebugMode()) {
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        if (map != null) {
            sb5.append(new JSONObject(new TreeMap(map)));
        }
        Log.d(TAG, " eventId + " + str + " \u6253\u5e73\u53c2\u6570\uff1a \n\n" + sb5.toString());
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.DTParamsNonFlattenFormatter
    protected void formatElements(@NonNull List<ReportData> list, Map<String, Object> map) {
        List<String> prefix = getPrefix(list);
        ArrayList arrayList = new ArrayList();
        ListIterator<ReportData> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            int previousIndex = listIterator.previousIndex();
            ReportData previous = listIterator.previous();
            if (previous != null) {
                String str = prefix.get(previousIndex);
                String id5 = previous.getId();
                map.put("eid", id5);
                Map<String, Object> params = previous.getParams();
                if (params != null) {
                    for (Map.Entry<String, Object> entry : params.entrySet()) {
                        map.put(str + entry.getKey(), entry.getValue());
                    }
                }
                arrayList.add(0, str + id5);
            }
        }
        map.put(ParamKey.ELEMENT_PATH, arrayList);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.DTParamsNonFlattenFormatter, com.tencent.qqlive.module.videoreport.reportdata.DefaultFormatter, com.tencent.qqlive.module.videoreport.utils.IFormatter
    public Map<String, Object> formatEvent(String str, Map<String, Object> map, Map<String, Object> map2) {
        IEventMapHandler fetchEventHandler = DTHandleEventFormatFactory.fetchEventHandler(str);
        printDebugLog(str, map2);
        fetchEventHandler.formatEvent(str, map, map2);
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put(DTParamKey.REPORT_KEY_PROTO_VERSION, "2");
        hashMap.put("udf_kv", map2);
        return hashMap;
    }
}
