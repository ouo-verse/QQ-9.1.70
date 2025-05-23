package com.tencent.mobileqq.qqecommerce.biz.report.api.impl;

import com.tencent.mobileqq.qqecommerce.biz.report.ECDataReportManager;
import com.tencent.mobileqq.qqecommerce.biz.report.api.IQQECDataReport;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/report/api/impl/QQECDataReportImpl;", "Lcom/tencent/mobileqq/qqecommerce/biz/report/api/IQQECDataReport;", "()V", "dataReportManager", "Lcom/tencent/mobileqq/qqecommerce/biz/report/ECDataReportManager;", "dataReport", "", "action", "", "params", "", "", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class QQECDataReportImpl implements IQQECDataReport {
    private final ECDataReportManager dataReportManager = new ECDataReportManager();

    @Override // com.tencent.mobileqq.qqecommerce.biz.report.api.IQQECDataReport
    public void dataReport(String action, Map<Object, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(params, "params");
        this.dataReportManager.dataReport(action, params, true);
    }
}
