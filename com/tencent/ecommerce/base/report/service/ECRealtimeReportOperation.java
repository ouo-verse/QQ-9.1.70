package com.tencent.ecommerce.base.report.service;

import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/base/report/service/ECRealtimeReportOperation;", "", QCircleDaTongConstant.ElementParamValue.OPERATION, "", "(Ljava/lang/String;II)V", "EC_REALTIME_REPORT_OPERATION_UNKNOWN", "EC_REALTIME_REPORT_OPERATION_VIEW_SHOW_WINDOWS", "EC_REALTIME_REPORT_OPERATION_VIEW_PRODUCT", "EC_REALTIME_REPORT_OPERATION_BUY_SAAS_PRODUCT", "EC_REALTIME_REPORT_OPERATION_TERMINAL_REAL_REPORT", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public enum ECRealtimeReportOperation {
    EC_REALTIME_REPORT_OPERATION_UNKNOWN(0),
    EC_REALTIME_REPORT_OPERATION_VIEW_SHOW_WINDOWS(1),
    EC_REALTIME_REPORT_OPERATION_VIEW_PRODUCT(2),
    EC_REALTIME_REPORT_OPERATION_BUY_SAAS_PRODUCT(3),
    EC_REALTIME_REPORT_OPERATION_TERMINAL_REAL_REPORT(50);

    public final int operation;

    ECRealtimeReportOperation(int i3) {
        this.operation = i3;
    }
}
