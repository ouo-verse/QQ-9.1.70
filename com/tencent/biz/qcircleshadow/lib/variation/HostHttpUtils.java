package com.tencent.biz.qcircleshadow.lib.variation;

import com.tencent.mobileqq.qcircle.api.impl.QCircleServiceImpl;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;

/* compiled from: P */
/* loaded from: classes4.dex */
public class HostHttpUtils {
    public static void cancel(NetReq netReq) {
        ((IHttpEngineService) QCircleServiceImpl.getAppRunTime().getRuntimeService(IHttpEngineService.class, "all")).cancelReq(netReq);
    }

    public static void httpEngineServiceSendRequest(HttpNetReq httpNetReq) {
        ((IHttpEngineService) QCircleServiceImpl.getAppRunTime().getRuntimeService(IHttpEngineService.class, "all")).sendReq(httpNetReq);
    }
}
