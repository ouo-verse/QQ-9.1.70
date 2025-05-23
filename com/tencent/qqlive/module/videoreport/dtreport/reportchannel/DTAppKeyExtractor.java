package com.tencent.qqlive.module.videoreport.dtreport.reportchannel;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.constants.ParamKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DTAppKeyExtractor {
    private static String appKeyCache = "";
    private static final Set<String> sElementEvents;

    static {
        HashSet hashSet = new HashSet();
        sElementEvents = hashSet;
        hashSet.add("imp");
        hashSet.add("imp_end");
        hashSet.add("clck");
    }

    DTAppKeyExtractor() {
    }

    private static void cacheAppKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            appKeyCache = str;
        }
    }

    public static String getAppKey(String str, Map<String, Object> map) {
        String appKeyFromParams = getAppKeyFromParams(str, map);
        cacheAppKey(appKeyFromParams);
        if (DTEventKey.SCREEN_DOM.equals(str) && TextUtils.isEmpty(appKeyFromParams)) {
            return appKeyCache;
        }
        return appKeyFromParams;
    }

    private static String getAppKeyFromElementPath(Object obj) {
        if (!(obj instanceof List)) {
            return null;
        }
        Iterator it = ((List) obj).iterator();
        while (it.hasNext()) {
            String appKeyFromMap = getAppKeyFromMap(it.next());
            if (!TextUtils.isEmpty(appKeyFromMap)) {
                return appKeyFromMap;
            }
        }
        return null;
    }

    private static String getAppKeyFromMap(@NonNull Object obj) {
        if (!(obj instanceof Map)) {
            return null;
        }
        Object obj2 = ((Map) obj).get(DTParamKey.REPORT_KEY_APPKEY);
        if (!(obj2 instanceof String)) {
            return null;
        }
        return (String) obj2;
    }

    private static String getAppKeyFromParams(String str, Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        String appKeyFromMap = getAppKeyFromMap(map);
        if (!TextUtils.isEmpty(appKeyFromMap)) {
            return appKeyFromMap;
        }
        Object obj = map.get("udf_kv");
        if (!(obj instanceof Map)) {
            return null;
        }
        String appKeyFromMap2 = getAppKeyFromMap(obj);
        if (TextUtils.isEmpty(appKeyFromMap2) && isElementEvent(str)) {
            String appKeyFromElementPath = getAppKeyFromElementPath(getParam(obj, ParamKey.ELEMENT_PARAMS));
            if (!TextUtils.isEmpty(appKeyFromElementPath)) {
                return appKeyFromElementPath;
            }
            return getAppKeyFromMap(getParam(obj, "cur_pg"));
        }
        return appKeyFromMap2;
    }

    private static Object getParam(Object obj, String str) {
        if (obj instanceof Map) {
            return ((Map) obj).get(str);
        }
        return null;
    }

    private static boolean isElementEvent(String str) {
        return sElementEvents.contains(str);
    }
}
