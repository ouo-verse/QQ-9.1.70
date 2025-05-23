package com.tencent.mobileqq.qwallet.report.impl;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.qwallet.report.IReportApi;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ReportApiImpl implements IReportApi {
    @Override // com.tencent.mobileqq.qwallet.report.IReportApi
    public void reportHongbaoTo644(BaseQQAppInterface baseQQAppInterface, String str, p pVar) {
        ReportUtils.e(str, pVar);
    }

    @Override // com.tencent.mobileqq.qwallet.report.IReportApi
    public void reportToDengTa(String str, String str2, String str3, String str4, String str5, String str6) {
        ReportUtils.i(str, str2, str3, str4, str5, str6);
    }

    @Override // com.tencent.mobileqq.qwallet.report.IReportApi
    public void reportHongbaoTo644(String str, p pVar, String str2) {
        ReportUtils.f(str, pVar, str2);
    }

    @Override // com.tencent.mobileqq.qwallet.report.IReportApi
    public void reportHongbaoTo644(String str, String str2, String str3, String str4, String str5) {
        ReportUtils.g(str, str2, str3, str4, str5);
    }
}
