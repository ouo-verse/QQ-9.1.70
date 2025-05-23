package com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter;

import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;

/* compiled from: P */
/* loaded from: classes31.dex */
public abstract class NearbyTechReporter {
    public abstract String getKey();

    public void report() {
        try {
            e params = toParams();
            if (params != null) {
                KLog.INSTANCE.d("NearbyTechReporter", '[' + getKey() + "] " + params);
                String key = getKey();
                params.v(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
                Utils.INSTANCE.currentBridgeModule().reportCustomDtEvent(key, params);
            }
        } catch (Exception e16) {
            KLog.INSTANCE.e("NearbyTechReporter", "report error " + e16);
        }
    }

    public abstract e toParams();
}
