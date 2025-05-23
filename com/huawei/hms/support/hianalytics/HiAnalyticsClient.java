package com.huawei.hms.support.hianalytics;

import android.content.Context;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HiAnalyticsClient extends HiAnalyticsBase {
    private static final String TAG = "HiAnalyticsClient";

    @Deprecated
    public static String reportEntry(Context context, String str) {
        if (context == null) {
            HMSLog.e(TAG, "<reportEntry 2 param> context is null.");
            return "";
        }
        return reportEntry(context, str, Util.getAppId(context), 0);
    }

    public static void reportExit(Context context, String str, String str2, int i3, int i16) {
        if (context == null) {
            HMSLog.e(TAG, "<reportExit 5 param> context is null.");
        } else {
            reportExit(context, str, str2, Util.getAppId(context), i3, i16, 0);
        }
    }

    public static String reportEntry(Context context, String str, int i3) {
        if (context == null) {
            HMSLog.e(TAG, "<reportEntry 3 param> context is null.");
            return "";
        }
        return reportEntry(context, str, Util.getAppId(context), i3);
    }

    public static void reportExit(Context context, String str, String str2, int i3, int i16, int i17) {
        if (context == null) {
            HMSLog.e(TAG, "<reportExit 6 param> context is null.");
        } else {
            reportExit(context, str, str2, Util.getAppId(context), i3, i16, i17);
        }
    }

    public static String reportEntry(Context context, String str, String str2, int i3) {
        if (context == null) {
            HMSLog.e(TAG, "<reportEntry 4 param> context is null.");
            return "";
        }
        String id5 = TransactionIdCreater.getId(str2, str);
        Map<String, String> mapForBi = HiAnalyticsBase.getMapForBi(context, str);
        mapForBi.put("appid", str2);
        mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, id5);
        mapForBi.put("direction", "req");
        mapForBi.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(i3)));
        mapForBi.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_KIT_API_CALLED, mapForBi);
        return id5;
    }

    public static void reportExit(Context context, String str, String str2, String str3, int i3, int i16, int i17) {
        if (context == null) {
            HMSLog.e(TAG, "<reportExit 7 param> context is null.");
            return;
        }
        Map<String, String> mapForBi = HiAnalyticsBase.getMapForBi(context, str);
        mapForBi.put("appid", str3);
        mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, str2);
        mapForBi.put("direction", "rsp");
        mapForBi.put(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, String.valueOf(i3));
        mapForBi.put("result", String.valueOf(i16));
        mapForBi.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(i17)));
        mapForBi.put("phoneType", Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(context, HiAnalyticsConstant.HMS_SDK_KIT_API_CALLED, mapForBi);
    }
}
