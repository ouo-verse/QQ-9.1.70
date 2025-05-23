package com.huawei.hms.push.utils;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

/* loaded from: classes2.dex */
public final class PushBiUtil {
    public static String reportEntry(Context context, String str) {
        return HiAnalyticsClient.reportEntry(context, str, 60500300);
    }

    public static void reportExit(Context context, String str, ResponseErrorCode responseErrorCode) {
        HiAnalyticsClient.reportExit(context, str, responseErrorCode.getTransactionId(), responseErrorCode.getStatusCode(), responseErrorCode.getErrorCode(), 60500300);
    }

    public static void reportExit(Context context, String str, String str2, ErrorEnum errorEnum) {
        HiAnalyticsClient.reportExit(context, str, str2, Status.SUCCESS.getStatusCode(), errorEnum.getExternalCode(), 60500300);
    }

    public static void reportExit(Context context, String str, String str2, int i3) {
        HiAnalyticsClient.reportExit(context, str, str2, Status.SUCCESS.getStatusCode(), i3, 60500300);
    }
}
