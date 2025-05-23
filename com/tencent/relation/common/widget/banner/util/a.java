package com.tencent.relation.common.widget.banner.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static int a(boolean z16, int i3, int i16) {
        if (!z16) {
            return i3;
        }
        if (i3 == 0) {
            return i16 - 1;
        }
        if (i3 == i16 + 1) {
            return 0;
        }
        return i3 - 1;
    }
}
