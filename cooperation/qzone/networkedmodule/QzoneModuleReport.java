package cooperation.qzone.networkedmodule;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.Calendar;
import java.util.HashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes38.dex */
public class QzoneModuleReport {
    private static final int DEFAULT_QZONE_MODULE_REPORT_SAMPLE = 100;
    private static final String FAILURE_CODE = "0";
    public static final String QZONE_MODULE_RESOVLE_CLASS_FAILED = "0";
    public static final String QZONE_MODULE_RESOVLE_CLASS_LOAD_SO_FAILED = "-1";
    public static final String QZONE_MODULE_RESOVLE_CLASS_SUCCESS = "1";
    private static final String SUCCESS_CODE = "1";
    private static final String TAG = "QzoneModuleReport";
    private static boolean sNeedReport = false;
    private static long sampleValidEndTime;
    private static long sampleValidStartTime;

    private static long getSpecifiedTimeInMillis(int i3, int i16, int i17, int i18, int i19, int i26) {
        Calendar calendar = Calendar.getInstance();
        if (i3 > 0) {
            calendar.set(1, i3);
        }
        if (i16 > 0) {
            calendar.set(2, i16);
        }
        if (i17 > 0) {
            calendar.set(5, i17);
        }
        calendar.set(11, i18);
        calendar.set(12, i19);
        calendar.set(13, i26);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    private static synchronized boolean isNeedReport() {
        synchronized (QzoneModuleReport.class) {
            long currentTimeMillis = System.currentTimeMillis();
            if (!isTodayTime(currentTimeMillis)) {
                int config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_KEY_QZONE_MODULE_REPORT_SAMPLE, 100);
                long j3 = currentTimeMillis / 86400000;
                long longAccountUin = BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin();
                if (longAccountUin == 0) {
                    return false;
                }
                if (config == 0) {
                    sNeedReport = false;
                } else {
                    long j16 = config;
                    int i3 = (int) (j3 % j16);
                    sNeedReport = ((long) i3) == longAccountUin % j16;
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 4, "----QzoneModule-sample number\uff1a " + i3);
                    }
                }
                sampleValidStartTime = getSpecifiedTimeInMillis(0, 0, 0, 0, 0, 0);
                sampleValidEndTime = getSpecifiedTimeInMillis(0, 0, 0, 24, 0, 0);
            }
            return sNeedReport;
        }
    }

    private static boolean isTodayTime(long j3) {
        long j16 = sampleValidStartTime;
        if (j16 != 0) {
            long j17 = sampleValidEndTime;
            if (j17 != 0 && j3 >= j16 && j3 < j17) {
                return true;
            }
        }
        return false;
    }

    private static void report(final String str, final String str2, final boolean z16, final long j3, final long j16, final HashMap<String, String> hashMap, final String str3) {
        if (!isNeedReport()) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 1, "needn't report");
                return;
            }
            return;
        }
        ThreadManagerV2.post(new Runnable() { // from class: cooperation.qzone.networkedmodule.QzoneModuleReport.1
            @Override // java.lang.Runnable
            public void run() {
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, str2, z16, j3, j16, hashMap, str3);
            }
        }, 5, null, false);
    }

    public static void reportResolveClassRes(QzoneModuleRecord qzoneModuleRecord, String str, long j3) {
        HashMap hashMap = new HashMap();
        hashMap.put("module_id", qzoneModuleRecord.mModuleId);
        hashMap.put(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_URL, qzoneModuleRecord.mUrl);
        hashMap.put(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_VERSION, qzoneModuleRecord.mVersion);
        hashMap.put("resolveClassState", str);
        hashMap.put("param_FailCode", "v" + qzoneModuleRecord.mVersion + "_" + str);
        boolean equalsIgnoreCase = "1".equalsIgnoreCase(str);
        report(BaseApplicationImpl.getApplication().getRuntime().getAccount(), qzoneModuleRecord.mModuleId + "_resolveClassRes", equalsIgnoreCase, j3, 0L, hashMap, "");
    }

    public static void reportDownloadRes(QzoneModuleRecord qzoneModuleRecord, boolean z16, long j3) {
        String str;
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("module_id", qzoneModuleRecord.mModuleId);
        hashMap.put(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_URL, qzoneModuleRecord.mUrl);
        hashMap.put(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_VERSION, String.valueOf(qzoneModuleRecord.mVersion));
        hashMap.put("downloadState", str);
        hashMap.put("param_FailCode", "v" + qzoneModuleRecord.mVersion + "_" + str);
        if (MobileQQ.sMobileQQ.peekAppRuntime() != null) {
            report(MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), qzoneModuleRecord.mModuleId + "_downloadRes", z16, j3, 0L, hashMap, "");
        }
    }

    public static void reportLoadRes(QzoneModuleRecord qzoneModuleRecord, boolean z16, long j3) {
        String str;
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        HashMap hashMap = new HashMap();
        hashMap.put("module_id", qzoneModuleRecord.mModuleId);
        hashMap.put(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_URL, qzoneModuleRecord.mUrl);
        hashMap.put(QzoneModuleConst.QZONE_MODULE_CONFIG_MODULE_VERSION, String.valueOf(qzoneModuleRecord.mVersion));
        hashMap.put("loadState", str);
        hashMap.put("param_FailCode", "v" + qzoneModuleRecord.mVersion + "_" + str);
        String account = BaseApplicationImpl.getApplication().getRuntime().getAccount();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(qzoneModuleRecord.mModuleId);
        sb5.append("_loadRes");
        report(account, sb5.toString(), z16, j3, 0L, hashMap, "");
    }
}
