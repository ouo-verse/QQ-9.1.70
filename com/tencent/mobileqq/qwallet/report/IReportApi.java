package com.tencent.mobileqq.qwallet.report;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes16.dex */
public interface IReportApi extends QRouteApi {
    void reportHongbaoTo644(BaseQQAppInterface baseQQAppInterface, String str, p pVar);

    void reportHongbaoTo644(String str, p pVar, String str2);

    void reportHongbaoTo644(String str, String str2, String str3, String str4, String str5);

    void reportToDengTa(String str, String str2, String str3, String str4, String str5, String str6);
}
