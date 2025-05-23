package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.TimeUnit;

/* loaded from: classes27.dex */
public class Persimmon {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static long f382997a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f382998b = 0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12282);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        TimeUnit timeUnit = TimeUnit.HOURS;
        f382997a = timeUnit.toMillis(1L);
        timeUnit.toMillis(4L);
    }
}
