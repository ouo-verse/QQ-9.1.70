package com.tencent.open.appstore.report;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.open.base.f;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.replacemonitor.replace.ReplaceMonitor;
import com.tencent.replacemonitor.replace.st.DownloadFinishLog;
import com.tencent.replacemonitor.replace.st.DownloadStartLog;
import com.tencent.replacemonitor.replace.st.InstallFinishLog;
import com.tencent.replacemonitor.replace.st.InstallStartLog;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.io.File;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class AppCenterReporter {
    /* JADX INFO: Access modifiers changed from: private */
    public static String d(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return "";
        }
        return c.f().i(downloadInfo.f341191i).m(downloadInfo.f341189h).s(downloadInfo.I).h(downloadInfo.f341184e).g(downloadInfo.H).q(downloadInfo.f341190h0).j(downloadInfo.f341192i0).r(downloadInfo.f341186f).p(downloadInfo.f341188g0).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return "";
        }
        return c.f().k(downloadInfo.f341181c0).n(downloadInfo.f341193j0).l(downloadInfo.f341194k0).o(downloadInfo.f341195l0).t(downloadInfo.C).c();
    }

    private static String f(String str, String str2, String str3, String str4, String str5) {
        return c.f().k(str5).n(str).l(str2).o(str3).t(str4).c();
    }

    private static MonitorTask g(DownloadInfo downloadInfo) {
        MonitorTask monitorTask = new MonitorTask();
        monitorTask.appName = downloadInfo.f341191i;
        monitorTask.packageName = downloadInfo.f341189h;
        monitorTask.versionCode = downloadInfo.I;
        monitorTask.fileMd5 = downloadInfo.f341185e0;
        try {
            monitorTask.yybApkId = Long.parseLong(downloadInfo.H);
            monitorTask.yybAppId = Long.parseLong(downloadInfo.f341184e);
        } catch (Throwable unused) {
        }
        monitorTask.downloadUrl = downloadInfo.f341186f;
        monitorTask.additionalId = downloadInfo.f341182d;
        monitorTask.filePath = downloadInfo.L;
        monitorTask.traceId = downloadInfo.f341200p0;
        HashMap hashMap = new HashMap();
        monitorTask.externalParams = hashMap;
        hashMap.put("via", downloadInfo.C);
        return monitorTask;
    }

    public static void h(DownloadInfo downloadInfo) {
        MonitorTask task;
        f.e("AppCenterReporter", ">deleteCheck info:" + downloadInfo);
        if (downloadInfo != null && (task = ReplaceMonitor.get().getTask(downloadInfo.f341182d)) != null) {
            ReplaceMonitor.get().deleteTask(task);
        }
    }

    public static void i(DownloadInfo downloadInfo) {
        f.e("AppCenterReporter", ">downloadSuccCheck info:" + downloadInfo);
        if (downloadInfo == null) {
            return;
        }
        MonitorTask task = ReplaceMonitor.get().getTask(downloadInfo.f341182d);
        if (task == null) {
            task = g(downloadInfo);
            ReplaceMonitor.get().addTask(task);
        } else if (TextUtils.isEmpty(task.filePath)) {
            task.filePath = downloadInfo.L;
        }
        f.e("AppCenterReporter", ">downloadSuccCheck task:" + task);
        if (task != null) {
            ReplaceMonitor.get().execSync(task, MonitorStep.DOWNLOADING);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long j(String str) {
        if (com.tencent.mobileqq.cooperation.a.d(str, com.tencent.open.adapter.a.f().e())) {
            try {
                return new File(InstalledAppListMonitor.getPackageInfo(GlobalUtil.getInstance().getContext().getPackageManager(), str, 0).applicationInfo.sourceDir).length();
            } catch (Throwable unused) {
                return 0L;
            }
        }
        f.e("AppCenterReporter", "[getInstalledAppFileSize]" + str + ": NOT INSTALLED!");
        return 0L;
    }

    public static void k(DownloadInfo downloadInfo) {
        f.e("AppCenterReporter", ">installStartCheck ,info:" + downloadInfo);
        if (downloadInfo == null) {
            return;
        }
        MonitorTask task = ReplaceMonitor.get().getTask(downloadInfo.f341182d);
        if (task == null) {
            task = g(downloadInfo);
            ReplaceMonitor.get().addTask(task);
        } else if (TextUtils.isEmpty(task.filePath)) {
            task.filePath = downloadInfo.L;
        }
        f.e("AppCenterReporter", ">installStartCheck task:" + task);
        if (task != null) {
            ReplaceMonitor.get().execSync(task, MonitorStep.BEFORE_INSTALL);
        }
    }

    public static void l(final String str, final boolean z16) {
        f.e("AppCenterReporter", ">notifyInstallFinish " + str + "|" + z16);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.report.AppCenterReporter.6
            @Override // java.lang.Runnable
            public void run() {
                ReplaceMonitor.get().onAppInstalled(str, z16);
            }
        }, 16, null, true);
    }

    public static void m(int i3, String str) {
        f.e("AppCenterReporter", "[report] type=" + i3 + "\ndata=" + str);
        SDKReportManager2.getInstance().postReport(i3, str);
    }

    public static void n(c cVar) {
        String d16 = cVar.d();
        f.e("AppCenterReporter", "[reportExposure] type=3002\ndata=" + d16);
        SDKReportManager2.getInstance().postReport(3002, d16);
    }

    public static void o(c cVar) {
        String d16 = cVar.d();
        f.e("AppCenterReporter", "[reportClick] type=3003\ndata=" + d16);
        SDKReportManager2.getInstance().postReport(3003, d16);
    }

    public static void p(String str, String str2, String str3, String str4, String str5) {
        String str6 = f(str, str2, str3, str4, str5) + "|" + c.f().b() + "|200";
        f.e("AppCenterReporter", "[reportClick] type=3003\ndata=" + str6);
        SDKReportManager2.getInstance().postReport(3003, str6);
    }

    public static void q(final DownloadInfo downloadInfo, final int i3, final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.report.AppCenterReporter.3
            @Override // java.lang.Runnable
            public void run() {
                if (DownloadInfo.this == null) {
                    return;
                }
                DownloadInfo g16 = pp3.a.j().g(DownloadInfo.this.f341182d);
                if (g16 != null) {
                    f.e("AppCenterReporter", ">reportDownloadError " + g16.f341199o0 + "|" + DownloadInfo.this.f341199o0);
                    DownloadInfo.this.f341199o0 = g16.f341199o0;
                }
                String qQProcessName = BaseApplicationImpl.getApplication().getQQProcessName();
                boolean equals = TextUtils.equals(qQProcessName, DownloadInfo.this.f341199o0);
                f.e("AppCenterReporter", ">reportDownloadError " + equals + "|" + qQProcessName + "|" + DownloadInfo.this.f341199o0 + "|");
                if (!equals) {
                    return;
                }
                f.e("AppCenterReporter", "[reportDownloadError] errorCode=" + i3 + ",errorMsg=" + str);
                AppCenterReporter.m(3006, AppCenterReporter.e(DownloadInfo.this) + "|" + AppCenterReporter.d(DownloadInfo.this) + "|" + i3 + "|" + str);
            }
        }, 16, null, true);
    }

    public static void r(final DownloadInfo downloadInfo) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.report.AppCenterReporter.1
            @Override // java.lang.Runnable
            public void run() {
                f.e("AppCenterReporter", "[reportDownloadStart]");
                AppCenterReporter.m(3004, AppCenterReporter.e(DownloadInfo.this) + "|" + AppCenterReporter.d(DownloadInfo.this));
                AppCenterReporter.w(DownloadInfo.this);
                DownloadStartLog downloadStartLog = new DownloadStartLog();
                DownloadInfo downloadInfo2 = DownloadInfo.this;
                downloadStartLog.packageName = downloadInfo2.f341189h;
                downloadStartLog.versionCode = downloadInfo2.I;
                downloadStartLog.downloadUrl = downloadInfo2.f341186f;
                try {
                    downloadStartLog.yybAppId = Long.parseLong(downloadInfo2.f341184e);
                    downloadStartLog.yybApkId = Long.parseLong(DownloadInfo.this.H);
                } catch (Throwable unused) {
                }
                downloadStartLog.traceId = DownloadInfo.this.f341200p0;
                downloadStartLog.downloadStartTime = System.currentTimeMillis();
                HashMap hashMap = new HashMap();
                downloadStartLog.externalParams = hashMap;
                hashMap.put("via", DownloadInfo.this.C);
                downloadStartLog.doReport();
            }
        }, 16, null, true);
    }

    public static void s(final DownloadInfo downloadInfo) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.report.AppCenterReporter.2
            @Override // java.lang.Runnable
            public void run() {
                if (DownloadInfo.this == null) {
                    return;
                }
                DownloadInfo g16 = pp3.a.j().g(DownloadInfo.this.f341182d);
                if (g16 != null) {
                    f.e("AppCenterReporter", ">reportDownloadSucc " + g16.f341199o0 + "|" + DownloadInfo.this.f341199o0);
                    DownloadInfo.this.f341199o0 = g16.f341199o0;
                }
                String qQProcessName = BaseApplicationImpl.getApplication().getQQProcessName();
                boolean equals = TextUtils.equals(qQProcessName, DownloadInfo.this.f341199o0);
                f.e("AppCenterReporter", ">reportDownloadSucc " + equals + "|" + qQProcessName + "|" + DownloadInfo.this.f341199o0 + "|");
                if (!equals) {
                    return;
                }
                f.e("AppCenterReporter", "[reportDownloadSucc]");
                AppCenterReporter.m(3005, AppCenterReporter.e(DownloadInfo.this) + "|" + AppCenterReporter.d(DownloadInfo.this) + "|" + new File(DownloadInfo.this.L).length());
                DownloadFinishLog downloadFinishLog = new DownloadFinishLog();
                DownloadInfo downloadInfo2 = DownloadInfo.this;
                downloadFinishLog.packageName = downloadInfo2.f341189h;
                downloadFinishLog.versionCode = downloadInfo2.I;
                downloadFinishLog.downloadUrl = downloadInfo2.f341186f;
                try {
                    downloadFinishLog.yybAppId = Long.parseLong(downloadInfo2.f341184e);
                    downloadFinishLog.yybApkId = Long.parseLong(DownloadInfo.this.H);
                } catch (Throwable unused) {
                }
                downloadFinishLog.traceId = DownloadInfo.this.f341200p0;
                downloadFinishLog.downloadFinishTime = System.currentTimeMillis();
                HashMap hashMap = new HashMap();
                downloadFinishLog.externalParams = hashMap;
                hashMap.put("via", DownloadInfo.this.C);
                downloadFinishLog.doReport();
            }
        }, 16, null, true);
    }

    public static void t(final DownloadInfo downloadInfo, final int i3) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.report.AppCenterReporter.5
            @Override // java.lang.Runnable
            public void run() {
                if (DownloadInfo.this == null) {
                    return;
                }
                DownloadInfo g16 = pp3.a.j().g(DownloadInfo.this.f341182d);
                if (g16 != null) {
                    f.e("AppCenterReporter", ">reportInstallComplete " + g16.f341199o0 + "|" + DownloadInfo.this.f341199o0);
                    DownloadInfo.this.f341199o0 = g16.f341199o0;
                }
                String qQProcessName = BaseApplicationImpl.getApplication().getQQProcessName();
                boolean equals = TextUtils.equals(qQProcessName, DownloadInfo.this.f341199o0);
                f.e("AppCenterReporter", ">reportInstallComplete " + equals + "|" + qQProcessName + "|" + DownloadInfo.this.f341199o0 + "|");
                if (!equals) {
                    return;
                }
                f.e("AppCenterReporter", "[reportInstallComplete]");
                AppCenterReporter.m(3008, AppCenterReporter.e(DownloadInfo.this) + "|" + AppCenterReporter.d(DownloadInfo.this) + "|" + i3 + "|" + AppCenterReporter.j(DownloadInfo.this.f341189h));
                InstallFinishLog installFinishLog = new InstallFinishLog();
                DownloadInfo downloadInfo2 = DownloadInfo.this;
                installFinishLog.packageName = downloadInfo2.f341189h;
                installFinishLog.versionCode = downloadInfo2.I;
                installFinishLog.downloadUrl = downloadInfo2.f341186f;
                try {
                    installFinishLog.yybAppId = Long.parseLong(downloadInfo2.f341184e);
                    installFinishLog.yybApkId = Long.parseLong(DownloadInfo.this.H);
                } catch (Throwable unused) {
                }
                installFinishLog.traceId = DownloadInfo.this.f341200p0;
                installFinishLog.installEndTime = System.currentTimeMillis();
                HashMap hashMap = new HashMap();
                installFinishLog.externalParams = hashMap;
                hashMap.put("via", DownloadInfo.this.C);
                installFinishLog.doReport();
            }
        }, 16, null, true);
    }

    public static void u(final DownloadInfo downloadInfo) {
        k(downloadInfo);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.open.appstore.report.AppCenterReporter.4
            @Override // java.lang.Runnable
            public void run() {
                if (DownloadInfo.this == null) {
                    return;
                }
                DownloadInfo g16 = pp3.a.j().g(DownloadInfo.this.f341182d);
                if (g16 != null) {
                    f.e("AppCenterReporter", ">reportInstallStart " + g16.f341199o0 + "|" + DownloadInfo.this.f341199o0);
                    DownloadInfo.this.f341199o0 = g16.f341199o0;
                }
                String qQProcessName = BaseApplicationImpl.getApplication().getQQProcessName();
                boolean equals = TextUtils.equals(qQProcessName, DownloadInfo.this.f341199o0);
                f.e("AppCenterReporter", ">reportInstallStart " + equals + "|" + qQProcessName + "|" + DownloadInfo.this.f341199o0 + "|");
                if (!equals) {
                    return;
                }
                f.e("AppCenterReporter", "[reportInstallStart]");
                AppCenterReporter.m(3007, AppCenterReporter.e(DownloadInfo.this) + "|" + AppCenterReporter.d(DownloadInfo.this) + "|" + new File(DownloadInfo.this.L).length());
                InstallStartLog installStartLog = new InstallStartLog();
                DownloadInfo downloadInfo2 = DownloadInfo.this;
                installStartLog.packageName = downloadInfo2.f341189h;
                installStartLog.versionCode = downloadInfo2.I;
                installStartLog.downloadUrl = downloadInfo2.f341186f;
                try {
                    installStartLog.yybAppId = Long.parseLong(downloadInfo2.f341184e);
                    installStartLog.yybApkId = Long.parseLong(DownloadInfo.this.H);
                } catch (Throwable unused) {
                }
                installStartLog.traceId = DownloadInfo.this.f341200p0;
                installStartLog.installStartTime = System.currentTimeMillis();
                HashMap hashMap = new HashMap();
                installStartLog.externalParams = hashMap;
                hashMap.put("via", DownloadInfo.this.C);
                installStartLog.doReport();
            }
        }, 16, null, true);
    }

    public static void v(String str, String str2, String str3, String str4, String str5) {
        String f16 = f(str, str2, str3, str4, str5);
        f.e("AppCenterReporter", "[reportNormalExposure] type=3001\ndata=" + f16);
        SDKReportManager2.getInstance().postReport(3001, f16);
    }

    public static void w(DownloadInfo downloadInfo) {
        f.e("AppCenterReporter", ">tryInitMonitorTask info:" + downloadInfo);
        if (downloadInfo == null) {
            return;
        }
        MonitorTask task = ReplaceMonitor.get().getTask(downloadInfo.f341182d);
        f.e("AppCenterReporter", ">tryInitMonitorTask info=" + downloadInfo);
        if (task == null) {
            task = g(downloadInfo);
        } else {
            if (TextUtils.isEmpty(task.filePath)) {
                task.filePath = downloadInfo.L;
            }
            f.e("AppCenterReporter", ">tryInitMonitorTask \u5df2\u6709task2:" + task);
        }
        ReplaceMonitor.get().addTask(task);
    }
}
