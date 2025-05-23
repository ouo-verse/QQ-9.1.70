package com.tencent.qqlive.module.videoreport.inner;

import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.qqlive.module.videoreport.IReporter;
import com.tencent.qqlive.module.videoreport.Log;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class LogReporter implements IReporter {
    private static final String TAG = "LogReporter";

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class InstanceHolder {
        static final LogReporter INSTANCE = new LogReporter();

        InstanceHolder() {
        }
    }

    public static LogReporter getInstance() {
        return InstanceHolder.INSTANCE;
    }

    @Override // com.tencent.qqlive.module.videoreport.IReporter
    public void report(Object obj, String str, Map<String, Object> map) {
        if (VideoReportInner.getInstance().isDebugMode()) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            TreeMap treeMap = new TreeMap(map);
            if ("pgin".equals(str)) {
                Log.d(TAG, "report: [" + str + "], " + new JSONObject(treeMap));
            }
            for (Map.Entry entry : treeMap.entrySet()) {
                Log.d(TAG, "    [" + str + "]  " + ((String) entry.getKey()) + MsgSummary.STR_COLON + entry.getValue());
            }
        }
    }

    LogReporter() {
    }
}
