package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import com.tencent.qqlive.module.videoreport.constants.EventKey;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DTAppEventMapHandler extends DTBaseEventMapHandler {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class Holder {
        private static final DTAppEventMapHandler instance = new DTAppEventMapHandler();

        Holder() {
        }
    }

    public static DTAppEventMapHandler getInstance() {
        return Holder.instance;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseEventMapHandler
    public void formatCustomParams(String str, Map<String, Object> map, Map<String, Object> map2) {
        super.formatCustomParams(str, map, map2);
        if (EventKey.APP_OUT.equals(str)) {
            formatLvTime(map, map2);
            if (isValidMap(map2) && map2.containsKey("cur_pg") && isValidMap(map2.get("cur_pg"))) {
                formatPage(map, (Map) map2.get("cur_pg"));
            }
        }
    }
}
