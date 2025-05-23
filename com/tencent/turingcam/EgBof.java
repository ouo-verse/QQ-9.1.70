package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.turingcam.HnGHR;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class EgBof {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final String f381794a;

    /* renamed from: b, reason: collision with root package name */
    public static final String f381795b;

    /* renamed from: c, reason: collision with root package name */
    public static final AtomicReference<FutureTask<HnGHR.spXPg>> f381796c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21212);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 1)) {
            redirector.redirect((short) 1);
            return;
        }
        f381794a = LwgsO.a(LwgsO.f381889c1);
        f381795b = LwgsO.a(LwgsO.f381892d1);
        f381796c = new AtomicReference<>(null);
    }
}
