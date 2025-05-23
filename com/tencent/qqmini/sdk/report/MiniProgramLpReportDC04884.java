package com.tencent.qqmini.sdk.report;

import NS_COMM.COMM;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.StorageUtil;
import com.tencent.qqmini.sdk.utils.QUAUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes23.dex */
public class MiniProgramLpReportDC04884 {
    private static final String TAG = "MiniProgramLpReportDC04";

    public static void reportApiReport(final String str, final String str2, final String str3, String str4) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.qqmini.sdk.report.MiniProgramLpReportDC04884.1
            @Override // java.lang.Runnable
            public void run() {
                if (((MiniAppProxy) ProxyManager.get(MiniAppProxy.class)).isDebugVersion()) {
                    QMLog.d(MiniProgramLpReportDC04884.TAG, "reportApiReportcalled with args: " + str2);
                }
                ArrayList arrayList = new ArrayList(Arrays.asList(MiniProgramReportHelper.newEntry("appid", str), MiniProgramReportHelper.newEntry("miniapp_version", str3), MiniProgramReportHelper.newEntry("baselib_version", StorageUtil.getPreference().getString("version", "1.74.3.00001")), MiniProgramReportHelper.newEntry("apiResult", str2)));
                if (!QUAUtil.isQQApp()) {
                    arrayList.addAll(MiniProgramReportHelper.newThirdSourceEntries());
                }
                MiniProgramReporter.getInstance().add(MiniProgramReportHelper.newSingleDcData(9, String.valueOf(6), arrayList, (List<COMM.Entry>) null));
            }
        });
    }
}
