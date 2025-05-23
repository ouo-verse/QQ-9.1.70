package com.tencent.mobileqq.activity.contacts.friend;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static int a(int i3, int i16, int i17) {
        com.tencent.mobileqq.friend.status.a c16 = com.tencent.mobileqq.friend.status.a.c();
        if (i3 == 0) {
            if (i16 != 69378 && i16 != 73474 && i16 != 73730) {
                if (1 != c16.b(i16, 1)) {
                    return 2;
                }
            } else {
                return 0;
            }
        }
        if (1 != c16.b(i16, 1)) {
            if (i17 == 1) {
                return 1;
            }
            if (i17 == 2) {
                return 2;
            }
            int i18 = 3;
            if (i17 != 3) {
                i18 = 4;
                if (i17 != 4) {
                    if (i17 == 7) {
                        return 7;
                    }
                    if (i17 == 8) {
                        return 8;
                    }
                    if (i17 == 9) {
                        return 9;
                    }
                    if (i17 == 12) {
                        return 5;
                    }
                }
            }
            return i18;
        }
        if (i17 == 7 || i17 == 8 || i17 == 9) {
            if (i17 == 7) {
                return 7;
            }
            if (i17 == 8) {
                return 8;
            }
            if (i17 == 9) {
                return 9;
            }
        }
        return i3;
    }
}
