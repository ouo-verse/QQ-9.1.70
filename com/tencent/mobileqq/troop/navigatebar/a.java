package com.tencent.mobileqq.troop.navigatebar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class a {
    static IPatchRedirector $redirector_;

    public static long a(int i3, long j3, long j16) {
        if (b(i3)) {
            return j3;
        }
        return j16;
    }

    protected static boolean b(int i3) {
        if (i3 == 1 || i3 == 22 || i3 == 17 || i3 == 100 || i3 == 11 || i3 == 10) {
            return true;
        }
        return false;
    }
}
