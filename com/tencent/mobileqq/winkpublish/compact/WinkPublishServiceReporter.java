package com.tencent.mobileqq.winkpublish.compact;

import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.IQCircleReportApi;
import com.tencent.mobileqq.qcircle.api.constant.QCirclePublishQualityDataBuilder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import mqq.app.MobileQQ;

/* loaded from: classes21.dex */
public class WinkPublishServiceReporter {
    public static final String KEY_BIND_SERVICE = "key_bind_service";
    public static final String P_PUBLISH_ALL_COST = "P_PUBLISH_ALL_COST";
    public static final int REPORT_BIND_SERVICE_SUCCESS = 2;
    public static final int REPORT_GET_SERVICE = 5;
    public static final int REPORT_SAMPLE_STAMP_INTERVAL = 3600000;
    public static final int REPORT_SERVICE_BIND_END = 11;
    public static final int REPORT_SERVICE_BIND_RESULT_FALSE = 9;
    public static final int REPORT_SERVICE_BIND_START = 10;
    public static final int REPORT_SERVICE_BIND_TIMEOUT = 12;
    public static final int REPORT_SERVICE_DEAD_OBJECT = 8;
    public static final int REPORT_SERVICE_DISCONNECTED = 4;
    public static final int REPORT_SERVICE_NOT_ALIVE = 7;
    public static final int REPORT_SERVICE_NOT_READY = 6;
    public static final int REPORT_TO_BIND_SERVICE = 1;
    public static final String SCENE_WINKPUBLISH_SERVICE = "scene_winkpublish_service";
    public static final String TAG = "WinkPublishServiceReporter";
    public static final String T_CATCH_IMPORTANT_INFO = "T_CATCH_IMPORTANT_INFO";
    private static long lastReadSampleStamp;
    private static boolean needReport;

    public static boolean needReport() {
        try {
        } catch (Exception e16) {
            QLog.w(TAG, 1, "[needReport]", e16);
            needReport = false;
        }
        if (System.currentTimeMillis() - lastReadSampleStamp < 3600000) {
            return needReport;
        }
        String winkPublishServiceSampleId = QzoneConfig.getWinkPublishServiceSampleId();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[needReport] postfix=", winkPublishServiceSampleId);
        }
        String[] split = winkPublishServiceSampleId.split(",");
        String account = ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
        int length = split.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            if (account.endsWith(split[i3])) {
                needReport = true;
                break;
            }
            i3++;
        }
        lastReadSampleStamp = System.currentTimeMillis();
        return needReport;
    }

    public static void reportCost(long j3, int i3) {
        if (!needReport()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[reportOperation] no sampler user, cost=" + j3 + ", businessType=" + i3);
                return;
            }
            return;
        }
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).uploadQualityReport(new QCirclePublishQualityDataBuilder().setKeyEventId(P_PUBLISH_ALL_COST).setExt1(String.valueOf(j3)).setExt2(KEY_BIND_SERVICE).setExt3(String.valueOf(MobileQQ.sProcessId)).setExt4(String.valueOf(i3)));
    }

    public static void reportOperation(int i3, int i16) {
        reportOperation(i3, i16, false);
    }

    public static void reportOperation(int i3, int i16, boolean z16) {
        if (!z16 && !needReport()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[reportOperation] no sampler user, operationType=" + i3 + ", businessType=" + i16);
                return;
            }
            return;
        }
        ((IQCircleReportApi) QRoute.api(IQCircleReportApi.class)).uploadQualityReport(new QCirclePublishQualityDataBuilder().setKeyEventId("T_CATCH_IMPORTANT_INFO").setExt1(SCENE_WINKPUBLISH_SERVICE).setExt2(String.valueOf(i3)).setExt3(String.valueOf(MobileQQ.sProcessId)).setExt4(String.valueOf(i16)));
    }
}
