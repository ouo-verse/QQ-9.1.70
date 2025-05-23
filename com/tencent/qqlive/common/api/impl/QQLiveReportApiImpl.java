package com.tencent.qqlive.common.api.impl;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qqlive.api.report.IQQLiveCallMainServiceApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqlive.common.api.IQQLiveReportApi;
import com.tencent.qqlive.common.api.impl.QQLiveReportApiImpl;
import com.tencent.qqlive.common.report.constant.QQLiveQualityReportData;
import com.tencent.qqlive.common.report.constant.QQLiveReportConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QQLiveReportApiImpl implements IQQLiveReportApi {
    public static final String TAG = "unknown|QQLiveReportApiImpl";
    public HashMap<String, Long> timeMap = new HashMap<>();

    private long computeKeyCost(String str) {
        if (this.timeMap.containsKey(str)) {
            return this.timeMap.remove(str).longValue();
        }
        return -1L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$qualityReport$0(QQLiveQualityReportData.Builder builder) {
        ((IQQLiveCallMainServiceApi) QRoute.api(IQQLiveCallMainServiceApi.class)).qualityReport(QQLiveReportConstants.ATTAID, builder);
    }

    @Override // com.tencent.qqlive.common.api.IQQLiveReportApi
    public String generateTraceId() {
        String str = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "_" + new SimpleDateFormat("MMddHHmmssSSS").format(new Date(System.currentTimeMillis())) + "_" + UUID.randomUUID();
        AegisLogger.i(TAG, "generateTraceId", "traceId:" + str);
        return str;
    }

    @Override // com.tencent.qqlive.common.api.IQQLiveReportApi
    public void mapEndKeyReport(String str, QQLiveQualityReportData.Builder builder) {
        long computeKeyCost = computeKeyCost(str);
        AegisLogger.i(TAG, "mapEndKeyReport", "key:" + str + " cost:" + computeKeyCost);
        if (computeKeyCost > 0) {
            builder.cost(String.valueOf(computeKeyCost));
            ((IQQLiveCallMainServiceApi) QRoute.api(IQQLiveCallMainServiceApi.class)).qualityReport(QQLiveReportConstants.ATTAID, builder);
        }
    }

    @Override // com.tencent.qqlive.common.api.IQQLiveReportApi
    public void mapStartKey(String str) {
        AegisLogger.i(TAG, "mapStartKey", "key:" + str);
        this.timeMap.put(str, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.tencent.qqlive.common.api.IQQLiveReportApi
    public void qualityReport(final QQLiveQualityReportData.Builder builder) {
        AegisLogger.i(TAG, "qualityReport", "builder:" + builder.toString());
        ThreadManagerV2.excute(new Runnable() { // from class: dt3.h
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveReportApiImpl.lambda$qualityReport$0(QQLiveQualityReportData.Builder.this);
            }
        }, 16, null, true);
    }
}
