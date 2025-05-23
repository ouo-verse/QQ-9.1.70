package com.tencent.mobileqq.apollo.statistics.product.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper;
import java.util.ArrayList;
import java.util.Map;
import s81.b;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ApolloDtReportHelperImpl implements IApolloDtReportHelper {
    @Override // com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper
    public void apolloCmEmojiSendReport(ArrayList arrayList, AppInterface appInterface, int i3) {
        b.b(arrayList, appInterface, i3);
    }

    @Override // com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper
    public int getReportSessionType(int i3) {
        return b.c(i3);
    }

    @Override // com.tencent.mobileqq.apollo.statistics.product.api.IApolloDtReportHelper
    public void report(String str, String str2, String str3, Map<String, String> map) {
        b.d(str, str2, str3, map);
    }
}
