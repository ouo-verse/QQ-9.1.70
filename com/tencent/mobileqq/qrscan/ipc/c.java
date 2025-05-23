package com.tencent.mobileqq.qrscan.ipc;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qrscan.e;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes17.dex */
public class c implements e {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static volatile c f276660c;

    /* renamed from: a, reason: collision with root package name */
    List<WeakReference<e>> f276661a;

    /* renamed from: b, reason: collision with root package name */
    HashSet<Object> f276662b;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f276661a = new ArrayList();
            this.f276662b = new HashSet<>(3);
        }
    }

    public static c f() {
        if (f276660c == null) {
            synchronized (c.class) {
                if (f276660c == null) {
                    f276660c = new c();
                }
            }
        }
        return f276660c;
    }

    public void a(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) eVar);
            return;
        }
        synchronized (this.f276661a) {
            if (this.f276661a.size() > 0) {
                for (int size = this.f276661a.size() - 1; size >= 0; size--) {
                    WeakReference<e> weakReference = this.f276661a.get(size);
                    if (weakReference == null || weakReference.get() == null || weakReference.get() == eVar) {
                        this.f276661a.remove(size);
                    }
                }
            }
            if (eVar != null) {
                this.f276661a.add(new WeakReference<>(eVar));
            }
        }
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        synchronized (this.f276661a) {
            this.f276661a.clear();
        }
    }

    public void c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            d.c().b(i3);
        }
    }

    @Override // com.tencent.mobileqq.qrscan.e
    public void d(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        ArrayList arrayList = new ArrayList(this.f276661a.size() + 1);
        synchronized (this.f276661a) {
            arrayList.addAll(this.f276661a);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            e eVar = (e) ((WeakReference) it.next()).get();
            if (eVar != null) {
                eVar.d(i3, z16);
            }
        }
    }

    @Override // com.tencent.mobileqq.qrscan.e
    public void e(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        ArrayList arrayList = new ArrayList(this.f276661a.size() + 1);
        synchronized (this.f276661a) {
            arrayList.addAll(this.f276661a);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            e eVar = (e) ((WeakReference) it.next()).get();
            if (eVar != null) {
                eVar.e(i3, i16);
            }
        }
    }

    public synchronized void g(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, obj);
            return;
        }
        if (obj == null) {
            return;
        }
        boolean add = this.f276662b.add(obj);
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.QRScanResHelper", 2, String.format("init deal=%b obj=%s", Boolean.valueOf(add), obj));
        }
        if (!add) {
            return;
        }
        d.c().register();
        d.c().d(this);
    }

    public void h(e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) eVar);
            return;
        }
        synchronized (this.f276661a) {
            if (this.f276661a.size() > 0) {
                for (int size = this.f276661a.size() - 1; size >= 0; size--) {
                    WeakReference<e> weakReference = this.f276661a.get(size);
                    if (weakReference == null || weakReference.get() == null || weakReference.get() == eVar) {
                        this.f276661a.remove(size);
                    }
                }
            }
        }
    }

    public synchronized void i(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, obj);
            return;
        }
        if (obj == null) {
            return;
        }
        boolean remove = this.f276662b.remove(obj);
        if (QLog.isColorLevel()) {
            QLog.i("MiniRecog.QRScanResHelper", 2, String.format("unInit deal=%b remove=%b obj=%s", Boolean.valueOf(this.f276662b.isEmpty()), Boolean.valueOf(remove), obj));
        }
        if (!remove) {
            return;
        }
        if (this.f276662b.isEmpty()) {
            d.c().d(null);
            b();
            d.c().unregister();
        }
    }
}
