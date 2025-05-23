package com.tencent.mobileqq.troop.navigatebar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Observable;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class c extends Observable {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract com.tencent.mobileqq.troop.data.c a(String str);

    public abstract com.tencent.mobileqq.troop.data.c b(String str);

    public abstract com.tencent.mobileqq.troop.data.c c(String str, com.tencent.mobileqq.troop.data.c cVar);
}
