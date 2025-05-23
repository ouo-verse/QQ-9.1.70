package com.tencent.mobileqq.msf.sdk;

import com.tencent.mobileqq.msf.core.net.NetContants;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;

/* loaded from: classes15.dex */
public class MSFSharedPreUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String KEY_MSF_GUID = "msf_guid";
    private static final String KEY_REPORT_LOGIN_TIME_MILLIS_TODAY_ZERO = "key_report_login_time_millis_today_zero_";
    private static final String SP_REPORT_LOGIN_STATUS = "sp_report_login";
    public static final String TAG = "MSFSharedPreUtils";

    public MSFSharedPreUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getGuid() {
        String string = MsfService.getCore().getSharedPreferences(NetContants.SharePref.SP_MSF_COMMON, 4).getString(KEY_MSF_GUID, "");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[getGuid], guid = " + string);
        }
        return string;
    }

    public static long getLoginTimeMillisInTodayZero(String str) {
        long j3 = MsfService.getCore().getSharedPreferences(SP_REPORT_LOGIN_STATUS, 4).getLong(KEY_REPORT_LOGIN_TIME_MILLIS_TODAY_ZERO + str, 0L);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[getLoginTimeMillisInTodayZero], account = " + str + ", time = " + j3);
        }
        return j3;
    }

    public static void setLoginTimeMillisInTodayZero(String str, long j3) {
        MsfService.getCore().getSharedPreferences(SP_REPORT_LOGIN_STATUS, 4).edit().putLong(KEY_REPORT_LOGIN_TIME_MILLIS_TODAY_ZERO + str, j3).apply();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[setLoginTimeMillisInTodayZero], account = " + str + ", time = " + j3);
        }
    }
}
