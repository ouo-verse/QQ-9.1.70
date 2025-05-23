package com.pay.network.model;

import android.text.TextUtils;
import com.pay.http.APHttpReqPost;
import com.pay.http.APPluginUrlConf;
import com.tencent.midas.data.APPluginDataInterface;

/* loaded from: classes2.dex */
public class APDataReportReq extends APHttpReqPost {
    public APDataReportReq() {
        String offerId = APPluginDataInterface.singleton().getOfferId();
        if (TextUtils.isEmpty(offerId)) {
            return;
        }
        setReportUrl(String.format(APPluginUrlConf.AP_LOGREPORT_FCG, offerId), String.format(APPluginUrlConf.AP_LOGREPORT_FCG, offerId), String.format(APPluginUrlConf.AP_LOGREPORT_FCG, offerId));
    }

    public void startService(String str) {
        if (str.equals("") || TextUtils.isEmpty(APPluginDataInterface.singleton().getOfferId())) {
            return;
        }
        this.httpParam.reqParam.clear();
        this.httpParam.reqParam.put(str, "");
        startRequest();
    }
}
