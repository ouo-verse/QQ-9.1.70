package com.tencent.qqlive.module.videoreport.dtreport.formatter;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.data.ReportData;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTHandleEventFormatFactory;
import com.tencent.qqlive.module.videoreport.reportdata.DefaultFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes22.dex */
public class DTParamsFlattenFormatter extends DefaultFormatter {
    private static final String TAG = "DTParamsFlattenFormatter";
    private static final String VIDEO_PROTO_VERSION = "1";

    @Override // com.tencent.qqlive.module.videoreport.reportdata.DefaultFormatter, com.tencent.qqlive.module.videoreport.utils.IFormatter
    public Map<String, Object> formatElementParams(@NonNull List<ReportData> list, ReportData reportData) {
        return super.formatElementParams(list, reportData);
    }

    @Override // com.tencent.qqlive.module.videoreport.reportdata.DefaultFormatter, com.tencent.qqlive.module.videoreport.utils.IFormatter
    public Map<String, Object> formatEvent(String str, Map<String, Object> map, Map<String, Object> map2) {
        try {
            DTHandleEventFormatFactory.fetchEventHandler(str).formatEvent(str, map, map2);
        } catch (Exception e16) {
            Log.e(TAG, "eventId: " + str + " error: " + e16);
        }
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        hashMap.put(DTParamKey.REPORT_KEY_PROTO_VERSION, "1");
        if (map2 != null) {
            hashMap.put("udf_kv", map2);
        }
        return hashMap;
    }
}
