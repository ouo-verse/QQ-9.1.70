package com.tencent.mobileqq.search.api.impl;

import com.tencent.mobileqq.search.api.ISearchReportApi;
import com.tencent.mobileqq.search.searchdetail.content.wxminapp.report.j;
import com.tencent.mobileqq.search.util.ak;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import qp2.SearchActionReportParam;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SearchReportApiImpl implements ISearchReportApi {
    @Override // com.tencent.mobileqq.search.api.ISearchReportApi
    public void reportCgiNetworkPerformance(ToServiceMsg toServiceMsg, FromServiceMsg fromServiceMsg) {
        ak.a(toServiceMsg, fromServiceMsg);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchReportApi
    public void reportErrorLog(String str, String str2) {
        ak.b(str, str2);
    }

    @Override // com.tencent.mobileqq.search.api.ISearchReportApi
    public void reportMiniAppAction(SearchActionReportParam searchActionReportParam) {
        if (searchActionReportParam != null) {
            j.C(searchActionReportParam);
        }
    }

    @Override // com.tencent.mobileqq.search.api.ISearchReportApi
    public void reportUnusedModuleDetection(String str, String str2) {
        ak.f(str, str2);
    }
}
