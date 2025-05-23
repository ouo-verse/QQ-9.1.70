package cooperation.qwallet.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qwallet.temp.IQWalletApiProxy;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.sp.QWalletSpFactory;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.impl.QWalletHelperDelegate;
import java.util.HashMap;

/* loaded from: classes28.dex */
public class PatternLockUtils {
    public static final int ALL_FAILED_GAP_TIME = 600;
    public static final int CHECK_PWD_MIN_TIME = 120;
    private static final String KEY_CFT_USER_TYPE = "cft_user_type";
    private static final String KEY_CHECK_INTERVAL_TIME = "check_interval_time";
    private static final String KEY_EXIT_INTERVAL_TIME = "exitinterval_time";
    private static final String KEY_FORGROUND_INTERVAL_TIME = "forground_interval_time";
    private static final String KEY_IS_FIRST_CREATE = "is_first_create";
    private static final String KEY_IS_FIRST_ENTER_AFTER_LOGIN = "isFirstEnterAfterLogin";
    private static final String KEY_IS_NEED_SYNC = "is_need_sync";
    private static final String KEY_IS_NEW_CREATE = "is_new_create";
    private static final String KEY_LAST_UNLOCK_FAILED_TIME = "last_unlock_failed_time";
    private static final String KEY_PWD = "lock_pwd";
    private static final String KEY_PWD_TYPE = "lock_pwd_type";
    private static final String KEY_SHAREPRE_NAME = "qwallet_patternlock";
    private static final String KEY_UNLOCK_FAILED_TIMES = "unlock_failed_times";
    public static final int LENGHT_MIN = 4;
    private static final String TAG = "Q.qwallet.pattern.pattutils";
    public static final int UNLOCK_MAXTIMES = 5;

    public static String encodeToLocalPWD(Context context, String str, String str2) {
        return MD5.toMD5(QWalletHelperDelegate.getQWDevId() + encodeToServerPWD(context, str, str2));
    }

    public static String encodeToServerPWD(Context context, String str, String str2) {
        return MD5.toMD5(MD5.toMD5(str + str2) + str2);
    }

