package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.constants.ParamKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
class DTNewsElementFlattenEventMapHandler extends DTBaseElementEventMapHandler {
    private DTNewsPageParamsFlattenHelper mFlattenHelper = new DTNewsPageParamsFlattenHelper();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class InstanceHolder {
        private static final DTNewsElementFlattenEventMapHandler sInstance = new DTNewsElementFlattenEventMapHandler();

        InstanceHolder() {
        }
    }

    DTNewsElementFlattenEventMapHandler() {
    }

    public static DTNewsElementFlattenEventMapHandler getInstance() {
        return InstanceHolder.sInstance;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseElementEventMapHandler, com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseEventMapHandler
    public void formatCustomParams(String str, Map<String, Object> map, Map<String, Object> map2) {
        super.formatCustomParams(str, map, map2);
        if (map != null && map2 != null) {
            this.mFlattenHelper.flattenPageParams(map, map2);
            Object remove = remove(map2, ParamKey.ELEMENT_PATH);
            if (remove != null) {
                map.put(DTParamKey.ELEMENT_PATH, remove);
            }
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseElementEventMapHandler
    protected String getElementId(Map<String, Object> map) {
        if (!isValidMap(map)) {
            return null;
        }
        return (String) getOrRemove(map, "eid");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTAbstractEventMapHandler
    public Object getOrRemove(@NonNull Map<?, ?> map, String str) {
        return this.mFlattenHelper.getOrRemove(map, str);
    }
}
