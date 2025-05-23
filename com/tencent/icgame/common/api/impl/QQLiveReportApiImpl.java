package com.tencent.icgame.common.api.impl;

import com.tencent.icgame.common.api.IQQLiveReportApi;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qroute.QRoute;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;
import rt0.a;

/* compiled from: P */
/* loaded from: classes7.dex */
public class QQLiveReportApiImpl implements IQQLiveReportApi {
    public static final String TAG = "ICGameUnknown|ICGameReportApiImpl";
    public HashMap<String, Long> timeMap = new HashMap<>();

    @Override // com.tencent.icgame.common.api.IQQLiveReportApi
    public String generateTraceId() {
        String str = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "_" + new SimpleDateFormat("MMddHHmmssSSS").format(new Date(System.currentTimeMillis())) + "_" + UUID.randomUUID();
        a.b(TAG, "generateTraceId", "traceId:" + str);
        return str;
    }
}
