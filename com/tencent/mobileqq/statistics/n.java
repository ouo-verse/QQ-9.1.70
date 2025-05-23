package com.tencent.mobileqq.statistics;

import NS_MOBILE_EXTRA.mobile_get_qzone_public_msg_rsp;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.observer.QZoneObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_dc02880;
import cooperation.qzone.report.lp.LpReportManager;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class n {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static int f290050a;

    /* renamed from: b, reason: collision with root package name */
    private static int f290051b;

    /* renamed from: c, reason: collision with root package name */
    private static AtomicInteger f290052c;

    /* renamed from: d, reason: collision with root package name */
    public static int f290053d;

    /* renamed from: e, reason: collision with root package name */
    private static AtomicBoolean f290054e;

    /* renamed from: f, reason: collision with root package name */
    private static AtomicLong f290055f;

    /* renamed from: g, reason: collision with root package name */
    private static long f290056g;

    /* renamed from: h, reason: collision with root package name */
    private static int f290057h;

    /* renamed from: i, reason: collision with root package name */
    private static int f290058i;

    /* renamed from: j, reason: collision with root package name */
    private static Calendar f290059j;

    /* renamed from: k, reason: collision with root package name */
    private static a f290060k;

    /* renamed from: l, reason: collision with root package name */
    public static boolean f290061l;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    static class a extends QZoneObserver {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.observer.QZoneObserver
        protected void j(boolean z16, Bundle bundle) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), bundle);
                return;
            }
            Serializable serializable = bundle.getSerializable("data");
            if (!z16 || serializable == null || !(serializable instanceof mobile_get_qzone_public_msg_rsp)) {
                n.f290058i++;
                if (QLog.isColorLevel()) {
                    QLog.w("QZoneReport", 2, "qzone report failed");
                }
            } else {
                int decrementAndGet = n.f290052c.decrementAndGet();
                n.f290058i = 0;
                AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                runtime.getPreferences().edit().putInt(runtime.getAccount() + "_qzone_xp_req_left", decrementAndGet).apply();
                n.f290051b = ((mobile_get_qzone_public_msg_rsp) serializable).next_req_tmstamp;
                if (QLog.isColorLevel()) {
                    QLog.i("QZoneReport", 2, "next req time: " + n.f290051b + ", left: " + decrementAndGet);
                }
                ReportController.o(null, "CliOper", "", "", "0X800915D", "0X800915D", 0, 0, "", "", "", "");
            }
            n.f290054e.set(false);
            BaseApplicationImpl.getApplication().getRuntime().unRegistObserver(n.f290060k);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75427);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f290050a = 2;
        f290052c = new AtomicInteger(2);
        f290053d = 3;
        f290054e = new AtomicBoolean(false);
        f290055f = new AtomicLong();
        f290059j = Calendar.getInstance();
        f290060k = new a();
        f290061l = false;
    }

    public static void h() {
        f290056g = 0L;
    }

    public static void i(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config, int i3, String str) {
        int i16 = configurationService$Config.version.get();
        int P1 = ea.P1(qQAppInterface.getApp(), AppConstants.Preferences.QZONE_XP_CONFIG_VERSION, str);
        if (QLog.isColorLevel()) {
            QLog.i("QZoneReport", 2, String.format(Locale.getDefault(), "received qzone xp Config remote version: %d, localVersion: %d", Integer.valueOf(i16), Integer.valueOf(P1)));
        }
        if (i16 != P1) {
            String F = ConfigServlet.F(configurationService$Config, P1, i3);
            if (!TextUtils.isEmpty(F)) {
                if (QLog.isColorLevel()) {
                    QLog.i("QZoneReport", 2, "receiveAllConfigs|type: " + i3 + ",content: " + F + ",version: " + i16);
                }
                try {
                    int max = Math.max(0, f290050a - f290052c.get());
                    JSONObject jSONObject = new JSONObject(F);
                    int optInt = jSONObject.optInt("maxReq", 2);
                    f290050a = optInt;
                    f290052c.set(Math.max(0, optInt - max));
                    f290053d = jSONObject.optInt("reqGap", 3);
                    BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt(str + "_qzone_xp_max_req", f290050a).putInt(str + "_qzone_xp_req_gap", f290053d).putInt(str + "_qzone_xp_req_left", f290052c.get()).apply();
                } catch (JSONException e16) {
                    if (QLog.isDevelopLevel()) {
                        e16.printStackTrace();
                    }
                }
                ea.l5(qQAppInterface.getApp(), AppConstants.Preferences.QZONE_XP_CONFIG_VERSION, str, i16);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("QZoneReport", 2, "config is null");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("QZoneReport", 2, "config version not updated, nothing to do");
        }
    }

    public static void j(boolean z16) {
        String str;
        if (!QzoneConfig.getInstance().isNewStylePublicAccountPage()) {
            return;
        }
        LpReportInfo_dc02880 lpReportInfo_dc02880 = new LpReportInfo_dc02880(12, 2);
        if (z16) {
            str = "1";
        } else {
            str = "0";
        }
        lpReportInfo_dc02880.reserves3 = str;
        LpReportManager.getInstance().reportToDC02880(lpReportInfo_dc02880, false, false);
    }

    public static void k(int i3) {
        if (i3 == 1 && f290061l) {
            return;
        }
        if (i3 == 1) {
            f290061l = true;
        }
        LpReportManager.getInstance().reportToDC02880(new LpReportInfo_dc02880(6, i3), false, false);
    }

    public static int l() {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        String account = runtime.getAccount();
        if (TextUtils.isEmpty(account)) {
            if (QLog.isColorLevel()) {
                QLog.w("QZoneReport", 2, "qzone report with empty account");
            }
            return -1;
        }
        if (!((IPublicAccountDataManager) runtime.getRuntimeService(IPublicAccountDataManager.class, "all")).isFollowedUin(Long.valueOf(Long.parseLong(AppConstants.VALUE.UIN_QZONE)))) {
            if (QLog.isColorLevel()) {
                QLog.w("QZoneReport", 2, "haven't yet follow qzone");
            }
            return -1;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        if (f290056g == 0) {
            SharedPreferences preferences = BaseApplicationImpl.getApplication().getRuntime().getPreferences();
            f290050a = preferences.getInt(account + "_qzone_xp_max_req", 2);
            f290056g = preferences.getLong(account + "_qzone_xp_first_req", serverTime);
            f290052c.set(preferences.getInt(account + "_qzone_xp_req_left", f290050a));
            f290053d = preferences.getInt(account + "_qzone_xp_req_gap", 3);
            f290059j.setTimeInMillis(f290056g * 1000);
            f290057h = f290059j.get(5);
            f290058i = 0;
            f290054e.set(false);
        }
        if (f290058i < 5 && !f290054e.get()) {
            long j3 = serverTime * 1000;
            f290059j.setTimeInMillis(j3);
            if (f290059j.get(5) != f290057h) {
                f290056g = serverTime;
                f290052c.set(f290050a);
                BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit().putInt(account + "_qzone_xp_req_left", f290050a).putLong(account + "_qzone_xp_first_req", f290056g).apply();
            }
            if (f290052c.get() <= 0) {
                if (QLog.isColorLevel()) {
                    QLog.w("QZoneReport", 2, "left: 0");
                }
                Calendar calendar = f290059j;
                calendar.set(5, calendar.get(5) + 1);
                f290059j.set(11, 0);
                f290059j.set(12, 0);
                f290059j.set(13, 0);
                return (int) ((f290059j.getTimeInMillis() - j3) / 1000);
            }
            return Math.max(0, (int) (f290051b - serverTime));
        }
        if (QLog.isColorLevel()) {
            QLog.w("QZoneReport", 2, "retry: " + f290058i + ", sending: " + f290054e.get());
            return -1;
        }
        return -1;
    }
}
