package com.tencent.mobileqq.dexasm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Set;
import org.jf.dexlib2.iface.AnnotationElement;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    protected b f203490a;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public void a(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) str);
            return;
        }
        b bVar = this.f203490a;
        if (bVar != null) {
            bVar.a(i3, str);
        }
    }

    public void b(Set<? extends AnnotationElement> set) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) set);
            return;
        }
        b bVar = this.f203490a;
        if (bVar != null) {
            bVar.b(set);
        }
    }
}
