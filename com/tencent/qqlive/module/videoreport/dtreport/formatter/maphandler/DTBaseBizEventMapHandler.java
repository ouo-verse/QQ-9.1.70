package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DTBaseBizEventMapHandler extends DTBaseElementEventMapHandler {

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class Holder {
        private static final DTBaseBizEventMapHandler instance = new DTBaseBizEventMapHandler();

        Holder() {
        }
    }

    public static DTBaseBizEventMapHandler getInstance() {
        return Holder.instance;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseElementEventMapHandler, com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseEventMapHandler
    public /* bridge */ /* synthetic */ void formatCustomParams(String str, Map map, Map map2) {
        super.formatCustomParams(str, map, map2);
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseElementEventMapHandler
    protected String getElementId(Map<String, Object> map) {
        if (!isValidMap(map)) {
            return null;
        }
        return (String) map.get("eid");
    }
}
