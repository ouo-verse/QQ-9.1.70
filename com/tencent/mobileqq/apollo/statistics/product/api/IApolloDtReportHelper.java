package com.tencent.mobileqq.apollo.statistics.product.api;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.util.ArrayList;
import java.util.Map;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IApolloDtReportHelper extends QRouteApi {
    void apolloCmEmojiSendReport(ArrayList arrayList, AppInterface appInterface, int i3);

    int getReportSessionType(int i3);

    void report(String str, String str2, String str3, Map<String, String> map);
}
