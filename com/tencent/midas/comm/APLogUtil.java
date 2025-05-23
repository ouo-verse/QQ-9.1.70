package com.tencent.midas.comm;

import android.content.Context;
import com.tencent.midas.comm.log.util.APLogDataReporter;
import com.tencent.midas.data.APPluginReportManager;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;

/* loaded from: classes9.dex */
public class APLogUtil {
    private static boolean HAS_INIT_LOG_IN_MAIN_PROCESS = false;
    private static boolean HAS_INIT_LOG_IN_NEW_PROCESS = false;
    public static boolean IS_IN_NEW_PROCESS = false;

    public static void flushIfNewProcess() {
        if (IS_IN_NEW_PROCESS && APLog.getLogInfo() != null && !APLog.getLogInfo().isAutoFlush()) {
            APLog.flush();
        }
    }

    public static void initAPLogIfNewProcess(final Context context, boolean z16, final boolean z17, final String str) {
        if (z16 && !HAS_INIT_LOG_IN_NEW_PROCESS) {
            IS_IN_NEW_PROCESS = true;
            new BaseThread(new Runnable() { // from class: com.tencent.midas.comm.APLogUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        APLogInfo aPLogInfo = new APLogInfo();
                        APLogDataReporter.getInstance().setReporter(new APLogDataReporter.Reporter() { // from class: com.tencent.midas.comm.APLogUtil.1.1
                            @Override // com.tencent.midas.comm.log.util.APLogDataReporter.Reporter
                            public void report(String str2, String str3, String str4) {
                                APPluginReportManager.getInstance().insertData(str2, str3, "", str4);
                            }
                        });
                        aPLogInfo.setContext(context);
                        aPLogInfo.setLogEnable(z17);
                        aPLogInfo.setAutoFlush(true);
                        aPLogInfo.setLogTag("TencentPay");
                        aPLogInfo.setLogCallbackClassName(str);
                        APLog.init(aPLogInfo);
                        boolean unused = APLogUtil.HAS_INIT_LOG_IN_NEW_PROCESS = true;
                    } catch (Throwable th5) {
                        APLog.e("APLogUtil init", th5.toString());
                    }
                }
            }).start();
        }
    }

    public static void initAPLogInPlugin(final Context context, final boolean z16, final String str) {
        if (!HAS_INIT_LOG_IN_MAIN_PROCESS) {
            HAS_INIT_LOG_IN_MAIN_PROCESS = true;
            new BaseThread(new Runnable() { // from class: com.tencent.midas.comm.APLogUtil.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        APLogInfo aPLogInfo = new APLogInfo();
                        APLogDataReporter.getInstance().setReporter(new APLogDataReporter.Reporter() { // from class: com.tencent.midas.comm.APLogUtil.2.1
                            @Override // com.tencent.midas.comm.log.util.APLogDataReporter.Reporter
                            public void report(String str2, String str3, String str4) {
                                APPluginReportManager.getInstance().insertData(str2, str3, "", str4);
                            }
                        });
                        aPLogInfo.setContext(context);
                        aPLogInfo.setLogEnable(z16);
                        aPLogInfo.setAutoFlush(true);
                        aPLogInfo.setLogTag("TencentPay");
                        aPLogInfo.setLogCallbackClassName(str);
                        APLog.init(aPLogInfo);
                    } catch (Throwable th5) {
                        APLog.e("APLogUtil init", th5.toString());
                    }
                }
            }).start();
        }
    }
}
