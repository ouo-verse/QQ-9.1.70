package com.tencent.wcdb;

import android.os.Bundle;
import android.os.IBinder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
final class d implements i {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private IBinder f384306d;

    /* renamed from: e, reason: collision with root package name */
    private Bundle f384307e;

    public d(IBinder iBinder) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iBinder);
        } else {
            this.f384306d = iBinder;
            this.f384307e = null;
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IBinder) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f384306d;
    }
}
