package cooperation.qzone.util;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QZoneTeenOnlineTimeHelper {
    public static final int DEFAULT_TEEN_TIME_LIMIT_STATUS = 0;
    public static final String KEY_TEEN_PWD_VERIFY_LAST_TIME = "teen_password_validation_last_time";
    public static final String KEY_TEEN_TIME_LIMIT_STATUS = "teen_online_time_limit";
    private static final String TAG = "QZoneTeenOnlineTimeUtil";
    public static final String TEEN_PSW_VERIFY_FAIL = "fail";
    public static final String TEEN_PSW_VERIFY_RESULT_ACTION = "com.tencent.studymode.pwdverify";
    public static final String TEEN_PSW_VERIFY_SUCCESS = "success";

    public static boolean isForbidEnterQZone(long j3) {
        int int4Uin = LocalMultiProcConfig.getInt4Uin(KEY_TEEN_TIME_LIMIT_STATUS, 0, j3);
        boolean isVerifiedPswToday = isVerifiedPswToday(j3);
        QLog.d(TAG, 2, "uin=" + j3 + ", limitStatus=" + int4Uin + "isPswVerifyCorrect=" + isVerifiedPswToday);
        if (int4Uin != 1 || isVerifiedPswToday) {
            return false;
        }
        return true;
    }

    public static boolean isVerifiedPswToday(long j3) {
        boolean isSameDay = DateUtils.isSameDay(System.currentTimeMillis(), LocalMultiProcConfig.getLong4Uin(KEY_TEEN_PWD_VERIFY_LAST_TIME, 0L, j3));
        QLog.d(TAG, 2, "uin=" + j3 + ", isPswVerifyCorrect=" + isSameDay);
        return isSameDay;
    }

    public static void savePswVerifyCorrectTime(long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        QLog.d(TAG, 1, "savePswVerifyCorrectTime uin=" + j3 + ", time=" + currentTimeMillis);
        LocalMultiProcConfig.putLong4Uin(KEY_TEEN_PWD_VERIFY_LAST_TIME, currentTimeMillis, j3);
    }
}
