package com.tencent.msdk.dns.c.e;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f336237a;

    /* renamed from: b, reason: collision with root package name */
    private static final Pattern f336238b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17407);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            f336237a = Pattern.compile("^(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|[1-9])\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)\\.(1\\d{2}|2[0-4]\\d|25[0-5]|[1-9]\\d|\\d)$");
            f336238b = Pattern.compile("([0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,7}:|([0-9a-fA-F]{1,4}:){1,6}:[0-9a-fA-F]{1,4}|([0-9a-fA-F]{1,4}:){1,5}(:[0-9a-fA-F]{1,4}){1,2}|([0-9a-fA-F]{1,4}:){1,4}(:[0-9a-fA-F]{1,4}){1,3}|([0-9a-fA-F]{1,4}:){1,3}(:[0-9a-fA-F]{1,4}){1,4}|([0-9a-fA-F]{1,4}:){1,2}(:[0-9a-fA-F]{1,4}){1,5}|[0-9a-fA-F]{1,4}:((:[0-9a-fA-F]{1,4}){1,6})|:((:[0-9a-fA-F]{1,4}){1,7}|:)|fe80:(:[0-9a-fA-F]{0,4}){0,4}%[0-9a-zA-Z]+|::ffff(:0{1,4})?:((25[0-5]|(2[0-4]|1?[0-9])?[0-9])\\\\.){3}(25[0-5]|(2[0-4]|1?[0-9])?[0-9])|([0-9a-fA-F]{1,4}:){1,4}:((25[0-5]|(2[0-4]|1?[0-9])?[0-9])\\\\.){3}(25[0-5]|(2[0-4]|1?[0-9])?[0-9])");
        }
    }

    private static String a(String str) {
        if (str.contains(":")) {
            return str.substring(str.indexOf(":") + 1);
        }
        return str;
    }

    public static boolean b(String str) {
        String a16 = a(str);
        if (!TextUtils.isEmpty(a16) && f336237a.matcher(a16).matches()) {
            return true;
        }
        return false;
    }

    public static boolean c(String str) {
        String a16 = a(str);
        if ((!TextUtils.isEmpty(str) && f336238b.matcher(str).matches()) || (!TextUtils.isEmpty(a16) && f336238b.matcher(a16).matches())) {
            return true;
        }
        return false;
    }
}
