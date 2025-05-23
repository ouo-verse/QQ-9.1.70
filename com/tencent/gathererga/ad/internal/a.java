package com.tencent.gathererga.ad.internal;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    static IPatchRedirector $redirector_;

    public static String a(String str) {
        if (!TextUtils.isEmpty(str)) {
            String b16 = f.b(str, "UTF-8");
            if (TextUtils.isEmpty(b16)) {
                return null;
            }
            return b16.toLowerCase();
        }
        return null;
    }
}
