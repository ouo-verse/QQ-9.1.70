package com.tencent.qqperf.monitor.crash;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.biz.richframework.network.cache.CacheHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.feedback.eup.CrashHandleListener;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.cf;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.msf.sdk.MsfConstants;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.WebpSoLoader;
import com.tencent.mobileqq.util.ak;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import com.tencent.qzonehub.api.IQZonePageApi;
import com.tencent.tmdownloader.TMAssistantDownloadManager;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class QQCrashHandleListener implements CrashHandleListener, f {

    /* renamed from: a, reason: collision with root package name */
    private List<d> f363142a = new ArrayList();

    public QQCrashHandleListener() {
        d();
        c();
    }

    private void a(final String str) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqperf.monitor.crash.QQCrashHandleListener.1
            @Override // java.lang.Runnable
            public void run() {
                WebpSoLoader.a(str);
                ak.a(str);
                ((IQCircleRFWApi) QRoute.api(IQCircleRFWApi.class)).checkExceptionWhetherCauseByQCircle(str);
                ((IQZonePageApi) QRoute.api(IQZonePageApi.class)).checkExceptionWhetherCauseByFeedx(str);
            }
        }, 192, null, false);
    }

    @Nullable
    private d b(boolean z16, String str, String str2, String str3, int i3) {
        for (d dVar : this.f363142a) {
            if (dVar.a(z16, str, str2, str3, i3)) {
                return dVar;
            }
        }
        return null;
    }

    private void c() {
        b bVar = new b();
        bVar.i();
        com.tencent.qqperf.monitor.crash.catchedexception.a.g(bVar);
    }

    private void d() {
        this.f363142a.add(new a());
        this.f363142a.add(new c());
    }

    private void e(Context context, String str) {
        QLog.d("QQCrashReportManager", 1, "stopServiceOnCrash");
        if (!TextUtils.isEmpty(str) && context != null) {
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningServices(200);
            if (runningServices != null && runningServices.size() > 0) {
                for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                    if (str.equals(runningServiceInfo.process)) {
                        Intent intent = new Intent();
                        intent.setComponent(runningServiceInfo.service);
                        QLog.d("QQCrashReportManager", 1, "Stop service: " + runningServiceInfo.service + ", clientCount: " + runningServiceInfo.clientCount + ", clientPackage: " + runningServiceInfo.clientPackage + ", crashCount: " + runningServiceInfo.crashCount);
                        context.stopService(intent);
                    }
                }
                return;
            }
            QLog.d("QQCrashReportManager", 1, "stopServiceOnCrash,list == null");
            return;
        }
        QLog.d("QQCrashReportManager", 1, "stopServiceOnCrash,context == null");
    }

    @Override // com.tencent.feedback.eup.CrashHandleListener
    public byte[] getCrashExtraData(boolean z16, String str, String str2, String str3, int i3, long j3) {
        g.c().f(z16, str, j3);
        return null;
    }

    @Override // com.tencent.feedback.eup.CrashHandleListener
    public String getCrashExtraMessage(final boolean z16, final String str, final String str2, final String str3, final int i3, final long j3) {
        boolean z17;
        ThreadExcutor.IThreadListener iThreadListener;
        final StringBuilder sb5;
        final BaseApplication context = BaseApplication.getContext();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqperf.monitor.crash.QQCrashHandleListener.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.e("QQCrashReportManager", 1, "getCrashExtraMessage isNativeCrashed=" + z16 + ", crashType=" + str + ", crashAddress=" + str2 + ", crashStack=" + str3 + ", native_SICODE=" + i3 + ", crashTime=" + ly3.a.f415787b.format(new Date(j3)));
                QLog.flushLog();
            }
        }, 64, null, false);
        QQCrashReportManager.f363165i = str;
        QQCrashReportManager.f363166j = str3;
        g.c().h(z16, str, j3);
        if (MobileQQ.sProcessId == 1) {
            com.tencent.qqperf.monitor.crash.tools.e.e(context, str, str3, j3);
        }
        StringBuilder sb6 = new StringBuilder();
        final d b16 = b(z16, str, str2, str3, i3);
        final String str4 = MobileQQ.processName;
        if (b16 != null) {
            z17 = false;
            iThreadListener = null;
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqperf.monitor.crash.QQCrashHandleListener.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        b16.b(context, z16, str, str2, str3, i3, j3, str4);
                    } catch (Throwable th5) {
                        QLog.e("QQCrashReportManager", 1, "doOnCrash has excetion!", th5);
                    }
                }
            }, 192, null, false);
            sb5 = sb6;
            sb5.append(b16.c(context, z16, str, str2, str3, i3, j3, str4));
        } else {
            z17 = false;
            iThreadListener = null;
            sb5 = sb6;
            sb5.append("Can not find CrashHandleProcessor");
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqperf.monitor.crash.QQCrashHandleListener.4
            @Override // java.lang.Runnable
            public void run() {
                QLog.e("QQCrashReportManager", 1, "getCrashExtraMsg: " + sb5.toString());
                QLog.flushLog();
            }
        }, 64, iThreadListener, z17);
        g.c().g(z16, str, j3);
        return sb5.toString();
    }

    @Override // com.tencent.qqperf.monitor.crash.f
    public void initCrashReport(String str, QQCrashReportManager qQCrashReportManager) {
        BaseApplication context = BaseApplication.getContext();
        CrashReport.putUserData(context, "PatchInstallStatus", String.valueOf(com.tencent.mobileqq.rfix.a.i()));
        if (!TextUtils.isEmpty(com.tencent.mobileqq.rfix.a.d(MobileQQ.processName))) {
            CrashReport.putUserData(context, "PatchNameInstalled", com.tencent.mobileqq.rfix.a.d(MobileQQ.processName));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x029c A[Catch: all -> 0x02c8, TryCatch #1 {all -> 0x02c8, blocks: (B:73:0x0204, B:75:0x020c, B:77:0x0216, B:79:0x023a, B:81:0x0240, B:82:0x0244, B:84:0x024a, B:87:0x0254, B:90:0x025a, B:93:0x0260, B:100:0x0269, B:101:0x0293, B:103:0x029c, B:105:0x02a2, B:107:0x02ab, B:109:0x02b4, B:111:0x02bf), top: B:72:0x0204 }] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01ad A[Catch: all -> 0x01fd, TryCatch #4 {all -> 0x01fd, blocks: (B:48:0x014c, B:50:0x016e, B:52:0x0174, B:53:0x0178, B:55:0x017e, B:58:0x0188, B:61:0x018e, B:64:0x0194, B:71:0x0198, B:119:0x01ad, B:121:0x01b4, B:122:0x01c2, B:124:0x01c8, B:127:0x01e7, B:131:0x01f0, B:133:0x01f9), top: B:44:0x0141 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x008e A[Catch: all -> 0x012c, TryCatch #2 {all -> 0x012c, blocks: (B:21:0x0086, B:23:0x008e, B:24:0x009c, B:27:0x00a8, B:29:0x00ae, B:31:0x00c2, B:33:0x00c8, B:35:0x00ce, B:37:0x00d4, B:39:0x00da, B:138:0x00e3, B:140:0x00e9, B:148:0x00b4), top: B:20:0x0086 }] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0143 A[Catch: all -> 0x01ff, TRY_LEAVE, TryCatch #6 {all -> 0x01ff, blocks: (B:43:0x0134, B:46:0x0143), top: B:42:0x0134 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x020c A[Catch: all -> 0x02c8, TryCatch #1 {all -> 0x02c8, blocks: (B:73:0x0204, B:75:0x020c, B:77:0x0216, B:79:0x023a, B:81:0x0240, B:82:0x0244, B:84:0x024a, B:87:0x0254, B:90:0x025a, B:93:0x0260, B:100:0x0269, B:101:0x0293, B:103:0x029c, B:105:0x02a2, B:107:0x02ab, B:109:0x02b4, B:111:0x02bf), top: B:72:0x0204 }] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    @Override // com.tencent.feedback.eup.CrashHandleListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onCrashHandleEnd(boolean z16) {
        BaseApplication baseApplication;
        ?? r65;
        BaseApplication baseApplication2;
        String str = QZoneHelper.Constants.KEY_SP_QZONE_ISFOREGROUND;
        QLog.d("QQCrashReportManager", 1, "onCrashHandleEnd isNativeCrashed=" + z16 + ", sIsFinalizeTimeoutException=" + QQCrashReportManager.f363162f);
        if (QQCrashReportManager.f363162f) {
            QQCrashReportManager.f363162f = false;
            return true;
        }
        BaseApplication context = BaseApplication.getContext();
        if (z16) {
            context.getSharedPreferences("QQCrashReportManager", 4).edit().putBoolean("KEY_IS_NATIVE_CRASH_HAPPENED", true).commit();
        }
        if (!z16 && SafeModeUtil.b(QQCrashReportManager.f363165i, QQCrashReportManager.f363166j)) {
            QQCrashReportManager.f363164h = true;
            return true;
        }
        String str2 = MobileQQ.processName;
        try {
            CacheHelper.fileCache().clear();
            BaseApplicationImpl.getApplication().closeAllActivities();
            try {
                e(context, str2);
            } catch (Throwable th5) {
                th = th5;
                th.printStackTrace();
                if (str2.equals(MobileQQ.PACKAGE_NAME)) {
                }
                if (!str2.endsWith(":qzone")) {
                }
                QQCrashControlManager.b().c();
                QQCrashControlManager.b().h(str2);
                if (!str2.endsWith(":qzone")) {
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("qzone crash | crash time:");
                baseApplication = context;
                try {
                    sb5.append(System.currentTimeMillis() / 1000);
                    QLog.d("QQCrashReportManager", 1, sb5.toString());
                    LocalMultiProcConfig.putLong("key_sp_qzone_crash_time_" + QQCrashReportManager.f363157a, System.currentTimeMillis() / 1000);
                    LocalMultiProcConfig.putBool(QZoneHelper.Constants.KEY_SP_QZONE_ISFOREGROUND, false);
                    r65 = str;
                } catch (Throwable unused) {
                    r65 = 1;
                    QLog.d("QQCrashReportManager", 1, "init and update crashcontrol exception happen.");
                    BaseApplicationImpl.getApplication().crashed();
                    if (str2.equals(MobileQQ.PACKAGE_NAME)) {
                    }
                    if (str2.equals(MobileQQ.PACKAGE_NAME)) {
                    }
                }
                BaseApplicationImpl.getApplication().crashed();
                if (str2.equals(MobileQQ.PACKAGE_NAME)) {
                }
                if (str2.equals(MobileQQ.PACKAGE_NAME)) {
                }
            }
        } catch (Throwable th6) {
            th = th6;
        }
        try {
            if (str2.equals(MobileQQ.PACKAGE_NAME)) {
                QQCrashControlManager.b().c();
                QQCrashControlManager.b().g();
            }
            if (!str2.endsWith(":qzone") || str2.endsWith(":tool") || str2.endsWith(":peak")) {
                QQCrashControlManager.b().c();
                QQCrashControlManager.b().h(str2);
            }
            if ((!str2.endsWith(":qzone") || str2.endsWith(":tool") || str2.endsWith(":peak") || str2.endsWith(":qzonevideo") || str2.endsWith(":picture")) && LocalMultiProcConfig.getBool(QZoneHelper.Constants.KEY_SP_QZONE_ISFOREGROUND, false)) {
                StringBuilder sb52 = new StringBuilder();
                sb52.append("qzone crash | crash time:");
                baseApplication = context;
                sb52.append(System.currentTimeMillis() / 1000);
                QLog.d("QQCrashReportManager", 1, sb52.toString());
                LocalMultiProcConfig.putLong("key_sp_qzone_crash_time_" + QQCrashReportManager.f363157a, System.currentTimeMillis() / 1000);
                LocalMultiProcConfig.putBool(QZoneHelper.Constants.KEY_SP_QZONE_ISFOREGROUND, false);
                r65 = str;
            } else {
                baseApplication = context;
                r65 = str;
            }
        } catch (Throwable unused2) {
            baseApplication = context;
        }
        try {
            BaseApplicationImpl.getApplication().crashed();
        } catch (Throwable th7) {
            th = th7;
            r65 = baseApplication;
        }
        try {
        } catch (Throwable th8) {
            th = th8;
            th.printStackTrace();
            baseApplication2 = r65;
            if (str2.equals(MobileQQ.PACKAGE_NAME)) {
            }
        }
        try {
            if (str2.equals(MobileQQ.PACKAGE_NAME)) {
                Intent intent = new Intent("com.tencent.process.exit");
                BaseApplication baseApplication3 = baseApplication;
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses((ActivityManager) baseApplication3.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
                ArrayList<String> arrayList = new ArrayList<>();
                String str3 = MobileQQ.PACKAGE_NAME + ":";
                if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (it.hasNext()) {
                        String str4 = it.next().processName;
                        if (str4 != null && str4.startsWith(str3) && !str4.endsWith(":MSF")) {
                            arrayList.add(str4);
                        }
                    }
                }
                intent.putStringArrayListExtra("procNameList", arrayList);
                intent.putExtra("verify", BaseApplicationImpl.getLocalVerify(arrayList, false));
                baseApplication3.sendBroadcast(intent);
                baseApplication2 = baseApplication3;
            } else {
                BaseApplication baseApplication4 = baseApplication;
                if (str2.endsWith(":qzone")) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it5 = SystemMethodProxy.getRunningAppProcesses((ActivityManager) baseApplication4.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).iterator();
                    while (true) {
                        baseApplication2 = baseApplication4;
                        if (it5.hasNext()) {
                            ActivityManager.RunningAppProcessInfo next = it5.next();
                            if (next.processName.equals(MobileQQ.PACKAGE_NAME + ":qzonevideo")) {
                                QLog.flushLog();
                                SystemMethodProxy.killProcess(next.pid);
                            }
                        }
                    }
                    if (str2.equals(MobileQQ.PACKAGE_NAME)) {
                        if (QQCrashControlManager.b().f()) {
                            QLog.d("QQCrashReportManager", 1, "onCrashHandleEnd shouldStopMsf= true, kill package processes.");
                            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses2 = SystemMethodProxy.getRunningAppProcesses((ActivityManager) baseApplication2.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
                            String str5 = MobileQQ.PACKAGE_NAME + ":";
                            if (runningAppProcesses2 != null && runningAppProcesses2.size() > 0) {
                                for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses2) {
                                    String str6 = runningAppProcessInfo.processName;
                                    if (str6 != null && str6.startsWith(str5) && !str6.endsWith(":MSF")) {
                                        QLog.flushLog();
                                        SystemMethodProxy.killProcess(runningAppProcessInfo.pid);
                                    }
                                }
                            }
                            SharedPreferences a16 = e.a(baseApplication2, "crashcontrol", 0);
                            a16.edit().putInt("countTryKillMsf", a16.getInt("countTryKillMsf", 0) + 1).commit();
                            BaseApplicationImpl.getApplication().stopMsfOnCrash(true);
                            QLog.flushLog();
                            SystemMethodProxy.killProcess(Process.myPid());
                        }
                        BaseApplicationImpl.getApplication().qqProcessExit(true);
                        return true;
                    }
                    if ((!str2.endsWith(":qzone") && !str2.endsWith(":buscard") && !str2.endsWith(MsfConstants.PROCESS_VIDEO) && !str2.contains(":mini")) || z16) {
                        BaseApplicationImpl.getApplication().otherProcessExit(false);
                        return true;
                    }
                    return true;
                }
                baseApplication2 = baseApplication4;
                if (str2.endsWith(":TMAssistantDownloadSDKService")) {
                    TMAssistantDownloadManager.closeAllService(baseApplication4);
                    baseApplication2 = baseApplication4;
                }
            }
            if (str2.equals(MobileQQ.PACKAGE_NAME)) {
            }
        } catch (Throwable th9) {
            th9.printStackTrace();
            return true;
        }
    }

    @Override // com.tencent.feedback.eup.CrashHandleListener
    public void onCrashHandleStart(boolean z16) {
        QLog.d("QQCrashReportManager", 1, "onCrashHandleStart isNativeCrashed=" + z16 + ", sHasCrashed=" + QQCrashReportManager.f363161e + ", sIsFinalizeTimeoutException=" + QQCrashReportManager.f363162f);
        if (QQCrashReportManager.f363161e && !QQCrashReportManager.f363162f && !SafeModeUtil.b(QQCrashReportManager.f363165i, QQCrashReportManager.f363166j)) {
            SystemMethodProxy.killProcess(Process.myPid());
        } else {
            QQCrashReportManager.f363161e = true;
        }
        SharedPreferencesProxyManager.getInstance().onCrashStart();
        try {
            StringBuilder sb5 = new StringBuilder(128);
            sb5.append("topActivity:" + cf.a());
            sb5.append("\n");
            sb5.append("ActivityInfoStack:size=");
            sb5.append(com.tencent.qqperf.monitor.crash.tools.b.c());
            sb5.append(",top five were:\u2193\n--->");
            sb5.append(com.tencent.qqperf.monitor.crash.tools.b.b());
            sb5.append("\n");
            sb5.append("Current mapEvent content is:\n");
            sb5.append(com.tencent.qqperf.monitor.crash.tools.b.d());
            com.tencent.qqperf.monitor.crash.tools.b.a();
            QQCrashReportManager.f363168l = sb5.toString();
            StringBuilder sb6 = QQCrashReportManager.f363170n;
            sb6.append("Current thread Id=");
            sb6.append(Process.myTid());
            sb6.append(", Name=");
            sb6.append(Thread.currentThread().getName());
            sb6.append("\n");
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    @Override // com.tencent.feedback.eup.CrashHandleListener
    public boolean onCrashSaving(boolean z16, String str, String str2, String str3, String str4, int i3, long j3, String str5, String str6, String str7, String str8) {
        boolean z17;
        StringBuilder sb5 = new StringBuilder("onCrashSaving isNativeCrashed=");
        sb5.append(z16);
        sb5.append(", crashType=");
        sb5.append(str);
        sb5.append(", crashAddress=");
        sb5.append(str3);
        sb5.append(", crashTime=");
        SimpleDateFormat simpleDateFormat = ly3.a.f415787b;
        sb5.append(simpleDateFormat.format(new Date(j3)));
        sb5.append(", curTime=");
        sb5.append(simpleDateFormat.format(new Date(System.currentTimeMillis())));
        QLog.w("QQCrashReportManager", 1, sb5.toString());
        if (!z16 && "java.util.concurrent.TimeoutException".equals(str) && !TextUtils.isEmpty(str4) && str4.contains("java.lang.Daemons$FinalizerDaemon")) {
            z17 = true;
        } else {
            z17 = false;
        }
        QQCrashReportManager.f363162f = z17;
        if (QQCrashReportManager.f363162f) {
            g.c().e(z16, str, j3, str8, false);
            return false;
        }
        try {
            if (SafeModeUtil.b(str, str4)) {
                String string = BaseApplication.getContext().getSharedPreferences(MsfCmdConfig.SP_SAFEMODE_NOT_EXIT, 4).getString(MsfCmdConfig.KEY_NOT_EXIT_CRASH_STACK, null);
                QLog.e("QQCrashReportManager", 1, "CrashReport.setCrashFilter: " + string);
                CrashReport.setCrashFilter(string);
            }
        } catch (Throwable unused) {
            QLog.e("QQCrashReportManager", 1, "CrashReport.setCrashFilter Failed");
        }
        a(str4);
        g.c().e(z16, str, j3, str8, true);
        return true;
    }

    @Override // com.tencent.qqperf.monitor.crash.f
    public CrashHandleListener getCrashHandleListener() {
        return this;
    }
}
