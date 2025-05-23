package com.tencent.avcore.camera.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final AtomicInteger f77477a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13464);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f77477a = new AtomicInteger();
        }
    }

    public static int a() {
        return f77477a.getAndIncrement();
    }
}
