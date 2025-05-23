package com.tencent.qqperf.monitor.crash;

import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class g {

    /* renamed from: c, reason: collision with root package name */
    public static SimpleDateFormat f363193c = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

    /* renamed from: d, reason: collision with root package name */
    private static volatile g f363194d;

    /* renamed from: a, reason: collision with root package name */
    private MMKVOptionEntity f363195a;

    /* renamed from: b, reason: collision with root package name */
    private volatile a f363196b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        boolean f363197a;

        /* renamed from: b, reason: collision with root package name */
        String f363198b;

        /* renamed from: c, reason: collision with root package name */
        long f363199c;

        /* renamed from: e, reason: collision with root package name */
        boolean f363201e = true;

        /* renamed from: d, reason: collision with root package name */
        int f363200d = 0;

        a(boolean z16, String str, long j3) {
            this.f363198b = str;
            this.f363197a = z16;
            this.f363199c = j3;
        }

        boolean a(boolean z16, String str, long j3) {
            if (z16 == this.f363197a && this.f363199c == j3 && str != null && str.equalsIgnoreCase(this.f363198b)) {
                return true;
            }
            return false;
        }

        String b() {
            if (!StringUtil.isEmpty(this.f363198b) && this.f363199c > 0) {
                return this.f363198b + "_" + this.f363199c;
            }
            return null;
        }

        void c(MMKVOptionEntity mMKVOptionEntity) {
            String b16;
            if (mMKVOptionEntity == null || (b16 = b()) == null) {
                return;
            }
            mMKVOptionEntity.encodeInt("QQCrashHandleReport_STATUS" + b16, this.f363200d);
            mMKVOptionEntity.encodeBool("QQCrashHandleReport_RESULT" + b16, this.f363201e);
        }
    }

    private boolean a(String str) {
        if (StringUtil.isEmpty(str)) {
            return false;
        }
        try {
            int lastIndexOf = str.lastIndexOf("_");
            if (lastIndexOf < 0) {
                return false;
            }
            if (System.currentTimeMillis() - Long.getLong(str.substring(lastIndexOf + 1), -1L).longValue() >= 3600000) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            QLog.e("QQCrashReportManager_StepReportHelper", 2, "checkCrashTime failed", e16);
            return false;
        }
    }

    private void b(String str) {
        QLog.d("QQCrashReportManager_StepReportHelper", 2, str);
    }

    public static g c() {
        if (f363194d == null) {
            f363194d = new g();
        }
        return f363194d;
    }

    private MMKVOptionEntity d() {
        if (this.f363195a == null) {
            this.f363195a = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        }
        return this.f363195a;
    }

    private void j(String str, int i3, boolean z16) {
        String str2;
        String str3;
        Throwable th5;
        HashMap<String, String> hashMap = new HashMap<>();
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        hashMap.put("saveResult", str2);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(i3);
        String str4 = "";
        sb5.append("");
        hashMap.put("endStep", sb5.toString());
        hashMap.put("crashUin", QQCrashReportManager.f363157a);
        try {
            int lastIndexOf = str.lastIndexOf("_");
            if (lastIndexOf >= 0) {
                str3 = str.substring(0, lastIndexOf);
                try {
                    str4 = str.substring(lastIndexOf + 1);
                    str = str3;
                } catch (Throwable th6) {
                    th5 = th6;
                    QLog.e("QQCrashReportManager_StepReportHelper", 1, "reportCrashStepDataInner get name and time failed", th5);
                    str = str3;
                    hashMap.put("crashKey", str);
                    hashMap.put("crashTime", str4);
                    StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(QQCrashReportManager.f363157a, "crash_handle_step_monitor", true, 0L, 0L, hashMap, "", false);
                }
            }
            if (!StringUtil.isEmpty(str4)) {
                str4 = f363193c.format(new Date(Long.getLong(str4, -1L).longValue()));
            }
        } catch (Throwable th7) {
            str3 = str;
            th5 = th7;
        }
        hashMap.put("crashKey", str);
        hashMap.put("crashTime", str4);
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(QQCrashReportManager.f363157a, "crash_handle_step_monitor", true, 0L, 0L, hashMap, "", false);
    }

    private synchronized void k(a aVar) {
        if (aVar == null) {
            return;
        }
        String b16 = aVar.b();
        Set<String> decodeStringSet = d().decodeStringSet("QQCrashHandleReportListKey", new HashSet());
        if (!decodeStringSet.contains(b16)) {
            decodeStringSet.add(b16);
            d().encodeStringSet("QQCrashHandleReportListKey", decodeStringSet);
            b("updateCrashReportData save ReportKey" + b16);
        }
        aVar.c(d());
    }

    public void e(boolean z16, String str, long j3, String str2, boolean z17) {
        b("onCrashSaving");
        a aVar = this.f363196b;
        if (aVar == null || !aVar.a(z16, str, j3)) {
            aVar = new a(z16, str, j3);
        }
        aVar.f363200d = 4;
        aVar.f363201e = z17;
        k(aVar);
    }

    public void f(boolean z16, String str, long j3) {
        b("onGetCrashExtraData");
        a aVar = this.f363196b;
        if (aVar == null || !aVar.a(z16, str, j3)) {
            aVar = new a(z16, str, j3);
        }
        aVar.f363200d = 3;
        this.f363196b = aVar;
        k(aVar);
    }

    public void g(boolean z16, String str, long j3) {
        b("onGetCrashExtraMessageEnd");
        a aVar = this.f363196b;
        if (aVar == null || !aVar.a(z16, str, j3)) {
            aVar = new a(z16, str, j3);
        }
        aVar.f363200d = 2;
        this.f363196b = aVar;
        k(aVar);
    }

    public void h(boolean z16, String str, long j3) {
        b("onGetCrashExtraMessageStart");
        a aVar = this.f363196b;
        if (aVar != null && aVar.a(z16, str, j3)) {
            return;
        }
        a aVar2 = new a(z16, str, j3);
        this.f363196b = aVar2;
        k(aVar2);
    }

    public synchronized void i() {
        String str;
        b("reportCrashStepData");
        Set<String> set = null;
        try {
            set = d().decodeStringSet("QQCrashHandleReportListKey", new HashSet());
            HashSet hashSet = new HashSet();
            b("checkCrashTime crashReportKeylist get list size:" + set.size());
            for (String str2 : set) {
                if (a(str2)) {
                    b("checkCrashTime jump key:" + str2);
                } else {
                    try {
                        int decodeInt = d().decodeInt("QQCrashHandleReport_STATUS" + str2, -1);
                        boolean decodeBool = d().decodeBool("QQCrashHandleReport_RESULT" + str2, true);
                        b("checkCrashTime begin report key:" + str2);
                        if (decodeInt >= 0) {
                            j(str2, decodeInt, decodeBool);
                        }
                        hashSet.add(str2);
                        d().removeKey("QQCrashHandleReport_STATUS" + str2);
                        d().removeKey("QQCrashHandleReport_RESULT" + str2);
                    } catch (Throwable th5) {
                        hashSet.add(str2);
                        d().removeKey("QQCrashHandleReport_STATUS" + str2);
                        d().removeKey("QQCrashHandleReport_RESULT" + str2);
                        throw th5;
                    }
                }
            }
            if (hashSet.size() > 0) {
                set.removeAll(hashSet);
            }
            d().encodeStringSet("QQCrashHandleReportListKey", set);
            str = "checkCrashTime crashReportKeylist save list size:" + set.size();
        } catch (Throwable th6) {
            try {
                QLog.e("QQCrashReportManager_StepReportHelper", 1, "reportCrashStepData failed", th6);
                if (set != null) {
                    d().encodeStringSet("QQCrashHandleReportListKey", set);
                    str = "checkCrashTime crashReportKeylist save list size:" + set.size();
                }
            } catch (Throwable th7) {
                if (set != null) {
                    d().encodeStringSet("QQCrashHandleReportListKey", set);
                    b("checkCrashTime crashReportKeylist save list size:" + set.size());
                }
                throw th7;
            }
        }
        b(str);
    }
}
