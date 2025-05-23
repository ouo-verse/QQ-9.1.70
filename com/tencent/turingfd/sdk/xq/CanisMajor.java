package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CanisMajor {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final AtomicBoolean f382623a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10978);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
        } else {
            new AtomicInteger(0);
            f382623a = new AtomicBoolean(false);
        }
    }
}
