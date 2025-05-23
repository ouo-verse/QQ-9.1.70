package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DTBaseEventMapHandler extends DTAbstractEventMapHandler {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class Holder {
        private static final DTBaseEventMapHandler instance = new DTBaseEventMapHandler();

        Holder() {
        }
    }

    public static DTBaseEventMapHandler getInstance() {
        return Holder.instance;
    }

    void extractDTParamOut(Map<String, Object> map, Map<String, Object> map2) {
        if (!isValidMap(map)) {
            return;
        }
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> next = it.next();
            String key = next.getKey();
            if (key.startsWith(DTParamKey.DT_PRE_FIX)) {
                map2.put(key, next.getValue());
                it.remove();
            }
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.IEventMapHandler
    public final void formatEvent(String str, Map<String, Object> map, Map<String, Object> map2) {
        formatPublicParams(map);
        formatCustomParams(str, map, map2);
        extractDTParamOut(map2, map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void formatSingleParam(Map<String, Object> map, String str, Map<String, Object> map2, String str2) {
        Object obj;
        if (isValidMap(map)) {
            obj = getOrRemove(map, str);
        } else {
            obj = null;
        }
        map2.put(str2, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void formatSingleParamNonNull(Map<String, Object> map, String str, Map<String, Object> map2, String str2) {
        Object obj;
        if (isValidMap(map)) {
            obj = getOrRemove(map, str);
        } else {
            obj = null;
        }
        if (obj != null) {
            map2.put(str2, obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object remove(Map<String, Object> map, String str) {
        if (map != null && str != null && map.containsKey(str)) {
            return map.remove(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void formatCustomParams(String str, Map<String, Object> map, Map<String, Object> map2) {
    }
}
