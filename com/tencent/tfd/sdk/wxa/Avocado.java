package com.tencent.tfd.sdk.wxa;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class Avocado {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static long f375409a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f375410b = 0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62382);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        TimeUnit timeUnit = TimeUnit.HOURS;
        f375409a = timeUnit.toMillis(1L);
        timeUnit.toMillis(4L);
    }
}
