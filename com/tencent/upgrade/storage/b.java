package com.tencent.upgrade.storage;

import com.tencent.component.media.image.ProgressTracer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b<T extends Serializable> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private d f383888a;

    /* renamed from: b, reason: collision with root package name */
    private String f383889b;

    /* renamed from: c, reason: collision with root package name */
    private T f383890c;

    /* renamed from: d, reason: collision with root package name */
    private T f383891d;

    public b(String str, T t16, d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, t16, dVar);
            return;
        }
        this.f383889b = str;
        this.f383890c = t16;
        this.f383888a = dVar;
        try {
            this.f383891d = (T) dVar.getParam(str, t16);
        } catch (ClassCastException e16) {
            com.tencent.upgrade.util.d.c("PersistenceObject", "classType = " + t16.getClass().getName());
            e16.printStackTrace();
        }
    }

    public synchronized T a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (T) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        if (this.f383891d != null) {
            com.tencent.upgrade.util.d.a("PersistenceObject", "get " + this.f383889b + "," + this.f383891d.getClass().getSimpleName() + ProgressTracer.SEPARATOR + this.f383891d.toString());
        } else {
            com.tencent.upgrade.util.d.a("PersistenceObject", "get default value : " + this.f383890c.toString() + "," + this.f383889b);
        }
        T t16 = this.f383891d;
        if (t16 == null) {
            t16 = this.f383890c;
        }
        return t16;
    }

    public synchronized void b(T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16);
            return;
        }
        this.f383891d = t16;
        if (t16 != null) {
            com.tencent.upgrade.util.d.a("PersistenceObject", "set " + this.f383889b + "," + t16.getClass().getSimpleName() + ProgressTracer.SEPARATOR + t16.toString());
            this.f383888a.a(this.f383889b, t16);
        } else {
            com.tencent.upgrade.util.d.a("PersistenceObject", "set clear cache," + this.f383889b);
            this.f383888a.remove(this.f383889b);
        }
    }
}
