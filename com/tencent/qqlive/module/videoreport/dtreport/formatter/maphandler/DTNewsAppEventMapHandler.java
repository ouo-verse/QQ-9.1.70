package com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.constants.EventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTEventKey;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes22.dex */
public class DTNewsAppEventMapHandler extends DTAppEventMapHandler {
    private DTNewsPageParamsFlattenHelper mFlattenHelper = new DTNewsPageParamsFlattenHelper();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    private static class Holder {
        private static final DTNewsAppEventMapHandler instance = new DTNewsAppEventMapHandler();

        Holder() {
        }
    }

    DTNewsAppEventMapHandler() {
    }

    private void formatAppHeartParams(Map<String, Object> map, Map<String, Object> map2) {
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_APP_SESSIONID);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_APP_FOREGROUND_HEARTBEAT_DURATION);
    }

    private void formatAppinParams(Map<String, Object> map, Map<String, Object> map2) {
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_APP_STARTTIME);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_SYS_ELAPSED_REALTIME);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_APP_HEARTBEAT_INTERVAL);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_APP_FILE_INTERVAL);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_APP_SESSIONID);
    }

    private void formatAppoutParams(Map<String, Object> map, Map<String, Object> map2) {
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_APP_STOPTIME);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_SYS_ELAPSED_REALTIME);
        transferIfExist(map, map2, DTParamKey.REPORT_KEY_APP_SESSIONID);
    }

    public static DTNewsAppEventMapHandler getInstance() {
        return Holder.instance;
    }

    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTAppEventMapHandler, com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTBaseEventMapHandler
    public void formatCustomParams(String str, Map<String, Object> map, Map<String, Object> map2) {
        super.formatCustomParams(str, map, map2);
        if (isValidMap(map) && isValidMap(map2)) {
            if (EventKey.APP_OUT.equals(str)) {
                this.mFlattenHelper.flattenPageParams(map, map2);
                formatAppoutParams(map, map2);
            } else if (EventKey.APP_IN.equals(str)) {
                formatAppinParams(map, map2);
            } else if (DTEventKey.APP_HEARTBEAT.equals(str)) {
                formatAppHeartParams(map, map2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.qqlive.module.videoreport.dtreport.formatter.maphandler.DTAbstractEventMapHandler
    public Object getOrRemove(@NonNull Map<?, ?> map, String str) {
        return this.mFlattenHelper.getOrRemove(map, str);
    }
}