    public static long getCheckIntervalTime(Context context, String str) {
        long j3 = getSharedPreferences(context).getLong(KEY_CHECK_INTERVAL_TIME + str, -1L);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getCheckIntervalTime.uin=" + str + ",checkIntervalTime=" + j3);
        }
        if (j3 < 0) {
            return 120L;
        }
        return j3;
    }

    public static long getForgroundIntervalTime(Context context, String str) {
        long j3 = getSharedPreferences(context).getLong(KEY_FORGROUND_INTERVAL_TIME + str, -1L);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getForgroundIntervalTime.uin=" + str + ",forgroundIntervalTime=" + j3);
        }
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public static long getLastExitWalletTime(Context context, String str) {
        long j3 = getSharedPreferences(context).getLong(KEY_EXIT_INTERVAL_TIME + str, -1L);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getLastExitWalletTime.uin=" + str + ",exitIntervalTime=" + j3);
        }
        if (j3 < 0) {
            return 0L;
        }
        return j3;
    }

    public static long getLastUnlockFailedTime(Context context, String str) {
        long j3 = getSharedPreferences(context).getLong(KEY_LAST_UNLOCK_FAILED_TIME + str, 0L);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getLastUnlockFailedTime.uin=" + str + ",allFailedTime=" + j3);
        }
        return j3;
    }

    public static String getPWD(Context context, String str) {
        String string = getSharedPreferences(context).getString(KEY_PWD + str, "");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getGesturePWD.uin=" + str + ",pw=" + string);
        }
        return string;
    }

    public static int getPWDType(Context context, String str) {
        int i3 = getSharedPreferences(context).getInt(KEY_PWD_TYPE + str, 0);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getGesturePWD.uin=" + str + ",pwdType=" + i3);
        }
        return i3;
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return QWalletSpFactory.a(KEY_SHAREPRE_NAME, 4);
    }

    public static boolean getSyncPatternLockState(Context context, String str) {
        boolean z16 = getSharedPreferences(context).getBoolean(KEY_IS_NEED_SYNC + str, true);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getSyncPatternLockState.uin=" + str + ",isNeedSync=" + z16);
        }
        return z16;
    }

    public static int getUnlockFailedTimes(Context context, String str) {
        int i3 = getSharedPreferences(context).getInt(KEY_UNLOCK_FAILED_TIMES + str, 0);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getUnlockFailedTime.uin=" + str + ",failedTimes=" + i3);
        }
        return i3;
    }

    public static boolean isFirstCreatePatternLock(Context context, String str) {
        boolean z16 = getSharedPreferences(context).getBoolean(KEY_IS_FIRST_CREATE + str, true);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isFirstCreatePatternLock.uin=" + str + ",isFirst=" + z16);
        }
        return z16;
    }

    public static boolean isFirstEnterAfterLogin(Context context, String str) {
        boolean z16 = getSharedPreferences(context).getBoolean(KEY_IS_FIRST_ENTER_AFTER_LOGIN + str, true);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isFirstEnterAfterLogin.uin=" + str + ",isFirstEnterAfterLogin=" + z16);
        }
        return z16;
    }

    public static boolean isNeedOpenPatternLock(Context context, String str) {
        String pwd;
        if (context == null || TextUtils.isEmpty(str) || (pwd = getPWD(context, str)) == null || pwd.length() <= 0) {
            return false;
        }
        if (isNewCreatePatternLock(context, str) || isFirstEnterAfterLogin(context, str) || getUnlockFailedTimes(context, str) >= 5) {
            return true;
        }
        if (getLastExitWalletTime(context, str) + getCheckIntervalTime(context, str) > NetConnInfoCenter.getServerTimeMillis() / 1000) {
            return false;
        }
        return true;
    }

    public static boolean isNewCreatePatternLock(Context context, String str) {
        boolean z16 = getSharedPreferences(context).getBoolean(KEY_IS_NEW_CREATE + str, false);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "isNewCreatePatternLock.uin=" + str + ",isNew=" + z16);
        }
        return z16;
    }

    public static boolean isOpenQWalletLockWhenJumpToQWallet(Activity activity, BaseQQAppInterface baseQQAppInterface, String str) {
        String[] split;
        if (activity == null || baseQQAppInterface == null || TextUtils.isEmpty(str) || ((IQWalletApiProxy) QRoute.api(IQWalletApiProxy.class)).getAppForground(activity)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (!lowerCase.startsWith("mqqapi://wallet/open?")) {
            return false;
        }
        try {
            split = lowerCase.split("\\?");
        } catch (Exception unused) {
        }
        if (split.length != 2) {
            return false;
        }
        String[] split2 = split[1].split(ContainerUtils.FIELD_DELIMITER);
        HashMap hashMap = new HashMap();
        if (split2 != null) {
            for (String str2 : split2) {
                String[] split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split3 != null && split3.length == 2) {
                    hashMap.put(split3[0], split3[1]);
                }
            }
        }
        String str3 = (String) hashMap.get(ISchemeApi.KEY_IOS_SRC_TYPE);
        String str4 = (String) hashMap.get("viewtype");
        String str5 = (String) hashMap.get("view");
        if (str3 != null && str3.equals("web") && str4 != null && str4.equals("0")) {
            if (str5 != null && !str5.equals("0")) {
                if (!str5.equals("1")) {
                    return false;
                }
            }
            return isPatternLockOpened(activity, baseQQAppInterface.getCurrentAccountUin());
        }
        return false;
    }

    public static boolean isPatternLockOpened(Context context, String str) {
        String pwd = getPWD(context, str);
        if (pwd != null && pwd.length() > 0) {
            return true;
        }
        return false;
    }

    public static void setCheckIntervalTime(Context context, String str, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setCheckIntervalTime.uin=" + str + ",curTime=" + j3);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putLong(KEY_CHECK_INTERVAL_TIME + str, j3);
        edit.apply();
    }

    public static void setFirstCreatePatternLock(Context context, String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setFirstCreatePatternLock.uin=" + str + ",isFirst=" + z16);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putBoolean(KEY_IS_FIRST_CREATE + str, z16);
        edit.commit();
    }

    public static void setFirstEnterAfterLoginState(Context context, String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setFirstEnterAfterLoginState.uin=" + str + ",isFirstState=" + z16);
        }
        getSharedPreferences(context).edit().putBoolean(KEY_IS_FIRST_ENTER_AFTER_LOGIN + str, z16).commit();
        if (z16) {
            setSyncPatternLockState(context, str, true);
        }
    }

    public static void setForgroundIntervalTime(Context context, String str, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setForgroundIntervalTime.uin=" + str + ",curTime=" + j3);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putLong(KEY_FORGROUND_INTERVAL_TIME + str, j3);
        edit.apply();
    }

    public static void setLastExitWalletTime(Context context, String str, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setLastExitWalletTime,curTime=" + j3);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putLong(KEY_EXIT_INTERVAL_TIME + str, j3);
        edit.apply();
    }

    public static void setLastUnlockFailedTime(Context context, String str, long j3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setLastUnlockFailedTime.uin=" + str + ",curTime=" + j3);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putLong(KEY_LAST_UNLOCK_FAILED_TIME + str, j3);
        edit.commit();
    }

    public static void setNewCreatePatternLock(Context context, String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setNewCreatePatternLock.uin=" + str + ",isNew=" + z16);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putBoolean(KEY_IS_NEW_CREATE + str, z16);
        edit.apply();
    }

    public static void setPWD(Context context, String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setGesturePWD.uin=" + str + ",pw=" + str2);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putString(KEY_PWD + str, str2);
        edit.apply();
    }

    public static void setPWDType(Context context, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setGesturePWD.uin=" + str + ",pwdType=" + i3);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putInt(KEY_PWD_TYPE + str, i3);
        edit.apply();
    }

    public static void setSyncPatternLockState(Context context, String str, boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setSyncPatternLockState.uin=" + str + ",isNeedSync=" + z16);
        }
        getSharedPreferences(context).edit().putBoolean(KEY_IS_NEED_SYNC + str, z16).apply();
    }

    public static void setUnlockFailedTimes(Context context, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setUnlockFailedTime.uin=" + str + ",failedTimes=" + i3);
        }
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putInt(KEY_UNLOCK_FAILED_TIMES + str, i3);
        edit.apply();
    }
}
