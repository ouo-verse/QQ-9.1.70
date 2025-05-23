package com.tencent.biz.pubaccount.weishi.request.newreq;

import UserGrowth.stWeishiDengtaReportReq;
import UserGrowth.stWeishiDengtaReportRsp;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.biz.pubaccount.weishi.util.x;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSBeaconSendRequest extends g<stWeishiDengtaReportRsp> {
    private static final String CMD_STRING = "WeishiDengtaReport";
    private static final String TAG = "BeaconSendRequest";

    public WSBeaconSendRequest(String str, Map<String, String> map) {
        super(CMD_STRING);
        stWeishiDengtaReportReq stweishidengtareportreq = new stWeishiDengtaReportReq();
        stweishidengtareportreq.eventName = str;
        stweishidengtareportreq.params = checkValueNotnull(map);
        this.req = stweishidengtareportreq;
        x.b(TAG, "BeaconSendRequest = " + stweishidengtareportreq.toString());
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public Class<stWeishiDengtaReportRsp> getRspClass() {
        return stWeishiDengtaReportRsp.class;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public boolean isHeaderNeedExpABTestData() {
        return false;
    }

    @Override // com.tencent.biz.pubaccount.weishi.net.common.g
    public boolean isReportPerformance() {
        return false;
    }

    private Map<String, String> checkValueNotnull(Map<String, String> map) {
        if (map == null) {
            return new HashMap();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry.getValue() == null) {
                entry.setValue("");
            }
        }
        return map;
    }
}
