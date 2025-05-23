package com.tencent.cache.core.manager.store;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class b extends Lambda implements Function1<a, CharSequence> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final b f98774a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13900);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f98774a = new b();
        }
    }

    public b() {
        super(1);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.CharSequence, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public CharSequence invoke(a aVar) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        }
        a aVar2 = aVar;
        com.tencent.cache.api.b bVar = aVar2.f98772a.get();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(aVar2.f98773b);
        sb5.append("|");
        Long l3 = null;
        if (bVar != null) {
            str = bVar.getClass().getSimpleName();
        } else {
            str = null;
        }
        sb5.append(str);
        sb5.append("|");
        if (bVar != null) {
            l3 = Long.valueOf(bVar.getMemorySize());
        }
        sb5.append(l3);
        return sb5.toString();
    }
}
