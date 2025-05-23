package com.tencent.avcore.camera.observe;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Observable;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends Observable {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public synchronized void a(Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) objArr);
        } else {
            super.setChanged();
            super.notifyObservers(objArr);
        }
    }
}
