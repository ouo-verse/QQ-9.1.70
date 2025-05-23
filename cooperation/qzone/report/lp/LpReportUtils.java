package cooperation.qzone.report.lp;

import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import common.config.service.QzoneConfig;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.TimeZone;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportUtils {
    private static final String TAG = "LpReport.LpReportUtils";
    private static boolean isSampled = false;
    private static long sampleValidEndTime;
    private static long sampleValidStartTime;
    public static final String CLICK_MESSAGE = HardCodeUtil.qqStr(R.string.nwg);
    public static final String SAMPLE_REPORT = HardCodeUtil.qqStr(R.string.nwf);
    public static final String ALL_REPORT = HardCodeUtil.qqStr(R.string.nwe);
    public static final String NOT_HIT = HardCodeUtil.qqStr(R.string.nwd);

    public static long getBeijingTimeInMillis(int i3, int i16, int i17) {
        return getBeijingTimeInMillis(0, 0, 0, i3, i16, i17);
    }

    public static int getDaysSince1970() {
        return (int) (((((System.currentTimeMillis() - getBeijingTimeInMillis(1970, 0, 1, 0, 0, 0)) / 1000) / 60) / 60) / 24);
    }

    public static String getMobileType() {
        return Build.BRAND + "_" + Build.DEVICE + "_" + Build.DISPLAY + "_" + Build.HARDWARE + "_" + Build.MANUFACTURER + "_" + DeviceInfoMonitor.getModel() + "_" + Build.PRODUCT;
    }

    public static boolean isNeedReport() {
        if (!isTodayTime(System.currentTimeMillis())) {
            userSample();
        }
        return isSampled;
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

    public static boolean meetCondition(LpReportInfos lpReportInfos, long j3) {
        if (MobileQQ.sProcessId == 1 && ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).isBackgroundPause()) {
            return true;
        }
        long uptimeMillis = SystemClock.uptimeMillis() - j3;
        int config = QzoneConfig.getInstance().getConfig("ClientReport", QzoneConfig.SECONDARY_CLICKREPORT_INTERVAL, 600) * 1000;
        if (lpReportInfos.size() >= QzoneConfig.getInstance().getConfig("ClientReport", QzoneConfig.SECONDARY_CLICKREPORT_COUNT, 50) || (uptimeMillis >= config && lpReportInfos.size() > 0)) {
            return true;
        }
        return false;
    }

    public static void safePut(Map<String, String> map, String str, String str2) {
        if (map == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        map.put(str, str2);
    }

    public static String transMapToStringForLog(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        String[] strArr = {"actiontype", "subactiontype", "reserves", LpReportInfo.KEY_NEW_FEED};
        for (int i3 = 0; i3 < 4; i3++) {
            String str = strArr[i3];
            sb5.append(str);
            sb5.append(":");
            sb5.append(map.get(str));
            sb5.append("\n");
        }
        for (String str2 : map.keySet()) {
            if (!Arrays.asList(strArr).contains(str2)) {
                sb5.append(str2);
                sb5.append(":");
                sb5.append(map.get(str2));
                sb5.append("\n");
            }
        }
        return sb5.toString();
    }

    private static void userSample() {
        long j3;
        int config = QzoneConfig.getInstance().getConfig("ClientReport", QzoneConfig.SECONDARY_CLICKREPORT_SAMPLE, 100);
        long daysSince1970 = getDaysSince1970();
        boolean z16 = true;
        try {
            j3 = ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getLongAccountUin();
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            j3 = 0;
        }
        if (j3 == 0) {
            return;
        }
        if (config == 0) {
            isSampled = false;
        } else {
            long j16 = config;
            int i3 = (int) (daysSince1970 % j16);
            if (i3 != j3 % j16) {
                z16 = false;
            }
            isSampled = z16;
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 4, "\u62bd\u4e2d\u7684\u5c3e\u6570\uff1a " + i3);
            }
        }
        sampleValidStartTime = getBeijingTimeInMillis(0, 0, 0);
        sampleValidEndTime = getBeijingTimeInMillis(24, 0, 0);
    }

    private static long getBeijingTimeInMillis(int i3, int i16, int i17, int i18, int i19, int i26) {
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        if (i3 != 0 || i16 != 0 || i17 != 0) {
            calendar.set(1, i3);
            calendar.set(2, i16);
            calendar.set(5, i17);
        }
        calendar.set(11, i18);
        calendar.set(12, i19);
        calendar.set(13, i26);
        calendar.set(14, 0);
        return calendar.getTimeInMillis();
    }

    public static void safePut(Map<String, String> map, String str, int i3) {
        if (map == null || TextUtils.isEmpty(str)) {
            return;
        }
        map.put(str, String.valueOf(i3));
    }

    public static void showToast(LpReportInfo lpReportInfo, boolean z16) {
    }
}
