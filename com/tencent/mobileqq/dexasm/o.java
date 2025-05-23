package com.tencent.mobileqq.dexasm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class o {
    static IPatchRedirector $redirector_;

    public static boolean a(int i3) {
        if ((i3 & (-16)) == 0) {
            return true;
        }
        return false;
    }

    public static boolean b(int i3) {
        if (i3 >= 0 && i3 <= 5) {
            return true;
        }
        return false;
    }
}
