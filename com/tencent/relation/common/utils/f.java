package com.tencent.relation.common.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.QQTheme;

/* compiled from: P */
/* loaded from: classes25.dex */
public class f {
    static IPatchRedirector $redirector_;

    public static boolean a() {
        com.tencent.relation.common.config.toggle.c cVar = com.tencent.relation.common.config.toggle.c.E;
        if (!cVar.g(false) && (cVar.g(false) || !QQTheme.isNowThemeIsNight())) {
            return false;
        }
        return true;
    }

    public static boolean b() {
        return com.tencent.relation.common.config.toggle.c.E.g(false);
    }
}
