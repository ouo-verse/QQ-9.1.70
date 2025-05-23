package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Nb4Ck {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static long f381957a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f381958b = 0;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21502);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        TimeUnit timeUnit = TimeUnit.HOURS;
        f381957a = timeUnit.toMillis(1L);
        timeUnit.toMillis(4L);
    }
}
