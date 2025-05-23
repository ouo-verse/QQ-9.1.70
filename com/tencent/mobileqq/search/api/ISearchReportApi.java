package com.tencent.mobileqq.search.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import qp2.SearchActionReportParam;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes18.dex */
public interface ISearchReportApi extends QRouteApi {
    public static final String KEY_SEND_REQ_TIME = "send_req_time";

    void reportCgiNetworkPerformance(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg);

    void reportErrorLog(String str, String str2);

    void reportMiniAppAction(SearchActionReportParam searchActionReportParam);

    void reportUnusedModuleDetection(String str, String str2);
}
