package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.constants.ParamKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes22.dex */
public class DTNewsPageEventMapHandler extends DTPageEventMapHandler {
    private DTNewsPageParamsFlattenHelper mFlattenHelper = new DTNewsPageParamsFlattenHelper();

    /* loaded from: classes22.dex */
    private static class Holder {
        private static final DTNewsPageEventMapHandler instance = new DTNewsPageEventMapHandler();

        Holder() {
        }
    }

    DTNewsPageEventMapHandler() {
    }

    private void flatten(String str, Map<String, Object> map, Map<String, Object> map2) {
        if (map != null && map2 != null) {
            Map<String, Object> removeMapParams = this.mFlattenHelper.removeMapParams(map2, "ref_pg");
            Object remove = this.mFlattenHelper.remove(map2, ParamKey.PAGE_PATH);
            Object remove2 = this.mFlattenHelper.remove(removeMapParams, ParamKey.PAGE_PATH);
            Object remove3 = this.mFlattenHelper.remove(map2, DTParamKey.REPORT_KEY_INTERACTIVE_FLAG);
            Object remove4 = this.mFlattenHelper.remove(map2, DTParamKey.REPORT_KEY_IS_PAGE_RETURN);
            this.mFlattenHelper.putAllPageParams(map2, getCurPagePrivateParams(map2), "pg_");
            this.mFlattenHelper.putAllPageParams(map2, removeMapParams, "refpg_");
            map.put(DTParamKey.CUR_PAGE_PATH, remove);
            map.put(DTParamKey.REF_PAGE_PATH, remove2);
            if ("pgout".equals(str)) {
                map.put(DTParamKey.REPORT_KEY_INTERACTIVE_FLAG, remove3);
            } else if ("pgin".equals(str)) {
                map.put(DTParamKey.REPORT_KEY_IS_PAGE_RETURN, remove4);
            }
        }
    }

    private Map<String, Object> getCurPagePrivateParams(Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Object> next = it.next();
                String key = next.getKey();
                it.remove();
                hashMap.put(key, next.getValue());
            }
        }
        return hashMap;
    }

    public static DTNewsPageEventMapHandler getInstance() {
        return Holder.instance;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTPageEventMapHandler, com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseEventMapHandler
    public void formatCustomParams(String str, Map<String, Object> map, Map<String, Object> map2) {
        super.formatCustomParams(str, map, map2);
        flatten(str, map, map2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTAbstractEventMapHandler
    public Object getOrRemove(@NonNull Map<?, ?> map, String str) {
        return this.mFlattenHelper.getOrRemove(map, str);
    }
}
