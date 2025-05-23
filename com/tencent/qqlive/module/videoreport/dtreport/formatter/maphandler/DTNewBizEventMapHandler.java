package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
class DTNewBizEventMapHandler extends DTBaseEventMapHandler {
    private DTNewsPageParamsFlattenHelper mNewsFlattenHelper = new DTNewsPageParamsFlattenHelper();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class Holder {
        private static final DTNewBizEventMapHandler instance = new DTNewBizEventMapHandler();

        Holder() {
        }
    }

    DTNewBizEventMapHandler() {
    }

    public static DTNewBizEventMapHandler getInstance() {
        return Holder.instance;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseEventMapHandler
    public void formatCustomParams(String str, Map<String, Object> map, Map<String, Object> map2) {
        super.formatCustomParams(str, map, map2);
        if (map != null && map2 != null) {
            formatPage(map, this.mNewsFlattenHelper.getMapParams(map2, "cur_pg"));
            this.mNewsFlattenHelper.flattenPageParams(map, map2);
        }
    }
}
