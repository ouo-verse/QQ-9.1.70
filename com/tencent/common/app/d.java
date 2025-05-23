package com.tencent.common.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.IActivityDispatchCallback;

/* compiled from: P */
@Deprecated
/* loaded from: classes5.dex */
public abstract class d implements IActivityDispatchCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static d f99535a;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
