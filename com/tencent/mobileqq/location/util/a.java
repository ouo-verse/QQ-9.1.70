package com.tencent.mobileqq.location.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermission;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String[] f241701a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29352);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f241701a = new String[]{"android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION"};
        }
    }

    public static boolean a(QQPermission qQPermission) {
        if (qQPermission == null) {
            return true;
        }
        if (qQPermission.hasPermission("android.permission.ACCESS_FINE_LOCATION") != 0 && qQPermission.hasPermission("android.permission.ACCESS_COARSE_LOCATION") != 0) {
            return true;
        }
        return false;
    }
}
