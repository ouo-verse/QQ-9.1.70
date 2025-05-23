package com.tencent.qqlive.module.videoreport.report;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DTReportHelper {
    private static final Map<String, String> EVENT_KEY_DICT;
    private static final String TAG = "common.DTReportHelper";

    static {
        HashMap hashMap = new HashMap();
        EVENT_KEY_DICT = hashMap;
        hashMap.put(EventKey.ORIGIN_VST, DTEventKey.ORIGIN_VST);
        hashMap.put(EventKey.VST, DTEventKey.VST);
        hashMap.put(EventKey.ACT, DTEventKey.ACT);
        hashMap.put(EventKey.APP_IN, DTEventKey.APP_IN);
        hashMap.put(EventKey.APP_OUT, DTEventKey.APP_OUT);
        hashMap.put("clck", "dt_clck");
        hashMap.put("imp", "dt_imp");
        hashMap.put("pgin", "dt_pgin");
        hashMap.put("pgout", "dt_pgout");
        hashMap.put("imp_end", "dt_imp_end");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public static Map<String, String> getParamsMap(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (BaseUtils.isEmpty(map)) {
            return hashMap;
        }
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key != null) {
                try {
                    String str = "";
                    if (value instanceof Map) {
                        str = new JSONObject((Map) value).toString();
                    } else if (value instanceof List) {
                        str = new JSONArray((Collection) value).toString();
                    } else if (value != null) {
                        str = String.valueOf(value);
                    }
                    hashMap.put(key, str);
                } catch (Exception e16) {
                    Log.e(TAG, e16.getLocalizedMessage());
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean shouldReportImmediately(String str) {
        if (!DTEventKey.ACT.equals(str) && !DTEventKey.VST.equals(str) && !DTEventKey.ORIGIN_VST.equals(str) && !DTEventKey.APP_IN.equals(str) && !DTEventKey.APP_OUT.equals(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String transformEvent(String str) {
        Map<String, String> map = EVENT_KEY_DICT;
        if (map.containsKey(str)) {
            return map.get(str);
        }
        if (VideoReportInner.getInstance().isDebugMode()) {
            Log.d(TAG, "origin event key:" + str + " no need to transform");
        }
        return str;
    }
}
