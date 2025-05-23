package com.tencent.mobileqq.mini.report;

import NS_COMM.COMM;
import com.tencent.mobileqq.mini.util.StorageUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes33.dex */
public class MiniProgramLpReportDC04884 {
    private static final String TAG = "MiniProgramLpReportDC04";

    public static void reportApiReport(final String str, final String str2, final String str3, String str4) {
        MiniProgramReporter.getInstance().getReportHandler().post(new Runnable() { // from class: com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04884.1
            @Override // java.lang.Runnable
            public void run() {
                MiniProgramReporter.getInstance().add(MiniProgramReportHelper.newSingleDcData(9, String.valueOf(6), new ArrayList(Arrays.asList(MiniProgramReportHelper.newEntry("appid", str), MiniProgramReportHelper.newEntry("miniapp_version", str3), MiniProgramReportHelper.newEntry("baselib_version", StorageUtil.getPreference().getString("version", "1.74.3.00001")), MiniProgramReportHelper.newEntry("apiResult", str2))), (List<COMM.Entry>) null));
            }
        });
    }
}
