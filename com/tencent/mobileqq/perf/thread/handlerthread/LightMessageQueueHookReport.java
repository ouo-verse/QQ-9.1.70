package com.tencent.mobileqq.perf.thread.handlerthread;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.QQCrashReportManager;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class LightMessageQueueHookReport {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name */
    private static volatile LightMessageQueueHookReport f258141b;

    /* renamed from: a, reason: collision with root package name */
    a f258142a;

    public LightMessageQueueHookReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f258142a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        long j3;
        String str;
        LightMessageQueueHookReport lightMessageQueueHookReport;
        long j16;
        long j17;
        long j18;
        if (Math.random() > this.f258142a.a()) {
            QLog.i("LightMsgQ.Report", 1, "doCrashReport jump for Event Ratio");
            return;
        }
        MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        long j19 = -1;
        long j26 = -1;
        try {
            if (fromV2.contains("light_msg_queue_hook_count")) {
                j3 = fromV2.getLong("light_msg_queue_hook_count", -1L);
                try {
                    j18 = fromV2.getLong("hook_app_handler_thread_count", -1L);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    j19 = fromV2.getLong("sys_handler_thread_count", -1L);
                    j26 = j3;
                } catch (Throwable th6) {
                    th = th6;
                    j26 = j18;
                    try {
                        QLog.e("LightMsgQ.Report", 1, "doCrashReport has exception!", th);
                        if (j3 > 0) {
                            str = "light_msg_queue_crash_report";
                            lightMessageQueueHookReport = this;
                            j16 = j3;
                            j17 = j26;
                            lightMessageQueueHookReport.f(str, j16, j17, j19);
                            g();
                        }
                        k(fromV2);
                    } catch (Throwable th7) {
                        if (j3 > 0) {
                            f("light_msg_queue_crash_report", j3, j26, -1L);
                            g();
                        }
                        k(fromV2);
                        throw th7;
                    }
                }
            } else {
                j18 = -1;
            }
        } catch (Throwable th8) {
            th = th8;
            j3 = -1;
        }
        if (j26 > 0) {
            str = "light_msg_queue_crash_report";
            lightMessageQueueHookReport = this;
            j16 = j26;
            j17 = j18;
            lightMessageQueueHookReport.f(str, j16, j17, j19);
            g();
        }
        k(fromV2);
    }

    private void f(String str, long j3, long j16, long j17) {
        String str2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            str2 = peekAppRuntime.getCurrentUin();
        } else {
            str2 = "null";
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("reportUin", str2);
        hashMap.put("hookMsgQueueCount", j3 + "");
        hashMap.put("hookHandlerThreadCount", j16 + "");
        hashMap.put("sysHandlerThreadCount", j17 + "");
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(QQCrashReportManager.f363157a, str, true, 0L, 0L, hashMap, "", false);
        if (QLog.isColorLevel()) {
            QLog.i("LightMsgQ.Report", 2, "doReportInner eventTag=" + str + " |hookMsgQueueCount=" + j3 + " |hookHandlerThreadCount=" + j16 + " |sysHandlerThreadCount=" + j17);
        }
    }

    private void g() {
        if (Math.random() > this.f258142a.c()) {
            QLog.i("LightMsgQ.Report", 1, "doSetFdReport jump for Event Ratio");
            return;
        }
        try {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            String str = "";
            if (fromV2.contains("light_msg_queue_set_fd_info")) {
                str = fromV2.getString("light_msg_queue_set_fd_info", "");
            }
            if (!StringUtil.isEmpty(str)) {
                JSONArray jSONArray = new JSONArray(str);
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    i(jSONArray.getJSONObject(i3));
                }
            }
        } catch (Throwable th5) {
            QLog.e("LightMsgQ.Report", 1, "doSetFdRecord failed!", th5);
        }
    }

    public static synchronized LightMessageQueueHookReport h() {
        LightMessageQueueHookReport lightMessageQueueHookReport;
        synchronized (LightMessageQueueHookReport.class) {
            if (f258141b == null) {
                f258141b = new LightMessageQueueHookReport();
                f258141b.f258142a = a.b();
                if (QLog.isColorLevel()) {
                    QLog.i("LightMsgQ.Report", 2, "init config:" + f258141b.f258142a.toString());
                }
            }
            lightMessageQueueHookReport = f258141b;
        }
        return lightMessageQueueHookReport;
    }

    private void k(MMKVOptionEntityV2 mMKVOptionEntityV2) {
        mMKVOptionEntityV2.remove("light_msg_queue_hook_count");
        mMKVOptionEntityV2.remove("hook_app_handler_thread_count");
        mMKVOptionEntityV2.remove("sys_handler_thread_count");
        mMKVOptionEntityV2.remove("light_msg_queue_set_fd_info");
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("LightMsgQ.Report", 2, "reportData invoke.");
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.perf.thread.handlerthread.LightMessageQueueHookReport.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) LightMessageQueueHookReport.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    LightMessageQueueHookReport.this.e();
                    LightMessageQueueHookReport.this.d();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        }, 16, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
    }

    private void i(@NonNull JSONObject jSONObject) {
    }
}
