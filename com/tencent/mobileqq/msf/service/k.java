package com.tencent.mobileqq.msf.service;

import android.os.Handler;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MSFSharedPreUtils;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class k {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static String f250952a = "MsfExistReporter";

    /* renamed from: b, reason: collision with root package name */
    private static final String f250953b = "SP_MSF_ALIVE_TODAY_ZERO_TIME";

    /* renamed from: c, reason: collision with root package name */
    private static ConcurrentHashMap<String, Long> f250954c = null;

    /* renamed from: d, reason: collision with root package name */
    private static final int f250955d = 0;

    /* renamed from: e, reason: collision with root package name */
    private static final int f250956e = 1;

    /* renamed from: f, reason: collision with root package name */
    private static final int f250957f = 2;

    /* renamed from: g, reason: collision with root package name */
    private static final String f250958g = "sp_report_login";

    /* renamed from: h, reason: collision with root package name */
    private static final String f250959h = "key_report_login_time_millis_today_zero_";

    /* renamed from: i, reason: collision with root package name */
    public static volatile boolean f250960i;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23486);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f250954c = new ConcurrentHashMap<>();
            f250960i = false;
        }
    }

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void a(Handler handler) {
        if (handler != null) {
            try {
                if (handler.hasMessages(10500)) {
                    handler.removeMessages(10500);
                }
                long currentTimeMillis = System.currentTimeMillis();
                long rawOffset = (((((TimeZone.getDefault().getRawOffset() + currentTimeMillis) / 86400000) + 1) * 86400000) - TimeZone.getDefault().getRawOffset()) + new Random().nextInt(3600000) + 1800000;
                handler.sendEmptyMessageDelayed(10500, rawOffset - currentTimeMillis);
                if (QLog.isColorLevel()) {
                    QLog.d(f250952a, 2, "timeZone=" + TimeZone.getDefault().getRawOffset() + ",nextTime=" + rawOffset + ",nowTime=" + currentTimeMillis);
                }
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        if (MsfCore.sCore != null && MsfService.core.isConnected()) {
            a(f250953b, 0);
            List<SimpleAccount> loginedAccountList = MsfSdkUtils.getLoginedAccountList();
            if (loginedAccountList != null && loginedAccountList.size() > 0) {
                for (SimpleAccount simpleAccount : loginedAccountList) {
                    if (simpleAccount.getUin().equals(MsfCore.sCore.getAccountCenter().e())) {
                        a(simpleAccount.getUin() + "_Background", 2);
                        if (QLog.isColorLevel()) {
                            QLog.d(f250952a, 2, "MAIN UIN=" + simpleAccount.getUin() + " status=" + simpleAccount.isLogined());
                        }
                    } else if (QLog.isColorLevel()) {
                        QLog.d(f250952a, 2, "UIN=" + simpleAccount.getUin() + " status=" + simpleAccount.isLogined());
                    }
                }
            } else if (QLog.isColorLevel()) {
                QLog.d(f250952a, 2, "no login account list");
            }
            f250960i = false;
            return;
        }
        f250960i = true;
    }

    private static void a(String str, int i3) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!f250954c.containsKey(str)) {
            if (i3 == 0) {
                f250954c.put(str, Long.valueOf(a()));
            } else if (i3 == 2) {
                f250954c.put(str, Long.valueOf(a(str)));
            }
        }
        if (currentTimeMillis - f250954c.get(str).longValue() < 86400000) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis((currentTimeMillis / 1000) * 1000);
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        long timeInMillis = calendar.getTimeInMillis();
        f250954c.put(str, Long.valueOf(timeInMillis));
        if (i3 == 0) {
            a(timeInMillis);
            com.tencent.mobileqq.msf.core.c0.a.a(MsfCore.sCore, "start_up", "backstage", "device_cnt", "", 1, "");
        } else if (i3 == 2) {
            a(str, timeInMillis);
            com.tencent.mobileqq.msf.core.c0.a.a(MsfCore.sCore, "login", "msf", "login", "", 1, "");
        }
        if (QLog.isColorLevel()) {
            QLog.d(f250952a, 2, "Daily Report info key=" + str + " timeMillisInTodayZero=" + timeInMillis + " nowTime=" + currentTimeMillis + "sNeedReportMSFAlive=" + f250960i);
        }
    }

    private static long a() {
        return MsfService.getCore().getSharedPreferences(j.f250946u, 0).getLong(f250953b, 0L);
    }

    private static void a(long j3) {
        MsfService.getCore().getSharedPreferences(j.f250946u, 0).edit().putLong(f250953b, j3).apply();
    }

    private static long a(String str) {
        return MSFSharedPreUtils.getLoginTimeMillisInTodayZero(str);
    }

    private static void a(String str, long j3) {
        MSFSharedPreUtils.setLoginTimeMillisInTodayZero(str, j3);
    }
}
