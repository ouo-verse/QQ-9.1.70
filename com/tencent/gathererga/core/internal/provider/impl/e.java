package com.tencent.gathererga.core.internal.provider.impl;

import android.content.Context;
import com.tencent.gathererga.core.TuringProvider;
import com.tencent.gathererga.core.f;
import com.tencent.gathererga.core.internal.provider.InfoID;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class e implements TuringProvider {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Context f108252a;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.gathererga.core.TuringProvider
    @InfoID(id = 1)
    public f getAIDTicket(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f) iPatchRedirector.redirect((short) 3, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(-999L, "");
    }

    @Override // com.tencent.gathererga.core.TuringProvider
    @InfoID(id = 2)
    public f getTAIDTicket(com.tencent.gathererga.core.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (f) iPatchRedirector.redirect((short) 2, (Object) this, (Object) eVar);
        }
        return new com.tencent.gathererga.core.internal.provider.c(-999L, "");
    }

    @Override // com.tencent.gathererga.core.TuringProvider, com.tencent.gathererga.core.internal.c
    public void onInit(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
        } else {
            this.f108252a = context;
        }
    }
}
