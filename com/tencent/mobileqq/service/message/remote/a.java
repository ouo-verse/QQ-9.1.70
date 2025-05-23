package com.tencent.mobileqq.service.message.remote;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static String a(int i3) {
        if (i3 != 32768) {
            if (i3 != 32770) {
                if (i3 != 32772) {
                    return "Default";
                }
                return "Sending";
            }
            return "Success";
        }
        return "Fail";
    }

    public static boolean b(int i3) {
        if (1 == i3 || 2 == i3) {
            return true;
        }
        return false;
    }

    public static boolean c(int i3) {
        if (1 == i3) {
            return true;
        }
        return false;
    }

    public static boolean d(int i3) {
        if (2 == i3) {
            return true;
        }
        return false;
    }
}
