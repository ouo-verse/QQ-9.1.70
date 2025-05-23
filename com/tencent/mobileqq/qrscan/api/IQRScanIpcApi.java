package com.tencent.mobileqq.qrscan.api;

import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface IQRScanIpcApi extends QRouteApi {
    public static final String MODULUE_MAIN = "QRScanMainQIPCModule";
    public static final String MODULUE_SUB = "QRScanSubQIPCModule";

    QIPCModule getModule(String str);
}
