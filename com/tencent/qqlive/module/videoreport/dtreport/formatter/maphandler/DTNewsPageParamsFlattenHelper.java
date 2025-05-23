package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.constants.ParamKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import java.util.Map;

/* loaded from: classes22.dex */
class DTNewsPageParamsFlattenHelper extends DTBaseEventMapHandler {
    /* JADX INFO: Access modifiers changed from: package-private */
    public void flattenPageParams(Map<String, Object> map, Map<String, Object> map2) {
        Map<String, Object> removeMapParams = removeMapParams(map2, "cur_pg");
        if (map != null && removeMapParams != null) {
            map.put(DTParamKey.CUR_PAGE_PATH, removeMapParams.remove(ParamKey.PAGE_PATH));
            map.put(DTParamKey.REPORT_KEY_INTERACTIVE_FLAG, removeMapParams.remove(DTParamKey.REPORT_KEY_INTERACTIVE_FLAG));
            Map<String, Object> removeMapParams2 = removeMapParams(removeMapParams, "ref_pg");
            map.put(DTParamKey.REF_PAGE_PATH, remove(removeMapParams2, ParamKey.PAGE_PATH));
            putAllPageParams(map2, removeMapParams2, "refpg_");
            putAllPageParams(map2, removeMapParams, "pg_");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> getMapParams(Map<String, Object> map, String str) {
        if (!isValidMap(map) || TextUtils.isEmpty(str)) {
            return null;
        }
        Object obj = map.get(str);
        if (!isValidMap(obj)) {
            return null;
        }
        return (Map) obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTAbstractEventMapHandler
    public Object getOrRemove(@NonNull Map<?, ?> map, String str) {
        return map.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void putAllPageParams(Map<String, Object> map, Map<String, Object> map2, String str) {
        if (isValidMap(map) && !BaseUtils.isEmpty(map2)) {
            for (Map.Entry<String, Object> entry : map2.entrySet()) {
                if (entry != null && entry.getKey() != null && entry.getValue() != null) {
                    map.put(str + entry.getKey(), entry.getValue());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> removeMapParams(Map<String, Object> map, String str) {
        Map<String, Object> mapParams = getMapParams(map, str);
        remove(map, str);
        return mapParams;
    }
}
