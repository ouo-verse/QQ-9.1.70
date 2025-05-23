package com.tencent.mobileqq.winkreport.crashreport;

import android.text.TextUtils;
import com.tencent.mobileqq.mqq.api.IThreadManagerApi;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.crashreport.WinkCrashReportParams;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import uq3.g;

/* loaded from: classes21.dex */
public class WinkCrashReportParams {
    public static final String E_PEAK_CRASH_PATHINFO = "E_PEAK_CRASH_PATHINFO";
    public static final String E_PEAK_NEW_CRASH_PATHINFO = "E_PEAK_NEW_CRASH_PATHINFO";
    public static final String TAG = "PeakAppInterface.WinkCrashReportParams";
    private static String activity_times = "";
    private static final ConcurrentHashMap<String, Integer> fragment_params = new ConcurrentHashMap<>();
    private static final Set<String> fragments = Collections.newSetFromMap(new ConcurrentHashMap());
    private static int interface_id = 0;
    private static boolean isBackground = false;
    private static String last_activity = "";
    private static String trace_id = "";

    public static void clearAllParams() {
        trace_id = "";
        activity_times = "";
        last_activity = "";
        fragment_params.clear();
        fragments.clear();
        saveAllParams();
    }

    public static void clearAllParamsExceptTrace() {
        activity_times = "";
        last_activity = "";
        fragment_params.clear();
        fragments.clear();
        saveAllParams();
    }

    public static String getActivityTimeParams() {
        Object d16 = g.d(WinkCrashReportConstants.KEY_WINK_ACTIVITY_CRASH_TIME_REPORT_INFO, "");
        if (!(d16 instanceof String)) {
            return "";
        }
        return (String) d16;
    }

    public static String getFragmentParams() {
        Object d16 = g.d(WinkCrashReportConstants.KEY_WINK_FRAGMENT_CRASH_REPORT_PARAM_INFO, "");
        if (!(d16 instanceof String)) {
            return "";
        }
        return (String) d16;
    }

    public static String getFragments() {
        Object d16 = g.d(WinkCrashReportConstants.KEY_WINK_FRAGMENT_CRASH_REPORT_INFO, "");
        if (!(d16 instanceof String)) {
            return "";
        }
        return ((String) d16).replace("[", "").replace("]", "");
    }

    public static String getLastActivity() {
        Object d16 = g.d(WinkCrashReportConstants.KEY_WINK_LAST_ACTIVITY_CRASH_REPORT_INFO, "");
        if (!(d16 instanceof String)) {
            return "";
        }
        return (String) d16;
    }

    public static String getTraceId() {
        Object d16 = g.d(WinkCrashReportConstants.KEY_WINK_TRACEID_CRASH_REPORT_INFO, "");
        if (!(d16 instanceof String)) {
            return "";
        }
        return (String) d16;
    }

