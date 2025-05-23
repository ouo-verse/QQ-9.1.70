package com.tencent.mobileqq.troop.shortcutbar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class a implements b {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract void a(String str, long j3);

    public abstract void b();

    public abstract void e(Object obj);

    public abstract void f(Object obj);

    public abstract void g();

    public void h(int i3, ArrayList<ShortcutBarInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) arrayList);
        } else {
            i(i3, arrayList, false);
        }
    }

    public abstract void i(int i3, ArrayList<ShortcutBarInfo> arrayList, boolean z16);
}
