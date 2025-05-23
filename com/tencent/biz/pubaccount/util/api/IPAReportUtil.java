package com.tencent.biz.pubaccount.util.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.List;

@QAPI(process = {"all"})
/* loaded from: classes4.dex */
public interface IPAReportUtil extends QRouteApi {
    void reportAdMsgArriveReceipt(AppInterface appInterface, String str, String str2, String str3, String str4, String str5, List<String> list);

    void reportAdMsgRead(AppInterface appInterface, String str, String str2, String str3, List<String> list, List<String> list2, List<String> list3);

    void reportClickEventForAdver(AppInterface appInterface, String str, String str2, String str3);
}
