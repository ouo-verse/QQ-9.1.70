package com.tencent.qqperf.monitor.crash;

import android.content.SharedPreferences;
import android.os.Process;
import com.tencent.common.config.AppSetting;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.feedback.eup.CrashStrategyBean;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.statistics.o;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class QQCrashReportManager {

    /* renamed from: a, reason: collision with root package name */
    public static String f363157a = "999";

    /* renamed from: b, reason: collision with root package name */
    public static int f363158b;

    /* renamed from: c, reason: collision with root package name */
    public static long f363159c;

    /* renamed from: k, reason: collision with root package name */
    private static QQCrashReportManager f363167k;

    /* renamed from: l, reason: collision with root package name */
    public static String f363168l;

    /* renamed from: d, reason: collision with root package name */
    public static final String f363160d = MobileQQ.sMobileQQ.getFilesDir().getPath();

    /* renamed from: e, reason: collision with root package name */
    public static volatile boolean f363161e = false;

    /* renamed from: f, reason: collision with root package name */
    public static volatile boolean f363162f = false;

    /* renamed from: g, reason: collision with root package name */
    public static volatile long f363163g = 0;

    /* renamed from: h, reason: collision with root package name */
    public static volatile boolean f363164h = false;

    /* renamed from: i, reason: collision with root package name */
    public static String f363165i = null;

    /* renamed from: j, reason: collision with root package name */
    public static String f363166j = null;

    /* renamed from: m, reason: collision with root package name */
    public static StringBuilder f363169m = new StringBuilder("DPC info:\n");

    /* renamed from: n, reason: collision with root package name */
    public static StringBuilder f363170n = new StringBuilder("Thread info:\n");

    QQCrashReportManager() {
    }

    public static QQCrashReportManager a() {
        if (f363167k == null) {
            synchronized (QQCrashReportManager.class) {
                if (f363167k == null) {
                    f363167k = new QQCrashReportManager();
                }
            }
        }
        return f363167k;
    }

    private void b(String str) {
        final BaseApplication context = BaseApplication.getContext();
        CrashReport.setUserId(context, str);
        CrashReport.putUserData(context, "Revision", AppSetting.l());
        CrashReport.putUserData(context, "Version.buildNum", AppSetting.d());
        CrashReport.putUserData(context, "AboutSubVersionLog", AppSetting.c());
        CrashReport.putUserData(context, "appid", String.valueOf(AppSetting.f()));
        CrashReport.putUserData(context, "qimei36", o.c());
        CrashReport.putUserData(context, "branchName", AppSetting.f99544d);
        StringBuilder sb5 = f363170n;
        sb5.append("Current process id=");
        sb5.append(Process.myPid());
        sb5.append(", Name=");
        sb5.append(MobileQQ.processName);
        sb5.append("\n");
        f363163g = System.currentTimeMillis();
        if (1 == MobileQQ.sProcessId) {
            QQCrashControlManager.b().a(str);
            ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.qqperf.monitor.crash.QQCrashReportManager.1
                @Override // java.lang.Runnable
                public void run() {
                    SafeModeUtil.g(context, 1);
                }
            }, 180000L);
            ThreadManager.getSubThreadHandler().postDelayed(new Runnable() { // from class: com.tencent.qqperf.monitor.crash.QQCrashReportManager.2
                @Override // java.lang.Runnable
                public void run() {
                    SharedPreferences sharedPreferences = context.getSharedPreferences(MsfCmdConfig.SP_SAFEMODE_NOT_EXIT, 4);
                    if (!QQCrashReportManager.f363164h && sharedPreferences.getBoolean(MsfCmdConfig.KEY_NOT_EXIT_ENABLE, false)) {
                        sharedPreferences.edit().clear().commit();
                    }
                }
            }, 600000L);
        }
    }

    public static void d(String str) {
        f363157a = str;
        CrashReport.setUserId(MobileQQ.sMobileQQ, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x007d, code lost:
    
        if (("SET CrashConfig =" + r9) == null) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00c4, code lost:
    
        r3 = r9.toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00c8, code lost:
    
        com.tencent.qphone.base.util.QLog.d("QQCrashReportManager", 1, r3);
        r11.setMerged(r10);
        r11.setEnableRecordAnrMainStack(r14);
        r11.setEnableCatchAnrTrace(r15);
        r3 = r10;
        r4 = r16;
        r12 = r17;
        r13 = r18;
        r10 = r19;
        r9 = r20;
        r11.setUploadSpotCrash(false);
        com.tencent.qphone.base.util.QLog.d("QQCrashReportManager", 1, "initCrashReport process=" + mqq.app.MobileQQ.processName + ", pid=" + android.os.Process.myPid() + ", isPublicVersion=true");
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0117, code lost:
    
        if (mqq.app.MobileQQ.processName.endsWith(":qzone") == false) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0119, code lost:
    
        com.tencent.mobileqq.app.ThreadManagerV2.executeOnSubThread(new com.tencent.qqperf.monitor.crash.QQCrashReportManager.AnonymousClass3(r24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0124, code lost:
    
        if (mqq.app.MobileQQ.sProcessId != 1) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0126, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0129, code lost:
    
        r11.setCrashHandler(r26.getCrashHandleListener());
        r11.setUploadProcess(r0);
        r11.setEnableNativeCrashMonitor(true);
        r11.setEnableANRCrashMonitor(true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0142, code lost:
    
        if (com.tencent.qqperf.crashdefend.CrashDefendManager.i().c() == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0144, code lost:
    
        if (r0 == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0146, code lost:
    
        wy3.a.f().n();
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x014d, code lost:
    
        kd2.e.h(true);
        r7 = kd2.e.a();
        com.tencent.qphone.base.util.QLog.d("QQCrashReportManager", 1, "initCrashReport appID is " + r7 + " | isPublishVersion=true");
        com.tencent.feedback.eup.CrashReport.initCrashReport(mqq.app.MobileQQ.sMobileQQ, r7, false, r11, 30000);
        com.tencent.feedback.eup.CrashReport.enableNativeSubProcess(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x019b, code lost:
    
        if (com.tencent.qqperf.crashdefend.CrashDefendManager.i().c() == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x019d, code lost:
    
        if (r0 == false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x019f, code lost:
    
        com.tencent.qphone.base.util.QLog.d("QQCrashReportManager", 1, "registerCrashHandlerToSystem after bugly init.");
        com.tencent.mobileqq.app.ThreadManagerV2.getUIHandlerV2().post(new com.tencent.qqperf.monitor.crash.QQCrashReportManager.AnonymousClass4(r24));
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x01b2, code lost:
    
        com.tencent.qphone.base.util.QLog.d("QQCrashReportManager", 1, "initNativeCrashReport process=" + mqq.app.MobileQQ.processName + ", pid=" + android.os.Process.myPid());
        com.tencent.feedback.eup.CrashReport.filterSysLog(true, true);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x01d7, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x01d8, code lost:
    
        com.tencent.qphone.base.util.QLog.e("QQCrashReportManager", 1, "initNativeCrashReport error", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0128, code lost:
    
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00c1, code lost:
    
        if (("SET CrashConfig =" + r9) != null) goto L47;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c(String str, f fVar) throws Exception {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        int i3;
        boolean z29;
        boolean z36;
        boolean z37;
        boolean z38;
        int i16;
        boolean z39;
        int i17;
        long nanoTime;
        String str2 = "null";
        QLog.d("QQCrashReportManager", 1, "CrashReport init started.");
        if (fVar == null) {
            QLog.e("QQCrashReportManager", 1, "setEnableCrashRecord with callback null,so return");
            return;
        }
        CrashStrategyBean crashStrategyBean = new CrashStrategyBean();
        my3.a aVar = null;
        try {
            nanoTime = System.nanoTime();
            aVar = my3.b.b().a();
            z16 = aVar.i();
        } catch (Throwable th5) {
            th = th5;
            z16 = true;
            z17 = true;
        }
        try {
            z18 = aVar.k();
        } catch (Throwable th6) {
            th = th6;
            z17 = true;
            z18 = false;
            z19 = false;
            z26 = false;
            z27 = false;
            z28 = false;
            i3 = 0;
            try {
                QLog.e("QQCrashReportManager", 1, "getCrashConfig has Exception", th);
            } catch (Throwable th7) {
                if (("SET CrashConfig =" + aVar) != null) {
                    str2 = aVar.toString();
                }
                QLog.d("QQCrashReportManager", 1, str2);
                crashStrategyBean.setMerged(z16);
                crashStrategyBean.setEnableRecordAnrMainStack(z18);
                crashStrategyBean.setEnableCatchAnrTrace(z19);
                throw th7;
            }
        }
        try {
            z19 = aVar.m();
        } catch (Throwable th8) {
            th = th8;
            z17 = true;
            z19 = false;
            z26 = false;
            z27 = false;
            z28 = false;
            i3 = 0;
            QLog.e("QQCrashReportManager", 1, "getCrashConfig has Exception", th);
        }
        try {
            z26 = aVar.g();
            try {
                z27 = aVar.h();
            } catch (Throwable th9) {
                th = th9;
                z17 = true;
                z27 = false;
                z28 = false;
                i3 = 0;
                QLog.e("QQCrashReportManager", 1, "getCrashConfig has Exception", th);
            }
            try {
                z28 = aVar.f();
            } catch (Throwable th10) {
                th = th10;
                z17 = true;
                z28 = false;
                i3 = 0;
                QLog.e("QQCrashReportManager", 1, "getCrashConfig has Exception", th);
            }
            try {
                i3 = aVar.b();
                try {
                    z17 = aVar.l();
                } catch (Throwable th11) {
                    th = th11;
                    z17 = true;
                }
            } catch (Throwable th12) {
                th = th12;
                z17 = true;
                i3 = 0;
                QLog.e("QQCrashReportManager", 1, "getCrashConfig has Exception", th);
            }
        } catch (Throwable th13) {
            th = th13;
            z17 = true;
            z26 = false;
            z27 = false;
            z28 = false;
            i3 = 0;
            QLog.e("QQCrashReportManager", 1, "getCrashConfig has Exception", th);
        }
        try {
            QLog.d("QQCrashReportManager", 2, "CrashConfigLoader Time Test mmkvloadCost:" + (System.nanoTime() - nanoTime));
        } catch (Throwable th14) {
            th = th14;
            QLog.e("QQCrashReportManager", 1, "getCrashConfig has Exception", th);
        }
        b(str);
        fVar.initCrashReport(str, this);
        QLog.d("QQCrashReportManager", i17, "CrashReport init finished.");
        try {
            CrashReport.putUserData(BaseApplication.getContext(), "publicVersionMergeSwitch", "" + z29);
            CrashReport.putUserData(BaseApplication.getContext(), "anrNeedThreadMonitor", "" + z18);
            CrashReport.putUserData(BaseApplication.getContext(), "anrNeedSysTrace", "" + z19);
            CrashReport.putUserData(BaseApplication.getContext(), "isActivityResumeWithDestoryMsgCheckSwitch", "" + z36);
            CrashReport.putUserData(BaseApplication.getContext(), "isBadTokenActivityFinishSwitch", "" + z37);
            CrashReport.putUserData(BaseApplication.getContext(), "isActivityRecordIssueHookFixSwitch", "" + z38);
            CrashReport.putUserData(BaseApplication.getContext(), "anrRecordMessageQueueNum", "" + i16);
            CrashReport.putUserData(BaseApplication.getContext(), "isNativeCrashSubProcessSwitch", "" + z39);
            CrashReport.putUserData(BaseApplication.getContext(), "dex2oatStatus", String.valueOf(kd2.d.b()));
            CrashReport.putUserData(BaseApplication.getContext(), "rfwVersion", "1.241.7.2");
            i17 = 1;
        } catch (Throwable th15) {
            i17 = 1;
            QLog.e("QQCrashReportManager", 1, "initNativeCrashReport putUserData error", th15);
        }
        b(str);
        fVar.initCrashReport(str, this);
        QLog.d("QQCrashReportManager", i17, "CrashReport init finished.");
    }
}
