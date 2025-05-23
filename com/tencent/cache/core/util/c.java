package com.tencent.cache.core.util;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class c extends Lambda implements Function1<com.tencent.cache.core.bitmap.cache.b<?, ?>, CharSequence> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final c f98834a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14755);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98834a = new c();
        }
    }

    public c() {
        super(1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.CharSequence, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public CharSequence invoke(com.tencent.cache.core.bitmap.cache.b<?, ?> bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) bVar);
        }
        com.tencent.cache.core.bitmap.cache.b<?, ?> it = bVar;
        Intrinsics.checkNotNullParameter(it, "it");
        return it.toString();
    }
}
