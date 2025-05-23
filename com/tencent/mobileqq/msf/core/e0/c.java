package com.tencent.mobileqq.msf.core.e0;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c<Callback> {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final ArrayList<Callback> f247970a;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f247970a = new ArrayList<>();
        }
    }

    public void a(Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
        } else {
            if (callback == null) {
                return;
            }
            synchronized (this.f247970a) {
                this.f247970a.add(callback);
            }
        }
    }

    public void b(Callback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback);
        } else {
            if (callback == null) {
                return;
            }
            synchronized (this.f247970a) {
                this.f247970a.remove(callback);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object[] a() {
        Object[] array;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Object[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        synchronized (this.f247970a) {
            array = this.f247970a.size() > 0 ? this.f247970a.toArray() : null;
        }
        return array;
    }
}
