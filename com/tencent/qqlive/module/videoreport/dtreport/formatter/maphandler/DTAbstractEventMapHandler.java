package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.qqlive.module.videoreport.constants.ParamKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
abstract class DTAbstractEventMapHandler implements IEventMapHandler {
    static final String CUR_PAGE_PREFIX = "pg_";
    static final String REF_PAGE_PREFIX = "refpg_";

    private Object getAndRemoveInteractiveFlag(Map<?, ?> map) {
        if (!isValidMap(map)) {
            return null;
        }
        return map.remove(ParamKey.REPORT_KEY_INTERACTIVE_FLAG);
    }

    private String getOrRemoveContentId(Map map) {
        Object orRemove;
        if (!isValidMap(map) || (orRemove = getOrRemove(map, ParamKey.CONTENT_ID)) == null) {
            return null;
        }
        return orRemove.toString();
    }

    private String getOrRemovePageId(Map<?, ?> map) {
        Object orRemove;
        if (!isValidMap(map) || (orRemove = getOrRemove(map, "pgid")) == null) {
            return null;
        }
        return orRemove.toString();
    }

    private String getOrRemovePageStp(Map<?, ?> map) {
        Object orRemove;
        if (!isValidMap(map) || !map.containsKey(ParamKey.REPORT_KEY_PG_STP) || (orRemove = getOrRemove(map, ParamKey.REPORT_KEY_PG_STP)) == null) {
            return null;
        }
        return orRemove.toString();
    }

    private String getOrRemoveRefPageParams(Map<?, ?> map, String str) {
        Object orRemove;
        if (!isValidMap(map) || !map.containsKey("ref_pg")) {
            return null;
        }
        Object obj = map.get("ref_pg");
        if (!isValidMap(obj)) {
            return null;
        }
        Map<?, ?> map2 = (Map) obj;
        if (!map2.containsKey(str) || (orRemove = getOrRemove(map2, str)) == null) {
            return null;
        }
        return orRemove.toString();
    }

    private void putToMap(Map<String, Object> map, String str, Object obj) {
        if (obj == null) {
            return;
        }
        if ((obj instanceof String) && TextUtils.isEmpty((String) obj)) {
            return;
        }
        map.put(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void formatLvTime(Map<String, Object> map, Map<String, Object> map2) {
        Object orRemove;
        if (isValidMap(map2) && map2.containsKey(ParamKey.REPORT_KEY_LVTM) && (orRemove = getOrRemove(map2, ParamKey.REPORT_KEY_LVTM)) != null) {
            map.put(DTParamKey.REPORT_KEY_LVTM, orRemove);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void formatPage(Map<String, Object> map, Map map2) {
        if (isValidMap(map2) && isValidMap(map)) {
            String orRemovePageId = getOrRemovePageId(map2);
            String orRemoveContentId = getOrRemoveContentId(map2);
            String orRemoveRefPageParams = getOrRemoveRefPageParams(map2, "pgid");
            String orRemoveRefPageParams2 = getOrRemoveRefPageParams(map2, ParamKey.CONTENT_ID);
            String orRemoveCrePageParams = getOrRemoveCrePageParams(map2, "pgid");
            String orRemoveCrePageParams2 = getOrRemoveCrePageParams(map2, ParamKey.CONTENT_ID);
            String orRemovePageStp = getOrRemovePageStp(map2);
            putToMap(map, "dt_pgid", orRemovePageId);
            putToMap(map, DTParamKey.REPORT_KEY_CONTENT_ID, orRemoveContentId);
            putToMap(map, "dt_ref_pgid", orRemoveRefPageParams);
            putToMap(map, DTParamKey.REF_PAGE_CONTENT_ID, orRemoveRefPageParams2);
            putToMap(map, DTParamKey.REPORT_KEY_CRE_PAGE_ID, orRemoveCrePageParams);
            putToMap(map, DTParamKey.CRE_PAGE_CONTENT_ID, orRemoveCrePageParams2);
            putToMap(map, "dt_pgstp", orRemovePageStp);
            Object andRemoveInteractiveFlag = getAndRemoveInteractiveFlag(map2);
            putToMap(map2, DTParamKey.REPORT_KEY_INTERACTIVE_FLAG, andRemoveInteractiveFlag);
            putToMap(map, DTParamKey.REPORT_KEY_INTERACTIVE_FLAG, andRemoveInteractiveFlag);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void formatPublicParams(Map<String, Object> map) {
        if (!isValidMap(map)) {
            return;
        }
        formatSinglePublicParams(map, ParamKey.REPORT_KEY_USID, DTParamKey.REPORT_KEY_USID);
        formatSinglePublicParams(map, ParamKey.REPORT_KEY_US_STMP, DTParamKey.REPORT_KEY_US_STMP);
        formatSinglePublicParams(map, ParamKey.REPORT_KEY_USSN, DTParamKey.REPORT_KEY_USSN);
        formatSinglePublicParams(map, ParamKey.REPORT_KEY_COLD_START, DTParamKey.REPORT_KEY_COLD_START);
    }

    void formatSinglePublicParams(Map<String, Object> map, String str, String str2) {
        if (map.containsKey(str)) {
            map.put(str2, map.remove(str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getOrRemove(@NonNull Map<?, ?> map, String str) {
        return map.get(str);
    }

    String getOrRemoveCrePageParams(Map<?, ?> map, String str) {
        Object orRemove;
        if (!isValidMap(map) || !map.containsKey("cre_pg")) {
            return null;
        }
        Object obj = map.get("cre_pg");
        if (!isValidMap(obj)) {
            return null;
        }
        Map<?, ?> map2 = (Map) obj;
        if (!map2.containsKey(str) || (orRemove = getOrRemove(map2, str)) == null) {
            return null;
        }
        return orRemove.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isValidMap(Object obj) {
        return obj instanceof Map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void transferIfExist(Map<String, Object> map, Map<String, Object> map2, String str) {
        if (map2.containsKey(str)) {
            map.put(str, getOrRemove(map2, str));
        }
    }
}
