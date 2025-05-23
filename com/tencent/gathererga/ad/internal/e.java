package com.tencent.gathererga.ad.internal;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class e {
    static IPatchRedirector $redirector_;

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                String b16 = f.b(str.replaceAll(":", "").toUpperCase(), "UTF-8");
                if (TextUtils.isEmpty(b16)) {
                    return null;
                }
                return b16.toLowerCase();
            } catch (Throwable th5) {
                com.tencent.gathererga.core.internal.util.d.b(th5.getMessage());
                return str;
            }
        }
        return null;
    }
}
