package com.tencent.gathererga.core.internal.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class n {
    static IPatchRedirector $redirector_;

    public static long a(int i3) {
        switch (i3) {
            case 1:
                return 1L;
            case 2:
                return 2L;
            case 3:
                return 4L;
            case 4:
                return 8L;
            case 5:
                return 16L;
            case 6:
                return 32L;
            case 7:
                return 64L;
            case 8:
                return 128L;
            case 9:
                return 256L;
            case 10:
                return 512L;
            case 11:
            case 18:
            default:
                return 0L;
            case 12:
                return 2048L;
            case 13:
                return 4096L;
            case 14:
                return 8192L;
            case 15:
                return 16384L;
            case 16:
                return 32768L;
            case 17:
                return 65536L;
            case 19:
                return 262144L;
            case 20:
                return 524288L;
        }
    }
}
