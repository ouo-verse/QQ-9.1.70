package com.tencent.qqmini.sdk.report;

import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

/* compiled from: P */
/* loaded from: classes23.dex */
public class InnerAppReportDc4239 {
    public static final String ACTION_TYPE = "inner_app";
    public static final String RESERVES2_DOWNLOADAPP = "downloadapp";
    public static final String RESERVES2_DOWNLOAD_FINISH = "downloadappfinish";
    public static final String RESERVES2_DOWNLOAD_PAUSE = "downloadapppause";
    public static final String RESERVES2_INSTALL_APP = "installapp";
    public static final String RESERVES2_OPENAPP = "openapp";
    public static final String RESERVES3_QQ_DOWNLOAD = "qqdownload";
    public static final String RESERVES3_YYB_DOWNLOAD = "yybdownload";
    public static final String RESERVES_ACTION_LAUNCH_APP = "launchapp";
    public static final String SUB_ACTION_TYPE = "from_api";
    private static final String TAG = "InnerAppReportDc4239";

    public static void innerAppReport(final MiniAppInfo miniAppInfo, final String str, final String str2, final String str3, final String str4) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.InnerAppReportDc4239.1
            @Override // java.lang.Runnable
            public void run() {
                MiniAppInfo miniAppInfo2 = MiniAppInfo.this;
                SDKMiniProgramLpReportDC04239.report(miniAppInfo2, SDKMiniProgramLpReportDC04239.getAppType(miniAppInfo2), str, "inner_app", "from_api", str2, str3, str4, null, null, null);
            }
        });
    }
}
