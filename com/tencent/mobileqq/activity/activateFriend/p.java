package com.tencent.mobileqq.activity.activateFriend;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes9.dex */
public class p {
    static IPatchRedirector $redirector_;

    public static String a(long j3, String str) {
        try {
            return new SimpleDateFormat(str, Locale.SIMPLIFIED_CHINESE).format(new Date(j3));
        } catch (Exception unused) {
            return "";
        }
    }

    private static boolean b(long j3, String str) {
        Date date = new Date(j3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.SIMPLIFIED_CHINESE);
        if (simpleDateFormat.format(date).equals(simpleDateFormat.format(new Date(NetConnInfoCenter.getServerTimeMillis())))) {
            return true;
        }
        return false;
    }

    public static boolean c(long j3) {
        return b(j3, "MM-dd");
    }

    public static boolean d(long j3) {
        Date date = new Date(NetConnInfoCenter.getServerTimeMillis());
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(5, 1);
        Date time = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd", Locale.SIMPLIFIED_CHINESE);
        return TextUtils.equals(simpleDateFormat.format(time), simpleDateFormat.format(new Date(j3)));
    }
}
