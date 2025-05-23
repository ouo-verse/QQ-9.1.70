package com.tencent.mobileqq.activity.miniaio;

import com.tencent.commonsdk.util.notification.NotificationLimiterUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes10.dex */
public class l {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static boolean f183505a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68586);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f183505a = false;
        }
    }

    public static void a() {
        f183505a = true;
        NotificationLimiterUtil.setLimiter(new com.tencent.util.notification.b());
    }
}
