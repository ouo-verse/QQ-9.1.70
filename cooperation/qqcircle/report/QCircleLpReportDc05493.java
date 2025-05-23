package cooperation.qqcircle.report;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QCircleLpReportDc05493 {
    public static final int ENTRANCE_FROM_INVITE = 10;
    public static final int ENTRANCE_FROM_QQ_AIO = 6;
    public static final int ENTRANCE_FROM_QQ_DYNAMIC_PAGE = 3;
    public static final int ENTRANCE_FROM_QQ_MAIN_TAB = 11;
    public static final int ENTRANCE_FROM_QQ_MESSAGE_PAGE = 4;
    public static final int ENTRANCE_FROM_QQ_PROFILE_CARD = 5;
    public static final int ENTRANCE_FROM_QQ_PUSH = 7;
    public static final int ENTRANCE_FROM_QQ_SETTING = 9;
    public static final int ENTRANCE_FROM_SCHEMA = 8;
    public static final int ENTRANCE_FROM_WX_AIO = 1;
    public static final int ENTRANCE_FROM_WX_CIRCLE = 2;
    public static final String KEY_EXT_1 = "ext1";
    public static final String KEY_EXT_2 = "ext2";
    public static final String KEY_EXT_3 = "ext3";
    public static final String KEY_EXT_4 = "ext4";
    public static final String KEY_EXT_5 = "ext5";
    public static final String KEY_EXT_6 = "ext6";
    public static final String KEY_LOGIN_ENTRANCE = "login_entrance";
    public static final String KEY_LOGIN_SUB_ENTRANCE = "sub_entrance";
    public static final String KEY_LOGIN_THIRD_ENTRANCE = "thr_entrance";
    public static final String KEY_LOGIN_TIME = "login_time";
    public static final String KEY_REPORT_FROM = "report_from";
    public static final String KEY_TOUIN = "touin";
    private static final Map<Integer, Integer> SUB_ENTRANCE_TO_LOGIN_ENTRANCE_MAP = new HashMap<Integer, Integer>() { // from class: cooperation.qqcircle.report.QCircleLpReportDc05493.1
        {
            put(1, 1);
            put(2, 1);
            put(3, 2);
            put(4, 2);
            put(5, 2);
            put(6, 2);
            put(7, 2);
            put(8, 3);
            put(9, 2);
            put(10, 1);
            put(11, 2);
            put(12, 2);
            put(13, 2);
            put(14, 2);
        }
    };
    private static final String TAG = "QCircleLpReportDc05493";

    static /* synthetic */ int access$000() {
        return getDcId();
    }

    private static int getDcId() {
        return 5493;
    }

    private static int getLoginEntranceWithSubEntrance(String str, int i3, int i16) {
        Integer num = SUB_ENTRANCE_TO_LOGIN_ENTRANCE_MAP.get(Integer.valueOf(i16));
        if (num == null) {
            QLog.e("QCircleReportHelper_QCircleLpReportDc05493", 1, "QCircle launch report invalid input fromStr:!" + str);
            return i3;
        }
        return num.intValue();
    }

    public static void report(String str, String str2, String str3, long j3, int i3) {
        report(str, str2, str3, j3, i3, "", "");
    }

    public static void report(String str, String str2, String str3, long j3, int i3, String str4, String str5) {
        int i16;
        long j16;
        int loginEntranceWithSubEntrance;
        try {
            i16 = Integer.parseInt(str2);
        } catch (Exception e16) {
            QLog.e("QCircleReportHelper_QCircleLpReportDc05493", 1, "QCircle launch report invalid input fromStr:" + str2 + e16.toString());
            i16 = 0;
        }
        if (!TextUtils.isEmpty(str3) && TextUtils.isDigitsOnly(str3)) {
            try {
                j16 = Long.parseLong(str3);
            } catch (Exception unused) {
                QLog.e("QCircleReportHelper_QCircleLpReportDc05493", 1, "QCircle launch report invalid input pushId:" + str3);
            }
            long j17 = j16;
            loginEntranceWithSubEntrance = getLoginEntranceWithSubEntrance(str2, 0, i16);
            if (i16 == 6 && (j17 == 1 || j17 == 2 || j17 == 3)) {
                loginEntranceWithSubEntrance = 3;
            }
            report(str, loginEntranceWithSubEntrance, i16, j17, j3, "", "", str4, str5, "", "", i3);
        }
        j16 = 0;
        long j172 = j16;
        loginEntranceWithSubEntrance = getLoginEntranceWithSubEntrance(str2, 0, i16);
        if (i16 == 6) {
            loginEntranceWithSubEntrance = 3;
        }
        report(str, loginEntranceWithSubEntrance, i16, j172, j3, "", "", str4, str5, "", "", i3);
    }

    private static void report(final String str, final long j3, final long j16, final long j17, final long j18, final String str2, final String str3, final String str4, final String str5, final String str6, final String str7, final int i3) {
        QCircleReporter.getInstance().getReportHandler().post(new Runnable() { // from class: cooperation.qqcircle.report.QCircleLpReportDc05493.2
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList(Arrays.asList(QCircleReportHelper.newEntry("touin", str), QCircleReportHelper.newEntry("login_time", String.valueOf(j18)), QCircleReportHelper.newEntry(QCircleLpReportDc05493.KEY_LOGIN_ENTRANCE, String.valueOf(j3)), QCircleReportHelper.newEntry(QCircleLpReportDc05493.KEY_LOGIN_SUB_ENTRANCE, String.valueOf(j16)), QCircleReportHelper.newEntry(QCircleLpReportDc05493.KEY_LOGIN_THIRD_ENTRANCE, String.valueOf(j17)), QCircleReportHelper.newEntry("report_from", "1"), QCircleReportHelper.newEntry("ext1", str2), QCircleReportHelper.newEntry("ext2", str3), QCircleReportHelper.newEntry("ext3", str4), QCircleReportHelper.newEntry("ext4", str5), QCircleReportHelper.newEntry("ext5", str6), QCircleReportHelper.newEntry("ext6", str7)));
                arrayList.addAll(QCircleReportHelper.getInstance().newBaseEntries());
                QCircleReporter.getInstance().add(QCircleReportHelper.newSingleDcData(QCircleLpReportDc05493.access$000(), arrayList, null, QCircleReportHelper.getInstance().newSessionEntries(i3)), true);
            }
        });
    }
}
