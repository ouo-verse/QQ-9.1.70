package com.tencent.mobileqq.qwallet.report;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.report.beacon.CommonReportBean;
import com.tencent.mobileqq.qwallet.report.beacon.IQWalletCommonReport;

/* compiled from: P */
@Deprecated
/* loaded from: classes16.dex */
public class VACDReportUtil {
    public static void a(String str, String str2, String str3, String str4, int i3, String str5) {
        ((IQWalletCommonReport) QRoute.api(IQWalletCommonReport.class)).report("e_common_report", new CommonReportBean(str, str2, str3, str4, i3, str5));
    }
}
