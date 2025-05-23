package com.tencent.mobileqq.service.profile;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static int a(int i3) {
        if (i3 == 0) {
            return 0;
        }
        return i3 & 255;
    }

    public static int b(int i3) {
        if (i3 == 0) {
            return 0;
        }
        return (i3 & 65280) >> 8;
    }
}
