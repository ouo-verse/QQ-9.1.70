package com.tencent.mobileqq.springhb;

import android.text.TextUtils;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.springhb.entry.model.TimeInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes18.dex */
public class ad {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static String f288965a;

    /* renamed from: b, reason: collision with root package name */
    public static String f288966b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(75257);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f288965a = "spring_festival_hb_offline_donwload_cnt";
            f288966b = "spring_festival_hb_offline_donwload_ts";
        }
    }

    public static TimeInfo a(TimeInfo timeInfo, long j3) {
        TimeInfo newEmpty = TimeInfo.newEmpty();
        if (j3 > 0) {
            long j16 = timeInfo.end;
            newEmpty.begin = j16 - j3;
            newEmpty.end = j16 + j3;
        }
        return newEmpty;
    }

    public static TimeInfo b(TimeInfo timeInfo, long j3) {
        TimeInfo newEmpty = TimeInfo.newEmpty();
        if (j3 > 0) {
            newEmpty.begin = timeInfo.begin - j3;
            newEmpty.end = timeInfo.begin + j3;
        }
        return newEmpty;
    }

    public static int c() {
        switch (NetworkUtil.getNetworkType(BaseApplication.getContext())) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 5;
            case 3:
                return 4;
            case 4:
                return 3;
            case 5:
                return 6;
            case 6:
                return 7;
            default:
                return 0;
        }
    }

    public static long d(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            simpleDateFormat.setCalendar(new GregorianCalendar());
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone(DateUtil.TIME_ZONE_8));
            return simpleDateFormat.parse(str).getTime();
        } catch (Exception e16) {
            QLog.e("springHb_Utils", 1, "parseTime exception: " + e16);
            return 0L;
        }
    }
}
