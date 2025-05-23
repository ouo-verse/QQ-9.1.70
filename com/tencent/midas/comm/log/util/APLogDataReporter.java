package com.tencent.midas.comm.log.util;

import android.util.Log;
import com.tencent.midas.comm.APLogInfo;
import com.tencent.midas.data.APMidasPluginInfo;

/* loaded from: classes9.dex */
public class APLogDataReporter {
    public static final String MIDAS_LOG_ERROR_APPEND = "sdk.log.error.append";
    public static final String MIDAS_LOG_ERROR_CLOSE = "sdk.log.error.close";
    public static final String MIDAS_LOG_ERROR_FLUSH = "sdk.log.error.flush";
    public static final String MIDAS_LOG_ERROR_INIT = "sdk.log.error.init";
    public static final String MIDAS_LOG_ERROR_MMAP_OPEN = "sdk.log.error.mmap.open";
    public static final String MIDAS_LOG_ERROR_PRINT = "sdk.log.error.print";
    public static final String MIDAS_LOG_ERROR_PROCESS = "sdk.log.error.process";
    public static final String MIDAS_LOG_ERROR_WRITE = "sdk.log.error.write";
    public static final String MIDAS_LOG_INIT = "sdk.log.init";
    private Reporter reporter;

    /* loaded from: classes9.dex */
    private static class Holder {
        private static final APLogDataReporter INSTANCE = new APLogDataReporter();

        Holder() {
        }
    }

    /* loaded from: classes9.dex */
    public interface Reporter {
        void report(String str, String str2, String str3);
    }

    public static APLogDataReporter getInstance() {
        return Holder.INSTANCE;
    }

    public Reporter getReporter() {
        return this.reporter;
    }

    public void report(String str, String str2) {
        report(APMidasPluginInfo.LAUNCH_INTERFACE_LAUNCHPAY, str, str2);
    }

    public void reportTimeEx(String str, long j3) {
        report(str, String.valueOf(System.currentTimeMillis() - j3));
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    APLogDataReporter() {
    }

    public void report(String str, String str2, String str3) {
        try {
            Reporter reporter = this.reporter;
            if (reporter != null) {
                reporter.report(str, str2, str3);
            }
        } catch (Throwable th5) {
            Log.e(APLogInfo.LOG_TAG, "report error: " + th5.getMessage());
            th5.printStackTrace();
        }
    }
}
