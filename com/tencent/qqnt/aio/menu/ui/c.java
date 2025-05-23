package com.tencent.qqnt.aio.menu.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes23.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    List<d> f351557a;

    /* renamed from: b, reason: collision with root package name */
    String f351558b;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f351557a = new CopyOnWriteArrayList();
        }
    }

    public void a(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
        } else if (dVar != null) {
            this.f351557a.add(dVar);
        }
    }

    public d b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (d) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        return this.f351557a.get(i3);
    }

    public c c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (c) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        c cVar = new c();
        cVar.f351558b = this.f351558b;
        cVar.f351557a.addAll(this.f351557a);
        return cVar;
    }

    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.f351557a.size();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        List<d> list = this.f351557a;
        if (list != null) {
            Iterator<d> it = list.iterator();
            while (it.hasNext()) {
                sb5.append(" " + it.next().f());
            }
        }
        return sb5.toString();
    }
}
