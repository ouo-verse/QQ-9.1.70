package com.tencent.msdk.dns.base.log;

import android.os.Build;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes21.dex */
public final class b implements a {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String b(String str) {
        if (str == null) {
            str = "";
        }
        if (23 < str.length() && 24 > Build.VERSION.SDK_INT) {
            return str.substring(0, 23);
        }
        return str;
    }

    private void c(int i3, String str, String str2, Throwable th5) {
        int min;
        String b16 = b(str);
        if (str2 == null) {
            str2 = "";
        }
        if (th5 != null) {
            str2 = str2 + "\n" + Log.getStackTraceString(th5);
        }
        if (4000 >= str2.length()) {
            Log.println(i3, b16, str2);
            return;
        }
        int length = str2.length();
        int i16 = 0;
        while (i16 < length) {
            int indexOf = str2.indexOf(10, i16);
            if (-1 == indexOf) {
                indexOf = length;
            }
            while (true) {
                min = Math.min(indexOf, i16 + 4000);
                Log.println(i3, b16, str2.substring(i16, min));
                if (min >= indexOf) {
                    break;
                } else {
                    i16 = min;
                }
            }
            i16 = min + 1;
        }
    }

    @Override // com.tencent.msdk.dns.base.log.a
    public void a(int i3, String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, str2, th5);
            return;
        }
        if (i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5 || i3 == 6) {
            c(i3, str, str2, th5);
        }
    }
}
