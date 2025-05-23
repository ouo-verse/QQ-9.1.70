package com.tencent.qqlive.module.videoreport.dtreport.verifydata;

import android.util.Pair;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes22.dex */
public class VerifyDataHelper {
    private static final String KEEP_FIELD_A = "^[Aa][0-9].*";
    private static final String KEEP_FIELD_DT = "dt_";
    private static final String KEEP_FIELD_RQD = "rqd_";
    private static final String TAG = "DT_DataCheck";
    public static final String WARNING = " \u53c2\u6570key\u4e0d\u80fd\u4e3a\u7a7a\uff0c\u4e14\u4e0d\u80fd\u4ee5^[Aa][0-9].*, dt_, rqd_\u5f00\u5934";

    public static void checkMap(Map<String, ?> map) {
        Pair<String, Boolean> isValidMap = isValidMap(map);
        if (!((Boolean) isValidMap.second).booleanValue()) {
            doCrash("invalid input key:" + ((String) isValidMap.first) + "," + WARNING);
        }
    }

    private static void doCrash(String str) {
        if (!VideoReport.isDebugMode()) {
            return;
        }
        Log.e(TAG, str);
        throw new RuntimeException(str);
    }

    private static boolean isValidKey(String str) {
        if (str == null || str.length() == 0 || str.startsWith("dt_") || str.startsWith(KEEP_FIELD_RQD) || Pattern.matches(KEEP_FIELD_A, str)) {
            return false;
        }
        return true;
    }

    private static Pair<String, Boolean> isValidMap(Map<String, ?> map) {
        if (map == null) {
            return new Pair<>("map is null", Boolean.FALSE);
        }
        if (map.size() > 0) {
            for (String str : map.keySet()) {
                if (!isValidKey(str)) {
                    return new Pair<>(str, Boolean.FALSE);
                }
            }
        }
        return new Pair<>("", Boolean.TRUE);
    }
}