    public static boolean isBackground() {
        Object d16 = g.d(WinkCrashReportConstants.KEY_WINK_IS_BACKGROUND, "");
        if (d16 instanceof Boolean) {
            return ((Boolean) d16).booleanValue();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$reportCrashReportInfo$4(String str, String str2, String str3, String str4, String str5) {
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).uploadQualityReport(new QCirclePublishQualityDataBuilder().setTraceId(str).setKeyEventId(E_PEAK_CRASH_PATHINFO).setExt1(str2).setExt2(str3).setExt3(str4).setExt4(str5));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$saveActivityParams$0() {
        g.e(WinkCrashReportConstants.KEY_WINK_LAST_ACTIVITY_CRASH_REPORT_INFO, last_activity);
        g.e(WinkCrashReportConstants.KEY_WINK_ACTIVITY_CRASH_TIME_REPORT_INFO, activity_times);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$saveAllParams$3() {
        g.e(WinkCrashReportConstants.KEY_WINK_TRACEID_CRASH_REPORT_INFO, trace_id);
        g.e(WinkCrashReportConstants.KEY_WINK_LAST_ACTIVITY_CRASH_REPORT_INFO, last_activity);
        g.e(WinkCrashReportConstants.KEY_WINK_ACTIVITY_CRASH_TIME_REPORT_INFO, activity_times);
        g.e(WinkCrashReportConstants.KEY_WINK_FRAGMENT_CRASH_REPORT_INFO, fragments.toString());
        g.e(WinkCrashReportConstants.KEY_WINK_IS_BACKGROUND, Boolean.valueOf(isBackground));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$saveBackgroundParams$2() {
        g.e(WinkCrashReportConstants.KEY_WINK_IS_BACKGROUND, Boolean.valueOf(isBackground));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$saveFragmentParams$1() {
        g.e(WinkCrashReportConstants.KEY_WINK_FRAGMENT_CRASH_REPORT_INFO, fragments.toString());
    }

    public static void putActivityParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss");
        last_activity = str;
        activity_times = simpleDateFormat.format(new Date());
        saveActivityParams();
        QLog.i(TAG, 1, last_activity);
    }

    public static void putAppInterfaceId(int i3) {
        interface_id = i3;
    }

    public static void putFragmentParams(String str, int i3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        fragment_params.put(str, Integer.valueOf(i3));
        if ((i3 <= 4 && fragments.add(str)) || (i3 >= 6 && fragments.remove(str))) {
            saveFragmentParams();
        }
        QLog.d(TAG, 4, fragments.toString());
    }

    public static void putTraceIdParams(String str, int i3) {
        if (!TextUtils.isEmpty(str) && !str.equals(trace_id)) {
            if (i3 != interface_id && !TextUtils.isEmpty(getTraceId())) {
                reportCrashReportInfo(str);
            }
            interface_id = i3;
            trace_id = str;
            saveAllParams();
        }
    }

    public static void reportCrashReportInfo(final String str) {
        final String traceId = getTraceId();
        final String lastActivity = getLastActivity();
        final String fragments2 = getFragments();
        if (!TextUtils.isEmpty(traceId) && !TextUtils.isEmpty(lastActivity) && !isBackground()) {
            final String activityTimeParams = getActivityTimeParams();
            ((IThreadManagerApi) QRoute.api(IThreadManagerApi.class)).execute(new Runnable() { // from class: za3.e
                @Override // java.lang.Runnable
                public final void run() {
                    WinkCrashReportParams.lambda$reportCrashReportInfo$4(str, traceId, lastActivity, fragments2, activityTimeParams);
                }
            }, 128, null, false);
            QLog.e(TAG, 1, "onPeakAppCreated, reportCrashReportInfo, \ntrace_id = " + traceId + "\nlast_activity = " + lastActivity + "\nfragments = " + fragments2);
            return;
        }
        QLog.e(TAG, 1, "reportCrashReportInfo skip");
    }

    private static void saveActivityParams() {
        if (!TextUtils.isEmpty(trace_id)) {
            ((IThreadManagerApi) QRoute.api(IThreadManagerApi.class)).execute(new Runnable() { // from class: za3.d
                @Override // java.lang.Runnable
                public final void run() {
                    WinkCrashReportParams.lambda$saveActivityParams$0();
                }
            }, 16, null, false);
        }
    }

    private static void saveAllParams() {
        ((IThreadManagerApi) QRoute.api(IThreadManagerApi.class)).execute(new Runnable() { // from class: za3.b
            @Override // java.lang.Runnable
            public final void run() {
                WinkCrashReportParams.lambda$saveAllParams$3();
            }
        }, 16, null, false);
    }

    private static void saveBackgroundParams() {
        ((IThreadManagerApi) QRoute.api(IThreadManagerApi.class)).execute(new Runnable() { // from class: za3.c
            @Override // java.lang.Runnable
            public final void run() {
                WinkCrashReportParams.lambda$saveBackgroundParams$2();
            }
        }, 16, null, false);
    }

    private static void saveFragmentParams() {
        if (!TextUtils.isEmpty(trace_id)) {
            ((IThreadManagerApi) QRoute.api(IThreadManagerApi.class)).execute(new Runnable() { // from class: za3.f
                @Override // java.lang.Runnable
                public final void run() {
                    WinkCrashReportParams.lambda$saveFragmentParams$1();
                }
            }, 16, null, false);
        }
    }

    public static void setIsBackground(boolean z16) {
        if (isBackground == z16) {
            return;
        }
        isBackground = z16;
        saveBackgroundParams();
    }
}
