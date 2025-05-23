package com.tencent.qqmini.sdk.report;

import NS_COMM.COMM;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.utils.AppBrandUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.List;

/* loaded from: classes23.dex */
public class MiniProgramLpReportDC04266 {
    private static final String TAG = "MiniProgramLpReportDC04266";

    MiniProgramLpReportDC04266() {
    }

    static /* synthetic */ int access$000() {
        return getQualityDcId();
    }

    static /* synthetic */ int access$100() {
        return getDcId5332();
    }

    private static int getDcId4266() {
        return 3;
    }

    private static int getDcId5332() {
        return 14;
    }

    private static int getDcId5374() {
        return 13;
    }

    private static int getQualityDcId() {
        if (!QUAUtil.isQQApp() && !QUAUtil.isMicroApp()) {
            return getDcId5374();
        }
        return getDcId4266();
    }

    public static void report(MiniAppInfo miniAppInfo, int i3, String str, String str2, String str3, int i16, String str4, long j3, String str5, long j16, String str6, String str7, String str8, String str9) {
        report(miniAppInfo, i3, str, str2, str3, i16, str4, j3, str5, j16, str6, str7, str8, str9, "");
    }

    public static void reportCostTimeEvent(final MiniAppInfo miniAppInfo, final String str, final String str2, final int i3, final long j3, final long j16, final String str3, final String str4, final String str5, final String str6, final String str7) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04266.2
            @Override // java.lang.Runnable
            public void run() {
                String launchIdForMiniAppConfig = MiniProgramReportHelper.launchIdForMiniAppConfig(MiniAppInfo.this);
                List<COMM.Entry> newAppQualityEntries = MiniProgramReportHelper.newAppQualityEntries(MiniAppInfo.this, null, str, str2, null, String.valueOf(i3), MiniReportManager.getAppType(MiniAppInfo.this), String.valueOf(j3), null, String.valueOf(j16), launchIdForMiniAppConfig, str3, str4, str5, str6, str7);
                if (!QUAUtil.isQQApp()) {
                    newAppQualityEntries.addAll(MiniProgramReportHelper.newThirdSourceEntries());
                }
                MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(MiniProgramLpReportDC04266.access$000(), newAppQualityEntries, null));
                if (MiniReportManager.needReportToDC5332(MiniReportManager.getAppType(MiniAppInfo.this), str, str6)) {
                    MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(MiniProgramLpReportDC04266.access$100(), newAppQualityEntries, null));
                    if (QMLog.isDebugEnabled()) {
                        QMLog.d(MiniProgramLpReportDC04266.TAG, "MiniReportManager  [5332] reportCostTimeEvent: costTime event = [" + str + "], costTime result = [" + i3 + "], appType = [" + MiniReportManager.getAppType(MiniAppInfo.this) + "], timeCost = [" + j3 + "],  attachInfo = [" + str2 + "]  launchId:" + launchIdForMiniAppConfig + "  retCode:" + i3 + "  reserves1:" + str3 + "  reserves2:" + str4 + "  reserves3:" + str5 + "  reserves4:" + str6);
                    }
                }
                if (QMLog.isDebugEnabled()) {
                    if (!TextUtils.isEmpty(str)) {
                        QMLog.d(MiniProgramLpReportDC04266.TAG, "MiniReportManager  reportCostTimeEvent: costTime event = [" + str + "], costTime result = [" + i3 + "], appType = [" + MiniReportManager.getAppType(MiniAppInfo.this) + "], timeCost = [" + j3 + "],  attachInfo = [" + str2 + "]  launchId:" + launchIdForMiniAppConfig + "  retCode:" + i3 + "  reserves1:" + str3 + "  reserves2:" + str4 + "  reserves3:" + str5 + "  reserves4:" + str6);
                        return;
                    }
                    QMLog.e(MiniProgramLpReportDC04266.TAG, "eventName not found!");
                    throw new AssertionError("MiniProgramLpReportDC04266 eventName not found!");
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean shouldFlushReportData(int i3) {
        if (i3 != 20 && i3 != 22 && i3 != 605 && i3 != 1011 && i3 != 1024 && i3 != 1028) {
            return false;
        }
        return true;
    }

    public static void report(final MiniAppInfo miniAppInfo, final int i3, final String str, final String str2, final String str3, final int i16, final String str4, final long j3, final String str5, final long j16, final String str6, final String str7, final String str8, final String str9, final String str10) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04266.1
            @Override // java.lang.Runnable
            public void run() {
                MiniProgramReportHelper.checkShouldAssignPreloadLaunchId(i3);
                if (i3 == 1) {
                    MiniProgramReportHelper.assignAppLaunchId(miniAppInfo);
                    if (miniAppInfo != null) {
                        MiniProgramReporter miniProgramReporter = MiniProgramReporter.getInstance();
                        MiniAppInfo miniAppInfo2 = miniAppInfo;
                        miniProgramReporter.addLaunchMiniAppRecord(miniAppInfo2.appId, MiniProgramReportHelper.launchIdForMiniAppConfig(miniAppInfo2));
                    }
                }
                if (i3 == 611 && miniAppInfo != null) {
                    String launchMiniAppRecord = MiniProgramReporter.getInstance().getLaunchMiniAppRecord(miniAppInfo.appId);
                    String launchIdForMiniAppConfig = MiniProgramReportHelper.launchIdForMiniAppConfig(miniAppInfo);
                    if (launchMiniAppRecord != null && launchMiniAppRecord.equals(launchIdForMiniAppConfig)) {
                        MiniProgramReporter.getInstance().removeLaunchMiniAppRecord(miniAppInfo.appId);
                    }
                }
                String launchIdForMiniAppConfig2 = MiniProgramReportHelper.launchIdForMiniAppConfig(miniAppInfo);
                String eventName = MiniReportManager.getEventName(i3);
                if (QMLog.isDebugEnabled()) {
                    if (!TextUtils.isEmpty(eventName)) {
                        QMLog.d(MiniProgramLpReportDC04266.TAG, "MiniReportManager  reportEventType() called with: eventType = [" + i3 + "]" + eventName + "  retCode:" + i16 + "  attachInfo: " + str2 + "  timestamp: " + j16 + "  launchId: " + launchIdForMiniAppConfig2 + " timecost: " + j3 + " reserves1:" + str6 + " reserves2:" + str7);
                    } else {
                        QMLog.e(MiniProgramLpReportDC04266.TAG, "eventName not found!");
                        throw new AssertionError("MiniProgramLpReportDC04266 eventName not found!");
                    }
                }
                List<COMM.Entry> newAppQualityEntries = MiniProgramReportHelper.newAppQualityEntries(miniAppInfo, AppBrandUtil.getUrlWithoutParams(str), eventName, str2, str3, String.valueOf(i16), str4, String.valueOf(j3), str5, String.valueOf(j16), launchIdForMiniAppConfig2, str6, str7, str8, str9, str10);
                if (!QUAUtil.isQQApp()) {
                    newAppQualityEntries.addAll(MiniProgramReportHelper.newThirdSourceEntries());
                }
                MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(MiniProgramLpReportDC04266.access$000(), newAppQualityEntries, null));
                if (MiniReportManager.needReportToDC5332(str4, eventName, str9)) {
                    MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(MiniProgramLpReportDC04266.access$100(), newAppQualityEntries, null));
                    if (QMLog.isDebugEnabled()) {
                        QMLog.d(MiniProgramLpReportDC04266.TAG, "MiniReportManager  [5332] reportEventType() called with: eventType = [" + i3 + "]" + eventName + "  retCode:" + i16 + "  attachInfo: " + str2 + "  timestamp: " + j16 + "  launchId: " + launchIdForMiniAppConfig2 + " timecost: " + j3);
                    }
                }
                if (MiniProgramLpReportDC04266.shouldFlushReportData(i3)) {
                    MiniProgramReporter.getInstance().flush();
                }
            }
        });
    }
}
