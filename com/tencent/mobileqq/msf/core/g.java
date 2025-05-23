package com.tencent.mobileqq.msf.core;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class g {
    static IPatchRedirector $redirector_;

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String[] split = str.split(":");
        StringBuilder sb5 = new StringBuilder();
        int i3 = -1;
        boolean z16 = false;
        for (int i16 = 0; i16 < split.length; i16++) {
            String str2 = split[i16];
            char[] charArray = str2.toCharArray();
            int i17 = 0;
            for (int i18 = 0; i18 < charArray.length - 1 && charArray[i18] == '0'; i18++) {
                i17++;
            }
            if (i17 > 0) {
                str2 = str2.substring(i17);
            }
            if (!z16) {
                if ("0".equals(str2)) {
                    if (i3 == -1) {
                        sb5.append(":");
                        i3 = i16;
                    }
                } else {
                    sb5.append(str2);
                    if (i16 < split.length - 1) {
                        sb5.append(":");
                    }
                    if (i3 != -1) {
                        z16 = true;
                    }
                }
            } else {
                sb5.append(str2);
                if (i16 < split.length - 1) {
                    sb5.append(":");
                }
            }
        }
        return sb5.toString();
    }
}
