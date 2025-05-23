package com.tencent.mobileqq.perf.thread.block;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.perf.report.PerfReportUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.util.AppSetting;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0086  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String a(Thread thread) {
        String str;
        Exception e16;
        String str2;
        StringBuilder sb5 = new StringBuilder(50);
        sb5.append("AdditionInfo:0|");
        String str3 = null;
        long j3 = 0;
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(BaseApplication.getContext().getPackageManager(), "com.tencent.mobileqq", 128);
            str = packageInfo.versionName + "." + packageInfo.versionCode;
            try {
                if (4 == MobileQQ.sProcessId) {
                    MsfCore msfCore = MsfCore.sCore;
                    if (msfCore != null) {
                        str3 = msfCore.getMainAccount();
                    }
                } else {
                    str3 = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
                }
                if (!TextUtils.isEmpty(str3)) {
                    j3 = Long.parseLong(str3);
                }
            } catch (Exception e17) {
                e16 = e17;
                QLog.e("[TM]ThreadLockReporter", 1, "", e16);
                sb5.append(j3);
                sb5.append("|");
                sb5.append(str);
                sb5.append("|");
                if (!AppSetting.isGrayVersion()) {
                }
                sb5.append("|");
                sb5.append(str2);
                sb5.append("|");
                sb5.append(System.currentTimeMillis());
                sb5.append("|");
                sb5.append(DeviceInfoMonitor.getModel());
                sb5.append("|");
                sb5.append(Build.VERSION.RELEASE);
                sb5.append("|");
                sb5.append("monitorThread=");
                sb5.append(thread.getName());
                sb5.append(",tid=");
                sb5.append(thread.getId());
                sb5.append(",state=");
                sb5.append(thread.getState());
                sb5.append(com.tencent.mobileqq.perf.thread.b.m());
                sb5.append(com.tencent.mobileqq.perf.thread.b.k());
                return sb5.toString();
            }
        } catch (Exception e18) {
            str = null;
            e16 = e18;
        }
        sb5.append(j3);
        sb5.append("|");
        sb5.append(str);
        sb5.append("|");
        if (!AppSetting.isGrayVersion()) {
            str2 = "gray";
        } else if (AppSetting.isPublicVersion()) {
            str2 = "pub";
        } else if (!AppSetting.isDebugVersion()) {
            str2 = TVKNetVideoInfo.AUDIO_TRACK_DOLBY;
        } else {
            str2 = "dbg";
        }
        sb5.append("|");
        sb5.append(str2);
        sb5.append("|");
        sb5.append(System.currentTimeMillis());
        sb5.append("|");
        sb5.append(DeviceInfoMonitor.getModel());
        sb5.append("|");
        sb5.append(Build.VERSION.RELEASE);
        sb5.append("|");
        sb5.append("monitorThread=");
        sb5.append(thread.getName());
        sb5.append(",tid=");
        sb5.append(thread.getId());
        sb5.append(",state=");
        sb5.append(thread.getState());
        sb5.append(com.tencent.mobileqq.perf.thread.b.m());
        sb5.append(com.tencent.mobileqq.perf.thread.b.k());
        return sb5.toString();
    }

    private static String b(Thread thread) {
        StackTraceElement[] stackTrace = thread.getStackTrace();
        StringBuilder sb5 = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTrace) {
            sb5.append(stackTraceElement);
            sb5.append("\r\n");
        }
        return sb5.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String c(String str) {
        StringBuilder sb5 = new StringBuilder();
        File file = new File(str);
        if (file.exists()) {
            QLog.e("[TM]ThreadLockReporter", 1, "debugThreadHeld start " + str);
            int i3 = 0;
            i3 = 0;
            i3 = 0;
            i3 = 0;
            i3 = 0;
            i3 = 0;
            i3 = 0;
            i3 = 0;
            i3 = 0;
            BufferedReader bufferedReader = null;
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(new FileInputStream(file)), 8096);
                    while (true) {
                        try {
                            String readLine = bufferedReader2.readLine();
                            if (readLine != null) {
                                sb5.append(readLine);
                                sb5.append("\n");
                            } else {
                                try {
                                    break;
                                } catch (Exception e16) {
                                    Object[] objArr = new Object[0];
                                    QLog.e("[TM]ThreadLockReporter", 1, e16, objArr);
                                    i3 = objArr;
                                }
                            }
                        } catch (FileNotFoundException e17) {
                            e = e17;
                            bufferedReader = bufferedReader2;
                            QLog.e("[TM]ThreadLockReporter", 1, e, new Object[0]);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e18) {
                                    Object[] objArr2 = new Object[0];
                                    QLog.e("[TM]ThreadLockReporter", 1, e18, objArr2);
                                    i3 = objArr2;
                                }
                            }
                            return sb5.toString();
                        } catch (IOException e19) {
                            e = e19;
                            bufferedReader = bufferedReader2;
                            QLog.e("[TM]ThreadLockReporter", 1, e, new Object[0]);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e26) {
                                    Object[] objArr3 = new Object[0];
                                    QLog.e("[TM]ThreadLockReporter", 1, e26, objArr3);
                                    i3 = objArr3;
                                }
                            }
                            return sb5.toString();
                        } catch (OutOfMemoryError e27) {
                            e = e27;
                            bufferedReader = bufferedReader2;
                            QLog.e("[TM]ThreadLockReporter", 1, e, new Object[0]);
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e28) {
                                    Object[] objArr4 = new Object[0];
                                    QLog.e("[TM]ThreadLockReporter", 1, e28, objArr4);
                                    i3 = objArr4;
                                }
                            }
                            return sb5.toString();
                        } catch (Throwable th5) {
                            th = th5;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (Exception e29) {
                                    QLog.e("[TM]ThreadLockReporter", 1, e29, new Object[i3]);
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader2.close();
                } catch (FileNotFoundException e36) {
                    e = e36;
                } catch (IOException e37) {
                    e = e37;
                } catch (OutOfMemoryError e38) {
                    e = e38;
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return sb5.toString();
    }

    private static String d(Thread thread) {
        String a16 = a(thread);
        String j3 = com.tencent.mobileqq.perf.thread.b.j(thread.getName());
        if (com.tencent.mobileqq.perf.thread.b.h(j3) != 1) {
            com.tencent.mobileqq.perf.thread.b.f(j3, a16);
        }
        return j3;
    }

    private static boolean e() {
        if (Foreground.getActivityCount() > 0) {
            return true;
        }
        return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations").decodeBool("app_state_foreground_key", true);
    }

    public static void f(a aVar) {
        Thread thread;
        if (aVar != null && (thread = aVar.f258099b) != null) {
            String c16 = c(d(thread));
            com.tencent.mobileqq.perf.log.a.d("TB", c16);
            h(aVar.f258099b, c16);
            g(aVar.f258099b, r0.f258119d, aVar.f258100c.f258116a, aVar.f258103f, aVar.f258105h);
        }
    }

    private static void g(Thread thread, long j3, String str, long j16, long j17) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("threadName", thread.getName());
        hashMap.put("threadState", String.valueOf(thread.getState()));
        hashMap.put("threadTimeout", String.valueOf(j3));
        hashMap.put("threadType", str);
        PerfReportUtil.a(hashMap);
        hashMap.put("threadStack", b(thread));
        hashMap.put("runnableNotSleepCost", String.valueOf(j16));
        hashMap.put("runnableSleepCost", String.valueOf(j17));
        hashMap.put("foregroundState", String.valueOf(e()));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actThreadBlock", true, 0L, 0L, hashMap, "");
        QLog.d("[TM]ThreadLockReporter", 1, "reportBeacon param:" + hashMap);
    }

    private static void h(Thread thread, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("[TM]ThreadLockReporter", 1, "reportToBugly.");
        }
        Throwable th5 = new Throwable("QQ_THREAD_BLOCK:" + thread.getName());
        th5.setStackTrace(thread.getStackTrace());
        com.tencent.qqperf.monitor.crash.catchedexception.a.d(th5, str, thread);
    }
}
