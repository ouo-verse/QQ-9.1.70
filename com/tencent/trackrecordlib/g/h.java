package com.tencent.trackrecordlib.g;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes26.dex */
public class h {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name */
    private static final String f381147a = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    /* renamed from: b, reason: collision with root package name */
    private static final String f381148b = "yyyyMMddHH";

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String a() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f381147a, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date());
    }

    public static String b() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f381148b, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date());
    }

    public static String a(Date date) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(f381147a, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(date);
    }
}
