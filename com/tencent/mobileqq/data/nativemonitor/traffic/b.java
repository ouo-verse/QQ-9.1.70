package com.tencent.mobileqq.data.nativemonitor.traffic;

import androidx.annotation.NonNull;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.mobileqq.data.nativemonitor.StackUtil;
import com.tencent.mobileqq.nativememorymonitor.library.trafficmonitor.ITrafficReporter;
import com.tencent.mobileqq.nativememorymonitor.library.trafficmonitor.TrafficReportBean;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.AppRuntime;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b implements ITrafficReporter {

    /* renamed from: a, reason: collision with root package name */
    private static volatile b f203181a;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements Comparator<TrafficReportBean> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f203182d;

        a(boolean z16) {
            this.f203182d = z16;
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(TrafficReportBean trafficReportBean, TrafficReportBean trafficReportBean2) {
            long j3;
            long j16;
            long j17;
            if (this.f203182d) {
                j3 = trafficReportBean.mobileUpLoadTraffic + trafficReportBean.mobileDownLoadTraffic;
                j16 = trafficReportBean2.mobileUpLoadTraffic;
                j17 = trafficReportBean2.mobileDownLoadTraffic;
            } else {
                j3 = trafficReportBean.wifiUploadTraffic + trafficReportBean.wifiDownLoadTraffic;
                j16 = trafficReportBean2.wifiUploadTraffic;
                j17 = trafficReportBean2.wifiDownLoadTraffic;
            }
            return -Long.compare(j3, j16 + j17);
        }
    }

    b() {
    }

    private Map<String, String> a() {
        boolean z16;
        HashMap hashMap = new HashMap();
        hashMap.put("traffic_monitor_process_name", MobileQQ.processName);
        if (Foreground.getActivityCount() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        hashMap.put("traffic_monitor_is_on_foreground", String.valueOf(z16));
        hashMap.put("bg_broadcast_register_res", String.valueOf(NativeTrafficMonitorHelper.f203166d));
        return hashMap;
    }

    public static b b() {
        if (f203181a == null) {
            synchronized (b.class) {
                if (f203181a == null) {
                    f203181a = new b();
                }
            }
        }
        return f203181a;
    }

    private static TrafficReportBean c(TrafficReportBean trafficReportBean) {
        if (trafficReportBean == null) {
            return null;
        }
        trafficReportBean.threadStack = StackUtil.a(trafficReportBean.threadStack, 0, 50);
        return trafficReportBean;
    }

    private static boolean d(TrafficReportBean trafficReportBean) {
        List<String> list;
        if (trafficReportBean == null) {
            return true;
        }
        com.tencent.mobileqq.data.nativemonitor.traffic.a aVar = NativeTrafficMonitorHelper.b().f203168a;
        if (aVar != null && (list = aVar.N) != null) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                if (trafficReportBean.threadStack.contains(it.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    private void e(Map<String, String> map, TrafficReportBean trafficReportBean, int i3) {
        String str;
        String str2;
        if (i3 <= 0) {
            str = "";
        } else {
            str = "_" + i3;
        }
        map.put("traffic_monitor_single_report_ip" + str, trafficReportBean.f252487ip);
        map.put("traffic_monitor_single_report_port" + str, String.valueOf(trafficReportBean.port));
        map.put("traffic_monitor_single_report_thread_name" + str, trafficReportBean.threadName);
        map.put("traffic_monitor_single_report_thread_stack" + str, trafficReportBean.threadStack);
        map.put("traffic_monitor_single_report_mobile_down_traffic" + str, String.valueOf(trafficReportBean.mobileDownLoadTraffic));
        map.put("traffic_monitor_single_report_mobile_up_traffic" + str, String.valueOf(trafficReportBean.mobileUpLoadTraffic));
        map.put("traffic_monitor_single_report_wifi_down_traffic" + str, String.valueOf(trafficReportBean.wifiDownLoadTraffic));
        map.put("traffic_monitor_single_report_wifi_up_traffic" + str, String.valueOf(trafficReportBean.wifiUploadTraffic));
        map.put("bg_single_report_mobile_down_traffic" + str, String.valueOf(trafficReportBean.bgMobileDownloadTraffic));
        map.put("bg_single_report_mobile_up_traffic" + str, String.valueOf(trafficReportBean.bgMobileUploadTraffic));
        map.put("bg_single_report_wifi_down_traffic" + str, String.valueOf(trafficReportBean.bgWifiDownloadTraffic));
        map.put("bg_single_report_wifi_up_traffic" + str, String.valueOf(trafficReportBean.bgWifiUploadTraffic));
        int i16 = trafficReportBean.trafficAlertType;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 != 3) {
                        str2 = "unknown";
                    } else {
                        str2 = "wifiUpload";
                    }
                } else {
                    str2 = "wifiDownload";
                }
            } else {
                str2 = "mobileUpload";
            }
        } else {
            str2 = "mobileDownLoad";
        }
        map.put("traffic_monitor_single_report_traffic_alert_type" + str, str2);
    }

    private void f(@NonNull List<TrafficReportBean> list, boolean z16) {
        String str;
        String currentUin;
        Map<String, String> a16 = a();
        if (z16) {
            str = DeviceType.DeviceCategory.MOBILE;
        } else {
            str = "wifi";
        }
        a16.put("traffic_monitor_global_report_alert_type", str);
        int i3 = 0;
        while (i3 < list.size() && i3 < 5) {
            TrafficReportBean c16 = c(list.get(i3));
            i3++;
            e(a16, c16, i3);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            currentUin = "0";
        } else {
            currentUin = peekAppRuntime.getCurrentUin();
        }
        QLog.d("NativeTrafficMonitorReporter", 1, "reportBeaconGlobal, param: " + a16);
        QQBeaconReport.report(currentUin, "native_traffic_monitor_global_report", a16);
    }

    private void g(@NonNull TrafficReportBean trafficReportBean) {
        String currentUin;
        Map<String, String> a16 = a();
        e(a16, c(trafficReportBean), 0);
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            currentUin = "0";
        } else {
            currentUin = peekAppRuntime.getCurrentUin();
        }
        QLog.d("NativeTrafficMonitorReporter", 1, "reportBeaconSingle, param: " + a16);
        QQBeaconReport.report(currentUin, "native_traffic_monitor_single_report", a16);
    }

    @Override // com.tencent.mobileqq.nativememorymonitor.library.trafficmonitor.ITrafficReporter
    public boolean onGlobalFdsTrafficReport(Set<TrafficReportBean> set, long j3, long j16, long j17, long j18, boolean z16) {
        long f16;
        boolean z17;
        if (set != null && !set.isEmpty()) {
            QLog.d("NativeTrafficMonitorReporter", 1, "onGlobalFdsTrafficReport, fetch fd size=" + set.size() + ", mobileSumTraffic: " + j3 + ", wifiSumTraffic: " + j16 + ", bgMobileSumTraffic: " + j17 + ", bgWifiSumTraffic: " + j18 + " isReportMobileTraffic=" + z16);
            ArrayList arrayList = new ArrayList(set);
            Collections.sort(arrayList, new a(z16));
            com.tencent.mobileqq.data.nativemonitor.traffic.a aVar = NativeTrafficMonitorHelper.b().f203168a;
            if (z16) {
                f16 = aVar.b();
            } else {
                f16 = aVar.f();
            }
            if (!z16) {
                j3 = j16;
            }
            if (j3 >= f16) {
                z17 = true;
            } else {
                z17 = false;
            }
            Iterator<TrafficReportBean> it = arrayList.iterator();
            boolean z18 = false;
            while (it.hasNext() && !(z18 = d(it.next()))) {
            }
            QLog.d("NativeTrafficMonitorReporter", 1, "onGlobalFdsTrafficReport globalSumTraffic: " + j3 + ", isReportMobileTraffic: " + z16 + ", isReport: " + z17 + ", isInBlackList: " + z18 + ", fdsDetails: " + arrayList);
            if (!z17) {
                return false;
            }
            if (!z18) {
                f(arrayList, z16);
            }
            return true;
        }
        QLog.d("NativeTrafficMonitorReporter", 1, "onGlobalFdsTrafficReport, set is null or empty!");
        return true;
    }

    @Override // com.tencent.mobileqq.nativememorymonitor.library.trafficmonitor.ITrafficReporter
    public void onSingleFdTrafficReport(TrafficReportBean trafficReportBean) {
        boolean z16;
        long n3;
        long j3;
        long j16;
        if (trafficReportBean == null) {
            QLog.d("NativeTrafficMonitorReporter", 1, "onSingleFdTrafficReport, trafficReportBean is null!");
            return;
        }
        com.tencent.mobileqq.data.nativemonitor.traffic.a aVar = NativeTrafficMonitorHelper.b().f203168a;
        boolean z17 = false;
        if (trafficReportBean.trafficAlertType <= 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            n3 = aVar.h();
        } else {
            n3 = aVar.n();
        }
        if (z16) {
            j3 = trafficReportBean.mobileUpLoadTraffic;
            j16 = trafficReportBean.mobileDownLoadTraffic;
        } else {
            j3 = trafficReportBean.wifiUploadTraffic;
            j16 = trafficReportBean.wifiDownLoadTraffic;
        }
        long j17 = j3 + j16;
        if (j17 >= n3) {
            z17 = true;
        }
        boolean d16 = d(trafficReportBean);
        QLog.d("NativeTrafficMonitorReporter", 1, "onSingleFdTrafficReport sumTraffic: " + j17 + ", isReportMobileTraffic: " + z16 + ", isReport: " + z17 + ", isInBlackList: " + d16 + ", trafficReportBean: " + trafficReportBean);
        if (z17 && !d16) {
            g(trafficReportBean);
        }
    }
}
