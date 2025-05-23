package com.tencent.mobileqq.winkreport.utils;

import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import java.util.Map;

/* loaded from: classes21.dex */
public class WinkDtParamsUtils {
    public static void initParamByKey(Map<String, String> map, String str) {
        String str2;
        if (map == null) {
            return;
        }
        if (map.containsKey(str)) {
            str2 = map.get(str);
        } else if (map.containsKey("taskid")) {
            str2 = map.get("taskid");
        } else {
            str2 = "";
        }
        WinkDatongCurrentParams.put(str, str2);
    }
}
