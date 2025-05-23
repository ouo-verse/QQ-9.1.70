package com.tencent.midas.data;

import com.tencent.midas.api.request.APMidasBaseRequest;
import com.tencent.midas.api.request.APMidasGameRequest;
import com.tencent.midas.api.request.APMidasGoodsRequest;
import com.tencent.midas.api.request.APMidasMonthRequest;
import com.tencent.midas.api.request.APMidasSubscribeRequest;
import com.tencent.midas.comm.APLog;

/* loaded from: classes9.dex */
public class APMidasAnalyzeParams {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class SingletonHolder {
        private static APMidasAnalyzeParams instance = new APMidasAnalyzeParams();

        SingletonHolder() {
        }
    }

    private void AnalyzeCommParams(APMidasBaseRequest aPMidasBaseRequest) {
        try {
            APPluginDataInterface singleton = APPluginDataInterface.singleton();
            singleton.setOfferId(aPMidasBaseRequest.offerId);
            singleton.setOpenId(aPMidasBaseRequest.openId);
            singleton.setOpenKey(aPMidasBaseRequest.openKey);
            singleton.setSessionId(aPMidasBaseRequest.sessionId);
            singleton.setSessionType(aPMidasBaseRequest.sessionType);
            singleton.setPf(aPMidasBaseRequest.f151589pf);
            singleton.setPfKey(aPMidasBaseRequest.pfKey);
            singleton.setZoneId(aPMidasBaseRequest.zoneId);
            singleton.setDiscountUrl(aPMidasBaseRequest.mpInfo.discountUrl);
            singleton.setReserv(aPMidasBaseRequest.reserv);
        } catch (Exception e16) {
            APLog.i("AnalyzeCommParams", e16.toString());
        }
    }

    public static APMidasAnalyzeParams getInstance() {
        return SingletonHolder.instance;
    }

    public void AnalyzeParams(APMidasBaseRequest aPMidasBaseRequest) {
        if (aPMidasBaseRequest != null) {
            AnalyzeCommParams(aPMidasBaseRequest);
            setSaveType(aPMidasBaseRequest);
        }
    }

    public void setSaveType(APMidasBaseRequest aPMidasBaseRequest) {
        APPluginDataInterface singleton = APPluginDataInterface.singleton();
        try {
            if (aPMidasBaseRequest instanceof APMidasGameRequest) {
                if (aPMidasBaseRequest.acctType.equals("qb")) {
                    singleton.setSaveType(3);
                } else {
                    singleton.setSaveType(0);
                }
            } else if (aPMidasBaseRequest instanceof APMidasGoodsRequest) {
                singleton.setSaveType(1);
            } else if (aPMidasBaseRequest instanceof APMidasMonthRequest) {
                singleton.setSaveType(4);
            } else if (aPMidasBaseRequest instanceof APMidasSubscribeRequest) {
                singleton.setSaveType(5);
            }
        } catch (Exception e16) {
            APLog.i("setSaveType", e16.toString());
        }
    }
}
