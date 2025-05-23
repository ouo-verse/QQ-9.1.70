package com.tencent.mobileqq.utils;

import android.app.ActivityManager;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.mobileqq.app.JobReporter;
import com.tencent.mobileqq.app.ThreadSetting;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.perf.replay.IReplayTest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class cq {
    public static void a(boolean z16, String... strArr) {
        List<ActivityManager.RunningAppProcessInfo> list;
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager == null) {
            return;
        }
        if (d()) {
            QLog.d(GuardManager.TAG, 1, "current is in replay test, ignore process exit action");
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList<String> arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList();
        try {
            list = SystemMethodProxy.getRunningAppProcesses((ActivityManager) guardManager.getContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY));
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(GuardManager.TAG, 2, "exitProcess: Failed.  exception: ", th5);
            }
            list = null;
        }
        if (list != null) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
                String str = runningAppProcessInfo.processName;
                if (str.startsWith(MobileQQ.PACKAGE_NAME) && str.indexOf(58) != -1 && !str.endsWith(":MSF")) {
                    if (strArr != null) {
                        int length = strArr.length;
                        int i3 = 0;
                        boolean z17 = false;
                        while (true) {
                            if (i3 >= length) {
                                break;
                            }
                            String str2 = strArr[i3];
                            if (!TextUtils.isEmpty(str2) && str.endsWith(str2)) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            if (z17) {
                                arrayList3.add(str);
                                break;
                            }
                            i3++;
                        }
                        if (z17) {
                        }
                    }
                    int i16 = runningAppProcessInfo.importance;
                    if (i16 != 100 && (i16 != 200 || (i16 == 200 && runningAppProcessInfo.importanceReasonCode != 0))) {
                        arrayList2.add(str);
                        GuardManager.sInstance.injector.exitProcess(str);
                        if (str.endsWith(":qzone")) {
                            GuardManager.sInstance.injector.g();
                        }
                    } else {
                        arrayList.add(str);
                    }
                }
            }
        }
        if (QLog.isColorLevel()) {
            QLog.d(GuardManager.TAG, 2, "GmVersion= 20140619, app versioncode = " + f.a(BaseApplication.getContext()) + ", toExitProcess=" + arrayList2 + ", forgroundProcess=" + arrayList + ", exceptions:" + arrayList3);
        }
        if (arrayList2.size() > 0) {
            Intent intent = new Intent("com.tencent.process.exit");
            intent.putExtra("exit_type", 101);
            intent.putExtra("qq_mode_foreground", z16);
            intent.putStringArrayListExtra("procNameList", arrayList2);
            intent.putExtra("verify", c(arrayList2, false));
            guardManager.getContext().sendBroadcast(intent);
        }
    }

    public static void b(boolean z16, String str) {
        GuardManager guardManager = GuardManager.sInstance;
        if (guardManager == null) {
            return;
        }
        if (d()) {
            QLog.d(GuardManager.TAG, 1, "current is in replay test, ignore process exit action");
            return;
        }
        GuardManager.sInstance.injector.exitProcess(str);
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(str);
        Intent intent = new Intent("com.tencent.process.exit");
        intent.putExtra("exit_type", 101);
        intent.putExtra("qq_mode_foreground", z16);
        intent.putStringArrayListExtra("procNameList", arrayList);
        intent.putExtra("verify", c(arrayList, false));
        guardManager.getContext().sendBroadcast(intent);
        if (QLog.isColorLevel()) {
            QLog.d(GuardManager.TAG, 2, "GmVersion= 20140619, app versioncode = " + f.a(BaseApplication.getContext()) + ", toExitTargetProcess=" + str + " isForeground=" + z16);
        }
    }

    public static String c(ArrayList<String> arrayList, boolean z16) {
        int i3;
        String obj;
        Time time = new Time();
        time.setToNow();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("com.tencent.process.exit");
        sb5.append(time.year);
        sb5.append(time.month + 1);
        sb5.append(time.monthDay);
        sb5.append(time.hour);
        if (z16) {
            i3 = time.minute - 1;
        } else {
            i3 = time.minute;
        }
        sb5.append(i3);
        if (arrayList == null) {
            obj = "null";
        } else {
            obj = arrayList.toString();
        }
        sb5.append(obj);
        return MD5.toMD5(MD5.toMD5(sb5.toString()) + sb5.toString());
    }

    private static boolean d() {
        try {
            return ((IReplayTest) QRoute.api(IReplayTest.class)).isReplayTest();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean e() {
        if (!ThreadSetting.isPublicVersion || ThreadSetting.isGrayVersion) {
            return true;
        }
        return JobReporter.ramdomReport(10000);
    }

    public static void f(boolean z16) {
        int i3;
        try {
            if (MobileQQ.sProcessId == 1) {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (z16 || uptimeMillis - JobReporter.sThreadJobReportLastReportTs.get() >= 600000) {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    long andSet = JobReporter.sThreadJobReportTotalCount.getAndSet(0L);
                    if (andSet != 0 && peekAppRuntime != null && e()) {
                        String l3 = Long.toString(JobReporter.sThreadJobReportCountLevelOne.getAndSet(0L));
                        String l16 = Long.toString(JobReporter.sThreadJobReportCountLevelTwo.getAndSet(0L));
                        String l17 = Long.toString(JobReporter.sThreadJobReportCountLevelThree.getAndSet(0L));
                        if (andSet > TTL.MAX_VALUE) {
                            i3 = Integer.MAX_VALUE;
                        } else {
                            i3 = (int) andSet;
                        }
                        JobReporter.sThreadJobReportLastReportTs.set(uptimeMillis);
                        HashMap<String, String> hashMap = new HashMap<>();
                        hashMap.put("countLevel_1", l3);
                        hashMap.put("countLevel_2", l16);
                        hashMap.put("countLevel_3", l17);
                        GuardManager.sInstance.injector.collectPerformance(peekAppRuntime.getAccount(), "maxThreadManagerJobWait", true, i3, 1L, hashMap, "");
                    }
                }
            }
        } catch (Throwable th5) {
            QLog.e(GuardManager.TAG, 1, "reportThreadJobWaitTime", th5);
        }
    }
}
