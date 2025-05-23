package com.tencent.qqlive.module.videoreport.dtreport.time.base;

import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.utils.JsonUtils;
import com.tencent.qqlive.module.videoreport.utils.ReportUtils;
import com.tencent.qqlive.module.videoreport.utils.SPUtils;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class HeartBeatSpUtils {
    public static void clearLastHeartBeat(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SPUtils.put(ReportUtils.getContext(), str, "");
    }

    public static Map<String, Object> getLastHeartBeat(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = (String) SPUtils.get(ReportUtils.getContext(), str, "");
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return JsonUtils.getMapForJson(str2);
    }

    public static void saveLastHeartBeat(String str, Map<String, Object> map) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SPUtils.put(ReportUtils.getContext(), str, JsonUtils.getJsonFromMap(map));
    }
}
