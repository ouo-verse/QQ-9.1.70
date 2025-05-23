package com.tencent.mobileqq.msf.core.net.u.c;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: f, reason: collision with root package name */
    private static final String f249434f = "Dispatcher";

    /* renamed from: a, reason: collision with root package name */
    private final Object f249435a;

    /* renamed from: b, reason: collision with root package name */
    private final Object f249436b;

    /* renamed from: c, reason: collision with root package name */
    private final ArrayDeque<d> f249437c;

    /* renamed from: d, reason: collision with root package name */
    private final ArrayDeque<d> f249438d;

    /* renamed from: e, reason: collision with root package name */
    private final List<c> f249439e;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f249435a = new Object();
        this.f249436b = new Object();
        this.f249437c = new ArrayDeque<>();
        this.f249438d = new ArrayDeque<>();
        this.f249439e = Collections.synchronizedList(new ArrayList());
    }

    public void a(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) dVar);
            return;
        }
        synchronized (this.f249435a) {
            this.f249437c.add(dVar);
        }
        a();
    }

    public void b(d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) dVar);
            return;
        }
        synchronized (this.f249435a) {
            this.f249438d.remove(dVar);
        }
    }

    private c a(com.tencent.mobileqq.msf.core.d dVar) {
        synchronized (this.f249436b) {
            for (c cVar : this.f249439e) {
                if (cVar.a(dVar)) {
                    return cVar;
                }
            }
            return null;
        }
    }

    private void a() {
        ArrayList<d> arrayList = new ArrayList();
        synchronized (this.f249435a) {
            Iterator<d> it = this.f249437c.iterator();
            while (it.hasNext()) {
                d next = it.next();
                it.remove();
                arrayList.add(next);
                this.f249438d.add(next);
            }
            arrayList.size();
        }
        for (d dVar : arrayList) {
            com.tencent.mobileqq.msf.core.d a16 = dVar.a();
            c a17 = a(a16);
            if (a17 == null) {
                a17 = new c(a16);
            }
            synchronized (this.f249436b) {
                this.f249439e.add(a17);
            }
            if (!a17.a(dVar)) {
                synchronized (this.f249435a) {
                    this.f249437c.add(dVar);
                }
            }
        }
    }
}
