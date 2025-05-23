package com.tencent.mobileqq.armap;

import android.content.SharedPreferences;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TimeZone;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes11.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static SimpleDateFormat f199723a;

    /* renamed from: b, reason: collision with root package name */
    static SimpleDateFormat f199724b;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f199725c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70859);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f199723a = null;
        f199724b = null;
        f199725c = false;
    }

    public static long a(String str) {
        long j3;
        if (f199723a == null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_MINUTES_FORMAT, Locale.getDefault());
            f199723a = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
        }
        try {
            j3 = f199723a.parse(str).getTime();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ArMapUtil", 2, "", e16);
            }
            j3 = -1;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ArMapUtil", 2, "data2Millis, date = " + str + ",millis = " + j3);
        }
        return j3;
    }

    public static SharedPreferences b(AppRuntime appRuntime) {
        return appRuntime.getApplication().getSharedPreferences(appRuntime.getAccount() + "sp_ar_map", 4);
    }
}
