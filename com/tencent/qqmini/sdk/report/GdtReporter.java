package com.tencent.qqmini.sdk.report;

import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

/* compiled from: P */
/* loaded from: classes23.dex */
public class GdtReporter {
    public static final int REPORT_DEEP_LINK_SUCCESS = 137;
    public static final int REPORT_OPEN_MAIN_PAGE = 138;

    public static void doCgiReport(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ThreadManager.executeOnNetworkIOThreadPool(new GdtCgiReportRunnable(str));
        QMLog.i("GDT_CGI_REPORT", str);
    }
}
