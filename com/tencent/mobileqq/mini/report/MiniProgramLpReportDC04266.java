package com.tencent.mobileqq.mini.report;

import NS_COMM.COMM;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* loaded from: classes33.dex */
public class MiniProgramLpReportDC04266 {
    private static final String TAG = "MiniProgramLpReportDC04266";
    private static final boolean VERBOSE = false;

    MiniProgramLpReportDC04266() {
    }

    static /* bridge */ /* synthetic */ int a() {
        return getDcId4266();
    }

    static /* bridge */ /* synthetic */ int b() {
        return getDcId5332();
    }

    private static int getDcId4266() {
        return 3;
    }

    private static int getDcId5332() {
        return 14;
    }

    public static void reportCostTimeEvent(final MiniAppConfig miniAppConfig, final String str, final String str2, final String str3, final int i3, final long j3, final long j16, final String str4, final String str5, final String str6, final String str7) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04266.2
            @Override // java.lang.Runnable
            public void run() {
                String launchIdForMiniAppConfig = MiniProgramReportHelper.launchIdForMiniAppConfig(MiniAppConfig.this);
                List<COMM.Entry> newAppQualityEntries = MiniProgramReportHelper.newAppQualityEntries(MiniAppConfig.this, AppBrandUtil.getUrlWithoutParams(str2), str, str3, null, String.valueOf(i3), MiniReportManager.getAppType(MiniAppConfig.this), String.valueOf(j3), null, String.valueOf(j16), launchIdForMiniAppConfig, str4, str5, str6, str7);
                MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(MiniProgramLpReportDC04266.a(), newAppQualityEntries, null));
                if (MiniReportManager.needReportToDC5332(MiniReportManager.getAppType(MiniAppConfig.this), str, str7)) {
                    MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(MiniProgramLpReportDC04266.b(), newAppQualityEntries, null));
                }
                QLog.d(MiniProgramLpReportDC04266.TAG, 2, "MiniReportManager  reportCostTimeEvent: costTime event = [" + str + "], costTime result = [" + i3 + "], appType = [" + MiniReportManager.getAppType(MiniAppConfig.this) + "], timeCost = [" + j3 + "],  attachInfo = [" + str3 + "]  launchId:" + launchIdForMiniAppConfig + "  retCode:" + i3 + "  reserves1:" + str4 + "  reserves2:" + str5 + "  reserves3:" + str6 + "  reserves4:" + str7);
                MiniProgramLpReportDC05115.reDispatchReportEvent(MiniAppConfig.this, str, String.valueOf(i3), j3, str7);
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

    public static void report(final MiniAppConfig miniAppConfig, final int i3, final String str, final String str2, final String str3, final int i16, final String str4, final long j3, final String str5, final long j16, final String str6, final String str7, final String str8, final String str9) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04266.1
            @Override // java.lang.Runnable
            public void run() {
                MiniAppConfig miniAppConfig2;
                MiniProgramReportHelper.checkShouldAssignPreloadLaunchId(i3);
                if (i3 == 1) {
                    MiniProgramReportHelper.assignAppLaunchId(miniAppConfig);
                    MiniAppConfig miniAppConfig3 = miniAppConfig;
                    if (miniAppConfig3 != null && miniAppConfig3.config != null) {
                        MiniProgramReporter miniProgramReporter = MiniProgramReporter.getInstance();
                        MiniAppConfig miniAppConfig4 = miniAppConfig;
                        miniProgramReporter.addLaunchMiniAppRecord(miniAppConfig4.config.appId, MiniProgramReportHelper.launchIdForMiniAppConfig(miniAppConfig4));
                    }
                }
                if (i3 == 611 && (miniAppConfig2 = miniAppConfig) != null && miniAppConfig2.config != null) {
                    String launchMiniAppRecord = MiniProgramReporter.getInstance().getLaunchMiniAppRecord(miniAppConfig.config.appId);
                    String launchIdForMiniAppConfig = MiniProgramReportHelper.launchIdForMiniAppConfig(miniAppConfig);
                    if (launchMiniAppRecord != null && launchMiniAppRecord.equals(launchIdForMiniAppConfig)) {
                        MiniProgramReporter.getInstance().removeLaunchMiniAppRecord(miniAppConfig.config.appId);
                    }
                }
                String launchIdForMiniAppConfig2 = MiniProgramReportHelper.launchIdForMiniAppConfig(miniAppConfig);
                String eventName = MiniReportManager.getEventName(i3);
                List<COMM.Entry> newAppQualityEntries = MiniProgramReportHelper.newAppQualityEntries(miniAppConfig, AppBrandUtil.getUrlWithoutParams(str), eventName, str2, str3, String.valueOf(i16), str4, String.valueOf(j3), str5, String.valueOf(j16), launchIdForMiniAppConfig2, str6, str7, str8, str9);
                if (MiniReportManager.needReportToDC4266(eventName)) {
                    MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(MiniProgramLpReportDC04266.a(), newAppQualityEntries, null));
                }
                if (MiniReportManager.needReportToDC5332(str4, eventName, str9)) {
                    MiniProgramReporter.getInstance().addData(MiniProgramReportHelper.newSingleReportData(MiniProgramLpReportDC04266.b(), newAppQualityEntries, null));
                }
                MiniProgramLpReportDC05115.reDispatchReportEvent(miniAppConfig, eventName, String.valueOf(i16), j3, str9);
                if (MiniProgramLpReportDC04266.shouldFlushReportData(i3)) {
                    MiniProgramReporter.getInstance().flush();
                }
            }
        });
    }
}
