package com.tencent.qimei.aj;

import android.annotation.SuppressLint;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qimei.ab.b;
import com.tencent.qimei.sdk.debug.IDebugger;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a implements IDebugger {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final String f343047a;

    public a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f343047a = str;
        }
    }

    @Override // com.tencent.qimei.sdk.debug.IDebugger
    @SuppressLint({"MissingPermission"})
    public void requestQm() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    @Override // com.tencent.qimei.sdk.debug.IDebugger
    public void requestStrategy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.qimei.sdk.debug.IDebugger
    public void setDebug(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            b.f342922a = z16;
        }
    }
}
