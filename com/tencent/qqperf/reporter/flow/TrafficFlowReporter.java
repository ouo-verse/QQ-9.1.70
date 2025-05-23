package com.tencent.qqperf.reporter.flow;

import android.app.usage.NetworkStats;
import android.app.usage.NetworkStatsManager;
import android.os.Process;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.servlet.MiniAppGetTeenagerConfigServlet;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes25.dex */
public class TrafficFlowReporter {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes25.dex */
    public class a implements Comparator<Map.Entry<String, TrafficFlowRecord>> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Map.Entry<String, TrafficFlowRecord> entry, Map.Entry<String, TrafficFlowRecord> entry2) {
            if (entry != null && entry2 != null) {
                return Long.compare(entry2.getValue().f363352d, entry.getValue().f363352d);
            }
            return -1;
        }
    }

    static /* bridge */ /* synthetic */ HashMap d() {
        return k();
    }

    static /* bridge */ /* synthetic */ String e() {
        return l();
    }

    static /* bridge */ /* synthetic */ boolean f() {
        return m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(HashMap<String, String> hashMap) {
        hashMap.put("currentProcess", MobileQQ.processName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(HashMap<String, String> hashMap) {
        hashMap.put("realUin", l());
    }

    private static String i(long j3) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HashMap<String, String> j(HashMap<String, String> hashMap) {
        List<Map.Entry<String, TrafficFlowRecord>> n3 = n(System.currentTimeMillis());
        if (n3.size() != 2) {
            return new HashMap<>();
        }
        HashMap<String, String> hashMap2 = new HashMap<>();
        hashMap2.put("realUin", l());
        hashMap2.put("totalAmount", hashMap.get("totalAmount"));
        hashMap2.put("totalMobile", hashMap.get("totalMobile"));
        hashMap2.put("totalWifi", hashMap.get("totalWifi"));
        hashMap2.put("wifiRxBytes", hashMap.get("wifiRxBytes"));
        hashMap2.put("mobileRxBytes", hashMap.get("mobileRxBytes"));
        hashMap2.put(MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, hashMap.get(MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL));
        int i3 = 0;
        while (i3 < n3.size()) {
            Map.Entry<String, TrafficFlowRecord> entry = n3.get(i3);
            i3++;
            String key = entry.getKey();
            String str = "top" + i3;
            TrafficFlowRecord value = entry.getValue();
            hashMap2.put(str + "totalAmount", String.valueOf(value.f363352d));
            hashMap2.put(str + "totalMobile", String.valueOf(value.f363356i));
            hashMap2.put(str + "totalWifi", String.valueOf(value.f363353e));
            hashMap2.put(str + MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, key);
            hashMap2.put(str + "wifiRxBytes", String.valueOf(value.f363354f));
            hashMap2.put(str + "mobileRxBytes", String.valueOf(value.f363357m));
        }
        return hashMap2;
    }

    private static HashMap<String, String> k() {
        long currentTimeMillis = System.currentTimeMillis();
        TrafficFlowRecord o16 = o(0L, currentTimeMillis);
        if (o16.f363352d == 0) {
            return new HashMap<>();
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        TrafficFlowRecord trafficFlowRecord = (TrafficFlowRecord) from.decodeParcelable("mmkv_daily_flow_report_last_record", TrafficFlowRecord.class, new TrafficFlowRecord());
        long decodeLong = from.decodeLong("mmkv_daily_flow_report_last_record_time", 0L);
        from.encodeLong("mmkv_daily_flow_report_last_record_time", currentTimeMillis);
        from.encodeParcelable("mmkv_daily_flow_report_last_record", o16);
        long j3 = trafficFlowRecord.f363352d;
        if (j3 > 0 && decodeLong != 0) {
            long j16 = o16.f363354f - trafficFlowRecord.f363354f;
            long j17 = o16.f363355h - trafficFlowRecord.f363355h;
            long j18 = o16.f363357m - trafficFlowRecord.f363357m;
            long j19 = o16.C - trafficFlowRecord.C;
            long j26 = o16.f363353e - trafficFlowRecord.f363353e;
            long j27 = o16.f363356i - trafficFlowRecord.f363356i;
            long j28 = o16.f363352d - j3;
            String str = i(decodeLong) + "-" + i(currentTimeMillis);
            if (j28 > 0 && j27 >= 0 && j26 >= 0) {
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("totalAmount", String.valueOf(j28));
                hashMap.put("totalMobile", String.valueOf(j27));
                hashMap.put("totalWifi", String.valueOf(j26));
                hashMap.put("realUin", l());
                hashMap.put(MiniAppGetTeenagerConfigServlet.KEY_TIME_INTERVAL, str);
                hashMap.put("wifiRxBytes", String.valueOf(j16));
                hashMap.put("wifiTxBytes", String.valueOf(j17));
                hashMap.put("mobileRxBytes", String.valueOf(j18));
                hashMap.put("mobileTxBytes", String.valueOf(j19));
                return hashMap;
            }
            return new HashMap<>();
        }
        return new HashMap<>();
    }

    private static String l() {
        SimpleAccount firstSimpleAccount = MobileQQ.sMobileQQ.getFirstSimpleAccount();
        if (firstSimpleAccount != null) {
            return firstSimpleAccount.getUin();
        }
        return "default";
    }

    private static boolean m() {
        if (new Random().nextInt(10) == 0) {
            return true;
        }
        return false;
    }

    private static List<Map.Entry<String, TrafficFlowRecord>> n(long j3) {
        HashMap hashMap = new HashMap();
        int i3 = 1;
        while (i3 <= 12) {
            long j16 = j3 - 7200000;
            TrafficFlowRecord o16 = o(j16, j3);
            String str = i(j16) + "-" + i(j3);
            QLog.d("TrafficFlowReporter", 1, "[queryLast24HSummaryFlow]:" + str + " " + o16);
            hashMap.put(str, o16);
            i3++;
            j3 = j16;
        }
        ArrayList arrayList = new ArrayList(hashMap.entrySet());
        Collections.sort(arrayList, new a());
        return arrayList.subList(0, Math.min(2, arrayList.size()));
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static TrafficFlowRecord o(long j3, long j16) {
        NetworkStats networkStats;
        NetworkStats querySummary;
        TrafficFlowRecord trafficFlowRecord = new TrafficFlowRecord();
        int myUid = Process.myUid();
        NetworkStatsManager networkStatsManager = (NetworkStatsManager) MobileQQ.sMobileQQ.getSystemService("netstats");
        if (networkStatsManager != null) {
            NetworkStats networkStats2 = null;
            try {
                querySummary = networkStatsManager.querySummary(1, null, j3, j16);
            } catch (Exception e16) {
                e = e16;
                networkStats = null;
            } catch (Throwable th5) {
                th = th5;
                networkStats = null;
            }
            try {
                networkStats2 = networkStatsManager.querySummary(0, null, j3, j16);
                do {
                    NetworkStats.Bucket bucket = new NetworkStats.Bucket();
                    querySummary.getNextBucket(bucket);
                    if (bucket.getUid() == myUid) {
                        trafficFlowRecord.f363354f += bucket.getRxBytes();
                        trafficFlowRecord.f363355h += bucket.getTxBytes();
                    }
                } while (querySummary.hasNextBucket());
                do {
                    NetworkStats.Bucket bucket2 = new NetworkStats.Bucket();
                    networkStats2.getNextBucket(bucket2);
                    if (bucket2.getUid() == myUid) {
                        trafficFlowRecord.f363357m += bucket2.getRxBytes();
                        trafficFlowRecord.C += bucket2.getTxBytes();
                    }
                } while (networkStats2.hasNextBucket());
                querySummary.close();
                networkStats2.close();
            } catch (Exception e17) {
                e = e17;
                networkStats = networkStats2;
                networkStats2 = querySummary;
                try {
                    QLog.e("TrafficFlowReporter", 1, "reportDailyFlow:" + e);
                    if (networkStats2 != null) {
                        networkStats2.close();
                    }
                    if (networkStats != null) {
                        networkStats.close();
                    }
                    long j17 = trafficFlowRecord.f363354f + trafficFlowRecord.f363355h;
                    trafficFlowRecord.f363353e = j17;
                    long j18 = trafficFlowRecord.f363357m + trafficFlowRecord.C;
                    trafficFlowRecord.f363356i = j18;
                    trafficFlowRecord.f363352d = j17 + j18;
                    QLog.d("TrafficFlowReporter", 1, "From:" + i(j3) + " To:" + i(j16) + " " + trafficFlowRecord.toString());
                    return trafficFlowRecord;
                } catch (Throwable th6) {
                    th = th6;
                    if (networkStats2 != null) {
                        networkStats2.close();
                    }
                    if (networkStats != null) {
                        networkStats.close();
                    }
                    throw th;
                }
            } catch (Throwable th7) {
                th = th7;
                networkStats = networkStats2;
                networkStats2 = querySummary;
                if (networkStats2 != null) {
                }
                if (networkStats != null) {
                }
                throw th;
            }
        }
        long j172 = trafficFlowRecord.f363354f + trafficFlowRecord.f363355h;
        trafficFlowRecord.f363353e = j172;
        long j182 = trafficFlowRecord.f363357m + trafficFlowRecord.C;
        trafficFlowRecord.f363356i = j182;
        trafficFlowRecord.f363352d = j172 + j182;
        QLog.d("TrafficFlowReporter", 1, "From:" + i(j3) + " To:" + i(j16) + " " + trafficFlowRecord.toString());
        return trafficFlowRecord;
    }

    public static void p() {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.qqperf.reporter.flow.TrafficFlowReporter.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    List<HashMap<String, String>> d16 = com.tencent.qqperf.reporter.flow.a.d();
                    if (!TrafficFlowReporter.f() || d16.isEmpty()) {
                        return;
                    }
                    String e16 = TrafficFlowReporter.e();
                    for (HashMap<String, String> hashMap : d16) {
                        if (!hashMap.isEmpty()) {
                            TrafficFlowReporter.h(hashMap);
                            QLog.d("DownloaderReporter", 1, "reportDailyDownloaderFlow, param = " + hashMap.toString());
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(e16, "DownloaderFlowReport", true, 0L, 0L, hashMap, "");
                        }
                    }
                } catch (Exception e17) {
                    QLog.e("DownloaderReporter", 1, "reportDailyFlow Error:" + e17);
                }
            }
        }, 128, null, false, 0L);
    }

    public static void q() {
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.qqperf.reporter.flow.TrafficFlowReporter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HashMap<String, String> d16 = TrafficFlowReporter.d();
                    if (d16.isEmpty()) {
                        return;
                    }
                    QLog.d("TrafficFlowReporter", 1, "reportDailyFlow, params = " + d16.toString());
                    String str = d16.get("totalAmount");
                    if (str == null) {
                        return;
                    }
                    long parseLong = Long.parseLong(str);
                    if (parseLong < 5242880000L) {
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(TrafficFlowReporter.e(), "dailyFlowReport", true, 0L, 0L, d16, "");
                    } else if (parseLong < 1099511627776L) {
                        HashMap<String, String> j3 = TrafficFlowReporter.j(d16);
                        QLog.d("TrafficFlowReporter", 1, "dailyBigFlowReport, params = " + j3.toString());
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(TrafficFlowReporter.e(), "dailyBigFlowReport", true, 0L, 0L, j3, "");
                    }
                } catch (Exception e16) {
                    QLog.e("TrafficFlowReporter", 1, "reportDailyFlow Error:" + e16);
                }
            }
        }, 128, null, false, 0L);
    }

    public static void r(final b bVar) {
        if (bVar == null) {
            return;
        }
        ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.qqperf.reporter.flow.TrafficFlowReporter.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HashMap<String, String> a16 = b.this.a();
                    TrafficFlowReporter.h(a16);
                    TrafficFlowReporter.g(a16);
                    if (AppSetting.isPublicVersion()) {
                        if (QLog.isColorLevel()) {
                            QLog.d("TrafficFlowReporter", 2, "reportFlow, params = " + b.this.b());
                        }
                    } else {
                        QLog.d("TrafficFlowReporter", 1, "reportFlow, params = " + a16.toString());
                    }
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(TrafficFlowReporter.e(), "businessFlowReport", true, 0L, 0L, a16, "");
                } catch (Exception e16) {
                    QLog.e("TrafficFlowReporter", 1, "reportFlow Error:" + e16);
                }
            }
        }, 128, null, false, 0L);
    }
}
