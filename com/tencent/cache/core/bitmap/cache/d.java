package com.tencent.cache.core.bitmap.cache;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class d extends Lambda implements Function0<Unit> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final d f98677a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13549);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98677a = new d();
        }
    }

    public d() {
        super(0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        return Unit.INSTANCE;
    }
}
