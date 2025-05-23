package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import com.tencent.qqlive.module.videoreport.constants.ParamKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DTViewFlattenEventMapHandler extends DTBaseElementEventMapHandler {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class Holder {
        public static final DTViewFlattenEventMapHandler instance = new DTViewFlattenEventMapHandler();

        Holder() {
        }
    }

    public static DTViewFlattenEventMapHandler getInstance() {
        return Holder.instance;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseElementEventMapHandler, com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseEventMapHandler
    public void formatCustomParams(String str, Map<String, Object> map, Map<String, Object> map2) {
        Object remove;
        super.formatCustomParams(str, map, map2);
        if (map != null && map2 != null && (remove = remove(map2, ParamKey.ELEMENT_PARAMS)) != null) {
            map.put(DTParamKey.ELEMENT_PARAMS, remove);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseElementEventMapHandler
    protected String getElementId(Map<String, Object> map) {
        if (!isValidMap(map)) {
            return null;
        }
        return (String) map.get("eid");
    }
}
