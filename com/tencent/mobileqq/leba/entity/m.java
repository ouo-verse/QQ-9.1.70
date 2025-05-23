package com.tencent.mobileqq.leba.entity;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class m {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final List<n> f240502a;

    /* renamed from: b, reason: collision with root package name */
    public final List<n> f240503b;

    public m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f240502a = new ArrayList();
            this.f240503b = new ArrayList();
        }
    }

    public void a(n nVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) nVar, i3);
            return;
        }
        if (nVar == null) {
            return;
        }
        if (this.f240502a.size() < i3) {
            this.f240502a.add(nVar);
            nVar.e();
        } else {
            this.f240503b.add(nVar);
            nVar.a();
        }
    }

    public void b(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) nVar);
        } else {
            if (nVar == null) {
                return;
            }
            this.f240503b.add(nVar);
            nVar.a();
        }
    }
}
