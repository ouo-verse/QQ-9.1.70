package cooperation.qzone.report;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import common.config.service.QzoneConfig;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QzoneLbsReporter {
    private static final String TAG = "QzoneLbsReporter";

    public static void reportLocationCacheResult(boolean z16, String str) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            if (System.currentTimeMillis() % 1000 < QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QZONE_LOCATION_CACHE_SAMPLE_RATE, 1, false)) {
                String account = peekAppRuntime.getAccount();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_businessId", str);
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(account, "QzoneNewLocationCache", z16, 0L, 0L, hashMap, "");
            }
        }
    }

    public static void reportLocationResult(int i3, String str, long j3) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            boolean z16 = true;
            if (System.currentTimeMillis() % 1000 < QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QZONE_LOCATION_SAMPLE_RATE, 1)) {
                String account = peekAppRuntime.getAccount();
                HashMap<String, String> hashMap = new HashMap<>();
                hashMap.put("param_FailCode", Integer.toString(i3));
                hashMap.put("param_businessId", str);
                StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
                if (i3 != 0) {
                    z16 = false;
                }
                statisticCollector.collectPerformance(account, "QzoneNewLocation", z16, j3, 0L, hashMap, "");
            }
        }
    }
}
