package fo;

import android.text.TextUtils;
import com.qzone.reborn.feedpro.utils.d;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {
    public Map<String, Object> b() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0AND0MWZXR4U3RVU");
        return hashMap;
    }

    public PageParams c(String str, String str2, Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        a(hashMap, str, str2);
        if (map != null && !map.isEmpty()) {
            hashMap.putAll(map);
        }
        return new PageParams(hashMap);
    }

    public PageParams d(String str, Map<String, Object> map) {
        return c("0AND0MWZXR4U3RVU", str, map);
    }

    public Map<String, Object> e() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE");
        return hashMap;
    }

    public void a(Map<String, Object> map, String str, String str2) {
        if (map == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            map.put(DTParamKey.REPORT_KEY_APPKEY, str);
        }
        map.put(QCircleDaTongConstant.PageParam.PAGE_SUBCLASS, str2);
        if (d.f54318a.b()) {
            map.put(QZoneDTLoginReporter.PAGE_STYLE, 1);
        } else {
            map.put(QZoneDTLoginReporter.PAGE_STYLE, 0);
        }
    }
}
