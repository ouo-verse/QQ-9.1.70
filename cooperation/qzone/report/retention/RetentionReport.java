package cooperation.qzone.report.retention;

import android.text.TextUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReport_Retention_dc03208;
import cooperation.qzone.util.QZLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class RetentionReport {
    public static final String CMD = "qzone_retention_";
    public static final String FUNCTIONID = "function_id";
    public static final int REPORT_LP = 1;
    public static final int REPORT_MTA = 2;
    public static final String TAG = "Retention.Report";
    public static final int WNS_DEFAULTVALUE = 0;
    public static final String WNS_MAINKEY = "ClientReport";
    public static final String WNS_SECONDARYKEY_BLACKLIST = "retention_report_blacklist";
    public static final String WNS_SECONDARYKEY_CHANNEL = "retention_report";
    public static final Set<String> blackCache = new HashSet();

    public static boolean meetConditon(String str) {
        if (blackCache.size() == 0) {
            String config = QzoneConfig.getInstance().getConfig("ClientReport", WNS_SECONDARYKEY_BLACKLIST, "");
            if (!TextUtils.isEmpty(config)) {
                for (String str2 : config.split(",")) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            blackCache.add(str2);
                        } catch (Exception e16) {
                            QZLog.e(TAG, "meetConditon error", e16);
                        }
                    }
                }
            }
        }
        Set<String> set = blackCache;
        if (set.size() > 0 && set.contains(str)) {
            return false;
        }
        return true;
    }

    public static void mtaReport(String str, HashMap<String, String> hashMap) {
        if (hashMap == null) {
            try {
                hashMap = new HashMap<>();
            } catch (Exception e16) {
                QZLog.e(TAG, "\u7edf\u8ba1\u7387\u4e0a\u62a5\u5931\u8d25", e16);
                return;
            }
        }
        HashMap<String, String> hashMap2 = hashMap;
        hashMap2.put(FUNCTIONID, str);
        StatisticCollector.getInstance(MobileQQ.sMobileQQ).collectPerformance(null, CMD + str, true, 0L, 0L, hashMap2, null);
    }

    public static void report(int i3) {
        report(String.valueOf(i3), null);
    }

    public static void report(String str) {
        report(str, null);
    }

    public static void report(String str, HashMap<String, String> hashMap) {
        if (meetConditon(str)) {
            int config = QzoneConfig.getInstance().getConfig("ClientReport", WNS_SECONDARYKEY_CHANNEL, 0);
            if (config == 0 || config == 2) {
                mtaReport(str, hashMap);
            }
            if (config == 0 || config == 1) {
                LpReport_Retention_dc03208.report(str, hashMap);
            }
            if (QZLog.isColorLevel()) {
                QZLog.i(TAG, 2, "RetentionReport, functionid:", str);
                return;
            }
            return;
        }
        if (QZLog.isColorLevel()) {
            QZLog.i(TAG, 2, "not meet condition, functionid:", str);
        }
    }
}
