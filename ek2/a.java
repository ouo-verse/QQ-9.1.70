package ek2;

import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a {
    public static Map<String, Object> a() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        return hashMap;
    }

    public static PageParams b(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        return new PageParams(hashMap);
    }
}
