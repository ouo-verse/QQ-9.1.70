package com.tencent.mobileqq.splash;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Calendar;

/* compiled from: P */
/* loaded from: classes18.dex */
public class g {
    static IPatchRedirector $redirector_;

    public static String a() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return String.valueOf(calendar.getTimeInMillis());
    }
}
