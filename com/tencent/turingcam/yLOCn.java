package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class yLOCn implements Serializable {
    static IPatchRedirector $redirector_;

    public yLOCn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void a(QjsR0 qjsR0);

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new StringBuilder().toString();
    }
}
