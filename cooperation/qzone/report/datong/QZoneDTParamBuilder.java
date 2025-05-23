package cooperation.qzone.report.datong;

import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes28.dex */
public class QZoneDTParamBuilder {
    public static final String QZONE_APP_KEY = "0AND0MWZXR4U3RVU";

    public Map<String, Object> buildElementParams() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND0MWZXR4U3RVU");
        return hashMap;
    }

    public PageParams buildPageParams() {
        return buildPageParams(null);
    }

    public PageParams buildPageParams(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            hashMap.putAll(map);
        }
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND0MWZXR4U3RVU");
        return new PageParams(hashMap);
    }
}
